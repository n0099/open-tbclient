package d.a.i0.a.r1.k.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.i0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f44302f = e.c();

    /* renamed from: b  reason: collision with root package name */
    public long f44303b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f44304c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f44305d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.a.r1.r.c.a f44306e;

    /* renamed from: d.a.i0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0795a implements d.a.i0.a.r1.r.c.a {
        public C0795a() {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void b() {
            a.this.g();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.g();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public void d(String str) {
            a.this.f44303b = System.currentTimeMillis();
        }

        @Override // d.a.i0.a.r1.r.c.a
        public String getName() {
            return "LaunchApiCache";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44308a = new a(null);
    }

    public /* synthetic */ a(C0795a c0795a) {
        this();
    }

    public static a c() {
        return b.f44308a;
    }

    public JSONObject d(String str) {
        if (!TextUtils.isEmpty(str) && e()) {
            JSONObject jSONObject = this.f44304c.get(str);
            if (d.a.i0.a.f1.f.a.f41678a && jSONObject != null) {
                Integer num = this.f44305d.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f44305d.put(str, Integer.valueOf(num.intValue() + 1));
            }
            return jSONObject;
        }
        return null;
    }

    public boolean e() {
        return f44302f > 0 && this.f44303b != -1 && System.currentTimeMillis() - this.f44303b <= ((long) f44302f);
    }

    public void f() {
        if (f44302f <= 0) {
            if (d.a.i0.a.f1.f.a.f41678a) {
                Log.d("SwanPerformance", "cache api close, can't register. duration = " + f44302f);
                return;
            }
            return;
        }
        d.a.i0.a.r1.r.a.f().h(this.f44306e, f44302f);
    }

    public final void g() {
        this.f44303b = -1L;
        if (d.a.i0.a.f1.f.a.f41678a) {
            StringBuilder sb = new StringBuilder();
            sb.append("adopt cache api = [ ");
            for (Map.Entry<String, Integer> entry : this.f44305d.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(" ");
            }
            sb.append("]");
            Log.d("SwanPerformance", sb.toString());
        }
        this.f44305d.clear();
        this.f44304c.clear();
    }

    public void h(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && e()) {
            this.f44304c.put(str, jSONObject);
        }
    }

    public a() {
        this.f44303b = -1L;
        this.f44304c = new ConcurrentHashMap<>(10);
        this.f44305d = new ConcurrentHashMap<>(10);
        this.f44306e = new C0795a();
    }
}
