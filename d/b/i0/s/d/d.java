package d.b.i0.s.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
/* loaded from: classes3.dex */
public class d {
    public static d n = new d();

    /* renamed from: a  reason: collision with root package name */
    public int f52021a = 300;

    /* renamed from: b  reason: collision with root package name */
    public boolean f52022b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52023c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f52024d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52025e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52026f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52027g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52028h = false;
    public boolean i = true;
    public boolean j = true;
    public boolean k = false;
    public String l = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String m = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    public static d d() {
        return n;
    }

    public void A() {
        d.b.j0.d3.n0.a.r();
    }

    public void B(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        b();
    }

    public void C(boolean z) {
        this.f52024d = z;
        b();
    }

    public void D(boolean z) {
        this.f52022b = z;
        b();
    }

    public void E(int i) {
        if (i == 0) {
            this.f52021a = i;
            b.g0().a0(0);
            b.g0().d0(0);
        } else {
            this.f52021a = 300;
        }
        b();
    }

    public void F(boolean z) {
        this.j = z;
    }

    public void G(boolean z) {
        this.f52027g = z;
        b();
    }

    public void H(boolean z) {
        this.f52025e = z;
        b();
    }

    public void I(boolean z) {
        this.i = z;
    }

    public void J(boolean z) {
        this.f52028h = z;
    }

    public void K(boolean z) {
        this.f52026f = z;
        b();
    }

    public void L(String str) {
        this.m = str;
    }

    public void M(boolean z) {
        this.k = z;
    }

    public void N(String str) {
        this.l = str;
    }

    public void O(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", z);
    }

    public void P(boolean z) {
        TbadkSettings.getInst().saveBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", z);
    }

    public void Q(boolean z) {
        d.b.i0.r.d0.b.j().t("permit_screen_lock", z);
    }

    public void R(boolean z) {
        f.c().h(z);
    }

    public void S(int i, int i2) {
        f.c().i(i, i2);
    }

    public void T(boolean z) {
        this.f52023c = z;
    }

    public void U() {
        f.c().m();
    }

    public void a(int i) {
        if (i == 0) {
            I(false);
            J(false);
        } else if (i == 1) {
            I(true);
            J(false);
        } else if (i == 2) {
            I(false);
            J(true);
        } else {
            I(true);
            J(true);
        }
    }

    public final void b() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016010));
    }

    public int c() {
        if (this.i || this.f52028h) {
            if (!this.i || this.f52028h) {
                return (this.i || !this.f52028h) ? 3 : 2;
            }
            return 1;
        }
        return 0;
    }

    public int e() {
        return this.f52021a;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.l;
    }

    public boolean h() {
        return d.b.i0.r.d0.b.j().g("permit_screen_lock", true);
    }

    public int i() {
        return f.c().d();
    }

    public int j() {
        return f.c().e();
    }

    public boolean k() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "official_push_switch", true);
    }

    public boolean l() {
        return TbadkSettings.getInst().loadBoolean(TbadkCoreApplication.getCurrentAccount() + "remind_forum_broadcast_switch", true);
    }

    public void m() {
        d.b.j0.d3.n0.a.n();
    }

    public boolean n() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public boolean o() {
        return this.f52024d;
    }

    public boolean p() {
        return this.f52022b;
    }

    public boolean q() {
        return this.j;
    }

    public boolean r() {
        return this.f52027g;
    }

    public boolean s() {
        return this.f52021a > 0;
    }

    public boolean t() {
        return this.f52025e;
    }

    public boolean u() {
        return this.i;
    }

    public boolean v() {
        return this.f52028h;
    }

    public boolean w() {
        return this.f52026f;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return f.c().g();
    }

    public boolean z() {
        return this.f52023c;
    }
}
