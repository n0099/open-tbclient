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
/* loaded from: classes3.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f52122a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f52123b;

    /* renamed from: c  reason: collision with root package name */
    public o f52124c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f52125d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f52126e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f52127f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.b.b.j.e.n> f52128g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f52129h;

    public List<TopicList> a() {
        return this.f52127f;
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
            this.f52123b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.a(tabList);
                this.f52123b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f52124c = oVar;
            oVar.a(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f52126e = new ArrayList();
            for (int i = 0; i < dataRes.topic_manual.topic_list.size(); i++) {
                b bVar = new b();
                bVar.l(dataRes.topic_manual);
                bVar.k(dataRes.topic_manual.topic_list.get(i));
                this.f52126e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f52125d = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_bang.topic_list.size(); i2++) {
                c cVar = new c();
                cVar.p(dataRes.topic_bang);
                cVar.o(dataRes.topic_bang.topic_list.get(i2));
                this.f52125d.add(cVar);
            }
        }
        this.f52127f = dataRes.frs_tab_topic;
        this.f52129h = dataRes.topic_list;
    }

    public final ArrayList<d.b.b.j.e.n> d() {
        this.f52128g = new ArrayList<>();
        o oVar = this.f52124c;
        if (oVar != null && (!StringUtils.isNull(oVar.f52143g) || !StringUtils.isNull(this.f52124c.f52144h))) {
            this.f52128g.add(this.f52124c);
        }
        List<b> list = this.f52126e;
        int i = 0;
        if (list != null && list.size() > 0) {
            int size = this.f52126e.size() == 1 ? this.f52126e.size() : 1;
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.f52126e.get(i2);
                if (bVar != null && (!StringUtils.isNull(bVar.j()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.f()))) {
                    this.f52128g.add(this.f52126e.get(i2));
                }
            }
        }
        List<c> list2 = this.f52125d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f52125d.size() <= 20 ? this.f52125d.size() : 20;
            while (i < size2) {
                c cVar = this.f52125d.get(i);
                i++;
                cVar.q(i);
                this.f52128g.add(cVar);
            }
        }
        return this.f52128g;
    }
}
