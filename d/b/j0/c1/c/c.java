package d.b.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.b.c.j.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f53921e;

    /* renamed from: f  reason: collision with root package name */
    public String f53922f;

    /* renamed from: g  reason: collision with root package name */
    public String f53923g;

    /* renamed from: h  reason: collision with root package name */
    public int f53924h = -1;
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
        return this.f53921e;
    }

    public String g() {
        return this.j;
    }

    @Override // d.b.c.j.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String j() {
        return this.f53923g;
    }

    public int k() {
        return this.k;
    }

    public String l() {
        return this.f53922f;
    }

    public int n() {
        return this.f53924h;
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
            this.f53921e = topicListModule.module_title;
            this.f53922f = topicListModule.tips;
            this.f53923g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void q(int i) {
        this.f53924h = i;
    }
}
