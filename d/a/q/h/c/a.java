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
    public a.C1785a f64386d;

    /* renamed from: e  reason: collision with root package name */
    public b f64387e;

    /* renamed from: d.a.q.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1787a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f64388a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f64389b = new HashSet<>();

        public static C1787a a(TrustSubject trustSubject) {
            try {
                String m = trustSubject.m("config-aid");
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                try {
                    C1787a c1787a = new C1787a();
                    JSONObject jSONObject = new JSONObject(m);
                    JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            c1787a.f64388a.add(optJSONArray.getString(i2));
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        for (int i3 = 0; i3 < length2; i3++) {
                            c1787a.f64389b.add(optJSONArray2.getString(i3));
                        }
                    }
                    return c1787a;
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
            return this.f64388a.contains(str);
        }

        public boolean c(String str) {
            return this.f64389b.contains(str);
        }
    }

    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public byte[] f64390a;

        /* renamed from: b  reason: collision with root package name */
        public String f64391b;

        /* renamed from: c  reason: collision with root package name */
        public String f64392c;

        /* renamed from: d  reason: collision with root package name */
        public long f64393d;

        /* renamed from: f  reason: collision with root package name */
        public String f64395f;

        /* renamed from: h  reason: collision with root package name */
        public long f64397h;

        /* renamed from: e  reason: collision with root package name */
        public boolean f64394e = true;

        /* renamed from: g  reason: collision with root package name */
        public e f64396g = new e();

        public b() {
        }

        public void a(long j) {
            if (j != this.f64393d) {
                this.f64393d = j;
                this.f64394e = true;
            }
        }

        public void b(long j, long j2) {
            if (this.f64396g.c(j, j2)) {
                this.f64394e = true;
            }
        }

        public void c(String str) {
            String str2 = this.f64391b;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64391b = str;
                this.f64394e = true;
            }
        }

        public void d(byte[] bArr) {
            if (Arrays.equals(bArr, this.f64390a)) {
                return;
            }
            this.f64390a = bArr;
            this.f64394e = true;
        }

        public byte[] e() {
            return this.f64390a;
        }

        public long f(long j) {
            return this.f64396g.a(j);
        }

        public String g() {
            return this.f64391b;
        }

        public void h(String str) {
            String str2 = this.f64392c;
            if (str2 == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64392c = str;
                this.f64394e = true;
            }
        }

        public String i() {
            return this.f64392c;
        }

        public void j(long j) {
            if (this.f64397h != j) {
                this.f64397h = j;
                this.f64394e = true;
            }
        }

        public void k(String str) {
            String str2 = this.f64395f;
            if (str == str2) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f64395f = str;
                this.f64394e = true;
            }
        }

        public long l() {
            return this.f64397h;
        }

        public boolean m() {
            String g2 = a.this.f64386d.g("aid.dat", true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f64390a = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.f64393d = jSONObject.getLong("gen_ts");
                    this.f64392c = jSONObject.getString("form_id");
                    this.f64391b = jSONObject.getString("and_id");
                    this.f64395f = jSONObject.optString("ran_id", null);
                    this.f64396g.b(jSONObject.getLong("flags"));
                    this.f64397h = jSONObject.getLong("lst_conf_ver");
                    jSONObject.getInt("c_form_ver");
                    this.f64394e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean n() {
            if (this.f64394e) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.f64391b);
                    jSONObject.put("form_id", this.f64392c);
                    jSONObject.put("gen_ts", this.f64393d);
                    jSONObject.put("flags", this.f64396g.d());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.f64395f)) {
                        jSONObject.put("ran_id", this.f64395f);
                    }
                    if (this.f64390a != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f64390a, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.f64397h);
                    a.this.f64386d.i("aid.dat", jSONObject.toString(), true);
                    this.f64394e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.f64387e = new b();
    }

    public static String i(byte[] bArr) {
        return d.a.q.h.a.b("A00", new d.a.q.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr));
    }

    @Override // d.a.q.h.a
    public String c() {
        return this.f64387e.i();
    }

    @Override // d.a.q.h.a
    public byte[] d() {
        return this.f64387e.e();
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
        this.f64386d = this.f64374a.f("aid");
        this.f64387e.m();
        TrustSubject trustSubject = this.f64375b.f64381c.f6369b;
        boolean z3 = false;
        boolean z4 = true;
        if (trustSubject != null) {
            j = trustSubject.n();
            if (j != this.f64387e.l()) {
                z = true;
                z2 = !TextUtils.isEmpty(this.f64387e.i()) || this.f64387e.e() == null || TextUtils.isEmpty(this.f64387e.g());
                if (!z2 || z) {
                    str = null;
                    C1787a a2 = trustSubject == null ? C1787a.a(trustSubject) : null;
                    str = Settings.Secure.getString(this.f64375b.f64379a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                    if (TextUtils.isEmpty(str)) {
                        str = "000000000";
                    }
                    if (z2) {
                        if (a2 != null) {
                            if (this.f64387e.f(1L) == 0) {
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
                            this.f64387e.k(uuid);
                            str2 = str2 + uuid;
                            this.f64387e.b(1L, 1L);
                        }
                        byte[] a3 = f.a(str2, "utf-8");
                        String i2 = i(a3);
                        this.f64387e.d(a3);
                        this.f64387e.a(System.currentTimeMillis());
                        this.f64387e.c(str);
                        this.f64387e.h(i2);
                    }
                    this.f64387e.j(j);
                    this.f64387e.n();
                }
                return;
            }
        } else {
            j = 0;
        }
        z = false;
        if (TextUtils.isEmpty(this.f64387e.i())) {
        }
        if (z2) {
        }
        str = null;
        if (trustSubject == null) {
        }
        str = Settings.Secure.getString(this.f64375b.f64379a.getContentResolver(), IAdRequestParam.ANDROID_ID);
        if (TextUtils.isEmpty(str)) {
        }
        if (z2) {
        }
        if (z3) {
        }
        this.f64387e.j(j);
        this.f64387e.n();
    }
}
