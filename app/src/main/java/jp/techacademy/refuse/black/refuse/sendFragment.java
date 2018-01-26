package jp.techacademy.refuse.black.refuse;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taiso on 2018/01/21.
 */

public class sendFragment extends Fragment {

    private String mContent;
    private String mCompanyName;
    private String mBlackName;
    private String mSymptom;
    private String mUid;
    private String mDate;
    private EditText companyNameEditText;
    private EditText blackNameEditText;
    private EditText contentEditText;
    private EditText caseEditText;
    private Button sendButton;
    private ImageView imageView;
    private FirebaseUser user;
    private String companyName;
    private String blackName;
    private String content;
    private String cases;

    DatabaseReference databaseReference;
    DatabaseReference contentsPathRef;
    String key;
    public watchFragment fragmentWatch;
    private ArrayList<articleData> mArticleDataArrayList = new ArrayList<articleData>();
    //date
    final Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_send,container,false);

        companyNameEditText = (EditText)v.findViewById(R.id.companyNameEditText);
        blackNameEditText = (EditText)v.findViewById(R.id.blackNameEditText);
        contentEditText = (EditText)v.findViewById(R.id.contentEditText);
        caseEditText = (EditText)v.findViewById(R.id.caseEditText);
        imageView = (ImageView)v.findViewById(R.id.imageView);
        sendButton = (Button)v.findViewById(R.id.sendButton);


        return v;
    }

    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //imageViewのセット
        //imageView.setImageResource((R.drawable.aaa));

        databaseReference = FirebaseDatabase.getInstance().getReference();
        contentsPathRef = databaseReference.child(Const.ContentsPATH);
        user = FirebaseAuth.getInstance().getCurrentUser();
/*
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){




                //realtimeDatabaseに送るよー
                Map<String, String> data = new HashMap<String, String>();

                String mUid = user.getUid();

                //日時
                String dateString = year + "/" + String.format("%02d", (month + 1)) + "/" + String.format("%02d", day);
                String timeString = String.format("%02d", hour) + ":" + String.format("%02d", minute);
                String date = dateString + timeString;

                companyName = companyNameEditText.getText().toString();
                blackName = blackNameEditText.getText().toString();
                cases = caseEditText.getText().toString();

                //Firebaseにデータ作成、データのkey取得
                key = contentsPathRef.push().getKey();

                data.put("mUid", mUid);
                data.put("date", date);
                data.put("companyName", companyName);
                data.put("blackName", blackName);
                data.put("content",content);
                data.put("case", cases);

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put(key, data);

                contentsPathRef.updateChildren(childUpdates);

                removeFragment();

                //送信完了のダイアログ表示

            }
        });
        */
        view.findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                removeFragment();
                watchFragment fragmentWatch = new watchFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.container,fragmentWatch,watchFragment.TAG)
                        .commit();
            }
        });
    }
    public  void removeFragment(){
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}
