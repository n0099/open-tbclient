package d.b.i0.c1.c;

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
    public String f53523a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f53524b;

    /* renamed from: c  reason: collision with root package name */
    public o f53525c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f53526d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f53527e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f53528f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.c.j.e.n> f53529g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f53530h;

    public List<TopicList> a() {
        return this.f53528f;
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
            this.f53524b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f53524b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f53525c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f53527e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                b bVar = new b();
                bVar.l(dataRes.topic_manual);
                bVar.k(dataRes.topic_manual.topic_list.get(i));
                this.f53527e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f53526d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                c cVar = new c();
                cVar.p(dataRes.topic_bang);
                cVar.o(dataRes.topic_bang.topic_list.get(i2));
                this.f53526d.add(cVar);
            }
        }
        this.f53528f = dataRes.frs_tab_topic;
        this.f53530h = dataRes.topic_list;
    }

    public final ArrayList<d.b.c.j.e.n> d() {
        this.f53529g = new ArrayList<>();
        o oVar = this.f53525c;
        if (oVar != null && (!StringUtils.isNull(oVar.f53544g) || !StringUtils.isNull(this.f53525c.f53545h))) {
            this.f53529g.add(this.f53525c);
        }
        List<b> list = this.f53527e;
        int i = 0;
        if (list != null && list.size() > 0) {
            int size = this.f53527e.size() == 1 ? this.f53527e.size() : 1;
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f53527e.get(i2);
                if (bVar != null && (!StringUtils.isNull(bVar.j()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.f()))) {
                    this.f53529g.add(this.f53527e.get(i2));
                }
            }
        }
        List<c> list2 = this.f53526d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f53526d.size() <= 20 ? this.f53526d.size() : 20;
            while (i < size2) {
                c cVar = this.f53526d.get(i);
                i++;
                cVar.q(i);
                this.f53529g.add(cVar);
            }
        }
        return this.f53529g;
    }
}
