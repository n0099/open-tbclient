package d.a.o0.d1.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.hottopic.controller.HotRanklistActivity;
import d.a.c.k.e.n;
import d.a.o0.d1.c.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdTypeListView f56270a;

    /* renamed from: b  reason: collision with root package name */
    public c f56271b;

    /* renamed from: c  reason: collision with root package name */
    public b f56272c;

    /* renamed from: d  reason: collision with root package name */
    public k f56273d;

    /* renamed from: e  reason: collision with root package name */
    public List<d.a.c.k.e.a> f56274e = new ArrayList();

    public a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        a(hotRanklistActivity, bdTypeListView);
    }

    public final void a(HotRanklistActivity hotRanklistActivity, BdTypeListView bdTypeListView) {
        this.f56271b = new c(hotRanklistActivity, d.a.o0.d1.c.c.m);
        this.f56272c = new b(hotRanklistActivity, d.a.o0.d1.c.b.j);
        this.f56273d = new k(hotRanklistActivity, o.k);
        this.f56274e.add(this.f56271b);
        this.f56274e.add(this.f56272c);
        this.f56274e.add(this.f56273d);
        this.f56270a = bdTypeListView;
        bdTypeListView.a(this.f56274e);
    }

    public void b(d.a.o0.d1.c.j jVar, String str) {
        ArrayList<n> arrayList;
        if (jVar.b() != null) {
            arrayList = jVar.b();
        } else {
            arrayList = new ArrayList<>();
        }
        k kVar = this.f56273d;
        if (kVar != null) {
            kVar.D0();
        }
        c cVar = this.f56271b;
        if (cVar != null) {
            cVar.m0(str);
        }
        BdTypeListView bdTypeListView = this.f56270a;
        if (bdTypeListView != null) {
            bdTypeListView.setData(arrayList);
        }
    }
}
