package d.a.m0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f53751a;

    /* renamed from: b  reason: collision with root package name */
    public String f53752b;

    /* renamed from: c  reason: collision with root package name */
    public long f53753c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f53751a = recomPostTopic.recom_title;
        this.f53752b = recomPostTopic.recom_topic;
        this.f53753c = recomPostTopic.uniq_topicid.longValue();
    }
}
