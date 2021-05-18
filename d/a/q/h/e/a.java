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
    public a.C1785a f64399d;

    /* renamed from: e  reason: collision with root package name */
    public C1788a f64400e;

    /* renamed from: d.a.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1788a {

        /* renamed from: a  reason: collision with root package name */
        public long f64401a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f64402b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f64403c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f64404d;

        /* renamed from: e  reason: collision with root package name */
        public String f64405e;

        public C1788a() {
        }

        public String a() {
            return this.f64404d;
        }

        public void b(String str) {
            String str2 = this.f64404d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64404d = str;
                this.f64402b = true;
            }
        }

        public void c(long j) {
            if (this.f64401a != j) {
                this.f64401a = j;
                this.f64402b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f64405e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64405e = str;
                this.f64402b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f64399d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f64404d = jSONObject.optString("form_id");
                this.f64401a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f64405e = jSONObject.getString("uuid");
                this.f64403c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f64402b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f64404d);
                    jSONObject.put("lst_fe_ts", this.f64401a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f64403c.d());
                    jSONObject.put("uuid", this.f64405e);
                    a.this.f64399d.i("cache.dat", jSONObject.toString(), true);
                    this.f64402b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        this.f64400e = new C1788a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64400e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f64399d = this.f64374a.f(e());
        this.f64400e.e();
        if (TextUtils.isEmpty(this.f64400e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f64400e.d(uuid);
            try {
                this.f64400e.b(d.a.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f64400e.c(System.currentTimeMillis());
        }
        this.f64400e.f();
    }
}
