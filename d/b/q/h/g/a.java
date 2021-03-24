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
    public a.C1752a f64525d;

    /* renamed from: e  reason: collision with root package name */
    public C1761a f64526e;

    /* renamed from: d.b.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1761a {

        /* renamed from: a  reason: collision with root package name */
        public long f64527a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64528b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64529c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64530d;

        /* renamed from: e  reason: collision with root package name */
        public String f64531e;

        public C1761a() {
        }

        public String a() {
            return this.f64530d;
        }

        public void b(String str) {
            String str2 = this.f64530d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64530d = str;
                this.f64528b = true;
            }
        }

        public String c() {
            return this.f64531e;
        }

        public void d(long j) {
            if (this.f64527a != j) {
                this.f64527a = j;
                this.f64528b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64531e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64531e = str;
                this.f64528b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f64525d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64530d = jSONObject.optString("form_id");
                this.f64527a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64531e = jSONObject.getString("ssaid");
                this.f64529c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f64528b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64530d);
                    jSONObject.put("lst_fe_ts", this.f64527a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64529c.d());
                    jSONObject.put("ssaid", this.f64531e);
                    a.this.f64525d.i("cache.dat", jSONObject.toString(), true);
                    this.f64528b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f64526e = new C1761a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64526e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f64525d = this.f64459a.f(e());
        String string = Settings.Secure.getString(this.f64460b.f64464a.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.f64526e.f();
        if (TextUtils.isEmpty(this.f64526e.a()) || !TextUtils.equals(string, this.f64526e.c())) {
            this.f64526e.e(string);
            try {
                this.f64526e.b(d.b.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64526e.d(System.currentTimeMillis());
        }
        this.f64526e.g();
    }
}
