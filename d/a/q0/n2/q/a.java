package d.a.q0.n2.q;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.p0.s.q.b2;
import d.a.q0.n2.o;
/* loaded from: classes8.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.h {
    boolean C();

    boolean D();

    View E();

    void W(int i2);

    int getCurrentPosition();

    boolean h0();

    boolean isPlaying();

    void q0(o oVar);

    void s0();

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(b2 b2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();

    boolean v0(boolean z);

    void y0(View.OnClickListener onClickListener);
}
