package tv.chushou.apollo.a;

import java.util.ArrayList;
import tv.chushou.zues.toolkit.richtext.RichText;
/* loaded from: classes6.dex */
public class a {
    public String mType;
    public Object tag;
    public String mContent = "";
    public String mUserID = "";
    public String mUserNickname = "";
    public c oUP = new c();
    public ArrayList<RichText> mContentRichText = new ArrayList<>();

    public a() {
        this.mType = "1";
        this.mType = "";
    }

    public String toString() {
        return "DanmaInfo{mContent='" + this.mContent + "', mType='" + this.mType + "', mUserID='" + this.mUserID + "', mUserNickname='" + this.mUserNickname + "', mGift=" + this.oUP + ", mContentRichText=" + this.mContentRichText + '}';
    }
}
