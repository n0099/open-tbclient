package d.b.q.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.b.q.g.c.a.b;
import d.b.q.g.c.a.e;
import d.b.q.g.d.a;
import d.b.q.h.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1784a f65484d;

    /* renamed from: e  reason: collision with root package name */
    public C1793a f65485e;

    /* renamed from: d.b.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1793a {

        /* renamed from: a  reason: collision with root package name */
        public long f65486a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f65487b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f65488c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f65489d;

        /* renamed from: e  reason: collision with root package name */
        public String f65490e;

        public C1793a() {
        }

        public String a() {
            return this.f65489d;
        }

        public void b(String str) {
            String str2 = this.f65489d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65489d = str;
                this.f65487b = true;
            }
        }

        public String c() {
            return this.f65490e;
        }

        public void d(long j) {
            if (this.f65486a != j) {
                this.f65486a = j;
                this.f65487b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f65490e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65490e = str;
                this.f65487b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f65484d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f65489d = jSONObject.optString("form_id");
                this.f65486a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f65490e = jSONObject.getString("ssaid");
                this.f65488c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f65487b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f65489d);
                    jSONObject.put("lst_fe_ts", this.f65486a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f65488c.d());
                    jSONObject.put("ssaid", this.f65490e);
                    a.this.f65484d.i("cache.dat", jSONObject.toString(), true);
                    this.f65487b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f65485e = new C1793a();
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f65485e.a();
    }

    @Override // d.b.q.h.a
    public void f(a.c cVar) {
        this.f65484d = this.f65418a.f(e());
        String string = Settings.Secure.getString(this.f65419b.f65423a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f65485e.f();
        if (TextUtils.isEmpty(this.f65485e.a()) || !TextUtils.equals(string, this.f65485e.c())) {
            this.f65485e.e(string);
            try {
                this.f65485e.b(d.b.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f65485e.d(System.currentTimeMillis());
        }
        this.f65485e.g();
    }
}
