package d.a.m0.a.n2.h;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.m0.a.g1.g;
import d.a.m0.a.k;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import d.a.m0.a.z1.b.b.h;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47610a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f47611b = TimeUnit.SECONDS.toMillis(d.a.m0.a.r1.l.b.f());

    /* renamed from: c  reason: collision with root package name */
    public static final long f47612c = TimeUnit.SECONDS.toMillis(d.a.m0.a.r1.l.b.e());

    /* renamed from: d  reason: collision with root package name */
    public static final long f47613d = TimeUnit.SECONDS.toMillis(d.a.m0.a.r1.l.b.i());

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f47614e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f47615f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static long f47616g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f47617h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static h f47618i;
    public static ActivityManager j;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f47620f;

        public a(long j, long j2) {
            this.f47619e = j;
            this.f47620f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.p(this.f47619e, this.f47620f);
        }
    }

    /* renamed from: d.a.m0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnClickListenerC0834b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47621e;

        public DialogInterface$OnClickListenerC0834b(Activity activity) {
            this.f47621e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_exit", null);
            h unused = b.f47618i = null;
            this.f47621e.moveTaskToBack(true);
            d.a.m0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_continue", null);
            dialogInterface.dismiss();
            h unused = b.f47618i = null;
            d.a.m0.a.n2.h.a.a();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f47618i != null && b.f47618i.isShowing()) {
                b.f47618i.dismiss();
            }
            h unused = b.f47618i = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements d.a.m0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            boolean z = !d.a.m0.a.r1.m.c.a(hybridUbcFlow);
            if (b.f47610a) {
                Log.d("MemoryWarningReminder", "startUpSuccess:" + z);
            }
            if (z) {
                b.f47614e.set(true);
                long unused = b.f47615f = System.currentTimeMillis();
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        ActivityManager j2 = j();
        if (j2 != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            j2.getMemoryInfo(memoryInfo);
            w.f(jSONObject, "memory_total", i(memoryInfo.totalMem));
            w.f(jSONObject, "memory_used", i(memoryInfo.totalMem - memoryInfo.availMem));
        }
    }

    public static void h(String str, JSONObject jSONObject) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46969a = "swan";
        eVar.f46970b = str;
        eVar.f46974f = d.a.m0.a.a2.d.g().getAppId();
        eVar.e(jSONObject);
        eVar.a("start_timestamp", Long.valueOf(f47615f));
        eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
        eVar.a("launchid", d.a.m0.a.a2.d.g().r().L().V());
        d.a.m0.a.j2.k.u("1619", eVar);
    }

    public static String i(long j2) {
        return new DecimalFormat("#.##").format(j2 / 1.073741824E9d) + "GB";
    }

    public static ActivityManager j() {
        if (j == null) {
            j = (ActivityManager) d.a.m0.a.a2.d.g().getSystemService("activity");
        }
        return j;
    }

    public static long k() {
        long j2;
        ActivityManager j3 = j();
        if (j3 != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            j3.getMemoryInfo(memoryInfo);
            long j4 = memoryInfo.totalMem;
            j2 = ((j4 - memoryInfo.availMem) * 100) / j4;
        } else {
            j2 = 0;
        }
        if (f47610a) {
            Log.d("MemoryWarningReminder", "usedMemoryRatio:" + j2);
        }
        return j2;
    }

    public static boolean l(int i2) {
        return i2 == 15;
    }

    public static void m(int i2) {
        if (d.a.m0.a.r1.l.b.o() && f47614e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f47616g;
            long j3 = currentTimeMillis - f47617h;
            if (j2 < f47613d) {
                if (f47610a) {
                    Log.d("MemoryWarningReminder", "ReceiveInterval:" + j2 + ",FilterInterval:" + f47613d);
                    return;
                }
                return;
            }
            boolean z = j2 < f47611b && j3 > f47612c && k() > ((long) d.a.m0.a.r1.l.b.g());
            if (f47610a) {
                Log.d("MemoryWarningReminder", "SwanApp:" + d.a.m0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f47611b + ",getMemoryWarningAlterInterval:" + f47612c);
                StringBuilder sb = new StringBuilder();
                sb.append("ReceiveInterval:");
                sb.append(j2);
                sb.append(",AlterInterval:");
                sb.append(j3);
                sb.append(",UsedMemoryRatioLimit:");
                sb.append(d.a.m0.a.r1.l.b.g());
                Log.d("MemoryWarningReminder", sb.toString());
            }
            f47616g = currentTimeMillis;
            if (z) {
                f47617h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        o();
        f47617h = 0L;
        j = null;
    }

    public static void o() {
        f47614e.set(false);
        f47615f = 0L;
        f47616g = 0L;
        d.a.m0.a.n2.h.a.c();
        q0.b0(new d());
    }

    @UiThread
    public static void p(long j2, long j3) {
        h hVar;
        SwanAppActivity x = d.a.m0.a.a2.d.g().r().x();
        if (x == null) {
            return;
        }
        h hVar2 = f47618i;
        if (hVar2 != null && hVar2.isShowing()) {
            f47618i.dismiss();
            f47618i = null;
        }
        boolean z = !d.a.m0.a.r1.l.b.n();
        if (z && f47618i == null) {
            h.a aVar = new h.a(x);
            aVar.n(new d.a.m0.a.w2.h.a());
            aVar.J(d.a.m0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(d.a.m0.a.h.swanapp_low_memory_tip);
            aVar.B(d.a.m0.a.h.swanapp_low_memory_button_continue, new c());
            aVar.O(d.a.m0.a.h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0834b(x));
            f47618i = aVar.c();
        }
        if (z && (hVar = f47618i) != null) {
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
        d.a.m0.a.n2.h.a.a();
    }
}
