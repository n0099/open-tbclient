package d.b.i0.a1.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f52937e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f52938f;

    /* renamed from: g  reason: collision with root package name */
    public long f52939g;

    /* renamed from: h  reason: collision with root package name */
    public int f52940h;
    public int i;
    public boolean j;

    public void g(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f52937e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f52938f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f52938f.V2();
        }
        this.f52940h = topicThread.user_agree.intValue();
        this.i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void j(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f52937e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f52938f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f52938f.V2();
        }
        this.f52940h = Integer.parseInt(topicThread.user_agree);
        this.i = topicThread.source.intValue();
    }
}
