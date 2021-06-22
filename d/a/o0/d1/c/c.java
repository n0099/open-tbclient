package d.a.o0.d1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.a.c.k.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56373e;

    /* renamed from: f  reason: collision with root package name */
    public String f56374f;

    /* renamed from: g  reason: collision with root package name */
    public String f56375g;

    /* renamed from: h  reason: collision with root package name */
    public int f56376h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f56377i;
    public String j;
    public int k;
    public long l;

    public long b() {
        return this.l;
    }

    public long c() {
        return this.f56377i;
    }

    public String e() {
        return this.f56373e;
    }

    public String g() {
        return this.j;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String h() {
        return this.f56375g;
    }

    public int i() {
        return this.k;
    }

    public String k() {
        return this.f56374f;
    }

    public int l() {
        return this.f56376h;
    }

    public void n(TopicList topicList) {
        if (topicList != null) {
            this.f56377i = topicList.topic_id.longValue();
            this.j = topicList.topic_name;
            this.k = topicList.tag.intValue();
            this.l = topicList.discuss_num.longValue();
            String str = topicList.topic_desc;
            String str2 = topicList.topic_pic;
        }
    }

    public void o(TopicListModule topicListModule) {
        try {
            this.f56373e = topicListModule.module_title;
            this.f56374f = topicListModule.tips;
            this.f56375g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void p(int i2) {
        this.f56376h = i2;
    }
}
