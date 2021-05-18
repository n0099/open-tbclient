package d.a.k0.a1.j.b.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.v0;
import tbclient.NewTopicList.NewTopicList;
import tbclient.NewTopicList.PkModule;
import tbclient.TopicModule;
/* loaded from: classes4.dex */
public class a extends d.a.k0.x.e0.b {
    public static final BdUniqueId d0 = BdUniqueId.gen();
    public static final BdUniqueId e0 = BdUniqueId.gen();
    public int T;
    public long U;
    public String V;
    public String W;
    public long X;
    public String Y;
    public b Z;
    public PostData a0;
    public int b0 = 0;
    public a2 c0;

    public static boolean Z(a2 a2Var) {
        return a2Var != null && a2Var.getType() == a2.W2;
    }

    public void a0(NewTopicList newTopicList) {
        if (newTopicList == null) {
            return;
        }
        this.U = newTopicList.topic_id.longValue();
        this.V = newTopicList.topic_name;
        this.W = newTopicList.topic_desc;
        this.X = newTopicList.discuss_num.longValue();
        this.Y = newTopicList.topic_image;
        PkModule pkModule = newTopicList.pk_module;
        if (pkModule != null && pkModule.agree != null && pkModule.disagree != null) {
            b bVar = new b();
            this.Z = bVar;
            bVar.f51817a = this.U;
            bVar.f51822f = 1;
            bVar.b(newTopicList.pk_module);
        }
        if (newTopicList.top_agree_post != null) {
            PostData postData = new PostData();
            this.a0 = postData;
            postData.b0(newTopicList.top_agree_post, TbadkCoreApplication.getInst());
        }
    }

    public void b0(TopicModule topicModule) {
        if (topicModule == null) {
            return;
        }
        this.U = topicModule.topic_id.longValue();
        this.V = topicModule.topic_name;
        this.W = topicModule.topic_desc;
        this.Y = topicModule.topic_image;
        tbclient.PkModule pkModule = topicModule.pk_module;
        if (pkModule == null || pkModule.agree == null || pkModule.disagree == null) {
            return;
        }
        b bVar = new b();
        this.Z = bVar;
        bVar.f51817a = this.U;
        bVar.f51822f = 3;
        bVar.c(topicModule.pk_module);
    }

    public void c0(a2 a2Var) {
        this.c0 = a2Var;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        return this.b0 == 0 ? d0 : e0;
    }

    @Override // d.a.k0.x.e0.b, d.a.j0.r.q.a
    public v0 h() {
        v0 h2 = super.h();
        if (h2 != null) {
            h2.p(this.U);
        }
        return h2;
    }

    @Override // d.a.k0.x.e0.b, d.a.j0.r.q.a
    public a2 m() {
        return this.c0;
    }
}
