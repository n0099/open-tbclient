package d.b.p.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.b.p.g.c.a.b;
import d.b.p.g.c.a.e;
import d.b.p.g.d.a;
import d.b.p.h.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1765a f65220d;

    /* renamed from: e  reason: collision with root package name */
    public C1774a f65221e;

    /* renamed from: d.b.p.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1774a {

        /* renamed from: a  reason: collision with root package name */
        public long f65222a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65223b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f65224c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f65225d;

        /* renamed from: e  reason: collision with root package name */
        public String f65226e;

        public C1774a() {
        }

        public String a() {
            return this.f65225d;
        }

        public void b(String str) {
            String str2 = this.f65225d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65225d = str;
                this.f65223b = true;
            }
        }

        public String c() {
            return this.f65226e;
        }

        public void d(long j) {
            if (this.f65222a != j) {
                this.f65222a = j;
                this.f65223b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f65226e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65226e = str;
                this.f65223b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f65220d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f65225d = jSONObject.optString("form_id");
                this.f65222a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f65226e = jSONObject.getString("ssaid");
                this.f65224c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f65223b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f65225d);
                    jSONObject.put("lst_fe_ts", this.f65222a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f65224c.d());
                    jSONObject.put("ssaid", this.f65226e);
                    a.this.f65220d.i("cache.dat", jSONObject.toString(), true);
                    this.f65223b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f65221e = new C1774a();
    }

    @Override // d.b.p.h.a
    public String c() {
        return this.f65221e.a();
    }

    @Override // d.b.p.h.a
    public void f(a.c cVar) {
        this.f65220d = this.f65154a.f(e());
        String string = Settings.Secure.getString(this.f65155b.f65159a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f65221e.f();
        if (TextUtils.isEmpty(this.f65221e.a()) || !TextUtils.equals(string, this.f65221e.c())) {
            this.f65221e.e(string);
            try {
                this.f65221e.b(d.b.p.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f65221e.d(System.currentTimeMillis());
        }
        this.f65221e.g();
    }
}
