package networkhit;

import com.mobicule.client.taskdemo.Model.Users;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface
{
    @GET("/users")
    Call<Users> doGetUserList();
}
