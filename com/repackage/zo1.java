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
import com.repackage.qy1;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class zo1 extends yo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ny1 b;
        public final /* synthetic */ qy1 c;
        public final /* synthetic */ qy1.b d;
        public final /* synthetic */ zo1 e;

        public a(zo1 zo1Var, int i, ny1 ny1Var, qy1 qy1Var, qy1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zo1Var, Integer.valueOf(i), ny1Var, qy1Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zo1Var;
            this.a = i;
            this.b = ny1Var;
            this.c = qy1Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    rb3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zo1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        hz2 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (a0 = hz2.a0()) == null) {
            return;
        }
        a0.B().H(a0.getAppId());
    }

    public hr1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (hr1) invokeV.objValue;
    }

    public hr1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            return !hr1Var.isSuccess() ? hr1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final hr1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            ns2.b(uuid);
            qy1 V = uk2.U().V();
            if (V == null) {
                hw1.c("NavigateBackApi", "manager is null");
                return new hr1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                hw1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new hr1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            hp2 f = v53.f(uuid, i);
            ny1 m = V.m();
            if (m == null) {
                hw1.c("NavigateBackApi", "slave container is null");
                return new hr1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                hw1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new hr1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                ns2.c(i2, uuid);
                qy1.b i3 = V.i(str);
                i3.n(qy1.i, qy1.h);
                i3.h(i);
                bd3.a0(new a(this, k, m, V, i3));
                py1 o = V.o();
                hp2 l3 = o == null ? null : o.l3();
                ms2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                ns2.a(uuid, l3);
                if (!(V.m() instanceof py1)) {
                    hw1.c("NavigateBackApi", "top fragment error");
                    v53.i(f);
                    return new hr1(1001, "top fragment error");
                }
                py1 py1Var = (py1) V.m();
                return new hr1(0, q23.c(py1Var != null ? py1Var.s3() : ""));
            }
        }
        return (hr1) invokeCommon.objValue;
    }
}
