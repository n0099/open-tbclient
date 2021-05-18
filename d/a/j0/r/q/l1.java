package d.a.j0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50031a;

    /* renamed from: b  reason: collision with root package name */
    public String f50032b;

    /* renamed from: c  reason: collision with root package name */
    public long f50033c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f50031a = recomPostTopic.recom_title;
        this.f50032b = recomPostTopic.recom_topic;
        this.f50033c = recomPostTopic.uniq_topicid.longValue();
    }
}
