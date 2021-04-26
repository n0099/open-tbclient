package d.a.h0.a.c0.d.d;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.h0.a.k;
import d.a.h0.a.z1.h;
import d.a.h0.a.z1.k.f;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41627a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static d f41628b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.h0.a.z1.a f41629c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f41630d;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f41631e;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d.f41627a) {
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

        @Override // d.a.h0.a.c0.d.d.d
        public void h(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f41627a) {
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
                d.a.h0.a.z1.b.d(d.f41629c, str, f());
            } else if (c2 == 1) {
                d.a.h0.a.z1.a aVar = d.f41629c;
                if (aVar != null) {
                    d.a.h0.a.z1.b.b(aVar);
                }
                n();
            } else if (c2 != 2) {
                d.a.h0.a.z1.a aVar2 = d.f41629c;
                if (aVar2 != null) {
                    d.a.h0.a.z1.b.d(aVar2, str, f());
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

        @Override // d.a.h0.a.c0.d.d.d
        public void h(String str) {
            SwanAppActivity v;
            if (TextUtils.isEmpty(str) || e.c()) {
                return;
            }
            if (d.f41627a) {
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
                    d.a.h0.a.z1.a aVar = d.f41629c;
                    if (aVar != null) {
                        d.a.h0.a.z1.b.d(aVar, str, f());
                        return;
                    }
                    return;
                }
                d.a.h0.a.z1.a aVar2 = d.f41629c;
                if (aVar2 != null) {
                    d.a.h0.a.z1.b.d(aVar2, str, f());
                    e();
                    n();
                    return;
                }
                return;
            }
            if (d.a.h0.a.r1.e.O() != null && (v = d.a.h0.a.r1.e.O().v()) != null && !v.isFinishing()) {
                z = false;
            }
            p(z);
            if (!z) {
                if (d.f41631e) {
                    d.a.h0.a.z1.a aVar3 = d.f41629c;
                    d.a.h0.a.z1.b.d(aVar3, str + "-preload", f());
                    boolean unused = d.f41631e = false;
                    return;
                }
                d.a.h0.a.z1.b.d(d.f41629c, str, f());
                return;
            }
            d.a.h0.a.z1.a aVar4 = d.f41629c;
            d.a.h0.a.z1.b.d(aVar4, str + "-destroy", f());
            boolean unused2 = d.f41631e = false;
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
        fVar.f45411a = "swan";
        fVar.f45412b = "launch";
        fVar.f45413c = "remote-debug";
        fVar.f45414d = "appready";
        h.onEvent(fVar);
    }

    public static d g() {
        if (f41628b == null) {
            synchronized (d.a.h0.a.z0.f.class) {
                if (f41628b == null) {
                    if (d.a.c0.b.a.a.g()) {
                        f41628b = new b(null);
                    } else {
                        f41628b = new c(null);
                    }
                }
            }
        }
        return f41628b;
    }

    public static void i(JSONArray jSONArray) {
        d dVar;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || (dVar = f41628b) == null) {
            return;
        }
        dVar.h(optString);
    }

    public static void j(d.a.h0.a.y0.e.c cVar) {
        cVar.n0().putString("aiapp_extra_need_download", "1");
        cVar.n0().putString("aiapp_extra_preset_pkg", "0");
        cVar.n0().putString("aiapp_extra_pkg_downloading", "0");
        cVar.n0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
        f fVar = new f();
        fVar.f45411a = h.n(cVar.F());
        fVar.j(cVar);
        fVar.f45412b = "launch";
        fVar.n = "1";
        fVar.p = "0";
        fVar.o = "0";
        fVar.f45413c = "remote-debug";
        JSONObject l = h.l(cVar.V());
        fVar.d(cVar.n0().getString(UBCCloudControlProcessor.UBC_KEY));
        fVar.b(l);
        h.onEvent(fVar);
    }

    public static void k() {
        f fVar = new f();
        fVar.f45411a = "swan";
        fVar.f45412b = "launch";
        fVar.f45413c = "remote-debug";
        fVar.f45414d = "loadmaster";
        h.onEvent(fVar);
    }

    public static void l() {
        f fVar = new f();
        fVar.f45411a = "swan";
        fVar.f45412b = "launch";
        fVar.f45413c = "remote-debug";
        fVar.f45414d = "downloadstart";
        h.onEvent(fVar);
    }

    public static void m(d.a.h0.a.y0.e.c cVar) {
        f fVar = new f();
        fVar.j(cVar);
        fVar.f45411a = h.n(cVar.F());
        fVar.f45412b = "launch";
        fVar.f45413c = "remote-debug";
        fVar.f45414d = "downloadsuccess";
        h.onEvent(fVar);
    }

    public void e() {
        if (f41629c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
            jSONObject2.putOpt("appid", O == null ? "" : O.B());
            jSONObject2.putOpt("from", "remote-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f41627a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.h0.a.z1.b.f(f41629c, jSONObject.toString());
        d.a.h0.a.z1.b.c(f41629c);
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (f41627a) {
                Log.d("RemoteDebugStatistic", "add event content fail", e2);
            }
        }
        return jSONObject.toString();
    }

    public abstract void h(String str);

    public void n() {
        Timer timer = f41630d;
        if (timer != null) {
            timer.cancel();
            f41630d = null;
        }
        f41628b = null;
        f41629c = null;
    }

    public void o() {
        f41631e = true;
    }

    public void p(boolean z) {
        if (f41629c != null) {
            return;
        }
        d.a.h0.a.z1.a e2 = h.e("1153");
        f41629c = e2;
        if (!z) {
            d.a.h0.a.z1.b.d(e2, "downloadstart", f());
            d.a.h0.a.z1.b.d(f41629c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        f41630d = timer;
        timer.schedule(new a(), 40000L);
    }

    public d() {
    }
}
