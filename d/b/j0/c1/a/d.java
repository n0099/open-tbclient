package d.b.j0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.b.j0.c1.c.m;
import d.b.j0.c1.c.n;
import d.b.j0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f53833a;

    /* renamed from: b  reason: collision with root package name */
    public i f53834b;

    /* renamed from: c  reason: collision with root package name */
    public g f53835c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f53836d;

    /* renamed from: e  reason: collision with root package name */
    public e f53837e;

    /* renamed from: f  reason: collision with root package name */
    public f f53838f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f53839g;

    /* renamed from: h  reason: collision with root package name */
    public h f53840h;
    public List<d.b.c.j.e.a> i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f53837e = new e(hotTopicActivity, d.b.j0.c1.c.g.f53937f);
        this.f53834b = new i(hotTopicActivity, m.p);
        this.f53835c = new g(hotTopicActivity, d.b.j0.c1.c.i.p);
        this.f53836d = new RelateCardForumAdapter(hotTopicActivity, n.f53960g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f53838f = new f(pageContext, d.b.j0.x.e0.k.l0);
        this.f53839g = new HomePageVideoThreadAdapter(pageContext, l.V);
        this.f53840h = new h(pageContext, d.b.j0.x.e0.k.o0);
        this.i.add(this.f53834b);
        this.i.add(this.f53835c);
        this.i.add(this.f53836d);
        this.i.add(this.f53837e);
        this.i.add(this.f53838f);
        this.i.add(this.f53839g);
        this.i.add(this.f53840h);
        this.f53833a = bdTypeListView;
        bdTypeListView.a(this.i);
    }

    public void b() {
        if (this.f53833a.getAdapter2() instanceof d.b.c.j.e.e) {
            this.f53833a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f53838f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.b.j0.c1.c.e eVar) {
        ArrayList<d.b.c.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f53833a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
