package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aMj;
    public long csr = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String qfg;
    public String qfh;
    public String qfi;
    public String qfj;
    public String qfk;
    public int qfl;
    public int qfm;
    public long qfn;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aMj.equals(aVar.aMj);
    }
}
