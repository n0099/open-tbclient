package d.a.n0.d1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.j.e.n;
import d.a.n0.d1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f52456a;

    /* renamed from: b  reason: collision with root package name */
    public c f52457b;

    /* renamed from: c  reason: collision with root package name */
    public b f52458c;

    /* renamed from: d  reason: collision with root package name */
    public k f52459d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.j.e.a> f52460e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f52457b = new c(hotRanklistActivity, d.a.n0.d1.c.c.m);
        this.f52458c = new b(hotRanklistActivity, d.a.n0.d1.c.b.j);
        this.f52459d = new k(hotRanklistActivity, o.k);
        this.f52460e.add(this.f52457b);
        this.f52460e.add(this.f52458c);
        this.f52460e.add(this.f52459d);
        this.f52456a = bdTypeListView;
        bdTypeListView.a(this.f52460e);
    }

    public void b(d.a.n0.d1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f52459d;
        if (kVar != null) {
            kVar.C0();
        }
        c cVar = this.f52457b;
        if (cVar != null) {
            cVar.n0(str);
        }
        BdTypeListView bdTypeListView = this.f52456a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
