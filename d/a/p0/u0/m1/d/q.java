package d.a.p0.u0.m1.d;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.FrsUserRecommendAdapter;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.a2;
import d.a.o0.r.q.b2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class q implements e0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public FrsFragment f63135a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.c.k.e.s f63136b;

    /* renamed from: c  reason: collision with root package name */
    public List<d.a.c.k.e.a> f63137c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<Integer, b2> f63138d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<d.a.c.k.e.n> f63139e;

    /* renamed from: f  reason: collision with root package name */
    public FrsViewData f63140f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63141g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.p0.u0.i f63142h;

    /* renamed from: i  reason: collision with root package name */
    public d0 f63143i;
    public d.a.c.k.e.a j;
    public y k;
    public k l;
    public v m;
    public s n;
    public j o;
    public m p;
    public w q;
    public a0 r;
    public u s;
    public r t;
    public z u;
    public l v;
    public t w;

    public q(FrsFragment frsFragment, d.a.c.k.e.s sVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, sVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63137c = new LinkedList();
        this.f63141g = false;
        this.f63136b = sVar;
        this.f63142h = new d.a.p0.u0.i();
        p(frsFragment, sVar);
        this.f63138d = new HashMap<>();
        n(z);
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void a(String str) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || (list = this.f63137c) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.p0.a0.z) {
                ((d.a.p0.a0.z) aVar).a(str);
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void b() {
        d.a.c.k.e.s sVar;
        List<d.a.c.k.e.n> data;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (sVar = this.f63136b) == null || sVar.getData() == null || this.f63136b.getData().size() == 0 || (data = this.f63136b.getData()) == null || data.size() == 0) {
            return;
        }
        for (d.a.c.k.e.n nVar : data) {
            if (nVar instanceof b2) {
                b2 b2Var = (b2) nVar;
                if (b2Var.m0() != 0) {
                    b2Var.M2();
                }
            } else if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                if (a2Var.w.m0() != 0) {
                    a2Var.w.M2();
                }
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.j != null) {
                return R.id.frs_fortune_bag_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void d(d.a.c.k.e.w wVar) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, wVar) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).a0(wVar);
            } else if ((aVar instanceof t) || (aVar instanceof z)) {
                aVar.a0(wVar);
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void e() {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).o(this.f63135a.getPageContext(), this.f63135a.getUniqueId());
            }
        }
        z(this.f63137c);
    }

    @Override // d.a.p0.u0.m1.d.e0
    public List<d.a.c.k.e.n> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            d.a.c.k.e.s sVar = this.f63136b;
            if (sVar != null) {
                return sVar.getData();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void g(ArrayList<d.a.c.k.e.n> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, arrayList, frsViewData) == null) {
            v(frsViewData);
            u();
            d.a.p0.h3.v.f(arrayList, 1);
            o(arrayList);
            x(arrayList);
            s(arrayList);
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.n next = it.next();
                if ((next instanceof a2) && ((a2) next).w.m2()) {
                    it.remove();
                }
            }
            this.f63136b.setData(arrayList);
            this.f63140f = frsViewData;
            w();
            y();
            this.f63139e = arrayList;
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public HashMap<Integer, b2> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f63138d : (HashMap) invokeV.objValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.j != null) {
                return R.id.frs_bawu_center;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j != null) {
                return R.id.frs_my_service_item;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public boolean k(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (d.a.c.k.e.a aVar : this.f63137c) {
                if (aVar != null && aVar.H() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void l(d.a.p0.u0.f fVar) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).k0(fVar);
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            for (d.a.c.k.e.a aVar : this.f63137c) {
                if (aVar instanceof d.a.p0.u0.k) {
                    ((d.a.p0.u0.k) aVar).i0();
                } else if (aVar instanceof d.a.p0.w2.o) {
                    ((d.a.p0.w2.o) aVar).onDestroy();
                }
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || this.f63141g == z) {
            return;
        }
        this.f63141g = z;
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void notifyDataSetChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.f63136b.getListAdapter() == null) {
            return;
        }
        this.f63136b.getListAdapter().notifyDataSetChanged();
    }

    public final ArrayList<Integer> o(ArrayList<d.a.c.k.e.n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, arrayList)) == null) {
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            ArrayList<Integer> arrayList2 = new ArrayList<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                d.a.c.k.e.n nVar = arrayList.get(i2);
                if (nVar instanceof AdvertAppInfo) {
                    arrayList2.add(Integer.valueOf(i2));
                    HashMap<Integer, b2> hashMap = this.f63138d;
                    if (hashMap != null && !hashMap.containsValue(nVar)) {
                        this.f63138d.put(Integer.valueOf(i2), (b2) nVar);
                    }
                }
            }
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void p(FrsFragment frsFragment, d.a.c.k.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, frsFragment, sVar) == null) {
            this.f63135a = frsFragment;
            this.j = d.a.p0.u0.e.e().c(frsFragment.getPageContext(), d.a.p0.h3.x.O3, this.f63135a.getUniqueId(), false);
            y yVar = new y(frsFragment.m(), b2.U2, this.f63135a.getUniqueId());
            this.k = yVar;
            yVar.p0(sVar);
            k kVar = new k(frsFragment.m(), b2.V2, this.f63135a.getUniqueId());
            this.l = kVar;
            kVar.p0(sVar);
            v vVar = new v(frsFragment.m(), b2.X2, this.f63135a.getUniqueId());
            this.m = vVar;
            vVar.p0(sVar);
            s sVar2 = new s(frsFragment.m(), b2.Y2, this.f63135a.getUniqueId());
            this.n = sVar2;
            sVar2.p0(sVar);
            j jVar = new j(frsFragment.m(), b2.a3, this.f63135a.getUniqueId());
            this.o = jVar;
            jVar.p0(sVar);
            m mVar = new m(frsFragment.m(), b2.b3, this.f63135a.getUniqueId());
            this.p = mVar;
            mVar.p0(sVar);
            a0 a0Var = new a0(frsFragment.m(), b2.g3, this.f63135a.getUniqueId());
            this.r = a0Var;
            a0Var.p0(sVar);
            w wVar = new w(frsFragment.m(), b2.z3, this.f63135a.getUniqueId());
            this.q = wVar;
            wVar.p0(sVar);
            u uVar = new u(frsFragment.m(), b2.h3, this.f63135a.getUniqueId());
            this.s = uVar;
            uVar.p0(sVar);
            r rVar = new r(frsFragment.m(), b2.i3, this.f63135a.getUniqueId());
            this.t = rVar;
            rVar.p0(sVar);
            z zVar = new z(frsFragment.getPageContext(), b2.l3, this.f63135a.getUniqueId());
            this.u = zVar;
            zVar.p0(sVar);
            l lVar = new l(frsFragment.getPageContext(), b2.E3, this.f63135a.getUniqueId());
            this.v = lVar;
            lVar.p0(sVar);
            p pVar = new p(frsFragment.getPageContext(), b2.j3, this.f63135a.getUniqueId());
            pVar.p0(sVar);
            x xVar = new x(frsFragment.getPageContext(), b2.q3, this.f63135a.getUniqueId());
            xVar.p0(sVar);
            a aVar = new a(frsFragment.getPageContext(), b2.d3, frsFragment.getUniqueId());
            aVar.p0(sVar);
            aVar.r(1);
            c cVar = new c(frsFragment.getPageContext(), b2.Z2, frsFragment.getUniqueId());
            cVar.p0(sVar);
            b bVar = new b(frsFragment.getPageContext(), b2.s3, this.f63135a.getUniqueId());
            bVar.p0(sVar);
            bVar.L0(true);
            g gVar = new g(frsFragment.getPageContext(), b2.r3, this.f63135a.getUniqueId());
            gVar.p0(sVar);
            gVar.L0(true);
            h hVar = new h(frsFragment.getPageContext(), b2.t3, this.f63135a.getUniqueId());
            hVar.p0(sVar);
            hVar.M0(true);
            z zVar2 = new z(frsFragment.getPageContext(), b2.u3, this.f63135a.getUniqueId());
            zVar2.p0(sVar);
            o oVar = new o(frsFragment.getPageContext(), b2.D3, this.f63135a.getUniqueId());
            oVar.p0(sVar);
            n nVar = new n(frsFragment.getPageContext(), b2.v3, this.f63135a.getUniqueId());
            nVar.p0(sVar);
            this.f63143i = new d0(frsFragment.getPageContext(), d.a.p0.h3.q.f58176g, this.f63135a.getUniqueId());
            t tVar = new t(frsFragment.getPageContext(), b2.k3, this.f63135a.getUniqueId());
            this.w = tVar;
            tVar.p0(sVar);
            d.a.c.k.e.a<? extends a2, ? extends TypeAdapter.ViewHolder> a2 = d.a.p0.u0.e.e().a(frsFragment.getPageContext(), this.f63135a.getUniqueId(), true);
            d.a.c.k.e.a<? extends b2, ? extends TypeAdapter.ViewHolder> d2 = d.a.p0.u0.e.e().d(frsFragment.getPageContext(), b2.I3, this.f63135a.getUniqueId());
            d.a.p0.u0.r rVar2 = new d.a.p0.u0.r(frsFragment.getPageContext(), d.a.p0.u0.s.f63802f);
            i iVar = new i(frsFragment.getPageContext(), d.a.p0.u0.u.f63844e);
            FrsUserRecommendAdapter frsUserRecommendAdapter = new FrsUserRecommendAdapter(frsFragment.getPageContext(), d.a.p0.u0.w.f63946i, this.f63135a.getUniqueId());
            e eVar = new e(frsFragment.getPageContext(), b2.f3, this.f63135a.getUniqueId());
            eVar.i0((BdTypeRecyclerView) sVar);
            this.f63137c.add(this.j);
            this.f63137c.add(this.k);
            this.f63137c.add(this.l);
            this.f63137c.add(this.m);
            this.f63137c.add(this.n);
            this.f63137c.add(this.o);
            this.f63137c.add(this.p);
            this.f63137c.add(this.q);
            this.f63137c.add(this.r);
            this.f63137c.add(this.s);
            this.f63137c.add(this.t);
            this.f63137c.add(this.f63143i);
            this.f63137c.add(pVar);
            this.f63137c.add(xVar);
            this.f63137c.add(aVar);
            this.f63137c.add(cVar);
            this.f63137c.add(bVar);
            this.f63137c.add(gVar);
            this.f63137c.add(hVar);
            this.f63137c.add(this.w);
            this.f63137c.add(this.u);
            this.f63137c.add(this.v);
            this.f63137c.add(a2);
            this.f63137c.add(d2);
            this.f63137c.add(rVar2);
            this.f63137c.add(iVar);
            this.f63137c.add(oVar);
            this.f63137c.add(nVar);
            this.f63137c.add(frsUserRecommendAdapter);
            this.f63137c.add(zVar2);
            this.f63137c.add(eVar);
            this.f63137c.add(d.a.p0.v0.b.e().b(this.f63135a.getBaseFragmentActivity(), AdvertAppInfo.q4));
            d.a.p0.e.f.b bVar2 = new d.a.p0.e.f.b(this.f63135a, 1);
            bVar2.t(this.f63137c);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, bVar2));
            z(this.f63137c);
            sVar.a(this.f63137c);
            AbsDelegateAdapterList absDelegateAdapterList = new AbsDelegateAdapterList();
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, absDelegateAdapterList);
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.f63135a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            t("page_frs");
            if (absDelegateAdapterList.isEmpty()) {
                return;
            }
            Iterator<d.a.c.k.e.a<?, ?>> it = absDelegateAdapterList.iterator();
            while (it.hasNext()) {
                d.a.c.k.e.a<?, ?> next = it.next();
                if (next instanceof d.a.p0.u0.k) {
                    ((d.a.p0.u0.k) next).o(this.f63135a.getPageContext(), this.f63135a.getUniqueId());
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(absDelegateAdapterList);
            List<d.a.c.k.e.a> list = this.f63137c;
            if (list != null) {
                list.addAll(arrayList);
            }
            d.a.c.k.e.s sVar3 = this.f63136b;
            if (sVar3 != null) {
                sVar3.a(arrayList);
            }
        }
    }

    public final boolean q(d.a.c.k.e.n nVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, nVar)) == null) {
            if (nVar == null) {
                return false;
            }
            BdUniqueId type = nVar.getType();
            return type == b2.O2 || type == b2.k3 || type == b2.l3 || type == b2.u3 || type == b2.D3;
        }
        return invokeL.booleanValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ArrayList<d.a.c.k.e.n> arrayList = this.f63139e;
            if (arrayList != null) {
                this.f63136b.setData(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    public final void s(ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            int count = ListUtils.getCount(arrayList);
            for (int i2 = 0; i2 < count; i2++) {
                d.a.c.k.e.n nVar = (d.a.c.k.e.n) ListUtils.getItem(arrayList, i2 - 1);
                d.a.c.k.e.n nVar2 = (d.a.c.k.e.n) ListUtils.getItem(arrayList, i2);
                if (nVar2 instanceof a2) {
                    b2 b2Var = ((a2) nVar2).w;
                    if (i2 == 0) {
                        b2Var.isFirstFloor = true;
                    } else {
                        b2Var.isFirstFloor = false;
                    }
                    String recomReason = b2Var.getRecomReason();
                    if (nVar instanceof d.a.p0.u0.u) {
                        b2Var.needTopMargin = false;
                    } else if (nVar != null && !q(nVar)) {
                        b2Var.needTopMargin = false;
                    } else if ((nVar instanceof a2) && q(nVar) && !TextUtils.isEmpty(((a2) nVar).w.getRecomReason())) {
                        b2Var.needTopMargin = true;
                    } else if (q(nVar2) && !TextUtils.isEmpty(recomReason)) {
                        b2Var.needTopMargin = true;
                    } else {
                        b2Var.needTopMargin = false;
                    }
                }
            }
        }
    }

    @Override // d.a.p0.u0.m1.d.e0
    public void setFromCDN(boolean z) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048596, this, z) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).setFromCDN(z);
            }
        }
        y yVar = this.k;
        if (yVar != null) {
            yVar.setFromCDN(z);
        }
        k kVar = this.l;
        if (kVar != null) {
            kVar.setFromCDN(z);
        }
        v vVar = this.m;
        if (vVar != null) {
            vVar.setFromCDN(z);
        }
        s sVar = this.n;
        if (sVar != null) {
            sVar.setFromCDN(z);
        }
        j jVar = this.o;
        if (jVar != null) {
            jVar.setFromCDN(z);
        }
        m mVar = this.p;
        if (mVar != null) {
            mVar.setFromCDN(z);
        }
        z zVar = this.u;
        if (zVar != null) {
            zVar.setFromCDN(z);
        }
        t tVar = this.w;
        if (tVar != null) {
            tVar.setFromCDN(z);
        }
    }

    public final void t(String str) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || (list = this.f63137c) == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.p0.o.f) {
                ((d.a.p0.o.f) aVar).g(str);
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || ListUtils.isEmpty(this.f63137c) || this.f63135a == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).s0(this.f63135a.getTbPageTag());
            }
        }
    }

    public void v(FrsViewData frsViewData) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, frsViewData) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).l0(frsViewData);
            }
        }
    }

    public final void w() {
        d.a.p0.u0.j2.b j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f63140f == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if ((aVar instanceof d.a.p0.u0.j2.d) && (j = ((d.a.p0.u0.j2.d) aVar).j()) != null) {
                if (this.f63140f.needLog == 1) {
                    j.f62956a = true;
                } else {
                    j.f62956a = false;
                }
                if (this.f63140f.getForum() != null) {
                    j.f62958c = this.f63140f.getForum().getId();
                }
                FrsFragment frsFragment = this.f63135a;
                if (frsFragment != null && frsFragment.d0() != null) {
                    int R = this.f63135a.d0().R();
                    if (R == -1) {
                        R = this.f63135a.d0().Q();
                    }
                    j.f62957b = R;
                }
            }
        }
    }

    public final void x(ArrayList<d.a.c.k.e.n> arrayList) {
        List<d.a.c.k.e.a> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, arrayList) == null) || (list = this.f63137c) == null || list.size() == 0) {
            return;
        }
        int i2 = 0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<d.a.c.k.e.n> it = arrayList.iterator();
            while (it.hasNext() && it.next().getType().getId() == b2.N2.getId()) {
                i2++;
            }
        }
        for (d.a.c.k.e.a aVar : this.f63137c) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).t0(i2);
            }
        }
    }

    public final void y() {
        FrsViewData frsViewData;
        d0 d0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || (frsViewData = this.f63140f) == null || frsViewData.getForum() == null || StringUtils.isNull(this.f63140f.getForum().getId()) || (d0Var = this.f63143i) == null) {
            return;
        }
        d0Var.A0(this.f63140f.getForum().getId());
    }

    public final void z(List<d.a.c.k.e.a> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || list == null) {
            return;
        }
        for (d.a.c.k.e.a aVar : list) {
            if (aVar instanceof d.a.p0.u0.k) {
                ((d.a.p0.u0.k) aVar).j0(this.f63142h);
            }
        }
    }
}
