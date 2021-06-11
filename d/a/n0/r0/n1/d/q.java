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
    public FrsFragment f62749a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.k.e.s f62750b;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, a2> f62752d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f62753e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f62754f;

    /* renamed from: i  reason: collision with root package name */
    public d0 f62757i;
    public d.a.c.k.e.a j;
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
    public List<d.a.c.k.e.a> f62751c = new LinkedList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f62755g = false;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.n0.r0.i f62756h = new d.a.n0.r0.i();

    public q(FrsFragment frsFragment, d.a.c.k.e.s sVar, boolean z) {
        this.f62750b = sVar;
        p(frsFragment, sVar);
        this.f62752d = new HashMap<>();
        n(z);
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void a(String str) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.n0.z.z) {
                ((d.a.n0.z.z) aVar).a(str);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void b() {
        List<d.a.c.k.e.n> data;
        d.a.c.k.e.s sVar = this.f62750b;
        if (sVar == null || sVar.getData() == null || this.f62750b.getData().size() == 0 || (data = this.f62750b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.a.c.k.e.n nVar : data) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.y0() != 0) {
                    a2Var.Z2();
                }
            } else if (nVar instanceof z1) {
                z1 z1Var = (z1) nVar;
                if (z1Var.w.y0() != 0) {
                    z1Var.w.Z2();
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
    public void d(d.a.c.k.e.w wVar) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).a0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.a0(wVar);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void e() {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).o(this.f62749a.getPageContext(), this.f62749a.getUniqueId());
            }
        }
        z(this.f62751c);
    }

    @Override // d.a.n0.r0.n1.d.e0
    public List<d.a.c.k.e.n> f() {
        d.a.c.k.e.s sVar = this.f62750b;
        if (sVar != null) {
            return sVar.getData();
        }
        return null;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void g(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        v(frsViewData);
        u();
        d.a.n0.e3.v.f(arrayList, 1);
        o(arrayList);
        x(arrayList);
        s(arrayList);
        Iterator<d.a.c.k.e.n> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.n next = it.next();
            if ((next instanceof z1) && ((z1) next).w.z2()) {
                it.remove();
            }
        }
        this.f62750b.setData(arrayList);
        this.f62754f = frsViewData;
        w();
        y();
        this.f62753e = arrayList;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public HashMap<Integer, a2> h() {
        return this.f62752d;
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
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar != null && aVar.H() == bdUniqueId) {
                return true;
            }
        }
        return false;
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void l(d.a.n0.r0.f fVar) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).k0(fVar);
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void m() {
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).i0();
            } else if (aVar instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) aVar).onDestroy();
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void n(boolean z) {
        if (this.f62755g != z) {
            this.f62755g = z;
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void notifyDataSetChanged() {
        if (this.f62750b.getListAdapter() != null) {
            this.f62750b.getListAdapter().notifyDataSetChanged();
        }
    }

    public final ArrayList<Integer> o(ArrayList<d.a.c.k.e.n> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.k.e.n nVar = arrayList.get(i2);
            if (nVar instanceof AdvertAppInfo) {
                arrayList2.add(Integer.valueOf(i2));
                HashMap<Integer, a2> hashMap = this.f62752d;
                if (hashMap != null && !hashMap.containsValue(nVar)) {
                    this.f62752d.put(Integer.valueOf(i2), (a2) nVar);
                }
            }
        }
        return arrayList2;
    }

    public void p(FrsFragment frsFragment, d.a.c.k.e.s sVar) {
        this.f62749a = frsFragment;
        this.j = d.a.n0.r0.e.e().c(frsFragment.getPageContext(), d.a.n0.e3.x.M3, this.f62749a.getUniqueId(), false);
        y yVar = new y(frsFragment.p(), a2.S2, this.f62749a.getUniqueId());
        this.k = yVar;
        yVar.m0(sVar);
        k kVar = new k(frsFragment.p(), a2.T2, this.f62749a.getUniqueId());
        this.l = kVar;
        kVar.m0(sVar);
        v vVar = new v(frsFragment.p(), a2.V2, this.f62749a.getUniqueId());
        this.m = vVar;
        vVar.m0(sVar);
        s sVar2 = new s(frsFragment.p(), a2.W2, this.f62749a.getUniqueId());
        this.n = sVar2;
        sVar2.m0(sVar);
        j jVar = new j(frsFragment.p(), a2.Y2, this.f62749a.getUniqueId());
        this.o = jVar;
        jVar.m0(sVar);
        m mVar = new m(frsFragment.p(), a2.Z2, this.f62749a.getUniqueId());
        this.p = mVar;
        mVar.m0(sVar);
        a0 a0Var = new a0(frsFragment.p(), a2.e3, this.f62749a.getUniqueId());
        this.r = a0Var;
        a0Var.m0(sVar);
        w wVar = new w(frsFragment.p(), a2.x3, this.f62749a.getUniqueId());
        this.q = wVar;
        wVar.m0(sVar);
        u uVar = new u(frsFragment.p(), a2.f3, this.f62749a.getUniqueId());
        this.s = uVar;
        uVar.m0(sVar);
        r rVar = new r(frsFragment.p(), a2.g3, this.f62749a.getUniqueId());
        this.t = rVar;
        rVar.m0(sVar);
        z zVar = new z(frsFragment.getPageContext(), a2.j3, this.f62749a.getUniqueId());
        this.u = zVar;
        zVar.m0(sVar);
        l lVar = new l(frsFragment.getPageContext(), a2.C3, this.f62749a.getUniqueId());
        this.v = lVar;
        lVar.m0(sVar);
        p pVar = new p(frsFragment.getPageContext(), a2.h3, this.f62749a.getUniqueId());
        pVar.m0(sVar);
        x xVar = new x(frsFragment.getPageContext(), a2.o3, this.f62749a.getUniqueId());
        xVar.m0(sVar);
        a aVar = new a(frsFragment.getPageContext(), a2.b3, frsFragment.getUniqueId());
        aVar.m0(sVar);
        aVar.r(1);
        c cVar = new c(frsFragment.getPageContext(), a2.X2, frsFragment.getUniqueId());
        cVar.m0(sVar);
        b bVar = new b(frsFragment.getPageContext(), a2.q3, this.f62749a.getUniqueId());
        bVar.m0(sVar);
        bVar.J0(true);
        g gVar = new g(frsFragment.getPageContext(), a2.p3, this.f62749a.getUniqueId());
        gVar.m0(sVar);
        gVar.J0(true);
        h hVar = new h(frsFragment.getPageContext(), a2.r3, this.f62749a.getUniqueId());
        hVar.m0(sVar);
        hVar.K0(true);
        z zVar2 = new z(frsFragment.getPageContext(), a2.s3, this.f62749a.getUniqueId());
        zVar2.m0(sVar);
        o oVar = new o(frsFragment.getPageContext(), a2.B3, this.f62749a.getUniqueId());
        oVar.m0(sVar);
        n nVar = new n(frsFragment.getPageContext(), a2.t3, this.f62749a.getUniqueId());
        nVar.m0(sVar);
        this.f62757i = new d0(frsFragment.getPageContext(), d.a.n0.e3.q.f57890g, this.f62749a.getUniqueId());
        t tVar = new t(frsFragment.getPageContext(), a2.i3, this.f62749a.getUniqueId());
        this.w = tVar;
        tVar.m0(sVar);
        d.a.c.k.e.a<? extends z1, ? extends TypeAdapter.ViewHolder> a2 = d.a.n0.r0.e.e().a(frsFragment.getPageContext(), this.f62749a.getUniqueId(), true);
        d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> d2 = d.a.n0.r0.e.e().d(frsFragment.getPageContext(), a2.G3, this.f62749a.getUniqueId());
        d.a.n0.r0.s sVar3 = new d.a.n0.r0.s(frsFragment.getPageContext(), d.a.n0.r0.t.f63349f);
        i iVar = new i(frsFragment.getPageContext(), d.a.n0.r0.v.f63391e);
        FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.a.n0.r0.x.f63493i, this.f62749a.getUniqueId());
        e eVar = new e(frsFragment.getPageContext(), a2.d3, this.f62749a.getUniqueId());
        eVar.i0((BdTypeRecyclerView) sVar);
        this.f62751c.add(this.j);
        this.f62751c.add(this.k);
        this.f62751c.add(this.l);
        this.f62751c.add(this.m);
        this.f62751c.add(this.n);
        this.f62751c.add(this.o);
        this.f62751c.add(this.p);
        this.f62751c.add(this.q);
        this.f62751c.add(this.r);
        this.f62751c.add(this.s);
        this.f62751c.add(this.t);
        this.f62751c.add(this.f62757i);
        this.f62751c.add(pVar);
        this.f62751c.add(xVar);
        this.f62751c.add(aVar);
        this.f62751c.add(cVar);
        this.f62751c.add(bVar);
        this.f62751c.add(gVar);
        this.f62751c.add(hVar);
        this.f62751c.add(this.w);
        this.f62751c.add(this.u);
        this.f62751c.add(this.v);
        this.f62751c.add(a2);
        this.f62751c.add(d2);
        this.f62751c.add(sVar3);
        this.f62751c.add(iVar);
        this.f62751c.add(oVar);
        this.f62751c.add(nVar);
        this.f62751c.add(frsUserRecommendAdapter);
        this.f62751c.add(zVar2);
        this.f62751c.add(eVar);
        this.f62751c.add(d.a.n0.s0.b.e().b(this.f62749a.getBaseFragmentActivity(), AdvertAppInfo.o4));
        d.a.n0.e.f.b bVar2 = new d.a.n0.e.f.b(this.f62749a, 1);
        bVar2.t(this.f62751c);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
        z(this.f62751c);
        sVar.a(this.f62751c);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003008);
        customMessage.setTag(this.f62749a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        t("page_frs");
        if (absDelegateAdapterList.isEmpty()) {
            return;
        }
        Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
        while (it.hasNext()) {
            d.a.c.k.e.a<?, ?> next = it.next();
            if (next instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) next).o(this.f62749a.getPageContext(), this.f62749a.getUniqueId());
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(absDelegateAdapterList);
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list != null) {
            list.addAll(arrayList);
        }
        d.a.c.k.e.s sVar4 = this.f62750b;
        if (sVar4 != null) {
            sVar4.a(arrayList);
        }
    }

    public final boolean q(d.a.c.k.e.n nVar) {
        if (nVar == null) {
            return false;
        }
        BdUniqueId type = nVar.getType();
        return type == a2.M2 || type == a2.i3 || type == a2.j3 || type == a2.s3 || type == a2.B3;
    }

    public void r() {
        ArrayList<d.a.c.k.e.n> arrayList = this.f62753e;
        if (arrayList != null) {
            this.f62750b.setData(arrayList);
        }
        notifyDataSetChanged();
    }

    public final void s(ArrayList<d.a.c.k.e.n> arrayList) {
        int count = ListUtils.getCount(arrayList);
        for (int i2 = 0; i2 < count; i2++) {
            d.a.c.k.e.n nVar = (d.a.c.k.e.n) ListUtils.getItem(arrayList, i2 - 1);
            d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, i2);
            if (nVar2 instanceof z1) {
                a2 a2Var = ((z1) nVar2).w;
                if (i2 == 0) {
                    a2Var.isFirstFloor = true;
                } else {
                    a2Var.isFirstFloor = false;
                }
                String X0 = a2Var.X0();
                if (nVar instanceof d.a.n0.r0.v) {
                    a2Var.needTopMargin = false;
                } else if (nVar != null && !q(nVar)) {
                    a2Var.needTopMargin = false;
                } else if ((nVar instanceof z1) && q(nVar) && !TextUtils.isEmpty(((z1) nVar).w.X0())) {
                    a2Var.needTopMargin = true;
                } else if (q(nVar2) && !TextUtils.isEmpty(X0)) {
                    a2Var.needTopMargin = true;
                } else {
                    a2Var.needTopMargin = false;
                }
            }
        }
    }

    @Override // d.a.n0.r0.n1.d.e0
    public void setFromCDN(boolean z) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
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
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.n0.o.f) {
                ((d.a.n0.o.f) aVar).g(str);
            }
        }
    }

    public final void u() {
        if (ListUtils.isEmpty(this.f62751c) || this.f62749a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f62749a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).l0(frsViewData);
            }
        }
    }

    public final void w() {
        d.a.n0.r0.j2.b j;
        if (this.f62754f == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if ((aVar instanceof d.a.n0.r0.j2.d) && (j = ((d.a.n0.r0.j2.d) aVar).j()) != null) {
                if (this.f62754f.needLog == 1) {
                    j.f62465a = true;
                } else {
                    j.f62465a = false;
                }
                if (this.f62754f.getForum() != null) {
                    j.f62467c = this.f62754f.getForum().getId();
                }
                FrsFragment frsFragment = this.f62749a;
                if (frsFragment != null && frsFragment.e0() != null) {
                    int R = this.f62749a.e0().R();
                    if (R == -1) {
                        R = this.f62749a.e0().Q();
                    }
                    j.f62466b = R;
                }
            }
        }
    }

    public final void x(ArrayList<d.a.c.k.e.n> arrayList) {
        List<d.a.c.k.e.a> list = this.f62751c;
        if (list == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == a2.L2.getId()) {
                i2++;
            }
        }
        for (d.a.c.k.e.a aVar : this.f62751c) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).q0(i2);
            }
        }
    }

    public final void y() {
        d0 d0Var;
        FrsViewData frsViewData = this.f62754f;
        if (frsViewData == null || frsViewData.getForum() == null || StringUtils.isNull(this.f62754f.getForum().getId()) || (d0Var = this.f62757i) == null) {
            return;
        }
        d0Var.y0(this.f62754f.getForum().getId());
    }

    public final void z(List<d.a.c.k.e.a> list) {
        if (list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).j0(this.f62756h);
            }
        }
    }
}
