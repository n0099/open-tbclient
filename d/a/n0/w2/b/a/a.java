package d.a.n0.w2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f66241a;

    /* renamed from: b  reason: collision with root package name */
    public int f66242b;

    /* renamed from: c  reason: collision with root package name */
    public int f66243c;

    /* renamed from: d  reason: collision with root package name */
    public int f66244d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f66245e;

    /* renamed from: f  reason: collision with root package name */
    public int f66246f;

    /* renamed from: g  reason: collision with root package name */
    public int f66247g;

    /* renamed from: h  reason: collision with root package name */
    public int f66248h;

    /* renamed from: i  reason: collision with root package name */
    public SimpleUser f66249i;
    public int j;
    public int k;

    public int a() {
        return this.f66247g;
    }

    public int b() {
        return this.f66248h;
    }

    public int c() {
        return this.f66242b;
    }

    public int d() {
        return this.f66243c;
    }

    public int e() {
        return this.f66244d;
    }

    public SimpleUser f() {
        return this.f66249i;
    }

    public int g() {
        return this.f66246f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f66241a;
    }

    public boolean j() {
        return this.f66245e;
    }

    public boolean k() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f66241a = j.k("post" + currentAccount, 0);
        this.f66242b = j.k("like" + currentAccount, 0);
        this.f66243c = j.k("group" + currentAccount, 0);
        this.f66244d = j.k("live" + currentAccount, 0);
        this.f66246f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f66247g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f66248h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f66245e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f66241a == 0 && this.f66242b == 0 && this.f66243c == 0 && this.f66244d == 0 && this.f66246f == 1 && this.k == 0 && this.f66247g == 0 && this.f66248h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f66241a = aVar.f66241a;
        this.f66242b = aVar.f66242b;
        this.f66243c = aVar.f66243c;
        this.f66245e = aVar.f66245e;
        this.f66244d = aVar.f66244d;
        this.j = aVar.j;
        this.f66246f = aVar.f66246f;
        this.k = aVar.k;
        this.f66248h = aVar.f66248h;
        this.f66247g = aVar.f66247g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v("post" + currentAccount, this.f66241a);
        j.v("like" + currentAccount, this.f66242b);
        j.v("group" + currentAccount, this.f66243c);
        j.v("live" + currentAccount, this.f66244d);
        j.v("reply" + currentAccount, this.f66246f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f66247g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f66248h);
        TbadkCoreApplication.getInst().setLocationShared(this.f66245e);
    }

    public void n(String str, int i2) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v(str + currentAccount, i2);
    }

    public void o(int i2) {
        this.f66247g = i2;
    }

    public void p(int i2) {
        this.f66248h = i2;
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66242b = i2;
    }

    public void s(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66243c = i2;
    }

    public void t(int i2) {
        if (i2 > 3 || i2 < 1) {
            return;
        }
        this.f66244d = i2;
    }

    public void u(int i2) {
        if (i2 != 1) {
            this.f66245e = false;
        } else {
            this.f66245e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.f66249i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i2) {
        if (i2 == 0) {
            this.f66246f = 1;
        } else {
            this.f66246f = i2;
        }
    }

    public void x(int i2) {
        this.k = i2;
    }

    public void y(int i2) {
        this.f66241a = i2;
    }
}
