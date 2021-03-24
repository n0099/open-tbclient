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
    public a.C1752a f64483d;

    /* renamed from: e  reason: collision with root package name */
    public C1755a f64484e;

    /* renamed from: d.b.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1755a {

        /* renamed from: a  reason: collision with root package name */
        public long f64485a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64486b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64487c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64488d;

        /* renamed from: e  reason: collision with root package name */
        public String f64489e;

        public C1755a() {
        }

        public String a() {
            return this.f64488d;
        }

        public void b(String str) {
            String str2 = this.f64488d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64488d = str;
                this.f64486b = true;
            }
        }

        public void c(long j) {
            if (this.f64485a != j) {
                this.f64485a = j;
                this.f64486b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f64489e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64489e = str;
                this.f64486b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f64483d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64488d = jSONObject.optString("form_id");
                this.f64485a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64489e = jSONObject.getString("uuid");
                this.f64487c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f64486b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64488d);
                    jSONObject.put("lst_fe_ts", this.f64485a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64487c.d());
                    jSONObject.put("uuid", this.f64489e);
                    a.this.f64483d.i("cache.dat", jSONObject.toString(), true);
                    this.f64486b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("iid");
        this.f64484e = new C1755a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64484e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64483d = this.f64459a.f(e());
        this.f64484e.e();
        if (TextUtils.isEmpty(this.f64484e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f64484e.d(uuid);
            try {
                this.f64484e.b(d.b.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64484e.c(System.currentTimeMillis());
        }
        this.f64484e.f();
    }
}
