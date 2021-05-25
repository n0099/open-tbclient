package d.a.m0.s.d;

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
    public int f50570a = 300;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50571b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50572c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50573d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f50574e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f50575f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f50576g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f50577h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50578i = true;
    public boolean j = true;
    public boolean k = false;
    public String l = TbConfig.MSG_DEFAULT_NODISTURB_START_TIME;
    public String m = TbConfig.MSG_DEFAULT_NODISTURB_END_TIME;

    public static d d() {
        return n;
    }

    public void A() {
        d.a.n0.e3.n0.a.r();
    }

    public void B(boolean z) {
        TbadkSettings.getInst().saveBoolean("group_notify", z);
        b();
    }

    public void C(boolean z) {
        this.f50573d = z;
        b();
    }

    public void D(boolean z) {
        this.f50571b = z;
        b();
    }

    public void E(int i2) {
        if (i2 == 0) {
            this.f50570a = i2;
            b.g0().a0(0);
            b.g0().d0(0);
        } else {
            this.f50570a = 300;
        }
        b();
    }

    public void F(boolean z) {
        this.j = z;
    }

    public void G(boolean z) {
        this.f50576g = z;
        b();
    }

    public void H(boolean z) {
        this.f50574e = z;
        b();
    }

    public void I(boolean z) {
        this.f50578i = z;
    }

    public void J(boolean z) {
        this.f50577h = z;
    }

    public void K(boolean z) {
        this.f50575f = z;
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
        d.a.m0.r.d0.b.j().t("permit_screen_lock", z);
    }

    public void R(boolean z) {
        f.c().h(z);
    }

    public void S(int i2, int i3) {
        f.c().i(i2, i3);
    }

    public void T(boolean z) {
        this.f50572c = z;
    }

    public void U() {
        f.c().m();
    }

    public void a(int i2) {
        if (i2 == 0) {
            I(false);
            J(false);
        } else if (i2 == 1) {
            I(true);
            J(false);
        } else if (i2 == 2) {
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
        if (this.f50578i || this.f50577h) {
            if (!this.f50578i || this.f50577h) {
                return (this.f50578i || !this.f50577h) ? 3 : 2;
            }
            return 1;
        }
        return 0;
    }

    public int e() {
        return this.f50570a;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.l;
    }

    public boolean h() {
        return d.a.m0.r.d0.b.j().g("permit_screen_lock", true);
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
        d.a.n0.e3.n0.a.n();
    }

    public boolean n() {
        TbadkCoreApplication.getInst().appResponseToIntentClass(GroupChatActivityConfig.class);
        return false;
    }

    public boolean o() {
        return this.f50573d;
    }

    public boolean p() {
        return this.f50571b;
    }

    public boolean q() {
        return this.j;
    }

    public boolean r() {
        return this.f50576g;
    }

    public boolean s() {
        return this.f50570a > 0;
    }

    public boolean t() {
        return this.f50574e;
    }

    public boolean u() {
        return this.f50578i;
    }

    public boolean v() {
        return this.f50577h;
    }

    public boolean w() {
        return this.f50575f;
    }

    public boolean x() {
        return this.k;
    }

    public boolean y() {
        return f.c().g();
    }

    public boolean z() {
        return this.f50572c;
    }
}
