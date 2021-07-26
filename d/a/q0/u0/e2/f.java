package d.a.q0.u0.e2;

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
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.a2;
import d.a.p0.s.q.b2;
import d.a.q0.h3.v;
import d.a.q0.u0.m1.d.a0;
import d.a.q0.u0.m1.d.p;
import d.a.q0.u0.m1.d.r;
import d.a.q0.u0.m1.d.s;
import d.a.q0.u0.m1.d.t;
import d.a.q0.u0.m1.d.u;
import d.a.q0.u0.m1.d.w;
import d.a.q0.u0.m1.d.x;
import d.a.q0.u0.m1.d.y;
import d.a.q0.u0.m1.d.z;
import d.a.q0.w2.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f63319a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f63320b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.d.k.e.a> f63321c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.d.k.e.a> f63322d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, b2> f63323e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.d.k.e.n> f63324f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f63325g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f63326h;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f63327a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f63327a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f63327a.f63321c)) {
                f fVar = this.f63327a;
                fVar.g(fVar.f63320b);
                f fVar2 = this.f63327a;
                fVar2.q(fVar2.f63324f, this.f63327a.f63325g);
            }
        }
    }

    public f(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63322d = new LinkedList();
        this.f63326h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f63320b = bdTypeRecyclerView;
        this.f63323e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f63319a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f63319a.registerListener(this.f63326h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f63319a != null && bdTypeRecyclerView != null) {
                this.f63321c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.a.q0.u0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.q0.u0.e.e().b(this.f63319a.getPageContext(), g2.get(i2), this.f63319a.getUniqueId());
                        if (b2 != null) {
                            this.f63322d.add(b2);
                            this.f63321c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f63321c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f63321c);
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public HashMap<Integer, b2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f63323e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<d.a.d.k.e.n> arrayList) {
        HashMap<Integer, b2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.d.k.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f63323e) != null && !hashMap.containsValue(nVar)) {
                this.f63323e.put(Integer.valueOf(i2), (b2) nVar);
            }
        }
    }

    public List<d.a.d.k.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f63324f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f63319a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.m(), b2.a3, this.f63319a.getUniqueId());
            yVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.k kVar = new d.a.q0.u0.m1.d.k(frsNewAreaFragment.m(), b2.b3, this.f63319a.getUniqueId());
            kVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.v vVar = new d.a.q0.u0.m1.d.v(frsNewAreaFragment.m(), b2.d3, this.f63319a.getUniqueId());
            vVar.n0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.m(), b2.e3, this.f63319a.getUniqueId());
            sVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.j jVar = new d.a.q0.u0.m1.d.j(frsNewAreaFragment.m(), b2.g3, this.f63319a.getUniqueId());
            jVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.m mVar = new d.a.q0.u0.m1.d.m(frsNewAreaFragment.m(), b2.h3, this.f63319a.getUniqueId());
            mVar.n0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.m(), b2.m3, this.f63319a.getUniqueId());
            a0Var.n0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.m(), b2.F3, this.f63319a.getUniqueId());
            wVar.n0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.m(), b2.n3, this.f63319a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.m(), b2.o3, this.f63319a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), b2.r3, this.f63319a.getUniqueId());
            zVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.l lVar = new d.a.q0.u0.m1.d.l(frsNewAreaFragment.getPageContext(), b2.K3, this.f63319a.getUniqueId());
            lVar.n0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), b2.p3, this.f63319a.getUniqueId());
            pVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.b bVar = new d.a.q0.u0.m1.d.b(frsNewAreaFragment.getPageContext(), b2.y3, this.f63319a.getUniqueId());
            bVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.g gVar = new d.a.q0.u0.m1.d.g(frsNewAreaFragment.getPageContext(), b2.x3, this.f63319a.getUniqueId());
            gVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.h hVar = new d.a.q0.u0.m1.d.h(frsNewAreaFragment.getPageContext(), b2.z3, this.f63319a.getUniqueId());
            hVar.n0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), b2.q3, this.f63319a.getUniqueId());
            tVar.n0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), b2.A3, this.f63319a.getUniqueId());
            zVar2.n0(bdTypeRecyclerView);
            d.a.q0.u0.r rVar2 = new d.a.q0.u0.r(frsNewAreaFragment.getPageContext(), d.a.q0.u0.s.f64447f);
            rVar2.n0(bdTypeRecyclerView);
            d.a.d.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = d.a.q0.u0.e.e().a(frsNewAreaFragment.getPageContext(), this.f63319a.getUniqueId(), true);
            d.a.d.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d2 = d.a.q0.u0.e.e().d(frsNewAreaFragment.getPageContext(), b2.O3, this.f63319a.getUniqueId());
            d.a.d.k.e.a<?, ?> f2 = d.a.q0.w2.w.o().f(this.f63319a, AdvertAppInfo.l4);
            d.a.d.k.e.a<?, ?> f3 = d.a.q0.w2.w.o().f(this.f63319a, AdvertAppInfo.o4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), b2.w3, this.f63319a.getUniqueId());
            xVar.n0(bdTypeRecyclerView);
            d.a.q0.u0.m1.d.e eVar = new d.a.q0.u0.m1.d.e(frsNewAreaFragment.getPageContext(), b2.l3, this.f63319a.getUniqueId());
            eVar.i0(bdTypeRecyclerView);
            this.f63322d.add(yVar);
            this.f63322d.add(kVar);
            this.f63322d.add(vVar);
            this.f63322d.add(sVar);
            this.f63322d.add(jVar);
            this.f63322d.add(mVar);
            this.f63322d.add(wVar);
            this.f63322d.add(a0Var);
            this.f63322d.add(uVar);
            this.f63322d.add(rVar);
            this.f63322d.add(zVar);
            this.f63322d.add(pVar);
            this.f63322d.add(bVar);
            this.f63322d.add(gVar);
            this.f63322d.add(hVar);
            this.f63322d.add(tVar);
            this.f63322d.add(rVar2);
            this.f63322d.add(lVar);
            this.f63322d.add(zVar2);
            this.f63322d.add(xVar);
            this.f63322d.add(eVar);
            if (a2 != null) {
                this.f63322d.add(a2);
            }
            if (d2 != null) {
                this.f63322d.add(d2);
            }
            this.f63322d.add(f2);
            this.f63322d.add(f3);
            d.a.d.k.e.a<?, ?> b2 = d.a.q0.v0.b.e().b(this.f63319a.getBaseFragmentActivity(), AdvertAppInfo.w4);
            d.a.d.k.e.a<?, ?> b3 = d.a.q0.v0.b.e().b(this.f63319a.getBaseFragmentActivity(), AdvertAppInfo.v4);
            this.f63322d.add(b2);
            this.f63322d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f63319a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<d.a.d.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.d.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.q0.u0.k) {
                        ((d.a.q0.u0.k) next).o(this.f63319a.getPageContext(), this.f63319a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<d.a.d.k.e.a> list = this.f63322d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            d.a.q0.e.f.b bVar2 = new d.a.q0.e.f.b(this.f63319a, 1);
            bVar2.t(this.f63322d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f63322d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f63320b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f63320b.getAdapter().notifyDataSetChanged();
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            for (d.a.d.k.e.a aVar : this.f63322d) {
                if (aVar instanceof d.a.q0.u0.k) {
                    ((d.a.q0.u0.k) aVar).i0();
                } else if (aVar instanceof o) {
                    ((o) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f63320b.setData(this.f63324f);
            l();
        }
    }

    public void q(ArrayList<d.a.d.k.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            v.f(arrayList, 1);
            i(arrayList);
            this.f63320b.setData(arrayList);
            this.f63324f = arrayList;
            this.f63325g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f63322d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63322d) {
            if (aVar instanceof d.a.q0.u0.k) {
                ((d.a.q0.u0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f63322d) || this.f63319a == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63322d) {
            if (aVar instanceof d.a.q0.u0.k) {
                ((d.a.q0.u0.k) aVar).p0(this.f63319a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f63322d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63322d) {
            if (aVar instanceof d.a.q0.u0.k) {
                ((d.a.q0.u0.k) aVar).l0(frsViewData);
            }
        }
    }

    public void u(d.a.d.k.e.w wVar) {
        List<d.a.d.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f63322d) == null || list.size() == 0) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63322d) {
            if (aVar != null && (aVar instanceof d.a.q0.u0.k)) {
                ((d.a.q0.u0.k) aVar).a0(wVar);
            }
        }
    }

    public final void v() {
        d.a.q0.u0.j2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f63325g == null) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f63322d) {
            if ((aVar instanceof d.a.q0.u0.j2.d) && (j = ((d.a.q0.u0.j2.d) aVar).j()) != null) {
                if (this.f63325g.needLog == 1) {
                    j.f63599a = true;
                } else {
                    j.f63599a = false;
                }
                if (this.f63325g.getForum() != null) {
                    j.f63601c = this.f63325g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f63320b) == null || bdTypeRecyclerView.getData() == null || this.f63320b.getData().size() == 0) {
            return;
        }
        for (d.a.d.k.e.n nVar : this.f63320b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.n0() != 0) {
                    a2Var.w.O2();
                }
            }
        }
    }
}
