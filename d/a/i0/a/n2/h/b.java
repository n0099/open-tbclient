package d.a.i0.a.n2.h;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.UiThread;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import d.a.i0.a.g1.g;
import d.a.i0.a.k;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import d.a.i0.a.z1.b.b.h;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43652a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f43653b = TimeUnit.SECONDS.toMillis(d.a.i0.a.r1.l.b.f());

    /* renamed from: c  reason: collision with root package name */
    public static final long f43654c = TimeUnit.SECONDS.toMillis(d.a.i0.a.r1.l.b.e());

    /* renamed from: d  reason: collision with root package name */
    public static final long f43655d = TimeUnit.SECONDS.toMillis(d.a.i0.a.r1.l.b.i());

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicBoolean f43656e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public static volatile long f43657f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static long f43658g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static long f43659h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static h f43660i;
    public static ActivityManager j;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f43661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f43662f;

        public a(long j, long j2) {
            this.f43661e = j;
            this.f43662f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.p(this.f43661e, this.f43662f);
        }
    }

    /* renamed from: d.a.i0.a.n2.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class DialogInterface$OnClickListenerC0764b implements DialogInterface.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f43663e;

        public DialogInterface$OnClickListenerC0764b(Activity activity) {
            this.f43663e = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_exit", null);
            h unused = b.f43660i = null;
            this.f43663e.moveTaskToBack(true);
            d.a.i0.a.a2.d.g().r().o("flag_finish_activity", "flag_remove_task");
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            b.h("memory_alert_continue", null);
            dialogInterface.dismiss();
            h unused = b.f43660i = null;
            d.a.i0.a.n2.h.a.a();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (b.f43660i != null && b.f43660i.isShowing()) {
                b.f43660i.dismiss();
            }
            h unused = b.f43660i = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements d.a.i0.a.v2.e1.b<HybridUbcFlow> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(HybridUbcFlow hybridUbcFlow) {
            boolean z = !d.a.i0.a.r1.m.c.a(hybridUbcFlow);
            if (b.f43652a) {
                Log.d("MemoryWarningReminder", "startUpSuccess:" + z);
            }
            if (z) {
                b.f43656e.set(true);
                long unused = b.f43657f = System.currentTimeMillis();
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
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43011a = "swan";
        eVar.f43012b = str;
        eVar.f43016f = d.a.i0.a.a2.d.g().getAppId();
        eVar.e(jSONObject);
        eVar.a("start_timestamp", Long.valueOf(f43657f));
        eVar.a("event_timestamp", Long.valueOf(System.currentTimeMillis()));
        eVar.a("launchid", d.a.i0.a.a2.d.g().r().L().V());
        d.a.i0.a.j2.k.u("1619", eVar);
    }

    public static String i(long j2) {
        return new DecimalFormat("#.##").format(j2 / 1.073741824E9d) + "GB";
    }

    public static ActivityManager j() {
        if (j == null) {
            j = (ActivityManager) d.a.i0.a.a2.d.g().getSystemService("activity");
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
        if (f43652a) {
            Log.d("MemoryWarningReminder", "usedMemoryRatio:" + j2);
        }
        return j2;
    }

    public static boolean l(int i2) {
        return i2 == 15;
    }

    public static void m(int i2) {
        if (d.a.i0.a.r1.l.b.o() && f43656e.get() && l(i2) && g.a().b()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = currentTimeMillis - f43658g;
            long j3 = currentTimeMillis - f43659h;
            if (j2 < f43655d) {
                if (f43652a) {
                    Log.d("MemoryWarningReminder", "ReceiveInterval:" + j2 + ",FilterInterval:" + f43655d);
                    return;
                }
                return;
            }
            boolean z = j2 < f43653b && j3 > f43654c && k() > ((long) d.a.i0.a.r1.l.b.g());
            if (f43652a) {
                Log.d("MemoryWarningReminder", "SwanApp:" + d.a.i0.a.a2.d.g().getAppId() + ",LowMemoryNeedRemind:" + z + ",getMemoryWarningInterval:" + f43653b + ",getMemoryWarningAlterInterval:" + f43654c);
                StringBuilder sb = new StringBuilder();
                sb.append("ReceiveInterval:");
                sb.append(j2);
                sb.append(",AlterInterval:");
                sb.append(j3);
                sb.append(",UsedMemoryRatioLimit:");
                sb.append(d.a.i0.a.r1.l.b.g());
                Log.d("MemoryWarningReminder", sb.toString());
            }
            f43658g = currentTimeMillis;
            if (z) {
                f43659h = currentTimeMillis;
                q0.b0(new a(j2, j3));
            }
        }
    }

    public static void n() {
        o();
        f43659h = 0L;
        j = null;
    }

    public static void o() {
        f43656e.set(false);
        f43657f = 0L;
        f43658g = 0L;
        d.a.i0.a.n2.h.a.c();
        q0.b0(new d());
    }

    @UiThread
    public static void p(long j2, long j3) {
        h hVar;
        SwanAppActivity x = d.a.i0.a.a2.d.g().r().x();
        if (x == null) {
            return;
        }
        h hVar2 = f43660i;
        if (hVar2 != null && hVar2.isShowing()) {
            f43660i.dismiss();
            f43660i = null;
        }
        boolean z = !d.a.i0.a.r1.l.b.n();
        if (z && f43660i == null) {
            h.a aVar = new h.a(x);
            aVar.n(new d.a.i0.a.w2.h.a());
            aVar.J(d.a.i0.a.c1.a.H().a());
            aVar.a();
            aVar.m(false);
            aVar.f(true);
            aVar.v(d.a.i0.a.h.swanapp_low_memory_tip);
            aVar.B(d.a.i0.a.h.swanapp_low_memory_button_continue, new c());
            aVar.O(d.a.i0.a.h.swanapp_low_memory_button_exit, new DialogInterface$OnClickListenerC0764b(x));
            f43660i = aVar.c();
        }
        if (z && (hVar = f43660i) != null) {
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
        d.a.i0.a.n2.h.a.a();
    }
}
