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
    public a.C1848a f67949d;

    /* renamed from: e  reason: collision with root package name */
    public C1851a f67950e;

    /* renamed from: d.a.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1851a {

        /* renamed from: a  reason: collision with root package name */
        public long f67951a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67952b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f67953c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f67954d;

        /* renamed from: e  reason: collision with root package name */
        public String f67955e;

        public C1851a() {
        }

        public String a() {
            return this.f67954d;
        }

        public void b(String str) {
            String str2 = this.f67954d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67954d = str;
                this.f67952b = true;
            }
        }

        public void c(long j) {
            if (this.f67951a != j) {
                this.f67951a = j;
                this.f67952b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f67955e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67955e = str;
                this.f67952b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f67949d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f67954d = jSONObject.optString("form_id");
                this.f67951a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f67955e = jSONObject.getString("uuid");
                this.f67953c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f67952b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f67954d);
                    jSONObject.put("lst_fe_ts", this.f67951a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f67953c.d());
                    jSONObject.put("uuid", this.f67955e);
                    a.this.f67949d.i("cache.dat", jSONObject.toString(), true);
                    this.f67952b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        this.f67950e = new C1851a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f67950e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f67949d = this.f67924a.f(e());
        this.f67950e.e();
        if (TextUtils.isEmpty(this.f67950e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f67950e.d(uuid);
            try {
                this.f67950e.b(d.a.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f67950e.c(System.currentTimeMillis());
        }
        this.f67950e.f();
    }
}
