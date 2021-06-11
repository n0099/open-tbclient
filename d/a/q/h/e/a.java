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
    public a.C1846a f67993d;

    /* renamed from: e  reason: collision with root package name */
    public C1849a f67994e;

    /* renamed from: d.a.q.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1849a {

        /* renamed from: a  reason: collision with root package name */
        public long f67995a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f67996b = true;

        /* renamed from: c  reason: collision with root package name */
        public e f67997c = new e();

        /* renamed from: d  reason: collision with root package name */
        public String f67998d;

        /* renamed from: e  reason: collision with root package name */
        public String f67999e;

        public C1849a() {
        }

        public String a() {
            return this.f67998d;
        }

        public void b(String str) {
            String str2 = this.f67998d;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67998d = str;
                this.f67996b = true;
            }
        }

        public void c(long j) {
            if (this.f67995a != j) {
                this.f67995a = j;
                this.f67996b = true;
            }
        }

        public void d(String str) {
            String str2 = this.f67999e;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67999e = str;
                this.f67996b = true;
            }
        }

        public boolean e() {
            String g2 = a.this.f67993d.g("cache.dat", true);
            if (TextUtils.isEmpty(g2)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f67998d = jSONObject.optString("form_id");
                this.f67995a = jSONObject.getLong("lst_fe_ts");
                jSONObject.getInt("c_form_ver");
                this.f67999e = jSONObject.getString("uuid");
                this.f67997c.b(jSONObject.getLong("flags"));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean f() {
            if (this.f67996b) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f67998d);
                    jSONObject.put("lst_fe_ts", this.f67995a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f67997c.d());
                    jSONObject.put("uuid", this.f67999e);
                    a.this.f67993d.i("cache.dat", jSONObject.toString(), true);
                    this.f67996b = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super(CommonUrlParamManager.PARAM_IID);
        this.f67994e = new C1849a();
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f67994e.a();
    }

    @Override // d.a.q.h.a
    public void f(a.c cVar) {
        this.f67993d = this.f67968a.f(e());
        this.f67994e.e();
        if (TextUtils.isEmpty(this.f67994e.a())) {
            String uuid = UUID.randomUUID().toString();
            this.f67994e.d(uuid);
            try {
                this.f67994e.b(d.a.q.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
            } catch (Exception unused) {
            }
            this.f67994e.c(System.currentTimeMillis());
        }
        this.f67994e.f();
    }
}
