package d.a.n0.r0.l1;

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
import d.a.m0.r.q.a2;
import d.a.n0.r0.n1.d.a0;
import d.a.n0.r0.n1.d.e;
import d.a.n0.r0.n1.d.g;
import d.a.n0.r0.n1.d.h;
import d.a.n0.r0.n1.d.j;
import d.a.n0.r0.n1.d.k;
import d.a.n0.r0.n1.d.l;
import d.a.n0.r0.n1.d.m;
import d.a.n0.r0.n1.d.p;
import d.a.n0.r0.n1.d.r;
import d.a.n0.r0.n1.d.t;
import d.a.n0.r0.n1.d.u;
import d.a.n0.r0.n1.d.v;
import d.a.n0.r0.n1.d.w;
import d.a.n0.r0.n1.d.x;
import d.a.n0.r0.n1.d.y;
import d.a.n0.r0.n1.d.z;
import d.a.n0.r0.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    public boolean A;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f58852a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f58853b;

    /* renamed from: c  reason: collision with root package name */
    public s f58854c;

    /* renamed from: e  reason: collision with root package name */
    public y f58856e;

    /* renamed from: f  reason: collision with root package name */
    public k f58857f;

    /* renamed from: g  reason: collision with root package name */
    public v f58858g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.n1.d.s f58859h;

    /* renamed from: i  reason: collision with root package name */
    public j f58860i;
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
    public d.a.n0.r0.n1.d.a t;
    public d.a.n0.r0.n1.d.c u;
    public d.a.n0.r0.n1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.j.e.a> f58855d = new LinkedList();
    public CustomMessageListener B = new C1505a(2003008);

    /* renamed from: d.a.n0.r0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1505a extends CustomMessageListener {
        public C1505a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.a.c.j.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.a.c.j.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.n0.z.y) {
                        d.a.n0.z.y yVar = (d.a.n0.z.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && a.this.f58855d != null) {
                            yVar.n(a.this.f58852a.getPageContext(), a.this.f58852a.getUniqueId());
                            if (a.this.A) {
                                yVar.setFrom("c13010");
                            }
                            a.this.f58855d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f58853b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.f58852a = frsCommonTabFragment;
        this.B.setPriority(1);
        this.B.setSelfListener(true);
        this.f58852a.registerListener(this.B);
        this.f58856e = new y(frsCommonTabFragment.o(), a2.P2, frsCommonTabFragment.getUniqueId());
        this.f58857f = new k(frsCommonTabFragment.o(), a2.Q2, frsCommonTabFragment.getUniqueId());
        this.f58858g = new v(frsCommonTabFragment.o(), a2.S2, frsCommonTabFragment.getUniqueId());
        this.f58859h = new d.a.n0.r0.n1.d.s(frsCommonTabFragment.o(), a2.T2, frsCommonTabFragment.getUniqueId());
        this.f58860i = new j(frsCommonTabFragment.o(), a2.V2, frsCommonTabFragment.getUniqueId());
        this.j = new m(frsCommonTabFragment.o(), a2.W2, frsCommonTabFragment.getUniqueId());
        this.k = new w(frsCommonTabFragment.o(), a2.u3, frsCommonTabFragment.getUniqueId());
        this.l = new a0(frsCommonTabFragment.o(), a2.b3, frsCommonTabFragment.getUniqueId());
        u uVar = new u(frsCommonTabFragment.o(), a2.c3, frsCommonTabFragment.getUniqueId());
        this.m = uVar;
        uVar.u0(frsCommonTabFragment.l);
        r rVar = new r(frsCommonTabFragment.o(), a2.d3, frsCommonTabFragment.getUniqueId());
        this.n = rVar;
        rVar.u0(frsCommonTabFragment.l);
        this.o = new z(frsCommonTabFragment.getPageContext(), a2.g3, frsCommonTabFragment.getUniqueId());
        this.p = new l(frsCommonTabFragment.getPageContext(), a2.z3, frsCommonTabFragment.getUniqueId());
        this.q = new t(frsCommonTabFragment.getPageContext(), a2.f3, frsCommonTabFragment.getUniqueId());
        this.r = new p(frsCommonTabFragment.getPageContext(), a2.e3, frsCommonTabFragment.getUniqueId());
        this.s = new x(frsCommonTabFragment.getPageContext(), a2.l3, frsCommonTabFragment.getUniqueId());
        this.t = new d.a.n0.r0.n1.d.a(frsCommonTabFragment.getPageContext(), a2.Y2, frsCommonTabFragment.getUniqueId());
        this.u = new d.a.n0.r0.n1.d.c(frsCommonTabFragment.getPageContext(), a2.U2, frsCommonTabFragment.getUniqueId());
        this.v = new d.a.n0.r0.n1.d.b(frsCommonTabFragment.getPageContext(), a2.n3, frsCommonTabFragment.getUniqueId());
        this.w = new g(frsCommonTabFragment.getPageContext(), a2.m3, frsCommonTabFragment.getUniqueId());
        this.x = new h(frsCommonTabFragment.getPageContext(), a2.o3, frsCommonTabFragment.getUniqueId());
        this.y = new z(frsCommonTabFragment.getPageContext(), a2.p3, frsCommonTabFragment.getUniqueId());
        this.f58854c = new s(frsCommonTabFragment.getPageContext(), d.a.n0.r0.t.f59658f);
        if (!z) {
            this.z = new e(frsCommonTabFragment.getPageContext(), a2.a3, frsCommonTabFragment.getUniqueId());
        }
        this.f58855d.add(this.f58856e);
        this.f58855d.add(this.f58857f);
        this.f58855d.add(this.f58858g);
        this.f58855d.add(this.f58859h);
        this.f58855d.add(this.f58860i);
        this.f58855d.add(this.j);
        this.f58855d.add(this.k);
        this.f58855d.add(this.l);
        this.f58855d.add(this.m);
        this.f58855d.add(this.n);
        this.f58855d.add(this.o);
        this.f58855d.add(this.p);
        this.f58855d.add(this.q);
        this.f58855d.add(this.r);
        this.f58855d.add(this.s);
        this.f58855d.add(this.t);
        this.f58855d.add(this.u);
        this.f58855d.add(this.v);
        this.f58855d.add(this.w);
        this.f58855d.add(this.x);
        this.f58855d.add(this.y);
        this.f58855d.add(this.f58854c);
        if (!z) {
            this.f58855d.add(this.z);
        }
        e();
        for (d.a.c.j.e.a aVar : this.f58855d) {
            if (aVar instanceof d.a.n0.r0.k) {
                d.a.n0.r0.k kVar = (d.a.n0.r0.k) aVar;
                kVar.n0(bdTypeRecyclerView);
                if (frsCommonTabFragment.k == 89) {
                    kVar.setFrom("c13010");
                }
            }
            if (aVar instanceof d.a.n0.z.z) {
                ((d.a.n0.z.z) aVar).q(frsCommonTabFragment.k);
            }
        }
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.f58852a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.j.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.j.e.a<?, ?> next = it.next();
                if (next instanceof d.a.n0.r0.k) {
                    ((d.a.n0.r0.k) next).n(this.f58852a.getPageContext(), this.f58852a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.j.e.a> list = this.f58855d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
            l(frsViewData);
        }
        k();
        bdTypeRecyclerView.a(this.f58855d);
        m();
    }

    public final void e() {
        d.a.c.j.e.a<?, ?> h2 = d.a.n0.t2.x.p().h(this.f58852a, AdvertAppInfo.a4);
        d.a.c.j.e.a<?, ?> h3 = d.a.n0.t2.x.p().h(this.f58852a, AdvertAppInfo.d4);
        d.a.c.j.e.a<?, ?> h4 = d.a.n0.t2.x.p().h(this.f58852a, AdvertAppInfo.e4);
        d.a.c.j.e.a<?, ?> h5 = d.a.n0.t2.x.p().h(this.f58852a, AdvertAppInfo.f4);
        d.a.c.j.e.a<?, ?> h6 = d.a.n0.t2.x.p().h(this.f58852a, AdvertAppInfo.g4);
        this.f58855d.add(h2);
        this.f58855d.add(h3);
        this.f58855d.add(h4);
        this.f58855d.add(h5);
        this.f58855d.add(h6);
        d.a.c.j.e.a<?, ?> d2 = d.a.n0.s0.b.e().d(this.f58852a.getBaseFragmentActivity(), AdvertAppInfo.l4);
        d.a.c.j.e.a<?, ?> d3 = d.a.n0.s0.b.e().d(this.f58852a.getBaseFragmentActivity(), AdvertAppInfo.k4);
        this.f58855d.add(d2);
        this.f58855d.add(d3);
    }

    public void f() {
        this.f58853b.getAdapter().notifyDataSetChanged();
    }

    public void g() {
        for (d.a.c.j.e.a aVar : this.f58855d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).h0();
            } else if (aVar instanceof d.a.n0.t2.p) {
                ((d.a.n0.t2.p) aVar).onDestroy();
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
                if (a2Var.z0() != null) {
                    if (!a2Var.F2()) {
                        arrayList2.add(next);
                    } else {
                        a2Var.Q3(null);
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
        this.f58853b.setData(h(arrayList));
    }

    public void j(boolean z) {
    }

    public final void k() {
        if (ListUtils.isEmpty(this.f58855d) || this.f58852a == null) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58855d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f58852a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.a.c.j.e.a> list = this.f58855d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58855d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).m0(frsViewData);
            }
        }
    }

    public final void m() {
        if (this.f58852a == null || ListUtils.isEmpty(this.f58855d)) {
            return;
        }
        for (d.a.c.j.e.a aVar : this.f58855d) {
            if (aVar instanceof d.a.n0.r0.j2.d) {
                d.a.n0.r0.j2.d dVar = (d.a.n0.r0.j2.d) aVar;
                if (dVar.i() != null) {
                    dVar.i().f58774a = this.f58852a.o;
                    dVar.i().f58776c = this.f58852a.f15271i;
                    dVar.i().f58777d = this.f58852a.k;
                    d.a.n0.r0.j2.b i2 = dVar.i();
                    FrsCommonTabFragment frsCommonTabFragment = this.f58852a;
                    i2.f58780g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.i().f58779f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.i().f58779f = 12;
                    }
                }
            }
        }
    }
}
