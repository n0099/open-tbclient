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
    public a.C1784a f65442d;

    /* renamed from: e  reason: collision with root package name */
    public C1787a f65443e;

    /* renamed from: d.b.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1787a {

        /* renamed from: a  reason: collision with root package name */
        public long f65444a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65445b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f65446c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f65447d;

        /* renamed from: e  reason: collision with root package name */
        public String f65448e;

        public C1787a() {
        }

        public String a() {
            return this.f65447d;
        }

        public void b(String str) {
            String str2 = this.f65447d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65447d = str;
                this.f65445b = true;
            }
        }

        public void c(long j) {
            if (this.f65444a != j) {
                this.f65444a = j;
                this.f65445b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f65448e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65448e = str;
                this.f65445b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f65442d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f65447d = jSONObject.optString("form_id");
                this.f65444a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f65448e = jSONObject.getString("uuid");
                this.f65446c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f65445b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f65447d);
                    jSONObject.put("lst_fe_ts", this.f65444a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f65446c.d());
                    jSONObject.put("uuid", this.f65448e);
                    a.this.f65442d.i("cache.dat", jSONObject.toString(), true);
                    this.f65445b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("iid");
        this.f65443e = new C1787a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f65443e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f65442d = this.f65418a.f(e());
        this.f65443e.e();
        if (TextUtils.isEmpty(this.f65443e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f65443e.d(uuid);
            try {
                this.f65443e.b(d.b.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f65443e.c(System.currentTimeMillis());
        }
        this.f65443e.f();
    }
}
