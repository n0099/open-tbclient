package d.a.o0.k2.q;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.n0.r.q.a2;
import d.a.o0.k2.o;
/* loaded from: classes5.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.g {
    boolean C();

    boolean D();

    View E();

    void W(int i2);

    boolean f0();

    int getCurrentPosition();

    boolean isPlaying();

    void n0(o oVar);

    void o0();

    boolean r0(boolean z);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(a2 a2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();

    void u0(View.OnClickListener onClickListener);
}
