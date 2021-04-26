package d.a.j0.q0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.j0.q0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f58486a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.q0.i1.g f58487b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.j2.c f58488c;

    /* renamed from: d  reason: collision with root package name */
    public View f58489d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58490e;

    public final void a(d.a.j0.q0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f57817a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f57818b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f57819c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f57823g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f57822f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f57820d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f57821e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f57824h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f57824h.f57829e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f57824h.f57830f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f57824h.f57826b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f57824h.f57827c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f57824h.f57828d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f57833c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f57834d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f57835e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f57836f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f57837g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f57838h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f57806e = videoSerializeVideoThreadInfo.forumId;
        gVar.f57807f = videoSerializeVideoThreadInfo.threadId;
        gVar.f57809h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f57810i = videoSerializeVideoThreadInfo.createTime;
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

    public d.a.j0.q0.i1.g b() {
        if (this.f58487b == null) {
            this.f58487b = new d.a.j0.q0.i1.g();
        }
        a(this.f58487b, this.f58486a.e());
        return this.f58487b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f58490e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f58490e = null;
        }
        View view = this.f58489d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.a.j0.j2.c cVar = this.f58488c;
        if (cVar != null) {
            cVar.v0();
            this.f58488c = null;
        }
    }

    public void e(i iVar) {
        this.f58486a = iVar;
    }
}
