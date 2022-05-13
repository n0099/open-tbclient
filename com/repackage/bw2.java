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
import com.repackage.ns1;
import com.repackage.rb4;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ns1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw2 a;

        public a(qw2 qw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw2Var;
        }

        @Override // com.repackage.ns1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bw2.r(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qw2 a;

        public b(qw2 qw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bw2.c(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements g22<Boolean> {
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
        @Override // com.repackage.g22
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                mw2.b("download plugin result = " + bool);
                nw2.b(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755812652, "Lcom/repackage/bw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755812652, "Lcom/repackage/bw2;");
                return;
            }
        }
        a = eh1.a;
    }

    public static void c(qw2 qw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, qw2Var) == null) {
            if (qw2Var != null && qw2Var.a()) {
                String str = qw2Var.a;
                String str2 = qw2Var.b;
                long j = qw2Var.c;
                c84.g(new vb4(str, str2, j, qw2Var.d), new aw2(str, str2, j, new c(str)));
                return;
            }
            mw2.b("plugin is invalid");
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
                String i = sw2.i("dependenciesPath", null);
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
                    mw2.b(Log.getStackTraceString(e));
                    return null;
                }
            }
            return null;
        }
        return (File) invokeL.objValue;
    }

    public static List<l94> e(String str, long j) {
        InterceptResult invokeLJ;
        SwanAppConfigData.d dVar;
        List<ow2> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, str, j)) == null) {
            SwanAppConfigData b2 = ml2.b(qj2.v(str, String.valueOf(j), false, null, null));
            if (b2 == null || (dVar = b2.k) == null || (list = dVar.a) == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (ow2 ow2Var : b2.k.a) {
                l94 l94Var = new l94();
                l94Var.a = ow2Var.a;
                l94Var.b = ow2Var.g;
                l94Var.c = ow2Var.c;
                l94Var.e = ow2Var.i;
                l94Var.d = ow2Var.h;
                arrayList.add(l94Var);
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
                String i = sw2.i("dependenciesConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    mw2.b(Log.getStackTraceString(e));
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

    public static File g(@Nullable t94 t94Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, t94Var)) == null) {
            if (t94Var == null) {
                return null;
            }
            File t = qj2.t(t94Var.g, String.valueOf(t94Var.i));
            return (t == null || !t.exists()) ? qj2.t(t94Var.g, String.valueOf(je3.c(t94Var.j))) : t;
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
                String i = sw2.i("dynamicLibConfig", null);
                if (TextUtils.isEmpty(i)) {
                    return null;
                }
                try {
                    optJSONObject = new JSONObject(i).optJSONObject(str2);
                } catch (JSONException e) {
                    mw2.b(Log.getStackTraceString(e));
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

    public static Set<rb4.a> i(PMSAppInfo pMSAppInfo) {
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

    public static Set<rb4.a> j(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65546, null, str, j)) == null) {
            List<l94> l = d84.b().l(str, j);
            if (l == null || l.isEmpty()) {
                return null;
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (l94 l94Var : l) {
                if (!l94Var.b && yd4.b(l94Var.a, l94Var.d, l94Var.e, arrayList) == null) {
                    rb4.a aVar = new rb4.a(l94Var.a);
                    aVar.f(l94Var.d, l94Var.e);
                    hashSet.add(aVar);
                }
            }
            if (!arrayList.isEmpty()) {
                p84.i().g(arrayList);
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
                    mw2.b("parse app.json is null");
                    return;
                }
                return;
            }
            List<qw2> i = swanAppConfigData.i(3);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                if (kb2.m()) {
                    Iterator<qw2> it = i.iterator();
                    while (it.hasNext()) {
                        qw2 next = it.next();
                        Pair<Boolean, File> i2 = kb2.i(next.a);
                        if (((Boolean) i2.first).booleanValue()) {
                            ux1.k("SwanDynamicUtil", "优先使用 Debug 动态库: " + ((File) i2.second).getAbsolutePath());
                            o(jSONObject, jSONObject2, (File) i2.second, next, -1L);
                            it.remove();
                        }
                    }
                }
                n(i, jSONObject, jSONObject2, z);
                String jSONObject3 = jSONObject.toString();
                String jSONObject4 = jSONObject2.toString();
                sw2.c("dynamicLibPath", jSONObject3);
                sw2.c("dynamicLibConfig", jSONObject4);
                return;
            }
            sw2.c("dynamicLibPath", null);
            sw2.c("dynamicLibConfig", null);
            if (a) {
                mw2.b("this swan app not apply on someone dynamic lib");
            }
        }
    }

    public static void n(@NonNull List<qw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, boolean z) {
        qw2 qw2Var;
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
        List<t94> w = p84.i().w(sw2.d(list));
        for (qw2 qw2Var2 : list) {
            File file2 = null;
            try {
                qw2Var = (qw2) qw2Var2.clone();
            } catch (CloneNotSupportedException e) {
                if (a) {
                    mw2.b(Log.getStackTraceString(e));
                }
                qw2Var = qw2Var2;
            }
            long j3 = 0;
            if (w != null) {
                j = 0;
                boolean z4 = false;
                z3 = true;
                boolean z5 = false;
                for (t94 t94Var : w) {
                    if (qw2Var2.a.equals(t94Var.g)) {
                        mw2.b("pluginName = " + qw2Var2.a + " latestPlugin versionCode = " + t94Var.i + " cur model versionCode = " + qw2Var2.c);
                        long j4 = qw2Var2.c;
                        if (j4 >= j3) {
                            c2 = t94Var.i;
                        } else {
                            c2 = je3.c(t94Var.j);
                            j4 = je3.c(qw2Var2.b);
                        }
                        if (c2 > j4) {
                            file2 = g(t94Var);
                            z5 = true;
                        }
                        if (z5) {
                            qw2Var.b = t94Var.j;
                            qw2Var.c = t94Var.i;
                        }
                        if (!t94Var.c()) {
                            mw2.b("plugin is new, not yet expired");
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
                long j5 = qw2Var2.c;
                if (j5 < 0) {
                    j5 = je3.c(qw2Var2.b);
                }
                j2 = j5;
            }
            o(jSONObject, jSONObject2, file, qw2Var2, j2);
            if (z3 && z) {
                s(qw2Var);
            }
        }
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2, File file, qw2 qw2Var, long j) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{jSONObject, jSONObject2, file, qw2Var, Long.valueOf(j)}) == null) || jSONObject == null || jSONObject2 == null || qw2Var == null) {
            return;
        }
        if (file != null && file.exists()) {
            str = file.getAbsolutePath();
            if (a) {
                mw2.b("apply path in workspace, name = " + qw2Var.a);
            }
        } else {
            str = qw2Var.e;
            if (a) {
                mw2.b("apply path inner swan app, name = " + qw2Var.a);
            }
        }
        try {
            jSONObject.put(qw2Var.a, str);
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(qw2Var.f)) {
                return;
            }
            File file2 = new File(str, qw2Var.f);
            if (file2.exists()) {
                String E = xg4.E(file2);
                if (a) {
                    mw2.b("pages info = " + E);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, new JSONObject(E));
                jSONObject3.put(PushManager.APP_VERSION_CODE, j);
                jSONObject2.put(qw2Var.a, jSONObject3);
            }
        } catch (JSONException e) {
            if (a) {
                mw2.b(Log.getStackTraceString(e));
            }
        }
    }

    public static t94 p(String str, String str2, long j) {
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
            List<t94> r = p84.i().r(str3, strArr);
            if (r == null || r.size() <= 0) {
                return null;
            }
            return r.get(0);
        }
        return (t94) invokeCommon.objValue;
    }

    public static List<t94> q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return p84.i().r("bundle_id = ? ", new String[]{str});
        }
        return (List) invokeL.objValue;
    }

    public static void r(qw2 qw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, qw2Var) == null) {
            ExecutorUtilsExt.postOnElastic(new b(qw2Var), "requestDynamicLib", 2);
        }
    }

    public static void s(qw2 qw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, qw2Var) == null) {
            gs1.d().c(new ns1(new a(qw2Var)));
        }
    }
}
