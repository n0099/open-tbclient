package d.b.p.h.e;

import android.text.TextUtils;
import d.b.p.g.c.a.b;
import d.b.p.g.c.a.e;
import d.b.p.g.d.a;
import d.b.p.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1765a f65178d;

    /* renamed from: e  reason: collision with root package name */
    public C1768a f65179e;

    /* renamed from: d.b.p.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1768a {

        /* renamed from: a  reason: collision with root package name */
        public long f65180a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65181b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f65182c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f65183d;

        /* renamed from: e  reason: collision with root package name */
        public String f65184e;

        public C1768a() {
        }

        public String a() {
            return this.f65183d;
        }

        public void b(String str) {
            String str2 = this.f65183d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65183d = str;
                this.f65181b = true;
            }
        }

        public void c(long j) {
            if (this.f65180a != j) {
                this.f65180a = j;
                this.f65181b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f65184e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65184e = str;
                this.f65181b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f65178d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f65183d = jSONObject.optString("form_id");
                this.f65180a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f65184e = jSONObject.getString("uuid");
                this.f65182c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f65181b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f65183d);
                    jSONObject.put("lst_fe_ts", this.f65180a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f65182c.d());
                    jSONObject.put("uuid", this.f65184e);
                    a.this.f65178d.i("cache.dat", jSONObject.toString(), true);
                    this.f65181b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("iid");
        this.f65179e = new C1768a();
    }

    @Override // d.b.p.h.a
    public String c() {
        return this.f65179e.a();
    }

    @Override // d.b.p.h.a
    public void f(a.c cVar) {
        this.f65178d = this.f65154a.f(e());
        this.f65179e.e();
        if (TextUtils.isEmpty(this.f65179e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f65179e.d(uuid);
            try {
                this.f65179e.b(d.b.p.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f65179e.c(System.currentTimeMillis());
        }
        this.f65179e.f();
    }
}
