package d.b.j0.c1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.b.c.j.e.n;
import d.b.j0.c1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f53823a;

    /* renamed from: b  reason: collision with root package name */
    public c f53824b;

    /* renamed from: c  reason: collision with root package name */
    public b f53825c;

    /* renamed from: d  reason: collision with root package name */
    public k f53826d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.b.c.j.e.a> f53827e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f53824b = new c(hotRanklistActivity, d.b.j0.c1.c.c.m);
        this.f53825c = new b(hotRanklistActivity, d.b.j0.c1.c.b.j);
        this.f53826d = new k(hotRanklistActivity, o.k);
        this.f53827e.add(this.f53824b);
        this.f53827e.add(this.f53825c);
        this.f53827e.add(this.f53826d);
        this.f53823a = bdTypeListView;
        bdTypeListView.a(this.f53827e);
    }

    public void b(d.b.j0.c1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f53826d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f53824b;
        if (cVar != null) {
            cVar.p0(str);
        }
        BdTypeListView bdTypeListView = this.f53823a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
