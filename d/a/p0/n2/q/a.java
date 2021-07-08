package d.a.p0.n2.q;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.o0.r.q.b2;
import d.a.p0.n2.o;
/* loaded from: classes8.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.h {
    boolean C();

    boolean D();

    View E();

    void V(int i2);

    boolean e0();

    int getCurrentPosition();

    boolean isPlaying();

    void n0(o oVar);

    void o0();

    boolean r0(boolean z);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(b2 b2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();

    void u0(View.OnClickListener onClickListener);
}
