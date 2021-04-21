package d.b.j0.a1.j.a.c;

import tbclient.NewHottopic.PkModule;
import tbclient.NewHottopic.TimeLine;
import tbclient.NewHottopic.TopicDetail;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f53352a;

    /* renamed from: b  reason: collision with root package name */
    public String f53353b;

    /* renamed from: c  reason: collision with root package name */
    public String f53354c;

    /* renamed from: d  reason: collision with root package name */
    public String f53355d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.a1.j.b.c.b f53356e;

    /* renamed from: f  reason: collision with root package name */
    public f f53357f;

    public void a(TopicDetail topicDetail) {
        if (topicDetail == null) {
            return;
        }
        this.f53352a = topicDetail.topic_id.longValue();
        this.f53353b = topicDetail.topic_desc;
        topicDetail.discuss_num.longValue();
        this.f53354c = topicDetail.topic_image;
        this.f53355d = topicDetail.bg_image;
    }

    public void b(PkModule pkModule) {
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        d.b.j0.a1.j.b.c.b bVar = new d.b.j0.a1.j.b.c.b();
        this.f53356e = bVar;
        bVar.f53393a = this.f53352a;
        bVar.f53398f = 2;
        bVar.a(pkModule);
    }

    public void c(TimeLine timeLine) {
        if (timeLine == null) {
            return;
        }
        f fVar = new f();
        this.f53357f = fVar;
        fVar.a(this.f53352a, timeLine);
    }
}
