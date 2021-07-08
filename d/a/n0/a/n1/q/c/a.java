package d.a.n0.a.n1.q.c;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.e;
import d.a.n0.a.e2.c.f;
import d.a.n0.a.k;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.n0.a.n1.q.c.b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46377a;

    /* renamed from: b  reason: collision with root package name */
    public static LruCache<String, ArrayMap<String, f>> f46378b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.n0.a.n1.q.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0834a implements d.a.n0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f46379a;

        /* renamed from: d.a.n0.a.n1.q.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0835a implements d.a.n0.a.n1.q.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ C0834a f46380a;

            public C0835a(C0834a c0834a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0834a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f46380a = c0834a;
            }

            @Override // d.a.n0.a.n1.q.b.a
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (a.f46377a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.f46380a.f46379a.onCallback(a.g(true));
                }
            }
        }

        public C0834a(d.a.n0.a.v2.e1.b bVar) {
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
            this.f46379a = bVar;
        }

        @Override // d.a.n0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, f> g2 = a.g(true);
                if (g2.size() > 0) {
                    this.f46379a.onCallback(g2);
                    if (a.f46377a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "has not scope set，required request from server");
                d.a.n0.a.n1.q.a.g().B(new C0835a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements d.a.n0.a.n1.q.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46381a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f46382b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46383c;

        public b(String str, d.a.n0.a.v2.e1.b bVar, String str2) {
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
            this.f46381a = str;
            this.f46382b = bVar;
            this.f46383c = str2;
        }

        @Override // d.a.n0.a.n1.q.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.n0.a.n1.q.d.b.f().d(this.f46381a);
                this.f46382b.onCallback(a.g(true).get(this.f46383c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(592133082, "Ld/a/n0/a/n1/q/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(592133082, "Ld/a/n0/a/n1/q/c/a;");
                return;
            }
        }
        f46377a = k.f45831a;
        f46378b = new LruCache<>(6);
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
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "cleanAccreditListData");
            e i2 = e.i();
            if (i2 == null) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", cleanAccredit");
            d.a.n0.a.n1.q.a.g().w(new a());
            i2.T().B("node_data_accredit_list", "");
            o();
            d.a.n0.a.n1.q.a.g().A();
        }
    }

    @NonNull
    public static Map<String, f> g(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            ArrayMap<String, f> l = l();
            if (l != null && z) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData from cache, size = " + l.size());
                return l;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayMap arrayMap = new ArrayMap();
            e i2 = e.i();
            if (i2 == null) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - swanApp is null");
                return arrayMap;
            }
            String q = i2.T().q("node_data_accredit_list", "");
            String q2 = i2.T().q("cur_request_id", "");
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "prefName: " + i2.T().p() + ", requestId: " + q2 + ", getAccreditListData - from sp =" + q);
            if (TextUtils.isEmpty(q)) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - sp is null");
                return arrayMap;
            }
            try {
                ArrayMap<String, f> m = m(new JSONObject(q));
                if (f46377a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append("getAccreditListData cost = ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append(" ; size = ");
                    LruCache<String, ArrayMap<String, f>> lruCache = f46378b;
                    sb.append(lruCache == null ? 0 : lruCache.size());
                    Log.d("SwanAppUpdateManager", sb.toString());
                }
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e2) {
                d.a.n0.a.e0.d.i("SwanAppUpdateManager", "getAccreditListData - parse json fail", e2);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull d.a.n0.a.v2.e1.b<Map<String, f>> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, bVar) == null) {
            if (f46377a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            d.a.n0.a.n1.q.a.g().z(new C0834a(bVar));
        }
    }

    public static void i(String str, @NonNull d.a.n0.a.v2.e1.b<f> bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, bVar) == null) {
            j(str, bVar, d.a.n0.a.n1.q.d.b.f().b(str));
        }
    }

    public static void j(String str, @NonNull d.a.n0.a.v2.e1.b<f> bVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, bVar, str2) == null) {
            f fVar = g(true).get(str);
            if (fVar != null) {
                d.a.n0.a.n1.q.d.b.f().d(str2);
                bVar.onCallback(fVar);
                if (f46377a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "has not scope node，required request from server");
            d.a.n0.a.n1.q.a.g().B(new b(str2, bVar, str));
        }
    }

    @Nullable
    public static f k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListDataFromLocalCache, scope = " + str);
            return g(true).get(str);
        }
        return (f) invokeL.objValue;
    }

    public static ArrayMap<String, f> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            e Q = e.Q();
            if (Q == null || TextUtils.isEmpty(Q.f43381f)) {
                return null;
            }
            return f46378b.get(Q.f43381f);
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
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
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
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "parseScopeInfoMap to cache");
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public static void n(ArrayMap<String, f> arrayMap) {
        e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, arrayMap) == null) || arrayMap == null || arrayMap.size() <= 0 || (Q = e.Q()) == null || TextUtils.isEmpty(Q.f43381f)) {
            return;
        }
        f46378b.put(Q.f43381f, arrayMap);
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "resetCache");
            f46378b.evictAll();
        }
    }

    @Override // d.a.n0.a.n1.q.c.b
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.n1.q.c.b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // d.a.n0.a.n1.q.c.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "onFiltered");
        }
    }

    @Override // d.a.n0.a.n1.q.c.b
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "data is null");
                return;
            }
            e i2 = e.i();
            if (i2 == null) {
                d.a.n0.a.e0.d.h("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            d.a.n0.a.e0.d.h("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + i2.T().p() + ", putAccredit = " + jSONObject2);
            i2.T().B("node_data_accredit_list", jSONObject2);
            d.a.n0.a.e2.a T = i2.T();
            T.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
