package d.b.i0.c1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.b.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f52290a;

    /* renamed from: b  reason: collision with root package name */
    public int f52291b = -1;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f52292c = new ArrayList();

    public String a() {
        return this.f52290a;
    }

    public List<d> b() {
        return this.f52292c;
    }

    public int c() {
        return this.f52291b;
    }

    public void d(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.f52290a = topicListModule.module_title;
            List<TopicList> list = topicListModule.topic_list;
            if (list == null) {
                return;
            }
            int count = ListUtils.getCount(list);
            for (int i = 0; i < count; i++) {
                d dVar = new d();
                TopicList topicList = (TopicList) ListUtils.getItem(topicListModule.topic_list, i);
                if (topicList != null) {
                    dVar.c(topicList);
                    if (!k.isEmptyStringAfterTrim(dVar.b())) {
                        this.f52292c.add(dVar);
                    }
                }
            }
        }
    }

    public void e(String str) {
        this.f52290a = str;
    }

    public void f(int i) {
        this.f52291b = i;
    }
}
