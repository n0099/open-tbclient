package d.a.q.h.e;

import android.text.TextUtils;
import com.baidu.common.param.CommonUrlParamManager;
import d.a.q.g.c.a.b;
import d.a.q.g.c.a.e;
import d.a.q.g.d.a;
import d.a.q.h.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1788a f64275d;

    /* renamed from: e  reason: collision with root package name */
    public C1791a f64276e;

    /* renamed from: d.a.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1791a {

        /* renamed from: a  reason: collision with root package name */
        public long f64277a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64278b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64279c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64280d;

        /* renamed from: e  reason: collision with root package name */
        public String f64281e;

        public C1791a() {
        }

        public String a() {
            return this.f64280d;
        }

        public void b(String str) {
            String str2 = this.f64280d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64280d = str;
                this.f64278b = true;
            }
        }

        public void c(long j) {
            if (this.f64277a != j) {
                this.f64277a = j;
                this.f64278b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f64281e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64281e = str;
                this.f64278b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f64275d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64280d = jSONObject.optString("form_id");
                this.f64277a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64281e = jSONObject.getString("uuid");
                this.f64279c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f64278b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64280d);
                    jSONObject.put("lst_fe_ts", this.f64277a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64279c.d());
                    jSONObject.put("uuid", this.f64281e);
                    a.this.f64275d.i("cache.dat", jSONObject.toString(), true);
                    this.f64278b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        this.f64276e = new C1791a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64276e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64275d = this.f64250a.f(e());
        this.f64276e.e();
        if (TextUtils.isEmpty(this.f64276e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f64276e.d(uuid);
            try {
                this.f64276e.b(d.a.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64276e.c(System.currentTimeMillis());
        }
        this.f64276e.f();
    }
}
