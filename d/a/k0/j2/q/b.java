package d.a.k0.j2.q;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.tencent.connect.common.Constants;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.j0.r.q.a2;
import d.a.k0.x.m;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends d {
    public VideoItemData L0;
    public VideoSerializeVideoThreadInfo M0;
    public a2 N0;

    public b(Context context, View view) {
        super(context, view);
        this.f56742e = 5000;
    }

    public final void A0() {
        View.OnClickListener onClickListener = this.u0;
        if (onClickListener != null) {
            onClickListener.onClick(E());
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
        if (videoSerializeVideoThreadInfo != null) {
            String str = videoSerializeVideoThreadInfo.threadId;
            String str2 = videoSerializeVideoThreadInfo.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.N0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public final void B0() {
        if (this.N0 == null) {
            return;
        }
        if (this.L0 == null) {
            this.L0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.L0.buildWithThreadData(this.N0);
        arrayList.add(this.L0);
        Context context = this.P;
        String str = this.d0;
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", str, str);
        videoPlayActivityConfig.setParamIsVertail(this.U);
        a2 a2Var = this.N0;
        if (a2Var != null && a2Var.V() != null) {
            videoPlayActivityConfig.setNid(this.N0.V().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }

    public final void C0() {
        if (this.N0 != null) {
            if (this.M0 == null) {
                this.M0 = new VideoSerializeVideoThreadInfo();
            }
            this.M0.copyFromThreadInfo(this.N0);
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.P, this.d0, this.W, m.g(), "", this.M0);
            a2 a2Var = this.N0;
            if (a2Var != null && a2Var.V() != null) {
                videoMiddlePageLightActivityConfig.setNid(this.N0.V().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
        }
    }

    @Override // d.a.k0.j2.q.d, d.a.k0.j2.q.a
    public boolean D() {
        return false;
    }

    public final void D0() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.M0;
        if (videoSerializeVideoThreadInfo != null) {
            a2 a2Var = this.N0;
            if (a2Var != null) {
                videoSerializeVideoThreadInfo.copyFromThreadInfo(a2Var);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.P, this.d0, this.W, m.g(), "", this.M0);
            a2 a2Var2 = this.N0;
            if (a2Var2 != null && a2Var2.V() != null) {
                videoMiddlePageActivityConfig.setNid(this.N0.V().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public void E0() {
        s0(this.f56746i);
    }

    @Override // d.a.k0.j2.q.d
    public void N() {
        if (this.q == this.f56745h) {
            E0();
        }
    }

    @Override // d.a.k0.j2.q.d
    public void O() {
        this.f56746i = 32;
    }

    @Override // d.a.k0.j2.q.d
    public void P() {
    }

    @Override // d.a.k0.j2.q.d
    public void d0() {
        super.d0();
        this.R.setOnTouchListener(null);
        this.R.setOnClickListener(this);
    }

    @Override // d.a.k0.j2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            W();
            return;
        }
        if (!j.z()) {
            l.L(this.P, R.string.no_network_guide);
        } else if (d.a.j0.b.d.K()) {
            C0();
        } else if (d.a.j0.b.d.M()) {
            B0();
        } else if (d.a.j0.b.d.P()) {
            A0();
        } else if (this.U) {
            B0();
        } else if (!"index".equals(this.d0) && !"frs".equals(this.d0) && !"concern_tab".equals(this.d0) && !"video_tab".equals(this.d0) && !Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.d0)) {
            D0();
        } else {
            D0();
        }
        View.OnClickListener onClickListener = this.t0;
        if (onClickListener != null) {
            onClickListener.onClick(E());
        }
    }

    @Override // d.a.k0.j2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    @Override // d.a.k0.j2.q.d, d.a.k0.j2.q.a
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
        videoSerializeVideoThreadInfo2.source = a2Var.R0;
        videoSerializeVideoThreadInfo2.extra = a2Var.U0;
        videoSerializeVideoThreadInfo2.ab_tag = a2Var.T0;
        videoSerializeVideoThreadInfo2.weight = a2Var.S0;
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        p0(z);
    }
}
