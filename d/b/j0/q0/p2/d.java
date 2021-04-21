package d.b.j0.q0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.b.j0.q0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f60394a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.q0.i1.g f60395b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.j2.c f60396c;

    /* renamed from: d  reason: collision with root package name */
    public View f60397d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f60398e;

    public final void a(d.b.j0.q0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f59749a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f59750b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f59751c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f59755g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f59754f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f59752d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f59753e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f59756h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f59756h.f59761e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f59756h.f59762f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f59756h.f59758b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f59756h.f59759c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f59756h.f59760d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f59765c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f59766d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f59767e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f59768f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f59769g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f59770h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f59739e = videoSerializeVideoThreadInfo.forumId;
        gVar.f59740f = videoSerializeVideoThreadInfo.threadId;
        gVar.f59742h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.i = videoSerializeVideoThreadInfo.createTime;
        gVar.k = videoSerializeVideoThreadInfo.postNum;
        gVar.m = videoSerializeVideoThreadInfo.agreeNum;
        gVar.n = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.o = videoSerializeVideoThreadInfo.agreeType;
        gVar.p = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.j() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.j().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.j().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.j().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.j().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.j().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.j().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.l = videoSerializeVideoThreadInfo.shareNum;
        gVar.x = videoSerializeVideoThreadInfo.title;
        gVar.q = videoSerializeVideoThreadInfo.source;
        gVar.s = videoSerializeVideoThreadInfo.extra;
        gVar.t = videoSerializeVideoThreadInfo.ab_tag;
        gVar.r = videoSerializeVideoThreadInfo.weight;
        gVar.E = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public d.b.j0.q0.i1.g b() {
        if (this.f60395b == null) {
            this.f60395b = new d.b.j0.q0.i1.g();
        }
        a(this.f60395b, this.f60394a.e());
        return this.f60395b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f60398e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f60398e = null;
        }
        View view = this.f60397d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.b.j0.j2.c cVar = this.f60396c;
        if (cVar != null) {
            cVar.v0();
            this.f60396c = null;
        }
    }

    public void e(i iVar) {
        this.f60394a = iVar;
    }
}
