package d.b.i0.i2.q;

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
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.x.m;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class b extends d {
    public VideoItemData K0;
    public VideoSerializeVideoThreadInfo L0;
    public a2 M0;

    public b(Context context, View view) {
        super(context, view);
        this.f56187e = 5000;
    }

    public final void A0() {
        if (this.M0 == null) {
            return;
        }
        if (this.K0 == null) {
            this.K0 = new VideoItemData();
        }
        ArrayList arrayList = new ArrayList();
        this.K0.buildWithThreadData(this.M0);
        arrayList.add(this.K0);
        Context context = this.P;
        String str = this.d0;
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", str, str);
        videoPlayActivityConfig.setParamIsVertail(this.U);
        a2 a2Var = this.M0;
        if (a2Var != null && a2Var.V() != null) {
            videoPlayActivityConfig.setNid(this.M0.V().oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }

    public final void B0() {
        if (this.M0 != null) {
            if (this.L0 == null) {
                this.L0 = new VideoSerializeVideoThreadInfo();
            }
            this.L0.copyFromThreadInfo(this.M0);
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(this.P, this.d0, this.W, m.g(), "", this.L0);
            a2 a2Var = this.M0;
            if (a2Var != null && a2Var.V() != null) {
                videoMiddlePageLightActivityConfig.setNid(this.M0.V().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
        }
    }

    public final void C0() {
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.L0;
        if (videoSerializeVideoThreadInfo != null) {
            a2 a2Var = this.M0;
            if (a2Var != null) {
                videoSerializeVideoThreadInfo.copyFromThreadInfo(a2Var);
            }
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(this.P, this.d0, this.W, m.g(), "", this.L0);
            a2 a2Var2 = this.M0;
            if (a2Var2 != null && a2Var2.V() != null) {
                videoMiddlePageActivityConfig.setNid(this.M0.V().oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public void D0() {
        r0(this.i);
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
    public boolean H() {
        return false;
    }

    @Override // d.b.i0.i2.q.d
    public void P() {
        if (this.q == this.f56190h) {
            D0();
        }
    }

    @Override // d.b.i0.i2.q.d
    public void Q() {
        this.i = 32;
    }

    @Override // d.b.i0.i2.q.d
    public void R() {
    }

    @Override // d.b.i0.i2.q.d
    public void f0() {
        super.f0();
        this.R.setOnTouchListener(null);
        this.R.setOnClickListener(this);
    }

    @Override // d.b.i0.i2.q.d, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        if (view.getId() == R.id.video_mute) {
            X();
            return;
        }
        if (!j.z()) {
            l.K(this.P, R.string.no_network_guide);
        } else if (d.b.h0.b.d.I()) {
            B0();
        } else if (d.b.h0.b.d.K()) {
            A0();
        } else if (d.b.h0.b.d.N()) {
            z0();
        } else if (this.U) {
            A0();
        } else if (!"index".equals(this.d0) && !"frs".equals(this.d0) && !"concern_tab".equals(this.d0) && !"video_tab".equals(this.d0) && !Constants.VIA_REPORT_TYPE_MAKE_FRIEND.equals(this.d0)) {
            C0();
        } else {
            C0();
        }
        View.OnClickListener onClickListener = this.s0;
        if (onClickListener != null) {
            onClickListener.onClick(C());
        }
    }

    @Override // d.b.i0.i2.q.d, com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        startPlay();
    }

    @Override // d.b.i0.i2.q.d, d.b.i0.i2.q.a
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

    public final void z0() {
        View.OnClickListener onClickListener = this.t0;
        if (onClickListener != null) {
            onClickListener.onClick(C());
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.L0;
        if (videoSerializeVideoThreadInfo != null) {
            String str = videoSerializeVideoThreadInfo.threadId;
            String str2 = videoSerializeVideoThreadInfo.forumId;
            PbActivityConfig pbActivityConfig = new PbActivityConfig(this.P);
            pbActivityConfig.createNormalCfg(str, null, null);
            pbActivityConfig.setForumId(String.valueOf(str2));
            pbActivityConfig.setThreadData(this.M0);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, pbActivityConfig));
        }
    }

    public b(Context context, View view, boolean z) {
        this(context, view);
        p0(z);
    }
}
