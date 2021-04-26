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
    public a.C1722a f63762d;

    /* renamed from: e  reason: collision with root package name */
    public C1725a f63763e;

    /* renamed from: d.a.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1725a {

        /* renamed from: a  reason: collision with root package name */
        public long f63764a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f63765b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f63766c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f63767d;

        /* renamed from: e  reason: collision with root package name */
        public String f63768e;

        public C1725a() {
        }

        public String a() {
            return this.f63767d;
        }

        public void b(String str) {
            String str2 = this.f63767d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63767d = str;
                this.f63765b = true;
            }
        }

        public void c(long j) {
            if (this.f63764a != j) {
                this.f63764a = j;
                this.f63765b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f63768e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f63768e = str;
                this.f63765b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f63762d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f63767d = jSONObject.optString("form_id");
                this.f63764a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f63768e = jSONObject.getString("uuid");
                this.f63766c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f63765b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f63767d);
                    jSONObject.put("lst_fe_ts", this.f63764a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f63766c.d());
                    jSONObject.put("uuid", this.f63768e);
                    a.this.f63762d.i("cache.dat", jSONObject.toString(), true);
                    this.f63765b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        this.f63763e = new C1725a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f63763e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f63762d = this.f63737a.f(e());
        this.f63763e.e();
        if (TextUtils.isEmpty(this.f63763e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f63763e.d(uuid);
            try {
                this.f63763e.b(d.a.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f63763e.c(System.currentTimeMillis());
        }
        this.f63763e.f();
    }
}
