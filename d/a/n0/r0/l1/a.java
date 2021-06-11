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
import d.a.c.k.e.n;
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
    public FrsCommonTabFragment f62543a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f62544b;

    /* renamed from: c  reason: collision with root package name */
    public s f62545c;

    /* renamed from: e  reason: collision with root package name */
    public y f62547e;

    /* renamed from: f  reason: collision with root package name */
    public k f62548f;

    /* renamed from: g  reason: collision with root package name */
    public v f62549g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.r0.n1.d.s f62550h;

    /* renamed from: i  reason: collision with root package name */
    public j f62551i;
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
    public List<d.a.c.k.e.a> f62546d = new LinkedList();
    public CustomMessageListener B = new C1561a(2003008);

    /* renamed from: d.a.n0.r0.l1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1561a extends CustomMessageListener {
        public C1561a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.a.c.k.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.n0.z.y) {
                        d.a.n0.z.y yVar = (d.a.n0.z.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && a.this.f62546d != null) {
                            yVar.o(a.this.f62543a.getPageContext(), a.this.f62543a.getUniqueId());
                            if (a.this.A) {
                                yVar.setFrom("c13010");
                            }
                            a.this.f62546d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f62544b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        this.f62543a = frsCommonTabFragment;
        this.B.setPriority(1);
        this.B.setSelfListener(true);
        this.f62543a.registerListener(this.B);
        this.f62547e = new y(frsCommonTabFragment.p(), a2.S2, frsCommonTabFragment.getUniqueId());
        this.f62548f = new k(frsCommonTabFragment.p(), a2.T2, frsCommonTabFragment.getUniqueId());
        this.f62549g = new v(frsCommonTabFragment.p(), a2.V2, frsCommonTabFragment.getUniqueId());
        this.f62550h = new d.a.n0.r0.n1.d.s(frsCommonTabFragment.p(), a2.W2, frsCommonTabFragment.getUniqueId());
        this.f62551i = new j(frsCommonTabFragment.p(), a2.Y2, frsCommonTabFragment.getUniqueId());
        this.j = new m(frsCommonTabFragment.p(), a2.Z2, frsCommonTabFragment.getUniqueId());
        this.k = new w(frsCommonTabFragment.p(), a2.x3, frsCommonTabFragment.getUniqueId());
        this.l = new a0(frsCommonTabFragment.p(), a2.e3, frsCommonTabFragment.getUniqueId());
        u uVar = new u(frsCommonTabFragment.p(), a2.f3, frsCommonTabFragment.getUniqueId());
        this.m = uVar;
        uVar.v0(frsCommonTabFragment.l);
        r rVar = new r(frsCommonTabFragment.p(), a2.g3, frsCommonTabFragment.getUniqueId());
        this.n = rVar;
        rVar.v0(frsCommonTabFragment.l);
        this.o = new z(frsCommonTabFragment.getPageContext(), a2.j3, frsCommonTabFragment.getUniqueId());
        this.p = new l(frsCommonTabFragment.getPageContext(), a2.C3, frsCommonTabFragment.getUniqueId());
        this.q = new t(frsCommonTabFragment.getPageContext(), a2.i3, frsCommonTabFragment.getUniqueId());
        this.r = new p(frsCommonTabFragment.getPageContext(), a2.h3, frsCommonTabFragment.getUniqueId());
        this.s = new x(frsCommonTabFragment.getPageContext(), a2.o3, frsCommonTabFragment.getUniqueId());
        this.t = new d.a.n0.r0.n1.d.a(frsCommonTabFragment.getPageContext(), a2.b3, frsCommonTabFragment.getUniqueId());
        this.u = new d.a.n0.r0.n1.d.c(frsCommonTabFragment.getPageContext(), a2.X2, frsCommonTabFragment.getUniqueId());
        this.v = new d.a.n0.r0.n1.d.b(frsCommonTabFragment.getPageContext(), a2.q3, frsCommonTabFragment.getUniqueId());
        this.w = new g(frsCommonTabFragment.getPageContext(), a2.p3, frsCommonTabFragment.getUniqueId());
        this.x = new h(frsCommonTabFragment.getPageContext(), a2.r3, frsCommonTabFragment.getUniqueId());
        this.y = new z(frsCommonTabFragment.getPageContext(), a2.s3, frsCommonTabFragment.getUniqueId());
        this.f62545c = new s(frsCommonTabFragment.getPageContext(), d.a.n0.r0.t.f63349f);
        if (!z) {
            this.z = new e(frsCommonTabFragment.getPageContext(), a2.d3, frsCommonTabFragment.getUniqueId());
        }
        this.f62546d.add(this.f62547e);
        this.f62546d.add(this.f62548f);
        this.f62546d.add(this.f62549g);
        this.f62546d.add(this.f62550h);
        this.f62546d.add(this.f62551i);
        this.f62546d.add(this.j);
        this.f62546d.add(this.k);
        this.f62546d.add(this.l);
        this.f62546d.add(this.m);
        this.f62546d.add(this.n);
        this.f62546d.add(this.o);
        this.f62546d.add(this.p);
        this.f62546d.add(this.q);
        this.f62546d.add(this.r);
        this.f62546d.add(this.s);
        this.f62546d.add(this.t);
        this.f62546d.add(this.u);
        this.f62546d.add(this.v);
        this.f62546d.add(this.w);
        this.f62546d.add(this.x);
        this.f62546d.add(this.y);
        this.f62546d.add(this.f62545c);
        if (!z) {
            this.f62546d.add(this.z);
        }
        e();
        for (d.a.c.k.e.a aVar : this.f62546d) {
            if (aVar instanceof d.a.n0.r0.k) {
                d.a.n0.r0.k kVar = (d.a.n0.r0.k) aVar;
                kVar.m0(bdTypeRecyclerView);
                if (frsCommonTabFragment.k == 89) {
                    kVar.setFrom("c13010");
                }
            }
            if (aVar instanceof d.a.n0.z.z) {
                ((d.a.n0.z.z) aVar).r(frsCommonTabFragment.k);
            }
        }
        AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
        CustomMessage customMessage = new CustomMessage(2003022);
        customMessage.setTag(this.f62543a.getUniqueId());
        customResponsedMessage.setOrginalMessage(customMessage);
        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        if (!absDelegateAdapterList.isEmpty()) {
            Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.a<?, ?> next = it.next();
                if (next instanceof d.a.n0.r0.k) {
                    ((d.a.n0.r0.k) next).o(this.f62543a.getPageContext(), this.f62543a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.k.e.a> list = this.f62546d;
            if (list != null) {
                list.addAll(arrayList);
            }
        }
        if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
            l(frsViewData);
        }
        k();
        bdTypeRecyclerView.a(this.f62546d);
        m();
    }

    public final void e() {
        d.a.c.k.e.a<?, ?> h2 = d.a.n0.t2.x.p().h(this.f62543a, AdvertAppInfo.d4);
        d.a.c.k.e.a<?, ?> h3 = d.a.n0.t2.x.p().h(this.f62543a, AdvertAppInfo.g4);
        d.a.c.k.e.a<?, ?> h4 = d.a.n0.t2.x.p().h(this.f62543a, AdvertAppInfo.h4);
        d.a.c.k.e.a<?, ?> h5 = d.a.n0.t2.x.p().h(this.f62543a, AdvertAppInfo.i4);
        d.a.c.k.e.a<?, ?> h6 = d.a.n0.t2.x.p().h(this.f62543a, AdvertAppInfo.j4);
        this.f62546d.add(h2);
        this.f62546d.add(h3);
        this.f62546d.add(h4);
        this.f62546d.add(h5);
        this.f62546d.add(h6);
        d.a.c.k.e.a<?, ?> d2 = d.a.n0.s0.b.e().d(this.f62543a.getBaseFragmentActivity(), AdvertAppInfo.o4);
        d.a.c.k.e.a<?, ?> d3 = d.a.n0.s0.b.e().d(this.f62543a.getBaseFragmentActivity(), AdvertAppInfo.n4);
        this.f62546d.add(d2);
        this.f62546d.add(d3);
    }

    public void f() {
        this.f62544b.getAdapter().notifyDataSetChanged();
    }

    public void g() {
        for (d.a.c.k.e.a aVar : this.f62546d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).i0();
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
                    if (!a2Var.G2()) {
                        arrayList2.add(next);
                    } else {
                        a2Var.R3(null);
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
        this.f62544b.setData(h(arrayList));
    }

    public void j(boolean z) {
    }

    public final void k() {
        if (ListUtils.isEmpty(this.f62546d) || this.f62543a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62546d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).p0(this.f62543a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list = this.f62546d;
        if (list == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62546d) {
            if (aVar instanceof d.a.n0.r0.k) {
                ((d.a.n0.r0.k) aVar).l0(frsViewData);
            }
        }
    }

    public final void m() {
        if (this.f62543a == null || ListUtils.isEmpty(this.f62546d)) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f62546d) {
            if (aVar instanceof d.a.n0.r0.j2.d) {
                d.a.n0.r0.j2.d dVar = (d.a.n0.r0.j2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f62465a = this.f62543a.o;
                    dVar.j().f62467c = this.f62543a.f15333i;
                    dVar.j().f62468d = this.f62543a.k;
                    d.a.n0.r0.j2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f62543a;
                    j.f62471g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.j().f62470f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.j().f62470f = 12;
                    }
                }
            }
        }
    }
}
