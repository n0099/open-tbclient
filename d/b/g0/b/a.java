package d.b.g0.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import d.b.g0.l.e;
import d.b.g0.l.g;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f43511e;

    /* renamed from: a  reason: collision with root package name */
    public String f43512a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f43513b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f43514c;

    /* renamed from: d  reason: collision with root package name */
    public Context f43515d;

    public a(Context context) {
        this.f43513b = context.getSharedPreferences("once_login_config", 0);
        context.getSharedPreferences("leroadcfg", 0);
        this.f43514c = this.f43513b.edit();
        this.f43515d = context;
    }

    public static a g(Context context) {
        if (f43511e == null) {
            synchronized (a.class) {
                if (f43511e == null) {
                    f43511e = new a(context);
                }
            }
        }
        return f43511e;
    }

    public void A(String str, String str2) {
        K("k_sdk_a_s", str + "_" + str2);
    }

    public void B(boolean z) {
        v("k_sdk_cu_s", z);
    }

    public long C() {
        return f("ky_cfo_t", d.b.g0.l.c.f43709f);
    }

    public final String D(String str, String str2) {
        return this.f43513b.getString(str, str2);
    }

    public void E(long j) {
        t("rp_last_off_ti", j);
    }

    public void F(String str) {
        K("last_al_rp_d", str);
    }

    public void G(boolean z) {
        v("k_is_ig_env", z);
    }

    public String H() {
        if (!TextUtils.isEmpty(this.f43512a)) {
            return this.f43512a;
        }
        String D = D("xyus", "");
        this.f43512a = D;
        if (TextUtils.isEmpty(D)) {
            String b2 = g.b(UUID.randomUUID().toString());
            this.f43512a = b2;
            K("xyus", b2);
        }
        return this.f43512a;
    }

    public void I(long j) {
        t("ky_lvt", j);
    }

    public void J(String str) {
        K("last_Rp_d", str);
    }

    public final void K(String str, String str2) {
        this.f43514c.putString(str, str2);
        this.f43514c.commit();
    }

    public void L(boolean z) {
        v("k_sdk_s", z);
    }

    public String M() {
        return h("k_cd_2", "");
    }

    public void N(long j) {
        t("ky_cfs_t", j);
    }

    public void O(String str) {
        u("ky_ltc", str);
    }

    public void P(boolean z) {
        v("k_u_a_pr", z);
    }

    public String Q() {
        return h("ky_dxc", "");
    }

    public void R(long j) {
        t("t_con_3g", j);
    }

    public void S(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        K("k_sdk_ra_k", str);
    }

    public long T() {
        return f("k_last_a_ts", 0L);
    }

    public void U(String str) {
        K("ky_sg", str);
    }

    public String V() {
        return D("last_al_rp_d", "");
    }

    public void W(String str) {
        u("ky_ydc", str);
    }

    public int X() {
        return e("ky_lls", -1);
    }

    public long Y() {
        return f("ky_llt", 0L);
    }

    public String Z() {
        return D("last_Rp_d", "");
    }

    public boolean a() {
        return n("k_sdk_cu_s", true);
    }

    public long a0() {
        return f("rp_last_off_ti", 0L);
    }

    public boolean b() {
        return n("k_is_ig_env", true);
    }

    public int b0() {
        return e("ky_lvs", -1);
    }

    public boolean c() {
        return n("k_sdk_s", true);
    }

    public long c0() {
        return f("ky_lvt", 0L);
    }

    public boolean d() {
        return n("k_u_a_pr", false);
    }

    public String d0() {
        return h("ky_ltc", "");
    }

    public final int e(String str, int i) {
        return this.f43513b.getInt(str, i);
    }

    public int e0() {
        return e("one_d_3g_con", 50);
    }

    public final long f(String str, long j) {
        return this.f43513b.getLong(str, j);
    }

    public long f0() {
        return f("ky_cfs_t", 0L);
    }

    public int g0() {
        return e("rp_off_gap", 3);
    }

    public String h(String str, String str2) {
        String string = this.f43513b.getString(str, str2);
        return !TextUtils.isEmpty(string) ? e.a(this.f43515d, string) : "";
    }

    public String h0() {
        return D("k_sdk_ra_k", "");
    }

    public void i() {
        K("k_sdk_a_s", "");
    }

    public String i0() {
        return D("k_sdk_a_s", "");
    }

    public void j(int i) {
        s("ky_lls", i);
    }

    public String j0() {
        return D("ky_sg", "");
    }

    public void k(long j) {
        t("ky_cfo_t", j);
    }

    public long k0() {
        return f("t_con_3g", 0L);
    }

    public void l(String str) {
        u("k_cd_2", str);
    }

    public String l0() {
        return h("ky_ydc", "");
    }

    public void m(boolean z) {
        v("k_sdk_cm_s", z);
    }

    public boolean m0() {
        return n("k_sdk_cm_s", true);
    }

    public final boolean n(String str, boolean z) {
        return this.f43513b.getBoolean(str, z);
    }

    public boolean n0() {
        return n("k_sdk_ct_s", true);
    }

    public String o() {
        return D("ky_aid", "");
    }

    public void p(int i) {
        s("ky_lvs", i);
    }

    public void q(long j) {
        t("k_last_a_ts", j);
    }

    public void r(String str) {
        K("ky_aid", str);
    }

    public final void s(String str, int i) {
        this.f43514c.putInt(str, i);
        this.f43514c.commit();
    }

    public final void t(String str, long j) {
        this.f43514c.putLong(str, j);
        this.f43514c.commit();
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f43514c.putString(str, e.b(this.f43515d, str2.getBytes()));
        this.f43514c.commit();
    }

    public final void v(String str, boolean z) {
        this.f43514c.putBoolean(str, z);
        this.f43514c.commit();
    }

    public void w(boolean z) {
        v("k_sdk_ct_s", z);
    }

    public long x() {
        return f("k_a_itl", d.b.g0.l.b.f43703b * 24);
    }

    public void y(long j) {
        t("ky_llt", j);
    }

    public void z(String str) {
        u("ky_dxc", str);
    }
}
