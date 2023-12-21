package com.example.ghi_chu;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import model.StudentModel;
import model.StudentResponse;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import remote.APIService;
import remote.RetroClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    TextView txbAcc, txbPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txbAcc= findViewById(R.id.txb_Account);
        txbPass = findViewById(R.id.txb_Password);
        btnLogin = findViewById(R.id.btn_Login);

        RetroClass.getAPIService(new RetroClass.OnBaseUrlFetchedListener() {
            @Override
            public void onBaseUrlFetched(String baseUrl) {
                // Xử lý baseUrl, ví dụ: hiển thị qua Toast
                showToast("BASE_URL: " + baseUrl, Toast.LENGTH_LONG);
            }
        });

           btnLogin.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String username = txbAcc.getText().toString();
                 String password = txbPass.getText().toString();
                 // Gọi phương thức để kiểm tra đăng nhập và kiểm tra cơ sở dữ liệu MySQL
                 callData(username,password);
             }
         });

//        String username = "Nhien1";
//        String password = "2";  // Cung cấp password nếu server yêu cầu





//***TEST***
//        APIService apiService = RetroClass.getAPIService();
//        Call<StudentModel> call = apiService.getStudentList();
//        call.enqueue(new Callback<StudentModel>(){
//            @Override
//            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
//                // Xử lý phản hồi từ server
//                showToast("Kết nối thành công!", Toast.LENGTH_LONG);
//            }
//            @Override
//            public void onFailure(Call<StudentModel> call, Throwable t) {
//                // Xử lý khi có lỗi
//                showToast("Kết nối thất bại!", Toast.LENGTH_LONG);
//            }
//        });
    }


        private void showToast(String message, int duration){

//            Context context = null;
            Toast.makeText(MainActivity.this, message, duration).show();
        }



//    public void callData(String username, String password) {
//        APIService apiService = RetroClass.getAPIService();
//
//        Call<StudentModel> studentModelCall = apiService.checkLogin(username, password);
//
//        studentModelCall.enqueue(new Callback<StudentModel>() {
//            @Override
//            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Log.d("response", "" + response.body().getStatus());
//                    showToast("Kết nối thành công!", Toast.LENGTH_LONG);
//                } else {
//                    showToast("Dữ liệu không hợp lệ!", Toast.LENGTH_LONG);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<StudentModel> call, Throwable t) {
//                showToast("Kết nối thất bại!", Toast.LENGTH_LONG);
//            }
//        });
//    }

//    public void callData(String username, String password) {
//            APIService apiService = RetroClass.getAPIService();
//            Call<StudentModel> call = apiService.checkLogin(username, password);
//            call.enqueue(new Callback<StudentModel>() {
//                @Override
//                public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
//                    if (response.isSuccessful()) {
//                        // Phản hồi thành công từ server
//                        showToast("Status Code: " + response.code(), Toast.LENGTH_LONG);
//                        showToast("Kết nối thành công!", Toast.LENGTH_LONG);
//                    } else {
//                        // Phản hồi thất bại từ server
//                        showToast("Kết nối thất bại! Mã lỗi: " + response.code(), Toast.LENGTH_LONG);
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<StudentModel> call, Throwable t) {
//                    // Xử lý khi có lỗi
//                    showToast("Kết nối thất bại!", Toast.LENGTH_LONG);
//                }
//            });
//    }

    public void callData(String username, String password) {
        APIService apiService = RetroClass.getAPIService();
        // Tạo một RequestBody chứa dữ liệu cần gửi đi
        RequestBody requestBody = new FormBody.Builder()
                .add("name", username)
                .add("password", password)
                .build();

        Call<StudentModel> call = apiService.checkLogin(requestBody);
        call.enqueue(new Callback<StudentModel>() {
            @Override
            public void onResponse(Call<StudentModel> call, Response<StudentModel> response) {
                if (response.isSuccessful()) {
                    // Phản hồi thành công từ server
                    showToast("Status Code: " + response.code(), Toast.LENGTH_LONG);
                    showToast("Kết nối thành công!", Toast.LENGTH_LONG);
                } else {
                    // Phản hồi thất bại từ server
                    showToast("Kết nối thất bại! Mã lỗi: " + response.code(), Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<StudentModel> call, Throwable t) {
                // Xử lý khi có lỗi
                showToast("Kết nối thất bại!", Toast.LENGTH_LONG);
            }
        });
    }




}