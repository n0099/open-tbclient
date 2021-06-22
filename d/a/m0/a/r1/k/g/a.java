package d.a.m0.a.r1.k.g;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import d.a.m0.a.r1.l.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements d.a.m0.a.f1.f.a {

    /* renamed from: f  reason: collision with root package name */
    public static final int f48260f = e.c();

    /* renamed from: b  reason: collision with root package name */
    public long f48261b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f48262c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f48263d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.a.r1.r.c.a f48264e;

    /* renamed from: d.a.m0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0865a implements d.a.m0.a.r1.r.c.a {
        public C0865a() {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void a(String str) {
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void b() {
            a.this.g();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void c(boolean z) {
            a.this.g();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public void d(String str) {
            a.this.f48261b = System.currentTimeMillis();
        }

        @Override // d.a.m0.a.r1.r.c.a
        public String getName() {
            return "LaunchApiCache";
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f48266a = new a(null);
    }

    public /* synthetic */ a(C0865a c0865a) {
        this();
    }

    public static a c() {
        return b.f48266a;
    }

    public JSONObject d(String str) {
        if (!TextUtils.isEmpty(str) && e()) {
            JSONObject jSONObject = this.f48262c.get(str);
            if (d.a.m0.a.f1.f.a.f45636a && jSONObject != null) {
                Integer num = this.f48263d.get(str);
                if (num == null) {
                    num = 0;
                }
                this.f48263d.put(str, Integer.valueOf(num.intValue() + 1));
            }
            return jSONObject;
        }
        return null;
    }

    public boolean e() {
        return f48260f > 0 && this.f48261b != -1 && System.currentTimeMillis() - this.f48261b <= ((long) f48260f);
    }

    public void f() {
        if (f48260f <= 0) {
            if (d.a.m0.a.f1.f.a.f45636a) {
                Log.d("SwanPerformance", "cache api close, can't register. duration = " + f48260f);
                return;
            }
            return;
        }
        d.a.m0.a.r1.r.a.f().h(this.f48264e, f48260f);
    }

    public final void g() {
        this.f48261b = -1L;
        if (d.a.m0.a.f1.f.a.f45636a) {
            StringBuilder sb = new StringBuilder();
            sb.append("adopt cache api = [ ");
            for (Map.Entry<String, Integer> entry : this.f48263d.entrySet()) {
                sb.append((Object) entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(" ");
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            Log.d("SwanPerformance", sb.toString());
        }
        this.f48263d.clear();
        this.f48262c.clear();
    }

    public void h(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str) && e()) {
            this.f48262c.put(str, jSONObject);
        }
    }

    public a() {
        this.f48261b = -1L;
        this.f48262c = new ConcurrentHashMap<>(10);
        this.f48263d = new ConcurrentHashMap<>(10);
        this.f48264e = new C0865a();
    }
}
