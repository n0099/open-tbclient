package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aLy;
    public long cwE = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String qqe;
    public String qqf;
    public String qqg;
    public String qqh;
    public String qqi;
    public int qqj;
    public int qqk;
    public long qql;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aLy.equals(aVar.aLy);
    }
}
