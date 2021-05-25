package d.a.n0.e1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f52785a;

    /* renamed from: b  reason: collision with root package name */
    public int f52786b = -1;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f52787c = new ArrayList();

    public String a() {
        return this.f52785a;
    }

    public List<d> b() {
        return this.f52787c;
    }

    public int c() {
        return this.f52786b;
    }

    public void d(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.f52785a = topicListModule.module_title;
            List<TopicList> list = topicListModule.topic_list;
            if (list == null) {
                return;
            }
            int count = ListUtils.getCount(list);
            for (int i2 = 0; i2 < count; i2++) {
                d dVar = new d();
                TopicList topicList = (TopicList) ListUtils.getItem(topicListModule.topic_list, i2);
                if (topicList != null) {
                    dVar.c(topicList);
                    if (!k.isEmptyStringAfterTrim(dVar.b())) {
                        this.f52787c.add(dVar);
                    }
                }
            }
        }
    }

    public void e(String str) {
        this.f52785a = str;
    }

    public void f(int i2) {
        this.f52786b = i2;
    }
}
