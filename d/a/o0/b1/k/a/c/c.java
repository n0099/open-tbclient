package d.a.o0.b1.k.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.n0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f55760e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f55761f;

    /* renamed from: g  reason: collision with root package name */
    public long f55762g;

    /* renamed from: h  reason: collision with root package name */
    public int f55763h;

    /* renamed from: i  reason: collision with root package name */
    public int f55764i;
    public boolean j;

    public void c(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f55760e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f55761f = a2Var;
            a2Var.V2(topicThread.thread_info);
            this.f55761f.Z2();
        }
        this.f55763h = topicThread.user_agree.intValue();
        this.f55764i = topicThread.source.intValue();
    }

    public void g(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f55760e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f55761f = a2Var;
            a2Var.V2(topicThread.thread_info);
            this.f55761f.Z2();
        }
        this.f55763h = Integer.parseInt(topicThread.user_agree);
        this.f55764i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        return k;
    }
}
