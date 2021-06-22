package d.a.o0.k2.q;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import d.a.c.e.p.j;
import d.a.n0.r.q.a2;
import d.a.o0.r0.l;
/* loaded from: classes5.dex */
public class c extends d {
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public a2 N0;

    public c(Context context, View view) {
        super(context, view);
        p0(false);
        setStageType(null);
    }

    public final void B0(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.N0);
        pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.R));
        pbActivityConfig.setNeedPreLoad(true);
        l.c(this.N0);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        View.OnClickListener onClickListener = this.y0;
        if (onClickListener != null) {
            onClickListener.onClick(E());
        }
    }

    public void C0() {
        s0(this.f60740i);
    }

    @Override // d.a.o0.k2.q.d, d.a.o0.k2.q.a
    public boolean D() {
        return false;
    }

    @Override // d.a.o0.k2.q.d
    public void N() {
        if (this.q == this.f60739h) {
            C0();
        }
    }

    @Override // d.a.o0.k2.q.d
    public void O() {
        this.f60740i = 32;
    }

    @Override // d.a.o0.k2.q.d
    public void P() {
    }

    @Override // d.a.o0.k2.q.d
    public void d0() {
        super.d0();
        this.R.setOnTouchListener(null);
        this.R.setOnClickListener(this);
    }

    @Override // d.a.o0.k2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            V();
        } else if (!j.z()) {
            d.a.c.e.p.l.L(this.P, R.string.no_network_guide);
        } else if (this.U) {
            VideoItemData videoItemData = this.L0;
            if (videoItemData != null) {
                B0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
            if (videoSerializeVideoThreadInfo != null) {
                B0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // d.a.o0.k2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    @Override // d.a.o0.k2.q.d, d.a.o0.k2.q.a
    public void setData(a2 a2Var) {
        super.setData(a2Var);
        this.N0 = a2Var;
        if (this.U) {
            VideoItemData videoItemData = new VideoItemData();
            this.L0 = videoItemData;
            videoItemData.buildWithThreadData(a2Var);
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        this.M0 = videoSerializeVideoThreadInfo;
        videoSerializeVideoThreadInfo.copyFromThreadInfo(a2Var);
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.M0;
        videoSerializeVideoThreadInfo2.source = a2Var.T0;
        videoSerializeVideoThreadInfo2.extra = a2Var.W0;
        videoSerializeVideoThreadInfo2.ab_tag = a2Var.V0;
        videoSerializeVideoThreadInfo2.weight = a2Var.U0;
    }
}
