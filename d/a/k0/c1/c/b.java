package d.a.k0.c1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class b implements d.a.c.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52374e;

    /* renamed from: f  reason: collision with root package name */
    public long f52375f;

    /* renamed from: g  reason: collision with root package name */
    public String f52376g;

    /* renamed from: h  reason: collision with root package name */
    public String f52377h;

    /* renamed from: i  reason: collision with root package name */
    public String f52378i;

    public long c() {
        return this.f52375f;
    }

    public String e() {
        return this.f52374e;
    }

    public String f() {
        return this.f52376g;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String h() {
        return this.f52377h;
    }

    public String i() {
        return this.f52378i;
    }

    public void k(TopicList topicList) {
        if (topicList != null) {
            this.f52375f = topicList.topic_id.longValue();
            this.f52376g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f52377h = topicList.topic_desc;
            this.f52378i = topicList.topic_pic;
        }
    }

    public void l(TopicListModule topicListModule) {
        try {
            this.f52374e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
