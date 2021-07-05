package d.a.q0.a.c2.f.g0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.g1.f;
import d.a.q0.a.h0.g.e;
import d.a.q0.a.h0.g.g;
import d.a.q0.a.k;
import d.a.q0.a.k2.g.h;
import d.a.q0.a.v2.o0;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: d  reason: collision with root package name */
    public static String f46967d = "SwanAppPageForbidden";

    /* renamed from: e  reason: collision with root package name */
    public static boolean f46968e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f46969a;

    /* renamed from: b  reason: collision with root package name */
    public List<JSONObject> f46970b;

    /* renamed from: c  reason: collision with root package name */
    public String f46971c;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f46972e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46973f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ e f46974g;

        public a(d dVar, g gVar, String str, e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, gVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46972e = gVar;
            this.f46973f = str;
            this.f46974g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b i2 = this.f46972e.i(this.f46973f);
                i2.n(g.f48010g, g.f48012i);
                i2.j(this.f46974g);
                i2.b();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f46975a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-705048721, "Ld/a/q0/a/c2/f/g0/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-705048721, "Ld/a/q0/a/c2/f/g0/d$b;");
                    return;
                }
            }
            f46975a = new d(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(589209837, "Ld/a/q0/a/c2/f/g0/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(589209837, "Ld/a/q0/a/c2/f/g0/d;");
                return;
            }
        }
        f46968e = k.f49133a;
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.f46975a : (d) invokeV.objValue;
    }

    public boolean a(d.a.q0.a.l1.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar != null && d.a.q0.a.v.a.e(d.a.q0.a.a2.d.g().r().N())) {
                if (!this.f46969a) {
                    j();
                }
                List<JSONObject> list = this.f46970b;
                if (list == null || list.isEmpty()) {
                    return false;
                }
                if (f46968e) {
                    Log.d(f46967d, "ForbiddenPage Check");
                }
                return g(bVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return str + "_forbidden_ban_page";
        }
        return (String) invokeL.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f46971c : (String) invokeV.objValue;
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return str + "_forbidden_tips";
        }
        return (String) invokeL.objValue;
    }

    public final boolean f(String[] strArr, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, strArr, list)) == null) {
            if (list == null || list.isEmpty() || strArr == null || strArr.length == 0) {
                return false;
            }
            List asList = Arrays.asList(strArr);
            if (asList.isEmpty()) {
                return false;
            }
            for (String str : list) {
                if (!asList.contains(str)) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(d.a.q0.a.l1.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            String str = bVar.f49291e;
            String str2 = bVar.f49294h;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                List<JSONObject> list = this.f46970b;
                if (list == null) {
                    return false;
                }
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null && !jSONObject.isNull("type") && !jSONObject.isNull("path")) {
                        int optInt = jSONObject.optInt("type");
                        String optString = jSONObject.optString("path");
                        if (TextUtils.equals(str, optString) || TextUtils.equals(str2, optString)) {
                            if (optInt == 1) {
                                return true;
                            }
                            if (optInt != 2) {
                                if (optInt == 3 && !jSONObject.isNull("query")) {
                                    String optString2 = jSONObject.optString("query");
                                    if (TextUtils.isEmpty(bVar.f49292f)) {
                                        return false;
                                    }
                                    List<String> c2 = o0.c(optString2);
                                    String[] split = bVar.f49292f.split("&");
                                    if (split == null || split.length == 0 || c2 == null || c2.isEmpty()) {
                                        return false;
                                    }
                                    if (f(split, c2)) {
                                        return true;
                                    }
                                }
                            } else if (jSONObject.isNull("query")) {
                                continue;
                            } else {
                                String optString3 = jSONObject.optString("query");
                                if (TextUtils.isEmpty(bVar.f49292f)) {
                                    return false;
                                }
                                List<String> c3 = o0.c(optString3);
                                String[] split2 = bVar.f49292f.split("&");
                                if (split2 == null || split2.length == 0 || c3 == null || c3.isEmpty() || split2.length != c3.size()) {
                                    return false;
                                }
                                if (f(split2, c3)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean h(d.a.q0.a.l1.b bVar) {
        InterceptResult invokeL;
        List<JSONObject> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            String str = bVar.f49294h;
            if (TextUtils.isEmpty(str) || (list = this.f46970b) == null) {
                return false;
            }
            for (JSONObject jSONObject : list) {
                if (jSONObject != null && TextUtils.equals(str, jSONObject.optString("path"))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void i(String str, d.a.q0.a.l1.b bVar) {
        g W;
        String e2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, str, bVar) == null) || bVar == null || (W = f.V().W()) == null || (W.m() instanceof e)) {
            return;
        }
        if (h(bVar)) {
            e2 = d.a.q0.a.l1.b.f(bVar);
        } else {
            e2 = d.a.q0.a.l1.b.e(bVar);
        }
        if (f46968e) {
            String str2 = f46967d;
            Log.d(str2, "jump from " + str + " ; path = " + e2);
        }
        d.a.q0.a.a2.e r = d.a.q0.a.a2.d.g().r();
        b.a L = r.L();
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
        forbiddenInfo.appId = r.getAppId();
        forbiddenInfo.appKey = r.D();
        forbiddenInfo.appTitle = L.K();
        forbiddenInfo.forbiddenReason = d();
        forbiddenInfo.forbiddenInformation = this.f46971c;
        forbiddenInfo.launchSource = L.T();
        forbiddenInfo.launchPath = e2;
        forbiddenInfo.enableSlidingFlag = 0;
        l(forbiddenInfo);
        q0.b0(new a(this, W, str, e.R2(SwanAppErrorActivity.TYPE_PATH_FORBIDDEN, forbiddenInfo, 0, 0)));
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d.a.q0.a.k2.g.b a2 = h.a();
            String D = d.a.q0.a.a2.d.g().r().D();
            if (a2 == null) {
                return;
            }
            String string = a2.getString(c(D), null);
            if (f46968e) {
                String str = f46967d;
                Log.d(str, "readData, appKey = " + D + " ; tips = " + this.f46971c + " ; page = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                this.f46970b = null;
            } else {
                JSONArray e2 = w.e(string);
                if (e2 == null) {
                    return;
                }
                int length = e2.length();
                this.f46970b = new ArrayList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject optJSONObject = e2.optJSONObject(i2);
                    if (optJSONObject != null) {
                        this.f46970b.add(optJSONObject);
                    }
                }
                this.f46971c = a2.getString(e(D), null);
            }
            this.f46969a = true;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (f46968e) {
                Log.d(f46967d, "releaseData");
            }
            this.f46969a = false;
            this.f46971c = null;
            List<JSONObject> list = this.f46970b;
            if (list != null) {
                list.clear();
                this.f46970b = null;
            }
        }
    }

    public final void l(ForbiddenInfo forbiddenInfo) {
        d.a.q0.a.a2.e Q;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, forbiddenInfo) == null) || (Q = d.a.q0.a.a2.e.Q()) == null) {
            return;
        }
        Q.r();
        SwanAppActivity x = Q.x();
        if (x == null) {
            return;
        }
        String i2 = d.a.q0.a.m2.b.i(f.V().N(), Q.N().G());
        d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
        aVar.j(10L);
        aVar.h(48L);
        aVar.c("page forbidden");
        forbiddenInfo.forbiddenDetail = x.getString(d.a.q0.a.h.aiapps_open_failed_detail_format, q0.D(), i2, String.valueOf(aVar.a()));
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("ai_apps_key", str);
            d.a.q0.a.v1.c.a e2 = d.a.q0.a.v1.c.a.e();
            d.a.q0.a.v1.c.c cVar = new d.a.q0.a.v1.c.c(IMPushPb.PushImClient.SDK_VERSION_FIELD_NUMBER, bundle);
            cVar.d();
            e2.h(cVar);
        }
    }

    public void n(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048588, this, jSONArray, str, str2) == null) || TextUtils.isEmpty(str2)) {
            return;
        }
        String c2 = c(str2);
        String e2 = e(str2);
        if (jSONArray != null && jSONArray.length() != 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            String jSONArray2 = jSONArray.toString();
            if (optJSONObject != null) {
                h.a().edit().putString(c2, jSONArray2).putString(e2, str).apply();
                if (f46968e) {
                    String str3 = f46967d;
                    Log.d(str3, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str);
                }
                m(str2);
                return;
            }
            return;
        }
        h.a().edit().remove(c2).remove(e2).apply();
        if (f46968e) {
            String str4 = f46967d;
            Log.d(str4, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46969a = false;
    }
}
