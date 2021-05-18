package d.a.k0.a1.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.j0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f51779e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f51780f;

    /* renamed from: g  reason: collision with root package name */
    public long f51781g;

    /* renamed from: h  reason: collision with root package name */
    public int f51782h;

    /* renamed from: i  reason: collision with root package name */
    public int f51783i;
    public boolean j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void h(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f51779e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f51780f = a2Var;
            a2Var.T2(topicThread.thread_info);
            this.f51780f.X2();
        }
        this.f51782h = topicThread.user_agree.intValue();
        this.f51783i = topicThread.source.intValue();
    }

    public void l(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f51779e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f51780f = a2Var;
            a2Var.T2(topicThread.thread_info);
            this.f51780f.X2();
        }
        this.f51782h = Integer.parseInt(topicThread.user_agree);
        this.f51783i = topicThread.source.intValue();
    }
}
