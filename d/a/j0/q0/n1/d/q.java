package d.a.j0.q0.n1.d;

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
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class q implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f58175a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.e.s f58176b;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, a2> f58178d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f58179e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f58180f;

    /* renamed from: i  reason: collision with root package name */
    public d0 f58183i;
    public d.a.c.j.e.a j;
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
    public List<d.a.c.j.e.a> f58177c = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f58181g = false;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.j0.q0.i f58182h = new d.a.j0.q0.i();

    public q(FrsFragment frsFragment, d.a.c.j.e.s sVar, boolean z) {
        this.f58176b = sVar;
        p(frsFragment, sVar);
        this.f58178d = new HashMap<>();
        n(z);
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void a(String str) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.x.z) {
                ((d.a.j0.x.z) aVar).a(str);
            }
        }
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void b() {
        List<d.a.c.j.e.n> data;
        d.a.c.j.e.s sVar = this.f58176b;
        if (sVar == null || sVar.getData() == null || this.f58176b.getData().size() == 0 || (data = this.f58176b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.a.c.j.e.n nVar : data) {
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

    @Override // d.a.j0.q0.n1.d.e0
    public int c() {
        if (this.j != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void d(d.a.c.j.e.w wVar) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).Z(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.Z(wVar);
            }
        }
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void e() {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).n(this.f58175a.getPageContext(), this.f58175a.getUniqueId());
            }
        }
        z(this.f58177c);
    }

    @Override // d.a.j0.q0.n1.d.e0
    public List<d.a.c.j.e.n> f() {
        d.a.c.j.e.s sVar = this.f58176b;
        if (sVar != null) {
            return sVar.getData();
        }
        return null;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void g(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        v(frsViewData);
        u();
        d.a.j0.d3.v.f(arrayList, 1);
        o(arrayList);
        x(arrayList);
        s(arrayList);
        Iterator<d.a.c.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if ((next instanceof z1) && ((z1) next).w.v2()) {
                it.remove();
            }
        }
        this.f58176b.setData(arrayList);
        this.f58180f = frsViewData;
        w();
        y();
        this.f58179e = arrayList;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public HashMap<Integer, a2> h() {
        return this.f58178d;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public int i() {
        if (this.j != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public int j() {
        if (this.j != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void l(d.a.j0.q0.f fVar) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).m0(fVar);
            }
        }
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void m() {
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).i0();
            } else if (aVar instanceof d.a.j0.s2.o) {
                ((d.a.j0.s2.o) aVar).onDestroy();
            }
        }
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void n(boolean z) {
        if (this.f58181g != z) {
            this.f58181g = z;
        }
    }

    @Override // d.a.j0.q0.n1.d.e0
    public void notifyDataSetChanged() {
        if (this.f58176b.getListAdapter() != null) {
            this.f58176b.getListAdapter().notifyDataSetChanged();
        }
    }

    public final ArrayList<Integer> o(ArrayList<d.a.c.j.e.n> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.j.e.n nVar = arrayList.get(i2);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                HashMap<Integer, a2> hashMap = this.f58178d;
                if (hashMap != null && !hashMap.containsValue(nVar)) {
                    this.f58178d.put(Integer.valueOf(i2), (a2) nVar);
                }
            }
        }
        return arrayList2;
    }

    public void p(FrsFragment frsFragment, d.a.c.j.e.s sVar) {
        this.f58175a = frsFragment;
        this.j = d.a.j0.q0.e.e().c(frsFragment.getPageContext(), d.a.j0.d3.x.H3, this.f58175a.getUniqueId(), false);
        y yVar = new y(frsFragment.o(), a2.N2, this.f58175a.getUniqueId());
        this.k = yVar;
        yVar.p0(sVar);
        k kVar = new k(frsFragment.o(), a2.O2, this.f58175a.getUniqueId());
        this.l = kVar;
        kVar.p0(sVar);
        v vVar = new v(frsFragment.o(), a2.Q2, this.f58175a.getUniqueId());
        this.m = vVar;
        vVar.p0(sVar);
        s sVar2 = new s(frsFragment.o(), a2.R2, this.f58175a.getUniqueId());
        this.n = sVar2;
        sVar2.p0(sVar);
        j jVar = new j(frsFragment.o(), a2.T2, this.f58175a.getUniqueId());
        this.o = jVar;
        jVar.p0(sVar);
        m mVar = new m(frsFragment.o(), a2.U2, this.f58175a.getUniqueId());
        this.p = mVar;
        mVar.p0(sVar);
        a0 a0Var = new a0(frsFragment.o(), a2.Z2, this.f58175a.getUniqueId());
        this.r = a0Var;
        a0Var.p0(sVar);
        w wVar = new w(frsFragment.o(), a2.s3, this.f58175a.getUniqueId());
        this.q = wVar;
        wVar.p0(sVar);
        u uVar = new u(frsFragment.o(), a2.a3, this.f58175a.getUniqueId());
        this.s = uVar;
        uVar.p0(sVar);
        r rVar = new r(frsFragment.o(), a2.b3, this.f58175a.getUniqueId());
        this.t = rVar;
        rVar.p0(sVar);
        z zVar = new z(frsFragment.getPageContext(), a2.e3, this.f58175a.getUniqueId());
        this.u = zVar;
        zVar.p0(sVar);
        l lVar = new l(frsFragment.getPageContext(), a2.x3, this.f58175a.getUniqueId());
        this.v = lVar;
        lVar.p0(sVar);
        p pVar = new p(frsFragment.getPageContext(), a2.c3, this.f58175a.getUniqueId());
        pVar.p0(sVar);
        x xVar = new x(frsFragment.getPageContext(), a2.j3, this.f58175a.getUniqueId());
        xVar.p0(sVar);
        a aVar = new a(frsFragment.getPageContext(), a2.W2, frsFragment.getUniqueId());
        aVar.p0(sVar);
        aVar.q(1);
        c cVar = new c(frsFragment.getPageContext(), a2.S2, frsFragment.getUniqueId());
        cVar.p0(sVar);
        b bVar = new b(frsFragment.getPageContext(), a2.l3, this.f58175a.getUniqueId());
        bVar.p0(sVar);
        bVar.J0(true);
        g gVar = new g(frsFragment.getPageContext(), a2.k3, this.f58175a.getUniqueId());
        gVar.p0(sVar);
        gVar.J0(true);
        h hVar = new h(frsFragment.getPageContext(), a2.m3, this.f58175a.getUniqueId());
        hVar.p0(sVar);
        hVar.K0(true);
        z zVar2 = new z(frsFragment.getPageContext(), a2.n3, this.f58175a.getUniqueId());
        zVar2.p0(sVar);
        o oVar = new o(frsFragment.getPageContext(), a2.w3, this.f58175a.getUniqueId());
        oVar.p0(sVar);
        n nVar = new n(frsFragment.getPageContext(), a2.o3, this.f58175a.getUniqueId());
        nVar.p0(sVar);
        this.f58183i = new d0(frsFragment.getPageContext(), d.a.j0.d3.q.f53281g, this.f58175a.getUniqueId());
        t tVar = new t(frsFragment.getPageContext(), a2.d3, this.f58175a.getUniqueId());
        this.w = tVar;
        tVar.p0(sVar);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.j0.q0.e.e().a(frsFragment.getPageContext(), this.f58175a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.j0.q0.e.e().d(frsFragment.getPageContext(), a2.B3, this.f58175a.getUniqueId());
        d.a.j0.q0.s sVar3 = new d.a.j0.q0.s(frsFragment.getPageContext(), d.a.j0.q0.t.f58775f);
        i iVar = new i(frsFragment.getPageContext(), d.a.j0.q0.v.f58817e);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.a.j0.q0.x.f58919i, this.f58175a.getUniqueId());
        e eVar = new e(frsFragment.getPageContext(), a2.Y2, this.f58175a.getUniqueId());
        eVar.h0((BdTypeRecyclerView) sVar);
        this.f58177c.add(this.j);
        this.f58177c.add(this.k);
        this.f58177c.add(this.l);
        this.f58177c.add(this.m);
        this.f58177c.add(this.n);
        this.f58177c.add(this.o);
        this.f58177c.add(this.p);
        this.f58177c.add(this.q);
        this.f58177c.add(this.r);
        this.f58177c.add(this.s);
        this.f58177c.add(this.t);
        this.f58177c.add(this.f58183i);
        this.f58177c.add(pVar);
        this.f58177c.add(xVar);
        this.f58177c.add(aVar);
        this.f58177c.add(cVar);
        this.f58177c.add(bVar);
        this.f58177c.add(gVar);
        this.f58177c.add(hVar);
        this.f58177c.add(this.w);
        this.f58177c.add(this.u);
        this.f58177c.add(this.v);
        this.f58177c.add(a2);
        this.f58177c.add(d2);
        this.f58177c.add(sVar3);
        this.f58177c.add(iVar);
        this.f58177c.add(oVar);
        this.f58177c.add(nVar);
        this.f58177c.add(frsUserRecommendAdapter);
        this.f58177c.add(zVar2);
        this.f58177c.add(eVar);
        this.f58177c.add(d.a.j0.r0.b.e().b(this.f58175a.getBaseFragmentActivity(), AdvertAppInfo.n4));
        d.a.j0.e.f.b bVar2 = new d.a.j0.e.f.b(this.f58175a, 1);
        bVar2.t(this.f58177c);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        z(this.f58177c);
        sVar.a(this.f58177c);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f58175a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        t("page_frs");
        if (absDelegateAdapterList.isEmpty()) {
            return;
        }
        Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.a<?, ?> next = it.next();
            if (next instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) next).n(this.f58175a.getPageContext(), this.f58175a.getUniqueId());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(absDelegateAdapterList);
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list != null) {
            list.addAll(arrayList);
        }
        d.a.c.j.e.s sVar4 = this.f58176b;
        if (sVar4 != null) {
            sVar4.a(arrayList);
        }
    }

    public final boolean q(d.a.c.j.e.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == a2.H2 || type == a2.d3 || type == a2.e3 || type == a2.n3 || type == a2.w3;
    }

    public void r() {
        ArrayList<d.a.c.j.e.n> arrayList = this.f58179e;
        if (arrayList != null) {
            this.f58176b.setData(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void s(ArrayList<d.a.c.j.e.n> arrayList) {
        int count = ListUtils.getCount(arrayList);
        for (int i2 = 0; i2 < count; i2++) {
            d.a.c.j.e.n nVar = (d.a.c.j.e.n) ListUtils.getItem(arrayList, i2 - 1);
            d.a.c.j.e.n nVar2 = (d.a.c.j.e.n) ListUtils.getItem(arrayList, i2);
            if (nVar2 instanceof z1) {
                a2 a2Var = ((z1) nVar2).w;
                if (i2 == 0) {
                    a2Var.isFirstFloor = true;
                } else {
                    a2Var.isFirstFloor = false;
                }
                String V0 = a2Var.V0();
                if (nVar instanceof d.a.j0.q0.v) {
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

    @Override // d.a.j0.q0.n1.d.e0
    public void setFromCDN(boolean z) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).setFromCDN(z);
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
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.m.f) {
                ((d.a.j0.m.f) aVar).g(str);
            }
        }
    }

    public final void u() {
        if (ListUtils.isEmpty(this.f58177c) || this.f58175a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).q0(this.f58175a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void w() {
        d.a.j0.q0.j2.b i2;
        if (this.f58180f == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if ((aVar instanceof d.a.j0.q0.j2.d) && (i2 = ((d.a.j0.q0.j2.d) aVar).i()) != null) {
                if (this.f58180f.needLog == 1) {
                    i2.f57891a = true;
                } else {
                    i2.f57891a = false;
                }
                if (this.f58180f.getForum() != null) {
                    i2.f57893c = this.f58180f.getForum().getId();
                }
                FrsFragment frsFragment = this.f58175a;
                if (frsFragment != null && frsFragment.b0() != null) {
                    int N = this.f58175a.b0().N();
                    if (N == -1) {
                        N = this.f58175a.b0().M();
                    }
                    i2.f57892b = N;
                }
            }
        }
    }

    public final void x(ArrayList<d.a.c.j.e.n> arrayList) {
        List<d.a.c.j.e.a> list = this.f58177c;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.a.c.j.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == a2.G2.getId()) {
                i2++;
            }
        }
        for (d.a.c.j.e.a aVar : this.f58177c) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).r0(i2);
            }
        }
    }

    public final void y() {
        d0 d0Var;
        FrsViewData frsViewData = this.f58180f;
        if (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f58180f.getForum().getId()) || (d0Var = this.f58183i) == null) {
            return;
        }
        d0Var.y0(this.f58180f.getForum().getId());
    }

    public final void z(List<d.a.c.j.e.a> list) {
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).j0(this.f58182h);
            }
        }
    }
}
