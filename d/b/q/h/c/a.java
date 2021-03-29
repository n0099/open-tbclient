package d.b.q.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.trusts.zone.TrustSubject;
import d.b.q.g.c.a.e;
import d.b.q.g.c.a.f;
import d.b.q.g.d.a;
import d.b.q.h.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1753a f64472d;

    /* renamed from: e  reason: collision with root package name */
    public b f64473e;

    /* renamed from: d.b.q.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1755a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f64474a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f64475b = new HashSet<>();

        public static C1755a a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-aid");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                try {
                    C1755a c1755a = new C1755a();
                    JSONObject jSONObject = new JSONObject(m);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            c1755a.f64474a.add(optJSONArray.getString(i));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            c1755a.f64475b.add(optJSONArray2.getString(i2));
                        }
                    }
                    return c1755a;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            } catch (TrustSubject.ConfigNotFoundException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        public boolean b(String str) {
            return this.f64474a.contains(str);
        }

        public boolean c(String str) {
            return this.f64475b.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f64476a;

        /* renamed from: b  reason: collision with root package name */
        public String f64477b;

        /* renamed from: c  reason: collision with root package name */
        public String f64478c;

        /* renamed from: d  reason: collision with root package name */
        public long f64479d;

        /* renamed from: f  reason: collision with root package name */
        public String f64481f;

        /* renamed from: h  reason: collision with root package name */
        public long f64483h;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64480e = true;

        /* renamed from: g  reason: collision with root package name */
        public e f64482g = new e();

        public b() {
        }

        public void a(long j) {
            if (j != this.f64479d) {
                this.f64479d = j;
                this.f64480e = true;
            }
        }

        public void b(long j, long j2) {
            if (this.f64482g.c(j, j2)) {
                this.f64480e = true;
            }
        }

        public void c(String str) {
            String str2 = this.f64477b;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64477b = str;
                this.f64480e = true;
            }
        }

        public void d(byte[] bArr) {
            if (Arrays.equals(bArr, this.f64476a)) {
                return;
            }
            this.f64476a = bArr;
            this.f64480e = true;
        }

        public byte[] e() {
            return this.f64476a;
        }

        public long f(long j) {
            return this.f64482g.a(j);
        }

        public String g() {
            return this.f64477b;
        }

        public void h(String str) {
            String str2 = this.f64478c;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64478c = str;
                this.f64480e = true;
            }
        }

        public String i() {
            return this.f64478c;
        }

        public void j(long j) {
            if (this.f64483h != j) {
                this.f64483h = j;
                this.f64480e = true;
            }
        }

        public void k(String str) {
            String str2 = this.f64481f;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64481f = str;
                this.f64480e = true;
            }
        }

        public long l() {
            return this.f64483h;
        }

        public boolean m() {
            String g2 = a.this.f64472d.g("aid.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64476a = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f64479d = jSONObject.getLong("gen_ts");
                    this.f64478c = jSONObject.getString("form_id");
                    this.f64477b = jSONObject.getString("and_id");
                    this.f64481f = jSONObject.optString("ran_id", null);
                    this.f64482g.b(jSONObject.getLong("flags"));
                    this.f64483h = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f64480e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean n() {
            if (this.f64480e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f64477b);
                    jSONObject.put("form_id", this.f64478c);
                    jSONObject.put("gen_ts", this.f64479d);
                    jSONObject.put("flags", this.f64482g.d());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f64481f)) {
                        jSONObject.put("ran_id", this.f64481f);
                    }
                    if (this.f64476a != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f64476a, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f64483h);
                    a.this.f64472d.i("aid.dat", jSONObject.toString(), true);
                    this.f64480e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.f64473e = new b();
    }

    public static String i(byte[] bArr) {
        return d.b.q.h.a.b("A00", new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr));
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f64473e.i();
    }

    @Override // d.b.q.h.a
    public byte[] d() {
        return this.f64473e.e();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:1|(2:3|(4:5|6|(1:49)(1:12)|(12:17|(1:19)(1:48)|20|21|22|23|(1:25)|26|(2:(2:39|40)|31)(2:(2:42|(1:44))|40)|(3:33|(1:35)|36)|37|38)(1:15)))(1:51)|50|6|(1:8)|49|(0)|17|(0)(0)|20|21|22|23|(0)|26|(0)(0)|(0)|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
        if (r13.c(r6) != false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009d  */
    @Override // d.b.q.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        this.f64472d = this.f64460a.f("aid");
        this.f64473e.m();
        TrustSubject trustSubject = this.f64461b.f64467c.f6295b;
        boolean z3 = false;
        boolean z4 = true;
        if (trustSubject != null) {
            j = trustSubject.n();
            if (j != this.f64473e.l()) {
                z = true;
                z2 = !TextUtils.isEmpty(this.f64473e.i()) || this.f64473e.e() == null || TextUtils.isEmpty(this.f64473e.g());
                if (!z2 || z) {
                    str = null;
                    C1755a a2 = trustSubject == null ? C1755a.a(trustSubject) : null;
                    str = Settings.Secure.getString(this.f64461b.f64465a.getContentResolver(), "android_id");
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (z2) {
                        if (a2 != null) {
                            if (this.f64473e.f(1L) == 0) {
                            }
                        }
                        z4 = false;
                    } else {
                        if (a2 == null || !a2.b(str)) {
                            z3 = true;
                            z4 = false;
                        }
                        z3 = true;
                    }
                    if (z3) {
                        String str2 = "com.helios" + str;
                        if (z4) {
                            String uuid = UUID.randomUUID().toString();
                            this.f64473e.k(uuid);
                            str2 = str2 + uuid;
                            this.f64473e.b(1L, 1L);
                        }
                        byte[] a3 = f.a(str2, "utf-8");
                        String i = i(a3);
                        this.f64473e.d(a3);
                        this.f64473e.a(System.currentTimeMillis());
                        this.f64473e.c(str);
                        this.f64473e.h(i);
                    }
                    this.f64473e.j(j);
                    this.f64473e.n();
                }
                return;
            }
        } else {
            j = 0;
        }
        z = false;
        if (TextUtils.isEmpty(this.f64473e.i())) {
        }
        if (z2) {
        }
        str = null;
        if (trustSubject == null) {
        }
        str = Settings.Secure.getString(this.f64461b.f64465a.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(str)) {
        }
        if (z2) {
        }
        if (z3) {
        }
        this.f64473e.j(j);
        this.f64473e.n();
    }
}
