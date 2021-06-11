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
    public BdTypeListView f56155a;

    /* renamed from: b  reason: collision with root package name */
    public i f56156b;

    /* renamed from: c  reason: collision with root package name */
    public g f56157c;

    /* renamed from: d  reason: collision with root package name */
    public RelateCardForumAdapter f56158d;

    /* renamed from: e  reason: collision with root package name */
    public e f56159e;

    /* renamed from: f  reason: collision with root package name */
    public f f56160f;

    /* renamed from: g  reason: collision with root package name */
    public HomePageVideoThreadAdapter f56161g;

    /* renamed from: h  reason: collision with root package name */
    public h f56162h;

    /* renamed from: i  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56163i = new ArrayList();

    public d(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        a(hotTopicActivity, bdTypeListView);
    }

    public final void a(HotTopicActivity hotTopicActivity, BdTypeListView bdTypeListView) {
        this.f56159e = new e(hotTopicActivity, d.a.n0.d1.c.g.f56267f);
        this.f56156b = new i(hotTopicActivity, m.p);
        this.f56157c = new g(hotTopicActivity, d.a.n0.d1.c.i.p);
        this.f56158d = new RelateCardForumAdapter(hotTopicActivity, n.f56292g);
        TbPageContext<HotTopicActivity> pageContext = hotTopicActivity.getPageContext();
        this.f56160f = new f(pageContext, d.a.n0.z.e0.k.m0);
        this.f56161g = new HomePageVideoThreadAdapter(pageContext, l.W);
        this.f56162h = new h(pageContext, d.a.n0.z.e0.k.p0);
        this.f56163i.add(this.f56156b);
        this.f56163i.add(this.f56157c);
        this.f56163i.add(this.f56158d);
        this.f56163i.add(this.f56159e);
        this.f56163i.add(this.f56160f);
        this.f56163i.add(this.f56161g);
        this.f56163i.add(this.f56162h);
        this.f56155a = bdTypeListView;
        bdTypeListView.a(this.f56163i);
    }

    public void b() {
        if (this.f56155a.getAdapter2() instanceof d.a.c.k.e.e) {
            this.f56155a.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c(boolean z) {
        f fVar = this.f56160f;
        if (fVar != null) {
            fVar.setFromCDN(z);
        }
    }

    public void d(d.a.n0.d1.c.e eVar) {
        ArrayList<d.a.c.k.e.n> arrayList;
        if (eVar.i() != null) {
            arrayList = eVar.i();
        } else {
            arrayList = new ArrayList<>();
        }
        BdTypeListView bdTypeListView = this.f56155a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
