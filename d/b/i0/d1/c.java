package d.b.i0.d1;

import GetSugTopic.TopicList;
import GetSugTopic.TopicListModule;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53686a;

    /* renamed from: b  reason: collision with root package name */
    public int f53687b = -1;

    /* renamed from: c  reason: collision with root package name */
    public List<d> f53688c = new ArrayList();

    public String a() {
        return this.f53686a;
    }

    public List<d> b() {
        return this.f53688c;
    }

    public int c() {
        return this.f53687b;
    }

    public void d(TopicListModule topicListModule) {
        if (topicListModule != null) {
            this.f53686a = topicListModule.module_title;
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
                        this.f53688c.add(dVar);
                    }
                }
            }
        }
    }

    public void e(String str) {
        this.f53686a = str;
    }

    public void f(int i) {
        this.f53687b = i;
    }
}
