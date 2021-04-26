package d.a.h0.a.z1.l;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import d.a.h0.a.i2.p;
import d.a.h0.a.k;
import d.a.h0.a.z1.h;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {
    public static final boolean j = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f45419a;

    /* renamed from: b  reason: collision with root package name */
    public String f45420b;

    /* renamed from: c  reason: collision with root package name */
    public String f45421c;

    /* renamed from: d  reason: collision with root package name */
    public String f45422d;

    /* renamed from: e  reason: collision with root package name */
    public String f45423e;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f45425g;

    /* renamed from: h  reason: collision with root package name */
    public int f45426h;

    /* renamed from: f  reason: collision with root package name */
    public HashMap<String, SearchFlowEvent> f45424f = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    public Timer f45427i = new Timer();

    /* renamed from: d.a.h0.a.z1.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0868a extends TimerTask {
        public C0868a() {
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
        this.f45426h = 0;
        this.f45419a = str;
        this.f45426h = 0;
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
        r6.f45421c = "fail";
        r6.f45423e = r7.f12194c;
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
        if (!TextUtils.isEmpty(this.f45419a) && this.f45424f != null) {
            if (this.f45424f.get(searchFlowEvent.f12192a) != null) {
                this.f45424f.remove(searchFlowEvent.f12192a);
                if (j) {
                    Log.d("SearchFlow", "SearchFlowEvent removed: " + searchFlowEvent.f12192a);
                }
            } else if (searchFlowEvent.f12196e == SearchFlowEvent.EventType.END) {
                this.f45426h++;
            }
            this.f45424f.put(searchFlowEvent.f12192a, searchFlowEvent);
            if (j) {
                Log.d("SearchFlow", "SearchFlowEvent added: " + searchFlowEvent.f12192a);
            }
            String str = searchFlowEvent.f12192a;
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
            this.f45421c = "success";
            this.f45423e = "";
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
        if (this.f45425g == null) {
            this.f45425g = new HashMap<>();
        }
        this.f45425g.put(str, str2);
    }

    public final synchronized void e() {
        if (this.f45427i != null) {
            this.f45427i.cancel();
            this.f45427i.purge();
            this.f45427i = null;
        }
    }

    public synchronized void f() {
        e();
        if (this.f45424f != null) {
            this.f45424f.clear();
        }
        if (this.f45425g != null) {
            this.f45425g.clear();
        }
        this.f45420b = null;
        this.f45421c = null;
        this.f45422d = null;
        this.f45423e = null;
        this.f45424f = null;
        this.f45425g = null;
        this.f45426h = 0;
        if (j) {
            Log.d("SearchFlow", "-----Destroy SearchFlow-----");
        }
    }

    public final boolean g(SearchFlowEvent searchFlowEvent) {
        return (searchFlowEvent == null || TextUtils.isEmpty(searchFlowEvent.f12192a) || searchFlowEvent.f12193b <= 0) ? false : true;
    }

    public void h() {
        if (j) {
            Log.d("SearchFlow", "try to send ubc: ");
        }
        if (this.f45426h >= 2) {
            if (j) {
                Log.d("SearchFlow", "two+ ends, cancel timer task, and send ubc instantly");
            }
            e();
            j();
        } else if (this.f45427i == null) {
            if (j) {
                Log.w("SearchFlow", "send delay timer is null");
            }
        } else {
            C0868a c0868a = new C0868a();
            if (j) {
                Log.d("SearchFlow", "timer: create timertask and schedule");
            }
            this.f45427i.schedule(c0868a, 3000L);
        }
    }

    public final synchronized void i() {
        if (TextUtils.equals(this.f45422d, "1250000000000000")) {
            if (j) {
                Log.w("SearchFlow", "source=" + this.f45422d + ", ignore this case");
            }
        } else if (this.f45424f == null) {
            if (j) {
                Log.d("SearchFlow", "event pool is empty");
            }
        } else {
            if (j) {
                Log.d("SearchFlow", "ubc: begin flow");
            }
            d.a.h0.a.z1.a e2 = h.e(this.f45419a);
            if (e2 == null) {
                if (j) {
                    Log.w("SearchFlow", "Ceres Flow create failed");
                }
                return;
            }
            for (SearchFlowEvent searchFlowEvent : this.f45424f.values()) {
                d.a.h0.a.z1.b.e(e2, searchFlowEvent.f12192a, searchFlowEvent.f12195d, searchFlowEvent.f12193b);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", "swan");
                jSONObject.put("type", this.f45421c);
                jSONObject.put("source", this.f45422d);
                jSONObject.put("value", this.f45423e);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appid", this.f45420b);
                if (this.f45425g != null) {
                    for (String str : this.f45425g.keySet()) {
                        jSONObject2.put(str, this.f45425g.get(str));
                    }
                }
                jSONObject.put("ext", jSONObject2);
            } catch (JSONException e3) {
                if (j) {
                    Log.w("SearchFlow", Log.getStackTraceString(e3));
                }
            }
            d.a.h0.a.z1.b.f(e2, jSONObject.toString());
            d.a.h0.a.z1.b.c(e2);
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
        this.f45420b = str;
    }

    public void l(String str) {
        this.f45422d = str;
    }
}
