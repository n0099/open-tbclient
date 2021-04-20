package d.b.i0.a1.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f52931a;

    /* renamed from: b  reason: collision with root package name */
    public String f52932b;

    /* renamed from: c  reason: collision with root package name */
    public String f52933c;

    /* renamed from: d  reason: collision with root package name */
    public String f52934d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.a1.j.b.c.b f52935e;

    /* renamed from: f  reason: collision with root package name */
    public f f52936f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f52931a = topicDetail.topic_id.longValue();
        this.f52932b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f52933c = topicDetail.topic_image;
        this.f52934d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.b.i0.a1.j.b.c.b bVar = new d.b.i0.a1.j.b.c.b();
        this.f52935e = bVar;
        bVar.f52972a = this.f52931a;
        bVar.f52977f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f52936f = fVar;
        fVar.a(this.f52931a, timeLine);
    }
}
