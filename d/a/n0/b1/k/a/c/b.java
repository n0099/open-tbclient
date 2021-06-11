package d.a.n0.b1.k.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f55629a;

    /* renamed from: b  reason: collision with root package name */
    public String f55630b;

    /* renamed from: c  reason: collision with root package name */
    public String f55631c;

    /* renamed from: d  reason: collision with root package name */
    public String f55632d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.b1.k.b.c.b f55633e;

    /* renamed from: f  reason: collision with root package name */
    public f f55634f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f55629a = topicDetail.topic_id.longValue();
        this.f55630b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f55631c = topicDetail.topic_image;
        this.f55632d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.a.n0.b1.k.b.c.b bVar = new d.a.n0.b1.k.b.c.b();
        this.f55633e = bVar;
        bVar.f55673a = this.f55629a;
        bVar.f55678f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f55634f = fVar;
        fVar.a(this.f55629a, timeLine);
    }
}
