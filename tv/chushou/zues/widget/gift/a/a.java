package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aHk;
    public long bVA = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String oOW;
    public String oOX;
    public String oOY;
    public String oOZ;
    public String oPa;
    public int oPb;
    public int oPc;
    public long oPd;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aHk.equals(aVar.aHk);
    }
}
