package d.b.i0.b1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.b.b.j.e.n;
import d.b.i0.b1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52001a;

    /* renamed from: b  reason: collision with root package name */
    public c f52002b;

    /* renamed from: c  reason: collision with root package name */
    public b f52003c;

    /* renamed from: d  reason: collision with root package name */
    public k f52004d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.b.j.e.a> f52005e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f52002b = new c(hotRanklistActivity, d.b.i0.b1.c.c.m);
        this.f52003c = new b(hotRanklistActivity, d.b.i0.b1.c.b.j);
        this.f52004d = new k(hotRanklistActivity, o.k);
        this.f52005e.add(this.f52002b);
        this.f52005e.add(this.f52003c);
        this.f52005e.add(this.f52004d);
        this.f52001a = bdTypeListView;
        bdTypeListView.a(this.f52005e);
    }

    public void b(d.b.i0.b1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f52004d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f52002b;
        if (cVar != null) {
            cVar.p0(str);
        }
        BdTypeListView bdTypeListView = this.f52001a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
