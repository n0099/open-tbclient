package d.a.n0.d1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class b implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52554e;

    /* renamed from: f  reason: collision with root package name */
    public long f52555f;

    /* renamed from: g  reason: collision with root package name */
    public String f52556g;

    /* renamed from: h  reason: collision with root package name */
    public String f52557h;

    /* renamed from: i  reason: collision with root package name */
    public String f52558i;

    public long c() {
        return this.f52555f;
    }

    public String e() {
        return this.f52554e;
    }

    public String f() {
        return this.f52556g;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f52557h;
    }

    public String i() {
        return this.f52558i;
    }

    public void k(TopicList topicList) {
        if (topicList != null) {
            this.f52555f = topicList.topic_id.longValue();
            this.f52556g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f52557h = topicList.topic_desc;
            this.f52558i = topicList.topic_pic;
        }
    }

    public void l(TopicListModule topicListModule) {
        try {
            this.f52554e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
