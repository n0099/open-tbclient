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
    public a.C1785a f64442d;

    /* renamed from: e  reason: collision with root package name */
    public C1794a f64443e;

    /* renamed from: d.a.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1794a {

        /* renamed from: a  reason: collision with root package name */
        public long f64444a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64445b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64446c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64447d;

        /* renamed from: e  reason: collision with root package name */
        public String f64448e;

        public C1794a() {
        }

        public String a() {
            return this.f64447d;
        }

        public void b(String str) {
            String str2 = this.f64447d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64447d = str;
                this.f64445b = true;
            }
        }

        public String c() {
            return this.f64448e;
        }

        public void d(long j) {
            if (this.f64444a != j) {
                this.f64444a = j;
                this.f64445b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f64448e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64448e = str;
                this.f64445b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f64442d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64447d = jSONObject.optString("form_id");
                this.f64444a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64448e = jSONObject.getString("ssaid");
                this.f64446c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f64445b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64447d);
                    jSONObject.put("lst_fe_ts", this.f64444a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64446c.d());
                    jSONObject.put("ssaid", this.f64448e);
                    a.this.f64442d.i("cache.dat", jSONObject.toString(), true);
                    this.f64445b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f64443e = new C1794a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64443e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64442d = this.f64374a.f(e());
        String string = Settings.Secure.getString(this.f64375b.f64379a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f64443e.f();
        if (TextUtils.isEmpty(this.f64443e.a()) || !TextUtils.equals(string, this.f64443e.c())) {
            this.f64443e.e(string);
            try {
                this.f64443e.b(d.a.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64443e.d(System.currentTimeMillis());
        }
        this.f64443e.g();
    }
}
