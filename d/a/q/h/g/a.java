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
    public a.C1848a f67992d;

    /* renamed from: e  reason: collision with root package name */
    public C1857a f67993e;

    /* renamed from: d.a.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1857a {

        /* renamed from: a  reason: collision with root package name */
        public long f67994a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67995b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f67996c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f67997d;

        /* renamed from: e  reason: collision with root package name */
        public String f67998e;

        public C1857a() {
        }

        public String a() {
            return this.f67997d;
        }

        public void b(String str) {
            String str2 = this.f67997d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67997d = str;
                this.f67995b = true;
            }
        }

        public String c() {
            return this.f67998e;
        }

        public void d(long j) {
            if (this.f67994a != j) {
                this.f67994a = j;
                this.f67995b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f67998e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67998e = str;
                this.f67995b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f67992d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f67997d = jSONObject.optString("form_id");
                this.f67994a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f67998e = jSONObject.getString("ssaid");
                this.f67996c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f67995b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f67997d);
                    jSONObject.put("lst_fe_ts", this.f67994a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f67996c.d());
                    jSONObject.put("ssaid", this.f67998e);
                    a.this.f67992d.i("cache.dat", jSONObject.toString(), true);
                    this.f67995b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f67993e = new C1857a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f67993e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f67992d = this.f67924a.f(e());
        String string = Settings.Secure.getString(this.f67925b.f67929a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f67993e.f();
        if (TextUtils.isEmpty(this.f67993e.a()) || !TextUtils.equals(string, this.f67993e.c())) {
            this.f67993e.e(string);
            try {
                this.f67993e.b(d.a.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f67993e.d(System.currentTimeMillis());
        }
        this.f67993e.g();
    }
}
