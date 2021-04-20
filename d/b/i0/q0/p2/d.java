package d.b.i0.q0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.b.i0.q0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f59973a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.q0.i1.g f59974b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.j2.c f59975c;

    /* renamed from: d  reason: collision with root package name */
    public View f59976d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59977e;

    public final void a(d.b.i0.q0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f59328a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f59329b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f59330c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f59334g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f59333f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f59331d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f59332e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f59335h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f59335h.f59340e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f59335h.f59341f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f59335h.f59337b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f59335h.f59338c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f59335h.f59339d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f59344c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f59345d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f59346e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f59347f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f59348g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f59349h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f59318e = videoSerializeVideoThreadInfo.forumId;
        gVar.f59319f = videoSerializeVideoThreadInfo.threadId;
        gVar.f59321h = videoSerializeVideoThreadInfo.firstPostId;
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

    public d.b.i0.q0.i1.g b() {
        if (this.f59974b == null) {
            this.f59974b = new d.b.i0.q0.i1.g();
        }
        a(this.f59974b, this.f59973a.e());
        return this.f59974b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f59977e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f59977e = null;
        }
        View view = this.f59976d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.b.i0.j2.c cVar = this.f59975c;
        if (cVar != null) {
            cVar.v0();
            this.f59975c = null;
        }
    }

    public void e(i iVar) {
        this.f59973a = iVar;
    }
}
