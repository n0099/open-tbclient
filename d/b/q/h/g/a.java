package d.b.q.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import d.b.q.g.c.a.b;
import d.b.q.g.c.a.e;
import d.b.q.g.d.a;
import d.b.q.h.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1753a f64526d;

    /* renamed from: e  reason: collision with root package name */
    public C1762a f64527e;

    /* renamed from: d.b.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1762a {

        /* renamed from: a  reason: collision with root package name */
        public long f64528a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64529b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64530c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64531d;

        /* renamed from: e  reason: collision with root package name */
        public String f64532e;

        public C1762a() {
        }

        public String a() {
            return this.f64531d;
        }

        public void b(String str) {
            String str2 = this.f64531d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64531d = str;
                this.f64529b = true;
            }
        }

        public String c() {
            return this.f64532e;
        }

        public void d(long j) {
            if (this.f64528a != j) {
                this.f64528a = j;
                this.f64529b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64532e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64532e = str;
                this.f64529b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f64526d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64531d = jSONObject.optString("form_id");
                this.f64528a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64532e = jSONObject.getString("ssaid");
                this.f64530c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f64529b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64531d);
                    jSONObject.put("lst_fe_ts", this.f64528a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64530c.d());
                    jSONObject.put("ssaid", this.f64532e);
                    a.this.f64526d.i("cache.dat", jSONObject.toString(), true);
                    this.f64529b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f64527e = new C1762a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64527e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64526d = this.f64460a.f(e());
        String string = Settings.Secure.getString(this.f64461b.f64465a.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.f64527e.f();
        if (TextUtils.isEmpty(this.f64527e.a()) || !TextUtils.equals(string, this.f64527e.c())) {
            this.f64527e.e(string);
            try {
                this.f64527e.b(d.b.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64527e.d(System.currentTimeMillis());
        }
        this.f64527e.g();
    }
}
