package d.a.s0.u0.e2;

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
import d.a.s0.u0.q;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final FrsFragment f65852a;

    /* renamed from: b  reason: collision with root package name */
    public final FrsLoadMoreModel f65853b;

    /* renamed from: c  reason: collision with root package name */
    public final FrsSmartLoadMoreModel f65854c;

    /* renamed from: d  reason: collision with root package name */
    public final FrsModelController f65855d;

    /* renamed from: e  reason: collision with root package name */
    public final q f65856e;

    /* renamed from: f  reason: collision with root package name */
    public final b f65857f;

    /* loaded from: classes9.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f65858a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65858a = cVar;
        }

        @Override // d.a.s0.u0.e2.c.b
        public void removeItem(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f65858a.f65856e == null || this.f65858a.f65856e.a0() == null) {
                return;
            }
            List<d.a.c.k.e.n> data = this.f65858a.f65856e.a0().getData();
            if (ListUtils.isEmpty(data) || this.f65858a.f65856e.a0().getAdapter() == null || ((d.a.c.k.e.n) ListUtils.remove(data, i2)) == null) {
                return;
            }
            this.f65858a.f65856e.a0().getAdapter().notifyItemRemoved(i2);
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void removeItem(int i2);
    }

    public c(FrsFragment frsFragment, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65857f = new a(this);
        if (frsFragment != null) {
            this.f65852a = frsFragment;
            this.f65853b = new FrsLoadMoreModel(frsFragment, kVar);
            FrsSmartLoadMoreModel frsSmartLoadMoreModel = new FrsSmartLoadMoreModel(frsFragment, kVar);
            this.f65854c = frsSmartLoadMoreModel;
            frsSmartLoadMoreModel.M(this.f65857f);
            this.f65853b.R(this.f65857f);
            this.f65856e = frsFragment.B0();
            FrsModelController d0 = frsFragment.d0();
            this.f65855d = d0;
            this.f65854c.setSortType(d0.a0());
            this.f65853b.setSortType(this.f65855d.a0());
            return;
        }
        throw new NullPointerException("FrsFragment is NullPointerException");
    }

    public boolean b(List<Long> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
            FrsModelController frsModelController = this.f65855d;
            if (frsModelController == null || frsModelController.u0()) {
                return false;
            }
            return this.f65853b.A(list);
        }
        return invokeL.booleanValue;
    }

    public ArrayList<d.a.c.k.e.n> c(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.s0.h3.h0.f fVar, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3)})) == null) ? d(z, z2, arrayList, fVar, false, z3) : (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<d.a.c.k.e.n> d(boolean z, boolean z2, ArrayList<d.a.c.k.e.n> arrayList, d.a.s0.h3.h0.f fVar, boolean z3, boolean z4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), arrayList, fVar, Boolean.valueOf(z3), Boolean.valueOf(z4)})) == null) {
            if (this.f65855d == null) {
                return arrayList;
            }
            boolean t0 = this.f65852a.d0().t0();
            if (this.f65855d.u0()) {
                return this.f65854c.y(z, t0, arrayList, z3, z4);
            }
            return this.f65853b.C(z, t0, z2, arrayList, fVar);
        }
        return (ArrayList) invokeCommon.objValue;
    }

    public ArrayList<d.a.c.k.e.n> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f65855d.u0()) {
                return this.f65854c.z();
            }
            return this.f65855d.W();
        }
        return (ArrayList) invokeV.objValue;
    }

    public FrsSmartLoadMoreModel f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f65854c : (FrsSmartLoadMoreModel) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            FrsModelController frsModelController = this.f65855d;
            if (frsModelController == null) {
                return 1;
            }
            if (frsModelController.u0()) {
                return this.f65854c.getPn();
            }
            return this.f65853b.getPn();
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            FrsModelController frsModelController = this.f65855d;
            if (frsModelController == null) {
                return -1;
            }
            if (frsModelController.u0()) {
                return this.f65854c.A();
            }
            return this.f65853b.E();
        }
        return invokeV.intValue;
    }

    public void i(String str, String str2, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, str, str2, frsViewData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921462, 0));
            if (this.f65855d == null || this.f65856e == null || frsViewData == null) {
                return;
            }
            this.f65852a.M = System.currentTimeMillis();
            if (this.f65855d.u0()) {
                if (this.f65854c.A() != 1 || this.f65855d.s0()) {
                    return;
                }
                this.f65854c.setSortType(this.f65855d.a0());
                this.f65854c.x();
                int pn = this.f65854c.getPn();
                this.f65854c.setPn(pn);
                this.f65855d.x0(pn + 1);
            } else if (this.f65855d.b0() == 1) {
                if (this.f65853b.isLoading || this.f65855d.s0()) {
                    return;
                }
                int pn2 = this.f65853b.getPn();
                if (this.f65853b.A(frsViewData.getThreadListIds())) {
                    this.f65853b.B();
                    this.f65853b.setSortType(this.f65855d.a0());
                    this.f65853b.M(d.a.c.e.m.b.f(str2, 0L), frsViewData.getThreadListIds(), str, pn2, frsViewData.isBrandForum, this.f65855d.d0() != null ? d.a.s0.w2.a.e(this.f65855d.d0().getThreadList(), false) : "");
                } else if (this.f65853b.E() == 1) {
                    this.f65853b.B();
                    this.f65853b.setPn(pn2);
                    this.f65855d.x0(pn2 + 1);
                    FrsLoadMoreModel frsLoadMoreModel = this.f65853b;
                    frsLoadMoreModel.loadingDone = false;
                    frsLoadMoreModel.loadIndex = 0;
                }
            } else if (this.f65855d.v0()) {
            } else {
                this.f65855d.w0();
            }
        }
    }

    public void j(d.a.c.k.e.n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nVar) == null) || nVar == null) {
            return;
        }
        if (this.f65855d.u0()) {
            this.f65854c.G(nVar);
        } else {
            this.f65853b.K(nVar);
        }
    }

    public void k() {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (frsModelController = this.f65855d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f65854c.H();
        } else {
            this.f65853b.N();
        }
    }

    public void l(d.a.s0.w0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.f65853b.O(aVar);
            this.f65854c.K(aVar);
        }
    }

    public void m(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048587, this, i2) == null) || (frsModelController = this.f65855d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f65854c.L(i2);
        } else {
            this.f65853b.Q(i2);
        }
    }

    public void n(int i2) {
        FrsModelController frsModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048588, this, i2) == null) || (frsModelController = this.f65855d) == null) {
            return;
        }
        if (frsModelController.u0()) {
            this.f65854c.setPn(i2);
        } else {
            this.f65853b.setPn(i2);
        }
    }
}
