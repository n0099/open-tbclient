package d.a.o0.j0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.k.e.n;
import d.a.c.k.e.s;
import d.a.o0.j0.k.c.e;
import d.a.o0.z.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59803a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59804b;

    /* renamed from: c  reason: collision with root package name */
    public s f59805c;

    /* renamed from: d  reason: collision with root package name */
    public b f59806d;

    /* renamed from: e  reason: collision with root package name */
    public c f59807e;

    /* renamed from: f  reason: collision with root package name */
    public d f59808f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f59809g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f59810h = new C1439a();

    /* renamed from: d.a.o0.j0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1439a extends b0<BaseCardInfo> {
        public C1439a() {
        }

        @Override // d.a.o0.z.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.a.o0.j0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String q = ((d.a.o0.j0.k.c.d) baseCardInfo).q();
                for (n nVar : a.this.f59809g) {
                    if (nVar instanceof d.a.o0.j0.k.c.d) {
                        d.a.o0.j0.k.c.d dVar = (d.a.o0.j0.k.c.d) nVar;
                        if (q.equals(dVar.q())) {
                            List<d.a.o0.j0.k.c.c> p = dVar.p();
                            arrayList.add(nVar);
                            arrayList.addAll(p);
                        } else {
                            List<d.a.o0.j0.k.c.c> o = dVar.o();
                            arrayList.add(nVar);
                            arrayList.addAll(o);
                        }
                    }
                }
                e eVar = new e();
                eVar.f59834e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f59805c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f59803a = tbPageContext;
        this.f59805c = sVar;
        c();
        this.f59805c.a(this.f59804b);
    }

    public final void c() {
        this.f59804b = new ArrayList();
        b bVar = new b(this.f59803a);
        this.f59806d = bVar;
        this.f59804b.add(bVar);
        c cVar = new c(this.f59803a, this.f59810h);
        this.f59807e = cVar;
        this.f59804b.add(cVar);
        d dVar = new d(this.f59803a);
        this.f59808f = dVar;
        this.f59804b.add(dVar);
    }

    public void d() {
        s sVar = this.f59805c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f59809g = list;
        this.f59805c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.k.e.a aVar : this.f59804b) {
            aVar.c0(bdUniqueId);
        }
    }
}
