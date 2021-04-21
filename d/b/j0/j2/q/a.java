package d.b.j0.j2.q;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import d.b.i0.r.q.a2;
import d.b.j0.j2.o;
/* loaded from: classes3.dex */
public interface a extends View.OnClickListener, CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, TbCyberVideoView.g {
    View C();

    boolean D();

    boolean H();

    boolean N();

    void Z(o oVar);

    void a0();

    boolean e0(boolean z);

    int getCurrentPosition();

    boolean isPlaying();

    void k0(View.OnClickListener onClickListener);

    void setAfterClickListener(View.OnClickListener onClickListener);

    void setData(a2 a2Var);

    void setFrom(String str);

    void setStageType(String str);

    void setUniqueId(BdUniqueId bdUniqueId);

    void startPlay();

    void stopPlay();

    void t(int i);
}
