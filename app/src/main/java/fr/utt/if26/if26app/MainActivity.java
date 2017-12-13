package fr.utt.if26.if26app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;

    private static Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //username = (EditText)findViewById(R.id.usernameTextField);
        //password = (EditText)findViewById(R.id.passwordTextField);

        buttonGo = (Button)findViewById(R.id.goButton);

        OnClickButtonListener();

        //buttonGo.setOnClickListener(new View.OnClickListener(){
        //            public void onClick(View v){
        //                Validate(username.getText().toString(), password.getText().toString());
        //            }
               // }
        //);

    }

    //public void Validate(String user, String pass){
    //    if((user.equals("admin")) && (pass.equals("12345"))){
      //      Intent intent = new Intent("fr.utt.if26.if26app.Main2Activity");
     //       startActivity(intent);
     //       username.setText("");
      //      password.setText("");
      //  }
      //  else{
       //     Toast.makeText(MainActivity.this, "Nom d'utilisateur ou mot de passe incorrect", Toast.LENGTH_LONG).show();
       //     username.setText("");
       //     password.setText("");
      //  }
   // }

    public void OnClickButtonListener(){
        buttonGo.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent("fr.utt.if26.if26app.Main2Activity");
                        startActivity(intent);
                    }
                }
        );
    }

}
