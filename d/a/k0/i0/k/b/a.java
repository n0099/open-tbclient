package d.a.k0.i0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.a.c.j.e.n;
import d.a.c.j.e.s;
import d.a.k0.i0.k.c.e;
import d.a.k0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55805a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.a.c.j.e.a> f55806b;

    /* renamed from: c  reason: collision with root package name */
    public s f55807c;

    /* renamed from: d  reason: collision with root package name */
    public b f55808d;

    /* renamed from: e  reason: collision with root package name */
    public c f55809e;

    /* renamed from: f  reason: collision with root package name */
    public d f55810f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f55811g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f55812h = new C1361a();

    /* renamed from: d.a.k0.i0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1361a extends b0<BaseCardInfo> {
        public C1361a() {
        }

        @Override // d.a.k0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.a.k0.i0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.a.k0.i0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f55811g) {
                    if (nVar instanceof d.a.k0.i0.k.c.d) {
                        d.a.k0.i0.k.c.d dVar = (d.a.k0.i0.k.c.d) nVar;
                        if (u.equals(dVar.u())) {
                            List<d.a.k0.i0.k.c.c> t = dVar.t();
                            arrayList.add(nVar);
                            arrayList.addAll(t);
                        } else {
                            List<d.a.k0.i0.k.c.c> s = dVar.s();
                            arrayList.add(nVar);
                            arrayList.addAll(s);
                        }
                    }
                }
                e eVar = new e();
                eVar.f55836e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f55807c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55805a = tbPageContext;
        this.f55807c = sVar;
        c();
        this.f55807c.a(this.f55806b);
    }

    public final void c() {
        this.f55806b = new ArrayList();
        b bVar = new b(this.f55805a);
        this.f55808d = bVar;
        this.f55806b.add(bVar);
        c cVar = new c(this.f55805a, this.f55812h);
        this.f55809e = cVar;
        this.f55806b.add(cVar);
        d dVar = new d(this.f55805a);
        this.f55810f = dVar;
        this.f55806b.add(dVar);
    }

    public void d() {
        s sVar = this.f55807c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f55811g = list;
        this.f55807c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.a.c.j.e.a aVar : this.f55806b) {
            aVar.b0(bdUniqueId);
        }
    }
}
