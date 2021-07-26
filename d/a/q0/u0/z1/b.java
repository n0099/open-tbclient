package d.a.q0.u0.z1;

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
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.a0.z;
import d.a.q0.h3.v;
import d.a.q0.o.f;
import d.a.q0.u0.e;
import d.a.q0.u0.j2.d;
import d.a.q0.u0.k;
import d.a.q0.u0.m1.d.a0;
import d.a.q0.u0.m1.d.g;
import d.a.q0.u0.m1.d.h;
import d.a.q0.u0.m1.d.j;
import d.a.q0.u0.m1.d.m;
import d.a.q0.u0.m1.d.p;
import d.a.q0.u0.m1.d.r;
import d.a.q0.u0.m1.d.s;
import d.a.q0.u0.m1.d.t;
import d.a.q0.u0.m1.d.u;
import d.a.q0.u0.m1.d.x;
import d.a.q0.u0.m1.d.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsGoodFragment f64682a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f64683b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f64684c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f64685d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, b2> f64686e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<n> f64687f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<n> f64688g;

    /* renamed from: h  reason: collision with root package name */
    public FrsViewData f64689h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f64690i;
    public CustomMessageListener j;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64691a;

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
            this.f64691a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<d.a.d.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.d.k.e.a<?, ?> next = it.next();
                    if (next instanceof k) {
                        ((k) next).o(this.f64691a.f64682a.getPageContext(), this.f64691a.f64682a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.f64691a.f64685d != null) {
                    this.f64691a.f64685d.addAll(arrayList);
                }
                if (this.f64691a.f64683b != null) {
                    this.f64691a.f64683b.a(arrayList);
                }
            }
        }
    }

    /* renamed from: d.a.q0.u0.z1.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1740b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f64692a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1740b(b bVar, int i2) {
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
            this.f64692a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f64692a.f64684c)) {
                b bVar = this.f64692a;
                bVar.i(bVar.f64683b);
                b bVar2 = this.f64692a;
                bVar2.w(bVar2.f64687f, this.f64692a.f64689h);
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
        this.f64685d = new LinkedList();
        this.f64690i = new a(this, 2003008);
        this.j = new C1740b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.f64683b = bdTypeRecyclerView;
        this.f64686e = new HashMap<>();
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (d.a.d.k.e.a aVar : this.f64685d) {
                if (aVar instanceof z) {
                    ((z) aVar).r(3);
                }
            }
        }
    }

    public void B(w wVar) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wVar) == null) || (list = this.f64685d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f64685d) {
            if (aVar != null && (aVar instanceof k)) {
                ((k) aVar).a0(wVar);
            }
        }
    }

    public final void C() {
        d.a.q0.u0.j2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f64689h == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f64685d) {
            if ((aVar instanceof d) && (j = ((d) aVar).j()) != null) {
                if (this.f64689h.needLog == 1) {
                    j.f63599a = true;
                } else {
                    j.f63599a = false;
                }
                if (this.f64689h.getForum() != null) {
                    j.f63601c = this.f64689h.getForum().getId();
                }
                if (this.f64682a != null) {
                    j.f63600b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (bdTypeRecyclerView = this.f64683b) == null || bdTypeRecyclerView.getData() == null || this.f64683b.getData().size() == 0) {
            return;
        }
        for (n nVar : this.f64683b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.n0() != 0) {
                    a2Var.w.O2();
                }
            }
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) || this.f64682a == null || bdTypeRecyclerView == null || i(bdTypeRecyclerView)) {
            return;
        }
        this.f64682a.registerListener(this.j);
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.f64682a != null && bdTypeRecyclerView != null) {
                this.f64684c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = e.e().b(this.f64682a.getPageContext(), g2.get(i2), this.f64682a.getUniqueId());
                        if (b2 != null) {
                            this.f64685d.add(b2);
                            this.f64684c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f64684c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f64684c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f64686e : (HashMap) invokeV.objValue;
    }

    public final void k(ArrayList<n> arrayList) {
        HashMap<Integer, b2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f64686e) != null && !hashMap.containsValue(nVar)) {
                this.f64686e.put(Integer.valueOf(i2), (b2) nVar);
            }
        }
    }

    public List<n> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f64687f : (List) invokeV.objValue;
    }

    public List<n> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f64688g : (List) invokeV.objValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.f64682a = frsGoodFragment;
            this.f64690i.setPriority(1);
            this.f64690i.setSelfListener(true);
            this.f64682a.registerListener(this.f64690i);
            y yVar = new y(frsGoodFragment.m(), b2.a3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.k kVar = new d.a.q0.u0.m1.d.k(frsGoodFragment.m(), b2.b3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.v vVar = new d.a.q0.u0.m1.d.v(frsGoodFragment.m(), b2.d3, this.f64682a.getUniqueId());
            s sVar = new s(frsGoodFragment.m(), b2.e3, this.f64682a.getUniqueId());
            j jVar = new j(frsGoodFragment.m(), b2.g3, this.f64682a.getUniqueId());
            m mVar = new m(frsGoodFragment.m(), b2.h3, this.f64682a.getUniqueId());
            a0 a0Var = new a0(frsGoodFragment.m(), b2.m3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.w wVar = new d.a.q0.u0.m1.d.w(frsGoodFragment.m(), b2.F3, this.f64682a.getUniqueId());
            u uVar = new u(frsGoodFragment.m(), b2.n3, this.f64682a.getUniqueId());
            r rVar = new r(frsGoodFragment.m(), b2.o3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.z zVar = new d.a.q0.u0.m1.d.z(frsGoodFragment.getPageContext(), b2.r3, this.f64682a.getUniqueId());
            p pVar = new p(frsGoodFragment.getPageContext(), b2.p3, this.f64682a.getUniqueId());
            t tVar = new t(frsGoodFragment.getPageContext(), b2.q3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.z zVar2 = new d.a.q0.u0.m1.d.z(frsGoodFragment.getPageContext(), b2.A3, this.f64682a.getUniqueId());
            d.a.q0.u0.r rVar2 = new d.a.q0.u0.r(frsGoodFragment.getPageContext(), d.a.q0.u0.s.f64447f);
            d.a.d.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = e.e().a(frsGoodFragment.getPageContext(), this.f64682a.getUniqueId(), true);
            d.a.d.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d2 = e.e().d(frsGoodFragment.getPageContext(), b2.O3, this.f64682a.getUniqueId());
            d.a.d.k.e.a<?, ?> f2 = d.a.q0.w2.w.o().f(this.f64682a, AdvertAppInfo.l4);
            d.a.d.k.e.a<?, ?> f3 = d.a.q0.w2.w.o().f(this.f64682a, AdvertAppInfo.o4);
            x xVar = new x(frsGoodFragment.getPageContext(), b2.w3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.b bVar = new d.a.q0.u0.m1.d.b(frsGoodFragment.getPageContext(), b2.y3, this.f64682a.getUniqueId());
            g gVar = new g(frsGoodFragment.getPageContext(), b2.x3, this.f64682a.getUniqueId());
            h hVar = new h(frsGoodFragment.getPageContext(), b2.z3, this.f64682a.getUniqueId());
            d.a.q0.u0.m1.d.e eVar = new d.a.q0.u0.m1.d.e(frsGoodFragment.getPageContext(), b2.l3, this.f64682a.getUniqueId());
            eVar.i0(bdTypeRecyclerView);
            this.f64685d.add(yVar);
            this.f64685d.add(kVar);
            this.f64685d.add(vVar);
            this.f64685d.add(sVar);
            this.f64685d.add(jVar);
            this.f64685d.add(mVar);
            this.f64685d.add(wVar);
            this.f64685d.add(a0Var);
            this.f64685d.add(uVar);
            this.f64685d.add(rVar);
            this.f64685d.add(zVar);
            this.f64685d.add(pVar);
            this.f64685d.add(pVar);
            this.f64685d.add(tVar);
            this.f64685d.add(rVar2);
            this.f64685d.add(zVar);
            this.f64685d.add(zVar2);
            this.f64685d.add(xVar);
            this.f64685d.add(bVar);
            this.f64685d.add(gVar);
            this.f64685d.add(hVar);
            this.f64685d.add(eVar);
            if (a2 != null) {
                this.f64685d.add(a2);
            }
            if (d2 != null) {
                this.f64685d.add(d2);
            }
            this.f64685d.add(f2);
            this.f64685d.add(f3);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f64682a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.f64685d.add(d.a.q0.v0.b.e().b(this.f64682a.getBaseFragmentActivity(), AdvertAppInfo.w4));
            this.f64685d.add(d.a.q0.v0.b.e().b(this.f64682a.getBaseFragmentActivity(), AdvertAppInfo.v4));
            d.a.q0.e.f.b bVar2 = new d.a.q0.e.f.b(this.f64682a, 1);
            bVar2.t(this.f64685d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f64685d);
            v("page_frs_good");
            for (d.a.d.k.e.a aVar : this.f64685d) {
                if (aVar instanceof d.a.q0.a0.a0) {
                    ((d.a.q0.a0.a0) aVar).l(true);
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
            for (d.a.d.k.e.a aVar : this.f64685d) {
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
            this.f64683b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f64683b.getAdapter().notifyDataSetChanged();
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
            for (d.a.d.k.e.a aVar : this.f64685d) {
                if (aVar instanceof k) {
                    ((k) aVar).i0();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.f64690i);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f64683b.setData(this.f64688g);
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
            if (it.next().getType() == b2.T2) {
                it.remove();
            }
        }
    }

    public final void v(String str) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || (list = this.f64685d) == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : list) {
            if (aVar instanceof f) {
                ((f) aVar).g(str);
            }
        }
    }

    public void w(ArrayList<n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof d.a.q0.u0.s)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            v.f(arrayList, 1);
            k(arrayList);
            ArrayList<n> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.f64683b.setData(switchThreadDataToThreadCardInfo);
            this.f64688g = switchThreadDataToThreadCardInfo;
            this.f64687f = arrayList;
            this.f64689h = frsViewData;
            C();
        }
    }

    public void x(boolean z) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f64685d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f64685d) {
            if (aVar instanceof k) {
                ((k) aVar).setFromCDN(z);
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || ListUtils.isEmpty(this.f64685d) || this.f64682a == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f64685d) {
            if (aVar instanceof k) {
                ((k) aVar).p0(this.f64682a.getTbPageTag());
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) || (list = this.f64685d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f64685d) {
            if (aVar instanceof k) {
                ((k) aVar).l0(frsViewData);
            }
        }
    }
}
