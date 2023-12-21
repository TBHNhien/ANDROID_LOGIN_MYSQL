package remote;

import com.google.gson.JsonObject;

import model.StudentAdd;
import model.StudentModel;
import okhttp3.RequestBody;
import retrofit2.http.Body;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    @GET("app/studentlist")
     Call<StudentModel> getStudentList();

    @POST("app/addStudent")
    Call<StudentAdd> addStudent(@Body JsonObject jsonObject);

    // Thêm hàm checkLogin
//    @FormUrlEncoded
//    @POST("app/checkLogin")
//    Call<StudentModel> checkLogin(
//            @Field("name") String username,
//            @Field("password") String password
//    );

    @GET("app/checkLogin")
    Call<StudentModel> checkLogin(
                    @Query("name") String username,
                    @Query("password") String password
            );

    @POST("app/checkLogin")
    Call<StudentModel> checkLogin(
            @Body RequestBody requestBody
    );





}
