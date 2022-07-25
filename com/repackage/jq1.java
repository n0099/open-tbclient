package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lo1;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class jq1 extends iq1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements lo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq1 a;

        public a(jq1 jq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq1Var;
        }

        @Override // com.repackage.lo1.a
        public is1 a(i03 i03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i03Var, jSONObject, str)) == null) {
                String Q = jq1.Q(jSONObject);
                if (Q == null) {
                    return new is1(202);
                }
                if (r73.b(Q)) {
                    return new is1(1001, "exceed storage key max length");
                }
                String P = jq1.P(jSONObject);
                if (P == null) {
                    return new is1(202);
                }
                if (r73.c(P)) {
                    return new is1(1001, "exceed storage item max length");
                }
                if (this.a.N(i03Var, Q, P)) {
                    return new is1(1003, "exceed storage max length");
                }
                jq1 jq1Var = this.a;
                jq1Var.q("#setStorageImpl dataKey=" + Q + " dataValue=" + P, false);
                this.a.F(i03Var).putString(Q, P);
                this.a.X();
                return is1.f();
            }
            return (is1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq1 a;

        public b(jq1 jq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq1Var;
        }

        @Override // com.repackage.lo1.a
        public is1 a(i03 i03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i03Var, jSONObject, str)) == null) {
                this.a.q("#clearStorageImpl clear", false);
                this.a.F(i03Var).edit().clear().apply();
                this.a.X();
                return is1.f();
            }
            return (is1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements lo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq1 a;

        public c(jq1 jq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq1Var;
        }

        @Override // com.repackage.lo1.a
        public is1 a(i03 i03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i03Var, jSONObject, str)) == null) {
                String Q = jq1.Q(jSONObject);
                if (Q == null) {
                    return new is1(202);
                }
                jq1 jq1Var = this.a;
                jq1Var.q("#removeStorageImpl dataKey=" + Q, false);
                this.a.F(i03Var).remove(Q);
                this.a.X();
                return is1.f();
            }
            return (is1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements lo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jq1 a;

        public d(jq1 jq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jq1Var;
        }

        @Override // com.repackage.lo1.a
        public is1 a(i03 i03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i03Var, jSONObject, str)) == null) {
                String Q = jq1.Q(jSONObject);
                if (Q == null) {
                    return new is1(202);
                }
                JSONObject O = jq1.O(this.a.F(i03Var).getString(Q, null));
                if (O == null) {
                    return new is1(202, "JSONException");
                }
                return new is1(0, O);
            }
            return (is1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements lo1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(jq1 jq1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.lo1.a
        public is1 a(i03 i03Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, i03Var, jSONObject, str)) == null) {
                r73 f0 = i03Var.f0();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(SavedStateHandle.KEYS, new JSONArray((Collection) f0.g().a()));
                    jSONObject2.put("currentSize", f0.e() / 1024);
                    jSONObject2.put("limitSize", f0.n() / 1024);
                    return new is1(0, jSONObject2);
                } catch (JSONException unused) {
                    return new is1(202, "JSONException");
                }
            }
            return (is1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ lo1.a b;
        public final /* synthetic */ i03 c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ jq1 e;

        public f(jq1 jq1Var, String str, lo1.a aVar, i03 i03Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jq1Var, str, aVar, i03Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = jq1Var;
            this.a = str;
            this.b = aVar;
            this.c = i03Var;
            this.d = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                jq1 jq1Var = this.e;
                String str = this.a;
                jq1Var.d(str, this.b.a(this.c, this.d, str));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jq1(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public static JSONObject O(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.has("key")) {
                        jSONObject.remove("key");
                    }
                    return jSONObject;
                } catch (JSONException unused) {
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            if (str == null) {
                str = "";
            }
            try {
                jSONObject2.put("data", str);
                return jSONObject2;
            } catch (JSONException unused2) {
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static String P(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject.isNull("data")) {
                return null;
            }
            return jSONObject.optString("data");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public static String Q(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject.isNull("key")) {
                return null;
            }
            return jSONObject.optString("key");
        }
        return (String) invokeL.objValue;
    }

    public is1 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            q("#clearStorage", false);
            return B(null, true);
        }
        return (is1) invokeV.objValue;
    }

    public is1 B(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) ? L(str, z, new b(this)) : (is1) invokeLZ.objValue;
    }

    public is1 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#clearStorageSync", false);
            return B(null, false);
        }
        return (is1) invokeV.objValue;
    }

    public is1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getStorage", false);
            return E(str, true);
        }
        return (is1) invokeL.objValue;
    }

    public is1 E(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048580, this, str, z)) == null) ? L(str, z, new d(this)) : (is1) invokeLZ.objValue;
    }

    public ig4 F(@NonNull i03 i03Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, i03Var)) == null) ? i03Var.f0().g() : (ig4) invokeL.objValue;
    }

    public is1 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getStorageInfo", false);
            return I(null, true);
        }
        return (is1) invokeV.objValue;
    }

    public is1 H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getStorageInfoAsync", false);
            return I(str, true);
        }
        return (is1) invokeL.objValue;
    }

    public is1 I(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) ? L(str, z, new e(this)) : (is1) invokeLZ.objValue;
    }

    public is1 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            q("#getStorageInfoSync", false);
            return I(null, false);
        }
        return (is1) invokeV.objValue;
    }

    public is1 K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            q("#getStorageSync", false);
            return E(str, false);
        }
        return (is1) invokeL.objValue;
    }

    public final is1 L(@Nullable String str, boolean z, @NonNull lo1.a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Boolean.valueOf(z), aVar})) == null) {
            i03 M = i03.M();
            if (M() && M == null) {
                return new is1(1001, "swan app is null");
            }
            if (TextUtils.isEmpty(str)) {
                return aVar.a(M, new JSONObject(), null);
            }
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = z ? jSONObject.optString("cb") : null;
                if (z && !TextUtils.isEmpty(optString)) {
                    cd3.k(new f(this, optString, aVar, M, jSONObject), "StorageApi");
                    return is1.f();
                }
                return aVar.a(M, jSONObject, null);
            }
            return is1Var;
        }
        return (is1) invokeCommon.objValue;
    }

    public boolean M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean N(@Nullable i03 i03Var, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, i03Var, str, str2)) == null) {
            if (i03Var == null) {
                return false;
            }
            return i03Var.f0().m(str, str2);
        }
        return invokeLLL.booleanValue;
    }

    public is1 R(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            q("#removeStorage", false);
            return S(str, true);
        }
        return (is1) invokeL.objValue;
    }

    public is1 S(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048591, this, str, z)) == null) ? L(str, z, new c(this)) : (is1) invokeLZ.objValue;
    }

    public is1 T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            q("#removeStorageSync", false);
            return S(str, false);
        }
        return (is1) invokeL.objValue;
    }

    public is1 U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            q("#setStorage", false);
            if (str != null && str.length() > 3145728) {
                return new is1(1001, "exceed storage item max length");
            }
            return V(str, true);
        }
        return (is1) invokeL.objValue;
    }

    public final is1 V(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048594, this, str, z)) == null) ? L(str, z, new a(this)) : (is1) invokeLZ.objValue;
    }

    public is1 W(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            q("#setStorageSync", false);
            return V(str, false);
        }
        return (is1) invokeL.objValue;
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            ec3.h.update();
        }
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? "StorageApi" : (String) invokeV.objValue;
    }
}
