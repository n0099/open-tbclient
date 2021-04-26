package d.a.j0.i0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.j0.i0.k.c.e;
import d.a.j0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55098a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55099b;

    /* renamed from: c  reason: collision with root package name */
    public s f55100c;

    /* renamed from: d  reason: collision with root package name */
    public b f55101d;

    /* renamed from: e  reason: collision with root package name */
    public c f55102e;

    /* renamed from: f  reason: collision with root package name */
    public d f55103f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f55104g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f55105h = new C1289a();

    /* renamed from: d.a.j0.i0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1289a extends b0<BaseCardInfo> {
        public C1289a() {
        }

        @Override // d.a.j0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.a.j0.i0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.a.j0.i0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f55104g) {
                    if (nVar instanceof d.a.j0.i0.k.c.d) {
                        d.a.j0.i0.k.c.d dVar = (d.a.j0.i0.k.c.d) nVar;
                        if (u.equals(dVar.u())) {
                            List<d.a.j0.i0.k.c.c> t = dVar.t();
                            arrayList.add(nVar);
                            arrayList.addAll(t);
                        } else {
                            List<d.a.j0.i0.k.c.c> s = dVar.s();
                            arrayList.add(nVar);
                            arrayList.addAll(s);
                        }
                    }
                }
                e eVar = new e();
                eVar.f55129e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f55100c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55098a = tbPageContext;
        this.f55100c = sVar;
        c();
        this.f55100c.a(this.f55099b);
    }

    public final void c() {
        this.f55099b = new ArrayList();
        b bVar = new b(this.f55098a);
        this.f55101d = bVar;
        this.f55099b.add(bVar);
        c cVar = new c(this.f55098a, this.f55105h);
        this.f55102e = cVar;
        this.f55099b.add(cVar);
        d dVar = new d(this.f55098a);
        this.f55103f = dVar;
        this.f55099b.add(dVar);
    }

    public void d() {
        s sVar = this.f55100c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f55104g = list;
        this.f55100c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f55099b) {
            aVar.b0(bdUniqueId);
        }
    }
}
