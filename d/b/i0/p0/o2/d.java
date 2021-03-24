package d.b.i0.p0.o2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.b.i0.p0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f58299a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.p0.i1.g f58300b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.i2.c f58301c;

    /* renamed from: d  reason: collision with root package name */
    public View f58302d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58303e;

    public final void a(d.b.i0.p0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f57628a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f57629b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f57630c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f57634g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f57633f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f57631d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f57632e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f57635h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f57635h.f57640e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f57635h.f57641f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f57635h.f57637b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f57635h.f57638c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f57635h.f57639d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f57644c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f57645d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f57646e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f57647f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f57648g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f57649h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f57618e = videoSerializeVideoThreadInfo.forumId;
        gVar.f57619f = videoSerializeVideoThreadInfo.threadId;
        gVar.f57621h = videoSerializeVideoThreadInfo.firstPostId;
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

    public d.b.i0.p0.i1.g b() {
        if (this.f58300b == null) {
            this.f58300b = new d.b.i0.p0.i1.g();
        }
        a(this.f58300b, this.f58299a.e());
        return this.f58300b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f58303e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f58303e = null;
        }
        View view = this.f58302d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.b.i0.i2.c cVar = this.f58301c;
        if (cVar != null) {
            cVar.v0();
            this.f58301c = null;
        }
    }

    public void e(i iVar) {
        this.f58299a = iVar;
    }
}
