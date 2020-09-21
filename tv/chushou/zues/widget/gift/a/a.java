package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aIB;
    public long bXB = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String oYA;
    public String oYB;
    public String oYC;
    public int oYD;
    public int oYE;
    public long oYF;
    public String oYy;
    public String oYz;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aIB.equals(aVar.aIB);
    }
}
