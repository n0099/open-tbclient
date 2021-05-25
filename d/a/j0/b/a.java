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
    public static volatile a f40262e;

    /* renamed from: a  reason: collision with root package name */
    public String f40263a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f40264b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f40265c;

    /* renamed from: d  reason: collision with root package name */
    public Context f40266d;

    public a(Context context) {
        this.f40264b = context.getSharedPreferences("once_login_config", 0);
        context.getSharedPreferences("leroadcfg", 0);
        this.f40265c = this.f40264b.edit();
        this.f40266d = context;
    }

    public static a g(Context context) {
        if (f40262e == null) {
            synchronized (a.class) {
                if (f40262e == null) {
                    f40262e = new a(context);
                }
            }
        }
        return f40262e;
    }

    public void A(String str, String str2) {
        K("k_sdk_a_s", str + "_" + str2);
    }

    public void B(boolean z) {
        v("k_sdk_cu_s", z);
    }

    public long C() {
        return f("ky_cfo_t", d.a.j0.l.c.f40472f);
    }

    public final String D(String str, String str2) {
        return this.f40264b.getString(str, str2);
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
        if (!TextUtils.isEmpty(this.f40263a)) {
            return this.f40263a;
        }
        String D = D("xyus", "");
        this.f40263a = D;
        if (TextUtils.isEmpty(D)) {
            String b2 = g.b(UUID.randomUUID().toString());
            this.f40263a = b2;
            K("xyus", b2);
        }
        return this.f40263a;
    }

    public void I(long j) {
        t("ky_lvt", j);
    }

    public void J(String str) {
        K("last_Rp_d", str);
    }

    public final void K(String str, String str2) {
        this.f40265c.putString(str, str2);
        this.f40265c.commit();
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

    public final int e(String str, int i2) {
        return this.f40264b.getInt(str, i2);
    }

    public int e0() {
        return e("one_d_3g_con", 50);
    }

    public final long f(String str, long j) {
        return this.f40264b.getLong(str, j);
    }

    public long f0() {
        return f("ky_cfs_t", 0L);
    }

    public int g0() {
        return e("rp_off_gap", 3);
    }

    public String h(String str, String str2) {
        String string = this.f40264b.getString(str, str2);
        return !TextUtils.isEmpty(string) ? e.a(this.f40266d, string) : "";
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

    public void j(int i2) {
        s("ky_lls", i2);
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
        return this.f40264b.getBoolean(str, z);
    }

    public boolean n0() {
        return n("k_sdk_ct_s", true);
    }

    public String o() {
        return D("ky_aid", "");
    }

    public void p(int i2) {
        s("ky_lvs", i2);
    }

    public void q(long j) {
        t("k_last_a_ts", j);
    }

    public void r(String str) {
        K("ky_aid", str);
    }

    public final void s(String str, int i2) {
        this.f40265c.putInt(str, i2);
        this.f40265c.commit();
    }

    public final void t(String str, long j) {
        this.f40265c.putLong(str, j);
        this.f40265c.commit();
    }

    public void u(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f40265c.putString(str, e.b(this.f40266d, str2.getBytes()));
        this.f40265c.commit();
    }

    public final void v(String str, boolean z) {
        this.f40265c.putBoolean(str, z);
        this.f40265c.commit();
    }

    public void w(boolean z) {
        v("k_sdk_ct_s", z);
    }

    public long x() {
        return f("k_a_itl", d.a.j0.l.b.f40466b * 24);
    }

    public void y(long j) {
        t("ky_llt", j);
    }

    public void z(String str) {
        u("ky_dxc", str);
    }
}
