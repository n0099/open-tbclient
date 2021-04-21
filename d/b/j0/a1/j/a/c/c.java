package d.b.j0.a1.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.i0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f53358e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f53359f;

    /* renamed from: g  reason: collision with root package name */
    public long f53360g;

    /* renamed from: h  reason: collision with root package name */
    public int f53361h;
    public int i;
    public boolean j;

    public void g(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f53358e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f53359f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f53359f.V2();
        }
        this.f53361h = topicThread.user_agree.intValue();
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
        this.f53358e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f53359f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f53359f.V2();
        }
        this.f53361h = Integer.parseInt(topicThread.user_agree);
        this.i = topicThread.source.intValue();
    }
}
