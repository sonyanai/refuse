package jp.techacademy.refuse.black.refuse;

import android.Manifest;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {



    public sendFragment fragmentSend;
    public watchFragment fragmentWatch;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        watchFragment fragmentWatch = new watchFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 他にも、メソッドにはreplace removeがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container, fragmentWatch);
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();




    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addButton:
                sendFragment fragmentSend = new sendFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                // 他にも、メソッドにはreplace removeがあります
                // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
                transaction.replace(R.id.container, fragmentSend);
                // 最後にcommitを使用することで変更を反映します
                transaction.commit();
        }
        return false;
    }
*/

}

