package d.b.f0.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import d.b.f0.l.e;
import d.b.f0.l.g;
import java.util.UUID;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f42822e;

    /* renamed from: a  reason: collision with root package name */
    public String f42823a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f42824b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f42825c;

    /* renamed from: d  reason: collision with root package name */
    public Context f42826d;

    public a(Context context) {
        this.f42824b = context.getSharedPreferences("once_login_config", 0);
        context.getSharedPreferences("leroadcfg", 0);
        this.f42825c = this.f42824b.edit();
        this.f42826d = context;
    }

    public static a g(Context context) {
        if (f42822e == null) {
            synchronized (a.class) {
                if (f42822e == null) {
                    f42822e = new a(context);
                }
            }
        }
        return f42822e;
    }

    public void A(String str, String str2) {
        K("k_sdk_a_s", str + "_" + str2);
    }

    public void B(boolean z) {
        v("k_sdk_cu_s", z);
    }

    public long C() {
        return f("ky_cfo_t", d.b.f0.l.c.f43020f);
    }

    public final String D(String str, String str2) {
        return this.f42824b.getString(str, str2);
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
        if (!TextUtils.isEmpty(this.f42823a)) {
            return this.f42823a;
        }
        String D = D("xyus", "");
        this.f42823a = D;
        if (TextUtils.isEmpty(D)) {
            String b2 = g.b(UUID.randomUUID().toString());
            this.f42823a = b2;
            K("xyus", b2);
        }
        return this.f42823a;
    }

    public void I(long j) {
        t("ky_lvt", j);
    }

    public void J(String str) {
        K("last_Rp_d", str);
    }

    public final void K(String str, String str2) {
        this.f42825c.putString(str, str2);
        this.f42825c.commit();
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
        return this.f42824b.getInt(str, i);
    }

    public int e0() {
        return e("one_d_3g_con", 50);
    }

    public final long f(String str, long j) {
        return this.f42824b.getLong(str, j);
    }

    public long f0() {
        return f("ky_cfs_t", 0L);
    }

    public int g0() {
        return e("rp_off_gap", 3);
    }

    public String h(String str, String str2) {
        String string = this.f42824b.getString(str, str2);
        return !TextUtils.isEmpty(string) ? e.a(this.f42826d, string) : "";
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
        return this.f42824b.getBoolean(str, z);
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
        this.f42825c.putInt(str, i);
        this.f42825c.commit();
    }

    public final void t(String str, long j) {
        this.f42825c.putLong(str, j);
        this.f42825c.commit();
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f42825c.putString(str, e.b(this.f42826d, str2.getBytes()));
        this.f42825c.commit();
    }

    public final void v(String str, boolean z) {
        this.f42825c.putBoolean(str, z);
        this.f42825c.commit();
    }

    public void w(boolean z) {
        v("k_sdk_ct_s", z);
    }

    public long x() {
        return f("k_a_itl", d.b.f0.l.b.f43014b * 24);
    }

    public void y(long j) {
        t("ky_llt", j);
    }

    public void z(String str) {
        u("ky_dxc", str);
    }
}
