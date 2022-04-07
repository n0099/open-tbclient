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
import com.repackage.sz1;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bq1 extends aq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ pz1 b;
        public final /* synthetic */ sz1 c;
        public final /* synthetic */ sz1.b d;
        public final /* synthetic */ bq1 e;

        public a(bq1 bq1Var, int i, pz1 pz1Var, sz1 sz1Var, sz1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bq1Var, Integer.valueOf(i), pz1Var, sz1Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = bq1Var;
            this.a = i;
            this.b = pz1Var;
            this.c = sz1Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    tc3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        j03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = j03.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public js1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (js1) invokeV.objValue;
    }

    public js1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            return !js1Var.isSuccess() ? js1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final js1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            pt2.b(uuid);
            sz1 V = wl2.U().V();
            if (V == null) {
                jx1.c("NavigateBackApi", "manager is null");
                return new js1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                jx1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new js1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            jq2 f = x63.f(uuid, i);
            pz1 m = V.m();
            if (m == null) {
                jx1.c("NavigateBackApi", "slave container is null");
                return new js1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                jx1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new js1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                pt2.c(i2, uuid);
                sz1.b i3 = V.i(str);
                i3.n(sz1.i, sz1.h);
                i3.h(i);
                de3.a0(new a(this, k, m, V, i3));
                rz1 o = V.o();
                jq2 l3 = o == null ? null : o.l3();
                ot2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                pt2.a(uuid, l3);
                if (!(V.m() instanceof rz1)) {
                    jx1.c("NavigateBackApi", "top fragment error");
                    x63.i(f);
                    return new js1(1001, "top fragment error");
                }
                rz1 rz1Var = (rz1) V.m();
                return new js1(0, s33.c(rz1Var != null ? rz1Var.s3() : ""));
            }
        }
        return (js1) invokeCommon.objValue;
    }
}
