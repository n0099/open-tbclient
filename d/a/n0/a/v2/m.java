package d.a.n0.a.v2;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.n2.c.a;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class m {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f48051a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends d.a.n0.a.v1.a.b.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f48052c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f48053d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.v2.e1.b f48054e;

        /* renamed from: d.a.n0.a.v2.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0954a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f48055e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f48056f;

            public RunnableC0954a(a aVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f48056f = aVar;
                this.f48055e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        m.f(jSONObject, this.f48055e, this.f48056f.f48052c, this.f48056f.f48053d);
                    } catch (Exception e2) {
                        w.f(jSONObject, "errorMsg", e2.getMessage());
                    }
                    this.f48056f.f48054e.onCallback(jSONObject);
                }
            }
        }

        public a(int i2, long j, d.a.n0.a.v2.e1.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j), bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48052c = i2;
            this.f48053d = j;
            this.f48054e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v1.a.b.c.b, d.a.n0.a.v1.a.b.c.c, d.a.n0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.n0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0954a(this, bVar.a() == null ? -1 : bVar.a().getInt("net_quality")), "getDeviceInfoAsync", 2);
            }
        }
    }

    public m() {
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

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? new DecimalFormat("#.##").format(j / 1.073741824E9d) : (String) invokeJ.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(f48051a)) {
                synchronized (m.class) {
                    f48051a = e();
                }
            }
            return f48051a;
        }
        return (String) invokeV.objValue;
    }

    public static void d(@NonNull d.a.n0.a.f1.e.b bVar, @NonNull d.a.n0.a.v2.e1.b<JSONObject> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bVar, bVar2) == null) {
            d.a.n0.a.a2.d.g().z().L(null, d.a.n0.a.n1.m.class, new a(bVar.i("host_launch_type"), bVar.k("box_cold_launch"), bVar2));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            String str = Build.MODEL;
            String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
            String str2 = Build.VERSION.RELEASE;
            String replace2 = TextUtils.isEmpty(str2) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str2.replace("_", "-");
            int i2 = Build.VERSION.SDK_INT;
            String str3 = Build.MANUFACTURER;
            String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
            return replace + "_" + replace2 + "_" + i2 + "_" + replace3;
        }
        return (String) invokeV.objValue;
    }

    public static void f(@NonNull JSONObject jSONObject, int i2, int i3, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{jSONObject, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j)}) == null) {
            w.f(jSONObject, "model", Build.MODEL);
            w.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            w.f(jSONObject, "netStatus", Integer.valueOf(i2));
            a.C0838a a2 = d.a.n0.a.n2.c.a.a(d.a.n0.a.c1.a.b());
            w.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.f46420a));
            w.f(jSONObject, "appCurVersion", q0.D());
            w.f(jSONObject, "startupType", String.valueOf(i3));
            w.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(d.a.n0.a.a1.e.i());
            w.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            w.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) d.a.n0.a.a2.d.g().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                w.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                w.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                w.f(jSONObject, "lowMemory", memoryInfo.lowMemory ? "1" : "0");
            }
        }
    }
}
