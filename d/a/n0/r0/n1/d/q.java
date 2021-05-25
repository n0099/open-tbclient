package d.a.n0.r0.n1.d;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.q.z1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class q implements e0 {

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f59058a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.j.e.s f59059b;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, a2> f59061d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.c.j.e.n> f59062e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f59063f;

    /* renamed from: i  reason: collision with root package name */
    public d0 f59066i;
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
    public List<d.a.c.j.e.a> f59060c = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f59064g = false;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.n0.r0.i f59065h = new d.a.n0.r0.i();

    public q(FrsFragment frsFragment, d.a.c.j.e.s sVar, boolean z) {
        this.f59059b = sVar;
        p(frsFragment, sVar);
        this.f59061d = new HashMap<>();
        n(z);
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void a(String str) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.n0.z.z) {
                ((d.a.n0.z.z) aVar).a(str);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void b() {
        List<d.a.c.j.e.n> data;
        d.a.c.j.e.s sVar = this.f59059b;
        if (sVar == null || sVar.getData() == null || this.f59059b.getData().size() == 0 || (data = this.f59059b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.a.c.j.e.n nVar : data) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.y0() != 0) {
                    a2Var.Y2();
                }
            } else if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Y2();
                }
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public int c() {
        if (this.j != null) {
            return R.id.frs_fortune_bag_item;
        }
        return 0;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void d(d.a.c.j.e.w wVar) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).Z(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.Z(wVar);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void e() {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).n(this.f59058a.getPageContext(), this.f59058a.getUniqueId());
            }
        }
        z(this.f59060c);
    }

    @Override // d.a.n0.r0.n1.d.e0
    public List<d.a.c.j.e.n> f() {
        d.a.c.j.e.s sVar = this.f59059b;
        if (sVar != null) {
            return sVar.getData();
        }
        return null;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void g(ArrayList<d.a.c.j.e.n> arrayList, FrsViewData frsViewData) {
        v(frsViewData);
        u();
        d.a.n0.e3.v.f(arrayList, 1);
        o(arrayList);
        x(arrayList);
        s(arrayList);
        Iterator<d.a.c.j.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.n next = it.next();
            if ((next instanceof z1) && ((z1) next).w.y2()) {
                it.remove();
            }
        }
        this.f59059b.setData(arrayList);
        this.f59063f = frsViewData;
        w();
        y();
        this.f59062e = arrayList;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public HashMap<Integer, a2> h() {
        return this.f59061d;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public int i() {
        if (this.j != null) {
            return R.id.frs_bawu_center;
        }
        return 0;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public int j() {
        if (this.j != null) {
            return R.id.frs_my_service_item;
        }
        return 0;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public boolean k(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
            return false;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar != null && aVar.G() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void l(d.a.n0.r0.f fVar) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).j0(fVar);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void m() {
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).h0();
            } else if (aVar instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) aVar).onDestroy();
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void n(boolean z) {
        if (this.f59064g != z) {
            this.f59064g = z;
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void notifyDataSetChanged() {
        if (this.f59059b.getListAdapter() != null) {
            this.f59059b.getListAdapter().notifyDataSetChanged();
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
                HashMap<Integer, a2> hashMap = this.f59061d;
                if (hashMap != null && !hashMap.containsValue(nVar)) {
                    this.f59061d.put(Integer.valueOf(i2), (a2) nVar);
                }
            }
        }
        return arrayList2;
    }

    public void p(FrsFragment frsFragment, d.a.c.j.e.s sVar) {
        this.f59058a = frsFragment;
        this.j = d.a.n0.r0.e.e().c(frsFragment.getPageContext(), d.a.n0.e3.x.J3, this.f59058a.getUniqueId(), false);
        y yVar = new y(frsFragment.o(), a2.P2, this.f59058a.getUniqueId());
        this.k = yVar;
        yVar.n0(sVar);
        k kVar = new k(frsFragment.o(), a2.Q2, this.f59058a.getUniqueId());
        this.l = kVar;
        kVar.n0(sVar);
        v vVar = new v(frsFragment.o(), a2.S2, this.f59058a.getUniqueId());
        this.m = vVar;
        vVar.n0(sVar);
        s sVar2 = new s(frsFragment.o(), a2.T2, this.f59058a.getUniqueId());
        this.n = sVar2;
        sVar2.n0(sVar);
        j jVar = new j(frsFragment.o(), a2.V2, this.f59058a.getUniqueId());
        this.o = jVar;
        jVar.n0(sVar);
        m mVar = new m(frsFragment.o(), a2.W2, this.f59058a.getUniqueId());
        this.p = mVar;
        mVar.n0(sVar);
        a0 a0Var = new a0(frsFragment.o(), a2.b3, this.f59058a.getUniqueId());
        this.r = a0Var;
        a0Var.n0(sVar);
        w wVar = new w(frsFragment.o(), a2.u3, this.f59058a.getUniqueId());
        this.q = wVar;
        wVar.n0(sVar);
        u uVar = new u(frsFragment.o(), a2.c3, this.f59058a.getUniqueId());
        this.s = uVar;
        uVar.n0(sVar);
        r rVar = new r(frsFragment.o(), a2.d3, this.f59058a.getUniqueId());
        this.t = rVar;
        rVar.n0(sVar);
        z zVar = new z(frsFragment.getPageContext(), a2.g3, this.f59058a.getUniqueId());
        this.u = zVar;
        zVar.n0(sVar);
        l lVar = new l(frsFragment.getPageContext(), a2.z3, this.f59058a.getUniqueId());
        this.v = lVar;
        lVar.n0(sVar);
        p pVar = new p(frsFragment.getPageContext(), a2.e3, this.f59058a.getUniqueId());
        pVar.n0(sVar);
        x xVar = new x(frsFragment.getPageContext(), a2.l3, this.f59058a.getUniqueId());
        xVar.n0(sVar);
        a aVar = new a(frsFragment.getPageContext(), a2.Y2, frsFragment.getUniqueId());
        aVar.n0(sVar);
        aVar.q(1);
        c cVar = new c(frsFragment.getPageContext(), a2.U2, frsFragment.getUniqueId());
        cVar.n0(sVar);
        b bVar = new b(frsFragment.getPageContext(), a2.n3, this.f59058a.getUniqueId());
        bVar.n0(sVar);
        bVar.I0(true);
        g gVar = new g(frsFragment.getPageContext(), a2.m3, this.f59058a.getUniqueId());
        gVar.n0(sVar);
        gVar.I0(true);
        h hVar = new h(frsFragment.getPageContext(), a2.o3, this.f59058a.getUniqueId());
        hVar.n0(sVar);
        hVar.J0(true);
        z zVar2 = new z(frsFragment.getPageContext(), a2.p3, this.f59058a.getUniqueId());
        zVar2.n0(sVar);
        o oVar = new o(frsFragment.getPageContext(), a2.y3, this.f59058a.getUniqueId());
        oVar.n0(sVar);
        n nVar = new n(frsFragment.getPageContext(), a2.q3, this.f59058a.getUniqueId());
        nVar.n0(sVar);
        this.f59066i = new d0(frsFragment.getPageContext(), d.a.n0.e3.q.f54201g, this.f59058a.getUniqueId());
        t tVar = new t(frsFragment.getPageContext(), a2.f3, this.f59058a.getUniqueId());
        this.w = tVar;
        tVar.n0(sVar);
        d.a.c.j.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.n0.r0.e.e().a(frsFragment.getPageContext(), this.f59058a.getUniqueId(), true);
        d.a.c.j.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.n0.r0.e.e().d(frsFragment.getPageContext(), a2.D3, this.f59058a.getUniqueId());
        d.a.n0.r0.s sVar3 = new d.a.n0.r0.s(frsFragment.getPageContext(), d.a.n0.r0.t.f59658f);
        i iVar = new i(frsFragment.getPageContext(), d.a.n0.r0.v.f59700e);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.a.n0.r0.x.f59802i, this.f59058a.getUniqueId());
        e eVar = new e(frsFragment.getPageContext(), a2.a3, this.f59058a.getUniqueId());
        eVar.h0((BdTypeRecyclerView) sVar);
        this.f59060c.add(this.j);
        this.f59060c.add(this.k);
        this.f59060c.add(this.l);
        this.f59060c.add(this.m);
        this.f59060c.add(this.n);
        this.f59060c.add(this.o);
        this.f59060c.add(this.p);
        this.f59060c.add(this.q);
        this.f59060c.add(this.r);
        this.f59060c.add(this.s);
        this.f59060c.add(this.t);
        this.f59060c.add(this.f59066i);
        this.f59060c.add(pVar);
        this.f59060c.add(xVar);
        this.f59060c.add(aVar);
        this.f59060c.add(cVar);
        this.f59060c.add(bVar);
        this.f59060c.add(gVar);
        this.f59060c.add(hVar);
        this.f59060c.add(this.w);
        this.f59060c.add(this.u);
        this.f59060c.add(this.v);
        this.f59060c.add(a2);
        this.f59060c.add(d2);
        this.f59060c.add(sVar3);
        this.f59060c.add(iVar);
        this.f59060c.add(oVar);
        this.f59060c.add(nVar);
        this.f59060c.add(frsUserRecommendAdapter);
        this.f59060c.add(zVar2);
        this.f59060c.add(eVar);
        this.f59060c.add(d.a.n0.s0.b.e().b(this.f59058a.getBaseFragmentActivity(), AdvertAppInfo.l4));
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(this.f59058a, 1);
        bVar2.t(this.f59060c);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        z(this.f59060c);
        sVar.a(this.f59060c);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f59058a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        t("page_frs");
        if (absDelegateAdapterList.isEmpty()) {
            return;
        }
        Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
        while (it.hasNext()) {
            d.a.c.j.e.a<?, ?> next = it.next();
            if (next instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) next).n(this.f59058a.getPageContext(), this.f59058a.getUniqueId());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(absDelegateAdapterList);
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list != null) {
            list.addAll(arrayList);
        }
        d.a.c.j.e.s sVar4 = this.f59059b;
        if (sVar4 != null) {
            sVar4.a(arrayList);
        }
    }

    public final boolean q(d.a.c.j.e.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == a2.J2 || type == a2.f3 || type == a2.g3 || type == a2.p3 || type == a2.y3;
    }

    public void r() {
        ArrayList<d.a.c.j.e.n> arrayList = this.f59062e;
        if (arrayList != null) {
            this.f59059b.setData(arrayList);
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
                String W0 = a2Var.W0();
                if (nVar instanceof d.a.n0.r0.v) {
                    a2Var.needTopMargin = false;
                } else if (nVar != null && !q(nVar)) {
                    a2Var.needTopMargin = false;
                } else if ((nVar instanceof z1) && q(nVar) && !TextUtils.isEmpty(((z1) nVar).w.W0())) {
                    a2Var.needTopMargin = true;
                } else if (q(nVar2) && !TextUtils.isEmpty(W0)) {
                    a2Var.needTopMargin = true;
                } else {
                    a2Var.needTopMargin = false;
                }
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void setFromCDN(boolean z) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).setFromCDN(z);
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
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public final void u() {
        if (ListUtils.isEmpty(this.f59060c) || this.f59058a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f59058a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void w() {
        d.a.n0.r0.j2.b i2;
        if (this.f59063f == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if ((aVar instanceof d.a.n0.r0.j2.d) && (i2 = ((d.a.n0.r0.j2.d) aVar).i()) != null) {
                if (this.f59063f.needLog == 1) {
                    i2.f58774a = true;
                } else {
                    i2.f58774a = false;
                }
                if (this.f59063f.getForum() != null) {
                    i2.f58776c = this.f59063f.getForum().getId();
                }
                FrsFragment frsFragment = this.f59058a;
                if (frsFragment != null && frsFragment.b0() != null) {
                    int N = this.f59058a.b0().N();
                    if (N == -1) {
                        N = this.f59058a.b0().M();
                    }
                    i2.f58775b = N;
                }
            }
        }
    }

    public final void x(ArrayList<d.a.c.j.e.n> arrayList) {
        List<d.a.c.j.e.a> list = this.f59060c;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.a.c.j.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == a2.I2.getId()) {
                i2++;
            }
        }
        for (d.a.c.j.e.a aVar : this.f59060c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).q0(i2);
            }
        }
    }

    public final void y() {
        d0 d0Var;
        FrsViewData frsViewData = this.f59063f;
        if (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f59063f.getForum().getId()) || (d0Var = this.f59066i) == null) {
            return;
        }
        d0Var.x0(this.f59063f.getForum().getId());
    }

    public final void z(List<d.a.c.j.e.a> list) {
        if (list == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : list) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).i0(this.f59065h);
            }
        }
    }
}
