package d.a.n0.j0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.n0.j0.k.c.e;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55989a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55990b;

    /* renamed from: c  reason: collision with root package name */
    public s f55991c;

    /* renamed from: d  reason: collision with root package name */
    public b f55992d;

    /* renamed from: e  reason: collision with root package name */
    public c f55993e;

    /* renamed from: f  reason: collision with root package name */
    public d f55994f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f55995g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f55996h = new C1379a();

    /* renamed from: d.a.n0.j0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1379a extends b0<BaseCardInfo> {
        public C1379a() {
        }

        @Override // d.a.n0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.a.n0.j0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.a.n0.j0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f55995g) {
                    if (nVar instanceof d.a.n0.j0.k.c.d) {
                        d.a.n0.j0.k.c.d dVar = (d.a.n0.j0.k.c.d) nVar;
                        if (u.equals(dVar.u())) {
                            List<d.a.n0.j0.k.c.c> t = dVar.t();
                            arrayList.add(nVar);
                            arrayList.addAll(t);
                        } else {
                            List<d.a.n0.j0.k.c.c> s = dVar.s();
                            arrayList.add(nVar);
                            arrayList.addAll(s);
                        }
                    }
                }
                e eVar = new e();
                eVar.f56020e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f55991c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55989a = tbPageContext;
        this.f55991c = sVar;
        c();
        this.f55991c.a(this.f55990b);
    }

    public final void c() {
        this.f55990b = new ArrayList();
        b bVar = new b(this.f55989a);
        this.f55992d = bVar;
        this.f55990b.add(bVar);
        c cVar = new c(this.f55989a, this.f55996h);
        this.f55993e = cVar;
        this.f55990b.add(cVar);
        d dVar = new d(this.f55989a);
        this.f55994f = dVar;
        this.f55990b.add(dVar);
    }

    public void d() {
        s sVar = this.f55991c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f55995g = list;
        this.f55991c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f55990b) {
            aVar.b0(bdUniqueId);
        }
    }
}
