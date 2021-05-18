package d.a.k0.a1.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51773a;

    /* renamed from: b  reason: collision with root package name */
    public String f51774b;

    /* renamed from: c  reason: collision with root package name */
    public String f51775c;

    /* renamed from: d  reason: collision with root package name */
    public String f51776d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.a1.j.b.c.b f51777e;

    /* renamed from: f  reason: collision with root package name */
    public f f51778f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f51773a = topicDetail.topic_id.longValue();
        this.f51774b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f51775c = topicDetail.topic_image;
        this.f51776d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.k0.a1.j.b.c.b bVar = new d.a.k0.a1.j.b.c.b();
        this.f51777e = bVar;
        bVar.f51817a = this.f51773a;
        bVar.f51822f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f51778f = fVar;
        fVar.a(this.f51773a, timeLine);
    }
}
