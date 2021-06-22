package d.a.m0.a.v2;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.XAdSDKPorxyConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import d.a.m0.a.n2.c.a;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f49207a;

    /* loaded from: classes3.dex */
    public static class a extends d.a.m0.a.v1.a.b.c.b {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f49208c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ long f49209d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.v2.e1.b f49210e;

        /* renamed from: d.a.m0.a.v2.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0945a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f49211e;

            public RunnableC0945a(int i2) {
                this.f49211e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    m.f(jSONObject, this.f49211e, a.this.f49208c, a.this.f49209d);
                } catch (Exception e2) {
                    w.f(jSONObject, "errorMsg", e2.getMessage());
                }
                a.this.f49210e.onCallback(jSONObject);
            }
        }

        public a(int i2, long j, d.a.m0.a.v2.e1.b bVar) {
            this.f49208c = i2;
            this.f49209d = j;
            this.f49210e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v1.a.b.c.b, d.a.m0.a.v1.a.b.c.c, d.a.m0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.m0.a.v1.a.b.a.b bVar) {
            ExecutorUtilsExt.postOnElastic(new RunnableC0945a(bVar.a() == null ? -1 : bVar.a().getInt("net_quality")), "getDeviceInfoAsync", 2);
        }
    }

    public static String b(long j) {
        return new DecimalFormat("#.##").format(j / 1.073741824E9d);
    }

    public static String c() {
        if (TextUtils.isEmpty(f49207a)) {
            synchronized (m.class) {
                f49207a = e();
            }
        }
        return f49207a;
    }

    public static void d(@NonNull d.a.m0.a.f1.e.b bVar, @NonNull d.a.m0.a.v2.e1.b<JSONObject> bVar2) {
        d.a.m0.a.a2.d.g().z().L(null, d.a.m0.a.n1.m.class, new a(bVar.i("host_launch_type"), bVar.k("box_cold_launch"), bVar2));
    }

    public static String e() {
        String str = Build.MODEL;
        String replace = TextUtils.isEmpty(str) ? "NUL" : str.replace("_", "-");
        String str2 = Build.VERSION.RELEASE;
        String replace2 = TextUtils.isEmpty(str2) ? XAdSDKPorxyConfig.REMOTE_VERSION_DEFAULT : str2.replace("_", "-");
        int i2 = Build.VERSION.SDK_INT;
        String str3 = Build.MANUFACTURER;
        String replace3 = TextUtils.isEmpty(str3) ? "NUL" : str3.replace("_", "-");
        return replace + "_" + replace2 + "_" + i2 + "_" + replace3;
    }

    public static void f(@NonNull JSONObject jSONObject, int i2, int i3, long j) {
        w.f(jSONObject, "model", Build.MODEL);
        w.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
        w.f(jSONObject, "netStatus", Integer.valueOf(i2));
        a.C0829a a2 = d.a.m0.a.n2.c.a.a(d.a.m0.a.c1.a.b());
        w.f(jSONObject, "batteryLevel", Integer.valueOf(a2 == null ? -1 : a2.f47576a));
        w.f(jSONObject, "appCurVersion", q0.D());
        w.f(jSONObject, "startupType", String.valueOf(i3));
        w.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
        StatFs statFs = new StatFs(d.a.m0.a.a1.e.i());
        w.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
        w.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
        ActivityManager activityManager = (ActivityManager) d.a.m0.a.a2.d.g().getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            w.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
            w.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
            w.f(jSONObject, "lowMemory", memoryInfo.lowMemory ? "1" : "0");
        }
    }
}
