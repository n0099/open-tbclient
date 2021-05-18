package d.a.k0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.hottopic.adapter.HomePageVideoThreadAdapter;
import com.baidu.tieba.hottopic.adapter.RelateCardForumAdapter;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import d.a.k0.c1.c.m;
import d.a.k0.c1.c.n;
import d.a.k0.x.e0.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52286a;

    /* renamed from: b  reason: collision with root package name */
    public i f52287b;

    /* renamed from: c  reason: collision with root package name */
    public g f52288c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f52289d;

    /* renamed from: e  reason: collision with root package name */
    public e f52290e;

    /* renamed from: f  reason: collision with root package name */
    public f f52291f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f52292g;

    /* renamed from: h  reason: collision with root package name */
    public h f52293h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52294i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f52290e = new e(hotTopicActivity, d.a.k0.c1.c.g.f52398f);
        this.f52287b = new i(hotTopicActivity, m.p);
        this.f52288c = new g(hotTopicActivity, d.a.k0.c1.c.i.p);
        this.f52289d = new RelateCardForumAdapter(hotTopicActivity, n.f52423g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f52291f = new f(pageContext, d.a.k0.x.e0.k.m0);
        this.f52292g = new HomePageVideoThreadAdapter(pageContext, l.W);
        this.f52293h = new h(pageContext, d.a.k0.x.e0.k.p0);
        this.f52294i.add(this.f52287b);
        this.f52294i.add(this.f52288c);
        this.f52294i.add(this.f52289d);
        this.f52294i.add(this.f52290e);
        this.f52294i.add(this.f52291f);
        this.f52294i.add(this.f52292g);
        this.f52294i.add(this.f52293h);
        this.f52286a = bdTypeListView;
        bdTypeListView.a(this.f52294i);
    }

    public void b() {
        if (this.f52286a.getAdapter2() instanceof d.a.c.j.e.e) {
            this.f52286a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f52291f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.a.k0.c1.c.e eVar) {
        ArrayList<d.a.c.j.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f52286a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
