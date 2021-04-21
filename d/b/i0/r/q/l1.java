package d.b.i0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51583a;

    /* renamed from: b  reason: collision with root package name */
    public String f51584b;

    /* renamed from: c  reason: collision with root package name */
    public long f51585c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f51583a = recomPostTopic.recom_title;
        this.f51584b = recomPostTopic.recom_topic;
        this.f51585c = recomPostTopic.uniq_topicid.longValue();
    }
}
