package d.b.i0.p0.l1;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.i0.p0.n1.d.f;
import d.b.i0.p0.n1.d.g;
import d.b.i0.p0.n1.d.h0;
import d.b.i0.p0.n1.d.j0;
import d.b.i0.p0.n1.d.k;
import d.b.i0.p0.n1.d.k0;
import d.b.i0.p0.n1.d.l;
import d.b.i0.p0.s;
import d.b.i0.p0.t;
import d.b.i0.x.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f57777a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57778b;

    /* renamed from: c  reason: collision with root package name */
    public k f57779c;

    /* renamed from: d  reason: collision with root package name */
    public k f57780d;

    /* renamed from: e  reason: collision with root package name */
    public h0 f57781e;

    /* renamed from: f  reason: collision with root package name */
    public j0 f57782f;

    /* renamed from: g  reason: collision with root package name */
    public j0 f57783g;

    /* renamed from: h  reason: collision with root package name */
    public f f57784h;
    public s i;
    public d.b.i0.p0.n1.d.c k;
    public l l;
    public k0 m;
    public g n;
    public boolean o;
    public List<d.b.b.j.e.a> j = new LinkedList();
    public CustomMessageListener p = new C1394a(2003008);

    /* renamed from: d.b.i0.p0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1394a extends CustomMessageListener {
        public C1394a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.b.b.j.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.b.b.j.e.a<?, ?> next = it.next();
                    if (next instanceof y) {
                        y yVar = (y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && a.this.j != null) {
                            yVar.i(a.this.f57777a.getPageContext(), a.this.f57777a.getUniqueId());
                            if (a.this.o) {
                                yVar.setFrom("c13010");
                            }
                            a.this.j.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f57778b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.f57777a = frsCommonTabFragment;
        this.p.setPriority(1);
        this.p.setSelfListener(true);
        this.f57777a.registerListener(this.p);
        this.f57779c = new k(frsCommonTabFragment.getPageContext(), a2.H2, this.f57777a.getUniqueId());
        this.f57780d = new k(frsCommonTabFragment.getPageContext(), a2.d3, this.f57777a.getUniqueId());
        this.f57781e = new h0(frsCommonTabFragment.getPageContext(), a2.j3, this.f57777a.getUniqueId());
        this.f57782f = new j0(frsCommonTabFragment.getPageContext(), a2.e3, this.f57777a.getUniqueId());
        boolean z2 = this.f57777a.q;
        this.f57783g = new j0(frsCommonTabFragment.getPageContext(), a2.n3, this.f57777a.getUniqueId());
        boolean z3 = this.f57777a.q;
        this.f57784h = new f(frsCommonTabFragment.getPageContext(), a2.x3, this.f57777a.getUniqueId());
        this.i = new s(frsCommonTabFragment.getPageContext(), t.f58579f);
        d.b.i0.p0.n1.d.a aVar = new d.b.i0.p0.n1.d.a(frsCommonTabFragment.getPageContext(), a2.W2, frsCommonTabFragment.getUniqueId());
        this.k = new d.b.i0.p0.n1.d.c(frsCommonTabFragment.getPageContext(), a2.l3, this.f57777a.getUniqueId());
        this.l = new l(frsCommonTabFragment.getPageContext(), a2.k3, this.f57777a.getUniqueId());
        this.m = new k0(frsCommonTabFragment.getPageContext(), a2.m3, this.f57777a.getUniqueId());
        if (!z) {
            g gVar = new g(frsCommonTabFragment.getPageContext(), a2.Y2, this.f57777a.getUniqueId());
            this.n = gVar;
            gVar.l0(this.f57778b);
        }
        e();
        this.j.add(this.f57779c);
        this.j.add(this.f57780d);
        this.j.add(this.f57781e);
        this.j.add(this.f57782f);
        this.j.add(this.f57783g);
        this.j.add(this.f57784h);
        this.j.add(this.i);
        this.j.add(aVar);
        this.j.add(this.k);
        this.j.add(this.l);
        this.j.add(this.m);
        this.j.add(this.n);
        if (frsCommonTabFragment.k == 89) {
            this.o = true;
            this.f57779c.setFrom("c13010");
            this.f57780d.setFrom("c13010");
            this.f57781e.setFrom("c13010");
            this.f57782f.setFrom("c13010");
            this.f57783g.setFrom("c13010");
            i("page_frs_dynamic");
        }
        this.f57779c.p(frsCommonTabFragment.k);
        this.f57780d.p(frsCommonTabFragment.k);
        this.f57781e.p(frsCommonTabFragment.k);
        this.f57782f.p(frsCommonTabFragment.k);
        this.f57783g.p(frsCommonTabFragment.k);
        this.f57784h.p(frsCommonTabFragment.k);
        this.k.p(frsCommonTabFragment.k);
        this.l.p(frsCommonTabFragment.k);
        this.m.p(frsCommonTabFragment.k);
        this.f57779c.M0(frsCommonTabFragment.l);
        this.f57780d.M0(frsCommonTabFragment.l);
        boolean z4 = frsCommonTabFragment.l == 16;
        this.f57779c.O0(z4);
        this.f57782f.P0(z4);
        this.f57784h.A0(z4);
        this.f57781e.G0(z4);
        this.l.J0(z4);
        this.m.N0(z4);
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.f57777a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.b.b.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.b.b.j.e.a<?, ?> next = it.next();
                if (next instanceof d.b.i0.p0.k) {
                    ((d.b.i0.p0.k) next).i(this.f57777a.getPageContext(), this.f57777a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.b.b.j.e.a> list = this.j;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
            m(frsViewData);
        }
        l();
        bdTypeRecyclerView.a(this.j);
        n();
    }

    public final void e() {
        d.b.b.j.e.a<?, ?> i = d.b.i0.r2.s.o().i(this.f57777a, AdvertAppInfo.h4);
        d.b.b.j.e.a<?, ?> i2 = d.b.i0.r2.s.o().i(this.f57777a, AdvertAppInfo.k4);
        d.b.b.j.e.a<?, ?> i3 = d.b.i0.r2.s.o().i(this.f57777a, AdvertAppInfo.o4);
        d.b.b.j.e.a<?, ?> i4 = d.b.i0.r2.s.o().i(this.f57777a, AdvertAppInfo.p4);
        d.b.b.j.e.a<?, ?> i5 = d.b.i0.r2.s.o().i(this.f57777a, AdvertAppInfo.q4);
        this.j.add(i);
        this.j.add(i2);
        this.j.add(i3);
        this.j.add(i4);
        this.j.add(i5);
        d.b.b.j.e.a<?, ?> b2 = d.b.i0.q0.b.d().b(this.f57777a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.b.b.j.e.a<?, ?> b3 = d.b.i0.q0.b.d().b(this.f57777a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.j.add(b2);
        this.j.add(b3);
    }

    public void f() {
        this.f57778b.getAdapter().notifyDataSetChanged();
    }

    public void g() {
        for (d.b.b.j.e.a aVar : this.j) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).m0();
            } else if (aVar instanceof d.b.i0.r2.l) {
                ((d.b.i0.r2.l) aVar).onDestroy();
            }
        }
    }

    public final ArrayList<n> h(ArrayList<n> arrayList) {
        ArrayList<n> arrayList2 = new ArrayList<>();
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next instanceof a2) {
                a2 a2Var = (a2) next;
                if (a2Var.y0() != null) {
                    if (!a2Var.B2()) {
                        arrayList2.add(next);
                    } else {
                        a2Var.M3(null);
                        arrayList2.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            } else {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public final void i(String str) {
        List<d.b.b.j.e.a> list = this.j;
        if (list == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : list) {
            if (aVar instanceof d.b.i0.m.f) {
                ((d.b.i0.m.f) aVar).o(str);
            }
        }
    }

    public void j(ArrayList<n> arrayList) {
        l();
        this.f57778b.setData(h(arrayList));
    }

    public void k(boolean z) {
        k kVar = this.f57779c;
        if (kVar != null) {
            kVar.N0(z);
        }
        k kVar2 = this.f57780d;
        if (kVar2 != null) {
            kVar2.N0(z);
        }
        j0 j0Var = this.f57782f;
        if (j0Var != null) {
            j0Var.O0(z);
        }
        j0 j0Var2 = this.f57783g;
        if (j0Var2 != null) {
            j0Var2.O0(z);
        }
        f fVar = this.f57784h;
        if (fVar != null) {
            fVar.z0(z);
        }
    }

    public final void l() {
        if (ListUtils.isEmpty(this.j) || this.f57777a == null) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.j) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).r0(this.f57777a.getTbPageTag());
            }
        }
    }

    public final void m(FrsViewData frsViewData) {
        List<d.b.b.j.e.a> list = this.j;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.j) {
            if (aVar instanceof d.b.i0.p0.k) {
                ((d.b.i0.p0.k) aVar).p0(frsViewData);
            }
        }
    }

    public final void n() {
        if (this.f57777a == null || ListUtils.isEmpty(this.j)) {
            return;
        }
        for (d.b.b.j.e.a aVar : this.j) {
            if (aVar instanceof d.b.i0.p0.j2.d) {
                d.b.i0.p0.j2.d dVar = (d.b.i0.p0.j2.d) aVar;
                if (dVar.b() != null) {
                    dVar.b().f57700a = this.f57777a.o;
                    dVar.b().f57702c = this.f57777a.i;
                    dVar.b().f57703d = this.f57777a.k;
                    d.b.i0.p0.j2.b b2 = dVar.b();
                    FrsCommonTabFragment frsCommonTabFragment = this.f57777a;
                    b2.f57706g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.b().f57705f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.b().f57705f = 12;
                    }
                }
            }
        }
    }
}
