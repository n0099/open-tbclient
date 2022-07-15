package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.el2;
import com.repackage.m53;
import com.repackage.u53;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class lr1 extends gr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ h03 b;
        public final /* synthetic */ lr1 c;

        public a(lr1 lr1Var, String str, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr1Var, str, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = lr1Var;
            this.a = str;
            this.b = h03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    if (lr1.f) {
                        Log.d("DesktopShortcutApi", "start add to desktop");
                    }
                    this.c.A(this.b.w(), this.b);
                    this.c.d(this.a, new hs1(0));
                    return;
                }
                int b = k53Var.b();
                this.c.d(this.a, new hs1(b, f53.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements u53.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(lr1 lr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.u53.f
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                lr1.C(i);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755519578, "Lcom/repackage/lr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755519578, "Lcom/repackage/lr1;");
                return;
            }
        }
        f = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lr1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void C(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            k73 k73Var = new k73();
            g03 K = g03.K();
            String appId = K.getAppId();
            String n = a73.n(K.k());
            k73Var.f = appId;
            k73Var.b = "api";
            k73Var.a = n;
            k73Var.e = "addshortcut";
            el2.a W = K.q().W();
            if (W != null) {
                k73Var.c = W.T();
            }
            k73Var.a("appid", appId);
            k73Var.a("resultstate", Integer.valueOf(i));
            q63.b(k73Var);
        }
    }

    public final void A(@NonNull Context context, @NonNull h03 h03Var) {
        el2.a Y;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, h03Var) == null) || (Y = h03Var.Y()) == null) {
            return;
        }
        u53.k(context, Y, new b(this));
    }

    public hs1 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#addToDesktop", false);
            if (f) {
                Log.d("DesktopShortcutApi", "#addToDesktop params = " + str);
            }
            Pair<hs1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((hs1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "cb is empty");
                }
                h03 b0 = h03.b0();
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    return new hs1(1001, "the context is not an activity");
                }
                b0.e0().g(context, "scope_add_to_desktop", new a(this, optString, b0));
                return hs1.f();
            }
            return (hs1) s.first;
        }
        return (hs1) invokeL.objValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "DesktopShortcutApi" : (String) invokeV.objValue;
    }
}
