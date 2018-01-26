package jp.techacademy.refuse.black.refuse;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by taiso on 2018/01/21.
 */

public class watchFragment extends Fragment {

    public static final String TAG = "watchFragment";

    private Button searchButton;
    private EditText searchEditText;
    //内容とか入っているリスト
    public ArrayList<articleData> mArticleDataArrayList;
    private ArticleDataArrayListAdapter mAdapter;
    private ListView mListView;
    FirebaseUser user;
    DatabaseReference databaseReference;
    DatabaseReference contentsPathRef;
    //検索ワード
    String cord;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_watch,container,false);

        searchButton = (Button)v.findViewById(R.id.searchButton);
        searchEditText = (EditText)v.findViewById(R.id.searchEditText);
        mArticleDataArrayList = new ArrayList<articleData>();
        mAdapter = new ArticleDataArrayListAdapter(this.getActivity(), R.layout.new_list);
        mListView = (ListView)v.findViewById(R.id.articleDataListView);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        user = FirebaseAuth.getInstance().getCurrentUser();
        contentsPathRef = databaseReference.child(Const.ContentsPATH);

        return v;
    }

    public void onViewCreated(View view,Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter.setArticleDataArrayList(mArticleDataArrayList);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        //imageViewのセット
        //imageView.setImageResource((R.drawable.aaa));



        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //検索ワードの取得
                cord=searchEditText.getText().toString();
                if (cord.length() > 0) {
                    //文字が入力されているときの処理
                    /*if(検索ワード){
                    * あるときの処理
                    * }else{
                    * ないときの処理}*/
                }
            }
        });

    }

}