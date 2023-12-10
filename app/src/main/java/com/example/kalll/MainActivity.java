package com.example.kalll;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Num1, Num2, Operation;
    private TextView ResultText;
    private Button button;
    private Toast toasterror;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Num1=findViewById(R.id.editText1);
        Operation=findViewById(R.id.editText2);
        Num2=findViewById(R.id.editText3);
        ResultText=findViewById(R.id.textResult);
        button=findViewById(R.id.button1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1, num2, result = 0;
        boolean correctOperation=true;
        String operation="";

        try{
            num1=Float.parseFloat(Num1.getText().toString());
            num2=Float.parseFloat(Num2.getText().toString());
            operation=Operation.getText().toString();
            switch (operation){
                case "+": result=num1+num2; break;
                case "-": result=num1-num2; break;
                case "/": if(num2==0) throw new ArithmeticException(); result=num1/num2; break;
                case "*": result=num1*num2; break;
                default: correctOperation = false; break;
            }
            if (correctOperation==true){

                ResultText.setText("Результат: "+num1+" "+operation+" "+num2+" = "+result);
            }
            else {
                int duration = Toast.LENGTH_SHORT;
                if(toasterror!=null){
                    toasterror.cancel();
                }
                toasterror=Toast.makeText(this, R.string.wrong_operation,duration);
                toasterror.show();
                return;
            }

        }
        catch (ArithmeticException e){
            int duration = Toast.LENGTH_SHORT;
            if(toasterror!=null){
                toasterror.cancel();
            }
            toasterror=Toast.makeText(this, R.string.divide_zero,duration);
            toasterror.show();
            return;
        }
        catch (NullPointerException e){
            int duration = Toast.LENGTH_SHORT;
            if(toasterror!=null){
                toasterror.cancel();
            }
            toasterror=Toast.makeText(this, R.string.null_data,duration);
            toasterror.show();
            return;
        }
        catch (NumberFormatException e){
            int duration = Toast.LENGTH_SHORT;
            if(toasterror!=null){
                toasterror.cancel();
            }
            toasterror=Toast.makeText(this, R.string.wrong_format,duration);
            toasterror.show();
            return;
        }

    }
}