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
    public String f56275a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f56276b;

    /* renamed from: c  reason: collision with root package name */
    public o f56277c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f56278d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f56279e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f56280f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f56281g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f56282h;

    public List<TopicList> a() {
        return this.f56280f;
    }

    public ArrayList<d.a.c.k.e.n> b() {
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
            this.f56276b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.b(tabList);
                this.f56276b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f56277c = oVar;
            oVar.b(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f56279e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.k(dataRes.topic_manual);
                bVar.i(dataRes.topic_manual.topic_list.get(i2));
                this.f56279e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f56278d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.o(dataRes.topic_bang);
                cVar.n(dataRes.topic_bang.topic_list.get(i3));
                this.f56278d.add(cVar);
            }
        }
        this.f56280f = dataRes.frs_tab_topic;
        this.f56282h = dataRes.topic_list;
    }

    public final ArrayList<d.a.c.k.e.n> d() {
        this.f56281g = new ArrayList<>();
        o oVar = this.f56277c;
        if (oVar != null && (!StringUtils.isNull(oVar.f56297g) || !StringUtils.isNull(this.f56277c.f56298h))) {
            this.f56281g.add(this.f56277c);
        }
        List<b> list = this.f56279e;
        int i2 = 0;
        if (list != null && list.size() > 0) {
            int size = this.f56279e.size() == 1 ? this.f56279e.size() : 1;
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f56279e.get(i3);
                if (bVar != null && (!StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.e()))) {
                    this.f56281g.add(this.f56279e.get(i3));
                }
            }
        }
        List<c> list2 = this.f56278d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f56278d.size() <= 20 ? this.f56278d.size() : 20;
            while (i2 < size2) {
                c cVar = this.f56278d.get(i2);
                i2++;
                cVar.p(i2);
                this.f56281g.add(cVar);
            }
        }
        return this.f56281g;
    }
}
