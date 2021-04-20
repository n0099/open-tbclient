package d.b.p.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.b.p.g.c.a.e;
import d.b.p.g.c.a.f;
import d.b.p.g.d.a;
import d.b.p.h.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.b.p.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1765a f65166d;

    /* renamed from: e  reason: collision with root package name */
    public b f65167e;

    /* renamed from: d.b.p.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1767a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f65168a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f65169b = new HashSet<>();

        public static C1767a a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-aid");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                try {
                    C1767a c1767a = new C1767a();
                    JSONObject jSONObject = new JSONObject(m);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            c1767a.f65168a.add(optJSONArray.getString(i));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            c1767a.f65169b.add(optJSONArray2.getString(i2));
                        }
                    }
                    return c1767a;
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
            return this.f65168a.contains(str);
        }

        public boolean c(String str) {
            return this.f65169b.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f65170a;

        /* renamed from: b  reason: collision with root package name */
        public String f65171b;

        /* renamed from: c  reason: collision with root package name */
        public String f65172c;

        /* renamed from: d  reason: collision with root package name */
        public long f65173d;

        /* renamed from: f  reason: collision with root package name */
        public String f65175f;

        /* renamed from: h  reason: collision with root package name */
        public long f65177h;

        /* renamed from: e  reason: collision with root package name */
        public boolean f65174e = true;

        /* renamed from: g  reason: collision with root package name */
        public e f65176g = new e();

        public b() {
        }

        public void a(long j) {
            if (j != this.f65173d) {
                this.f65173d = j;
                this.f65174e = true;
            }
        }

        public void b(long j, long j2) {
            if (this.f65176g.c(j, j2)) {
                this.f65174e = true;
            }
        }

        public void c(String str) {
            String str2 = this.f65171b;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65171b = str;
                this.f65174e = true;
            }
        }

        public void d(byte[] bArr) {
            if (Arrays.equals(bArr, this.f65170a)) {
                return;
            }
            this.f65170a = bArr;
            this.f65174e = true;
        }

        public byte[] e() {
            return this.f65170a;
        }

        public long f(long j) {
            return this.f65176g.a(j);
        }

        public String g() {
            return this.f65171b;
        }

        public void h(String str) {
            String str2 = this.f65172c;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65172c = str;
                this.f65174e = true;
            }
        }

        public String i() {
            return this.f65172c;
        }

        public void j(long j) {
            if (this.f65177h != j) {
                this.f65177h = j;
                this.f65174e = true;
            }
        }

        public void k(String str) {
            String str2 = this.f65175f;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f65175f = str;
                this.f65174e = true;
            }
        }

        public long l() {
            return this.f65177h;
        }

        public boolean m() {
            String g2 = a.this.f65166d.g("aid.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f65170a = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f65173d = jSONObject.getLong("gen_ts");
                    this.f65172c = jSONObject.getString("form_id");
                    this.f65171b = jSONObject.getString("and_id");
                    this.f65175f = jSONObject.optString("ran_id", null);
                    this.f65176g.b(jSONObject.getLong("flags"));
                    this.f65177h = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f65174e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean n() {
            if (this.f65174e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f65171b);
                    jSONObject.put("form_id", this.f65172c);
                    jSONObject.put("gen_ts", this.f65173d);
                    jSONObject.put("flags", this.f65176g.d());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f65175f)) {
                        jSONObject.put("ran_id", this.f65175f);
                    }
                    if (this.f65170a != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f65170a, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f65177h);
                    a.this.f65166d.i("aid.dat", jSONObject.toString(), true);
                    this.f65174e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.f65167e = new b();
    }

    public static String i(byte[] bArr) {
        return d.b.p.h.a.b("A00", new d.b.p.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr));
    }

    @Override // d.b.p.h.a
    public String c() {
        return this.f65167e.i();
    }

    @Override // d.b.p.h.a
    public byte[] d() {
        return this.f65167e.e();
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
    @Override // d.b.p.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        this.f65166d = this.f65154a.f("aid");
        this.f65167e.m();
        TrustSubject trustSubject = this.f65155b.f65161c.f6330b;
        boolean z3 = false;
        boolean z4 = true;
        if (trustSubject != null) {
            j = trustSubject.n();
            if (j != this.f65167e.l()) {
                z = true;
                z2 = !TextUtils.isEmpty(this.f65167e.i()) || this.f65167e.e() == null || TextUtils.isEmpty(this.f65167e.g());
                if (!z2 || z) {
                    str = null;
                    C1767a a2 = trustSubject == null ? C1767a.a(trustSubject) : null;
                    str = Settings.Secure.getString(this.f65155b.f65159a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (z2) {
                        if (a2 != null) {
                            if (this.f65167e.f(1L) == 0) {
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
                            this.f65167e.k(uuid);
                            str2 = str2 + uuid;
                            this.f65167e.b(1L, 1L);
                        }
                        byte[] a3 = f.a(str2, "utf-8");
                        String i = i(a3);
                        this.f65167e.d(a3);
                        this.f65167e.a(System.currentTimeMillis());
                        this.f65167e.c(str);
                        this.f65167e.h(i);
                    }
                    this.f65167e.j(j);
                    this.f65167e.n();
                }
                return;
            }
        } else {
            j = 0;
        }
        z = false;
        if (TextUtils.isEmpty(this.f65167e.i())) {
        }
        if (z2) {
        }
        str = null;
        if (trustSubject == null) {
        }
        str = Settings.Secure.getString(this.f65155b.f65159a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (TextUtils.isEmpty(str)) {
        }
        if (z2) {
        }
        if (z3) {
        }
        this.f65167e.j(j);
        this.f65167e.n();
    }
}
