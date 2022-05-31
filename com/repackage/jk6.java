package com.repackage;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.loadmore.FrsLoadMoreModel;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.smartsort.FrsSmartLoadMoreModel;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.AdMixFloor;
/* loaded from: classes6.dex */
public class jk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final lb6 e;
    public final b f;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jk6 a;

        public a(jk6 jk6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jk6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jk6Var;
        }

        @Override // com.repackage.jk6.b
        public void removeItem(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.e == null || this.a.e.c0() == null) {
                return;
            }
            List<jn> data = this.a.e.c0().getData();
            if (ListUtils.isEmpty(data) || this.a.e.c0().getAdapter() == null || ((jn) ListUtils.remove(data, i)) == null) {
                return;
            }
            this.a.e.c0().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void removeItem(int i);
    }

    public jk6(FrsFragment frsFragment, rk6 rk6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, rk6Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this);
        if (frsFragment != null) {
            this.a = frsFragment;
            this.b = new FrsLoadMoreModel(frsFragment, rk6Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, rk6Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.O(this.f);
            this.b.U(this.f);
            this.e = frsFragment.y0();
            FrsModelController c0 = frsFragment.c0();
            this.d = c0;
            this.c.setSortType(c0.c0());
            this.b.setSortType(this.d.c0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.v0()) {
                return false;
            }
            return this.b.C(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<jn> c(boolean z, boolean z2, ArrayList<jn> arrayList, rg8 rg8Var, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, rg8Var, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) ? d(z, z2, arrayList, rg8Var, false, z3, i, list) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<jn> d(boolean z, boolean z2, ArrayList<jn> arrayList, rg8 rg8Var, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, rg8Var, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean u0 = this.a.c0().u0();
            if (this.d.v0()) {
                return this.c.A(z, u0, arrayList, z3, z4, i, list);
            }
            return this.b.F(z, u0, z2, arrayList, rg8Var, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<jn> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.v0()) {
                return this.c.B();
            }
            return this.d.Y();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.v0()) {
                return this.c.getPn();
            }
            return this.b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.v0()) {
                return this.c.C();
            }
            return this.b.H();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.d == null || this.e == null || frsViewData == null) {
                return;
            }
            this.a.I = System.currentTimeMillis();
            if (this.d.v0()) {
                if (this.c.C() != 1 || this.d.t0()) {
                    return;
                }
                this.c.setSortType(this.d.c0());
                this.c.z();
                int pn = this.c.getPn();
                this.c.setPn(pn);
                this.d.y0(pn + 1);
            } else if (this.d.d0() == 1) {
                if (this.b.isLoading || this.d.t0()) {
                    return;
                }
                int pn2 = this.b.getPn();
                if (this.b.C(frsViewData.getThreadListIds())) {
                    this.b.D();
                    this.b.setSortType(this.d.c0());
                    this.b.Q(jg.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.d.f0() != null ? u68.e(this.d.f0().getThreadList(), false) : "");
                } else if (this.b.H() == 1) {
                    this.b.D();
                    this.b.setPn(pn2);
                    this.d.y0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.d.w0()) {
            } else {
                this.d.x0();
            }
        }
    }

    public void j(jn jnVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jnVar) == null) || jnVar == null) {
            return;
        }
        if (this.d.v0()) {
            this.c.I(jnVar);
        } else {
            this.b.N(jnVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.v0()) {
                this.c.J(str);
            } else {
                this.b.O(str);
            }
        }
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.c.K();
        } else {
            this.b.R();
        }
    }

    public void m(rp6 rp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, rp6Var) == null) {
            this.b.S(rp6Var);
            this.c.N(rp6Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.c.setHasMore(i);
        } else {
            this.b.setHasMore(i);
        }
    }

    public void o(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.v0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }
}
