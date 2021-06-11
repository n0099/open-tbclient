package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class b implements d.a.c.k.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f56243e;

    /* renamed from: f  reason: collision with root package name */
    public long f56244f;

    /* renamed from: g  reason: collision with root package name */
    public String f56245g;

    /* renamed from: h  reason: collision with root package name */
    public String f56246h;

    /* renamed from: i  reason: collision with root package name */
    public String f56247i;

    public long b() {
        return this.f56244f;
    }

    public String c() {
        return this.f56243e;
    }

    public String e() {
        return this.f56245g;
    }

    public String g() {
        return this.f56246h;
    }

    @Override // d.a.c.k.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f56247i;
    }

    public void i(TopicList topicList) {
        if (topicList != null) {
            this.f56244f = topicList.topic_id.longValue();
            this.f56245g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f56246h = topicList.topic_desc;
            this.f56247i = topicList.topic_pic;
        }
    }

    public void k(TopicListModule topicListModule) {
        try {
            this.f56243e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
