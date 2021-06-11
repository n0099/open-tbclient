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
    public static final int f48152f = e.c();

    /* renamed from: b  reason: collision with root package name */
    public long f48153b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f48154c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f48155d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.l0.a.r1.r.c.a f48156e;

    /* renamed from: d.a.l0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0862a implements d.a.l0.a.r1.r.c.a {
        public C0862a() {
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
            a.this.f48153b = System.currentTimeMillis();
        }

        @Override // d.a.l0.a.r1.r.c.a
        public String getName() {
            return "LaunchApiCache";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48158a = new a(null);
    }

    public /* synthetic */ a(C0862a c0862a) {
        this();
    }

    public static a c() {
        return b.f48158a;
    }

    public JSONObject d(String str) {
        if (!TextUtils.isEmpty(str) && e()) {
            JSONObject jSONObject = this.f48154c.get(str);
            if (d.a.l0.a.f1.f.a.f45528a && jSONObject != null) {
                Integer num = this.f48155d.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f48155d.put(str, Integer.valueOf(num.intValue() + 1));
            }
            return jSONObject;
        }
        return null;
    }

    public boolean e() {
        return f48152f > 0 && this.f48153b != -1 && System.currentTimeMillis() - this.f48153b <= ((long) f48152f);
    }

    public void f() {
        if (f48152f <= 0) {
            if (d.a.l0.a.f1.f.a.f45528a) {
                Log.d("SwanPerformance", "cache api close, can't register. duration = " + f48152f);
                return;
            }
            return;
        }
        d.a.l0.a.r1.r.a.f().h(this.f48156e, f48152f);
    }

    public final void g() {
        this.f48153b = -1L;
        if (d.a.l0.a.f1.f.a.f45528a) {
            StringBuilder sb = new StringBuilder();
            sb.append("adopt cache api = [ ");
            for (Map.Entry<String, Integer> entry : this.f48155d.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(" ");
            }
            sb.append("]");
            Log.d("SwanPerformance", sb.toString());
        }
        this.f48155d.clear();
        this.f48154c.clear();
    }

    public void h(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && e()) {
            this.f48154c.put(str, jSONObject);
        }
    }

    public a() {
        this.f48153b = -1L;
        this.f48154c = new ConcurrentHashMap<>(10);
        this.f48155d = new ConcurrentHashMap<>(10);
        this.f48156e = new C0862a();
    }
}
