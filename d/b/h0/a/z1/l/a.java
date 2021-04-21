package d.b.h0.a.z1.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
import d.b.h0.a.z1.h;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f47980a;

    /* renamed from: b  reason: collision with root package name */
    public String f47981b;

    /* renamed from: c  reason: collision with root package name */
    public String f47982c;

    /* renamed from: d  reason: collision with root package name */
    public String f47983d;

    /* renamed from: e  reason: collision with root package name */
    public String f47984e;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f47986g;

    /* renamed from: h  reason: collision with root package name */
    public int f47987h;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, SearchFlowEvent> f47985f = new HashMap<>();
    public Timer i = new Timer();

    /* renamed from: d.b.h0.a.z1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0929a extends TimerTask {
        public C0929a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.j) {
                Log.d("SearchFlow", "timer: send ubc...");
            }
            a.this.j();
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    public a(String str) {
        this.f47987h = 0;
        this.f47980a = str;
        this.f47987h = 0;
        if (j) {
            Log.d("SearchFlow", "-----New SearchFlow-----");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b8, code lost:
        if (r2 == 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ba, code lost:
        if (r2 == 2) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00bd, code lost:
        r6.f47982c = "fail";
        r6.f47984e = r7.f12322c;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void c(SearchFlowEvent searchFlowEvent) {
        if (!g(searchFlowEvent)) {
            if (j) {
                Log.d("SearchFlow", "SearchFlowEvent is invalid");
            }
            return;
        }
        if (!TextUtils.isEmpty(this.f47980a) && this.f47985f != null) {
            if (this.f47985f.get(searchFlowEvent.f12320a) != null) {
                this.f47985f.remove(searchFlowEvent.f12320a);
                if (j) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.f12320a);
                }
            } else if (searchFlowEvent.f12324e == SearchFlowEvent.EventType.END) {
                this.f47987h++;
            }
            this.f47985f.put(searchFlowEvent.f12320a, searchFlowEvent);
            if (j) {
                Log.d("SearchFlow", "SearchFlowEvent added: " + searchFlowEvent.f12320a);
            }
            String str = searchFlowEvent.f12320a;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1037374011) {
                if (hashCode != -912085361) {
                    if (hashCode == 1211923090 && str.equals("dom_first_paint")) {
                        c2 = 0;
                    }
                } else if (str.equals("fe_first_paint")) {
                    c2 = 1;
                }
            } else if (str.equals("nreach")) {
                c2 = 2;
            }
            this.f47982c = "success";
            this.f47984e = "";
            return;
        }
        if (j) {
            Log.d("SearchFlow", "ubc flow status is invalid");
        }
    }

    public void d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.f47986g == null) {
            this.f47986g = new HashMap<>();
        }
        this.f47986g.put(str, str2);
    }

    public final synchronized void e() {
        if (this.i != null) {
            this.i.cancel();
            this.i.purge();
            this.i = null;
        }
    }

    public synchronized void f() {
        e();
        if (this.f47985f != null) {
            this.f47985f.clear();
        }
        if (this.f47986g != null) {
            this.f47986g.clear();
        }
        this.f47981b = null;
        this.f47982c = null;
        this.f47983d = null;
        this.f47984e = null;
        this.f47985f = null;
        this.f47986g = null;
        this.f47987h = 0;
        if (j) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    public final boolean g(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.f12320a) || searchFlowEvent.f12321b <= 0) ? false : true;
    }

    public void h() {
        if (j) {
            Log.d("SearchFlow", "try to send ubc: ");
        }
        if (this.f47987h >= 2) {
            if (j) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            e();
            j();
        } else if (this.i == null) {
            if (j) {
                Log.w("SearchFlow", "send delay timer is null");
            }
        } else {
            C0929a c0929a = new C0929a();
            if (j) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.i.schedule(c0929a, 3000L);
        }
    }

    public final synchronized void i() {
        if (TextUtils.equals(this.f47983d, "1250000000000000")) {
            if (j) {
                Log.w("SearchFlow", "source=" + this.f47983d + ", ignore this case");
            }
        } else if (this.f47985f == null) {
            if (j) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (j) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            d.b.h0.a.z1.a e2 = h.e(this.f47980a);
            if (e2 == null) {
                if (j) {
                    Log.w("SearchFlow", "Ceres Flow create failed");
                }
                return;
            }
            for (SearchFlowEvent searchFlowEvent : this.f47985f.values()) {
                d.b.h0.a.z1.b.e(e2, searchFlowEvent.f12320a, searchFlowEvent.f12323d, searchFlowEvent.f12321b);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", this.f47982c);
                jSONObject.put("source", this.f47983d);
                jSONObject.put("value", this.f47984e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.f47981b);
                if (this.f47986g != null) {
                    for (String str : this.f47986g.keySet()) {
                        jSONObject2.put(str, this.f47986g.get(str));
                    }
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e3) {
                if (j) {
                    Log.w("SearchFlow", Log.getStackTraceString(e3));
                }
            }
            d.b.h0.a.z1.b.f(e2, jSONObject.toString());
            d.b.h0.a.z1.b.c(e2);
            if (j) {
                Log.d("SearchFlow", "ubc: end flow");
            }
            f();
            if (j) {
                Log.d("SearchFlow", "send ubc log");
            }
        }
    }

    public final void j() {
        p.g().execute(new b());
    }

    public void k(String str) {
        this.f47981b = str;
    }

    public void l(String str) {
        this.f47983d = str;
    }
}
