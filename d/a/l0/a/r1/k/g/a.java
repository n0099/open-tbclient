package d.a.l0.a.r1.k.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.l0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f44478f = e.c();

    /* renamed from: b  reason: collision with root package name */
    public long f44479b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f44480c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f44481d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f44482e;

    /* renamed from: d.a.l0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0806a implements d.a.l0.a.r1.r.c.a {
        public C0806a() {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void b() {
            a.this.g();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.g();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public void d(String str) {
            a.this.f44479b = System.currentTimeMillis();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "LaunchApiCache";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44484a = new a(null);
    }

    public /* synthetic */ a(C0806a c0806a) {
        this();
    }

    public static a c() {
        return b.f44484a;
    }

    public JSONObject d(String str) {
        if (!TextUtils.isEmpty(str) && e()) {
            JSONObject jSONObject = this.f44480c.get(str);
            if (d.a.l0.a.f1.f.a.f41852a && jSONObject != null) {
                Integer num = this.f44481d.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f44481d.put(str, Integer.valueOf(num.intValue() + 1));
            }
            return jSONObject;
        }
        return null;
    }

    public boolean e() {
        return f44478f > 0 && this.f44479b != -1 && System.currentTimeMillis() - this.f44479b <= ((long) f44478f);
    }

    public void f() {
        if (f44478f <= 0) {
            if (d.a.l0.a.f1.f.a.f41852a) {
                Log.d("SwanPerformance", "cache api close, can't register. duration = " + f44478f);
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f44482e, f44478f);
    }

    public final void g() {
        this.f44479b = -1L;
        if (d.a.l0.a.f1.f.a.f41852a) {
            StringBuilder sb = new StringBuilder();
            sb.append("adopt cache api = [ ");
            for (Map.Entry<String, Integer> entry : this.f44481d.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(" ");
            }
            sb.append("]");
            Log.d("SwanPerformance", sb.toString());
        }
        this.f44481d.clear();
        this.f44480c.clear();
    }

    public void h(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && e()) {
            this.f44480c.put(str, jSONObject);
        }
    }

    public a() {
        this.f44479b = -1L;
        this.f44480c = new ConcurrentHashMap<>(10);
        this.f44481d = new ConcurrentHashMap<>(10);
        this.f44482e = new C0806a();
    }
}
