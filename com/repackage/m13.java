package com.repackage;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public a(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.k("WebSafeWhiteListMgr", "async read webDomains");
                m13.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(d dVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.k("WebSafeWhiteListMgr", "async read serverDomains");
                m13.p(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public c(d dVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ux1.k("WebSafeWhiteListMgr", "async read webActions");
                m13.o(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public List<String> b;
        public long c;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new CopyOnWriteArrayList();
        }

        @NonNull
        public static List<String> d(JSONArray jSONArray) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONArray)) == null) {
                ArrayList arrayList = new ArrayList();
                if (jSONArray != null && jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
                return;
            }
            this.a = jSONObject.optString("token");
            this.b.addAll(d(jSONObject.optJSONArray("data")));
        }

        public void b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject, str) == null) || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return;
            }
            this.b.addAll(d(optJSONObject.optJSONArray(str)));
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.clear();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return "WebSafeData{token='" + this.a + "', data=" + this.b + ", lastModifiedTime=" + this.c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755552190, "Lcom/repackage/m13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755552190, "Lcom/repackage/m13;");
                return;
            }
        }
        a = eh1.a;
    }

    @NonNull
    public static String c(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, str, str2, str3)) == null) {
            String path = AppRuntime.getAppContext().getFilesDir().getPath();
            if (TextUtils.isEmpty(str)) {
                return path + File.separator + str2 + File.separator + str3;
            }
            return path + File.separator + str2 + File.separator + str + "_" + str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static List<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("swanAPI/installApp4Ad");
            arrayList.add("swanAPI/openApp4Ad");
            arrayList.add("swanAPI/checkAppInstalled");
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir().getPath() + File.separator + "aiapps_folder/cloud_config";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static vg4 f(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return i93.b(str + "_domain_config");
        }
        return (vg4) invokeL.objValue;
    }

    @Nullable
    public static Set<String> g(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? f(str).getStringSet("prelink", null) : (Set) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void h(boolean z, String str, String str2, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, dVar}) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.w("WebSafeWhiteListMgr", "get serverDomains: appId is empty");
                }
            } else if (dVar == null) {
                if (a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
            } else {
                String i = i(str);
                if (z) {
                    ExecutorUtilsExt.postOnElastic(new b(dVar, i, str2), "load-ServerDomains", 2);
                } else {
                    p(dVar, i, str2);
                }
            }
        }
    }

    @NonNull
    public static String i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? c(str, "aiapps_folder/cloud_config", "server_domains.json") : (String) invokeL.objValue;
    }

    @NonNull
    public static String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) ? c("", "aiapps_folder/cloud_config", "global_web_actions.json") : (String) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void k(boolean z, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65547, null, z, dVar) == null) {
            if (dVar == null) {
                if (a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
                return;
            }
            String j = j();
            if (z) {
                ExecutorUtilsExt.postOnElastic(new c(dVar, j), "load-WebActions", 2);
            } else {
                o(dVar, j);
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void l(boolean z, String str, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), str, dVar}) == null) {
            if (TextUtils.isEmpty(str)) {
                if (a) {
                    Log.w("WebSafeWhiteListMgr", "getWebDomains: appId is empty");
                }
            } else if (dVar == null) {
                if (a) {
                    throw new RuntimeException("Please init webSafeData first!");
                }
            } else {
                String m = m(str);
                if (z) {
                    ExecutorUtilsExt.postOnElastic(new a(dVar, m), "load-WebDomains", 2);
                } else {
                    o(dVar, m);
                }
            }
        }
    }

    @NonNull
    public static String m(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? c(str, "aiapps_folder/cloud_config", "web_domains.json") : (String) invokeL.objValue;
    }

    public static boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? new File(m(str)).exists() : invokeL.booleanValue;
    }

    public static void o(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, dVar, str) == null) {
            if (dVar == null) {
                ux1.k("WebSafeWhiteListMgr", "webSafeData == null");
                return;
            }
            ux1.k("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
            try {
                dVar.a(new JSONObject(q(str)));
                v(dVar, str);
                ux1.k("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
            } catch (Exception e) {
                ux1.k("WebSafeWhiteListMgr", Log.getStackTraceString(e));
            }
        }
    }

    public static void p(d dVar, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, dVar, str, str2) == null) {
            if (dVar == null) {
                ux1.k("WebSafeWhiteListMgr", "webSafeData == null");
                return;
            }
            ux1.k("WebSafeWhiteListMgr", "update webSafeData(before): " + dVar);
            try {
                dVar.b(new JSONObject(q(str)), str2);
                v(dVar, str);
                ux1.k("WebSafeWhiteListMgr", "update webSafeData(after): " + dVar);
            } catch (Exception e) {
                ux1.k("WebSafeWhiteListMgr", Log.getStackTraceString(e));
            }
        }
    }

    public static String q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            ux1.k("WebSafeWhiteListMgr", "read data from: " + str);
            return xj2.a(str);
        }
        return (String) invokeL.objValue;
    }

    public static void r(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, null, str, str2) == null) {
            JSONArray optJSONArray = ud3.d(str2).optJSONArray("prelink");
            if (optJSONArray != null) {
                ArraySet arraySet = new ArraySet();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arraySet.add(optString);
                    }
                }
                w(str, arraySet);
            }
            if (a) {
                Log.d("WebSafeWhiteListMgr", "saveDomainConfig appId=" + str + ", domainConfig=" + str2);
            }
        }
    }

    public static boolean s(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, jSONObject)) == null) {
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("data", jSONObject);
                    String i = i(str);
                    boolean b2 = xj2.b(i, jSONObject2.toString(), false);
                    ux1.k("WebSafeWhiteListMgr", "save serverDomains: result=" + b2 + " filePath=" + i + " appId= " + str + " data=" + jSONObject);
                    return b2;
                } catch (JSONException e) {
                    if (a) {
                        Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                    }
                    return false;
                }
            }
            if (a) {
                Log.d("WebSafeWhiteListMgr", "save serverDomains: appId or data is empty");
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean t(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, str, jSONArray)) == null) {
            if (jSONArray == null) {
                if (a) {
                    Log.w("WebSafeWhiteListMgr", "saveWebActions: data is empty");
                }
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("token", str);
                }
                jSONObject.put("data", jSONArray);
                String j = j();
                boolean b2 = xj2.b(j, jSONObject.toString(), false);
                ux1.k("WebSafeWhiteListMgr", "save webActions: result=" + b2 + " filePath=" + j + " token=" + str + " data=" + jSONArray);
                return b2;
            } catch (JSONException e) {
                if (a) {
                    Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean u(String str, String str2, JSONArray jSONArray) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65557, null, str, str2, jSONArray)) == null) {
            if (!TextUtils.isEmpty(str) && jSONArray != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("token", str2);
                    }
                    jSONObject.put("data", jSONArray);
                    String m = m(str);
                    boolean b2 = xj2.b(m, jSONObject.toString(), false);
                    ux1.k("WebSafeWhiteListMgr", "save WebDomains: result=" + b2 + " filePath=" + m + " appId= " + str + " token=" + str2 + " data=" + jSONArray);
                    return b2;
                } catch (JSONException e) {
                    if (a) {
                        Log.e("WebSafeWhiteListMgr", Log.getStackTraceString(e));
                    }
                    return false;
                }
            }
            if (a) {
                Log.w("WebSafeWhiteListMgr", "saveWebDomains: appId or data is empty");
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void v(@NonNull d dVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, dVar, str) == null) {
            File file = new File(str);
            if (file.exists()) {
                dVar.c = file.lastModified();
            }
        }
    }

    public static void w(@NonNull String str, @Nullable Set<String> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, set) == null) {
            if (set != null) {
                ArrayList arrayList = new ArrayList(set.size());
                ArraySet arraySet = new ArraySet(set.size());
                for (String str2 : set) {
                    String e = jq1.e(str2);
                    if (e != null && !arrayList.contains(e)) {
                        arraySet.add(str2);
                        arrayList.add(e);
                    }
                }
                set = arraySet;
            }
            f(str).putStringSet("prelink", set);
        }
    }
}
