package d.a.n0.j0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.n0.j0.k.c.e;
import d.a.n0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59678a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59679b;

    /* renamed from: c  reason: collision with root package name */
    public s f59680c;

    /* renamed from: d  reason: collision with root package name */
    public b f59681d;

    /* renamed from: e  reason: collision with root package name */
    public c f59682e;

    /* renamed from: f  reason: collision with root package name */
    public d f59683f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f59684g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f59685h = new C1435a();

    /* renamed from: d.a.n0.j0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1435a extends b0<BaseCardInfo> {
        public C1435a() {
        }

        @Override // d.a.n0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.a.n0.j0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String q = ((d.a.n0.j0.k.c.d) baseCardInfo).q();
                for (n nVar : a.this.f59684g) {
                    if (nVar instanceof d.a.n0.j0.k.c.d) {
                        d.a.n0.j0.k.c.d dVar = (d.a.n0.j0.k.c.d) nVar;
                        if (q.equals(dVar.q())) {
                            List<d.a.n0.j0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        } else {
                            List<d.a.n0.j0.k.c.c> o = dVar.o();
                            arrayList.add(nVar);
                            arrayList.addAll(o);
                        }
                    }
                }
                e eVar = new e();
                eVar.f59709e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f59680c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f59678a = tbPageContext;
        this.f59680c = sVar;
        c();
        this.f59680c.a(this.f59679b);
    }

    public final void c() {
        this.f59679b = new ArrayList();
        b bVar = new b(this.f59678a);
        this.f59681d = bVar;
        this.f59679b.add(bVar);
        c cVar = new c(this.f59678a, this.f59685h);
        this.f59682e = cVar;
        this.f59679b.add(cVar);
        d dVar = new d(this.f59678a);
        this.f59683f = dVar;
        this.f59679b.add(dVar);
    }

    public void d() {
        s sVar = this.f59680c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f59684g = list;
        this.f59680c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f59679b) {
            aVar.c0(bdUniqueId);
        }
    }
}
