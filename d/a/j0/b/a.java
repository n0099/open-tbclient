package d.a.j0.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import d.a.j0.l.e;
import d.a.j0.l.g;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43943e;

    /* renamed from: a  reason: collision with root package name */
    public String f43944a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f43945b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f43946c;

    /* renamed from: d  reason: collision with root package name */
    public Context f43947d;

    public a(Context context) {
        this.f43945b = context.getSharedPreferences("once_login_config", 0);
        context.getSharedPreferences("leroadcfg", 0);
        this.f43946c = this.f43945b.edit();
        this.f43947d = context;
    }

    public static a h(Context context) {
        if (f43943e == null) {
            synchronized (a.class) {
                if (f43943e == null) {
                    f43943e = new a(context);
                }
            }
        }
        return f43943e;
    }

    public void A(long j) {
        u("ky_llt", j);
    }

    public void B(String str) {
        v("ky_dxc", str);
    }

    public void C(String str, String str2) {
        M("k_sdk_a_s", str + "_" + str2);
    }

    public void D(boolean z) {
        w("k_sdk_cu_s", z);
    }

    public long E() {
        return g("ky_cfo_t", d.a.j0.l.c.f44151f);
    }

    public final String F(String str, String str2) {
        return this.f43945b.getString(str, str2);
    }

    public void G(long j) {
        u("rp_last_off_ti", j);
    }

    public void H(String str) {
        M("last_al_rp_d", str);
    }

    public void I(boolean z) {
        w("k_is_ig_env", z);
    }

    public String J() {
        if (!TextUtils.isEmpty(this.f43944a)) {
            return this.f43944a;
        }
        String F = F("xyus", "");
        this.f43944a = F;
        if (TextUtils.isEmpty(F)) {
            String b2 = g.b(UUID.randomUUID().toString());
            this.f43944a = b2;
            M("xyus", b2);
        }
        return this.f43944a;
    }

    public void K(long j) {
        u("ky_lvt", j);
    }

    public void L(String str) {
        M("last_Rp_d", str);
    }

    public final void M(String str, String str2) {
        this.f43946c.putString(str, str2);
        this.f43946c.commit();
    }

    public void N(boolean z) {
        w("k_sdk_s", z);
    }

    public String O() {
        return i("k_cd_2", "");
    }

    public void P(long j) {
        u("ky_cfs_t", j);
    }

    public void Q(String str) {
        v("ky_ltc", str);
    }

    public void R(boolean z) {
        w("k_u_a_pr", z);
    }

    public String S() {
        return i("ky_dxc", "");
    }

    public void T(long j) {
        u("t_con_3g", j);
    }

    public void U(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        M("k_sdk_ra_k", str);
    }

    public long V() {
        return g("k_last_a_ts", 0L);
    }

    public void W(String str) {
        M("ky_sg", str);
    }

    public String X() {
        return F("last_al_rp_d", "");
    }

    public void Y(String str) {
        v("ky_ydc", str);
    }

    public int Z() {
        return f("ky_lls", -1);
    }

    public boolean a() {
        return o("k_sdk_ct_s", true);
    }

    public long a0() {
        return g("ky_llt", 0L);
    }

    public boolean b() {
        return o("k_sdk_cu_s", true);
    }

    public String b0() {
        return F("last_Rp_d", "");
    }

    public boolean c() {
        return o("k_is_ig_env", true);
    }

    public long c0() {
        return g("rp_last_off_ti", 0L);
    }

    public boolean d() {
        return o("k_sdk_s", true);
    }

    public int d0() {
        return f("ky_lvs", -1);
    }

    public boolean e() {
        return o("k_u_a_pr", false);
    }

    public long e0() {
        return g("ky_lvt", 0L);
    }

    public final int f(String str, int i2) {
        return this.f43945b.getInt(str, i2);
    }

    public String f0() {
        return i("ky_ltc", "");
    }

    public final long g(String str, long j) {
        return this.f43945b.getLong(str, j);
    }

    public int g0() {
        int f2 = f("k_mask_num", 4);
        if (f2 <= 4) {
            return 4;
        }
        if (f2 >= 8) {
            return 8;
        }
        return f2;
    }

    public int h0() {
        return f("one_d_3g_con", 50);
    }

    public String i(String str, String str2) {
        String string = this.f43945b.getString(str, str2);
        return !TextUtils.isEmpty(string) ? e.a(this.f43947d, string) : "";
    }

    public long i0() {
        return g("ky_cfs_t", 0L);
    }

    public void j() {
        M("k_sdk_a_s", "");
    }

    public int j0() {
        return f("rp_off_gap", 3);
    }

    public void k(int i2) {
        t("ky_lls", i2);
    }

    public String k0() {
        return F("k_sdk_ra_k", "");
    }

    public void l(long j) {
        u("ky_cfo_t", j);
    }

    public String l0() {
        return F("k_sdk_a_s", "");
    }

    public void m(String str) {
        v("k_cd_2", str);
    }

    public String m0() {
        return F("ky_sg", "");
    }

    public void n(boolean z) {
        w("k_sdk_cm_s", z);
    }

    public long n0() {
        return g("t_con_3g", 0L);
    }

    public final boolean o(String str, boolean z) {
        return this.f43945b.getBoolean(str, z);
    }

    public String o0() {
        return i("ky_ydc", "");
    }

    public String p() {
        return F("ky_aid", "");
    }

    public boolean p0() {
        return o("k_sdk_cm_s", true);
    }

    public void q(int i2) {
        t("ky_lvs", i2);
    }

    public void r(long j) {
        u("k_last_a_ts", j);
    }

    public void s(String str) {
        M("ky_aid", str);
    }

    public final void t(String str, int i2) {
        this.f43946c.putInt(str, i2);
        this.f43946c.commit();
    }

    public final void u(String str, long j) {
        this.f43946c.putLong(str, j);
        this.f43946c.commit();
    }

    public void v(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f43946c.putString(str, e.b(this.f43947d, str2.getBytes()));
        this.f43946c.commit();
    }

    public final void w(String str, boolean z) {
        this.f43946c.putBoolean(str, z);
        this.f43946c.commit();
    }

    public void x(boolean z) {
        w("k_sdk_ct_s", z);
    }

    public long y() {
        return g("k_a_itl", d.a.j0.l.b.f44145b * 24);
    }

    public void z(int i2) {
        if (i2 <= 4) {
            return;
        }
        t("k_mask_num", i2);
    }
}
