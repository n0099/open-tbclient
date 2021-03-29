package d.b.i0.z0.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f63312a;

    /* renamed from: b  reason: collision with root package name */
    public String f63313b;

    /* renamed from: c  reason: collision with root package name */
    public String f63314c;

    /* renamed from: d  reason: collision with root package name */
    public String f63315d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.z0.j.b.c.b f63316e;

    /* renamed from: f  reason: collision with root package name */
    public f f63317f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f63312a = topicDetail.topic_id.longValue();
        this.f63313b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f63314c = topicDetail.topic_image;
        this.f63315d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.b.i0.z0.j.b.c.b bVar = new d.b.i0.z0.j.b.c.b();
        this.f63316e = bVar;
        bVar.f63353a = this.f63312a;
        bVar.f63358f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f63317f = fVar;
        fVar.a(this.f63312a, timeLine);
    }
}
