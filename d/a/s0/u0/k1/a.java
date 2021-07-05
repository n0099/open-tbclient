package d.a.s0.u0.k1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.s0.u0.m1.d.a0;
import d.a.s0.u0.m1.d.e;
import d.a.s0.u0.m1.d.g;
import d.a.s0.u0.m1.d.h;
import d.a.s0.u0.m1.d.j;
import d.a.s0.u0.m1.d.k;
import d.a.s0.u0.m1.d.l;
import d.a.s0.u0.m1.d.m;
import d.a.s0.u0.m1.d.p;
import d.a.s0.u0.m1.d.s;
import d.a.s0.u0.m1.d.t;
import d.a.s0.u0.m1.d.u;
import d.a.s0.u0.m1.d.v;
import d.a.s0.u0.m1.d.w;
import d.a.s0.u0.m1.d.x;
import d.a.s0.u0.m1.d.y;
import d.a.s0.u0.m1.d.z;
import d.a.s0.u0.r;
import d.a.s0.w2.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f66194a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f66195b;

    /* renamed from: c  reason: collision with root package name */
    public r f66196c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f66197d;

    /* renamed from: e  reason: collision with root package name */
    public y f66198e;

    /* renamed from: f  reason: collision with root package name */
    public k f66199f;

    /* renamed from: g  reason: collision with root package name */
    public v f66200g;

    /* renamed from: h  reason: collision with root package name */
    public s f66201h;

    /* renamed from: i  reason: collision with root package name */
    public j f66202i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public d.a.s0.u0.m1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public d.a.s0.u0.m1.d.a t;
    public d.a.s0.u0.m1.d.c u;
    public d.a.s0.u0.m1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: d.a.s0.u0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1722a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f66203a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1722a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66203a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.a.c.k.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.s0.a0.y) {
                        d.a.s0.a0.y yVar = (d.a.s0.a0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.f66203a.f66197d != null) {
                            yVar.o(this.f66203a.f66194a.getPageContext(), this.f66203a.f66194a.getUniqueId());
                            if (this.f66203a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.f66203a.f66197d.add(next);
                        }
                    }
                }
            }
        }
    }

    public a(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66197d = new LinkedList();
        this.B = new C1722a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f66195b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f66194a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f66194a.registerListener(this.B);
            this.f66198e = new y(frsCommonTabFragment.n(), b2.U2, frsCommonTabFragment.getUniqueId());
            this.f66199f = new k(frsCommonTabFragment.n(), b2.V2, frsCommonTabFragment.getUniqueId());
            this.f66200g = new v(frsCommonTabFragment.n(), b2.X2, frsCommonTabFragment.getUniqueId());
            this.f66201h = new s(frsCommonTabFragment.n(), b2.Y2, frsCommonTabFragment.getUniqueId());
            this.f66202i = new j(frsCommonTabFragment.n(), b2.a3, frsCommonTabFragment.getUniqueId());
            this.j = new m(frsCommonTabFragment.n(), b2.b3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.n(), b2.z3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.n(), b2.g3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.n(), b2.h3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.x0(frsCommonTabFragment.l);
            d.a.s0.u0.m1.d.r rVar = new d.a.s0.u0.m1.d.r(frsCommonTabFragment.n(), b2.i3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.x0(frsCommonTabFragment.l);
            this.o = new z(frsCommonTabFragment.getPageContext(), b2.l3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), b2.E3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), b2.k3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), b2.j3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), b2.q3, frsCommonTabFragment.getUniqueId());
            this.t = new d.a.s0.u0.m1.d.a(frsCommonTabFragment.getPageContext(), b2.d3, frsCommonTabFragment.getUniqueId());
            this.u = new d.a.s0.u0.m1.d.c(frsCommonTabFragment.getPageContext(), b2.Z2, frsCommonTabFragment.getUniqueId());
            this.v = new d.a.s0.u0.m1.d.b(frsCommonTabFragment.getPageContext(), b2.s3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), b2.r3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), b2.t3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), b2.u3, frsCommonTabFragment.getUniqueId());
            this.f66196c = new r(frsCommonTabFragment.getPageContext(), d.a.s0.u0.s.f67019f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), b2.f3, frsCommonTabFragment.getUniqueId());
            }
            this.f66197d.add(this.f66198e);
            this.f66197d.add(this.f66199f);
            this.f66197d.add(this.f66200g);
            this.f66197d.add(this.f66201h);
            this.f66197d.add(this.f66202i);
            this.f66197d.add(this.j);
            this.f66197d.add(this.k);
            this.f66197d.add(this.l);
            this.f66197d.add(this.m);
            this.f66197d.add(this.n);
            this.f66197d.add(this.o);
            this.f66197d.add(this.p);
            this.f66197d.add(this.q);
            this.f66197d.add(this.r);
            this.f66197d.add(this.s);
            this.f66197d.add(this.t);
            this.f66197d.add(this.u);
            this.f66197d.add(this.v);
            this.f66197d.add(this.w);
            this.f66197d.add(this.x);
            this.f66197d.add(this.y);
            this.f66197d.add(this.f66196c);
            if (!z) {
                this.f66197d.add(this.z);
            }
            e();
            for (d.a.c.k.e.a aVar : this.f66197d) {
                if (aVar instanceof d.a.s0.u0.k) {
                    d.a.s0.u0.k kVar = (d.a.s0.u0.k) aVar;
                    kVar.p0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.k == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof d.a.s0.a0.z) {
                    ((d.a.s0.a0.z) aVar).r(frsCommonTabFragment.k);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f66194a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.s0.u0.k) {
                        ((d.a.s0.u0.k) next).o(this.f66194a.getPageContext(), this.f66194a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<d.a.c.k.e.a> list = this.f66197d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.a(this.f66197d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.c.k.e.a<?, ?> g2 = d.a.s0.w2.w.p().g(this.f66194a, AdvertAppInfo.f4);
            d.a.c.k.e.a<?, ?> g3 = d.a.s0.w2.w.p().g(this.f66194a, AdvertAppInfo.i4);
            d.a.c.k.e.a<?, ?> g4 = d.a.s0.w2.w.p().g(this.f66194a, AdvertAppInfo.j4);
            d.a.c.k.e.a<?, ?> g5 = d.a.s0.w2.w.p().g(this.f66194a, AdvertAppInfo.k4);
            d.a.c.k.e.a<?, ?> g6 = d.a.s0.w2.w.p().g(this.f66194a, AdvertAppInfo.l4);
            this.f66197d.add(g2);
            this.f66197d.add(g3);
            this.f66197d.add(g4);
            this.f66197d.add(g5);
            this.f66197d.add(g6);
            d.a.c.k.e.a<?, ?> d2 = d.a.s0.v0.b.e().d(this.f66194a.getBaseFragmentActivity(), AdvertAppInfo.q4);
            d.a.c.k.e.a<?, ?> d3 = d.a.s0.v0.b.e().d(this.f66194a.getBaseFragmentActivity(), AdvertAppInfo.p4);
            this.f66197d.add(d2);
            this.f66197d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f66195b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.c.k.e.a aVar : this.f66197d) {
                if (aVar instanceof d.a.s0.u0.k) {
                    ((d.a.s0.u0.k) aVar).i0();
                } else if (aVar instanceof o) {
                    ((o) aVar).onDestroy();
                }
            }
        }
    }

    public final ArrayList<n> h(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, arrayList)) == null) {
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    if (b2Var.n0() != null) {
                        if (!b2Var.t2()) {
                            arrayList2.add(next);
                        } else {
                            b2Var.E3(null);
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
        return (ArrayList) invokeL.objValue;
    }

    public void i(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, arrayList) == null) {
            k();
            this.f66195b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f66197d) || this.f66194a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f66197d) {
            if (aVar instanceof d.a.s0.u0.k) {
                ((d.a.s0.u0.k) aVar).s0(this.f66194a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f66197d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f66197d) {
            if (aVar instanceof d.a.s0.u0.k) {
                ((d.a.s0.u0.k) aVar).l0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f66194a == null || ListUtils.isEmpty(this.f66197d)) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f66197d) {
            if (aVar instanceof d.a.s0.u0.j2.d) {
                d.a.s0.u0.j2.d dVar = (d.a.s0.u0.j2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f66175a = this.f66194a.o;
                    dVar.j().f66177c = this.f66194a.f15508i;
                    dVar.j().f66178d = this.f66194a.k;
                    d.a.s0.u0.j2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f66194a;
                    j.f66181g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.j().f66180f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.j().f66180f = 12;
                    }
                }
            }
        }
    }
}
