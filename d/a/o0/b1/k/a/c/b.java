package d.a.o0.b1.k.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f55754a;

    /* renamed from: b  reason: collision with root package name */
    public String f55755b;

    /* renamed from: c  reason: collision with root package name */
    public String f55756c;

    /* renamed from: d  reason: collision with root package name */
    public String f55757d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.b1.k.b.c.b f55758e;

    /* renamed from: f  reason: collision with root package name */
    public f f55759f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f55754a = topicDetail.topic_id.longValue();
        this.f55755b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f55756c = topicDetail.topic_image;
        this.f55757d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.o0.b1.k.b.c.b bVar = new d.a.o0.b1.k.b.c.b();
        this.f55758e = bVar;
        bVar.f55798a = this.f55754a;
        bVar.f55803f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f55759f = fVar;
        fVar.a(this.f55754a, timeLine);
    }
}
