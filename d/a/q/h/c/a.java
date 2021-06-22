package d.a.q.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import d.a.q.g.c.a.e;
import d.a.q.g.c.a.f;
import d.a.q.g.d.a;
import d.a.q.h.a;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d.a.q.h.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C1848a f67936d;

    /* renamed from: e  reason: collision with root package name */
    public b f67937e;

    /* renamed from: d.a.q.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1850a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f67938a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f67939b = new HashSet<>();

        public static C1850a a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-aid");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                try {
                    C1850a c1850a = new C1850a();
                    JSONObject jSONObject = new JSONObject(m);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c1850a.f67938a.add(optJSONArray.getString(i2));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            c1850a.f67939b.add(optJSONArray2.getString(i3));
                        }
                    }
                    return c1850a;
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
            return this.f67938a.contains(str);
        }

        public boolean c(String str) {
            return this.f67939b.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f67940a;

        /* renamed from: b  reason: collision with root package name */
        public String f67941b;

        /* renamed from: c  reason: collision with root package name */
        public String f67942c;

        /* renamed from: d  reason: collision with root package name */
        public long f67943d;

        /* renamed from: f  reason: collision with root package name */
        public String f67945f;

        /* renamed from: h  reason: collision with root package name */
        public long f67947h;

        /* renamed from: e  reason: collision with root package name */
        public boolean f67944e = true;

        /* renamed from: g  reason: collision with root package name */
        public e f67946g = new e();

        public b() {
        }

        public void a(long j) {
            if (j != this.f67943d) {
                this.f67943d = j;
                this.f67944e = true;
            }
        }

        public void b(long j, long j2) {
            if (this.f67946g.c(j, j2)) {
                this.f67944e = true;
            }
        }

        public void c(String str) {
            String str2 = this.f67941b;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67941b = str;
                this.f67944e = true;
            }
        }

        public void d(byte[] bArr) {
            if (Arrays.equals(bArr, this.f67940a)) {
                return;
            }
            this.f67940a = bArr;
            this.f67944e = true;
        }

        public byte[] e() {
            return this.f67940a;
        }

        public long f(long j) {
            return this.f67946g.a(j);
        }

        public String g() {
            return this.f67941b;
        }

        public void h(String str) {
            String str2 = this.f67942c;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67942c = str;
                this.f67944e = true;
            }
        }

        public String i() {
            return this.f67942c;
        }

        public void j(long j) {
            if (this.f67947h != j) {
                this.f67947h = j;
                this.f67944e = true;
            }
        }

        public void k(String str) {
            String str2 = this.f67945f;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f67945f = str;
                this.f67944e = true;
            }
        }

        public long l() {
            return this.f67947h;
        }

        public boolean m() {
            String g2 = a.this.f67936d.g("aid.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f67940a = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f67943d = jSONObject.getLong("gen_ts");
                    this.f67942c = jSONObject.getString("form_id");
                    this.f67941b = jSONObject.getString("and_id");
                    this.f67945f = jSONObject.optString("ran_id", null);
                    this.f67946g.b(jSONObject.getLong("flags"));
                    this.f67947h = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f67944e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean n() {
            if (this.f67944e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f67941b);
                    jSONObject.put("form_id", this.f67942c);
                    jSONObject.put("gen_ts", this.f67943d);
                    jSONObject.put("flags", this.f67946g.d());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f67945f)) {
                        jSONObject.put("ran_id", this.f67945f);
                    }
                    if (this.f67940a != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f67940a, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f67947h);
                    a.this.f67936d.i("aid.dat", jSONObject.toString(), true);
                    this.f67944e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.f67937e = new b();
    }

    public static String i(byte[] bArr) {
        return d.a.q.h.a.b("A00", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr));
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f67937e.i();
    }

    @Override // d.a.q.h.a
    public byte[] d() {
        return this.f67937e.e();
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
    @Override // d.a.q.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        this.f67936d = this.f67924a.f("aid");
        this.f67937e.m();
        TrustSubject trustSubject = this.f67925b.f67931c.f6312b;
        boolean z3 = false;
        boolean z4 = true;
        if (trustSubject != null) {
            j = trustSubject.n();
            if (j != this.f67937e.l()) {
                z = true;
                z2 = !TextUtils.isEmpty(this.f67937e.i()) || this.f67937e.e() == null || TextUtils.isEmpty(this.f67937e.g());
                if (!z2 || z) {
                    str = null;
                    C1850a a2 = trustSubject == null ? C1850a.a(trustSubject) : null;
                    str = Settings.Secure.getString(this.f67925b.f67929a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (z2) {
                        if (a2 != null) {
                            if (this.f67937e.f(1L) == 0) {
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
                            this.f67937e.k(uuid);
                            str2 = str2 + uuid;
                            this.f67937e.b(1L, 1L);
                        }
                        byte[] a3 = f.a(str2, "utf-8");
                        String i2 = i(a3);
                        this.f67937e.d(a3);
                        this.f67937e.a(System.currentTimeMillis());
                        this.f67937e.c(str);
                        this.f67937e.h(i2);
                    }
                    this.f67937e.j(j);
                    this.f67937e.n();
                }
                return;
            }
        } else {
            j = 0;
        }
        z = false;
        if (TextUtils.isEmpty(this.f67937e.i())) {
        }
        if (z2) {
        }
        str = null;
        if (trustSubject == null) {
        }
        str = Settings.Secure.getString(this.f67925b.f67929a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (TextUtils.isEmpty(str)) {
        }
        if (z2) {
        }
        if (z3) {
        }
        this.f67937e.j(j);
        this.f67937e.n();
    }
}
