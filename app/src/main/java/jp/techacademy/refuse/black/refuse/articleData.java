package jp.techacademy.refuse.black.refuse;

/**
 * Created by taiso on 2018/01/20.
 */

public class articleData {
    private String mContent;
    private String mCompanyName;
    private String mBlackName;
    private String mCase;
    private String mUid;
    private String mDate;


    public String getCompanyName(){
        return mCompanyName;
    }
    public String getBlackName(){
        return mBlackName;
    }
    public String getContent(){
        return mContent;
    }
    public String getCase(){
        return mCase;
    }
    public String getUid(){
        return mUid;
    }
    public String getDate(){
        return mDate;
    }

    public articleData(String uid,String date,String companyName, String blackName,String content,  String cases ) {
        mUid = uid;
        mDate = date;
        mCompanyName = companyName;
        mBlackName = blackName;
        mContent = content;
        mCase = cases;
    }
}
