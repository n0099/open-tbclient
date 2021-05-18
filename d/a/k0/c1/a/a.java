package d.a.k0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.j.e.n;
import d.a.k0.c1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52276a;

    /* renamed from: b  reason: collision with root package name */
    public c f52277b;

    /* renamed from: c  reason: collision with root package name */
    public b f52278c;

    /* renamed from: d  reason: collision with root package name */
    public k f52279d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52280e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f52277b = new c(hotRanklistActivity, d.a.k0.c1.c.c.m);
        this.f52278c = new b(hotRanklistActivity, d.a.k0.c1.c.b.j);
        this.f52279d = new k(hotRanklistActivity, o.k);
        this.f52280e.add(this.f52277b);
        this.f52280e.add(this.f52278c);
        this.f52280e.add(this.f52279d);
        this.f52276a = bdTypeListView;
        bdTypeListView.a(this.f52280e);
    }

    public void b(d.a.k0.c1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f52279d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f52277b;
        if (cVar != null) {
            cVar.n0(str);
        }
        BdTypeListView bdTypeListView = this.f52276a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
