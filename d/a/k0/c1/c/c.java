package d.a.k0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.a.c.j.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52379e;

    /* renamed from: f  reason: collision with root package name */
    public String f52380f;

    /* renamed from: g  reason: collision with root package name */
    public String f52381g;

    /* renamed from: h  reason: collision with root package name */
    public int f52382h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f52383i;
    public String j;
    public int k;
    public long l;

    public long c() {
        return this.l;
    }

    public long e() {
        return this.f52383i;
    }

    public String f() {
        return this.f52379e;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.f52381g;
    }

    public int k() {
        return this.k;
    }

    public String l() {
        return this.f52380f;
    }

    public int m() {
        return this.f52382h;
    }

    public void o(TopicList topicList) {
        if (topicList != null) {
            this.f52383i = topicList.topic_id.longValue();
            this.j = topicList.topic_name;
            this.k = topicList.tag.intValue();
            this.l = topicList.discuss_num.longValue();
            String str = topicList.topic_desc;
            String str2 = topicList.topic_pic;
        }
    }

    public void p(TopicListModule topicListModule) {
        try {
            this.f52379e = topicListModule.module_title;
            this.f52380f = topicListModule.tips;
            this.f52381g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void q(int i2) {
        this.f52382h = i2;
    }
}
