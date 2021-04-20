package d.b.i0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.b.c.j.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53500e;

    /* renamed from: f  reason: collision with root package name */
    public String f53501f;

    /* renamed from: g  reason: collision with root package name */
    public String f53502g;

    /* renamed from: h  reason: collision with root package name */
    public int f53503h = -1;
    public long i;
    public String j;
    public int k;
    public long l;

    public long a() {
        return this.l;
    }

    public long e() {
        return this.i;
    }

    public String f() {
        return this.f53500e;
    }

    public String g() {
        return this.j;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String j() {
        return this.f53502g;
    }

    public int k() {
        return this.k;
    }

    public String l() {
        return this.f53501f;
    }

    public int n() {
        return this.f53503h;
    }

    public void o(TopicList topicList) {
        if (topicList != null) {
            this.i = topicList.topic_id.longValue();
            this.j = topicList.topic_name;
            this.k = topicList.tag.intValue();
            this.l = topicList.discuss_num.longValue();
            String str = topicList.topic_desc;
            String str2 = topicList.topic_pic;
        }
    }

    public void p(TopicListModule topicListModule) {
        try {
            this.f53500e = topicListModule.module_title;
            this.f53501f = topicListModule.tips;
            this.f53502g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void q(int i) {
        this.f53503h = i;
    }
}
