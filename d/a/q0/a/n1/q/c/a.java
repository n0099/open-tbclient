package d.a.q0.a.n1.q.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.e2.c.f;
import d.a.q0.a.k;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.a.n1.q.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49679a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f49680b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.n1.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0885a implements d.a.q0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f49681a;

        /* renamed from: d.a.q0.a.n1.q.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0886a implements d.a.q0.a.n1.q.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0885a f49682a;

            public C0886a(C0885a c0885a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0885a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f49682a = c0885a;
            }

            @Override // d.a.q0.a.n1.q.b.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (a.f49679a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.f49682a.f49681a.onCallback(a.g(true));
                }
            }
        }

        public C0885a(d.a.q0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49681a = bVar;
        }

        @Override // d.a.q0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, f> g2 = a.g(true);
                if (g2.size() > 0) {
                    this.f49681a.onCallback(g2);
                    if (a.f49679a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "has not scope set，required request from server");
                d.a.q0.a.n1.q.a.g().B(new C0886a(this));
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b implements d.a.q0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49683a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.v2.e1.b f49684b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f49685c;

        public b(String str, d.a.q0.a.v2.e1.b bVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49683a = str;
            this.f49684b = bVar;
            this.f49685c = str2;
        }

        @Override // d.a.q0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.n1.q.d.b.f().d(this.f49683a);
                this.f49684b.onCallback(a.g(true).get(this.f49685c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-924542793, "Ld/a/q0/a/n1/q/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-924542793, "Ld/a/q0/a/n1/q/c/a;");
                return;
            }
        }
        f49679a = k.f49133a;
        f49680b = new LruCache<>(6);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "cleanAccreditListData");
            e i2 = e.i();
            if (i2 == null) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", cleanAccredit");
            d.a.q0.a.n1.q.a.g().w(new a());
            i2.T().B("node_data_accredit_list", "");
            o();
            d.a.q0.a.n1.q.a.g().A();
        }
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65540, null, z)) == null) {
            ArrayMap<String, f> l = l();
            if (l != null && z) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData from cache, size = " + l.size());
                return l;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayMap arrayMap = new ArrayMap();
            e i2 = e.i();
            if (i2 == null) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
                return arrayMap;
            }
            String q = i2.T().q("node_data_accredit_list", "");
            String q2 = i2.T().q("cur_request_id", "");
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", requestId: " + q2 + ", getAccreditListData - from sp =" + q);
            if (TextUtils.isEmpty(q)) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
                return arrayMap;
            }
            try {
                ArrayMap<String, f> m = m(new JSONObject(q));
                if (f49679a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAccreditListData cost = ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append(" ; size = ");
                    LruCache<String, ArrayMap<String, f>> lruCache = f49680b;
                    sb.append(lruCache == null ? 0 : lruCache.size());
                    Log.d("SwanAppUpdateManager", sb.toString());
                }
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e2) {
                d.a.q0.a.e0.d.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull d.a.q0.a.v2.e1.b<Map<String, f>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            if (f49679a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            d.a.q0.a.n1.q.a.g().z(new C0885a(bVar));
        }
    }

    public static void i(String str, @NonNull d.a.q0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bVar) == null) {
            j(str, bVar, d.a.q0.a.n1.q.d.b.f().b(str));
        }
    }

    public static void j(String str, @NonNull d.a.q0.a.v2.e1.b<f> bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, bVar, str2) == null) {
            f fVar = g(true).get(str);
            if (fVar != null) {
                d.a.q0.a.n1.q.d.b.f().d(str2);
                bVar.onCallback(fVar);
                if (f49679a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "has not scope node，required request from server");
            d.a.q0.a.n1.q.a.g().B(new b(str2, bVar, str));
        }
    }

    @Nullable
    public static f k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
            return g(true).get(str);
        }
        return (f) invokeL.objValue;
    }

    public static ArrayMap<String, f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            e Q = e.Q();
            if (Q == null || TextUtils.isEmpty(Q.f46683f)) {
                return null;
            }
            return f49680b.get(Q.f46683f);
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static ArrayMap<String, f> m(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            ArrayMap<String, f> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, f.d(next, optJSONObject));
                }
            }
            n(arrayMap);
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "parseScopeInfoMap to cache");
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public static void n(ArrayMap<String, f> arrayMap) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, arrayMap) == null) || arrayMap == null || arrayMap.size() <= 0 || (Q = e.Q()) == null || TextUtils.isEmpty(Q.f46683f)) {
            return;
        }
        f49680b.put(Q.f46683f, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "resetCache");
            f49680b.evictAll();
        }
    }

    @Override // d.a.q0.a.n1.q.c.b
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.n1.q.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // d.a.q0.a.n1.q.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // d.a.q0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "data is null");
                return;
            }
            e i2 = e.i();
            if (i2 == null) {
                d.a.q0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            d.a.q0.a.e0.d.h("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + i2.T().p() + ", putAccredit = " + jSONObject2);
            i2.T().B("node_data_accredit_list", jSONObject2);
            d.a.q0.a.e2.a T = i2.T();
            T.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
