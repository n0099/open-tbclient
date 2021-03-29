package d.b.i0.z0.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.h0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes3.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f63318e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f63319f;

    /* renamed from: g  reason: collision with root package name */
    public long f63320g;

    /* renamed from: h  reason: collision with root package name */
    public int f63321h;
    public int i;
    public boolean j;

    public void g(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f63318e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f63319f = a2Var;
            a2Var.Q2(topicThread.thread_info);
            this.f63319f.U2();
        }
        this.f63321h = topicThread.user_agree.intValue();
        this.i = topicThread.source.intValue();
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.b.b.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void j(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f63318e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f63319f = a2Var;
            a2Var.Q2(topicThread.thread_info);
            this.f63319f.U2();
        }
        this.f63321h = Integer.parseInt(topicThread.user_agree);
        this.i = topicThread.source.intValue();
    }
}
