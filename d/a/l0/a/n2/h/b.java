package d.a.l0.a.n2.h;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.l0.a.g1.g;
import d.a.l0.a.k;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
import d.a.l0.a.z1.b.b.h;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47502a = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f47503b = TimeUnit.SECONDS.toMillis(d.a.l0.a.r1.l.b.f());

    /* renamed from: c  reason: collision with root package name */
    public static final long f47504c = TimeUnit.SECONDS.toMillis(d.a.l0.a.r1.l.b.e());

    /* renamed from: d  reason: collision with root package name */
    public static final long f47505d = TimeUnit.SECONDS.toMillis(d.a.l0.a.r1.l.b.i());

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f47506e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f47507f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static long f47508g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f47509h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static h f47510i;
    public static ActivityManager j;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f47511e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f47512f;

        public a(long j, long j2) {
            this.f47511e = j;
            this.f47512f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.p(this.f47511e, this.f47512f);
        }
    }

    /* renamed from: d.a.l0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnClickListenerC0831b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f47513e;

        public DialogInterface$OnClickListenerC0831b(Activity activity) {
            this.f47513e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_exit", null);
            h unused = b.f47510i = null;
            this.f47513e.moveTaskToBack(true);
            d.a.l0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_continue", null);
            dialogInterface.dismiss();
            h unused = b.f47510i = null;
            d.a.l0.a.n2.h.a.a();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f47510i != null && b.f47510i.isShowing()) {
                b.f47510i.dismiss();
            }
            h unused = b.f47510i = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements d.a.l0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            boolean z = !d.a.l0.a.r1.m.c.a(hybridUbcFlow);
            if (b.f47502a) {
                Log.d("MemoryWarningReminder", "startUpSuccess:" + z);
            }
            if (z) {
                b.f47506e.set(true);
                long unused = b.f47507f = System.currentTimeMillis();
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
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46861a = "swan";
        eVar.f46862b = str;
        eVar.f46866f = d.a.l0.a.a2.d.g().getAppId();
        eVar.e(jSONObject);
        eVar.a("start_timestamp", Long.valueOf(f47507f));
        eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
        eVar.a("launchid", d.a.l0.a.a2.d.g().r().L().V());
        d.a.l0.a.j2.k.u("1619", eVar);
    }

    public static String i(long j2) {
        return new DecimalFormat("#.##").format(j2 / 1.073741824E9d) + "GB";
    }

    public static ActivityManager j() {
        if (j == null) {
            j = (ActivityManager) d.a.l0.a.a2.d.g().getSystemService("activity");
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
        if (f47502a) {
            Log.d("MemoryWarningReminder", "usedMemoryRatio:" + j2);
        }
        return j2;
    }

    public static boolean l(int i2) {
        return i2 == 15;
    }

    public static void m(int i2) {
        if (d.a.l0.a.r1.l.b.o() && f47506e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f47508g;
            long j3 = currentTimeMillis - f47509h;
            if (j2 < f47505d) {
                if (f47502a) {
                    Log.d("MemoryWarningReminder", "ReceiveInterval:" + j2 + ",FilterInterval:" + f47505d);
                    return;
                }
                return;
            }
            boolean z = j2 < f47503b && j3 > f47504c && k() > ((long) d.a.l0.a.r1.l.b.g());
            if (f47502a) {
                Log.d("MemoryWarningReminder", "SwanApp:" + d.a.l0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f47503b + ",getMemoryWarningAlterInterval:" + f47504c);
                StringBuilder sb = new StringBuilder();
                sb.append("ReceiveInterval:");
                sb.append(j2);
                sb.append(",AlterInterval:");
                sb.append(j3);
                sb.append(",UsedMemoryRatioLimit:");
                sb.append(d.a.l0.a.r1.l.b.g());
                Log.d("MemoryWarningReminder", sb.toString());
            }
            f47508g = currentTimeMillis;
            if (z) {
                f47509h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        o();
        f47509h = 0L;
        j = null;
    }

    public static void o() {
        f47506e.set(false);
        f47507f = 0L;
        f47508g = 0L;
        d.a.l0.a.n2.h.a.c();
        q0.b0(new d());
    }

    @UiThread
    public static void p(long j2, long j3) {
        h hVar;
        SwanAppActivity x = d.a.l0.a.a2.d.g().r().x();
        if (x == null) {
            return;
        }
        h hVar2 = f47510i;
        if (hVar2 != null && hVar2.isShowing()) {
            f47510i.dismiss();
            f47510i = null;
        }
        boolean z = !d.a.l0.a.r1.l.b.n();
        if (z && f47510i == null) {
            h.a aVar = new h.a(x);
            aVar.n(new d.a.l0.a.w2.h.a());
            aVar.J(d.a.l0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(d.a.l0.a.h.swanapp_low_memory_tip);
            aVar.B(d.a.l0.a.h.swanapp_low_memory_button_continue, new c());
            aVar.O(d.a.l0.a.h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0831b(x));
            f47510i = aVar.c();
        }
        if (z && (hVar = f47510i) != null) {
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
        d.a.l0.a.n2.h.a.a();
    }
}
