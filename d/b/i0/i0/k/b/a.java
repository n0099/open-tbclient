package d.b.i0.i0.k.b;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import d.b.c.j.e.n;
import d.b.c.j.e.s;
import d.b.i0.i0.k.c.e;
import d.b.i0.x.b0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56747a;

    /* renamed from: b  reason: collision with root package name */
    public List<d.b.c.j.e.a> f56748b;

    /* renamed from: c  reason: collision with root package name */
    public s f56749c;

    /* renamed from: d  reason: collision with root package name */
    public b f56750d;

    /* renamed from: e  reason: collision with root package name */
    public c f56751e;

    /* renamed from: f  reason: collision with root package name */
    public d f56752f;

    /* renamed from: g  reason: collision with root package name */
    public List<n> f56753g;

    /* renamed from: h  reason: collision with root package name */
    public b0<BaseCardInfo> f56754h = new C1327a();

    /* renamed from: d.b.i0.i0.k.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1327a extends b0<BaseCardInfo> {
        public C1327a() {
        }

        @Override // d.b.i0.x.b0
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof d.b.i0.i0.k.c.d)) {
                ArrayList arrayList = new ArrayList();
                String u = ((d.b.i0.i0.k.c.d) baseCardInfo).u();
                for (n nVar : a.this.f56753g) {
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
                eVar.f56777e = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.f56749c.setData(arrayList);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext, s sVar) {
        this.f56747a = tbPageContext;
        this.f56749c = sVar;
        c();
        this.f56749c.a(this.f56748b);
    }

    public final void c() {
        this.f56748b = new ArrayList();
        b bVar = new b(this.f56747a);
        this.f56750d = bVar;
        this.f56748b.add(bVar);
        c cVar = new c(this.f56747a, this.f56754h);
        this.f56751e = cVar;
        this.f56748b.add(cVar);
        d dVar = new d(this.f56747a);
        this.f56752f = dVar;
        this.f56748b.add(dVar);
    }

    public void d() {
        s sVar = this.f56749c;
        if (sVar != null) {
            sVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void e(List<n> list) {
        this.f56753g = list;
        this.f56749c.setData(list);
    }

    public void f(BdUniqueId bdUniqueId) {
        for (d.b.c.j.e.a aVar : this.f56748b) {
            aVar.f0(bdUniqueId);
        }
    }
}
