package d.b.i0.q0.n1.d;

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
public class q implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59674a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.c.j.e.s f59675b;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, a2> f59677d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.b.c.j.e.n> f59678e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f59679f;
    public d0 i;
    public d.b.c.j.e.a j;
    public y k;
    public k l;
    public v m;
    public s n;
    public j o;
    public m p;
    public w q;
    public a0 r;
    public u s;
    public r t;
    public z u;
    public l v;
    public t w;

    /* renamed from: c  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59676c = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59680g = false;

    /* renamed from: h  reason: collision with root package name */
    public final d.b.i0.q0.i f59681h = new d.b.i0.q0.i();

    public q(FrsFragment frsFragment, d.b.c.j.e.s sVar, boolean z) {
        this.f59675b = sVar;
        p(frsFragment, sVar);
        this.f59677d = new HashMap<>();
        n(z);
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void a(String str) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.x.z) {
                ((d.b.i0.x.z) aVar).a(str);
            }
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void b(ArrayList<d.b.c.j.e.n> arrayList, FrsViewData frsViewData) {
        v(frsViewData);
        u();
        d.b.i0.d3.v.f(arrayList, 1);
        o(arrayList);
        x(arrayList);
        s(arrayList);
        Iterator<d.b.c.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.c.j.e.n next = it.next();
            if ((next instanceof z1) && ((z1) next).w.v2()) {
                it.remove();
            }
        }
        this.f59675b.setData(arrayList);
        this.f59679f = frsViewData;
        w();
        y();
        this.f59678e = arrayList;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public HashMap<Integer, a2> c() {
        return this.f59677d;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void d() {
        List<d.b.c.j.e.n> data;
        d.b.c.j.e.s sVar = this.f59675b;
        if (sVar == null || sVar.getData() == null || this.f59675b.getData().size() == 0 || (data = this.f59675b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.b.c.j.e.n nVar : data) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.x0() != 0) {
                    a2Var.V2();
                }
            } else if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.x0() != 0) {
                    z1Var.w.V2();
                }
            }
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public int e() {
        if (this.j != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public int f() {
        if (this.j != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void g(d.b.c.j.e.w wVar) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).c0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.c0(wVar);
            }
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void h() {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).i(this.f59674a.getPageContext(), this.f59674a.getUniqueId());
            }
        }
        z(this.f59676c);
    }

    @Override // d.b.i0.q0.n1.d.e0
    public int i() {
        if (this.j != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public boolean j(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void k(d.b.i0.q0.f fVar) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).o0(fVar);
            }
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public List<d.b.c.j.e.n> l() {
        d.b.c.j.e.s sVar = this.f59675b;
        if (sVar != null) {
            return sVar.getData();
        }
        return null;
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void m() {
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).m0();
            } else if (aVar instanceof d.b.i0.s2.o) {
                ((d.b.i0.s2.o) aVar).onDestroy();
            }
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void n(boolean z) {
        if (this.f59680g != z) {
            this.f59680g = z;
        }
    }

    @Override // d.b.i0.q0.n1.d.e0
    public void notifyDataSetChanged() {
        if (this.f59675b.getListAdapter() != null) {
            this.f59675b.getListAdapter().notifyDataSetChanged();
        }
    }

    public final ArrayList<Integer> o(ArrayList<d.b.c.j.e.n> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            d.b.c.j.e.n nVar = arrayList.get(i);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i));
                HashMap<Integer, a2> hashMap = this.f59677d;
                if (hashMap != null && !hashMap.containsValue(nVar)) {
                    this.f59677d.put(Integer.valueOf(i), (a2) nVar);
                }
            }
        }
        return arrayList2;
    }

    public void p(FrsFragment frsFragment, d.b.c.j.e.s sVar) {
        this.f59674a = frsFragment;
        this.j = d.b.i0.q0.e.e().b(frsFragment.getPageContext(), d.b.i0.d3.x.H3, this.f59674a.getUniqueId(), false);
        y yVar = new y(frsFragment.q(), a2.N2, this.f59674a.getUniqueId());
        this.k = yVar;
        yVar.q0(sVar);
        k kVar = new k(frsFragment.q(), a2.O2, this.f59674a.getUniqueId());
        this.l = kVar;
        kVar.q0(sVar);
        v vVar = new v(frsFragment.q(), a2.Q2, this.f59674a.getUniqueId());
        this.m = vVar;
        vVar.q0(sVar);
        s sVar2 = new s(frsFragment.q(), a2.R2, this.f59674a.getUniqueId());
        this.n = sVar2;
        sVar2.q0(sVar);
        j jVar = new j(frsFragment.q(), a2.T2, this.f59674a.getUniqueId());
        this.o = jVar;
        jVar.q0(sVar);
        m mVar = new m(frsFragment.q(), a2.U2, this.f59674a.getUniqueId());
        this.p = mVar;
        mVar.q0(sVar);
        a0 a0Var = new a0(frsFragment.q(), a2.Z2, this.f59674a.getUniqueId());
        this.r = a0Var;
        a0Var.q0(sVar);
        w wVar = new w(frsFragment.q(), a2.s3, this.f59674a.getUniqueId());
        this.q = wVar;
        wVar.q0(sVar);
        u uVar = new u(frsFragment.q(), a2.a3, this.f59674a.getUniqueId());
        this.s = uVar;
        uVar.q0(sVar);
        r rVar = new r(frsFragment.q(), a2.b3, this.f59674a.getUniqueId());
        this.t = rVar;
        rVar.q0(sVar);
        z zVar = new z(frsFragment.getPageContext(), a2.e3, this.f59674a.getUniqueId());
        this.u = zVar;
        zVar.q0(sVar);
        l lVar = new l(frsFragment.getPageContext(), a2.x3, this.f59674a.getUniqueId());
        this.v = lVar;
        lVar.q0(sVar);
        p pVar = new p(frsFragment.getPageContext(), a2.c3, this.f59674a.getUniqueId());
        pVar.q0(sVar);
        x xVar = new x(frsFragment.getPageContext(), a2.j3, this.f59674a.getUniqueId());
        xVar.q0(sVar);
        a aVar = new a(frsFragment.getPageContext(), a2.W2, frsFragment.getUniqueId());
        aVar.q0(sVar);
        aVar.p(1);
        c cVar = new c(frsFragment.getPageContext(), a2.S2, frsFragment.getUniqueId());
        cVar.q0(sVar);
        b bVar = new b(frsFragment.getPageContext(), a2.l3, this.f59674a.getUniqueId());
        bVar.q0(sVar);
        bVar.J0(true);
        g gVar = new g(frsFragment.getPageContext(), a2.k3, this.f59674a.getUniqueId());
        gVar.q0(sVar);
        gVar.J0(true);
        h hVar = new h(frsFragment.getPageContext(), a2.m3, this.f59674a.getUniqueId());
        hVar.q0(sVar);
        hVar.K0(true);
        z zVar2 = new z(frsFragment.getPageContext(), a2.n3, this.f59674a.getUniqueId());
        zVar2.q0(sVar);
        o oVar = new o(frsFragment.getPageContext(), a2.w3, this.f59674a.getUniqueId());
        oVar.q0(sVar);
        n nVar = new n(frsFragment.getPageContext(), a2.o3, this.f59674a.getUniqueId());
        nVar.q0(sVar);
        this.i = new d0(frsFragment.getPageContext(), d.b.i0.d3.q.f55016g, this.f59674a.getUniqueId());
        t tVar = new t(frsFragment.getPageContext(), a2.d3, this.f59674a.getUniqueId());
        this.w = tVar;
        tVar.q0(sVar);
        d.b.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> d2 = d.b.i0.q0.e.e().d(frsFragment.getPageContext(), this.f59674a.getUniqueId(), true);
        d.b.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> c2 = d.b.i0.q0.e.e().c(frsFragment.getPageContext(), a2.B3, this.f59674a.getUniqueId());
        d.b.i0.q0.s sVar3 = new d.b.i0.q0.s(frsFragment.getPageContext(), d.b.i0.q0.t.f60247f);
        i iVar = new i(frsFragment.getPageContext(), d.b.i0.q0.v.f60287e);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.b.i0.q0.x.i, this.f59674a.getUniqueId());
        e eVar = new e(frsFragment.getPageContext(), a2.Y2, this.f59674a.getUniqueId());
        eVar.l0((BdTypeRecyclerView) sVar);
        this.f59676c.add(this.j);
        this.f59676c.add(this.k);
        this.f59676c.add(this.l);
        this.f59676c.add(this.m);
        this.f59676c.add(this.n);
        this.f59676c.add(this.o);
        this.f59676c.add(this.p);
        this.f59676c.add(this.q);
        this.f59676c.add(this.r);
        this.f59676c.add(this.s);
        this.f59676c.add(this.t);
        this.f59676c.add(this.i);
        this.f59676c.add(pVar);
        this.f59676c.add(xVar);
        this.f59676c.add(aVar);
        this.f59676c.add(cVar);
        this.f59676c.add(bVar);
        this.f59676c.add(gVar);
        this.f59676c.add(hVar);
        this.f59676c.add(this.w);
        this.f59676c.add(this.u);
        this.f59676c.add(this.v);
        this.f59676c.add(d2);
        this.f59676c.add(c2);
        this.f59676c.add(sVar3);
        this.f59676c.add(iVar);
        this.f59676c.add(oVar);
        this.f59676c.add(nVar);
        this.f59676c.add(frsUserRecommendAdapter);
        this.f59676c.add(zVar2);
        this.f59676c.add(eVar);
        this.f59676c.add(d.b.i0.r0.b.e().c(this.f59674a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        d.b.i0.e.f.b bVar2 = new d.b.i0.e.f.b(this.f59674a, 1);
        bVar2.t(this.f59676c);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        z(this.f59676c);
        sVar.a(this.f59676c);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59674a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        t("page_frs");
        if (absDelegateAdapterList.isEmpty()) {
            return;
        }
        Iterator<d.b.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
        while (it.hasNext()) {
            d.b.c.j.e.a<?, ?> next = it.next();
            if (next instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) next).i(this.f59674a.getPageContext(), this.f59674a.getUniqueId());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(absDelegateAdapterList);
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list != null) {
            list.addAll(arrayList);
        }
        d.b.c.j.e.s sVar4 = this.f59675b;
        if (sVar4 != null) {
            sVar4.a(arrayList);
        }
    }

    public final boolean q(d.b.c.j.e.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == a2.H2 || type == a2.d3 || type == a2.e3 || type == a2.n3 || type == a2.w3;
    }

    public void r() {
        ArrayList<d.b.c.j.e.n> arrayList = this.f59678e;
        if (arrayList != null) {
            this.f59675b.setData(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void s(ArrayList<d.b.c.j.e.n> arrayList) {
        int count = ListUtils.getCount(arrayList);
        for (int i = 0; i < count; i++) {
            d.b.c.j.e.n nVar = (d.b.c.j.e.n) ListUtils.getItem(arrayList, i - 1);
            d.b.c.j.e.n nVar2 = (d.b.c.j.e.n) ListUtils.getItem(arrayList, i);
            if (nVar2 instanceof z1) {
                a2 a2Var = ((z1) nVar2).w;
                if (i == 0) {
                    a2Var.isFirstFloor = true;
                } else {
                    a2Var.isFirstFloor = false;
                }
                String V0 = a2Var.V0();
                if (nVar instanceof d.b.i0.q0.v) {
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

    @Override // d.b.i0.q0.n1.d.e0
    public void setFromCDN(boolean z) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).setFromCDN(z);
            }
        }
        y yVar = this.k;
        if (yVar != null) {
            yVar.setFromCDN(z);
        }
        k kVar = this.l;
        if (kVar != null) {
            kVar.setFromCDN(z);
        }
        v vVar = this.m;
        if (vVar != null) {
            vVar.setFromCDN(z);
        }
        s sVar = this.n;
        if (sVar != null) {
            sVar.setFromCDN(z);
        }
        j jVar = this.o;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.setFromCDN(z);
        }
        z zVar = this.u;
        if (zVar != null) {
            zVar.setFromCDN(z);
        }
        t tVar = this.w;
        if (tVar != null) {
            tVar.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.m.f) {
                ((d.b.i0.m.f) aVar).o(str);
            }
        }
    }

    public final void u() {
        if (ListUtils.isEmpty(this.f59676c) || this.f59674a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).r0(this.f59674a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).p0(frsViewData);
            }
        }
    }

    public final void w() {
        d.b.i0.q0.j2.b b2;
        if (this.f59679f == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if ((aVar instanceof d.b.i0.q0.j2.d) && (b2 = ((d.b.i0.q0.j2.d) aVar).b()) != null) {
                if (this.f59679f.needLog == 1) {
                    b2.f59399a = true;
                } else {
                    b2.f59399a = false;
                }
                if (this.f59679f.getForum() != null) {
                    b2.f59401c = this.f59679f.getForum().getId();
                }
                FrsFragment frsFragment = this.f59674a;
                if (frsFragment != null && frsFragment.M() != null) {
                    int N = this.f59674a.M().N();
                    if (N == -1) {
                        N = this.f59674a.M().M();
                    }
                    b2.f59400b = N;
                }
            }
        }
    }

    public final void x(ArrayList<d.b.c.j.e.n> arrayList) {
        List<d.b.c.j.e.a> list = this.f59676c;
        if (list == null || list.size() == 0) {
            return;
        }
        int i = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.b.c.j.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == a2.G2.getId()) {
                i++;
            }
        }
        for (d.b.c.j.e.a aVar : this.f59676c) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).s0(i);
            }
        }
    }

    public final void y() {
        d0 d0Var;
        FrsViewData frsViewData = this.f59679f;
        if (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f59679f.getForum().getId()) || (d0Var = this.i) == null) {
            return;
        }
        d0Var.y0(this.f59679f.getForum().getId());
    }

    public final void z(List<d.b.c.j.e.a> list) {
        if (list == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.q0.k) {
                ((d.b.i0.q0.k) aVar).n0(this.f59681h);
            }
        }
    }
}
