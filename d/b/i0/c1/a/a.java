package d.b.i0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.b.c.j.e.n;
import d.b.i0.c1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f53402a;

    /* renamed from: b  reason: collision with root package name */
    public c f53403b;

    /* renamed from: c  reason: collision with root package name */
    public b f53404c;

    /* renamed from: d  reason: collision with root package name */
    public k f53405d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53406e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f53403b = new c(hotRanklistActivity, d.b.i0.c1.c.c.m);
        this.f53404c = new b(hotRanklistActivity, d.b.i0.c1.c.b.j);
        this.f53405d = new k(hotRanklistActivity, o.k);
        this.f53406e.add(this.f53403b);
        this.f53406e.add(this.f53404c);
        this.f53406e.add(this.f53405d);
        this.f53402a = bdTypeListView;
        bdTypeListView.a(this.f53406e);
    }

    public void b(d.b.i0.c1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f53405d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f53403b;
        if (cVar != null) {
            cVar.p0(str);
        }
        BdTypeListView bdTypeListView = this.f53402a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
