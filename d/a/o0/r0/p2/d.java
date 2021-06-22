package d.a.o0.r0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.o0.r0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f63185a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.r0.i1.g f63186b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.k2.c f63187c;

    /* renamed from: d  reason: collision with root package name */
    public View f63188d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f63189e;

    public final void a(d.a.o0.r0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f62516a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f62517b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f62518c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f62522g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f62521f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f62519d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f62520e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f62523h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f62523h.f62528e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f62523h.f62529f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f62523h.f62525b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f62523h.f62526c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f62523h.f62527d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f62532c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f62533d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f62534e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f62535f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f62536g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f62537h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f62505e = videoSerializeVideoThreadInfo.forumId;
        gVar.f62506f = videoSerializeVideoThreadInfo.threadId;
        gVar.f62508h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f62509i = videoSerializeVideoThreadInfo.createTime;
        gVar.k = videoSerializeVideoThreadInfo.postNum;
        gVar.m = videoSerializeVideoThreadInfo.agreeNum;
        gVar.n = videoSerializeVideoThreadInfo.disAgreeNum;
        gVar.o = videoSerializeVideoThreadInfo.agreeType;
        gVar.p = videoSerializeVideoThreadInfo.hasAgree;
        if (gVar.g() != null && videoSerializeVideoThreadInfo.mAgreeData != null) {
            gVar.g().threadId = videoSerializeVideoThreadInfo.mAgreeData.threadId;
            gVar.g().agreeType = videoSerializeVideoThreadInfo.mAgreeData.agreeType;
            gVar.g().hasAgree = videoSerializeVideoThreadInfo.mAgreeData.hasAgree;
            gVar.g().agreeNum = videoSerializeVideoThreadInfo.mAgreeData.agreeNum;
            gVar.g().disAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.disAgreeNum;
            gVar.g().diffAgreeNum = videoSerializeVideoThreadInfo.mAgreeData.diffAgreeNum;
        }
        gVar.l = videoSerializeVideoThreadInfo.shareNum;
        gVar.x = videoSerializeVideoThreadInfo.title;
        gVar.q = videoSerializeVideoThreadInfo.source;
        gVar.s = videoSerializeVideoThreadInfo.extra;
        gVar.t = videoSerializeVideoThreadInfo.ab_tag;
        gVar.r = videoSerializeVideoThreadInfo.weight;
        gVar.E = videoSerializeVideoThreadInfo.mWorksInfoData;
    }

    public d.a.o0.r0.i1.g b() {
        if (this.f63186b == null) {
            this.f63186b = new d.a.o0.r0.i1.g();
        }
        a(this.f63186b, this.f63185a.e());
        return this.f63186b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f63189e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f63189e = null;
        }
        View view = this.f63188d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.a.o0.k2.c cVar = this.f63187c;
        if (cVar != null) {
            cVar.v0();
            this.f63187c = null;
        }
    }

    public void e(i iVar) {
        this.f63185a = iVar;
    }
}
