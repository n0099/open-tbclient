package d.b.j0.q0.l1;

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
import d.b.c.j.e.n;
import d.b.i0.r.q.a2;
import d.b.j0.q0.n1.d.a0;
import d.b.j0.q0.n1.d.e;
import d.b.j0.q0.n1.d.g;
import d.b.j0.q0.n1.d.h;
import d.b.j0.q0.n1.d.j;
import d.b.j0.q0.n1.d.k;
import d.b.j0.q0.n1.d.l;
import d.b.j0.q0.n1.d.m;
import d.b.j0.q0.n1.d.p;
import d.b.j0.q0.n1.d.r;
import d.b.j0.q0.n1.d.t;
import d.b.j0.q0.n1.d.u;
import d.b.j0.q0.n1.d.v;
import d.b.j0.q0.n1.d.w;
import d.b.j0.q0.n1.d.x;
import d.b.j0.q0.n1.d.y;
import d.b.j0.q0.n1.d.z;
import d.b.j0.q0.s;
import d.b.j0.s2.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public boolean A;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f59897a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f59898b;

    /* renamed from: c  reason: collision with root package name */
    public s f59899c;

    /* renamed from: e  reason: collision with root package name */
    public y f59901e;

    /* renamed from: f  reason: collision with root package name */
    public k f59902f;

    /* renamed from: g  reason: collision with root package name */
    public v f59903g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.j0.q0.n1.d.s f59904h;
    public j i;
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
    public d.b.j0.q0.n1.d.a t;
    public d.b.j0.q0.n1.d.c u;
    public d.b.j0.q0.n1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: d  reason: collision with root package name */
    public List<d.b.c.j.e.a> f59900d = new LinkedList();
    public CustomMessageListener B = new C1479a(2003008);

    /* renamed from: d.b.j0.q0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1479a extends CustomMessageListener {
        public C1479a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.b.c.j.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.b.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof d.b.j0.x.y) {
                        d.b.j0.x.y yVar = (d.b.j0.x.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && a.this.f59900d != null) {
                            yVar.i(a.this.f59897a.getPageContext(), a.this.f59897a.getUniqueId());
                            if (a.this.A) {
                                yVar.setFrom("c13010");
                            }
                            a.this.f59900d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f59898b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.f59897a = frsCommonTabFragment;
        this.B.setPriority(1);
        this.B.setSelfListener(true);
        this.f59897a.registerListener(this.B);
        this.f59901e = new y(frsCommonTabFragment.q(), a2.N2, frsCommonTabFragment.getUniqueId());
        this.f59902f = new k(frsCommonTabFragment.q(), a2.O2, frsCommonTabFragment.getUniqueId());
        this.f59903g = new v(frsCommonTabFragment.q(), a2.Q2, frsCommonTabFragment.getUniqueId());
        this.f59904h = new d.b.j0.q0.n1.d.s(frsCommonTabFragment.q(), a2.R2, frsCommonTabFragment.getUniqueId());
        this.i = new j(frsCommonTabFragment.q(), a2.T2, frsCommonTabFragment.getUniqueId());
        this.j = new m(frsCommonTabFragment.q(), a2.U2, frsCommonTabFragment.getUniqueId());
        this.k = new w(frsCommonTabFragment.q(), a2.s3, frsCommonTabFragment.getUniqueId());
        this.l = new a0(frsCommonTabFragment.q(), a2.Z2, frsCommonTabFragment.getUniqueId());
        u uVar = new u(frsCommonTabFragment.q(), a2.a3, frsCommonTabFragment.getUniqueId());
        this.m = uVar;
        uVar.v0(frsCommonTabFragment.l);
        r rVar = new r(frsCommonTabFragment.q(), a2.b3, frsCommonTabFragment.getUniqueId());
        this.n = rVar;
        rVar.v0(frsCommonTabFragment.l);
        this.o = new z(frsCommonTabFragment.getPageContext(), a2.e3, frsCommonTabFragment.getUniqueId());
        this.p = new l(frsCommonTabFragment.getPageContext(), a2.x3, frsCommonTabFragment.getUniqueId());
        this.q = new t(frsCommonTabFragment.getPageContext(), a2.d3, frsCommonTabFragment.getUniqueId());
        this.r = new p(frsCommonTabFragment.getPageContext(), a2.c3, frsCommonTabFragment.getUniqueId());
        this.s = new x(frsCommonTabFragment.getPageContext(), a2.j3, frsCommonTabFragment.getUniqueId());
        this.t = new d.b.j0.q0.n1.d.a(frsCommonTabFragment.getPageContext(), a2.W2, frsCommonTabFragment.getUniqueId());
        this.u = new d.b.j0.q0.n1.d.c(frsCommonTabFragment.getPageContext(), a2.S2, frsCommonTabFragment.getUniqueId());
        this.v = new d.b.j0.q0.n1.d.b(frsCommonTabFragment.getPageContext(), a2.l3, frsCommonTabFragment.getUniqueId());
        this.w = new g(frsCommonTabFragment.getPageContext(), a2.k3, frsCommonTabFragment.getUniqueId());
        this.x = new h(frsCommonTabFragment.getPageContext(), a2.m3, frsCommonTabFragment.getUniqueId());
        this.y = new z(frsCommonTabFragment.getPageContext(), a2.n3, frsCommonTabFragment.getUniqueId());
        this.f59899c = new s(frsCommonTabFragment.getPageContext(), d.b.j0.q0.t.f60668f);
        if (!z) {
            this.z = new e(frsCommonTabFragment.getPageContext(), a2.Y2, frsCommonTabFragment.getUniqueId());
        }
        this.f59900d.add(this.f59901e);
        this.f59900d.add(this.f59902f);
        this.f59900d.add(this.f59903g);
        this.f59900d.add(this.f59904h);
        this.f59900d.add(this.i);
        this.f59900d.add(this.j);
        this.f59900d.add(this.k);
        this.f59900d.add(this.l);
        this.f59900d.add(this.m);
        this.f59900d.add(this.n);
        this.f59900d.add(this.o);
        this.f59900d.add(this.p);
        this.f59900d.add(this.q);
        this.f59900d.add(this.r);
        this.f59900d.add(this.s);
        this.f59900d.add(this.t);
        this.f59900d.add(this.u);
        this.f59900d.add(this.v);
        this.f59900d.add(this.w);
        this.f59900d.add(this.x);
        this.f59900d.add(this.y);
        this.f59900d.add(this.f59899c);
        if (!z) {
            this.f59900d.add(this.z);
        }
        e();
        for (d.b.c.j.e.a aVar : this.f59900d) {
            if (aVar instanceof d.b.j0.q0.k) {
                d.b.j0.q0.k kVar = (d.b.j0.q0.k) aVar;
                kVar.q0(bdTypeRecyclerView);
                if (frsCommonTabFragment.k == 89) {
                    kVar.setFrom("c13010");
                }
            }
            if (aVar instanceof d.b.j0.x.z) {
                ((d.b.j0.x.z) aVar).p(frsCommonTabFragment.k);
            }
        }
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.f59897a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.b.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.b.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.b.j0.q0.k) {
                    ((d.b.j0.q0.k) next).i(this.f59897a.getPageContext(), this.f59897a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.b.c.j.e.a> list = this.f59900d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
            l(frsViewData);
        }
        k();
        bdTypeRecyclerView.a(this.f59900d);
        m();
    }

    public final void e() {
        d.b.c.j.e.a<?, ?> j = d.b.j0.s2.v.p().j(this.f59897a, AdvertAppInfo.h4);
        d.b.c.j.e.a<?, ?> j2 = d.b.j0.s2.v.p().j(this.f59897a, AdvertAppInfo.k4);
        d.b.c.j.e.a<?, ?> j3 = d.b.j0.s2.v.p().j(this.f59897a, AdvertAppInfo.o4);
        d.b.c.j.e.a<?, ?> j4 = d.b.j0.s2.v.p().j(this.f59897a, AdvertAppInfo.p4);
        d.b.c.j.e.a<?, ?> j5 = d.b.j0.s2.v.p().j(this.f59897a, AdvertAppInfo.q4);
        this.f59900d.add(j);
        this.f59900d.add(j2);
        this.f59900d.add(j3);
        this.f59900d.add(j4);
        this.f59900d.add(j5);
        d.b.c.j.e.a<?, ?> b2 = d.b.j0.r0.b.e().b(this.f59897a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        d.b.c.j.e.a<?, ?> b3 = d.b.j0.r0.b.e().b(this.f59897a.getBaseFragmentActivity(), AdvertAppInfo.m4);
        this.f59900d.add(b2);
        this.f59900d.add(b3);
    }

    public void f() {
        this.f59898b.getAdapter().notifyDataSetChanged();
    }

    public void g() {
        for (d.b.c.j.e.a aVar : this.f59900d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).m0();
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
        this.f59898b.setData(h(arrayList));
    }

    public void j(boolean z) {
    }

    public final void k() {
        if (ListUtils.isEmpty(this.f59900d) || this.f59897a == null) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59900d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).r0(this.f59897a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.b.c.j.e.a> list = this.f59900d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59900d) {
            if (aVar instanceof d.b.j0.q0.k) {
                ((d.b.j0.q0.k) aVar).p0(frsViewData);
            }
        }
    }

    public final void m() {
        if (this.f59897a == null || ListUtils.isEmpty(this.f59900d)) {
            return;
        }
        for (d.b.c.j.e.a aVar : this.f59900d) {
            if (aVar instanceof d.b.j0.q0.j2.d) {
                d.b.j0.q0.j2.d dVar = (d.b.j0.q0.j2.d) aVar;
                if (dVar.b() != null) {
                    dVar.b().f59820a = this.f59897a.o;
                    dVar.b().f59822c = this.f59897a.i;
                    dVar.b().f59823d = this.f59897a.k;
                    d.b.j0.q0.j2.b b2 = dVar.b();
                    FrsCommonTabFragment frsCommonTabFragment = this.f59897a;
                    b2.f59826g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.b().f59825f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.b().f59825f = 12;
                    }
                }
            }
        }
    }
}
