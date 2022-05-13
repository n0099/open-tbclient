package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h63;
import com.repackage.rl2;
import com.repackage.z53;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yr1 extends tr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ u03 b;
        public final /* synthetic */ yr1 c;

        public a(yr1 yr1Var, String str, u03 u03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var, str, u03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yr1Var;
            this.a = str;
            this.b = u03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    if (yr1.f) {
                        Log.d("DesktopShortcutApi", "start add to desktop");
                    }
                    this.c.A(this.b.x(), this.b);
                    this.c.d(this.a, new us1(0));
                    return;
                }
                int b = x53Var.b();
                this.c.d(this.a, new us1(b, s53.f(b)));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements h63.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(yr1 yr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.h63.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                yr1.C(i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755132295, "Lcom/repackage/yr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755132295, "Lcom/repackage/yr1;");
                return;
            }
        }
        f = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yr1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            x73 x73Var = new x73();
            t03 J = t03.J();
            String appId = J.getAppId();
            String n = n73.n(J.l());
            x73Var.f = appId;
            x73Var.b = RetrieveTaskManager.KEY;
            x73Var.a = n;
            x73Var.e = "addshortcut";
            rl2.a V = J.r().V();
            if (V != null) {
                x73Var.c = V.T();
            }
            x73Var.a("appid", appId);
            x73Var.a("resultstate", Integer.valueOf(i));
            d73.b(x73Var);
        }
    }

    public final void A(@NonNull Context context, @NonNull u03 u03Var) {
        rl2.a X;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, u03Var) == null) || (X = u03Var.X()) == null) {
            return;
        }
        h63.k(context, X, new b(this));
    }

    public us1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<us1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((us1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "cb is empty");
                }
                u03 a0 = u03.a0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = a0.x()) == null) {
                    return new us1(1001, "the context is not an activity");
                }
                a0.d0().g(context, "scope_add_to_desktop", new a(this, optString, a0));
                return us1.f();
            }
            return (us1) s.first;
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }
}
