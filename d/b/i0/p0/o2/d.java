package d.b.i0.p0.o2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.b.i0.p0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f58300a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.p0.i1.g f58301b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.i2.c f58302c;

    /* renamed from: d  reason: collision with root package name */
    public View f58303d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f58304e;

    public final void a(d.b.i0.p0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f57629a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f57630b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f57631c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f57635g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f57634f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f57632d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f57633e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f57636h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f57636h.f57641e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f57636h.f57642f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f57636h.f57638b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f57636h.f57639c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f57636h.f57640d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f57645c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f57646d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f57647e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f57648f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f57649g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f57650h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f57619e = videoSerializeVideoThreadInfo.forumId;
        gVar.f57620f = videoSerializeVideoThreadInfo.threadId;
        gVar.f57622h = videoSerializeVideoThreadInfo.firstPostId;
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
        if (this.f58301b == null) {
            this.f58301b = new d.b.i0.p0.i1.g();
        }
        a(this.f58301b, this.f58300a.e());
        return this.f58301b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f58304e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f58304e = null;
        }
        View view = this.f58303d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.b.i0.i2.c cVar = this.f58302c;
        if (cVar != null) {
            cVar.v0();
            this.f58302c = null;
        }
    }

    public void e(i iVar) {
        this.f58300a = iVar;
    }
}
