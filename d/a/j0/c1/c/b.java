package d.a.j0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class b implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f51675e;

    /* renamed from: f  reason: collision with root package name */
    public long f51676f;

    /* renamed from: g  reason: collision with root package name */
    public String f51677g;

    /* renamed from: h  reason: collision with root package name */
    public String f51678h;

    /* renamed from: i  reason: collision with root package name */
    public String f51679i;

    public long c() {
        return this.f51676f;
    }

    public String e() {
        return this.f51675e;
    }

    public String f() {
        return this.f51677g;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f51678h;
    }

    public String i() {
        return this.f51679i;
    }

    public void k(TopicList topicList) {
        if (topicList != null) {
            this.f51676f = topicList.topic_id.longValue();
            this.f51677g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f51678h = topicList.topic_desc;
            this.f51679i = topicList.topic_pic;
        }
    }

    public void l(TopicListModule topicListModule) {
        try {
            this.f51675e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
