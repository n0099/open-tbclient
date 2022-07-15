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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dp1 extends ap1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ dp1 d;

        public a(dp1 dp1Var, nz1 nz1Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp1Var, nz1Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dp1Var;
            this.a = nz1Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz1 nz1Var = this.a;
                boolean z = true;
                if (!((nz1Var == null || !nz1Var.w2(this.b, true)) ? false : false)) {
                    hx1.c("NavigationBarApi", "set title fail");
                    this.d.d(this.c, new hs1(1001));
                }
                this.d.d(this.c, new hs1(0));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ dp1 f;

        public b(dp1 dp1Var, nz1 nz1Var, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp1Var, nz1Var, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = dp1Var;
            this.a = nz1Var;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz1 nz1Var = this.a;
                if (nz1Var != null && nz1Var.E2(this.b, true)) {
                    if (!this.a.u2(SwanAppConfigData.t(this.d), true)) {
                        hx1.c("NavigationBarApi", "set title background fail");
                        this.f.d(this.c, new hs1(1001));
                        return;
                    }
                    JSONObject jSONObject = this.e;
                    if (jSONObject != null) {
                        this.a.s2(jSONObject.optInt("duration"), this.e.optString("timingFunc"));
                        hx1.i("NavigationBarApi", "set action bar animator");
                    }
                    this.f.d(this.c, new hs1(0));
                    return;
                }
                hx1.c("NavigationBarApi", "set title color fail");
                this.f.d(this.c, new hs1(1001));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz1 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ dp1 d;

        public c(dp1 dp1Var, nz1 nz1Var, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp1Var, nz1Var, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dp1Var;
            this.a = nz1Var;
            this.b = str;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean S1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nz1 nz1Var = this.a;
                if (nz1Var == null) {
                    hx1.c("NavigationBarApi", "swanAppFragment is null");
                    this.d.d(this.b, new hs1(1001));
                    return;
                }
                if (this.c) {
                    S1 = nz1Var.N2();
                } else {
                    S1 = nz1Var.S1();
                }
                if (!S1) {
                    String str = this.c ? "show" : "hide";
                    hx1.c("NavigationBarApi", str + " navigation loading progressbar fail");
                    this.d.d(this.b, new hs1(1001));
                    return;
                }
                this.d.d(this.b, new hs1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp1(@NonNull io1 io1Var) {
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

    public hs1 A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#setNavigationBarTitle", false);
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (jSONObject == null) {
                    return new hs1(1001);
                }
                String optString = jSONObject.optString("title");
                qz1 V = ul2.U().V();
                if (V == null) {
                    hx1.c("NavigationBarApi", "manager is null");
                    return new hs1(1001);
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    p("cb is empty", null, true);
                    return new hs1(1001, "cb is empty");
                }
                be3.e0(new a(this, V.m(), optString, optString2));
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#showNavigationBarLoading", false);
            h03 b0 = h03.b0();
            if (b0 != null && b0.n0()) {
                return new hs1(1001, "ui operation does not supported when app is invisible.");
            }
            return x(str, true);
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "NavigationBarApi" : (String) invokeV.objValue;
    }

    public final hs1 x(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            qz1 V = ul2.U().V();
            if (V == null) {
                hx1.c("NavigationBarApi", "manager is null");
                return new hs1(1001);
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new hs1(1001, "cb is empty");
                }
                be3.e0(new c(this, V.m(), optString, z));
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeLZ.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#hideNavigationBarLoading", false);
            return x(str, false);
        }
        return (hs1) invokeL.objValue;
    }

    public hs1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#setNavigationBarColor", false);
            qz1 V = ul2.U().V();
            if (V == null) {
                hx1.c("NavigationBarApi", "manager is null");
                return new hs1(1001);
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    p("cb is empty", null, true);
                    return new hs1(1001, "cb is empty");
                }
                be3.e0(new b(this, V.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString(TtmlNode.ATTR_TTS_BACKGROUND_COLOR), jSONObject.optJSONObject("animation")));
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }
}
