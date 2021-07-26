package d.a.q0.u0.k1;

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
import d.a.d.k.e.n;
import d.a.p0.s.q.b2;
import d.a.q0.u0.m1.d.a0;
import d.a.q0.u0.m1.d.e;
import d.a.q0.u0.m1.d.g;
import d.a.q0.u0.m1.d.h;
import d.a.q0.u0.m1.d.j;
import d.a.q0.u0.m1.d.k;
import d.a.q0.u0.m1.d.l;
import d.a.q0.u0.m1.d.m;
import d.a.q0.u0.m1.d.p;
import d.a.q0.u0.m1.d.s;
import d.a.q0.u0.m1.d.t;
import d.a.q0.u0.m1.d.u;
import d.a.q0.u0.m1.d.v;
import d.a.q0.u0.m1.d.w;
import d.a.q0.u0.m1.d.x;
import d.a.q0.u0.m1.d.y;
import d.a.q0.u0.m1.d.z;
import d.a.q0.u0.r;
import d.a.q0.w2.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public CustomMessageListener B;

    /* renamed from: a  reason: collision with root package name */
    public FrsCommonTabFragment f63618a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63619b;

    /* renamed from: c  reason: collision with root package name */
    public r f63620c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f63621d;

    /* renamed from: e  reason: collision with root package name */
    public y f63622e;

    /* renamed from: f  reason: collision with root package name */
    public k f63623f;

    /* renamed from: g  reason: collision with root package name */
    public v f63624g;

    /* renamed from: h  reason: collision with root package name */
    public s f63625h;

    /* renamed from: i  reason: collision with root package name */
    public j f63626i;
    public m j;
    public w k;
    public a0 l;
    public u m;
    public d.a.q0.u0.m1.d.r n;
    public z o;
    public l p;
    public t q;
    public p r;
    public x s;
    public d.a.q0.u0.m1.d.a t;
    public d.a.q0.u0.m1.d.c u;
    public d.a.q0.u0.m1.d.b v;
    public g w;
    public h x;
    public z y;
    public e z;

    /* renamed from: d.a.q0.u0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1683a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f63627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1683a(a aVar, int i2) {
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
            this.f63627a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                Iterator<d.a.d.k.e.a<?, ?>> it = ((AbsDelegateAdapterList) customResponsedMessage.getData()).iterator();
                while (it.hasNext()) {
                    d.a.d.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.q0.a0.y) {
                        d.a.q0.a0.y yVar = (d.a.q0.a0.y) next;
                        if ("FrsHottopicDelegateAdapter".equals(yVar.from()) && this.f63627a.f63621d != null) {
                            yVar.o(this.f63627a.f63618a.getPageContext(), this.f63627a.f63618a.getUniqueId());
                            if (this.f63627a.A) {
                                yVar.setFrom("c13010");
                            }
                            this.f63627a.f63621d.add(next);
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
        this.f63621d = new LinkedList();
        this.B = new C1683a(this, 2003008);
        d(frsCommonTabFragment, bdTypeRecyclerView, frsViewData, z);
        this.f63619b = bdTypeRecyclerView;
    }

    public void d(FrsCommonTabFragment frsCommonTabFragment, BdTypeRecyclerView bdTypeRecyclerView, FrsViewData frsViewData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{frsCommonTabFragment, bdTypeRecyclerView, frsViewData, Boolean.valueOf(z)}) == null) {
            this.f63618a = frsCommonTabFragment;
            this.B.setPriority(1);
            this.B.setSelfListener(true);
            this.f63618a.registerListener(this.B);
            this.f63622e = new y(frsCommonTabFragment.m(), b2.a3, frsCommonTabFragment.getUniqueId());
            this.f63623f = new k(frsCommonTabFragment.m(), b2.b3, frsCommonTabFragment.getUniqueId());
            this.f63624g = new v(frsCommonTabFragment.m(), b2.d3, frsCommonTabFragment.getUniqueId());
            this.f63625h = new s(frsCommonTabFragment.m(), b2.e3, frsCommonTabFragment.getUniqueId());
            this.f63626i = new j(frsCommonTabFragment.m(), b2.g3, frsCommonTabFragment.getUniqueId());
            this.j = new m(frsCommonTabFragment.m(), b2.h3, frsCommonTabFragment.getUniqueId());
            this.k = new w(frsCommonTabFragment.m(), b2.F3, frsCommonTabFragment.getUniqueId());
            this.l = new a0(frsCommonTabFragment.m(), b2.m3, frsCommonTabFragment.getUniqueId());
            u uVar = new u(frsCommonTabFragment.m(), b2.n3, frsCommonTabFragment.getUniqueId());
            this.m = uVar;
            uVar.w0(frsCommonTabFragment.l);
            d.a.q0.u0.m1.d.r rVar = new d.a.q0.u0.m1.d.r(frsCommonTabFragment.m(), b2.o3, frsCommonTabFragment.getUniqueId());
            this.n = rVar;
            rVar.w0(frsCommonTabFragment.l);
            this.o = new z(frsCommonTabFragment.getPageContext(), b2.r3, frsCommonTabFragment.getUniqueId());
            this.p = new l(frsCommonTabFragment.getPageContext(), b2.K3, frsCommonTabFragment.getUniqueId());
            this.q = new t(frsCommonTabFragment.getPageContext(), b2.q3, frsCommonTabFragment.getUniqueId());
            this.r = new p(frsCommonTabFragment.getPageContext(), b2.p3, frsCommonTabFragment.getUniqueId());
            this.s = new x(frsCommonTabFragment.getPageContext(), b2.w3, frsCommonTabFragment.getUniqueId());
            this.t = new d.a.q0.u0.m1.d.a(frsCommonTabFragment.getPageContext(), b2.j3, frsCommonTabFragment.getUniqueId());
            this.u = new d.a.q0.u0.m1.d.c(frsCommonTabFragment.getPageContext(), b2.f3, frsCommonTabFragment.getUniqueId());
            this.v = new d.a.q0.u0.m1.d.b(frsCommonTabFragment.getPageContext(), b2.y3, frsCommonTabFragment.getUniqueId());
            this.w = new g(frsCommonTabFragment.getPageContext(), b2.x3, frsCommonTabFragment.getUniqueId());
            this.x = new h(frsCommonTabFragment.getPageContext(), b2.z3, frsCommonTabFragment.getUniqueId());
            this.y = new z(frsCommonTabFragment.getPageContext(), b2.A3, frsCommonTabFragment.getUniqueId());
            this.f63620c = new r(frsCommonTabFragment.getPageContext(), d.a.q0.u0.s.f64447f);
            if (!z) {
                this.z = new e(frsCommonTabFragment.getPageContext(), b2.l3, frsCommonTabFragment.getUniqueId());
            }
            this.f63621d.add(this.f63622e);
            this.f63621d.add(this.f63623f);
            this.f63621d.add(this.f63624g);
            this.f63621d.add(this.f63625h);
            this.f63621d.add(this.f63626i);
            this.f63621d.add(this.j);
            this.f63621d.add(this.k);
            this.f63621d.add(this.l);
            this.f63621d.add(this.m);
            this.f63621d.add(this.n);
            this.f63621d.add(this.o);
            this.f63621d.add(this.p);
            this.f63621d.add(this.q);
            this.f63621d.add(this.r);
            this.f63621d.add(this.s);
            this.f63621d.add(this.t);
            this.f63621d.add(this.u);
            this.f63621d.add(this.v);
            this.f63621d.add(this.w);
            this.f63621d.add(this.x);
            this.f63621d.add(this.y);
            this.f63621d.add(this.f63620c);
            if (!z) {
                this.f63621d.add(this.z);
            }
            e();
            for (d.a.d.k.e.a aVar : this.f63621d) {
                if (aVar instanceof d.a.q0.u0.k) {
                    d.a.q0.u0.k kVar = (d.a.q0.u0.k) aVar;
                    kVar.n0(bdTypeRecyclerView);
                    if (frsCommonTabFragment.k == 89) {
                        kVar.setFrom("c13010");
                    }
                }
                if (aVar instanceof d.a.q0.a0.z) {
                    ((d.a.q0.a0.z) aVar).r(frsCommonTabFragment.k);
                }
            }
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003022, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003022);
            customMessage.setTag(this.f63618a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<d.a.d.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.d.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.q0.u0.k) {
                        ((d.a.q0.u0.k) next).o(this.f63618a.getPageContext(), this.f63618a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<d.a.d.k.e.a> list = this.f63621d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            if (frsCommonTabFragment.k == 502 || frsCommonTabFragment.n == 1) {
                l(frsViewData);
            }
            k();
            bdTypeRecyclerView.a(this.f63621d);
            m();
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.d.k.e.a<?, ?> f2 = d.a.q0.w2.w.o().f(this.f63618a, AdvertAppInfo.l4);
            d.a.d.k.e.a<?, ?> f3 = d.a.q0.w2.w.o().f(this.f63618a, AdvertAppInfo.o4);
            d.a.d.k.e.a<?, ?> f4 = d.a.q0.w2.w.o().f(this.f63618a, AdvertAppInfo.p4);
            d.a.d.k.e.a<?, ?> f5 = d.a.q0.w2.w.o().f(this.f63618a, AdvertAppInfo.q4);
            d.a.d.k.e.a<?, ?> f6 = d.a.q0.w2.w.o().f(this.f63618a, AdvertAppInfo.r4);
            this.f63621d.add(f2);
            this.f63621d.add(f3);
            this.f63621d.add(f4);
            this.f63621d.add(f5);
            this.f63621d.add(f6);
            d.a.d.k.e.a<?, ?> d2 = d.a.q0.v0.b.e().d(this.f63618a.getBaseFragmentActivity(), AdvertAppInfo.w4);
            d.a.d.k.e.a<?, ?> d3 = d.a.q0.v0.b.e().d(this.f63618a.getBaseFragmentActivity(), AdvertAppInfo.v4);
            this.f63621d.add(d2);
            this.f63621d.add(d3);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f63619b.getAdapter().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (d.a.d.k.e.a aVar : this.f63621d) {
                if (aVar instanceof d.a.q0.u0.k) {
                    ((d.a.q0.u0.k) aVar).i0();
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
                    if (b2Var.o0() != null) {
                        if (!b2Var.v2()) {
                            arrayList2.add(next);
                        } else {
                            b2Var.H3(null);
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
            this.f63619b.setData(h(arrayList));
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || ListUtils.isEmpty(this.f63621d) || this.f63618a == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63621d) {
            if (aVar instanceof d.a.q0.u0.k) {
                ((d.a.q0.u0.k) aVar).p0(this.f63618a.getTbPageTag());
            }
        }
    }

    public final void l(FrsViewData frsViewData) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frsViewData) == null) || (list = this.f63621d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63621d) {
            if (aVar instanceof d.a.q0.u0.k) {
                ((d.a.q0.u0.k) aVar).l0(frsViewData);
            }
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || this.f63618a == null || ListUtils.isEmpty(this.f63621d)) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63621d) {
            if (aVar instanceof d.a.q0.u0.j2.d) {
                d.a.q0.u0.j2.d dVar = (d.a.q0.u0.j2.d) aVar;
                if (dVar.j() != null) {
                    dVar.j().f63599a = this.f63618a.o;
                    dVar.j().f63601c = this.f63618a.f15595i;
                    dVar.j().f63602d = this.f63618a.k;
                    d.a.q0.u0.j2.b j = dVar.j();
                    FrsCommonTabFragment frsCommonTabFragment = this.f63618a;
                    j.f63605g = frsCommonTabFragment.l;
                    if (frsCommonTabFragment.k == 502) {
                        dVar.j().f63604f = 10;
                    } else if (frsCommonTabFragment.n == 1) {
                        dVar.j().f63604f = 12;
                    }
                }
            }
        }
    }
}
