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
/* loaded from: classes6.dex */
public class fs2 extends gs2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, h53>> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements es2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af3 a;

        /* renamed from: com.repackage.fs2$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0640a implements es2 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0640a(a aVar) {
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

            @Override // com.repackage.es2
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (fs2.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.a(fs2.g(true));
                }
            }
        }

        public a(af3 af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af3Var;
        }

        @Override // com.repackage.es2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, h53> g = fs2.g(true);
                if (g.size() > 0) {
                    this.a.a(g);
                    if (fs2.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                hx1.k("SwanAppUpdateManager", "has not scope set，required request from server");
                ds2.g().update(new C0640a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements es2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ af3 b;
        public final /* synthetic */ String c;

        public b(String str, af3 af3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, af3Var, str2};
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
            this.b = af3Var;
            this.c = str2;
        }

        @Override // com.repackage.es2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ks2.f().d(this.a);
                this.b.a(fs2.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755697332, "Lcom/repackage/fs2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755697332, "Lcom/repackage/fs2;");
                return;
            }
        }
        a = rg1.a;
        b = new LruCache<>(6);
    }

    public fs2() {
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
            hx1.k("SwanAppUpdateManager", "cleanAccreditListData");
            h03 M = h03.M();
            if (M == null) {
                hx1.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            hx1.k("SwanAppUpdateManager", "prefName: " + M.e0().p() + ", cleanAccredit");
            ds2.g().w(new fs2());
            M.e0().B("node_data_accredit_list", "");
            o();
            ds2.g().update();
        }
    }

    @NonNull
    public static Map<String, h53> g(boolean z) {
        InterceptResult invokeZ;
        ArrayMap<String, h53> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (!z || (l = l()) == null) {
                long nanoTime = a ? System.nanoTime() : 0L;
                ArrayMap arrayMap = new ArrayMap();
                h03 M = h03.M();
                if (M == null) {
                    hx1.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                    return arrayMap;
                }
                String appId = M.getAppId();
                String q = M.e0().q("node_data_accredit_list", "");
                String q2 = M.e0().q("cur_request_id", "");
                hx1.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + M.e0().p() + " requestId=" + q2 + " accreditList=" + q);
                if (TextUtils.isEmpty(q)) {
                    return arrayMap;
                }
                try {
                    ArrayMap<String, h53> m = m(new JSONObject(q), appId);
                    if (a) {
                        long nanoTime2 = System.nanoTime();
                        StringBuilder sb = new StringBuilder();
                        sb.append("#getAccreditListData cost=");
                        sb.append((nanoTime2 - nanoTime) / 1000000.0d);
                        sb.append(" size=");
                        LruCache<String, ArrayMap<String, h53>> lruCache = b;
                        sb.append(lruCache == null ? 0 : lruCache.size());
                        Log.d("SwanAppUpdateManager", sb.toString());
                    }
                    hx1.k("SwanAppUpdateManager", "getAccreditListData - from json");
                    return m;
                } catch (JSONException e) {
                    hx1.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                    return arrayMap;
                }
            }
            return l;
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull af3<Map<String, h53>> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, af3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            ds2.g().z(new a(af3Var));
        }
    }

    public static void i(String str, @NonNull af3<h53> af3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, af3Var) == null) {
            j(str, af3Var, ks2.f().b(str));
        }
    }

    public static void j(String str, @NonNull af3<h53> af3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, af3Var, str2) == null) {
            h53 h53Var = g(true).get(str);
            if (h53Var != null) {
                ks2.f().d(str2);
                af3Var.a(h53Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            hx1.k("SwanAppUpdateManager", "has not scope node，required request from server");
            ds2.g().update(new b(str2, af3Var, str));
        }
    }

    @Nullable
    public static h53 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? g(true).get(str) : (h53) invokeL.objValue;
    }

    public static ArrayMap<String, h53> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            h03 b0 = h03.b0();
            if (b0 == null || TextUtils.isEmpty(b0.b)) {
                return null;
            }
            return b.get(b0.b);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, h53> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, h53> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                hx1.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, h53.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, h53> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65547, null, arrayMap, str) == null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        hx1.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + g03.K().getAppId());
        b.put(str, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            hx1.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.repackage.gs2
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // com.repackage.gs2
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            hx1.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.repackage.gs2
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hx1.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // com.repackage.gs2
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            hx1.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                hx1.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            h03 M = h03.M();
            if (M == null) {
                hx1.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            hx1.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + M.e0().p() + ", putAccredit = " + jSONObject2);
            M.e0().B("node_data_accredit_list", jSONObject2);
            q43 e0 = M.e0();
            e0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
