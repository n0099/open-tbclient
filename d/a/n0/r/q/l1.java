package d.a.n0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53858a;

    /* renamed from: b  reason: collision with root package name */
    public String f53859b;

    /* renamed from: c  reason: collision with root package name */
    public long f53860c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f53858a = recomPostTopic.recom_title;
        this.f53859b = recomPostTopic.recom_topic;
        this.f53860c = recomPostTopic.uniq_topicid.longValue();
    }
}
