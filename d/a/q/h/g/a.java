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
    public a.C1722a f63805d;

    /* renamed from: e  reason: collision with root package name */
    public C1731a f63806e;

    /* renamed from: d.a.q.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1731a {

        /* renamed from: a  reason: collision with root package name */
        public long f63807a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63808b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f63809c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f63810d;

        /* renamed from: e  reason: collision with root package name */
        public String f63811e;

        public C1731a() {
        }

        public String a() {
            return this.f63810d;
        }

        public void b(String str) {
            String str2 = this.f63810d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63810d = str;
                this.f63808b = true;
            }
        }

        public String c() {
            return this.f63811e;
        }

        public void d(long j) {
            if (this.f63807a != j) {
                this.f63807a = j;
                this.f63808b = true;
            }
        }

        public void e(String str) {
            String str2 = this.f63811e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63811e = str;
                this.f63808b = true;
            }
        }

        public boolean f() {
            String g2 = a.this.f63805d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f63810d = jSONObject.optString("form_id");
                this.f63807a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f63811e = jSONObject.getString("ssaid");
                this.f63809c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean g() {
            if (this.f63808b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f63810d);
                    jSONObject.put("lst_fe_ts", this.f63807a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f63809c.d());
                    jSONObject.put("ssaid", this.f63811e);
                    a.this.f63805d.i("cache.dat", jSONObject.toString(), true);
                    this.f63808b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.f63806e = new C1731a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f63806e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f63805d = this.f63737a.f(e());
        String string = Settings.Secure.getString(this.f63738b.f63742a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (string == null) {
            string = "0";
        }
        this.f63806e.f();
        if (TextUtils.isEmpty(this.f63806e.a()) || !TextUtils.equals(string, this.f63806e.c())) {
            this.f63806e.e(string);
            try {
                this.f63806e.b(d.a.q.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f63806e.d(System.currentTimeMillis());
        }
        this.f63806e.g();
    }
}
