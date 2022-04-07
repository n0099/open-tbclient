package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jp1 extends cp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ jp1 d;

        public a(jp1 jp1Var, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jp1Var, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = jp1Var;
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                vb3 z = jp1.z();
                if (z == null) {
                    jx1.c("TabBarApi", "tabBarViewController is null");
                    this.d.d(this.a, new js1(1001));
                    return;
                }
                if (this.b) {
                    j = z.r(this.c);
                } else {
                    j = z.j(this.c);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.b ? "open" : "close");
                    sb.append("bottom bar fail");
                    jx1.c("TabBarApi", sb.toString());
                    this.d.d(this.a, new js1(1001));
                }
                this.d.d(this.a, new js1(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp1(@NonNull ko1 ko1Var) {
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

    public static boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            sz1 V = wl2.U().V();
            return V == null || V.o() == null || !V.o().d2();
        }
        return invokeV.booleanValue;
    }

    public static vb3 z() {
        InterceptResult invokeV;
        rz1 l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            sz1 V = wl2.U().V();
            if (V == null || (l = V.l()) == null) {
                return null;
            }
            return l.u3();
        }
        return (vb3) invokeV.objValue;
    }

    public final js1 A(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            if (B()) {
                jx1.c("TabBarApi", "fail not TabBar page");
                return new js1(1001, "fail not TabBar page");
            }
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    jx1.c("TabBarApi", "callback is null");
                    return new js1(1001, "callback is null");
                }
                de3.e0(new a(this, optString, z, jSONObject.optBoolean("animation")));
                return js1.f();
            }
            return js1Var;
        }
        return (js1) invokeLZ.objValue;
    }

    public js1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#openTabBar", false);
            return A(str, true);
        }
        return (js1) invokeL.objValue;
    }

    public js1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#setTabBarItem", false);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                if (B()) {
                    jx1.c("TabBarApi", "fail not TabBar page");
                    return new js1(1001, "fail not TabBar page");
                }
                vb3 z = z();
                if (z == null) {
                    jx1.c("TabBarApi", "tabBarViewController is null");
                    return new js1(1001, "tabBarViewController is null");
                } else if (!z.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                    jx1.c("TabBarApi", "set tab bar item fail");
                    return new js1(1001, "set tab bar item fail");
                } else {
                    return js1.f();
                }
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "TabBarApi" : (String) invokeV.objValue;
    }

    public js1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            q("#closeTabBar", false);
            return A(str, false);
        }
        return (js1) invokeL.objValue;
    }

    public js1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#closeTabBarRedDot", false);
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                int optInt = ((JSONObject) s.second).optInt("index");
                if (B()) {
                    jx1.c("TabBarApi", "fail not TabBar page");
                    return new js1(1001, "fail not TabBar page");
                }
                vb3 z = z();
                if (z == null) {
                    jx1.c("TabBarApi", "tabBarViewController is null");
                    return new js1(1001, "tabBarViewController is null");
                } else if (!z.k(optInt)) {
                    jx1.c("TabBarApi", "close red dot fail");
                    return new js1(1001, "close red dot fail");
                } else {
                    return js1.f();
                }
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }
}
