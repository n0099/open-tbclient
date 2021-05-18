package d.a.i0.a.e0.f.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41211a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f41212b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.i0.a.j2.a f41213c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f41214d;

    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d.f41211a) {
                Log.d("LocalDebugStatistic", "timer: send local debug ubc flow");
            }
            d.this.c();
            d.this.h();
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends d {
        public b() {
            super(null);
        }

        @Override // d.a.i0.a.e0.f.d.d
        public void f(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f41211a) {
                Log.d("LocalDebugStatistic", "local-debug statistic event name is : " + str);
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
                i();
                d.a.i0.a.j2.b.d(d.f41213c, str, d());
            } else if (c2 == 1) {
                if (d.f41213c != null) {
                    d.a.i0.a.j2.b.d(d.f41213c, "downloadsuccess", d());
                }
                c();
                h();
            } else if (c2 != 2) {
                if (d.f41213c != null) {
                    d.a.i0.a.j2.b.d(d.f41213c, str, d());
                }
            } else {
                if (d.f41213c != null) {
                    d.a.i0.a.j2.b.d(d.f41213c, "downloadfail", d());
                }
                c();
                h();
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

        @Override // d.a.i0.a.e0.f.d.d
        public void f(String str) {
            if (TextUtils.isEmpty(str) || f.k().m()) {
                return;
            }
            if (d.f41211a) {
                Log.d("LocalDebugStatistic", "local-debug statistic event name is : " + str);
            }
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 900970612) {
                if (hashCode == 1415552890 && str.equals("unzipstart")) {
                    c2 = 0;
                }
            } else if (str.equals("pageready")) {
                c2 = 1;
            }
            if (c2 == 0) {
                i();
                d.a.i0.a.j2.b.d(d.f41213c, str, d());
            } else if (c2 != 1) {
                if (d.f41213c != null) {
                    d.a.i0.a.j2.b.d(d.f41213c, str, d());
                }
            } else if (d.f41213c != null) {
                d.a.i0.a.j2.b.d(d.f41213c, str, d());
                c();
                h();
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d e() {
        if (f41212b == null) {
            synchronized (d.a.i0.a.g1.f.class) {
                if (f41212b == null) {
                    if (d.a.c0.b.a.a.g()) {
                        f41212b = new b(null);
                    } else {
                        f41212b = new c(null);
                    }
                }
            }
        }
        return f41212b;
    }

    public static void g(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f41212b == null) {
            return;
        }
        f41212b.f(optString);
    }

    public void c() {
        if (f41213c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.getAppId());
            jSONObject2.putOpt("from", "local-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f41211a) {
                Log.d("LocalDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.i0.a.j2.b.f(f41213c, jSONObject.toString());
        d.a.i0.a.j2.b.c(f41213c);
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (f41211a) {
                Log.d("LocalDebugStatistic", "add event content fail", e2);
            }
        }
        return jSONObject.toString();
    }

    public abstract void f(String str);

    public void h() {
        Timer timer = f41214d;
        if (timer != null) {
            timer.cancel();
            f41214d = null;
        }
        f41212b = null;
        f41213c = null;
    }

    public void i() {
        if (f41213c != null) {
            return;
        }
        f41213c = d.a.i0.a.j2.k.c("1153");
        a aVar = new a();
        Timer timer = new Timer();
        f41214d = timer;
        try {
            timer.schedule(aVar, 40000L);
        } catch (Exception e2) {
            if (f41211a) {
                e2.printStackTrace();
            }
        }
    }

    public d() {
    }
}
