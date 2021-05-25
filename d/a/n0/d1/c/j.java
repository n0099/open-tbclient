package d.a.n0.d1.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
import tbclient.TopicList.DataRes;
import tbclient.TopicList.NewTopicList;
import tbclient.TopicList.TabList;
import tbclient.TopicList.TopicList;
import tbclient.TopicList.TopicListModule;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f52586a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f52587b;

    /* renamed from: c  reason: collision with root package name */
    public o f52588c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f52589d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f52590e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f52591f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f52592g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f52593h;

    public List<TopicList> a() {
        return this.f52591f;
    }

    public ArrayList<d.a.c.j.e.n> b() {
        return d();
    }

    public void c(DataRes dataRes) {
        List<TopicList> list;
        List<TopicList> list2;
        if (dataRes == null) {
            return;
        }
        List<TabList> list3 = dataRes.tab_list;
        if (list3 != null && !ListUtils.isEmpty(list3)) {
            this.f52587b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.c(tabList);
                this.f52587b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f52588c = oVar;
            oVar.c(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f52590e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.l(dataRes.topic_manual);
                bVar.k(dataRes.topic_manual.topic_list.get(i2));
                this.f52590e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f52589d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.p(dataRes.topic_bang);
                cVar.o(dataRes.topic_bang.topic_list.get(i3));
                this.f52589d.add(cVar);
            }
        }
        this.f52591f = dataRes.frs_tab_topic;
        this.f52593h = dataRes.topic_list;
    }

    public final ArrayList<d.a.c.j.e.n> d() {
        this.f52592g = new ArrayList<>();
        o oVar = this.f52588c;
        if (oVar != null && (!StringUtils.isNull(oVar.f52608g) || !StringUtils.isNull(this.f52588c.f52609h))) {
            this.f52592g.add(this.f52588c);
        }
        List<b> list = this.f52590e;
        int i2 = 0;
        if (list != null && list.size() > 0) {
            int size = this.f52590e.size() == 1 ? this.f52590e.size() : 1;
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f52590e.get(i3);
                if (bVar != null && (!StringUtils.isNull(bVar.i()) || !StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.f()))) {
                    this.f52592g.add(this.f52590e.get(i3));
                }
            }
        }
        List<c> list2 = this.f52589d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f52589d.size() <= 20 ? this.f52589d.size() : 20;
            while (i2 < size2) {
                c cVar = this.f52589d.get(i2);
                i2++;
                cVar.q(i2);
                this.f52592g.add(cVar);
            }
        }
        return this.f52592g;
    }
}
