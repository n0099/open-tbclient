package d.b.j0.i0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.j0.i0.k.c.e;
import d.b.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57168a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f57169b;

    /* renamed from: c  reason: collision with root package name */
    public s f57170c;

    /* renamed from: d  reason: collision with root package name */
    public b f57171d;

    /* renamed from: e  reason: collision with root package name */
    public c f57172e;

    /* renamed from: f  reason: collision with root package name */
    public d f57173f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f57174g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f57175h = new C1350a();

    /* renamed from: d.b.j0.i0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1350a extends b0<BaseCardInfo> {
        public C1350a() {
        }

        @Override // d.b.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.b.j0.i0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.b.j0.i0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f57174g) {
                    if (nVar instanceof d.b.j0.i0.k.c.d) {
                        d.b.j0.i0.k.c.d dVar = (d.b.j0.i0.k.c.d) nVar;
                        if (u.equals(dVar.u())) {
                            List<d.b.j0.i0.k.c.c> t = dVar.t();
                            arrayList.add(nVar);
                            arrayList.addAll(t);
                        } else {
                            List<d.b.j0.i0.k.c.c> s = dVar.s();
                            arrayList.add(nVar);
                            arrayList.addAll(s);
                        }
                    }
                }
                e eVar = new e();
                eVar.f57198e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f57170c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f57168a = tbPageContext;
        this.f57170c = sVar;
        c();
        this.f57170c.a(this.f57169b);
    }

    public final void c() {
        this.f57169b = new ArrayList();
        b bVar = new b(this.f57168a);
        this.f57171d = bVar;
        this.f57169b.add(bVar);
        c cVar = new c(this.f57168a, this.f57175h);
        this.f57172e = cVar;
        this.f57169b.add(cVar);
        d dVar = new d(this.f57168a);
        this.f57173f = dVar;
        this.f57169b.add(dVar);
    }

    public void d() {
        s sVar = this.f57170c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f57174g = list;
        this.f57170c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f57169b) {
            aVar.f0(bdUniqueId);
        }
    }
}
