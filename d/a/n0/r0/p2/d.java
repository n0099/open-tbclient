package d.a.n0.r0.p2;

import android.animation.ValueAnimator;
import android.view.View;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.n0.r0.i1.g;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public i f63060a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.r0.i1.g f63061b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.k2.c f63062c;

    /* renamed from: d  reason: collision with root package name */
    public View f63063d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f63064e;

    public final void a(d.a.n0.r0.i1.g gVar, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        if (videoSerializeVideoThreadInfo == null) {
            return;
        }
        g.b bVar = new g.b();
        if (videoSerializeVideoThreadInfo.getAuthor() != null) {
            bVar.f62391a = videoSerializeVideoThreadInfo.getAuthor().userId;
            bVar.f62392b = videoSerializeVideoThreadInfo.getAuthor().userName;
            bVar.f62393c = videoSerializeVideoThreadInfo.getAuthor().userNickname;
            bVar.f62397g = videoSerializeVideoThreadInfo.getAuthor().isBigV;
            bVar.f62396f = videoSerializeVideoThreadInfo.getAuthor().isGod;
            bVar.f62394d = videoSerializeVideoThreadInfo.getAuthor().portrait;
            bVar.f62395e = videoSerializeVideoThreadInfo.getAuthor().hasFocus;
            if (videoSerializeVideoThreadInfo.getAuthor().baijiahaoData != null) {
                bVar.f62398h = new g.b.a();
                String str = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.name;
                bVar.f62398h.f62403e = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_id;
                bVar.f62398h.f62404f = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.auth_desc;
                bVar.f62398h.f62400b = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar;
                bVar.f62398h.f62401c = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.avatar_h;
                bVar.f62398h.f62402d = videoSerializeVideoThreadInfo.getAuthor().baijiahaoData.brief;
            }
        }
        gVar.y = bVar;
        g.c cVar = new g.c();
        if (videoSerializeVideoThreadInfo.getThreadVideoInfo() != null) {
            String str2 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailWidth;
            String str3 = videoSerializeVideoThreadInfo.getThreadVideoInfo().thumbnailHeight;
            cVar.f62407c = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoMd5;
            cVar.f62408d = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoUrl;
            cVar.f62409e = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoDuration;
            cVar.f62410f = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoWidth;
            cVar.f62411g = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoHeight;
            cVar.f62412h = videoSerializeVideoThreadInfo.getThreadVideoInfo().videoSize;
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
        gVar.f62380e = videoSerializeVideoThreadInfo.forumId;
        gVar.f62381f = videoSerializeVideoThreadInfo.threadId;
        gVar.f62383h = videoSerializeVideoThreadInfo.firstPostId;
        gVar.f62384i = videoSerializeVideoThreadInfo.createTime;
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

    public d.a.n0.r0.i1.g b() {
        if (this.f63061b == null) {
            this.f63061b = new d.a.n0.r0.i1.g();
        }
        a(this.f63061b, this.f63060a.e());
        return this.f63061b;
    }

    public void c() {
        ValueAnimator valueAnimator = this.f63064e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f63064e = null;
        }
        View view = this.f63063d;
        if (view != null) {
            view.clearAnimation();
        }
        d();
    }

    public void d() {
        d.a.n0.k2.c cVar = this.f63062c;
        if (cVar != null) {
            cVar.v0();
            this.f63062c = null;
        }
    }

    public void e(i iVar) {
        this.f63060a = iVar;
    }
}
