package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.mcssdk.PushManager;
import com.repackage.as1;
import com.repackage.eb4;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ov2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements as1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2 a;

        public a(dw2 dw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw2Var;
        }

        @Override // com.repackage.as1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ov2.r(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dw2 a;

        public b(dw2 dw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ov2.c(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements t12<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.t12
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                zv2.b("download plugin result = " + bool);
                aw2.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755426330, "Lcom/repackage/ov2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755426330, "Lcom/repackage/ov2;");
                return;
            }
        }
        a = rg1.a;
    }

    public static void c(dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dw2Var) == null) {
            if (dw2Var != null && dw2Var.a()) {
                String str = dw2Var.a;
                String str2 = dw2Var.b;
                long j = dw2Var.c;
                p74.g(new ib4(str, str2, j, dw2Var.d), new nv2(str, str2, j, new c(str)));
                return;
            }
            zv2.b("plugin is invalid");
        }
    }

    public static File d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (str.startsWith("__dep__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i = fw2.i("dependenciesPath", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    String optString = new JSONObject(i).optString(str2);
                    if (TextUtils.isEmpty(optString)) {
                        return null;
                    }
                    return new File(optString, substring + ".json");
                } catch (JSONException e) {
                    zv2.b(Log.getStackTraceString(e));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static List<y84> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<bw2> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = zk2.b(dj2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (bw2 bw2Var : b2.k.a) {
                y84 y84Var = new y84();
                y84Var.a = bw2Var.a;
                y84Var.b = bw2Var.g;
                y84Var.c = bw2Var.c;
                y84Var.e = bw2Var.i;
                y84Var.d = bw2Var.h;
                arrayList.add(y84Var);
            }
            return arrayList;
        }
        return (List) invokeLJ.objValue;
    }

    public static String f(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (str.startsWith("__dep__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i = fw2.i("dependenciesConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    zv2.b(Log.getStackTraceString(e));
                }
                if (optJSONObject == null) {
                    return null;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES);
                if (l(substring, optJSONArray)) {
                    return str;
                }
                JSONObject optJSONObject3 = optJSONObject.optJSONObject("module");
                if (optJSONObject3 == null || (optJSONObject2 = optJSONObject3.optJSONObject("paths")) == null) {
                    return null;
                }
                Iterator<String> keys = optJSONObject2.keys();
                String str3 = null;
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        if (substring.startsWith(next)) {
                            if (str3 != null && next.length() <= str3.length()) {
                            }
                            str3 = next;
                        }
                    }
                }
                if (str3 == null) {
                    return null;
                }
                String replaceFirst = substring.replaceFirst(str3, optJSONObject2.optString(str3));
                if (l(replaceFirst, optJSONArray)) {
                    return str.replace(substring, replaceFirst);
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static File g(@Nullable g94 g94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, g94Var)) == null) {
            if (g94Var == null) {
                return null;
            }
            File t = dj2.t(g94Var.g, String.valueOf(g94Var.i));
            return (t == null || !t.exists()) ? dj2.t(g94Var.g, String.valueOf(wd3.c(g94Var.j))) : t;
        }
        return (File) invokeL.objValue;
    }

    public static String h(@NonNull String str) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (str.startsWith("__dynamicLib__")) {
                String[] split = str.split("/");
                if (split.length < 2) {
                    return null;
                }
                String str2 = split[1];
                int indexOf = str.indexOf(str2) + str2.length() + 1;
                if (indexOf >= str.length()) {
                    return null;
                }
                String substring = str.substring(indexOf);
                String i = fw2.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    zv2.b(Log.getStackTraceString(e));
                }
                if (optJSONObject != null && (optJSONObject2 = optJSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME)) != null && (optJSONArray = optJSONObject2.optJSONArray(NotificationCompat.WearableExtender.KEY_PAGES)) != null && (length = optJSONArray.length()) != 0) {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (TextUtils.equals(substring, optJSONArray.optString(i2))) {
                            return str;
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static Set<eb4.a> i(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, pMSAppInfo)) == null) {
            if (pMSAppInfo == null) {
                return null;
            }
            return j(pMSAppInfo.appId, pMSAppInfo.versionCode);
        }
        return (Set) invokeL.objValue;
    }

    public static Set<eb4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<y84> l = q74.b().l(str, j);
            if (l == null || l.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (y84 y84Var : l) {
                if (!y84Var.b && ld4.b(y84Var.a, y84Var.d, y84Var.e, arrayList) == null) {
                    eb4.a aVar = new eb4.a(y84Var.a);
                    aVar.f(y84Var.d, y84Var.e);
                    hashSet.add(aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                c84.i().g(arrayList);
            }
            return hashSet;
        }
        return (Set) invokeLJ.objValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return (TextUtils.isEmpty(h(str)) && TextUtils.isEmpty(f(str))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static boolean l(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) != 0) {
                for (int i = 0; i < length; i++) {
                    if (TextUtils.equals(str, jSONArray.optString(i))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void m(SwanAppConfigData swanAppConfigData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65549, null, swanAppConfigData, z) == null) {
            if (swanAppConfigData == null) {
                if (a) {
                    zv2.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<dw2> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (xa2.m()) {
                    Iterator<dw2> it = i.iterator();
                    while (it.hasNext()) {
                        dw2 next = it.next();
                        Pair<Boolean, File> i2 = xa2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            hx1.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                fw2.c("dynamicLibPath", jSONObject3);
                fw2.c("dynamicLibConfig", jSONObject4);
                return;
            }
            fw2.c("dynamicLibPath", null);
            fw2.c("dynamicLibConfig", null);
            if (a) {
                zv2.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<dw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        dw2 dw2Var;
        File file;
        boolean z2;
        boolean z3;
        long j;
        long j2;
        long c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{list, jSONObject, jSONObject2, Boolean.valueOf(z)}) == null) || list == null || list.size() == 0) {
            return;
        }
        List<g94> w = c84.i().w(fw2.d(list));
        for (dw2 dw2Var2 : list) {
            File file2 = null;
            try {
                dw2Var = (dw2) dw2Var2.clone();
            } catch (CloneNotSupportedException e) {
                if (a) {
                    zv2.b(Log.getStackTraceString(e));
                }
                dw2Var = dw2Var2;
            }
            long j3 = 0;
            if (w != null) {
                j = 0;
                boolean z4 = false;
                z3 = true;
                boolean z5 = false;
                for (g94 g94Var : w) {
                    if (dw2Var2.a.equals(g94Var.g)) {
                        zv2.b("pluginName = " + dw2Var2.a + " latestPlugin versionCode = " + g94Var.i + " cur model versionCode = " + dw2Var2.c);
                        long j4 = dw2Var2.c;
                        if (j4 >= j3) {
                            c2 = g94Var.i;
                        } else {
                            c2 = wd3.c(g94Var.j);
                            j4 = wd3.c(dw2Var2.b);
                        }
                        if (c2 > j4) {
                            file2 = g(g94Var);
                            z5 = true;
                        }
                        if (z5) {
                            dw2Var.b = g94Var.j;
                            dw2Var.c = g94Var.i;
                        }
                        if (!g94Var.c()) {
                            zv2.b("plugin is new, not yet expired");
                            z3 = false;
                        }
                        j = Math.max(c2, j4);
                        j3 = 0;
                        z4 = true;
                    }
                }
                file = file2;
                z2 = z4;
            } else {
                file = null;
                z2 = false;
                z3 = true;
                j = 0;
            }
            if (z2) {
                j2 = j;
            } else {
                long j5 = dw2Var2.c;
                if (j5 < 0) {
                    j5 = wd3.c(dw2Var2.b);
                }
                j2 = j5;
            }
            o(jSONObject, jSONObject2, file, dw2Var2, j2);
            if (z3 && z) {
                s(dw2Var);
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, dw2 dw2Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, dw2Var, Long.valueOf(j)}) == null) || jSONObject == null || jSONObject2 == null || dw2Var == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (a) {
                zv2.b("apply path in workspace, name = " + dw2Var.a);
            }
        } else {
            str = dw2Var.e;
            if (a) {
                zv2.b("apply path inner swan app, name = " + dw2Var.a);
            }
        }
        try {
            jSONObject.put(dw2Var.a, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(dw2Var.f)) {
                return;
            }
            File file2 = new File(str, dw2Var.f);
            if (file2.exists()) {
                String E = jg4.E(file2);
                if (a) {
                    zv2.b("pages info = " + E);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, new JSONObject(E));
                jSONObject3.put(PushManager.APP_VERSION_CODE, j);
                jSONObject2.put(dw2Var.a, jSONObject3);
            }
        } catch (JSONException e) {
            if (a) {
                zv2.b(Log.getStackTraceString(e));
            }
        }
    }

    public static g94 p(String str, String str2, long j) {
        InterceptResult invokeCommon;
        String[] strArr;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (j >= 0) {
                strArr = new String[]{str, String.valueOf(j)};
                str3 = "bundle_id = ?  and version_code = ? ";
            } else if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str};
                str3 = "bundle_id = ? ";
            } else {
                String[] strArr2 = {str, str2};
                str3 = "bundle_id = ?  and version_name = ? ";
                strArr = strArr2;
            }
            List<g94> r = c84.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (g94) invokeCommon.objValue;
    }

    public static List<g94> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c84.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, dw2Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(dw2Var), "requestDynamicLib", 2);
        }
    }

    public static void s(dw2 dw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, dw2Var) == null) {
            tr1.d().c(new as1(new a(dw2Var)));
        }
    }
}
