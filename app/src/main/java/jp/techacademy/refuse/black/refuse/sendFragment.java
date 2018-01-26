package jp.techacademy.refuse.black.refuse;



import android.content.Intent;
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
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taiso on 2018/01/21.
 */

public class sendFragment extends Fragment {
/*
    private String mContent;
    private String mCompanyName;
    private String mBlackName;
    private String mSymptom;
    private String mUid;
    private String mDate;

    */
    private EditText companyNameEditText;
    private EditText blackNameEditText;
    private EditText contentEditText;
    private EditText caseEditText;
    private EditText dateEditText;
    private Button sendButton;
    private ImageView imageView;
    private FirebaseUser user;
    private String companyName;
    private String blackName;
    private String date;
    private String content;
    private String cases;

    DatabaseReference databaseReference;
    DatabaseReference contentsPathRef;
    String key;
    public watchFragment fragmentWatch;
    private ArrayList<articleData> mArticleDataArrayList = new ArrayList<articleData>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_send,container,false);

        companyNameEditText = (EditText)v.findViewById(R.id.companyNameEditText);
        blackNameEditText = (EditText)v.findViewById(R.id.blackNameEditText);
        dateEditText = (EditText)v.findViewById(R.id.dateEditText);
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
        if (user==null){
            MainActivity activity = (MainActivity) getActivity();
            activity.intentLogin();
        }




        view.findViewById(R.id.sendButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                //realtimeDatabaseに送るよー
                Map<String, String> data = new HashMap<String, String>();

                String mUid = user.getUid();


                companyName = companyNameEditText.getText().toString();
                blackName = blackNameEditText.getText().toString();
                date = dateEditText.getText().toString();
                cases = caseEditText.getText().toString();
                content = contentEditText.getText().toString();

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


                //送信完了のダイアログ表示






                watchFragment fragmentWatch = new watchFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.container,fragmentWatch,watchFragment.TAG)
                        .commit();
            }
        });
    }

}
