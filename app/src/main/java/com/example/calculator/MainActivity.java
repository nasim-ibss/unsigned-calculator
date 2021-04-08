package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText num1, num2;
    private Button add, sub, mul, dev, rem, power;
    private int n1, n2;
    private float m1, m2;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();


        add.setOnClickListener(v -> {
            if (isSetIntValue())
                result.setText(String.valueOf(Add(n1,n2)));
        });

        sub.setOnClickListener(v -> {
            if (isSetIntValue())
                if (n1 > n2){
                    result.setText(String.valueOf(Sub(n1,n2)));
                }else{
                    result.setText(String.valueOf(Sub(n2,n1)));
                }
        });

        mul.setOnClickListener(v -> {
            if (isSetIntValue())
                result.setText(String.valueOf(Mul(n1,n2)));
        });

        dev.setOnClickListener(v -> {
            if (isSetFloatValue())
                result.setText(String.valueOf(Dev(m1,m2)));
        });

        rem.setOnClickListener(v -> {
            if (isSetIntValue())
                result.setText(String.valueOf(Rem(n1,n2)));
        });

        power.setOnClickListener(v -> {
            if (isSetIntValue())
                if(Pow(n1, n2) < 0){
                    Toast.makeText(getApplicationContext(),"Overflow!", Toast.LENGTH_LONG).show();
                    result.setText("0");
                    num2.requestFocus();
                }else {
                    result.setText(String.valueOf(Pow(n1, n2)));
                }
        });

    }

    public void initUI(){
        result = findViewById(R.id.result);
        num1 = findViewById(R.id.first_number);
        num2 = findViewById(R.id.second_number);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        dev = findViewById(R.id.dev);
        rem = findViewById(R.id.rem);
        power = findViewById(R.id.pow);
    }

    public boolean isSetIntValue(){
        if (num1.getText().toString().equals("")){
            Toast.makeText(this,"Please enter a valid number.", Toast.LENGTH_LONG).show();
            num1.requestFocus();
            return false;
        }else if(num2.getText().toString().equals("")){
            Toast.makeText(this,"Please enter a valid number.", Toast.LENGTH_LONG).show();
            num2.requestFocus();
            return false;
        }else{
            n1 = Integer.parseInt(num1.getText().toString());
            n2 = Integer.parseInt(num2.getText().toString());
            return true;
        }
    }

    public boolean isSetFloatValue(){
        if(num1.getText().toString().equals("")){
            Toast.makeText(this,"Please enter a valid number.", Toast.LENGTH_LONG).show();
            num1.requestFocus();
            return false;
        }else if(num2.getText().toString().equals("")){
            Toast.makeText(this,"Please enter a valid number.", Toast.LENGTH_LONG).show();
            num2.requestFocus();
            return false;
        }else{
            m1 = Float.parseFloat(num1.getText().toString());
            m2 = Float.parseFloat(num2.getText().toString());
            return true;
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native int Add(int x, int y);
    public native int Sub(int x, int y);
    public native int Mul(int x, int y);
    public native float Dev(float x, float y);
    public native int Rem(int x, int y);
    public native int Pow(int x, int y);
}