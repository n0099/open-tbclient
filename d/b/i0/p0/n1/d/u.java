package d.b.i0.p0.n1.d;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.z1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class u implements l0 {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58042a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.b.j.e.s f58043b;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, a2> f58045d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.b.j.e.n> f58046e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f58047f;
    public i0 i;
    public d.b.b.j.e.a j;
    public c0 k;
    public o l;
    public z m;
    public w n;
    public n o;
    public q p;
    public a0 q;
    public e0 r;
    public y s;
    public v t;
    public d0 u;
    public p v;
    public x w;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.b.j.e.a> f58044c = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f58048g = false;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.i0.p0.i f58049h = new d.b.i0.p0.i();

    public u(FrsFragment frsFragment, d.b.b.j.e.s sVar, boolean z) {
        this.f58043b = sVar;
        p(frsFragment, sVar);
        this.f58045d = new HashMap<>();
        n(z);
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void a(String str) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.x.z) {
                ((d.b.i0.x.z) aVar).a(str);
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void b(ArrayList<d.b.b.j.e.n> arrayList, FrsViewData frsViewData) {
        v(frsViewData);
        u();
        d.b.i0.c3.v.f(arrayList, 1);
        o(arrayList);
        x(arrayList);
        s(arrayList);
        Iterator<d.b.b.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.b.j.e.n next = it.next();
            if ((next instanceof z1) && ((z1) next).w.u2()) {
                it.remove();
            }
        }
        this.f58043b.setData(arrayList);
        this.f58047f = frsViewData;
        w();
        y();
        this.f58046e = arrayList;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public HashMap<Integer, a2> c() {
        return this.f58045d;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void d() {
        List<d.b.b.j.e.n> data;
        d.b.b.j.e.s sVar = this.f58043b;
        if (sVar == null || sVar.getData() == null || this.f58043b.getData().size() == 0 || (data = this.f58043b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.b.b.j.e.n nVar : data) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x0() != 0) {
                    a2Var.U2();
                }
            } else if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.U2();
                }
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public int e() {
        if (this.j != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public int f() {
        if (this.j != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void g(d.b.b.j.e.w wVar) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).c0(wVar);
            } else if ((aVar instanceof x) || (aVar instanceof d0)) {
                aVar.c0(wVar);
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void h() {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).i(this.f58042a.getPageContext(), this.f58042a.getUniqueId());
            }
        }
        z(this.f58044c);
    }

    @Override // d.b.i0.p0.n1.d.l0
    public int i() {
        if (this.j != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public boolean j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void k(d.b.i0.p0.f fVar) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).o0(fVar);
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public List<d.b.b.j.e.n> l() {
        d.b.b.j.e.s sVar = this.f58043b;
        if (sVar != null) {
            return sVar.getData();
        }
        return null;
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void m() {
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).m0();
            } else if (aVar instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar).onDestroy();
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void n(boolean z) {
        if (this.f58048g != z) {
            this.f58048g = z;
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void notifyDataSetChanged() {
        if (this.f58043b.getListAdapter() != null) {
            this.f58043b.getListAdapter().notifyDataSetChanged();
        }
    }

    public final ArrayList<Integer> o(ArrayList<d.b.b.j.e.n> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.b.j.e.n nVar = arrayList.get(i);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i));
                HashMap<Integer, a2> hashMap = this.f58045d;
                if (hashMap != null && !hashMap.containsValue(nVar)) {
                    this.f58045d.put(Integer.valueOf(i), (a2) nVar);
                }
            }
        }
        return arrayList2;
    }

    public void p(FrsFragment frsFragment, d.b.b.j.e.s sVar) {
        this.f58042a = frsFragment;
        this.j = d.b.i0.p0.e.e().b(frsFragment.getPageContext(), d.b.i0.c3.x.H3, this.f58042a.getUniqueId(), false);
        c0 c0Var = new c0(frsFragment.q(), a2.N2, this.f58042a.getUniqueId());
        this.k = c0Var;
        c0Var.q0(sVar);
        o oVar = new o(frsFragment.q(), a2.O2, this.f58042a.getUniqueId());
        this.l = oVar;
        oVar.q0(sVar);
        z zVar = new z(frsFragment.q(), a2.Q2, this.f58042a.getUniqueId());
        this.m = zVar;
        zVar.q0(sVar);
        w wVar = new w(frsFragment.q(), a2.R2, this.f58042a.getUniqueId());
        this.n = wVar;
        wVar.q0(sVar);
        n nVar = new n(frsFragment.q(), a2.T2, this.f58042a.getUniqueId());
        this.o = nVar;
        nVar.q0(sVar);
        q qVar = new q(frsFragment.q(), a2.U2, this.f58042a.getUniqueId());
        this.p = qVar;
        qVar.q0(sVar);
        e0 e0Var = new e0(frsFragment.q(), a2.Z2, this.f58042a.getUniqueId());
        this.r = e0Var;
        e0Var.q0(sVar);
        a0 a0Var = new a0(frsFragment.q(), a2.s3, this.f58042a.getUniqueId());
        this.q = a0Var;
        a0Var.q0(sVar);
        y yVar = new y(frsFragment.q(), a2.a3, this.f58042a.getUniqueId());
        this.s = yVar;
        yVar.q0(sVar);
        v vVar = new v(frsFragment.q(), a2.b3, this.f58042a.getUniqueId());
        this.t = vVar;
        vVar.q0(sVar);
        d0 d0Var = new d0(frsFragment.getPageContext(), a2.e3, this.f58042a.getUniqueId());
        this.u = d0Var;
        d0Var.q0(sVar);
        p pVar = new p(frsFragment.getPageContext(), a2.x3, this.f58042a.getUniqueId());
        this.v = pVar;
        pVar.q0(sVar);
        t tVar = new t(frsFragment.getPageContext(), a2.c3, this.f58042a.getUniqueId());
        tVar.q0(sVar);
        b0 b0Var = new b0(frsFragment.getPageContext(), a2.j3, this.f58042a.getUniqueId());
        b0Var.q0(sVar);
        a aVar = new a(frsFragment.getPageContext(), a2.W2, frsFragment.getUniqueId());
        aVar.q0(sVar);
        aVar.p(1);
        d dVar = new d(frsFragment.getPageContext(), a2.S2, frsFragment.getUniqueId());
        dVar.q0(sVar);
        b bVar = new b(frsFragment.getPageContext(), a2.l3, this.f58042a.getUniqueId());
        bVar.q0(sVar);
        bVar.J0(true);
        i iVar = new i(frsFragment.getPageContext(), a2.k3, this.f58042a.getUniqueId());
        iVar.q0(sVar);
        iVar.J0(true);
        j jVar = new j(frsFragment.getPageContext(), a2.m3, this.f58042a.getUniqueId());
        jVar.q0(sVar);
        jVar.K0(true);
        d0 d0Var2 = new d0(frsFragment.getPageContext(), a2.n3, this.f58042a.getUniqueId());
        d0Var2.q0(sVar);
        s sVar2 = new s(frsFragment.getPageContext(), a2.w3, this.f58042a.getUniqueId());
        sVar2.q0(sVar);
        r rVar = new r(frsFragment.getPageContext(), a2.o3, this.f58042a.getUniqueId());
        rVar.q0(sVar);
        this.i = new i0(frsFragment.getPageContext(), d.b.i0.c3.q.f53571g, this.f58042a.getUniqueId());
        x xVar = new x(frsFragment.getPageContext(), a2.d3, this.f58042a.getUniqueId());
        this.w = xVar;
        xVar.q0(sVar);
        d.b.b.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = d.b.i0.p0.e.e().d(frsFragment.getPageContext(), this.f58042a.getUniqueId(), true);
        d.b.b.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = d.b.i0.p0.e.e().c(frsFragment.getPageContext(), a2.B3, this.f58042a.getUniqueId());
        d.b.i0.p0.s sVar3 = new d.b.i0.p0.s(frsFragment.getPageContext(), d.b.i0.p0.t.f58578f);
        m mVar = new m(frsFragment.getPageContext(), d.b.i0.p0.v.f58618e);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.b.i0.p0.x.i, this.f58042a.getUniqueId());
        g gVar = new g(frsFragment.getPageContext(), a2.Y2, this.f58042a.getUniqueId());
        gVar.l0((BdTypeRecyclerView) sVar);
        this.f58044c.add(this.j);
        this.f58044c.add(this.k);
        this.f58044c.add(this.l);
        this.f58044c.add(this.m);
        this.f58044c.add(this.n);
        this.f58044c.add(this.o);
        this.f58044c.add(this.p);
        this.f58044c.add(this.q);
        this.f58044c.add(this.r);
        this.f58044c.add(this.s);
        this.f58044c.add(this.t);
        this.f58044c.add(this.i);
        this.f58044c.add(tVar);
        this.f58044c.add(b0Var);
        this.f58044c.add(aVar);
        this.f58044c.add(dVar);
        this.f58044c.add(bVar);
        this.f58044c.add(iVar);
        this.f58044c.add(jVar);
        this.f58044c.add(this.w);
        this.f58044c.add(this.u);
        this.f58044c.add(this.v);
        this.f58044c.add(d2);
        this.f58044c.add(c2);
        this.f58044c.add(sVar3);
        this.f58044c.add(mVar);
        this.f58044c.add(sVar2);
        this.f58044c.add(rVar);
        this.f58044c.add(frsUserRecommendAdapter);
        this.f58044c.add(d0Var2);
        this.f58044c.add(gVar);
        this.f58044c.add(d.b.i0.q0.b.d().c(this.f58042a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f58042a, 1);
        bVar2.t(this.f58044c);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        z(this.f58044c);
        sVar.a(this.f58044c);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58042a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        t("page_frs");
        if (absDelegateAdapterList.isEmpty()) {
            return;
        }
        Iterator<d.b.b.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
        while (it.hasNext()) {
            d.b.b.j.e.a<?, ?> next = it.next();
            if (next instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) next).i(this.f58042a.getPageContext(), this.f58042a.getUniqueId());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(absDelegateAdapterList);
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list != null) {
            list.addAll(arrayList);
        }
        d.b.b.j.e.s sVar4 = this.f58043b;
        if (sVar4 != null) {
            sVar4.a(arrayList);
        }
    }

    public final boolean q(d.b.b.j.e.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == a2.H2 || type == a2.d3 || type == a2.e3 || type == a2.n3 || type == a2.w3;
    }

    public void r() {
        ArrayList<d.b.b.j.e.n> arrayList = this.f58046e;
        if (arrayList != null) {
            this.f58043b.setData(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void s(ArrayList<d.b.b.j.e.n> arrayList) {
        int count = ListUtils.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            d.b.b.j.e.n nVar = (d.b.b.j.e.n) ListUtils.getItem(arrayList, i - 1);
            d.b.b.j.e.n nVar2 = (d.b.b.j.e.n) ListUtils.getItem(arrayList, i);
            if (nVar2 instanceof z1) {
                a2 a2Var = ((z1) nVar2).w;
                if (i == 0) {
                    a2Var.isFirstFloor = true;
                } else {
                    a2Var.isFirstFloor = false;
                }
                String V0 = a2Var.V0();
                if (nVar instanceof d.b.i0.p0.v) {
                    a2Var.needTopMargin = false;
                } else if (nVar != null && !q(nVar)) {
                    a2Var.needTopMargin = false;
                } else if ((nVar instanceof z1) && q(nVar) && !TextUtils.isEmpty(((z1) nVar).w.V0())) {
                    a2Var.needTopMargin = true;
                } else if (q(nVar2) && !TextUtils.isEmpty(V0)) {
                    a2Var.needTopMargin = true;
                } else {
                    a2Var.needTopMargin = false;
                }
            }
        }
    }

    @Override // d.b.i0.p0.n1.d.l0
    public void setFromCDN(boolean z) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).setFromCDN(z);
            }
        }
        c0 c0Var = this.k;
        if (c0Var != null) {
            c0Var.setFromCDN(z);
        }
        o oVar = this.l;
        if (oVar != null) {
            oVar.setFromCDN(z);
        }
        z zVar = this.m;
        if (zVar != null) {
            zVar.setFromCDN(z);
        }
        w wVar = this.n;
        if (wVar != null) {
            wVar.setFromCDN(z);
        }
        n nVar = this.o;
        if (nVar != null) {
            nVar.setFromCDN(z);
        }
        q qVar = this.p;
        if (qVar != null) {
            qVar.setFromCDN(z);
        }
        d0 d0Var = this.u;
        if (d0Var != null) {
            d0Var.setFromCDN(z);
        }
        x xVar = this.w;
        if (xVar != null) {
            xVar.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.m.f) {
                ((d.b.i0.m.f) aVar).o(str);
            }
        }
    }

    public final void u() {
        if (ListUtils.isEmpty(this.f58044c) || this.f58042a == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).r0(this.f58042a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).p0(frsViewData);
            }
        }
    }

    public final void w() {
        d.b.i0.p0.j2.b b2;
        if (this.f58047f == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if ((aVar instanceof d.b.i0.p0.j2.d) && (b2 = ((d.b.i0.p0.j2.d) aVar).b()) != null) {
                if (this.f58047f.needLog == 1) {
                    b2.f57699a = true;
                } else {
                    b2.f57699a = false;
                }
                if (this.f58047f.getForum() != null) {
                    b2.f57701c = this.f58047f.getForum().getId();
                }
                FrsFragment frsFragment = this.f58042a;
                if (frsFragment != null && frsFragment.M() != null) {
                    int N = this.f58042a.M().N();
                    if (N == -1) {
                        N = this.f58042a.M().M();
                    }
                    b2.f57700b = N;
                }
            }
        }
    }

    public final void x(ArrayList<d.b.b.j.e.n> arrayList) {
        List<d.b.b.j.e.a> list = this.f58044c;
        if (list == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.b.b.j.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == a2.G2.getId()) {
                i++;
            }
        }
        for (d.b.b.j.e.a aVar : this.f58044c) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).s0(i);
            }
        }
    }

    public final void y() {
        i0 i0Var;
        FrsViewData frsViewData = this.f58047f;
        if (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f58047f.getForum().getId()) || (i0Var = this.i) == null) {
            return;
        }
        i0Var.y0(this.f58047f.getForum().getId());
    }

    public final void z(List<d.b.b.j.e.a> list) {
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).n0(this.f58049h);
            }
        }
    }
}
