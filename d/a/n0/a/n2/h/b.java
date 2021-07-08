package d.a.n0.a.n2.h;

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
import d.a.n0.a.g1.g;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import d.a.n0.a.v2.w;
import d.a.n0.a.z1.b.b.h;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f46454a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f46455b;

    /* renamed from: c  reason: collision with root package name */
    public static final long f46456c;

    /* renamed from: d  reason: collision with root package name */
    public static final long f46457d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f46458e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f46459f;

    /* renamed from: g  reason: collision with root package name */
    public static long f46460g;

    /* renamed from: h  reason: collision with root package name */
    public static long f46461h;

    /* renamed from: i  reason: collision with root package name */
    public static h f46462i;
    public static ActivityManager j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f46463e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f46464f;

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
            this.f46463e = j;
            this.f46464f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.p(this.f46463e, this.f46464f);
            }
        }
    }

    /* renamed from: d.a.n0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class DialogInterface$OnClickListenerC0843b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f46465e;

        public DialogInterface$OnClickListenerC0843b(Activity activity) {
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
            this.f46465e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                b.h("memory_alert_exit", null);
                h unused = b.f46462i = null;
                this.f46465e.moveTaskToBack(true);
                d.a.n0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes7.dex */
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
                h unused = b.f46462i = null;
                d.a.n0.a.n2.h.a.a();
            }
        }
    }

    /* loaded from: classes7.dex */
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
                if (b.f46462i != null && b.f46462i.isShowing()) {
                    b.f46462i.dismiss();
                }
                h unused = b.f46462i = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class e implements d.a.n0.a.v2.e1.b<HybridUbcFlow> {
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
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hybridUbcFlow) == null) {
                boolean z = !d.a.n0.a.r1.m.c.a(hybridUbcFlow);
                if (b.f46454a) {
                    Log.d("MemoryWarningReminder", "startUpSuccess:" + z);
                }
                if (z) {
                    b.f46458e.set(true);
                    long unused = b.f46459f = System.currentTimeMillis();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1405511957, "Ld/a/n0/a/n2/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1405511957, "Ld/a/n0/a/n2/h/b;");
                return;
            }
        }
        f46454a = k.f45831a;
        f46455b = TimeUnit.SECONDS.toMillis(d.a.n0.a.r1.l.b.f());
        f46456c = TimeUnit.SECONDS.toMillis(d.a.n0.a.r1.l.b.e());
        f46457d = TimeUnit.SECONDS.toMillis(d.a.n0.a.r1.l.b.i());
        f46458e = new AtomicBoolean(false);
        f46459f = 0L;
        f46460g = 0L;
        f46461h = 0L;
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
            d.a.n0.a.j2.p.e eVar = new d.a.n0.a.j2.p.e();
            eVar.f45817a = "swan";
            eVar.f45818b = str;
            eVar.f45822f = d.a.n0.a.a2.d.g().getAppId();
            eVar.e(jSONObject);
            eVar.a("start_timestamp", Long.valueOf(f46459f));
            eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
            eVar.a("launchid", d.a.n0.a.a2.d.g().r().L().V());
            d.a.n0.a.j2.k.u("1619", eVar);
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
                j = (ActivityManager) d.a.n0.a.a2.d.g().getSystemService("activity");
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
            if (f46454a) {
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
        if ((interceptable == null || interceptable.invokeI(65549, null, i2) == null) && d.a.n0.a.r1.l.b.o() && f46458e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f46460g;
            long j3 = currentTimeMillis - f46461h;
            if (j2 < f46457d) {
                if (f46454a) {
                    Log.d("MemoryWarningReminder", "ReceiveInterval:" + j2 + ",FilterInterval:" + f46457d);
                    return;
                }
                return;
            }
            boolean z = j2 < f46455b && j3 > f46456c && k() > ((long) d.a.n0.a.r1.l.b.g());
            if (f46454a) {
                Log.d("MemoryWarningReminder", "SwanApp:" + d.a.n0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f46455b + ",getMemoryWarningAlterInterval:" + f46456c);
                StringBuilder sb = new StringBuilder();
                sb.append("ReceiveInterval:");
                sb.append(j2);
                sb.append(",AlterInterval:");
                sb.append(j3);
                sb.append(",UsedMemoryRatioLimit:");
                sb.append(d.a.n0.a.r1.l.b.g());
                Log.d("MemoryWarningReminder", sb.toString());
            }
            f46460g = currentTimeMillis;
            if (z) {
                f46461h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, null) == null) {
            o();
            f46461h = 0L;
            j = null;
        }
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, null) == null) {
            f46458e.set(false);
            f46459f = 0L;
            f46460g = 0L;
            d.a.n0.a.n2.h.a.c();
            q0.b0(new d());
        }
    }

    @UiThread
    public static void p(long j2, long j3) {
        SwanAppActivity x;
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || (x = d.a.n0.a.a2.d.g().r().x()) == null) {
            return;
        }
        h hVar2 = f46462i;
        if (hVar2 != null && hVar2.isShowing()) {
            f46462i.dismiss();
            f46462i = null;
        }
        boolean z = !d.a.n0.a.r1.l.b.n();
        if (z && f46462i == null) {
            h.a aVar = new h.a(x);
            aVar.n(new d.a.n0.a.w2.h.a());
            aVar.J(d.a.n0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(d.a.n0.a.h.swanapp_low_memory_tip);
            aVar.B(d.a.n0.a.h.swanapp_low_memory_button_continue, new c());
            aVar.O(d.a.n0.a.h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0843b(x));
            f46462i = aVar.c();
        }
        if (z && (hVar = f46462i) != null) {
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
        d.a.n0.a.n2.h.a.a();
    }
}
