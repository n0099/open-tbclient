package d.b.h0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f50840a;

    /* renamed from: b  reason: collision with root package name */
    public String f50841b;

    /* renamed from: c  reason: collision with root package name */
    public long f50842c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f50840a = recomPostTopic.recom_title;
        this.f50841b = recomPostTopic.recom_topic;
        this.f50842c = recomPostTopic.uniq_topicid.longValue();
    }
}
