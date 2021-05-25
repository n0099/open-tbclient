package d.a.n0.b1.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51940a;

    /* renamed from: b  reason: collision with root package name */
    public String f51941b;

    /* renamed from: c  reason: collision with root package name */
    public String f51942c;

    /* renamed from: d  reason: collision with root package name */
    public String f51943d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.j.b.c.b f51944e;

    /* renamed from: f  reason: collision with root package name */
    public f f51945f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f51940a = topicDetail.topic_id.longValue();
        this.f51941b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f51942c = topicDetail.topic_image;
        this.f51943d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.n0.b1.j.b.c.b bVar = new d.a.n0.b1.j.b.c.b();
        this.f51944e = bVar;
        bVar.f51984a = this.f51940a;
        bVar.f51989f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f51945f = fVar;
        fVar.a(this.f51940a, timeLine);
    }
}
