package d.a.q0.a.n2.h;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.g1.g;
import d.a.q0.a.k;
import d.a.q0.a.v2.q0;
import d.a.q0.a.v2.w;
import d.a.q0.a.z1.b.b.h;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49756a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f49757b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f49758c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f49759d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f49760e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f49761f;

    /* renamed from: g  reason: collision with root package name */
    public static long f49762g;

    /* renamed from: h  reason: collision with root package name */
    public static long f49763h;

    /* renamed from: i  reason: collision with root package name */
    public static h f49764i;
    public static ActivityManager j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f49765e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f49766f;

        public a(long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49765e = j;
            this.f49766f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.p(this.f49765e, this.f49766f);
            }
        }
    }

    /* renamed from: d.a.q0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class DialogInterface$OnClickListenerC0894b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f49767e;

        public DialogInterface$OnClickListenerC0894b(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49767e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_exit", null);
                h unused = b.f49764i = null;
                this.f49767e.moveTaskToBack(true);
                d.a.q0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_continue", null);
                dialogInterface.dismiss();
                h unused = b.f49764i = null;
                d.a.q0.a.n2.h.a.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.f49764i != null && b.f49764i.isShowing()) {
                    b.f49764i.dismiss();
                }
                h unused = b.f49764i = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class e implements d.a.q0.a.v2.e1.b<HybridUbcFlow> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                boolean z = !d.a.q0.a.r1.m.c.a(hybridUbcFlow);
                if (b.f49756a) {
                    Log.d("MemoryWarningReminder", "startUpSuccess:" + z);
                }
                if (z) {
                    b.f49760e.set(true);
                    long unused = b.f49761f = System.currentTimeMillis();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1792760114, "Ld/a/q0/a/n2/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1792760114, "Ld/a/q0/a/n2/h/b;");
                return;
            }
        }
        f49756a = k.f49133a;
        f49757b = TimeUnit.SECONDS.toMillis(d.a.q0.a.r1.l.b.f());
        f49758c = TimeUnit.SECONDS.toMillis(d.a.q0.a.r1.l.b.e());
        f49759d = TimeUnit.SECONDS.toMillis(d.a.q0.a.r1.l.b.i());
        f49760e = new AtomicBoolean(false);
        f49761f = 0L;
        f49762g = 0L;
        f49763h = 0L;
    }

    public static void g(JSONObject jSONObject) {
        ActivityManager j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jSONObject) == null) || (j2 = j()) == null) {
            return;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        j2.getMemoryInfo(memoryInfo);
        w.f(jSONObject, "memory_total", i(memoryInfo.totalMem));
        w.f(jSONObject, "memory_used", i(memoryInfo.totalMem - memoryInfo.availMem));
    }

    public static void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, jSONObject) == null) {
            d.a.q0.a.j2.p.e eVar = new d.a.q0.a.j2.p.e();
            eVar.f49119a = "swan";
            eVar.f49120b = str;
            eVar.f49124f = d.a.q0.a.a2.d.g().getAppId();
            eVar.e(jSONObject);
            eVar.a("start_timestamp", Long.valueOf(f49761f));
            eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
            eVar.a("launchid", d.a.q0.a.a2.d.g().r().L().V());
            d.a.q0.a.j2.k.u("1619", eVar);
        }
    }

    public static String i(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65545, null, j2)) == null) {
            return new DecimalFormat("#.##").format(j2 / 1.073741824E9d) + "GB";
        }
        return (String) invokeJ.objValue;
    }

    public static ActivityManager j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (j == null) {
                j = (ActivityManager) d.a.q0.a.a2.d.g().getSystemService("activity");
            }
            return j;
        }
        return (ActivityManager) invokeV.objValue;
    }

    public static long k() {
        InterceptResult invokeV;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            ActivityManager j3 = j();
            if (j3 != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                j3.getMemoryInfo(memoryInfo);
                long j4 = memoryInfo.totalMem;
                j2 = ((j4 - memoryInfo.availMem) * 100) / j4;
            } else {
                j2 = 0;
            }
            if (f49756a) {
                Log.d("MemoryWarningReminder", "usedMemoryRatio:" + j2);
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public static boolean l(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65548, null, i2)) == null) ? i2 == 15 : invokeI.booleanValue;
    }

    public static void m(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65549, null, i2) == null) && d.a.q0.a.r1.l.b.o() && f49760e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f49762g;
            long j3 = currentTimeMillis - f49763h;
            if (j2 < f49759d) {
                if (f49756a) {
                    Log.d("MemoryWarningReminder", "ReceiveInterval:" + j2 + ",FilterInterval:" + f49759d);
                    return;
                }
                return;
            }
            boolean z = j2 < f49757b && j3 > f49758c && k() > ((long) d.a.q0.a.r1.l.b.g());
            if (f49756a) {
                Log.d("MemoryWarningReminder", "SwanApp:" + d.a.q0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f49757b + ",getMemoryWarningAlterInterval:" + f49758c);
                StringBuilder sb = new StringBuilder();
                sb.append("ReceiveInterval:");
                sb.append(j2);
                sb.append(",AlterInterval:");
                sb.append(j3);
                sb.append(",UsedMemoryRatioLimit:");
                sb.append(d.a.q0.a.r1.l.b.g());
                Log.d("MemoryWarningReminder", sb.toString());
            }
            f49762g = currentTimeMillis;
            if (z) {
                f49763h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            o();
            f49763h = 0L;
            j = null;
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            f49760e.set(false);
            f49761f = 0L;
            f49762g = 0L;
            d.a.q0.a.n2.h.a.c();
            q0.b0(new d());
        }
    }

    @UiThread
    public static void p(long j2, long j3) {
        SwanAppActivity x;
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (x = d.a.q0.a.a2.d.g().r().x()) == null) {
            return;
        }
        h hVar2 = f49764i;
        if (hVar2 != null && hVar2.isShowing()) {
            f49764i.dismiss();
            f49764i = null;
        }
        boolean z = !d.a.q0.a.r1.l.b.n();
        if (z && f49764i == null) {
            h.a aVar = new h.a(x);
            aVar.n(new d.a.q0.a.w2.h.a());
            aVar.J(d.a.q0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(d.a.q0.a.h.swanapp_low_memory_tip);
            aVar.B(d.a.q0.a.h.swanapp_low_memory_button_continue, new c());
            aVar.O(d.a.q0.a.h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0894b(x));
            f49764i = aVar.c();
        }
        if (z && (hVar = f49764i) != null) {
            hVar.show();
        }
        JSONObject jSONObject = new JSONObject();
        w.f(jSONObject, "receive_warning_interval", Long.valueOf(j2));
        w.f(jSONObject, "alter_interval", Long.valueOf(j3));
        g(jSONObject);
        h("memory_alert_show", jSONObject);
        if (z) {
            return;
        }
        d.a.q0.a.n2.h.a.a();
    }
}
