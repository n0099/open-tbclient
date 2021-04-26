package d.a.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.a.c.j.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51680e;

    /* renamed from: f  reason: collision with root package name */
    public String f51681f;

    /* renamed from: g  reason: collision with root package name */
    public String f51682g;

    /* renamed from: h  reason: collision with root package name */
    public int f51683h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f51684i;
    public String j;
    public int k;
    public long l;

    public long c() {
        return this.l;
    }

    public long e() {
        return this.f51684i;
    }

    public String f() {
        return this.f51680e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.f51682g;
    }

    public int k() {
        return this.k;
    }

    public String l() {
        return this.f51681f;
    }

    public int m() {
        return this.f51683h;
    }

    public void o(TopicList topicList) {
        if (topicList != null) {
            this.f51684i = topicList.topic_id.longValue();
            this.j = topicList.topic_name;
            this.k = topicList.tag.intValue();
            this.l = topicList.discuss_num.longValue();
            String str = topicList.topic_desc;
            String str2 = topicList.topic_pic;
        }
    }

    public void p(TopicListModule topicListModule) {
        try {
            this.f51680e = topicListModule.module_title;
            this.f51681f = topicListModule.tips;
            this.f51682g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void q(int i2) {
        this.f51683h = i2;
    }
}
