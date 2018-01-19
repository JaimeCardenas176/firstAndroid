package com.example.jaime.asynctask_example1;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ProgressDialog pd;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView =findViewById(R.id.imageView);
        new MyImageDownloadAsyncTask().execute();
    }

    private class MyImageDownloadAsyncTask extends AsyncTask<Void, Void, Bitmap> {

        //http://www.salesianos-triana.com/fp/wp-content/uploads/2018/01/elementos-inicial.jpg
        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            pd =  new ProgressDialog(MainActivity.this);
            // set progrees dialog style spinner
            pd.setProgress(ProgressDialog.STYLE_SPINNER);

            //Set the progress dialog titlle and message
            pd.setTitle("Tittle og progress dialog");
            pd.setMessage("Loading....");
            pd.setIndeterminate(true);

            pd.show();

        }

        @Override
        protected Bitmap doInBackground(Void... voids) {
            URL urlImage = null;
            Bitmap imagen = null;
            try {
                urlImage = new URL("http://www.salesianos-triana.com/fp/wp-content/uploads/2018/01/elementos-inicial.jpg");
                imagen = BitmapFactory.decodeStream(urlImage.openStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return imagen;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //super.onPostExecute(bitmap);
            pd.dismiss();
            imageView.setImageBitmap(bitmap);
        }
    }
}
