package com.repackage;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.event.SwanJSVersionUpdateEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class p93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static a b;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static String b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? i == 1 ? "game-core-version-code" : "swan-core-version-code" : (String) invokeI.objValue;
        }

        public static String c(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i == 1 ? "game-core-version-name" : "swan-core-version-name" : (String) invokeI.objValue;
        }

        public static a f(JSONObject jSONObject, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, i)) == null) {
                a aVar = new a();
                if (jSONObject != null) {
                    aVar.a = jSONObject.optString(c(i));
                    aVar.b = jSONObject.optLong(b(i));
                }
                return aVar;
            }
            return (a) invokeLI.objValue;
        }

        public long d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.longValue;
        }

        public String e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.a) ? "0" : this.a : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755455129, "Lcom/repackage/p93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755455129, "Lcom/repackage/p93;");
                return;
            }
        }
        a = rg1.a;
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            hx1.k("PresetSwanCoreControl", "canPresetFolderWrite presetSavePath=" + str);
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                hx1.k("PresetSwanCoreControl", "canPresetFolderWrite mkdirs fail");
                return false;
            }
            boolean canWrite = file.canWrite();
            hx1.k("PresetSwanCoreControl", "canPresetFolderWrite canWrite=" + canWrite);
            return canWrite;
        }
        return invokeL.booleanValue;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            v83.a().putString(p(i), "0");
            v83.a().putLong(o(i), 0L);
        }
    }

    public static Exception c(a aVar, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, aVar, i)) == null) {
            hx1.k("PresetSwanCoreControl", "doPresetUpdate.");
            if (aVar == null) {
                return new Exception("preset swan config is null");
            }
            String h = h(i);
            String path = l(aVar.d(), i).getPath();
            if (!jg4.V(h, path)) {
                Exception exc = new Exception("PresetSwanCoreControl doPresetUpdate: failed by unzip file path = " + h);
                hx1.k("PresetSwanCoreControl", "doPresetUpdate unzip failed assetExists: " + sc3.a(AppRuntime.getAppContext(), h) + ParamableElem.DIVIDE_PARAM + exc);
                boolean a2 = a(path);
                if (i == 0 && Looper.myLooper() != Looper.getMainLooper() && !dj2.w() && !a2) {
                    hx1.k("PresetSwanCoreControl", "doSwanFolderFallback:start.");
                    dj2.e("swan_core" + File.separator + "preset" + File.separator + aVar.d());
                }
                return exc;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(aVar.d()));
            m93.b(j(i), arrayList);
            v83.a().putLong(o(i), aVar.d());
            v83.a().putString(p(i), aVar.e());
            if (i == 0) {
                SwanJSVersionUpdateEvent.sendEvent(aVar.d());
            }
            v(false, i);
            if (a) {
                String b2 = lg4.b(new File(h(i)), false);
                if (TextUtils.isEmpty(b2)) {
                    return null;
                }
                v83.a().putString(l93.d(i), b2);
                return null;
            }
            return null;
        }
        return (Exception) invokeLI.objValue;
    }

    public static a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (b == null) {
                b = a.f(u(0), 0);
            }
            return b;
        }
        return (a) invokeV.objValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) ? i == 1 ? "aigames/game-config.json" : "aiapps/swan-config.json" : (String) invokeI.objValue;
    }

    public static long f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) ? v83.a().getLong(o(i), 0L) : invokeI.longValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? v83.a().getString(p(i), "0") : (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? i == 1 ? "aigames/game-core.zip" : "aiapps/swan-core.zip" : (String) invokeI.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (c == null) {
                c = a.f(u(1), 1);
            }
            return c;
        }
        return (a) invokeV.objValue;
    }

    public static File j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? new File(m93.d(i), "preset") : (File) invokeI.objValue;
    }

    public static a k(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            if (i == 1) {
                return i();
            }
            return d();
        }
        return (a) invokeI.objValue;
    }

    public static File l(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) ? new File(j(i), String.valueOf(j)) : (File) invokeCommon.objValue;
    }

    public static SwanCoreVersion m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) {
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCoreType = 0;
            swanCoreVersion.swanCoreVersionCode = f(i);
            swanCoreVersion.swanCoreVersionName = g(i);
            swanCoreVersion.swanCorePath = l(swanCoreVersion.swanCoreVersionCode, i).getPath();
            return swanCoreVersion;
        }
        return (SwanCoreVersion) invokeI.objValue;
    }

    public static String n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i)) == null) ? i == 1 ? "aigames_preset_update_key" : "aiapps_preset_update_key" : (String) invokeI.objValue;
    }

    public static String o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) ? i == 1 ? "aigames_cur_preset_ver_key" : "aiapps_cur_preset_ver_key" : (String) invokeI.objValue;
    }

    public static String p(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) ? i == 1 ? "aigames_cur_preset_ver_name_key" : "aiapps_cur_preset_ver_name_key" : (String) invokeI.objValue;
    }

    public static boolean q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            if (k(i).b > 0) {
                return v83.a().getBoolean(n(i), false) || !m(i).isAvailable();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i)) == null) {
            return v83.a().getBoolean(i == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", false);
        }
        return invokeI.booleanValue;
    }

    public static synchronized void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65555, null, i) == null) {
            synchronized (p93.class) {
                a k = k(i);
                String h = h(i);
                String path = l(k.d(), i).getPath();
                boolean z = jg4.z(h, path);
                if (a) {
                    Log.d("PresetSwanCoreControl", "isZipAssetMatchUnzipResult:" + z + ",path:" + path);
                }
                if (!z) {
                    m93.m(0, i, k.d());
                    jg4.M(path);
                    jg4.V(h, path);
                }
            }
        }
    }

    public static synchronized Exception t(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) {
            synchronized (p93.class) {
                if (a) {
                    Log.d("PresetSwanCoreControl", "onPresetUpdate start.");
                }
                if (q(i)) {
                    a k = k(i);
                    long j = v83.a().getLong(h(i), 0L);
                    if (a) {
                        Log.d("PresetSwanCoreControl", "onPresetUpdate curVer: " + j + " newVer: " + k.e());
                    }
                    return c(k, i);
                }
                return null;
            }
        }
        return (Exception) invokeI.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static JSONObject u(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65557, null, i)) == null) {
            if (a) {
                Log.d("PresetSwanCoreControl", "readPresetConfig start.");
            }
            String D = jg4.D(AppRuntime.getAppContext(), e(i));
            if (TextUtils.isEmpty(D)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(D);
                if (a) {
                    Log.d("PresetSwanCoreControl", "readPresetConfig end. config: " + jSONObject.toString());
                }
                return jSONObject;
            } catch (JSONException e) {
                if (a) {
                    throw new RuntimeException(e);
                }
                return null;
            }
        }
        return (JSONObject) invokeI.objValue;
    }

    public static void v(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            v83.a().putBoolean(n(i), z);
        }
    }

    public static void w(boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            v83.a().putBoolean(i == 1 ? "aigames_preset_checked_key" : "aiapps_preset_checked_key", z);
        }
    }
}
