package d.b.i0.b1.c;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes3.dex */
public class b implements d.b.b.j.e.n {
    public static final BdUniqueId j = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public String f52095e;

    /* renamed from: f  reason: collision with root package name */
    public long f52096f;

    /* renamed from: g  reason: collision with root package name */
    public String f52097g;

    /* renamed from: h  reason: collision with root package name */
    public String f52098h;
    public String i;

    public long a() {
        return this.f52096f;
    }

    public String e() {
        return this.f52095e;
    }

    public String f() {
        return this.f52097g;
    }

    public String g() {
        return this.f52098h;
    }

    @Override // d.b.b.j.e.n
    public BdUniqueId getType() {
        return j;
    }

    public String j() {
        return this.i;
    }

    public void k(TopicList topicList) {
        if (topicList != null) {
            this.f52096f = topicList.topic_id.longValue();
            this.f52097g = topicList.topic_name;
            topicList.tag.intValue();
            topicList.discuss_num.longValue();
            this.f52098h = topicList.topic_desc;
            this.i = topicList.topic_pic;
        }
    }

    public void l(TopicListModule topicListModule) {
        try {
            this.f52095e = topicListModule.module_title;
            String str = topicListModule.tips;
            String str2 = topicListModule.rule_jump_url;
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }
}
