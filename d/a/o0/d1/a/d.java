package d.a.o0.d1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.o0.d1.c.m;
import d.a.o0.d1.c.n;
import d.a.o0.z.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56280a;

    /* renamed from: b  reason: collision with root package name */
    public i f56281b;

    /* renamed from: c  reason: collision with root package name */
    public g f56282c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f56283d;

    /* renamed from: e  reason: collision with root package name */
    public e f56284e;

    /* renamed from: f  reason: collision with root package name */
    public f f56285f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f56286g;

    /* renamed from: h  reason: collision with root package name */
    public h f56287h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56288i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f56284e = new e(hotTopicActivity, d.a.o0.d1.c.g.f56392f);
        this.f56281b = new i(hotTopicActivity, m.p);
        this.f56282c = new g(hotTopicActivity, d.a.o0.d1.c.i.p);
        this.f56283d = new RelateCardForumAdapter(hotTopicActivity, n.f56417g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f56285f = new f(pageContext, d.a.o0.z.e0.k.r0);
        this.f56286g = new HomePageVideoThreadAdapter(pageContext, l.W);
        this.f56287h = new h(pageContext, d.a.o0.z.e0.k.u0);
        this.f56288i.add(this.f56281b);
        this.f56288i.add(this.f56282c);
        this.f56288i.add(this.f56283d);
        this.f56288i.add(this.f56284e);
        this.f56288i.add(this.f56285f);
        this.f56288i.add(this.f56286g);
        this.f56288i.add(this.f56287h);
        this.f56280a = bdTypeListView;
        bdTypeListView.a(this.f56288i);
    }

    public void b() {
        if (this.f56280a.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f56280a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f56285f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.a.o0.d1.c.e eVar) {
        ArrayList<d.a.c.k.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f56280a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
