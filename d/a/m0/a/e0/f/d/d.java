package d.a.m0.a.e0.f.d;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45169a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f45170b;

    /* renamed from: c  reason: collision with root package name */
    public static d.a.m0.a.j2.a f45171c;

    /* renamed from: d  reason: collision with root package name */
    public static Timer f45172d;

    /* loaded from: classes3.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (d.f45169a) {
                Log.d("LocalDebugStatistic", "timer: send local debug ubc flow");
            }
            d.this.c();
            d.this.h();
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends d {
        public b() {
            super(null);
        }

        @Override // d.a.m0.a.e0.f.d.d
        public void f(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (d.f45169a) {
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
                d.a.m0.a.j2.b.d(d.f45171c, str, d());
            } else if (c2 == 1) {
                if (d.f45171c != null) {
                    d.a.m0.a.j2.b.d(d.f45171c, "downloadsuccess", d());
                }
                c();
                h();
            } else if (c2 != 2) {
                if (d.f45171c != null) {
                    d.a.m0.a.j2.b.d(d.f45171c, str, d());
                }
            } else {
                if (d.f45171c != null) {
                    d.a.m0.a.j2.b.d(d.f45171c, "downloadfail", d());
                }
                c();
                h();
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

        @Override // d.a.m0.a.e0.f.d.d
        public void f(String str) {
            if (TextUtils.isEmpty(str) || f.k().m()) {
                return;
            }
            if (d.f45169a) {
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
                d.a.m0.a.j2.b.d(d.f45171c, str, d());
            } else if (c2 != 1) {
                if (d.f45171c != null) {
                    d.a.m0.a.j2.b.d(d.f45171c, str, d());
                }
            } else if (d.f45171c != null) {
                d.a.m0.a.j2.b.d(d.f45171c, str, d());
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
        if (f45170b == null) {
            synchronized (d.a.m0.a.g1.f.class) {
                if (f45170b == null) {
                    if (d.a.f0.b.a.a.g()) {
                        f45170b = new b(null);
                    } else {
                        f45170b = new c(null);
                    }
                }
            }
        }
        return f45170b;
    }

    public static void g(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        JSONObject optJSONObject = jSONArray.optJSONObject(0);
        String optString = optJSONObject != null ? optJSONObject.optString("actionId") : "";
        if (TextUtils.isEmpty(optString) || f45170b == null) {
            return;
        }
        f45170b.f(optString);
    }

    public void c() {
        if (f45171c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            jSONObject2.putOpt("appid", Q == null ? "" : Q.getAppId());
            jSONObject2.putOpt("from", "local-debug");
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (f45169a) {
                Log.d("LocalDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        d.a.m0.a.j2.b.f(f45171c, jSONObject.toString());
        d.a.m0.a.j2.b.c(f45171c);
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (JSONException e2) {
            if (f45169a) {
                Log.d("LocalDebugStatistic", "add event content fail", e2);
            }
        }
        return jSONObject.toString();
    }

    public abstract void f(String str);

    public void h() {
        Timer timer = f45172d;
        if (timer != null) {
            timer.cancel();
            f45172d = null;
        }
        f45170b = null;
        f45171c = null;
    }

    public void i() {
        if (f45171c != null) {
            return;
        }
        f45171c = d.a.m0.a.j2.k.c("1153");
        a aVar = new a();
        Timer timer = new Timer();
        f45172d = timer;
        try {
            timer.schedule(aVar, 40000L);
        } catch (Exception e2) {
            if (f45169a) {
                e2.printStackTrace();
            }
        }
    }

    public d() {
    }
}
