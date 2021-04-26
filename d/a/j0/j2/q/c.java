package d.a.j0.j2.q;

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
import d.a.i0.r.q.a2;
import d.a.j0.q0.l;
/* loaded from: classes4.dex */
public class c extends d {
    public VideoItemData K0;
    public VideoSerializeVideoThreadInfo L0;
    public a2 M0;

    public c(Context context, View view) {
        super(context, view);
        p0(false);
        setStageType(null);
    }

    public final void A0(String str, String str2) {
        PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
        pbActivityConfig.createNormalCfg(str2, null, null);
        pbActivityConfig.setForumId(String.valueOf(str));
        pbActivityConfig.setThreadData(this.M0);
        pbActivityConfig.setVideoOriginArea(ThreadCardUtils.computeViewArea(this.R));
        pbActivityConfig.setNeedPreLoad(true);
        l.c(this.M0);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        View.OnClickListener onClickListener = this.s0;
        if (onClickListener != null) {
            onClickListener.onClick(E());
        }
    }

    public void B0() {
        r0(this.f56039i);
    }

    @Override // d.a.j0.j2.q.d, d.a.j0.j2.q.a
    public boolean D() {
        return false;
    }

    @Override // d.a.j0.j2.q.d
    public void N() {
        if (this.q == this.f56038h) {
            B0();
        }
    }

    @Override // d.a.j0.j2.q.d
    public void O() {
        this.f56039i = 32;
    }

    @Override // d.a.j0.j2.q.d
    public void P() {
    }

    @Override // d.a.j0.j2.q.d
    public void d0() {
        super.d0();
        this.R.setOnTouchListener(null);
        this.R.setOnClickListener(this);
    }

    @Override // d.a.j0.j2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            W();
        } else if (!j.z()) {
            d.a.c.e.p.l.L(this.P, R.string.no_network_guide);
        } else if (this.U) {
            VideoItemData videoItemData = this.K0;
            if (videoItemData != null) {
                A0(videoItemData.forum_id, videoItemData.thread_id);
            }
        } else {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.L0;
            if (videoSerializeVideoThreadInfo != null) {
                A0(videoSerializeVideoThreadInfo.forumId, videoSerializeVideoThreadInfo.threadId);
            }
        }
    }

    @Override // d.a.j0.j2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    @Override // d.a.j0.j2.q.d, d.a.j0.j2.q.a
    public void setData(a2 a2Var) {
        super.setData(a2Var);
        this.M0 = a2Var;
        if (this.U) {
            VideoItemData videoItemData = new VideoItemData();
            this.K0 = videoItemData;
            videoItemData.buildWithThreadData(a2Var);
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        this.L0 = videoSerializeVideoThreadInfo;
        videoSerializeVideoThreadInfo.copyFromThreadInfo(a2Var);
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo2 = this.L0;
        videoSerializeVideoThreadInfo2.source = a2Var.R0;
        videoSerializeVideoThreadInfo2.extra = a2Var.U0;
        videoSerializeVideoThreadInfo2.ab_tag = a2Var.T0;
        videoSerializeVideoThreadInfo2.weight = a2Var.S0;
    }
}
