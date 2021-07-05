package d.a.s0.u0.z1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.a0.z;
import d.a.s0.h3.v;
import d.a.s0.o.f;
import d.a.s0.u0.e;
import d.a.s0.u0.j2.d;
import d.a.s0.u0.k;
import d.a.s0.u0.m1.d.a0;
import d.a.s0.u0.m1.d.g;
import d.a.s0.u0.m1.d.h;
import d.a.s0.u0.m1.d.j;
import d.a.s0.u0.m1.d.m;
import d.a.s0.u0.m1.d.p;
import d.a.s0.u0.m1.d.r;
import d.a.s0.u0.m1.d.s;
import d.a.s0.u0.m1.d.t;
import d.a.s0.u0.m1.d.u;
import d.a.s0.u0.m1.d.x;
import d.a.s0.u0.m1.d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f67254a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f67255b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f67256c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f67257d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, b2> f67258e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f67259f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f67260g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f67261h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f67262i;
    public CustomMessageListener j;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67263a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f67263a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.f67263a.f67254a.getPageContext(), this.f67263a.f67254a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f67263a.f67257d != null) {
                    this.f67263a.f67257d.addAll(arrayList);
                }
                if (this.f67263a.f67255b != null) {
                    this.f67263a.f67255b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.s0.u0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1778b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f67264a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1778b(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f67264a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f67264a.f67256c)) {
                b bVar = this.f67264a;
                bVar.i(bVar.f67255b);
                b bVar2 = this.f67264a;
                bVar2.w(bVar2.f67259f, this.f67264a.f67261h);
            }
        }
    }

    public b(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67257d = new LinkedList();
        this.f67262i = new a(this, 2003008);
        this.j = new C1778b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f67255b = bdTypeRecyclerView;
        this.f67258e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (d.a.c.k.e.a aVar : this.f67257d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f67257d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f67257d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).a0(wVar);
            }
        }
    }

    public final void C() {
        d.a.s0.u0.j2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f67261h == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f67257d) {
            if ((aVar instanceof d) && (j = ((d) aVar).j()) != null) {
                if (this.f67261h.needLog == 1) {
                    j.f66175a = true;
                } else {
                    j.f66175a = false;
                }
                if (this.f67261h.getForum() != null) {
                    j.f66177c = this.f67261h.getForum().getId();
                }
                if (this.f67254a != null) {
                    j.f66176b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f67255b) == null || bdTypeRecyclerView.getData() == null || this.f67255b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f67255b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.m0() != 0) {
                    a2Var.w.M2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f67254a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f67254a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f67254a != null && bdTypeRecyclerView != null) {
                this.f67256c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f67254a.getPageContext(), g2.get(i2), this.f67254a.getUniqueId());
                        if (b2 != null) {
                            this.f67257d.add(b2);
                            this.f67256c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f67256c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f67256c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, b2> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67258e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, b2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f67258e) != null && !hashMap.containsValue(nVar)) {
                this.f67258e.put(Integer.valueOf(i2), (b2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67259f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f67260g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f67254a = frsGoodFragment;
            this.f67262i.setPriority(1);
            this.f67262i.setSelfListener(true);
            this.f67254a.registerListener(this.f67262i);
            y yVar = new y(frsGoodFragment.n(), b2.U2, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.k kVar = new d.a.s0.u0.m1.d.k(frsGoodFragment.n(), b2.V2, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.v vVar = new d.a.s0.u0.m1.d.v(frsGoodFragment.n(), b2.X2, this.f67254a.getUniqueId());
            s sVar = new s(frsGoodFragment.n(), b2.Y2, this.f67254a.getUniqueId());
            j jVar = new j(frsGoodFragment.n(), b2.a3, this.f67254a.getUniqueId());
            m mVar = new m(frsGoodFragment.n(), b2.b3, this.f67254a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.n(), b2.g3, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.w wVar = new d.a.s0.u0.m1.d.w(frsGoodFragment.n(), b2.z3, this.f67254a.getUniqueId());
            u uVar = new u(frsGoodFragment.n(), b2.h3, this.f67254a.getUniqueId());
            r rVar = new r(frsGoodFragment.n(), b2.i3, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.z zVar = new d.a.s0.u0.m1.d.z(frsGoodFragment.getPageContext(), b2.l3, this.f67254a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), b2.j3, this.f67254a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), b2.k3, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.z zVar2 = new d.a.s0.u0.m1.d.z(frsGoodFragment.getPageContext(), b2.u3, this.f67254a.getUniqueId());
            d.a.s0.u0.r rVar2 = new d.a.s0.u0.r(frsGoodFragment.getPageContext(), d.a.s0.u0.s.f67019f);
            d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f67254a.getUniqueId(), true);
            d.a.c.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), b2.I3, this.f67254a.getUniqueId());
            d.a.c.k.e.a<?, ?> g2 = d.a.s0.w2.w.p().g(this.f67254a, AdvertAppInfo.f4);
            d.a.c.k.e.a<?, ?> g3 = d.a.s0.w2.w.p().g(this.f67254a, AdvertAppInfo.i4);
            x xVar = new x(frsGoodFragment.getPageContext(), b2.q3, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.b bVar = new d.a.s0.u0.m1.d.b(frsGoodFragment.getPageContext(), b2.s3, this.f67254a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), b2.r3, this.f67254a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), b2.t3, this.f67254a.getUniqueId());
            d.a.s0.u0.m1.d.e eVar = new d.a.s0.u0.m1.d.e(frsGoodFragment.getPageContext(), b2.f3, this.f67254a.getUniqueId());
            eVar.i0(bdTypeRecyclerView);
            this.f67257d.add(yVar);
            this.f67257d.add(kVar);
            this.f67257d.add(vVar);
            this.f67257d.add(sVar);
            this.f67257d.add(jVar);
            this.f67257d.add(mVar);
            this.f67257d.add(wVar);
            this.f67257d.add(a0Var);
            this.f67257d.add(uVar);
            this.f67257d.add(rVar);
            this.f67257d.add(zVar);
            this.f67257d.add(pVar);
            this.f67257d.add(pVar);
            this.f67257d.add(tVar);
            this.f67257d.add(rVar2);
            this.f67257d.add(zVar);
            this.f67257d.add(zVar2);
            this.f67257d.add(xVar);
            this.f67257d.add(bVar);
            this.f67257d.add(gVar);
            this.f67257d.add(hVar);
            this.f67257d.add(eVar);
            if (a2 != null) {
                this.f67257d.add(a2);
            }
            if (d2 != null) {
                this.f67257d.add(d2);
            }
            this.f67257d.add(g2);
            this.f67257d.add(g3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f67254a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f67257d.add(d.a.s0.v0.b.e().b(this.f67254a.getBaseFragmentActivity(), AdvertAppInfo.q4));
            this.f67257d.add(d.a.s0.v0.b.e().b(this.f67254a.getBaseFragmentActivity(), AdvertAppInfo.p4));
            d.a.s0.e.f.b bVar2 = new d.a.s0.e.f.b(this.f67254a, 1);
            bVar2.t(this.f67257d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f67257d);
            v("page_frs_good");
            for (d.a.c.k.e.a aVar : this.f67257d) {
                if (aVar instanceof d.a.s0.a0.a0) {
                    ((d.a.s0.a0.a0) aVar).l(true);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (d.a.c.k.e.a aVar : this.f67257d) {
                if (aVar != null && aVar.H() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f67255b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f67255b.getAdapter().notifyDataSetChanged();
        }
    }

    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (d.a.c.k.e.a aVar : this.f67257d) {
                if (aVar instanceof k) {
                    ((k) aVar).i0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f67262i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f67255b.setData(this.f67260g);
            p();
        }
    }

    public final void u(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<n> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().getType() == b2.N2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f67257d) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.s0.u0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            v.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f67255b.setData(switchThreadDataToThreadCardInfo);
            this.f67260g = switchThreadDataToThreadCardInfo;
            this.f67259f = arrayList;
            this.f67261h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f67257d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f67257d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f67257d) || this.f67254a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f67257d) {
            if (aVar instanceof k) {
                ((k) aVar).s0(this.f67254a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f67257d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f67257d) {
            if (aVar instanceof k) {
                ((k) aVar).l0(frsViewData);
            }
        }
    }
}
