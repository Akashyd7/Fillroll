package com.project.fillroll.api;


import static com.project.fillroll.api.ApiUtilities.API_KEY;
import static com.project.fillroll.constants.ConstantVariables.URL_PHOTOS_DATA_CONTROLLER_SERVER;

import com.project.fillroll.model.ImageModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LunchAPI {

    @GET(URL_PHOTOS_DATA_CONTROLLER_SERVER)
    Call<ArrayList<ImageModel>>getImages(@Query("client_id") String client_id);




}