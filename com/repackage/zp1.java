package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qz1;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zp1 extends yp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ nz1 b;
        public final /* synthetic */ qz1 c;
        public final /* synthetic */ qz1.b d;
        public final /* synthetic */ zp1 e;

        public a(zp1 zp1Var, int i, nz1 nz1Var, qz1 qz1Var, qz1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zp1Var, Integer.valueOf(i), nz1Var, qz1Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zp1Var;
            this.a = i;
            this.b = nz1Var;
            this.c = qz1Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    rc3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zp1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        h03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (b0 = h03.b0()) == null) {
            return;
        }
        b0.B().I(b0.getAppId());
    }

    public hs1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            return !hs1Var.isSuccess() ? hs1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final hs1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            nt2.b(uuid);
            qz1 V = ul2.U().V();
            if (V == null) {
                hx1.c("NavigateBackApi", "manager is null");
                return new hs1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                hx1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new hs1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            hq2 f = v63.f(uuid, i);
            nz1 m = V.m();
            if (m == null) {
                hx1.c("NavigateBackApi", "slave container is null");
                return new hs1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                hx1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new hs1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                nt2.c(i2, uuid);
                qz1.b i3 = V.i(str);
                i3.n(qz1.i, qz1.h);
                i3.h(i);
                be3.a0(new a(this, k, m, V, i3));
                pz1 o = V.o();
                hq2 m3 = o == null ? null : o.m3();
                mt2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                nt2.a(uuid, m3);
                if (!(V.m() instanceof pz1)) {
                    hx1.c("NavigateBackApi", "top fragment error");
                    v63.i(f);
                    return new hs1(1001, "top fragment error");
                }
                pz1 pz1Var = (pz1) V.m();
                return new hs1(0, q33.c(pz1Var != null ? pz1Var.t3() : ""));
            }
        }
        return (hs1) invokeCommon.objValue;
    }
}
