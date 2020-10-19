package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aLF;
    public long cjQ = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String pnS;
    public String pnT;
    public String pnU;
    public String pnV;
    public String pnW;
    public int pnX;
    public int pnY;
    public long pnZ;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aLF.equals(aVar.aLF);
    }
}
