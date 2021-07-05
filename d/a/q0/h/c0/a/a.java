package d.a.q0.h.c0.a;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.CfgFileUtils;
import d.a.q0.a.a2.n.c;
import d.a.q0.a.k;
import d.a.q0.a.r1.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class a extends d.a.q0.a.a2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f53184h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f53185b;

    /* renamed from: c  reason: collision with root package name */
    public b f53186c;

    /* renamed from: d  reason: collision with root package name */
    public c f53187d;

    /* renamed from: e  reason: collision with root package name */
    public String f53188e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.h.r.a f53189f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.q0.h.y.e.a f53190g;

    /* renamed from: d.a.q0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1137a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f53191a;

        /* renamed from: b  reason: collision with root package name */
        public String f53192b;

        /* renamed from: c  reason: collision with root package name */
        public String f53193c;

        /* renamed from: d  reason: collision with root package name */
        public String f53194d;

        public C1137a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static C1137a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C1137a c1137a = new C1137a();
                c1137a.f53192b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                c1137a.f53191a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c1137a.f53192b) && !TextUtils.isEmpty(c1137a.f53191a)) {
                    if (c1137a.f53192b.endsWith(".js")) {
                        String[] split = c1137a.f53192b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c1137a.f53194d = split[split.length - 1];
                        c1137a.f53193c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c1137a.f53193c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c1137a.f53192b;
                        c1137a.f53193c = str;
                        if (!str.endsWith(File.separator)) {
                            c1137a.f53193c += File.separator;
                        }
                        c1137a.f53194d = "index.js";
                    }
                    return c1137a;
                }
                return c();
            }
            return (C1137a) invokeL.objValue;
        }

        public static C1137a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1137a() : (C1137a) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C1137a> f53195a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f53196b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static b b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("subpackages");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    b bVar = new b();
                    bVar.f53195a = new ArrayList();
                    bVar.f53196b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.f53195a.add(C1137a.b(optJSONObject));
                        }
                    }
                    return bVar;
                }
                return c();
            }
            return (b) invokeL.objValue;
        }

        public static b c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                b bVar = new b();
                bVar.f53195a = new ArrayList();
                bVar.f53196b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f53197a;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static c b(JSONObject jSONObject, b bVar) {
            InterceptResult invokeLL;
            List<C1137a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.f53195a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.f53197a = new HashMap<>();
                    for (C1137a c1137a : bVar.f53195a) {
                        if (c1137a != null && !TextUtils.isEmpty(c1137a.f53192b)) {
                            HashMap<String, String> hashMap = cVar.f53197a;
                            String str = c1137a.f53192b;
                            hashMap.put(str, optJSONObject.optString(str));
                        }
                    }
                    return cVar;
                }
                return c();
            }
            return (c) invokeLL.objValue;
        }

        public static c c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                c cVar = new c();
                cVar.f53197a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(795407992, "Ld/a/q0/h/c0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(795407992, "Ld/a/q0/h/c0/a/a;");
                return;
            }
        }
        f53184h = k.f49133a;
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

    public static a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.f46713a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f53185b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f53185b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f53186c = b2;
                aVar.f53187d = c.b(jSONObject, b2);
                aVar.f53188e = jSONObject.optString("openDataContext");
                aVar.f53189f = new d.a.q0.h.r.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p("startup").A("preload_resources", z ? "1" : "0");
                aVar.f53190g = new d.a.q0.h.y.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f53184h) {
                    Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
