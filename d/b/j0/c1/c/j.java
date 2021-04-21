package d.b.j0.c1.c;

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
    public String f53944a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f53945b;

    /* renamed from: c  reason: collision with root package name */
    public o f53946c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f53947d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f53948e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f53949f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.c.j.e.n> f53950g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f53951h;

    public List<TopicList> a() {
        return this.f53949f;
    }

    public ArrayList<d.b.c.j.e.n> b() {
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
            this.f53945b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f53945b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f53946c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f53948e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                b bVar = new b();
                bVar.l(dataRes.topic_manual);
                bVar.k(dataRes.topic_manual.topic_list.get(i));
                this.f53948e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f53947d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                c cVar = new c();
                cVar.p(dataRes.topic_bang);
                cVar.o(dataRes.topic_bang.topic_list.get(i2));
                this.f53947d.add(cVar);
            }
        }
        this.f53949f = dataRes.frs_tab_topic;
        this.f53951h = dataRes.topic_list;
    }

    public final ArrayList<d.b.c.j.e.n> d() {
        this.f53950g = new ArrayList<>();
        o oVar = this.f53946c;
        if (oVar != null && (!StringUtils.isNull(oVar.f53965g) || !StringUtils.isNull(this.f53946c.f53966h))) {
            this.f53950g.add(this.f53946c);
        }
        List<b> list = this.f53948e;
        int i = 0;
        if (list != null && list.size() > 0) {
            int size = this.f53948e.size() == 1 ? this.f53948e.size() : 1;
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f53948e.get(i2);
                if (bVar != null && (!StringUtils.isNull(bVar.j()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.f()))) {
                    this.f53950g.add(this.f53948e.get(i2));
                }
            }
        }
        List<c> list2 = this.f53947d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f53947d.size() <= 20 ? this.f53947d.size() : 20;
            while (i < size2) {
                c cVar = this.f53947d.get(i);
                i++;
                cVar.q(i);
                this.f53950g.add(cVar);
            }
        }
        return this.f53950g;
    }
}
