package d.b.q.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
    public a.C1784a f65430d;

    /* renamed from: e  reason: collision with root package name */
    public b f65431e;

    /* renamed from: d.b.q.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1786a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f65432a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f65433b = new HashSet<>();

        public static C1786a a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-aid");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                try {
                    C1786a c1786a = new C1786a();
                    JSONObject jSONObject = new JSONObject(m);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            c1786a.f65432a.add(optJSONArray.getString(i));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            c1786a.f65433b.add(optJSONArray2.getString(i2));
                        }
                    }
                    return c1786a;
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
            return this.f65432a.contains(str);
        }

        public boolean c(String str) {
            return this.f65433b.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f65434a;

        /* renamed from: b  reason: collision with root package name */
        public String f65435b;

        /* renamed from: c  reason: collision with root package name */
        public String f65436c;

        /* renamed from: d  reason: collision with root package name */
        public long f65437d;

        /* renamed from: f  reason: collision with root package name */
        public String f65439f;

        /* renamed from: h  reason: collision with root package name */
        public long f65441h;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65438e = true;

        /* renamed from: g  reason: collision with root package name */
        public e f65440g = new e();

        public b() {
        }

        public void a(long j) {
            if (j != this.f65437d) {
                this.f65437d = j;
                this.f65438e = true;
            }
        }

        public void b(long j, long j2) {
            if (this.f65440g.c(j, j2)) {
                this.f65438e = true;
            }
        }

        public void c(String str) {
            String str2 = this.f65435b;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65435b = str;
                this.f65438e = true;
            }
        }

        public void d(byte[] bArr) {
            if (Arrays.equals(bArr, this.f65434a)) {
                return;
            }
            this.f65434a = bArr;
            this.f65438e = true;
        }

        public byte[] e() {
            return this.f65434a;
        }

        public long f(long j) {
            return this.f65440g.a(j);
        }

        public String g() {
            return this.f65435b;
        }

        public void h(String str) {
            String str2 = this.f65436c;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65436c = str;
                this.f65438e = true;
            }
        }

        public String i() {
            return this.f65436c;
        }

        public void j(long j) {
            if (this.f65441h != j) {
                this.f65441h = j;
                this.f65438e = true;
            }
        }

        public void k(String str) {
            String str2 = this.f65439f;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65439f = str;
                this.f65438e = true;
            }
        }

        public long l() {
            return this.f65441h;
        }

        public boolean m() {
            String g2 = a.this.f65430d.g("aid.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f65434a = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f65437d = jSONObject.getLong("gen_ts");
                    this.f65436c = jSONObject.getString("form_id");
                    this.f65435b = jSONObject.getString("and_id");
                    this.f65439f = jSONObject.optString("ran_id", null);
                    this.f65440g.b(jSONObject.getLong("flags"));
                    this.f65441h = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f65438e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean n() {
            if (this.f65438e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f65435b);
                    jSONObject.put("form_id", this.f65436c);
                    jSONObject.put("gen_ts", this.f65437d);
                    jSONObject.put("flags", this.f65440g.d());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f65439f)) {
                        jSONObject.put("ran_id", this.f65439f);
                    }
                    if (this.f65434a != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f65434a, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f65441h);
                    a.this.f65430d.i("aid.dat", jSONObject.toString(), true);
                    this.f65438e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.f65431e = new b();
    }

    public static String i(byte[] bArr) {
        return d.b.q.h.a.b("A00", new d.b.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr));
    }

    @Override // d.b.q.h.a
    public String c() {
        return this.f65431e.i();
    }

    @Override // d.b.q.h.a
    public byte[] d() {
        return this.f65431e.e();
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
        this.f65430d = this.f65418a.f("aid");
        this.f65431e.m();
        TrustSubject trustSubject = this.f65419b.f65425c.f6330b;
        boolean z3 = false;
        boolean z4 = true;
        if (trustSubject != null) {
            j = trustSubject.n();
            if (j != this.f65431e.l()) {
                z = true;
                z2 = !TextUtils.isEmpty(this.f65431e.i()) || this.f65431e.e() == null || TextUtils.isEmpty(this.f65431e.g());
                if (!z2 || z) {
                    str = null;
                    C1786a a2 = trustSubject == null ? C1786a.a(trustSubject) : null;
                    str = Settings.Secure.getString(this.f65419b.f65423a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (z2) {
                        if (a2 != null) {
                            if (this.f65431e.f(1L) == 0) {
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
                            this.f65431e.k(uuid);
                            str2 = str2 + uuid;
                            this.f65431e.b(1L, 1L);
                        }
                        byte[] a3 = f.a(str2, "utf-8");
                        String i = i(a3);
                        this.f65431e.d(a3);
                        this.f65431e.a(System.currentTimeMillis());
                        this.f65431e.c(str);
                        this.f65431e.h(i);
                    }
                    this.f65431e.j(j);
                    this.f65431e.n();
                }
                return;
            }
        } else {
            j = 0;
        }
        z = false;
        if (TextUtils.isEmpty(this.f65431e.i())) {
        }
        if (z2) {
        }
        str = null;
        if (trustSubject == null) {
        }
        str = Settings.Secure.getString(this.f65419b.f65423a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (TextUtils.isEmpty(str)) {
        }
        if (z2) {
        }
        if (z3) {
        }
        this.f65431e.j(j);
        this.f65431e.n();
    }
}
