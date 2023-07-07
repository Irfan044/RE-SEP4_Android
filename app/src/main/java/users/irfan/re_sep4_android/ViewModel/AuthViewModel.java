package users.irfan.re_sep4_android.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import users.irfan.re_sep4_android.Repository.AuthenticationRepository;

public class AuthViewModel extends AndroidViewModel {

    private AuthenticationRepository repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedInStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedInStatus() {
        return loggedInStatus;
    }

    public AuthViewModel(@NonNull Application application){
        super(application);
        repository = new AuthenticationRepository(application);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedInStatus = repository.getUserLoggedInMutableLiveData();
    }

    public void register(String email, String password){
        repository.register(email, password);
    }
    public void signIn(String email, String password){
        repository.login(email, password);
    }
    public void signOut(){
        repository.signOut();
    }
}
