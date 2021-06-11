package d.a.n0.b1.k.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.m0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f55635e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f55636f;

    /* renamed from: g  reason: collision with root package name */
    public long f55637g;

    /* renamed from: h  reason: collision with root package name */
    public int f55638h;

    /* renamed from: i  reason: collision with root package name */
    public int f55639i;
    public boolean j;

    public void c(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f55635e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f55636f = a2Var;
            a2Var.V2(topicThread.thread_info);
            this.f55636f.Z2();
        }
        this.f55638h = topicThread.user_agree.intValue();
        this.f55639i = topicThread.source.intValue();
    }

    public void g(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f55635e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f55636f = a2Var;
            a2Var.V2(topicThread.thread_info);
            this.f55636f.Z2();
        }
        this.f55638h = Integer.parseInt(topicThread.user_agree);
        this.f55639i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
