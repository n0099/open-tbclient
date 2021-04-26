package d.a.j0.a1.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f51074a;

    /* renamed from: b  reason: collision with root package name */
    public String f51075b;

    /* renamed from: c  reason: collision with root package name */
    public String f51076c;

    /* renamed from: d  reason: collision with root package name */
    public String f51077d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.a1.j.b.c.b f51078e;

    /* renamed from: f  reason: collision with root package name */
    public f f51079f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f51074a = topicDetail.topic_id.longValue();
        this.f51075b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f51076c = topicDetail.topic_image;
        this.f51077d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.j0.a1.j.b.c.b bVar = new d.a.j0.a1.j.b.c.b();
        this.f51078e = bVar;
        bVar.f51118a = this.f51074a;
        bVar.f51123f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f51079f = fVar;
        fVar.a(this.f51074a, timeLine);
    }
}
