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
import com.repackage.d02;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mq1 extends lq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ a02 b;
        public final /* synthetic */ d02 c;
        public final /* synthetic */ d02.b d;
        public final /* synthetic */ mq1 e;

        public a(mq1 mq1Var, int i, a02 a02Var, d02 d02Var, d02.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mq1Var, Integer.valueOf(i), a02Var, d02Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = mq1Var;
            this.a = i;
            this.b = a02Var;
            this.c = d02Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    ed3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mq1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public us1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (us1) invokeV.objValue;
    }

    public us1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            return !us1Var.isSuccess() ? us1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final us1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            au2.b(uuid);
            d02 V = hm2.U().V();
            if (V == null) {
                ux1.c("NavigateBackApi", "manager is null");
                return new us1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                ux1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new us1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            uq2 f = i73.f(uuid, i);
            a02 m = V.m();
            if (m == null) {
                ux1.c("NavigateBackApi", "slave container is null");
                return new us1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                ux1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new us1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                au2.c(i2, uuid);
                d02.b i3 = V.i(str);
                i3.n(d02.i, d02.h);
                i3.h(i);
                oe3.a0(new a(this, k, m, V, i3));
                c02 o = V.o();
                uq2 l3 = o == null ? null : o.l3();
                zt2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                au2.a(uuid, l3);
                if (!(V.m() instanceof c02)) {
                    ux1.c("NavigateBackApi", "top fragment error");
                    i73.i(f);
                    return new us1(1001, "top fragment error");
                }
                c02 c02Var = (c02) V.m();
                return new us1(0, d43.c(c02Var != null ? c02Var.s3() : ""));
            }
        }
        return (us1) invokeCommon.objValue;
    }
}
