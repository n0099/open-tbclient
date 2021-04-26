package d.a.i0.r.q;

import tbclient.RecomPostTopic;
/* loaded from: classes3.dex */
public class l1 {

    /* renamed from: a  reason: collision with root package name */
    public String f49212a;

    /* renamed from: b  reason: collision with root package name */
    public String f49213b;

    /* renamed from: c  reason: collision with root package name */
    public long f49214c;

    public void a(RecomPostTopic recomPostTopic) {
        if (recomPostTopic == null) {
            return;
        }
        this.f49212a = recomPostTopic.recom_title;
        this.f49213b = recomPostTopic.recom_topic;
        this.f49214c = recomPostTopic.uniq_topicid.longValue();
    }
}
