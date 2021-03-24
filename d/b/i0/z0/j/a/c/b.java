package d.b.i0.z0.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f63311a;

    /* renamed from: b  reason: collision with root package name */
    public String f63312b;

    /* renamed from: c  reason: collision with root package name */
    public String f63313c;

    /* renamed from: d  reason: collision with root package name */
    public String f63314d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.z0.j.b.c.b f63315e;

    /* renamed from: f  reason: collision with root package name */
    public f f63316f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f63311a = topicDetail.topic_id.longValue();
        this.f63312b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f63313c = topicDetail.topic_image;
        this.f63314d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.b.i0.z0.j.b.c.b bVar = new d.b.i0.z0.j.b.c.b();
        this.f63315e = bVar;
        bVar.f63352a = this.f63311a;
        bVar.f63357f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f63316f = fVar;
        fVar.a(this.f63311a, timeLine);
    }
}
