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
    public a.C1846a f68036d;

    /* renamed from: e  reason: collision with root package name */
    public C1855a f68037e;

    /* renamed from: d.a.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1855a {

        /* renamed from: a  reason: collision with root package name */
        public long f68038a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f68039b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f68040c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f68041d;

        /* renamed from: e  reason: collision with root package name */
        public String f68042e;

        public C1855a() {
        }

        public String a() {
            return this.f68041d;
        }

        public void b(String str) {
            String str2 = this.f68041d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f68041d = str;
                this.f68039b = true;
            }
        }

        public String c() {
            return this.f68042e;
        }

        public void d(long j) {
            if (this.f68038a != j) {
                this.f68038a = j;
                this.f68039b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f68042e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f68042e = str;
                this.f68039b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f68036d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f68041d = jSONObject.optString("form_id");
                this.f68038a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f68042e = jSONObject.getString("ssaid");
                this.f68040c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f68039b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f68041d);
                    jSONObject.put("lst_fe_ts", this.f68038a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f68040c.d());
                    jSONObject.put("ssaid", this.f68042e);
                    a.this.f68036d.i("cache.dat", jSONObject.toString(), true);
                    this.f68039b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f68037e = new C1855a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f68037e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f68036d = this.f67968a.f(e());
        String string = Settings.Secure.getString(this.f67969b.f67973a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f68037e.f();
        if (TextUtils.isEmpty(this.f68037e.a()) || !TextUtils.equals(string, this.f68037e.c())) {
            this.f68037e.e(string);
            try {
                this.f68037e.b(d.a.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f68037e.d(System.currentTimeMillis());
        }
        this.f68037e.g();
    }
}
