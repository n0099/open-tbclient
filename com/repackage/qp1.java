package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qp1 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ qp1 d;

        public a(qp1 qp1Var, a02 a02Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp1Var, a02Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qp1Var;
            this.a = a02Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a02 a02Var = this.a;
                boolean z = true;
                if (!((a02Var == null || !a02Var.v2(this.b, true)) ? false : false)) {
                    ux1.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new us1(1001));
                }
                this.d.d(this.c, new us1(0));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ qp1 f;

        public b(qp1 qp1Var, a02 a02Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp1Var, a02Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = qp1Var;
            this.a = a02Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a02 a02Var = this.a;
                if (a02Var != null && a02Var.D2(this.b, true)) {
                    if (!this.a.t2(SwanAppConfigData.t(this.d), true)) {
                        ux1.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new us1(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.r2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        ux1.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new us1(0));
                    return;
                }
                ux1.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new us1(1001));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a02 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ qp1 d;

        public c(qp1 qp1Var, a02 a02Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qp1Var, a02Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = qp1Var;
            this.a = a02Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean R1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a02 a02Var = this.a;
                if (a02Var == null) {
                    ux1.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new us1(1001));
                    return;
                }
                if (this.c) {
                    R1 = a02Var.M2();
                } else {
                    R1 = a02Var.R1();
                }
                if (!R1) {
                    String str = this.c ? "show" : "hide";
                    ux1.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new us1(1001));
                    return;
                }
                this.d.d(this.b, new us1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qp1(@NonNull vo1 vo1Var) {
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

    public us1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new us1(1001);
                }
                String optString = jSONObject.optString("title");
                d02 V = hm2.U().V();
                if (V == null) {
                    ux1.c("NavigationBarApi", "manager is null");
                    return new us1(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new us1(1001, "cb is empty");
                }
                oe3.e0(new a(this, V.m(), optString, optString2));
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    public us1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            u03 a0 = u03.a0();
            if (a0 != null && a0.m0()) {
                return new us1(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final us1 x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            d02 V = hm2.U().V();
            if (V == null) {
                ux1.c("NavigationBarApi", "manager is null");
                return new us1(1001);
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new us1(1001, "cb is empty");
                }
                oe3.e0(new c(this, V.m(), optString, z));
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeLZ.objValue;
    }

    public us1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (us1) invokeL.objValue;
    }

    public us1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            d02 V = hm2.U().V();
            if (V == null) {
                ux1.c("NavigationBarApi", "manager is null");
                return new us1(1001);
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new us1(1001, "cb is empty");
                }
                oe3.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }
}
