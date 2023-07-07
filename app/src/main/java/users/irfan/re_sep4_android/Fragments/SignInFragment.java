package users.irfan.re_sep4_android.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

import users.irfan.re_sep4_android.R;
import users.irfan.re_sep4_android.ViewModel.AuthViewModel;

public class SignInFragment extends Fragment {

    private EditText emailEdit, passwordEdit;
    private TextView signUpText;
    private Button signInBtn;
    private AuthViewModel viewModel;
    private NavController navController;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory
                .getInstance(getActivity().getApplication())).get(AuthViewModel.class);
        viewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser != null){
                    navController.navigate(R.id.action_signInFragment_to_signOutFragment);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailEdit = view.findViewById(R.id.emailEditSignIn);
        passwordEdit = view.findViewById(R.id.passwordEditSignIn);
        signUpText = view.findViewById(R.id.signUpText);
        signInBtn = view.findViewById(R.id.signInBtn);

        navController = Navigation.findNavController(view);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                navController.navigate(R.id.action_signInFragment_to_signUpFragment);
            }
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if(!email.isEmpty() && !password.isEmpty()){
                    viewModel.signIn(email, password);
                }
            }
        });
    }
}