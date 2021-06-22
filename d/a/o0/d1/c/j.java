package d.a.o0.d1.c;

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
    public String f56400a;

    /* renamed from: b  reason: collision with root package name */
    public List<p> f56401b;

    /* renamed from: c  reason: collision with root package name */
    public o f56402c;

    /* renamed from: d  reason: collision with root package name */
    public List<c> f56403d;

    /* renamed from: e  reason: collision with root package name */
    public List<b> f56404e;

    /* renamed from: f  reason: collision with root package name */
    public List<TopicList> f56405f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f56406g = null;

    /* renamed from: h  reason: collision with root package name */
    public List<NewTopicList> f56407h;

    public List<TopicList> a() {
        return this.f56405f;
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
            this.f56401b = new ArrayList();
            for (TabList tabList : dataRes.tab_list) {
                p pVar = new p();
                pVar.b(tabList);
                this.f56401b.add(pVar);
            }
        }
        if (dataRes.media_topic != null) {
            o oVar = new o();
            this.f56402c = oVar;
            oVar.b(dataRes.media_topic);
        }
        TopicListModule topicListModule = dataRes.topic_manual;
        if (topicListModule != null && (list2 = topicListModule.topic_list) != null && list2.size() > 0) {
            this.f56404e = new ArrayList();
            for (int i2 = 0; i2 < dataRes.topic_manual.topic_list.size(); i2++) {
                b bVar = new b();
                bVar.k(dataRes.topic_manual);
                bVar.i(dataRes.topic_manual.topic_list.get(i2));
                this.f56404e.add(bVar);
            }
        }
        TopicListModule topicListModule2 = dataRes.topic_bang;
        if (topicListModule2 != null && (list = topicListModule2.topic_list) != null && list.size() > 0) {
            this.f56403d = new ArrayList();
            for (int i3 = 0; i3 < dataRes.topic_bang.topic_list.size(); i3++) {
                c cVar = new c();
                cVar.o(dataRes.topic_bang);
                cVar.n(dataRes.topic_bang.topic_list.get(i3));
                this.f56403d.add(cVar);
            }
        }
        this.f56405f = dataRes.frs_tab_topic;
        this.f56407h = dataRes.topic_list;
    }

    public final ArrayList<d.a.c.k.e.n> d() {
        this.f56406g = new ArrayList<>();
        o oVar = this.f56402c;
        if (oVar != null && (!StringUtils.isNull(oVar.f56422g) || !StringUtils.isNull(this.f56402c.f56423h))) {
            this.f56406g.add(this.f56402c);
        }
        List<b> list = this.f56404e;
        int i2 = 0;
        if (list != null && list.size() > 0) {
            int size = this.f56404e.size() == 1 ? this.f56404e.size() : 1;
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.f56404e.get(i3);
                if (bVar != null && (!StringUtils.isNull(bVar.h()) || !StringUtils.isNull(bVar.g()) || !StringUtils.isNull(bVar.e()))) {
                    this.f56406g.add(this.f56404e.get(i3));
                }
            }
        }
        List<c> list2 = this.f56403d;
        if (list2 != null && list2.size() > 0) {
            int size2 = this.f56403d.size() <= 20 ? this.f56403d.size() : 20;
            while (i2 < size2) {
                c cVar = this.f56403d.get(i2);
                i2++;
                cVar.p(i2);
                this.f56406g.add(cVar);
            }
        }
        return this.f56406g;
    }
}
