package d.b.g0.a.z1.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import d.b.g0.a.i2.p;
import d.b.g0.a.k;
import d.b.g0.a.z1.h;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static final boolean j = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f47259a;

    /* renamed from: b  reason: collision with root package name */
    public String f47260b;

    /* renamed from: c  reason: collision with root package name */
    public String f47261c;

    /* renamed from: d  reason: collision with root package name */
    public String f47262d;

    /* renamed from: e  reason: collision with root package name */
    public String f47263e;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f47265g;

    /* renamed from: h  reason: collision with root package name */
    public int f47266h;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, SearchFlowEvent> f47264f = new HashMap<>();
    public Timer i = new Timer();

    /* renamed from: d.b.g0.a.z1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0897a extends TimerTask {
        public C0897a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (a.j) {
                Log.d("SearchFlow", "timer: send ubc...");
            }
            a.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.i();
        }
    }

    public a(String str) {
        this.f47266h = 0;
        this.f47259a = str;
        this.f47266h = 0;
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
        r6.f47261c = "fail";
        r6.f47263e = r7.f12653c;
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
        if (!TextUtils.isEmpty(this.f47259a) && this.f47264f != null) {
            if (this.f47264f.get(searchFlowEvent.f12651a) != null) {
                this.f47264f.remove(searchFlowEvent.f12651a);
                if (j) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.f12651a);
                }
            } else if (searchFlowEvent.f12655e == SearchFlowEvent.EventType.END) {
                this.f47266h++;
            }
            this.f47264f.put(searchFlowEvent.f12651a, searchFlowEvent);
            if (j) {
                Log.d("SearchFlow", "SearchFlowEvent added: " + searchFlowEvent.f12651a);
            }
            String str = searchFlowEvent.f12651a;
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
            this.f47261c = "success";
            this.f47263e = "";
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
        if (this.f47265g == null) {
            this.f47265g = new HashMap<>();
        }
        this.f47265g.put(str, str2);
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
        if (this.f47264f != null) {
            this.f47264f.clear();
        }
        if (this.f47265g != null) {
            this.f47265g.clear();
        }
        this.f47260b = null;
        this.f47261c = null;
        this.f47262d = null;
        this.f47263e = null;
        this.f47264f = null;
        this.f47265g = null;
        this.f47266h = 0;
        if (j) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    public final boolean g(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.f12651a) || searchFlowEvent.f12652b <= 0) ? false : true;
    }

    public void h() {
        if (j) {
            Log.d("SearchFlow", "try to send ubc: ");
        }
        if (this.f47266h >= 2) {
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
            C0897a c0897a = new C0897a();
            if (j) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.i.schedule(c0897a, 3000L);
        }
    }

    public final synchronized void i() {
        if (TextUtils.equals(this.f47262d, "1250000000000000")) {
            if (j) {
                Log.w("SearchFlow", "source=" + this.f47262d + ", ignore this case");
            }
        } else if (this.f47264f == null) {
            if (j) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (j) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            d.b.g0.a.z1.a e2 = h.e(this.f47259a);
            if (e2 == null) {
                if (j) {
                    Log.w("SearchFlow", "Ceres Flow create failed");
                }
                return;
            }
            for (SearchFlowEvent searchFlowEvent : this.f47264f.values()) {
                d.b.g0.a.z1.b.e(e2, searchFlowEvent.f12651a, searchFlowEvent.f12654d, searchFlowEvent.f12652b);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", this.f47261c);
                jSONObject.put("source", this.f47262d);
                jSONObject.put("value", this.f47263e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.f47260b);
                if (this.f47265g != null) {
                    for (String str : this.f47265g.keySet()) {
                        jSONObject2.put(str, this.f47265g.get(str));
                    }
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e3) {
                if (j) {
                    Log.w("SearchFlow", Log.getStackTraceString(e3));
                }
            }
            d.b.g0.a.z1.b.f(e2, jSONObject.toString());
            d.b.g0.a.z1.b.c(e2);
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
        this.f47260b = str;
    }

    public void l(String str) {
        this.f47262d = str;
    }
}
