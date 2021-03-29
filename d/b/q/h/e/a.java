package d.b.q.h.e;

import android.text.TextUtils;
import d.b.q.g.c.a.b;
import d.b.q.g.c.a.e;
import d.b.q.g.d.a;
import d.b.q.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1753a f64484d;

    /* renamed from: e  reason: collision with root package name */
    public C1756a f64485e;

    /* renamed from: d.b.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1756a {

        /* renamed from: a  reason: collision with root package name */
        public long f64486a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64487b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64488c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64489d;

        /* renamed from: e  reason: collision with root package name */
        public String f64490e;

        public C1756a() {
        }

        public String a() {
            return this.f64489d;
        }

        public void b(String str) {
            String str2 = this.f64489d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64489d = str;
                this.f64487b = true;
            }
        }

        public void c(long j) {
            if (this.f64486a != j) {
                this.f64486a = j;
                this.f64487b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f64490e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64490e = str;
                this.f64487b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f64484d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64489d = jSONObject.optString("form_id");
                this.f64486a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64490e = jSONObject.getString("uuid");
                this.f64488c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f64487b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64489d);
                    jSONObject.put("lst_fe_ts", this.f64486a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64488c.d());
                    jSONObject.put("uuid", this.f64490e);
                    a.this.f64484d.i("cache.dat", jSONObject.toString(), true);
                    this.f64487b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("iid");
        this.f64485e = new C1756a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64485e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64484d = this.f64460a.f(e());
        this.f64485e.e();
        if (TextUtils.isEmpty(this.f64485e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f64485e.d(uuid);
            try {
                this.f64485e.b(d.b.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64485e.c(System.currentTimeMillis());
        }
        this.f64485e.f();
    }
}
