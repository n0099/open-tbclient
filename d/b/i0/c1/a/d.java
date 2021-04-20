package d.b.i0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.i0.c1.c.m;
import d.b.i0.c1.c.n;
import d.b.i0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f53412a;

    /* renamed from: b  reason: collision with root package name */
    public i f53413b;

    /* renamed from: c  reason: collision with root package name */
    public g f53414c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f53415d;

    /* renamed from: e  reason: collision with root package name */
    public e f53416e;

    /* renamed from: f  reason: collision with root package name */
    public f f53417f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f53418g;

    /* renamed from: h  reason: collision with root package name */
    public h f53419h;
    public List<d.b.c.j.e.a> i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f53416e = new e(hotTopicActivity, d.b.i0.c1.c.g.f53516f);
        this.f53413b = new i(hotTopicActivity, m.p);
        this.f53414c = new g(hotTopicActivity, d.b.i0.c1.c.i.p);
        this.f53415d = new RelateCardForumAdapter(hotTopicActivity, n.f53539g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f53417f = new f(pageContext, d.b.i0.x.e0.k.l0);
        this.f53418g = new HomePageVideoThreadAdapter(pageContext, l.V);
        this.f53419h = new h(pageContext, d.b.i0.x.e0.k.o0);
        this.i.add(this.f53413b);
        this.i.add(this.f53414c);
        this.i.add(this.f53415d);
        this.i.add(this.f53416e);
        this.i.add(this.f53417f);
        this.i.add(this.f53418g);
        this.i.add(this.f53419h);
        this.f53412a = bdTypeListView;
        bdTypeListView.a(this.i);
    }

    public void b() {
        if (this.f53412a.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f53412a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f53417f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.b.i0.c1.c.e eVar) {
        ArrayList<d.b.c.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f53412a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
