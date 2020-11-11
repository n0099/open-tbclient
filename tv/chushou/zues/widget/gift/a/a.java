package tv.chushou.zues.widget.gift.a;

import com.baidu.android.imsdk.internal.IMConnection;
/* loaded from: classes6.dex */
public class a {
    public String aNj;
    public long cyo = IMConnection.RETRY_DELAY_TIMES;
    public String mNickName;
    public boolean mShowAvatar;
    public String mUserId;
    public String qoB;
    public String qoC;
    public String qoD;
    public String qoE;
    public String qoF;
    public int qoG;
    public int qoH;
    public long qoI;

    public boolean equals(Object obj) {
        a aVar = (a) obj;
        return this.mUserId.equals(aVar.mUserId) && this.aNj.equals(aVar.aNj);
    }
}
