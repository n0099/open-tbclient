package d.a.s0.u0.e2;

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
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.s0.h3.v;
import d.a.s0.u0.m1.d.a0;
import d.a.s0.u0.m1.d.p;
import d.a.s0.u0.m1.d.r;
import d.a.s0.u0.m1.d.s;
import d.a.s0.u0.m1.d.t;
import d.a.s0.u0.m1.d.u;
import d.a.s0.u0.m1.d.w;
import d.a.s0.u0.m1.d.x;
import d.a.s0.u0.m1.d.y;
import d.a.s0.u0.m1.d.z;
import d.a.s0.w2.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsNewAreaFragment f65895a;

    /* renamed from: b  reason: collision with root package name */
    public BdTypeRecyclerView f65896b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65897c;

    /* renamed from: d  reason: collision with root package name */
    public List<d.a.c.k.e.a> f65898d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Integer, b2> f65899e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f65900f;

    /* renamed from: g  reason: collision with root package name */
    public FrsViewData f65901g;

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f65902h;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f65903a;

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
            this.f65903a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.f65903a.f65897c)) {
                f fVar = this.f65903a;
                fVar.g(fVar.f65896b);
                f fVar2 = this.f65903a;
                fVar2.q(fVar2.f65900f, this.f65903a.f65901g);
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
        this.f65898d = new LinkedList();
        this.f65902h = new a(this, 2016470);
        k(frsNewAreaFragment, bdTypeRecyclerView);
        this.f65896b = bdTypeRecyclerView;
        this.f65899e = new HashMap<>();
    }

    public final void f(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bdTypeRecyclerView) == null) || this.f65895a == null || bdTypeRecyclerView == null || g(bdTypeRecyclerView)) {
            return;
        }
        this.f65895a.registerListener(this.f65902h);
    }

    public final boolean g(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeRecyclerView)) == null) {
            if (this.f65895a != null && bdTypeRecyclerView != null) {
                this.f65897c = new ArrayList();
                ArrayList<BdUniqueId> g2 = v.g();
                if (g2 != null && g2.size() > 0) {
                    int size = g2.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        d.a.s0.u0.k<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = d.a.s0.u0.e.e().b(this.f65895a.getPageContext(), g2.get(i2), this.f65895a.getUniqueId());
                        if (b2 != null) {
                            this.f65898d.add(b2);
                            this.f65897c.add(b2);
                        }
                    }
                    if (ListUtils.isEmpty(this.f65897c)) {
                        return true;
                    }
                    bdTypeRecyclerView.a(this.f65897c);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f65899e : (HashMap) invokeV.objValue;
    }

    public final void i(ArrayList<d.a.c.k.e.n> arrayList) {
        HashMap<Integer, b2> hashMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) || arrayList == null || arrayList.size() == 0) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            d.a.c.k.e.n nVar = arrayList.get(i2);
            if ((nVar instanceof AdvertAppInfo) && (hashMap = this.f65899e) != null && !hashMap.containsValue(nVar)) {
                this.f65899e.put(Integer.valueOf(i2), (b2) nVar);
            }
        }
    }

    public List<d.a.c.k.e.n> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65900f : (List) invokeV.objValue;
    }

    public void k(FrsNewAreaFragment frsNewAreaFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, frsNewAreaFragment, bdTypeRecyclerView) == null) {
            this.f65895a = frsNewAreaFragment;
            y yVar = new y(frsNewAreaFragment.n(), b2.U2, this.f65895a.getUniqueId());
            yVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.k kVar = new d.a.s0.u0.m1.d.k(frsNewAreaFragment.n(), b2.V2, this.f65895a.getUniqueId());
            kVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.v vVar = new d.a.s0.u0.m1.d.v(frsNewAreaFragment.n(), b2.X2, this.f65895a.getUniqueId());
            vVar.p0(bdTypeRecyclerView);
            s sVar = new s(frsNewAreaFragment.n(), b2.Y2, this.f65895a.getUniqueId());
            sVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.j jVar = new d.a.s0.u0.m1.d.j(frsNewAreaFragment.n(), b2.a3, this.f65895a.getUniqueId());
            jVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.m mVar = new d.a.s0.u0.m1.d.m(frsNewAreaFragment.n(), b2.b3, this.f65895a.getUniqueId());
            mVar.p0(bdTypeRecyclerView);
            a0 a0Var = new a0(frsNewAreaFragment.n(), b2.g3, this.f65895a.getUniqueId());
            a0Var.p0(bdTypeRecyclerView);
            w wVar = new w(frsNewAreaFragment.n(), b2.z3, this.f65895a.getUniqueId());
            wVar.p0(bdTypeRecyclerView);
            u uVar = new u(frsNewAreaFragment.n(), b2.h3, this.f65895a.getUniqueId());
            r rVar = new r(frsNewAreaFragment.n(), b2.i3, this.f65895a.getUniqueId());
            z zVar = new z(frsNewAreaFragment.getPageContext(), b2.l3, this.f65895a.getUniqueId());
            zVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.l lVar = new d.a.s0.u0.m1.d.l(frsNewAreaFragment.getPageContext(), b2.E3, this.f65895a.getUniqueId());
            lVar.p0(bdTypeRecyclerView);
            p pVar = new p(frsNewAreaFragment.getPageContext(), b2.j3, this.f65895a.getUniqueId());
            pVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.b bVar = new d.a.s0.u0.m1.d.b(frsNewAreaFragment.getPageContext(), b2.s3, this.f65895a.getUniqueId());
            bVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.g gVar = new d.a.s0.u0.m1.d.g(frsNewAreaFragment.getPageContext(), b2.r3, this.f65895a.getUniqueId());
            gVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.h hVar = new d.a.s0.u0.m1.d.h(frsNewAreaFragment.getPageContext(), b2.t3, this.f65895a.getUniqueId());
            hVar.p0(bdTypeRecyclerView);
            t tVar = new t(frsNewAreaFragment.getPageContext(), b2.k3, this.f65895a.getUniqueId());
            tVar.p0(bdTypeRecyclerView);
            z zVar2 = new z(frsNewAreaFragment.getPageContext(), b2.u3, this.f65895a.getUniqueId());
            zVar2.p0(bdTypeRecyclerView);
            d.a.s0.u0.r rVar2 = new d.a.s0.u0.r(frsNewAreaFragment.getPageContext(), d.a.s0.u0.s.f67019f);
            rVar2.p0(bdTypeRecyclerView);
            d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = d.a.s0.u0.e.e().a(frsNewAreaFragment.getPageContext(), this.f65895a.getUniqueId(), true);
            d.a.c.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d2 = d.a.s0.u0.e.e().d(frsNewAreaFragment.getPageContext(), b2.I3, this.f65895a.getUniqueId());
            d.a.c.k.e.a<?, ?> g2 = d.a.s0.w2.w.p().g(this.f65895a, AdvertAppInfo.f4);
            d.a.c.k.e.a<?, ?> g3 = d.a.s0.w2.w.p().g(this.f65895a, AdvertAppInfo.i4);
            x xVar = new x(frsNewAreaFragment.getPageContext(), b2.q3, this.f65895a.getUniqueId());
            xVar.p0(bdTypeRecyclerView);
            d.a.s0.u0.m1.d.e eVar = new d.a.s0.u0.m1.d.e(frsNewAreaFragment.getPageContext(), b2.f3, this.f65895a.getUniqueId());
            eVar.i0(bdTypeRecyclerView);
            this.f65898d.add(yVar);
            this.f65898d.add(kVar);
            this.f65898d.add(vVar);
            this.f65898d.add(sVar);
            this.f65898d.add(jVar);
            this.f65898d.add(mVar);
            this.f65898d.add(wVar);
            this.f65898d.add(a0Var);
            this.f65898d.add(uVar);
            this.f65898d.add(rVar);
            this.f65898d.add(zVar);
            this.f65898d.add(pVar);
            this.f65898d.add(bVar);
            this.f65898d.add(gVar);
            this.f65898d.add(hVar);
            this.f65898d.add(tVar);
            this.f65898d.add(rVar2);
            this.f65898d.add(lVar);
            this.f65898d.add(zVar2);
            this.f65898d.add(xVar);
            this.f65898d.add(eVar);
            if (a2 != null) {
                this.f65898d.add(a2);
            }
            if (d2 != null) {
                this.f65898d.add(d2);
            }
            this.f65898d.add(g2);
            this.f65898d.add(g3);
            d.a.c.k.e.a<?, ?> b2 = d.a.s0.v0.b.e().b(this.f65895a.getBaseFragmentActivity(), AdvertAppInfo.q4);
            d.a.c.k.e.a<?, ?> b3 = d.a.s0.v0.b.e().b(this.f65895a.getBaseFragmentActivity(), AdvertAppInfo.p4);
            this.f65898d.add(b2);
            this.f65898d.add(b3);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f65895a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            if (!absDelegateAdapterList.isEmpty()) {
                Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    d.a.c.k.e.a<?, ?> next = it.next();
                    if (next instanceof d.a.s0.u0.k) {
                        ((d.a.s0.u0.k) next).o(this.f65895a.getPageContext(), this.f65895a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                List<d.a.c.k.e.a> list = this.f65898d;
                if (list != null) {
                    list.addAll(arrayList);
                }
            }
            f(bdTypeRecyclerView);
            d.a.s0.e.f.b bVar2 = new d.a.s0.e.f.b(this.f65895a, 1);
            bVar2.t(this.f65898d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            bdTypeRecyclerView.a(this.f65898d);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f65896b.getAdapter().notifyDataSetChanged();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f65896b.getAdapter().notifyDataSetChanged();
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
            for (d.a.c.k.e.a aVar : this.f65898d) {
                if (aVar instanceof d.a.s0.u0.k) {
                    ((d.a.s0.u0.k) aVar).i0();
                } else if (aVar instanceof o) {
                    ((o) aVar).onDestroy();
                }
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f65896b.setData(this.f65900f);
            l();
        }
    }

    public void q(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, arrayList, frsViewData) == null) {
            t(frsViewData);
            s();
            v.f(arrayList, 1);
            i(arrayList);
            this.f65896b.setData(arrayList);
            this.f65900f = arrayList;
            this.f65901g = frsViewData;
            v();
        }
    }

    public void r(boolean z) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (list = this.f65898d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f65898d) {
            if (aVar instanceof d.a.s0.u0.k) {
                ((d.a.s0.u0.k) aVar).setFromCDN(z);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || ListUtils.isEmpty(this.f65898d) || this.f65895a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f65898d) {
            if (aVar instanceof d.a.s0.u0.k) {
                ((d.a.s0.u0.k) aVar).s0(this.f65895a.getTbPageTag());
            }
        }
    }

    public void t(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, frsViewData) == null) || (list = this.f65898d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f65898d) {
            if (aVar instanceof d.a.s0.u0.k) {
                ((d.a.s0.u0.k) aVar).l0(frsViewData);
            }
        }
    }

    public void u(d.a.c.k.e.w wVar) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, wVar) == null) || (list = this.f65898d) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f65898d) {
            if (aVar != null && (aVar instanceof d.a.s0.u0.k)) {
                ((d.a.s0.u0.k) aVar).a0(wVar);
            }
        }
    }

    public final void v() {
        d.a.s0.u0.j2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || this.f65901g == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f65898d) {
            if ((aVar instanceof d.a.s0.u0.j2.d) && (j = ((d.a.s0.u0.j2.d) aVar).j()) != null) {
                if (this.f65901g.needLog == 1) {
                    j.f66175a = true;
                } else {
                    j.f66175a = false;
                }
                if (this.f65901g.getForum() != null) {
                    j.f66177c = this.f65901g.getForum().getId();
                }
            }
        }
    }

    public void w() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (bdTypeRecyclerView = this.f65896b) == null || bdTypeRecyclerView.getData() == null || this.f65896b.getData().size() == 0) {
            return;
        }
        for (d.a.c.k.e.n nVar : this.f65896b.getData()) {
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.m0() != 0) {
                    a2Var.w.M2();
                }
            }
        }
    }
}
