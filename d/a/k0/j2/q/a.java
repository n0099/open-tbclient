package d.a.k0.j2.q;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.a.j0.r.q.a2;
import d.a.k0.j2.o;
/* loaded from: classes5.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.g {
    boolean C();

    boolean D();

    View E();

    void U(int i2);

    boolean c0();

    int getCurrentPosition();

    boolean isPlaying();

    void k0(o oVar);

    void l0();

    boolean o0(boolean z);

    void r0(View.OnClickListener onClickListener);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(a2 a2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();
}
