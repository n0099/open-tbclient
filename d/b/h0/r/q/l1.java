package d.b.h0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f51247a;

    /* renamed from: b  reason: collision with root package name */
    public String f51248b;

    /* renamed from: c  reason: collision with root package name */
    public long f51249c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f51247a = recomPostTopic.recom_title;
        this.f51248b = recomPostTopic.recom_topic;
        this.f51249c = recomPostTopic.uniq_topicid.longValue();
    }
}
