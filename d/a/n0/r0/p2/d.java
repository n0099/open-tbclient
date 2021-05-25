package d.a.n0.r0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.n0.r0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f59369a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.r0.i1.g f59370b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.k2.c f59371c;

    /* renamed from: d  reason: collision with root package name */
    public View f59372d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59373e;

    public final void a(d.a.n0.r0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f58700a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f58701b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f58702c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f58706g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f58705f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f58703d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f58704e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f58707h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f58707h.f58712e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f58707h.f58713f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f58707h.f58709b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f58707h.f58710c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f58707h.f58711d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f58716c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f58717d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f58718e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f58719f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f58720g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f58721h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
            cVar.j = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailUrl;
            String str4 = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            gVar.j = videoSerializeVideoThreadInfo.playCount;
        }
        gVar.z = cVar;
        if (videoSerializeVideoThreadInfo.getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = new BaijiahaoData();
            baijiahaoData.oriUgcNid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcNid;
            baijiahaoData.oriUgcTid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcTid;
            baijiahaoData.oriUgcType = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcType;
            baijiahaoData.oriUgcVid = videoSerializeVideoThreadInfo.getBaijiahaoData().oriUgcVid;
            baijiahaoData.forwardUrl = videoSerializeVideoThreadInfo.getBaijiahaoData().forwardUrl;
            gVar.A = baijiahaoData;
        }
        gVar.f58689e = videoSerializeVideoThreadInfo.forumId;
        gVar.f58690f = videoSerializeVideoThreadInfo.threadId;
        gVar.f58692h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f58693i = videoSerializeVideoThreadInfo.createTime;
        gVar.k = videoSerializeVideoThreadInfo.postNum;
        gVar.m = videoSerializeVideoThreadInfo.agreeNum;
        gVar.n = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.o = videoSerializeVideoThreadInfo.agreeType;
        gVar.p = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.l() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.l().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.l().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.l().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.l().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.l().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.l().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.l = videoSerializeVideoThreadInfo.shareNum;
        gVar.x = videoSerializeVideoThreadInfo.title;
        gVar.q = videoSerializeVideoThreadInfo.source;
        gVar.s = videoSerializeVideoThreadInfo.extra;
        gVar.t = videoSerializeVideoThreadInfo.ab_tag;
        gVar.r = videoSerializeVideoThreadInfo.weight;
        gVar.E = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public d.a.n0.r0.i1.g b() {
        if (this.f59370b == null) {
            this.f59370b = new d.a.n0.r0.i1.g();
        }
        a(this.f59370b, this.f59369a.e());
        return this.f59370b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f59373e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f59373e = null;
        }
        View view = this.f59372d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.a.n0.k2.c cVar = this.f59371c;
        if (cVar != null) {
            cVar.v0();
            this.f59371c = null;
        }
    }

    public void e(i iVar) {
        this.f59369a = iVar;
    }
}
