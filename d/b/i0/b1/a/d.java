package d.b.i0.b1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.i0.b1.c.m;
import d.b.i0.b1.c.n;
import d.b.i0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52010a;

    /* renamed from: b  reason: collision with root package name */
    public i f52011b;

    /* renamed from: c  reason: collision with root package name */
    public g f52012c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f52013d;

    /* renamed from: e  reason: collision with root package name */
    public e f52014e;

    /* renamed from: f  reason: collision with root package name */
    public f f52015f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f52016g;

    /* renamed from: h  reason: collision with root package name */
    public h f52017h;
    public List<d.b.b.j.e.a> i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f52014e = new e(hotTopicActivity, d.b.i0.b1.c.g.f52114f);
        this.f52011b = new i(hotTopicActivity, m.p);
        this.f52012c = new g(hotTopicActivity, d.b.i0.b1.c.i.p);
        this.f52013d = new RelateCardForumAdapter(hotTopicActivity, n.f52137g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f52015f = new f(pageContext, d.b.i0.x.e0.k.l0);
        this.f52016g = new HomePageVideoThreadAdapter(pageContext, l.V);
        this.f52017h = new h(pageContext, d.b.i0.x.e0.k.o0);
        this.i.add(this.f52011b);
        this.i.add(this.f52012c);
        this.i.add(this.f52013d);
        this.i.add(this.f52014e);
        this.i.add(this.f52015f);
        this.i.add(this.f52016g);
        this.i.add(this.f52017h);
        this.f52010a = bdTypeListView;
        bdTypeListView.a(this.i);
    }

    public void b() {
        if (this.f52010a.getAdapter2() instanceof d.b.b.j.e.e) {
            this.f52010a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f52015f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.b.i0.b1.c.e eVar) {
        ArrayList<d.b.b.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f52010a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
