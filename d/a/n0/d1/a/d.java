package d.a.n0.d1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.n0.d1.c.m;
import d.a.n0.d1.c.n;
import d.a.n0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52466a;

    /* renamed from: b  reason: collision with root package name */
    public i f52467b;

    /* renamed from: c  reason: collision with root package name */
    public g f52468c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f52469d;

    /* renamed from: e  reason: collision with root package name */
    public e f52470e;

    /* renamed from: f  reason: collision with root package name */
    public f f52471f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f52472g;

    /* renamed from: h  reason: collision with root package name */
    public h f52473h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52474i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f52470e = new e(hotTopicActivity, d.a.n0.d1.c.g.f52578f);
        this.f52467b = new i(hotTopicActivity, m.p);
        this.f52468c = new g(hotTopicActivity, d.a.n0.d1.c.i.p);
        this.f52469d = new RelateCardForumAdapter(hotTopicActivity, n.f52603g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f52471f = new f(pageContext, d.a.n0.z.e0.k.m0);
        this.f52472g = new HomePageVideoThreadAdapter(pageContext, l.W);
        this.f52473h = new h(pageContext, d.a.n0.z.e0.k.p0);
        this.f52474i.add(this.f52467b);
        this.f52474i.add(this.f52468c);
        this.f52474i.add(this.f52469d);
        this.f52474i.add(this.f52470e);
        this.f52474i.add(this.f52471f);
        this.f52474i.add(this.f52472g);
        this.f52474i.add(this.f52473h);
        this.f52466a = bdTypeListView;
        bdTypeListView.a(this.f52474i);
    }

    public void b() {
        if (this.f52466a.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f52466a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f52471f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.a.n0.d1.c.e eVar) {
        ArrayList<d.a.c.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f52466a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
