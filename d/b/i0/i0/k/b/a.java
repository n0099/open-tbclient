package d.b.i0.i0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.b.j.e.n;
import d.b.b.j.e.s;
import d.b.i0.i0.k.c.e;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55624a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.b.j.e.a> f55625b;

    /* renamed from: c  reason: collision with root package name */
    public s f55626c;

    /* renamed from: d  reason: collision with root package name */
    public b f55627d;

    /* renamed from: e  reason: collision with root package name */
    public c f55628e;

    /* renamed from: f  reason: collision with root package name */
    public d f55629f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f55630g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f55631h = new C1289a();

    /* renamed from: d.b.i0.i0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1289a extends b0<BaseCardInfo> {
        public C1289a() {
        }

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.b.i0.i0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.b.i0.i0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f55630g) {
                    if (nVar instanceof d.b.i0.i0.k.c.d) {
                        d.b.i0.i0.k.c.d dVar = (d.b.i0.i0.k.c.d) nVar;
                        if (u.equals(dVar.u())) {
                            List<d.b.i0.i0.k.c.c> t = dVar.t();
                            arrayList.add(nVar);
                            arrayList.addAll(t);
                        } else {
                            List<d.b.i0.i0.k.c.c> s = dVar.s();
                            arrayList.add(nVar);
                            arrayList.addAll(s);
                        }
                    }
                }
                e eVar = new e();
                eVar.f55654e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f55626c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f55624a = tbPageContext;
        this.f55626c = sVar;
        c();
        this.f55626c.a(this.f55625b);
    }

    public final void c() {
        this.f55625b = new ArrayList();
        b bVar = new b(this.f55624a);
        this.f55627d = bVar;
        this.f55625b.add(bVar);
        c cVar = new c(this.f55624a, this.f55631h);
        this.f55628e = cVar;
        this.f55625b.add(cVar);
        d dVar = new d(this.f55624a);
        this.f55629f = dVar;
        this.f55625b.add(dVar);
    }

    public void d() {
        s sVar = this.f55626c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f55630g = list;
        this.f55626c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.b.j.e.a aVar : this.f55625b) {
            aVar.f0(bdUniqueId);
        }
    }
}
