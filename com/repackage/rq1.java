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
import com.repackage.i02;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rq1 extends qq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ f02 b;
        public final /* synthetic */ i02 c;
        public final /* synthetic */ i02.b d;
        public final /* synthetic */ rq1 e;

        public a(rq1 rq1Var, int i, f02 f02Var, i02 i02Var, i02.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rq1Var, Integer.valueOf(i), f02Var, i02Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = rq1Var;
            this.a = i;
            this.b = f02Var;
            this.c = i02Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    jd3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rq1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        z03 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (b0 = z03.b0()) == null) {
            return;
        }
        b0.B().I(b0.getAppId());
    }

    public zs1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (zs1) invokeV.objValue;
    }

    public zs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            return !zs1Var.isSuccess() ? zs1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (zs1) invokeL.objValue;
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final zs1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            fu2.b(uuid);
            i02 V = mm2.U().V();
            if (V == null) {
                zx1.c("NavigateBackApi", "manager is null");
                return new zs1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                zx1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new zs1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            zq2 f = n73.f(uuid, i);
            f02 m = V.m();
            if (m == null) {
                zx1.c("NavigateBackApi", "slave container is null");
                return new zs1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                zx1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new zs1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                fu2.c(i2, uuid);
                i02.b i3 = V.i(str);
                i3.n(i02.i, i02.h);
                i3.h(i);
                te3.a0(new a(this, k, m, V, i3));
                h02 o = V.o();
                zq2 m3 = o == null ? null : o.m3();
                eu2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                fu2.a(uuid, m3);
                if (!(V.m() instanceof h02)) {
                    zx1.c("NavigateBackApi", "top fragment error");
                    n73.i(f);
                    return new zs1(1001, "top fragment error");
                }
                h02 h02Var = (h02) V.m();
                return new zs1(0, i43.c(h02Var != null ? h02Var.t3() : ""));
            }
        }
        return (zs1) invokeCommon.objValue;
    }
}
