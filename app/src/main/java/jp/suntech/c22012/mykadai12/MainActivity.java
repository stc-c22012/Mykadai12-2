package jp.suntech.c22012.mykadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btSend = findViewById(R.id.btSend);
        Button btConfirm = findViewById(R.id.btConfirm);
        //リスナ・オブジェクトの用意
        kadai12 listener = new kadai12();
        //ボタンにリスナを設定
        btSend.setOnClickListener(listener);
        btConfirm.setOnClickListener(listener);

        //クリアボタンであるButtonオブジェクトを取得。
        Button btClear = findViewById(R.id.btClear);

        //お名前クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
    }



    //ボタンをクリックした時のリスナクラス
    private class kadai12 implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //入力欄であるEditTextオブジェクトを取得。
            EditText input = findViewById(R.id.etName);
            //入力欄であるEditTextオブジェクトを取得。
            EditText input2 = findViewById(R.id.etMailTitle);
            //入力欄であるEditTextオブジェクトを取得。
            EditText input3 = findViewById(R.id.etMail);
            //入力欄であるEditTextオブジェクトを取得。
            EditText input4 = findViewById(R.id.etText);

            //タップされた画面部品をidのR値を取得。
            int id = view.getId();
            //idのR値に応じて処理を分岐

            ConfirmDialog dialog = new ConfirmDialog();

            if(id==R.id.btSend){
                String inputStr = input.getText().toString();
                String input2Str = input2.getText().toString();
                String input3Str = input3.getText().toString();
                String input4Str = input4.getText().toString();
                String inputText = "名前：" + inputStr + "  メールタイトル：" + input2Str +
                        "\nメールアドレス；" + input3Str + "  質問内容：" + input4Str;
                Snackbar.make(view,inputText, Snackbar.LENGTH_LONG).show();
            }
            if(id==R.id.btConfirm){
                dialog.show(getSupportFragmentManager(),"CofirmDialog");

                String inputStr = input.getText().toString();
                String input2Str = input2.getText().toString();
                String input3Str = input3.getText().toString();
                String input4Str = input4.getText().toString();
                String inputText = "名前：" + inputStr + "  メールタイトル：" + input2Str +
                        "\nメールアドレス；" + input3Str + "  質問内容：" + input4Str;
                Snackbar.make(view,inputText, Snackbar.LENGTH_LONG).show();
            }
            if(id == R.id.btClear){
                input.setText("");
                input2.setText("");
                input3.setText("");
                input4.setText("");
            }
        }
    }


    //
}