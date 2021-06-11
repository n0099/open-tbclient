package d.a.n0.d1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.k.e.n;
import d.a.n0.d1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56145a;

    /* renamed from: b  reason: collision with root package name */
    public c f56146b;

    /* renamed from: c  reason: collision with root package name */
    public b f56147c;

    /* renamed from: d  reason: collision with root package name */
    public k f56148d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56149e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f56146b = new c(hotRanklistActivity, d.a.n0.d1.c.c.m);
        this.f56147c = new b(hotRanklistActivity, d.a.n0.d1.c.b.j);
        this.f56148d = new k(hotRanklistActivity, o.k);
        this.f56149e.add(this.f56146b);
        this.f56149e.add(this.f56147c);
        this.f56149e.add(this.f56148d);
        this.f56145a = bdTypeListView;
        bdTypeListView.a(this.f56149e);
    }

    public void b(d.a.n0.d1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f56148d;
        if (kVar != null) {
            kVar.D0();
        }
        c cVar = this.f56146b;
        if (cVar != null) {
            cVar.m0(str);
        }
        BdTypeListView bdTypeListView = this.f56145a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
