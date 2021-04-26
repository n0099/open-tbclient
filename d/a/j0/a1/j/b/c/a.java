package d.a.j0.a1.j.b.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.v0;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes4.dex */
public class a extends d.a.j0.x.e0.b {
    public static final BdUniqueId c0 = BdUniqueId.gen();
    public static final BdUniqueId d0 = BdUniqueId.gen();
    public int S;
    public long T;
    public String U;
    public String V;
    public long W;
    public String X;
    public b Y;
    public PostData Z;
    public int a0 = 0;
    public a2 b0;

    public static boolean Z(a2 a2Var) {
        return a2Var != null && a2Var.getType() == a2.V2;
    }

    public void a0(NewTopicList newTopicList) {
        if (newTopicList == null) {
            return;
        }
        this.T = newTopicList.topic_id.longValue();
        this.U = newTopicList.topic_name;
        this.V = newTopicList.topic_desc;
        this.W = newTopicList.discuss_num.longValue();
        this.X = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            b bVar = new b();
            this.Y = bVar;
            bVar.f51118a = this.T;
            bVar.f51123f = 1;
            bVar.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.Z = postData;
            postData.b0(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
        }
    }

    public void b0(TopicModule topicModule) {
        if (topicModule == null) {
            return;
        }
        this.T = topicModule.topic_id.longValue();
        this.U = topicModule.topic_name;
        this.V = topicModule.topic_desc;
        this.X = topicModule.topic_image;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        b bVar = new b();
        this.Y = bVar;
        bVar.f51118a = this.T;
        bVar.f51123f = 3;
        bVar.c(topicModule.pk_module);
    }

    public void c0(a2 a2Var) {
        this.b0 = a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.a0 == 0 ? c0 : d0;
    }

    @Override // d.a.j0.x.e0.b, d.a.i0.r.q.a
    public v0 h() {
        v0 h2 = super.h();
        if (h2 != null) {
            h2.p(this.T);
        }
        return h2;
    }

    @Override // d.a.j0.x.e0.b, d.a.i0.r.q.a
    public a2 m() {
        return this.b0;
    }
}
