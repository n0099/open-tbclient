package d.a.j0.a1.j.a.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.i0.r.q.a2;
import tbclient.NewHottopic.TopicThread;
/* loaded from: classes4.dex */
public class c extends BaseCardInfo {
    public static final BdUniqueId k = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public long f51080e;

    /* renamed from: f  reason: collision with root package name */
    public a2 f51081f;

    /* renamed from: g  reason: collision with root package name */
    public long f51082g;

    /* renamed from: h  reason: collision with root package name */
    public int f51083h;

    /* renamed from: i  reason: collision with root package name */
    public int f51084i;
    public boolean j;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return k;
    }

    public void h(TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f51080e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f51081f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f51081f.V2();
        }
        this.f51083h = topicThread.user_agree.intValue();
        this.f51084i = topicThread.source.intValue();
    }

    public void l(tbclient.NewTopicThread.TopicThread topicThread) {
        if (topicThread == null) {
            return;
        }
        this.f51080e = topicThread.feed_id.longValue();
        if (topicThread.thread_info != null) {
            a2 a2Var = new a2();
            this.f51081f = a2Var;
            a2Var.R2(topicThread.thread_info);
            this.f51081f.V2();
        }
        this.f51083h = Integer.parseInt(topicThread.user_agree);
        this.f51084i = topicThread.source.intValue();
    }
}
