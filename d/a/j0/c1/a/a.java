package d.a.j0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.j.e.n;
import d.a.j0.c1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f51577a;

    /* renamed from: b  reason: collision with root package name */
    public c f51578b;

    /* renamed from: c  reason: collision with root package name */
    public b f51579c;

    /* renamed from: d  reason: collision with root package name */
    public k f51580d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f51581e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f51578b = new c(hotRanklistActivity, d.a.j0.c1.c.c.m);
        this.f51579c = new b(hotRanklistActivity, d.a.j0.c1.c.b.j);
        this.f51580d = new k(hotRanklistActivity, o.k);
        this.f51581e.add(this.f51578b);
        this.f51581e.add(this.f51579c);
        this.f51581e.add(this.f51580d);
        this.f51577a = bdTypeListView;
        bdTypeListView.a(this.f51581e);
    }

    public void b(d.a.j0.c1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f51580d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f51578b;
        if (cVar != null) {
            cVar.n0(str);
        }
        BdTypeListView bdTypeListView = this.f51577a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
