package d.b.i0.b1.c;

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
    public String f52121a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f52122b;

    /* renamed from: c  reason: collision with root package name */
    public o f52123c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f52124d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f52125e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f52126f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.b.j.e.n> f52127g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f52128h;

    public List<TopicList> a() {
        return this.f52126f;
    }

    public ArrayList<d.b.b.j.e.n> b() {
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
            this.f52122b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f52122b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f52123c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f52125e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                b bVar = new b();
                bVar.l(dataRes.topic_manual);
                bVar.k(dataRes.topic_manual.topic_list.get(i));
                this.f52125e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f52124d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                c cVar = new c();
                cVar.p(dataRes.topic_bang);
                cVar.o(dataRes.topic_bang.topic_list.get(i2));
                this.f52124d.add(cVar);
            }
        }
        this.f52126f = dataRes.frs_tab_topic;
        this.f52128h = dataRes.topic_list;
    }

    public final ArrayList<d.b.b.j.e.n> d() {
        this.f52127g = new ArrayList<>();
        o oVar = this.f52123c;
        if (oVar != null && (!StringUtils.isNull(oVar.f52142g) || !StringUtils.isNull(this.f52123c.f52143h))) {
            this.f52127g.add(this.f52123c);
        }
        List<b> list = this.f52125e;
        int i = 0;
        if (list != null && list.size() > 0) {
            int size = this.f52125e.size() == 1 ? this.f52125e.size() : 1;
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f52125e.get(i2);
                if (bVar != null && (!StringUtils.isNull(bVar.j()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.f()))) {
                    this.f52127g.add(this.f52125e.get(i2));
                }
            }
        }
        List<c> list2 = this.f52124d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f52124d.size() <= 20 ? this.f52124d.size() : 20;
            while (i < size2) {
                c cVar = this.f52124d.get(i);
                i++;
                cVar.q(i);
                this.f52127g.add(cVar);
            }
        }
        return this.f52127g;
    }
}
