package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class c implements d.a.c.k.e.n {
    public static final BdUniqueId m = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56248e;

    /* renamed from: f  reason: collision with root package name */
    public String f56249f;

    /* renamed from: g  reason: collision with root package name */
    public String f56250g;

    /* renamed from: h  reason: collision with root package name */
    public int f56251h = -1;

    /* renamed from: i  reason: collision with root package name */
    public long f56252i;
    public String j;
    public int k;
    public long l;

    public long b() {
        return this.l;
    }

    public long c() {
        return this.f56252i;
    }

    public String e() {
        return this.f56248e;
    }

    public String g() {
        return this.j;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return m;
    }

    public String h() {
        return this.f56250g;
    }

    public int i() {
        return this.k;
    }

    public String k() {
        return this.f56249f;
    }

    public int l() {
        return this.f56251h;
    }

    public void n(TopicList topicList) {
        if (topicList != null) {
            this.f56252i = topicList.topic_id.longValue();
            this.j = topicList.topic_name;
            this.k = topicList.tag.intValue();
            this.l = topicList.discuss_num.longValue();
            String str = topicList.topic_desc;
            String str2 = topicList.topic_pic;
        }
    }

    public void o(TopicListModule topicListModule) {
        try {
            this.f56248e = topicListModule.module_title;
            this.f56249f = topicListModule.tips;
            this.f56250g = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void p(int i2) {
        this.f56251h = i2;
    }
}
