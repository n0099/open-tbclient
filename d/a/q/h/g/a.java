package d.a.q.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.a.q.g.c.a.b;
import d.a.q.g.c.a.e;
import d.a.q.g.d.a;
import d.a.q.h.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1788a f64318d;

    /* renamed from: e  reason: collision with root package name */
    public C1797a f64319e;

    /* renamed from: d.a.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1797a {

        /* renamed from: a  reason: collision with root package name */
        public long f64320a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64321b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64322c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64323d;

        /* renamed from: e  reason: collision with root package name */
        public String f64324e;

        public C1797a() {
        }

        public String a() {
            return this.f64323d;
        }

        public void b(String str) {
            String str2 = this.f64323d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64323d = str;
                this.f64321b = true;
            }
        }

        public String c() {
            return this.f64324e;
        }

        public void d(long j) {
            if (this.f64320a != j) {
                this.f64320a = j;
                this.f64321b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64324e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64324e = str;
                this.f64321b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f64318d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64323d = jSONObject.optString("form_id");
                this.f64320a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64324e = jSONObject.getString("ssaid");
                this.f64322c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f64321b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64323d);
                    jSONObject.put("lst_fe_ts", this.f64320a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64322c.d());
                    jSONObject.put("ssaid", this.f64324e);
                    a.this.f64318d.i("cache.dat", jSONObject.toString(), true);
                    this.f64321b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f64319e = new C1797a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64319e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64318d = this.f64250a.f(e());
        String string = Settings.Secure.getString(this.f64251b.f64255a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f64319e.f();
        if (TextUtils.isEmpty(this.f64319e.a()) || !TextUtils.equals(string, this.f64319e.c())) {
            this.f64319e.e(string);
            try {
                this.f64319e.b(d.a.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64319e.d(System.currentTimeMillis());
        }
        this.f64319e.g();
    }
}
