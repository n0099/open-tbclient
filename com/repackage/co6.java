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
public class co6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FrsFragment a;
    public final FrsLoadMoreModel b;
    public final FrsSmartLoadMoreModel c;
    public final FrsModelController d;
    public final af6 e;
    public final b f;

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ co6 a;

        public a(co6 co6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {co6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = co6Var;
        }

        @Override // com.repackage.co6.b
        public void removeItem(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.e == null || this.a.e.d0() == null) {
                return;
            }
            List<on> data = this.a.e.d0().getData();
            if (ListUtils.isEmpty(data) || this.a.e.d0().getAdapter() == null || ((on) ListUtils.remove(data, i)) == null) {
                return;
            }
            this.a.e.d0().getAdapter().notifyItemRemoved(i);
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void removeItem(int i);
    }

    public co6(FrsFragment frsFragment, ko6 ko6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, ko6Var};
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
            this.b = new FrsLoadMoreModel(frsFragment, ko6Var);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, ko6Var);
            this.c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.P(this.f);
            this.b.V(this.f);
            this.e = frsFragment.k1();
            FrsModelController K0 = frsFragment.K0();
            this.d = K0;
            this.c.setSortType(K0.d0());
            this.b.setSortType(this.d.d0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.d;
            if (frsModelController == null || frsModelController.w0()) {
                return false;
            }
            return this.b.D(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<on> c(boolean z, boolean z2, ArrayList<on> arrayList, sk8 sk8Var, boolean z3, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, sk8Var, Boolean.valueOf(z3), Integer.valueOf(i), list})) == null) ? d(z, z2, arrayList, sk8Var, false, z3, i, list) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<on> d(boolean z, boolean z2, ArrayList<on> arrayList, sk8 sk8Var, boolean z3, boolean z4, int i, List<AdMixFloor> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, sk8Var, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i), list})) == null) {
            if (this.d == null) {
                return arrayList;
            }
            boolean v0 = this.a.K0().v0();
            if (this.d.w0()) {
                return this.c.B(z, v0, arrayList, z3, z4, i, list);
            }
            return this.b.G(z, v0, z2, arrayList, sk8Var, list, i);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<on> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.d.w0()) {
                return this.c.C();
            }
            return this.d.Z();
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
            if (frsModelController.w0()) {
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
            if (frsModelController.w0()) {
                return this.c.D();
            }
            return this.b.I();
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
            if (this.d.w0()) {
                if (this.c.D() != 1 || this.d.u0()) {
                    return;
                }
                this.c.setSortType(this.d.d0());
                this.c.A();
                int pn = this.c.getPn();
                this.c.setPn(pn);
                this.d.z0(pn + 1);
            } else if (this.d.e0() == 1) {
                if (this.b.isLoading || this.d.u0()) {
                    return;
                }
                int pn2 = this.b.getPn();
                if (this.b.D(frsViewData.getThreadListIds())) {
                    this.b.E();
                    this.b.setSortType(this.d.d0());
                    this.b.R(og.g(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.d.g0() != null ? cb8.e(this.d.g0().getThreadList(), false) : "");
                } else if (this.b.I() == 1) {
                    this.b.E();
                    this.b.setPn(pn2);
                    this.d.z0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.d.x0()) {
            } else {
                this.d.y0();
            }
        }
    }

    public void j(on onVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onVar) == null) || onVar == null) {
            return;
        }
        if (this.d.w0()) {
            this.c.J(onVar);
        } else {
            this.b.O(onVar);
        }
    }

    public void k(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (this.d.w0()) {
                this.c.K(str);
            } else {
                this.b.P(str);
            }
        }
    }

    public void l() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.w0()) {
            this.c.L();
        } else {
            this.b.S();
        }
    }

    public void m(ys6 ys6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ys6Var) == null) {
            this.b.T(ys6Var);
            this.c.O(ys6Var);
        }
    }

    public void n(int i) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i) == null) || (frsModelController = this.d) == null) {
            return;
        }
        if (frsModelController.w0()) {
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
        if (frsModelController.w0()) {
            this.c.setPn(i);
        } else {
            this.b.setPn(i);
        }
    }
}
