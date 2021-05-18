package d.a.k0.q0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.k0.q0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f59228a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.k0.q0.i1.g f59229b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.j2.c f59230c;

    /* renamed from: d  reason: collision with root package name */
    public View f59231d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f59232e;

    public final void a(d.a.k0.q0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f58559a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f58560b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f58561c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f58565g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f58564f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f58562d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f58563e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f58566h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f58566h.f58571e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f58566h.f58572f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f58566h.f58568b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f58566h.f58569c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f58566h.f58570d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f58575c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f58576d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f58577e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f58578f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f58579g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f58580h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f58548e = videoSerializeVideoThreadInfo.forumId;
        gVar.f58549f = videoSerializeVideoThreadInfo.threadId;
        gVar.f58551h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f58552i = videoSerializeVideoThreadInfo.createTime;
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

    public d.a.k0.q0.i1.g b() {
        if (this.f59229b == null) {
            this.f59229b = new d.a.k0.q0.i1.g();
        }
        a(this.f59229b, this.f59228a.e());
        return this.f59229b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f59232e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f59232e = null;
        }
        View view = this.f59231d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.a.k0.j2.c cVar = this.f59230c;
        if (cVar != null) {
            cVar.v0();
            this.f59230c = null;
        }
    }

    public void e(i iVar) {
        this.f59228a = iVar;
    }
}
