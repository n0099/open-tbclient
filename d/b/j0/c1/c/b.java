package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class b implements d.b.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53917e;

    /* renamed from: f  reason: collision with root package name */
    public long f53918f;

    /* renamed from: g  reason: collision with root package name */
    public String f53919g;

    /* renamed from: h  reason: collision with root package name */
    public String f53920h;
    public String i;

    public long a() {
        return this.f53918f;
    }

    public String e() {
        return this.f53917e;
    }

    public String f() {
        return this.f53919g;
    }

    public String g() {
        return this.f53920h;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String j() {
        return this.i;
    }

    public void k(TopicList topicList) {
        if (topicList != null) {
            this.f53918f = topicList.topic_id.longValue();
            this.f53919g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f53920h = topicList.topic_desc;
            this.i = topicList.topic_pic;
        }
    }

    public void l(TopicListModule topicListModule) {
        try {
            this.f53917e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
