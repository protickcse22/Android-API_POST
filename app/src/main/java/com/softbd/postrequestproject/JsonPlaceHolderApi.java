package com.softbd.postrequestproject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @FormUrlEncoded
    @POST("/dev/api/questions")
    Call<ServerData> createPost(@Field("user_id") Integer user_id, @Field("eiin") Integer eiin,
                                @Field("class_id") Integer class_id, @Field("subject_id") Integer subject_id);
}
