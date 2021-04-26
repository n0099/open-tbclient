package d.a.j0.q0.l1;

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
import d.a.c.j.e.n;
import d.a.i0.r.q.a2;
import d.a.j0.q0.n1.d.a0;
import d.a.j0.q0.n1.d.e;
import d.a.j0.q0.n1.d.g;
import d.a.j0.q0.n1.d.h;
import d.a.j0.q0.n1.d.j;
import d.a.j0.q0.n1.d.k;
import d.a.j0.q0.n1.d.l;
import d.a.j0.q0.n1.d.m;
import d.a.j0.q0.n1.d.p;
import d.a.j0.q0.n1.d.r;
import d.a.j0.q0.n1.d.t;
import d.a.j0.q0.n1.d.u;
import d.a.j0.q0.n1.d.v;
import d.a.j0.q0.n1.d.w;
import d.a.j0.q0.n1.d.x;
import d.a.j0.q0.n1.d.y;
import d.a.j0.q0.n1.d.z;
import d.a.j0.q0.s;
import d.a.j0.s2.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public boolean A;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f57969a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f57970b;

    /* renamed from: c  reason: collision with root package name */
    public s f57971c;

    /* renamed from: e  reason: collision with root package name */
    public y f57973e;

    /* renamed from: f  reason: collision with root package name */
    public k f57974f;

    /* renamed from: g  reason: collision with root package name */
    public v f57975g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.q0.n1.d.s f57976h;

    /* renamed from: i  reason: collision with root package name */
    public j f57977i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public d.a.j0.q0.n1.d.a t;
    public d.a.j0.q0.n1.d.c u;
    public d.a.j0.q0.n1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f57972d = new LinkedList();
    public CustomMessageListener B = new C1418a(2003008);

    /* renamed from: d.a.j0.q0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1418a extends CustomMessageListener {
        public C1418a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.a.c.j.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.a.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.j0.x.y) {
                        d.a.j0.x.y yVar = (d.a.j0.x.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && a.this.f57972d != null) {
                            yVar.n(a.this.f57969a.getPageContext(), a.this.f57969a.getUniqueId());
                            if (a.this.A) {
                                yVar.setFrom("c13010");
                            }
                            a.this.f57972d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f57970b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.f57969a = frsCommonTabFragment;
        this.B.setPriority(1);
        this.B.setSelfListener(true);
        this.f57969a.registerListener(this.B);
        this.f57973e = new y(frsCommonTabFragment.o(), a2.N2, frsCommonTabFragment.getUniqueId());
        this.f57974f = new k(frsCommonTabFragment.o(), a2.O2, frsCommonTabFragment.getUniqueId());
        this.f57975g = new v(frsCommonTabFragment.o(), a2.Q2, frsCommonTabFragment.getUniqueId());
        this.f57976h = new d.a.j0.q0.n1.d.s(frsCommonTabFragment.o(), a2.R2, frsCommonTabFragment.getUniqueId());
        this.f57977i = new j(frsCommonTabFragment.o(), a2.T2, frsCommonTabFragment.getUniqueId());
        this.j = new m(frsCommonTabFragment.o(), a2.U2, frsCommonTabFragment.getUniqueId());
        this.k = new w(frsCommonTabFragment.o(), a2.s3, frsCommonTabFragment.getUniqueId());
        this.l = new a0(frsCommonTabFragment.o(), a2.Z2, frsCommonTabFragment.getUniqueId());
        u uVar = new u(frsCommonTabFragment.o(), a2.a3, frsCommonTabFragment.getUniqueId());
        this.m = uVar;
        uVar.v0(frsCommonTabFragment.l);
        r rVar = new r(frsCommonTabFragment.o(), a2.b3, frsCommonTabFragment.getUniqueId());
        this.n = rVar;
        rVar.v0(frsCommonTabFragment.l);
        this.o = new z(frsCommonTabFragment.getPageContext(), a2.e3, frsCommonTabFragment.getUniqueId());
        this.p = new l(frsCommonTabFragment.getPageContext(), a2.x3, frsCommonTabFragment.getUniqueId());
        this.q = new t(frsCommonTabFragment.getPageContext(), a2.d3, frsCommonTabFragment.getUniqueId());
        this.r = new p(frsCommonTabFragment.getPageContext(), a2.c3, frsCommonTabFragment.getUniqueId());
        this.s = new x(frsCommonTabFragment.getPageContext(), a2.j3, frsCommonTabFragment.getUniqueId());
        this.t = new d.a.j0.q0.n1.d.a(frsCommonTabFragment.getPageContext(), a2.W2, frsCommonTabFragment.getUniqueId());
        this.u = new d.a.j0.q0.n1.d.c(frsCommonTabFragment.getPageContext(), a2.S2, frsCommonTabFragment.getUniqueId());
        this.v = new d.a.j0.q0.n1.d.b(frsCommonTabFragment.getPageContext(), a2.l3, frsCommonTabFragment.getUniqueId());
        this.w = new g(frsCommonTabFragment.getPageContext(), a2.k3, frsCommonTabFragment.getUniqueId());
        this.x = new h(frsCommonTabFragment.getPageContext(), a2.m3, frsCommonTabFragment.getUniqueId());
        this.y = new z(frsCommonTabFragment.getPageContext(), a2.n3, frsCommonTabFragment.getUniqueId());
        this.f57971c = new s(frsCommonTabFragment.getPageContext(), d.a.j0.q0.t.f58775f);
        if (!z) {
            this.z = new e(frsCommonTabFragment.getPageContext(), a2.Y2, frsCommonTabFragment.getUniqueId());
        }
        this.f57972d.add(this.f57973e);
        this.f57972d.add(this.f57974f);
        this.f57972d.add(this.f57975g);
        this.f57972d.add(this.f57976h);
        this.f57972d.add(this.f57977i);
        this.f57972d.add(this.j);
        this.f57972d.add(this.k);
        this.f57972d.add(this.l);
        this.f57972d.add(this.m);
        this.f57972d.add(this.n);
        this.f57972d.add(this.o);
        this.f57972d.add(this.p);
        this.f57972d.add(this.q);
        this.f57972d.add(this.r);
        this.f57972d.add(this.s);
        this.f57972d.add(this.t);
        this.f57972d.add(this.u);
        this.f57972d.add(this.v);
        this.f57972d.add(this.w);
        this.f57972d.add(this.x);
        this.f57972d.add(this.y);
        this.f57972d.add(this.f57971c);
        if (!z) {
            this.f57972d.add(this.z);
        }
        e();
        for (d.a.c.j.e.a aVar : this.f57972d) {
            if (aVar instanceof d.a.j0.q0.k) {
                d.a.j0.q0.k kVar = (d.a.j0.q0.k) aVar;
                kVar.p0(bdTypeRecyclerView);
                if (frsCommonTabFragment.k == 89) {
                    kVar.setFrom("c13010");
                }
            }
            if (aVar instanceof d.a.j0.x.z) {
                ((d.a.j0.x.z) aVar).q(frsCommonTabFragment.k);
            }
        }
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.f57969a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.a.j0.q0.k) {
                    ((d.a.j0.q0.k) next).n(this.f57969a.getPageContext(), this.f57969a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.j.e.a> list = this.f57972d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
            l(frsViewData);
        }
        k();
        bdTypeRecyclerView.a(this.f57972d);
        m();
    }

    public final void e() {
        d.a.c.j.e.a<?, ?> h2 = d.a.j0.s2.w.p().h(this.f57969a, AdvertAppInfo.h4);
        d.a.c.j.e.a<?, ?> h3 = d.a.j0.s2.w.p().h(this.f57969a, AdvertAppInfo.k4);
        d.a.c.j.e.a<?, ?> h4 = d.a.j0.s2.w.p().h(this.f57969a, AdvertAppInfo.o4);
        d.a.c.j.e.a<?, ?> h5 = d.a.j0.s2.w.p().h(this.f57969a, AdvertAppInfo.p4);
        d.a.c.j.e.a<?, ?> h6 = d.a.j0.s2.w.p().h(this.f57969a, AdvertAppInfo.q4);
        this.f57972d.add(h2);
        this.f57972d.add(h3);
        this.f57972d.add(h4);
        this.f57972d.add(h5);
        this.f57972d.add(h6);
        d.a.c.j.e.a<?, ?> d2 = d.a.j0.r0.b.e().d(this.f57969a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.a.c.j.e.a<?, ?> d3 = d.a.j0.r0.b.e().d(this.f57969a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f57972d.add(d2);
        this.f57972d.add(d3);
    }

    public void f() {
        this.f57970b.getAdapter().notifyDataSetChanged();
    }

    public void g() {
        for (d.a.c.j.e.a aVar : this.f57972d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).i0();
            } else if (aVar instanceof o) {
                ((o) aVar).onDestroy();
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
                    if (!a2Var.C2()) {
                        arrayList2.add(next);
                    } else {
                        a2Var.N3(null);
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

    public void i(ArrayList<n> arrayList) {
        k();
        this.f57970b.setData(h(arrayList));
    }

    public void j(boolean z) {
    }

    public final void k() {
        if (ListUtils.isEmpty(this.f57972d) || this.f57969a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57972d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).q0(this.f57969a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f57972d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57972d) {
            if (aVar instanceof d.a.j0.q0.k) {
                ((d.a.j0.q0.k) aVar).n0(frsViewData);
            }
        }
    }

    public final void m() {
        if (this.f57969a == null || ListUtils.isEmpty(this.f57972d)) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f57972d) {
            if (aVar instanceof d.a.j0.q0.j2.d) {
                d.a.j0.q0.j2.d dVar = (d.a.j0.q0.j2.d) aVar;
                if (dVar.i() != null) {
                    dVar.i().f57891a = this.f57969a.o;
                    dVar.i().f57893c = this.f57969a.f16053i;
                    dVar.i().f57894d = this.f57969a.k;
                    d.a.j0.q0.j2.b i2 = dVar.i();
                    FrsCommonTabFragment frsCommonTabFragment = this.f57969a;
                    i2.f57897g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.i().f57896f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.i().f57896f = 12;
                    }
                }
            }
        }
    }
}
