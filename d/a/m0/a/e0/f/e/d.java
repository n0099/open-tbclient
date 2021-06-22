package d.a.m0.a.e0.f.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.m0.a.j2.p.f;
import d.a.m0.a.k;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45231a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f45232b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.m0.a.j2.a f45233c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f45234d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f45235e;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d.f45231a) {
                Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
            }
            d.this.e();
            d.this.n();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d {
        public b() {
            super(null);
        }

        @Override // d.a.m0.a.e0.f.e.d
        public void h(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f45231a) {
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
                d.a.m0.a.j2.b.d(d.f45233c, str, f());
            } else if (c2 == 1) {
                d.a.m0.a.j2.a aVar = d.f45233c;
                if (aVar != null) {
                    d.a.m0.a.j2.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                d.a.m0.a.j2.a aVar2 = d.f45233c;
                if (aVar2 != null) {
                    d.a.m0.a.j2.b.d(aVar2, str, f());
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

    /* loaded from: classes3.dex */
    public static class c extends d {
        public c() {
            super(null);
        }

        @Override // d.a.m0.a.e0.f.e.d
        public void h(String str) {
            SwanAppActivity x;
            if (TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.f45231a) {
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
                    d.a.m0.a.j2.a aVar = d.f45233c;
                    if (aVar != null) {
                        d.a.m0.a.j2.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                d.a.m0.a.j2.a aVar2 = d.f45233c;
                if (aVar2 != null) {
                    d.a.m0.a.j2.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (d.a.m0.a.a2.e.Q() != null && (x = d.a.m0.a.a2.e.Q().x()) != null && !x.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f45235e) {
                    d.a.m0.a.j2.a aVar3 = d.f45233c;
                    d.a.m0.a.j2.b.d(aVar3, str + "-preload", f());
                    boolean unused = d.f45235e = false;
                    return;
                }
                d.a.m0.a.j2.b.d(d.f45233c, str, f());
                return;
            }
            d.a.m0.a.j2.a aVar4 = d.f45233c;
            d.a.m0.a.j2.b.d(aVar4, str + "-destroy", f());
            boolean unused2 = d.f45235e = false;
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
        fVar.f46969a = "swan";
        fVar.f46970b = "launch";
        fVar.f46971c = "remote-debug";
        fVar.f46973e = "appready";
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public static d g() {
        if (f45232b == null) {
            synchronized (d.a.m0.a.g1.f.class) {
                if (f45232b == null) {
                    if (d.a.f0.b.a.a.g()) {
                        f45232b = new b(null);
                    } else {
                        f45232b = new c(null);
                    }
                }
            }
        }
        return f45232b;
    }

    public static void i(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f45232b == null) {
            return;
        }
        f45232b.h(optString);
    }

    public static void j(d.a.m0.a.f1.e.c cVar) {
        cVar.r0().putString("aiapp_extra_need_download", "1");
        cVar.r0().putString("aiapp_extra_pkg_downloading", "0");
        cVar.r0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        f fVar = new f();
        fVar.f46969a = d.a.m0.a.j2.k.m(cVar.G());
        fVar.j(cVar);
        fVar.f46970b = "launch";
        fVar.o = "1";
        fVar.f46971c = "remote-debug";
        JSONObject k = d.a.m0.a.j2.k.k(cVar.W());
        fVar.d(cVar.r0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(k);
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public static void k() {
        f fVar = new f();
        fVar.f46969a = "swan";
        fVar.f46970b = "launch";
        fVar.f46971c = "remote-debug";
        fVar.f46973e = "loadmaster";
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public static void l() {
        f fVar = new f();
        fVar.f46969a = "swan";
        fVar.f46970b = "launch";
        fVar.f46971c = "remote-debug";
        fVar.f46973e = "downloadstart";
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public static void m(d.a.m0.a.f1.e.c cVar) {
        f fVar = new f();
        fVar.j(cVar);
        fVar.f46969a = d.a.m0.a.j2.k.m(cVar.G());
        fVar.f46970b = "launch";
        fVar.f46971c = "remote-debug";
        fVar.f46973e = "downloadsuccess";
        d.a.m0.a.j2.k.onEvent(fVar);
    }

    public void e() {
        if (f45233c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.D());
            jSONObject2.putOpt("from", "remote-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f45231a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.m0.a.j2.b.f(f45233c, jSONObject.toString());
        d.a.m0.a.j2.b.c(f45233c);
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (f45231a) {
                Log.d("RemoteDebugStatistic", "add event content fail", e2);
            }
        }
        return jSONObject.toString();
    }

    public abstract void h(String str);

    public void n() {
        Timer timer = f45234d;
        if (timer != null) {
            timer.cancel();
            f45234d = null;
        }
        f45232b = null;
        f45233c = null;
    }

    public void o() {
        f45235e = true;
    }

    public void p(boolean z) {
        if (f45233c != null) {
            return;
        }
        d.a.m0.a.j2.a c2 = d.a.m0.a.j2.k.c("1153");
        f45233c = c2;
        if (!z) {
            d.a.m0.a.j2.b.d(c2, "downloadstart", f());
            d.a.m0.a.j2.b.d(f45233c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        f45234d = timer;
        timer.schedule(new a(), 40000L);
    }

    public d() {
    }
}
