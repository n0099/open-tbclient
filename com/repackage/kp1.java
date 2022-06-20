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
import com.repackage.bz1;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kp1 extends jp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ yy1 b;
        public final /* synthetic */ bz1 c;
        public final /* synthetic */ bz1.b d;
        public final /* synthetic */ kp1 e;

        public a(kp1 kp1Var, int i, yy1 yy1Var, bz1 bz1Var, bz1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kp1Var, Integer.valueOf(i), yy1Var, bz1Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = kp1Var;
            this.a = i;
            this.b = yy1Var;
            this.c = bz1Var;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a > 1 && !this.b.D0) {
                    cc3.b(this.c, this.e.getContext(), 1);
                }
                this.d.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kp1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static void y() {
        sz2 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || (b0 = sz2.b0()) == null) {
            return;
        }
        b0.B().I(b0.getAppId());
    }

    public sr1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#hideModalPage", false);
            y();
            return z(1, "hideModalPage", 10);
        }
        return (sr1) invokeV.objValue;
    }

    public sr1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#navigateBack params=" + str, false);
            y();
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            return !sr1Var.isSuccess() ? sr1Var : z(((JSONObject) s.second).optInt("delta", 1), "navigateBack", 1);
        }
        return (sr1) invokeL.objValue;
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigateBackApi" : (String) invokeV.objValue;
    }

    public final sr1 z(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String uuid = UUID.randomUUID().toString();
            ys2.b(uuid);
            bz1 V = fl2.U().V();
            if (V == null) {
                sw1.c("NavigateBackApi", "manager is null");
                return new sr1(1001, "manager is null");
            }
            int k = V.k();
            if (k == 1) {
                sw1.c("NavigateBackApi", "navigateBack api can only work when slave's count greater than 1");
                return new sr1(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (i >= k) {
                i = k - 1;
            }
            sp2 f = g63.f(uuid, i);
            yy1 m = V.m();
            if (m == null) {
                sw1.c("NavigateBackApi", "slave container is null");
                return new sr1(1001, "slave container is null");
            } else if (TextUtils.equals("hideModalPage", str) && !m.D0) {
                sw1.c("NavigateBackApi", "hideModalPage api can only work after showModalPage");
                return new sr1(1001, "hideModalPage api can only work after showModalPage");
            } else {
                ys2.c(i2, uuid);
                bz1.b i3 = V.i(str);
                i3.n(bz1.i, bz1.h);
                i3.h(i);
                md3.a0(new a(this, k, m, V, i3));
                az1 o = V.o();
                sp2 m3 = o == null ? null : o.m3();
                xs2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
                ys2.a(uuid, m3);
                if (!(V.m() instanceof az1)) {
                    sw1.c("NavigateBackApi", "top fragment error");
                    g63.i(f);
                    return new sr1(1001, "top fragment error");
                }
                az1 az1Var = (az1) V.m();
                return new sr1(0, b33.c(az1Var != null ? az1Var.t3() : ""));
            }
        }
        return (sr1) invokeCommon.objValue;
    }
}
