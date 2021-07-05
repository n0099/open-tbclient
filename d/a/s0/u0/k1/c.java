package d.a.s0.u0.k1;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.commontab.FrsCommonTabFragment;
import com.baidu.tieba.frs.commontab.FrsCommonTabNetModel;
import com.baidu.tieba.frs.commontab.FrsCommonTabRequestData;
import com.baidu.tieba.frs.dynamic.FrsDynamicModel;
import com.baidu.tieba.frs.dynamic.FrsDynamicRequestData;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.r0.r.q.a2;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.n0;
import d.a.r0.r.q.o0;
import d.a.r0.r.q.x0;
import d.a.s0.u0.s;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes9.dex */
public class c implements NetModel.k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public FrsCommonTabFragment f66218e;

    /* renamed from: f  reason: collision with root package name */
    public d f66219f;

    /* renamed from: g  reason: collision with root package name */
    public FrsCommonTabRequestData f66220g;

    /* renamed from: h  reason: collision with root package name */
    public FrsCommonTabNetModel f66221h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f66222i;
    public FrsDynamicRequestData j;
    public FrsDynamicModel k;
    public boolean l;
    public HashSet<String> m;
    public int n;
    public long o;
    public int p;
    public String q;
    public String r;
    public d.a.s0.w0.a s;

    public c(FrsCommonTabFragment frsCommonTabFragment, int i2, int i3, String str, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsCommonTabFragment, Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new HashSet<>();
        this.n = 1;
        this.o = -1L;
        if (frsCommonTabFragment == null) {
            return;
        }
        this.f66218e = frsCommonTabFragment;
        this.r = "FRS_GENERAL_TAB" + i3;
        if (i3 == 89) {
            this.f66222i = true;
            FrsDynamicRequestData frsDynamicRequestData = new FrsDynamicRequestData();
            this.j = frsDynamicRequestData;
            frsDynamicRequestData.forumId = i2;
            frsDynamicRequestData.scrH = l.i(TbadkCoreApplication.getInst());
            this.j.scrW = l.k(TbadkCoreApplication.getInst());
            this.j.scrDip = l.h(TbadkCoreApplication.getInst());
            FrsDynamicModel frsDynamicModel = new FrsDynamicModel(frsCommonTabFragment.getPageContext(), this.j);
            this.k = frsDynamicModel;
            frsDynamicModel.Z(this);
            this.k.setUniqueId(frsCommonTabFragment.getUniqueId());
            return;
        }
        this.f66222i = false;
        FrsCommonTabRequestData frsCommonTabRequestData = new FrsCommonTabRequestData();
        this.f66220g = frsCommonTabRequestData;
        frsCommonTabRequestData.fid = i2;
        frsCommonTabRequestData.tabId = i3;
        frsCommonTabRequestData.isDefaultNavTab = i(i3) ? 1 : 0;
        FrsCommonTabRequestData frsCommonTabRequestData2 = this.f66220g;
        frsCommonTabRequestData2.tabName = str;
        frsCommonTabRequestData2.isGeneralTab = i4;
        FrsCommonTabNetModel frsCommonTabNetModel = new FrsCommonTabNetModel(frsCommonTabFragment.getPageContext(), this.f66220g);
        this.f66221h = frsCommonTabNetModel;
        frsCommonTabNetModel.Z(this);
        this.f66221h.setUniqueId(frsCommonTabFragment.getUniqueId());
    }

    public void a(b2 b2Var) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, b2Var) == null) || b2Var == null || (dVar = this.f66219f) == null || dVar.f66225g == null) {
            return;
        }
        ArrayList<n> arrayList = new ArrayList<>();
        arrayList.add(b2Var);
        ArrayList<n> s = s(arrayList);
        if (ListUtils.isEmpty(this.f66219f.f66225g)) {
            this.f66219f.f66225g.addAll(s);
        } else {
            if (this.f66219f.f66225g.size() == 1 && (this.f66219f.f66225g.get(0) instanceof s)) {
                this.f66219f.f66225g.remove(0);
            }
            this.f66219f.f66225g.addAll(0, s);
        }
        this.f66218e.X0(this.f66219f);
    }

    public final void b(List<n> list) {
        JSONObject b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) || d.a.s0.n1.o.k.a.e(list)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (n nVar : list) {
            if ((nVar instanceof b2) && (b2 = d.a.s0.w2.i0.b.b(((b2) nVar).K0())) != null) {
                arrayList.add(b2);
            }
        }
        d.a.s0.w2.i0.b.f().h(this.r, arrayList);
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void c(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, mvcSocketResponsedMessage, mvcSocketMessage, mvcNetMessage) == null) || mvcSocketResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcSocketResponsedMessage.hasError()) {
            if (mvcSocketResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcSocketResponsedMessage.getData();
            } else if (mvcSocketResponsedMessage.getData() instanceof d.a.s0.u0.l1.a) {
                d.a.s0.u0.l1.a aVar = (d.a.s0.u0.l1.a) mvcSocketResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f66274e;
                dVar2.f66225g = arrayList;
                dVar2.f66223e = aVar.f66276g;
                dVar2.f66224f = aVar.f66275f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f66225g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof b2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((b2) nVar).c0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcSocketResponsedMessage.getError();
            this.q = mvcSocketResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f66218e.onServerError(errorData);
            }
        }
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int b2 = this.l ? 0 : d.a.s0.w2.a.b(this.f66219f.f66225g);
            String d2 = this.l ? "" : d.a.s0.w2.i0.b.f().d(this.r);
            d dVar = this.f66219f;
            String e2 = d.a.s0.w2.a.e(dVar == null ? null : dVar.f66225g, this.l);
            AdExtParam.a b3 = AdExtParam.a.b();
            b3.g(b2);
            b3.e(e2);
            b3.c(d2);
            b3.f(this.f66218e.j);
            return b3.a();
        }
        return (String) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.n : invokeV.intValue;
    }

    public d f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66219f : (d) invokeV.objValue;
    }

    public final void g(List<App> list, List<n> list2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, list, list2) == null) {
            b(list2);
            d.a.s0.w2.a.j(d.a.s0.w2.a.g(list, "FRS_GENERAL_TAB"), list2, 0);
            d.a.s0.w2.a.a(list2, this.n, "FRS_GENERAL_TAB");
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            d dVar = this.f66219f;
            return (dVar == null || ListUtils.isEmpty(dVar.f66225g)) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final boolean i(int i2) {
        InterceptResult invokeI;
        FrsViewData frsViewData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            FrsCommonTabFragment frsCommonTabFragment = this.f66218e;
            return (frsCommonTabFragment == null || (frsViewData = frsCommonTabFragment.f15507h) == null || frsViewData.mHeadLineDefaultNavTabId != i2) ? false : true;
        }
        return invokeI.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.l = false;
            if (!this.f66222i) {
                if (this.f66221h.Q()) {
                    return;
                }
                int i3 = this.n + 1;
                this.n = i3;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f66220g;
                frsCommonTabRequestData.pn = i3;
                frsCommonTabRequestData.sortType = i2;
                frsCommonTabRequestData.lastThreadId = -1L;
                frsCommonTabRequestData.adExtParams = d();
                this.f66221h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.j.qType = 2;
                } else {
                    this.j.qType = 1;
                }
                this.k.R();
            }
        }
    }

    public void l(String str) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || (dVar = this.f66219f) == null || d.a.s0.n1.o.k.a.e(dVar.f66225g)) {
            return;
        }
        d.a.s0.w2.a.d(str, this.f66219f.f66225g);
        this.f66218e.X0(this.f66219f);
    }

    public final boolean m(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            if (this.l) {
                this.m.clear();
                Iterator<n> it = dVar.f66225g.iterator();
                while (it.hasNext()) {
                    n next = it.next();
                    if (next instanceof b2) {
                        String n1 = ((b2) next).n1();
                        if (!this.m.contains(n1)) {
                            this.m.add(n1);
                        }
                    }
                }
                if (d.a.s0.w0.a.d()) {
                    d.a.s0.w0.a aVar = this.s;
                    if (aVar != null) {
                        aVar.b(dVar.f66225g, this.l, this.f66218e.A());
                    }
                } else {
                    g(dVar.o, dVar.f66225g);
                }
                this.f66219f = dVar;
                dVar.f66225g = s(dVar.f66225g);
            } else {
                d dVar2 = this.f66219f;
                dVar2.f66223e = dVar.f66223e;
                dVar2.f66224f.putAll(dVar.f66224f);
                ArrayList<n> arrayList = new ArrayList<>();
                Iterator<n> it2 = dVar.f66225g.iterator();
                while (it2.hasNext()) {
                    n next2 = it2.next();
                    if (next2 instanceof b2) {
                        b2 b2Var = (b2) next2;
                        String n12 = b2Var.n1();
                        if (!this.m.contains(n12)) {
                            b2Var.G1 = this.f66218e.p;
                            arrayList.add(next2);
                            this.m.add(n12);
                        }
                    }
                }
                if (d.a.s0.w0.a.d()) {
                    d.a.s0.w0.a aVar2 = this.s;
                    if (aVar2 != null) {
                        aVar2.b(arrayList, this.l, this.f66218e.A());
                    }
                } else {
                    g(dVar.o, arrayList);
                }
                this.f66219f.f66225g.addAll(s(arrayList));
            }
            this.f66218e.X0(this.f66219f);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l = true;
            if (!this.f66222i) {
                if (this.f66221h.Q()) {
                    return;
                }
                this.n = 1;
                FrsCommonTabRequestData frsCommonTabRequestData = this.f66220g;
                frsCommonTabRequestData.pn = 1;
                frsCommonTabRequestData.sortType = i2;
                long j = this.o;
                if (j >= 0) {
                    frsCommonTabRequestData.lastThreadId = j;
                }
                this.f66220g.adExtParams = d();
                this.f66221h.R();
            } else if (this.k.Q()) {
            } else {
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    this.j.qType = 2;
                } else {
                    this.j.qType = 1;
                }
                this.j.lastThreadId = 0L;
                this.k.R();
            }
        }
    }

    public void o(d.a.s0.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, aVar) == null) {
            this.s = aVar;
        }
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048591, this, mvcHttpResponsedMessage, mvcHttpMessage, mvcNetMessage) == null) || mvcHttpResponsedMessage == null) {
            return;
        }
        d dVar = null;
        if (!mvcHttpResponsedMessage.hasError()) {
            if (mvcHttpResponsedMessage.getData() instanceof d) {
                dVar = (d) mvcHttpResponsedMessage.getData();
            } else if (mvcHttpResponsedMessage.getData() instanceof d.a.s0.u0.l1.a) {
                d.a.s0.u0.l1.a aVar = (d.a.s0.u0.l1.a) mvcHttpResponsedMessage.getData();
                d dVar2 = new d();
                ArrayList<n> arrayList = aVar.f66274e;
                dVar2.f66225g = arrayList;
                dVar2.f66223e = aVar.f66276g;
                dVar2.f66224f = aVar.f66275f;
                if (!ListUtils.isEmpty(arrayList)) {
                    ArrayList<n> arrayList2 = dVar2.f66225g;
                    n nVar = (n) ListUtils.getItem(arrayList2, arrayList2.size() - 1);
                    if (nVar instanceof b2) {
                        this.j.lastThreadId = d.a.c.e.m.b.f(((b2) nVar).c0(), 0L);
                    }
                }
                dVar = dVar2;
            }
        }
        if (dVar == null || !m(dVar)) {
            this.p = mvcHttpResponsedMessage.getError();
            this.q = mvcHttpResponsedMessage.getErrorString();
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.p);
            errorData.setError_msg(this.q);
            if (this.p != 0) {
                this.f66218e.onServerError(errorData);
            }
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.o = j;
        }
    }

    public void r(int i2) {
        FrsCommonTabRequestData frsCommonTabRequestData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i2) == null) || (frsCommonTabRequestData = this.f66220g) == null) {
            return;
        }
        frsCommonTabRequestData.tabType = i2;
    }

    public final ArrayList<n> s(ArrayList<n> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
            boolean z = this.f66218e.l == 16;
            ArrayList<n> arrayList2 = new ArrayList<>();
            Iterator<n> it = arrayList.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                n next = it.next();
                if (next instanceof n0) {
                    ((n0) next).setPosition(i2);
                    arrayList2.add(next);
                } else if (next instanceof o0) {
                    ((o0) next).position = i2;
                    arrayList2.add(next);
                } else if (next instanceof b2) {
                    b2 b2Var = (b2) next;
                    d.a.r0.b.f.a.e(b2Var);
                    int[] d0 = b2Var.d0();
                    if (b2Var.getType() == b2.O2 && !b2Var.m2()) {
                        a2 a2Var = new a2();
                        a2Var.w = b2Var;
                        a2Var.position = i2;
                        a2Var.f55850e = true;
                        a2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var);
                        a2 a2Var2 = new a2();
                        a2Var2.w = b2Var;
                        a2Var2.position = i2;
                        if (b2Var.F1()) {
                            a2Var2.j = true;
                        } else if (b2Var.N2() == 1) {
                            a2Var2.f55853h = true;
                            a2Var2.x = d0[0];
                            a2Var2.y = d0[1];
                        } else if (b2Var.N2() >= 2) {
                            a2Var2.f55854i = true;
                        } else {
                            a2Var2.f55851f = true;
                        }
                        a2Var2.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var2);
                        if (b2Var.D0() != null) {
                            a2 a2Var3 = new a2();
                            a2Var3.s = true;
                            a2Var3.w = b2Var;
                            a2Var3.position = i2;
                            a2Var3.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var3);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var4 = new a2();
                            a2Var4.p = true;
                            a2Var4.w = b2Var;
                            a2Var4.position = i2;
                            a2Var4.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var4);
                        }
                        if (!ListUtils.isEmpty(b2Var.v0()) || !ListUtils.isEmpty(b2Var.Z())) {
                            a2 a2Var5 = new a2();
                            if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) == 1) {
                                a2Var5.t = true;
                            } else if (ListUtils.getCount(b2Var.v0()) + ListUtils.getCount(b2Var.Z()) > 1) {
                                a2Var5.u = true;
                            }
                            a2Var5.w = b2Var;
                            a2Var5.position = i2;
                            a2Var5.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var5);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var6 = new a2();
                            a2Var6.l = true;
                            a2Var6.w = b2Var;
                            a2Var6.position = i2;
                            a2Var6.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var6);
                        }
                        if (!z && b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var7 = new a2();
                            a2Var7.r = true;
                            a2Var7.w = b2Var;
                            a2Var7.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var7);
                        }
                        a2 a2Var8 = new a2();
                        a2Var8.k = true;
                        a2Var8.w = b2Var;
                        a2Var8.position = i2;
                        a2Var8.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var8);
                    } else if ((b2Var.getType() == b2.l3 || b2Var.getType() == b2.E3) && !b2Var.m2()) {
                        a2 a2Var9 = new a2();
                        a2Var9.w = b2Var;
                        a2Var9.position = i2;
                        a2Var9.f55850e = true;
                        a2Var9.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var9);
                        a2 a2Var10 = new a2();
                        a2Var10.w = b2Var;
                        a2Var10.position = i2;
                        if (b2Var instanceof x0) {
                            a2Var10.n = true;
                        } else {
                            a2Var10.m = true;
                        }
                        a2Var10.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var10);
                        if (b2Var.D0() != null) {
                            a2 a2Var11 = new a2();
                            a2Var11.s = true;
                            a2Var11.w = b2Var;
                            a2Var11.position = i2;
                            a2Var11.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var11);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var12 = new a2();
                            a2Var12.p = true;
                            a2Var12.w = b2Var;
                            a2Var12.position = i2;
                            a2Var12.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var12);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var13 = new a2();
                            a2Var13.l = true;
                            a2Var13.w = b2Var;
                            a2Var13.position = i2;
                            a2Var13.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var13);
                        }
                        if (!z && b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var14 = new a2();
                            a2Var14.r = true;
                            a2Var14.w = b2Var;
                            a2Var14.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var14);
                        }
                        a2 a2Var15 = new a2();
                        a2Var15.k = true;
                        a2Var15.w = b2Var;
                        a2Var15.position = i2;
                        a2Var15.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var15);
                    } else if (b2Var.l1() != null && !b2Var.W1() && b2Var.Q1()) {
                        a2 a2Var16 = new a2();
                        a2Var16.w = b2Var;
                        a2Var16.position = i2;
                        a2Var16.f55850e = true;
                        a2Var16.setSupportType(BaseCardInfo.SupportType.TOP);
                        arrayList2.add(a2Var16);
                        a2 a2Var17 = new a2();
                        a2Var17.w = b2Var;
                        a2Var17.position = i2;
                        a2Var17.o = true;
                        a2Var17.setSupportType(BaseCardInfo.SupportType.CONTENT);
                        arrayList2.add(a2Var17);
                        if (b2Var.D0() != null) {
                            a2 a2Var18 = new a2();
                            a2Var18.s = true;
                            a2Var18.w = b2Var;
                            a2Var18.position = i2;
                            a2Var18.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var18);
                        }
                        if (b2Var.Z0() != null) {
                            a2 a2Var19 = new a2();
                            a2Var19.p = true;
                            a2Var19.w = b2Var;
                            a2Var19.position = i2;
                            a2Var19.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var19);
                        }
                        if (b2Var.p1() != null) {
                            a2 a2Var20 = new a2();
                            a2Var20.l = true;
                            a2Var20.w = b2Var;
                            a2Var20.position = i2;
                            a2Var20.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var20);
                        }
                        if (!z && b2Var.n0() != null && !b2Var.t2()) {
                            a2 a2Var21 = new a2();
                            a2Var21.r = true;
                            a2Var21.w = b2Var;
                            a2Var21.setSupportType(BaseCardInfo.SupportType.EXTEND);
                            arrayList2.add(a2Var21);
                        }
                        a2 a2Var22 = new a2();
                        a2Var22.k = true;
                        a2Var22.w = b2Var;
                        a2Var22.position = i2;
                        a2Var22.setSupportType(BaseCardInfo.SupportType.BOTTOM);
                        arrayList2.add(a2Var22);
                    } else if (b2Var.getType() == b2.d3 && b2Var.E1()) {
                        b2Var.position = i2;
                        arrayList2.add(b2Var);
                    } else {
                        a2 a2Var23 = new a2();
                        a2Var23.w = b2Var;
                        a2Var23.position = i2;
                        arrayList2.add(a2Var23);
                    }
                    i2++;
                    b2Var.setSupportType(BaseCardInfo.SupportType.TOP);
                } else {
                    arrayList2.add(next);
                }
                i2++;
            }
            d.a.r0.b.f.a.d(arrayList2);
            return arrayList2;
        }
        return (ArrayList) invokeL.objValue;
    }
}
