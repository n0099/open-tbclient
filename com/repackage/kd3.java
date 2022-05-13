package com.repackage;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.na3;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kd3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ nf3 c;

        public a(int i, long j, nf3 nf3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), nf3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = nf3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    kd3.f(jSONObject, hs2.b(), this.a, this.b);
                } catch (Exception e) {
                    ud3.f(jSONObject, "errorMsg", e.getMessage());
                }
                this.c.onCallback(jSONObject);
            }
        }
    }

    public kd3() {
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

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? new DecimalFormat("#.##").format(j / 1.073741824E9d) : (String) invokeJ.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                synchronized (kd3.class) {
                    a = e();
                }
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(@NonNull rl2 rl2Var, @NonNull nf3<JSONObject> nf3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, rl2Var, nf3Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(rl2Var.i("host_launch_type"), rl2Var.k("box_cold_launch"), nf3Var), "getDeviceInfoAsync", 2);
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = Build.MODEL;
            String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
            String str2 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str2) ? "0.0" : str2.replace("_", "-");
            int i = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
            return replace + "_" + replace2 + "_" + i + "_" + replace3;
        }
        return (String) invokeV.objValue;
    }

    public static void f(@NonNull JSONObject jSONObject, int i, int i2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            ud3.f(jSONObject, "model", Build.MODEL);
            ud3.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            ud3.f(jSONObject, "netStatus", Integer.valueOf(i));
            na3.a a2 = na3.a(bk2.c());
            ud3.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.a));
            ud3.f(jSONObject, "appCurVersion", oe3.D());
            ud3.f(jSONObject, "startupType", String.valueOf(i2));
            ud3.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(qj2.i());
            ud3.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            ud3.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) t03.J().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                ud3.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                ud3.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                ud3.f(jSONObject, "lowMemory", memoryInfo.lowMemory ? "1" : "0");
            }
        }
    }
}
