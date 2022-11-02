package com.project.fillroll.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    public static final String BASE_URL ="https://api.unsplash.com";
    public static final String API_KEY ="zLGb7ZPqbDd9GA8VJc11sUULxKsa4UCdvM3PeHXrw1M";
    public static final String URL_PHOTOS_DATA_CONTROLLER_SERVER =BASE_URL +"photos";

    private static Retrofit retrofit = null;

    static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build();



    public static LunchAPI getLaunchAPI(){

                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)

                            .addConverterFactory(GsonConverterFactory.create())
//                            .addConverterFactory(ScalarsConverterFactory.create())
                            .build();
                }
                return retrofit.create(LunchAPI.class);
            }
        }




