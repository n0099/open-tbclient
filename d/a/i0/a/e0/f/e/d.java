package d.a.i0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.j2.p.f;
import d.a.i0.a.k;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41273a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f41274b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.i0.a.j2.a f41275c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f41276d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f41277e;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d.f41273a) {
                Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
            }
            d.this.e();
            d.this.n();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d {
        public b() {
            super(null);
        }

        @Override // d.a.i0.a.e0.f.e.d
        public void h(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f41273a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c2 = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c2 = 2;
                }
            } else if (str.equals("downloadstart")) {
                c2 = 0;
            }
            if (c2 == 0) {
                p(true);
                d.a.i0.a.j2.b.d(d.f41275c, str, f());
            } else if (c2 == 1) {
                d.a.i0.a.j2.a aVar = d.f41275c;
                if (aVar != null) {
                    d.a.i0.a.j2.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                d.a.i0.a.j2.a aVar2 = d.f41275c;
                if (aVar2 != null) {
                    d.a.i0.a.j2.b.d(aVar2, str, f());
                }
            } else {
                e();
                n();
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends d {
        public c() {
            super(null);
        }

        @Override // d.a.i0.a.e0.f.e.d
        public void h(String str) {
            SwanAppActivity x;
            if (TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.f41273a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            boolean z = true;
            if (hashCode != 511060680) {
                if (hashCode == 900970612 && str.equals("pageready")) {
                    c2 = 1;
                }
            } else if (str.equals("loadmaster")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    d.a.i0.a.j2.a aVar = d.f41275c;
                    if (aVar != null) {
                        d.a.i0.a.j2.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                d.a.i0.a.j2.a aVar2 = d.f41275c;
                if (aVar2 != null) {
                    d.a.i0.a.j2.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (d.a.i0.a.a2.e.Q() != null && (x = d.a.i0.a.a2.e.Q().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f41277e) {
                    d.a.i0.a.j2.a aVar3 = d.f41275c;
                    d.a.i0.a.j2.b.d(aVar3, str + "-preload", f());
                    boolean unused = d.f41277e = false;
                    return;
                }
                d.a.i0.a.j2.b.d(d.f41275c, str, f());
                return;
            }
            d.a.i0.a.j2.a aVar4 = d.f41275c;
            d.a.i0.a.j2.b.d(aVar4, str + "-destroy", f());
            boolean unused2 = d.f41277e = false;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static void d() {
        f fVar = new f();
        fVar.f43011a = "swan";
        fVar.f43012b = "launch";
        fVar.f43013c = "remote-debug";
        fVar.f43015e = "appready";
        d.a.i0.a.j2.k.onEvent(fVar);
    }

    public static d g() {
        if (f41274b == null) {
            synchronized (d.a.i0.a.g1.f.class) {
                if (f41274b == null) {
                    if (d.a.c0.b.a.a.g()) {
                        f41274b = new b(null);
                    } else {
                        f41274b = new c(null);
                    }
                }
            }
        }
        return f41274b;
    }

    public static void i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f41274b == null) {
            return;
        }
        f41274b.h(optString);
    }

    public static void j(d.a.i0.a.f1.e.c cVar) {
        cVar.r0().putString("aiapp_extra_need_download", "1");
        cVar.r0().putString("aiapp_extra_pkg_downloading", "0");
        cVar.r0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        f fVar = new f();
        fVar.f43011a = d.a.i0.a.j2.k.m(cVar.G());
        fVar.j(cVar);
        fVar.f43012b = "launch";
        fVar.o = "1";
        fVar.f43013c = "remote-debug";
        JSONObject k = d.a.i0.a.j2.k.k(cVar.W());
        fVar.d(cVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(k);
        d.a.i0.a.j2.k.onEvent(fVar);
    }

    public static void k() {
        f fVar = new f();
        fVar.f43011a = "swan";
        fVar.f43012b = "launch";
        fVar.f43013c = "remote-debug";
        fVar.f43015e = "loadmaster";
        d.a.i0.a.j2.k.onEvent(fVar);
    }

    public static void l() {
        f fVar = new f();
        fVar.f43011a = "swan";
        fVar.f43012b = "launch";
        fVar.f43013c = "remote-debug";
        fVar.f43015e = "downloadstart";
        d.a.i0.a.j2.k.onEvent(fVar);
    }

    public static void m(d.a.i0.a.f1.e.c cVar) {
        f fVar = new f();
        fVar.j(cVar);
        fVar.f43011a = d.a.i0.a.j2.k.m(cVar.G());
        fVar.f43012b = "launch";
        fVar.f43013c = "remote-debug";
        fVar.f43015e = "downloadsuccess";
        d.a.i0.a.j2.k.onEvent(fVar);
    }

    public void e() {
        if (f41275c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.D());
            jSONObject2.putOpt("from", "remote-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f41273a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.i0.a.j2.b.f(f41275c, jSONObject.toString());
        d.a.i0.a.j2.b.c(f41275c);
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (f41273a) {
                Log.d("RemoteDebugStatistic", "add event content fail", e2);
            }
        }
        return jSONObject.toString();
    }

    public abstract void h(String str);

    public void n() {
        Timer timer = f41276d;
        if (timer != null) {
            timer.cancel();
            f41276d = null;
        }
        f41274b = null;
        f41275c = null;
    }

    public void o() {
        f41277e = true;
    }

    public void p(boolean z) {
        if (f41275c != null) {
            return;
        }
        d.a.i0.a.j2.a c2 = d.a.i0.a.j2.k.c("1153");
        f41275c = c2;
        if (!z) {
            d.a.i0.a.j2.b.d(c2, "downloadstart", f());
            d.a.i0.a.j2.b.d(f41275c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        f41276d = timer;
        timer.schedule(new a(), 40000L);
    }

    public d() {
    }
}
