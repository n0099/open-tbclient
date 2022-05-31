package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.view.SwanAppWebPopWindow;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jo1 extends ao1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppWebPopWindow f;
    public wy1 g;
    public ny1 h;

    /* loaded from: classes6.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ jo1 d;

        public a(jo1 jo1Var, String str, hz2 hz2Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo1Var, str, hz2Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jo1Var;
            this.a = str;
            this.b = hz2Var;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.d.I(this.b, this.c, this.a);
                } else {
                    this.d.d(this.a, new hr1(10005, "system deny"));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ hz2 b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ jo1 e;

        /* loaded from: classes6.dex */
        public class a extends wy1 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // com.repackage.wy1, com.repackage.xy1
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    super.b();
                    hw1.i("WebPopWindowApi", "swanId=" + this.a.b.b + ", nowId=" + hz2.f0());
                    if (TextUtils.equals(this.a.b.b, hz2.f0())) {
                        return;
                    }
                    this.a.e.H();
                }
            }

            @Override // com.repackage.wy1, com.repackage.xy1
            public void c() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    hw1.i("WebPopWindowApi", "call onFragmentDestroyed");
                    this.a.e.H();
                    if (this.a.e.h == null || this.a.e.g == null) {
                        return;
                    }
                    this.a.e.h.Q2(this.a.e.g);
                }
            }
        }

        public b(jo1 jo1Var, String str, hz2 hz2Var, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jo1Var, str, hz2Var, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jo1Var;
            this.a = str;
            this.b = hz2Var;
            this.c = str2;
            this.d = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            SwanAppActivity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (activity = uk2.U().getActivity()) == null) {
                return;
            }
            if (this.e.f != null && this.e.f.y()) {
                this.e.d(this.a, new hr1(303, "execute failed, halfScreenWebview is showing"));
                return;
            }
            qy1 V = uk2.U().V();
            if (V == null) {
                return;
            }
            this.e.h = V.m();
            if (this.e.h == null) {
                return;
            }
            if (this.e.g != null) {
                this.e.h.Q2(this.e.g);
            }
            this.e.g = new a(this);
            this.e.h.m2(this.e.g);
            jo1 jo1Var = this.e;
            SwanAppWebPopWindow swanAppWebPopWindow = new SwanAppWebPopWindow(activity, this.c);
            swanAppWebPopWindow.r0(R.string.obfuscated_res_0x7f0f123b);
            jo1Var.f = swanAppWebPopWindow;
            if (TextUtils.equals(this.d, "protect")) {
                SwanAppWebPopWindow swanAppWebPopWindow2 = this.e.f;
                swanAppWebPopWindow2.n0(SwanAppWebPopWindow.CloseStyle.CLOSE_AT_BOTTOM);
                swanAppWebPopWindow2.o0();
            }
            SwanAppWebPopWindow swanAppWebPopWindow3 = this.e.f;
            swanAppWebPopWindow3.m0();
            swanAppWebPopWindow3.t0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 0);
            } catch (JSONException e) {
                if (jo1.i) {
                    e.printStackTrace();
                }
            }
            this.e.d(this.a, new hr1(0, "show halfScreenWebview success", jSONObject));
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755582043, "Lcom/repackage/jo1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755582043, "Lcom/repackage/jo1;");
                return;
            }
        }
        i = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void G(hz2 hz2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, hz2Var, str, str2) == null) {
            if (TextUtils.equals(str, "protect")) {
                hz2Var.d0().g(getContext(), "scope_web_window_pay_protected", new a(this, str2, hz2Var, str));
            } else {
                d(str2, new hr1(202, "type is invalid"));
            }
        }
    }

    public final void H() {
        SwanAppWebPopWindow swanAppWebPopWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.h.Q() && (swanAppWebPopWindow = this.f) != null) {
            swanAppWebPopWindow.s();
        }
    }

    public final void I(hz2 hz2Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, hz2Var, str, str2) == null) {
            String J = J(hz2Var, str);
            if (J == null) {
                d(str2, new hr1(202, "type is invalid"));
            } else {
                bd3.e0(new b(this, str2, hz2Var, J, str));
            }
        }
    }

    public final String J(hz2 hz2Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hz2Var, str)) == null) {
            if (!TextUtils.equals(str, "protect") || hz2Var == null) {
                return null;
            }
            return "https://baozhang.baidu.com/guarantee/baoshowdetail?appkey=" + hz2Var.N();
        }
        return (String) invokeLL.objValue;
    }

    public hr1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#showHalfScreenWebview", false);
            if (i) {
                Log.d("WebPopWindowApi", "#showHalfScreenWebview params=" + str);
            }
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new hr1(202, "swan app is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((hr1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("type");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "type is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "cb is invalid");
                }
                G(a0, optString, optString2);
                return hr1.f();
            }
            return new hr1(202);
        }
        return (hr1) invokeL.objValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "WebPopWindowApi" : (String) invokeV.objValue;
    }
}
