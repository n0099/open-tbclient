package d.a.o0.h.c0.a;

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
import d.a.o0.a.a2.n.c;
import d.a.o0.a.k;
import d.a.o0.a.r1.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a extends d.a.o0.a.a2.n.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f50386h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public int f50387b;

    /* renamed from: c  reason: collision with root package name */
    public b f50388c;

    /* renamed from: d  reason: collision with root package name */
    public c f50389d;

    /* renamed from: e  reason: collision with root package name */
    public String f50390e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.h.r.a f50391f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.h.y.e.a f50392g;

    /* renamed from: d.a.o0.h.c0.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C1095a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50393a;

        /* renamed from: b  reason: collision with root package name */
        public String f50394b;

        /* renamed from: c  reason: collision with root package name */
        public String f50395c;

        /* renamed from: d  reason: collision with root package name */
        public String f50396d;

        public C1095a() {
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

        public static C1095a b(JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
                if (jSONObject == null) {
                    return c();
                }
                C1095a c1095a = new C1095a();
                c1095a.f50394b = jSONObject.optString(PrefetchEvent.EVENT_DATA_ROOT_PATH);
                c1095a.f50393a = jSONObject.optString("name");
                if (!TextUtils.isEmpty(c1095a.f50394b) && !TextUtils.isEmpty(c1095a.f50393a)) {
                    if (c1095a.f50394b.endsWith(".js")) {
                        String[] split = c1095a.f50394b.split(File.separator);
                        if (split.length < 1) {
                            return c();
                        }
                        c1095a.f50396d = split[split.length - 1];
                        c1095a.f50395c = "";
                        for (int i2 = 0; i2 < split.length - 1; i2++) {
                            c1095a.f50395c += split[i2] + File.separator;
                        }
                    } else {
                        String str = c1095a.f50394b;
                        c1095a.f50395c = str;
                        if (!str.endsWith(File.separator)) {
                            c1095a.f50395c += File.separator;
                        }
                        c1095a.f50396d = "index.js";
                    }
                    return c1095a;
                }
                return c();
            }
            return (C1095a) invokeL.objValue;
        }

        public static C1095a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? new C1095a() : (C1095a) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<C1095a> f50397a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Boolean> f50398b;

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
                    bVar.f50397a = new ArrayList();
                    bVar.f50398b = new HashMap<>();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            bVar.f50397a.add(C1095a.b(optJSONObject));
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
                bVar.f50397a = new ArrayList();
                bVar.f50398b = new HashMap<>();
                return bVar;
            }
            return (b) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashMap<String, String> f50399a;

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
            List<C1095a> list;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, jSONObject, bVar)) == null) {
                if (jSONObject != null && bVar != null && (list = bVar.f50397a) != null && list.size() > 0) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("_sub_swan");
                    if (optJSONObject == null) {
                        return c();
                    }
                    c cVar = new c();
                    cVar.f50399a = new HashMap<>();
                    for (C1095a c1095a : bVar.f50397a) {
                        if (c1095a != null && !TextUtils.isEmpty(c1095a.f50394b)) {
                            HashMap<String, String> hashMap = cVar.f50399a;
                            String str = c1095a.f50394b;
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
                cVar.f50399a = new HashMap<>();
                return cVar;
            }
            return (c) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(537242554, "Ld/a/o0/h/c0/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(537242554, "Ld/a/o0/h/c0/a/a;");
                return;
            }
        }
        f50386h = k.f46335a;
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
                aVar.f43915a = c.a.a(jSONObject);
                String optString = jSONObject.optString("deviceOrientation", "portrait");
                boolean z = false;
                aVar.f50387b = 0;
                if (TextUtils.equals(optString, "landscape")) {
                    aVar.f50387b = 1;
                }
                jSONObject.optBoolean("showStatusBar", false);
                jSONObject.optString("workers");
                b b2 = b.b(jSONObject);
                aVar.f50388c = b2;
                aVar.f50389d = c.b(jSONObject, b2);
                aVar.f50390e = jSONObject.optString("openDataContext");
                aVar.f50391f = new d.a.o0.h.r.a(jSONObject);
                JSONArray optJSONArray = jSONObject.optJSONArray("preloadResources");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z = true;
                }
                h.p("startup").A("preload_resources", z ? "1" : "0");
                aVar.f50392g = new d.a.o0.h.y.e.a(optJSONArray);
                JSONObject optJSONObject = jSONObject.optJSONObject(com.alipay.sdk.sys.a.j);
                if (optJSONObject != null) {
                    optJSONObject.optBoolean(CfgFileUtils.KEY_URL_CHECK, true);
                }
                return aVar;
            } catch (JSONException e2) {
                if (f50386h) {
                    Log.e("SwanGameConfigData", "buildConfigData json error: " + Log.getStackTraceString(e2));
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }
}
