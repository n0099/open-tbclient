package d.a.j0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.j0.c1.c.m;
import d.a.j0.c1.c.n;
import d.a.j0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f51587a;

    /* renamed from: b  reason: collision with root package name */
    public i f51588b;

    /* renamed from: c  reason: collision with root package name */
    public g f51589c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f51590d;

    /* renamed from: e  reason: collision with root package name */
    public e f51591e;

    /* renamed from: f  reason: collision with root package name */
    public f f51592f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f51593g;

    /* renamed from: h  reason: collision with root package name */
    public h f51594h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51595i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f51591e = new e(hotTopicActivity, d.a.j0.c1.c.g.f51699f);
        this.f51588b = new i(hotTopicActivity, m.p);
        this.f51589c = new g(hotTopicActivity, d.a.j0.c1.c.i.p);
        this.f51590d = new RelateCardForumAdapter(hotTopicActivity, n.f51724g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f51592f = new f(pageContext, d.a.j0.x.e0.k.l0);
        this.f51593g = new HomePageVideoThreadAdapter(pageContext, l.V);
        this.f51594h = new h(pageContext, d.a.j0.x.e0.k.o0);
        this.f51595i.add(this.f51588b);
        this.f51595i.add(this.f51589c);
        this.f51595i.add(this.f51590d);
        this.f51595i.add(this.f51591e);
        this.f51595i.add(this.f51592f);
        this.f51595i.add(this.f51593g);
        this.f51595i.add(this.f51594h);
        this.f51587a = bdTypeListView;
        bdTypeListView.a(this.f51595i);
    }

    public void b() {
        if (this.f51587a.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f51587a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f51592f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.a.j0.c1.c.e eVar) {
        ArrayList<d.a.c.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f51587a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
