package com.repackage;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ss2 extends ts2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, u53>> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements rs2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nf3 a;

        /* renamed from: com.repackage.ss2$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0520a implements rs2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0520a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.repackage.rs2
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (ss2.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.onCallback(ss2.g(true));
                }
            }
        }

        public a(nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nf3Var;
        }

        @Override // com.repackage.rs2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, u53> g = ss2.g(true);
                if (g.size() > 0) {
                    this.a.onCallback(g);
                    if (ss2.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                ux1.k("SwanAppUpdateManager", "has not scope set，required request from server");
                qs2.g().update(new C0520a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements rs2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ nf3 b;
        public final /* synthetic */ String c;

        public b(String str, nf3 nf3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, nf3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = nf3Var;
            this.c = str2;
        }

        @Override // com.repackage.rs2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                xs2.f().d(this.a);
                this.b.onCallback(ss2.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755310049, "Lcom/repackage/ss2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755310049, "Lcom/repackage/ss2;");
                return;
            }
        }
        a = eh1.a;
        b = new LruCache<>(6);
    }

    public ss2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            ux1.k("SwanAppUpdateManager", "cleanAccreditListData");
            u03 L = u03.L();
            if (L == null) {
                ux1.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            ux1.k("SwanAppUpdateManager", "prefName: " + L.d0().p() + ", cleanAccredit");
            qs2.g().w(new ss2());
            L.d0().B("node_data_accredit_list", "");
            o();
            qs2.g().update();
        }
    }

    @NonNull
    public static Map<String, u53> g(boolean z) {
        InterceptResult invokeZ;
        ArrayMap<String, u53> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (!z || (l = l()) == null) {
                long nanoTime = a ? System.nanoTime() : 0L;
                ArrayMap arrayMap = new ArrayMap();
                u03 L = u03.L();
                if (L == null) {
                    ux1.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                    return arrayMap;
                }
                String appId = L.getAppId();
                String q = L.d0().q("node_data_accredit_list", "");
                String q2 = L.d0().q("cur_request_id", "");
                ux1.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + L.d0().p() + " requestId=" + q2 + " accreditList=" + q);
                if (TextUtils.isEmpty(q)) {
                    return arrayMap;
                }
                try {
                    ArrayMap<String, u53> m = m(new JSONObject(q), appId);
                    if (a) {
                        long nanoTime2 = System.nanoTime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("#getAccreditListData cost=");
                        sb.append((nanoTime2 - nanoTime) / 1000000.0d);
                        sb.append(" size=");
                        LruCache<String, ArrayMap<String, u53>> lruCache = b;
                        sb.append(lruCache == null ? 0 : lruCache.size());
                        Log.d("SwanAppUpdateManager", sb.toString());
                    }
                    ux1.k("SwanAppUpdateManager", "getAccreditListData - from json");
                    return m;
                } catch (JSONException e) {
                    ux1.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                    return arrayMap;
                }
            }
            return l;
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull nf3<Map<String, u53>> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, nf3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            qs2.g().z(new a(nf3Var));
        }
    }

    public static void i(String str, @NonNull nf3<u53> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, nf3Var) == null) {
            j(str, nf3Var, xs2.f().b(str));
        }
    }

    public static void j(String str, @NonNull nf3<u53> nf3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, nf3Var, str2) == null) {
            u53 u53Var = g(true).get(str);
            if (u53Var != null) {
                xs2.f().d(str2);
                nf3Var.onCallback(u53Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            ux1.k("SwanAppUpdateManager", "has not scope node，required request from server");
            qs2.g().update(new b(str2, nf3Var, str));
        }
    }

    @Nullable
    public static u53 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? g(true).get(str) : (u53) invokeL.objValue;
    }

    public static ArrayMap<String, u53> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            u03 a0 = u03.a0();
            if (a0 == null || TextUtils.isEmpty(a0.b)) {
                return null;
            }
            return b.get(a0.b);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, u53> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, u53> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                ux1.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, u53.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, u53> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, arrayMap, str) == null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        ux1.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + t03.J().getAppId());
        b.put(str, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            ux1.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.repackage.ts2
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // com.repackage.ts2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ux1.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.repackage.ts2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ux1.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // com.repackage.ts2
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            ux1.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                ux1.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            u03 L = u03.L();
            if (L == null) {
                ux1.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            ux1.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + L.d0().p() + ", putAccredit = " + jSONObject2);
            L.d0().B("node_data_accredit_list", jSONObject2);
            d53 d0 = L.d0();
            d0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
