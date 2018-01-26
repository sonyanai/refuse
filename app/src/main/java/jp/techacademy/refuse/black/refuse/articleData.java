package jp.techacademy.refuse.black.refuse;

/**
 * Created by taiso on 2018/01/20.
 */

public class articleData {
    private String mContent;
    private  String mCompanyName;
    private  String mBlackName;
    private String mSymptom;
    private String mUid;
    private String mDate;


    public String getCompanyName(){
        return mCompanyName;
    }
    public  String getBlackName(){
        return mBlackName;
    }
    public String getContent(){
        return mContent;
    }
    public String getSymptom(){
        return mSymptom;
    }
    public String getUid(){
        return mUid;
    }
    public String getDate(){
        return mDate;
    }

    public articleData(String companyName, String blackName,String content,  String symptom, String uid, String date ) {
        mCompanyName = companyName;
        mBlackName = blackName;
        mContent = content;
        mSymptom = symptom;
        mUid = uid;
        mDate = date;
    }
}
