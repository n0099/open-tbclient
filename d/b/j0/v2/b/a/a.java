package d.b.j0.v2.b.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.setting.PrivacyMarkActivityConfig;
import tbclient.SimpleUser;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public int f63460a;

    /* renamed from: b  reason: collision with root package name */
    public int f63461b;

    /* renamed from: c  reason: collision with root package name */
    public int f63462c;

    /* renamed from: d  reason: collision with root package name */
    public int f63463d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63464e;

    /* renamed from: f  reason: collision with root package name */
    public int f63465f;

    /* renamed from: g  reason: collision with root package name */
    public int f63466g;

    /* renamed from: h  reason: collision with root package name */
    public int f63467h;
    public SimpleUser i;
    public int j;
    public int k;

    public int a() {
        return this.f63466g;
    }

    public int b() {
        return this.f63467h;
    }

    public int c() {
        return this.f63461b;
    }

    public int d() {
        return this.f63462c;
    }

    public int e() {
        return this.f63463d;
    }

    public SimpleUser f() {
        return this.i;
    }

    public int g() {
        return this.f63465f;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.f63460a;
    }

    public boolean j() {
        return this.f63464e;
    }

    public boolean k() {
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        this.f63460a = j.k("post" + currentAccount, 0);
        this.f63461b = j.k("like" + currentAccount, 0);
        this.f63462c = j.k("group" + currentAccount, 0);
        this.f63463d = j.k("live" + currentAccount, 0);
        this.f63465f = j.k("reply" + currentAccount, 1);
        this.k = j.k("reply_show_myself" + currentAccount, 0);
        this.f63466g = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, 0);
        this.f63467h = j.k(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, 0);
        this.f63464e = TbadkCoreApplication.getInst().getLocationShared();
        return (this.f63460a == 0 && this.f63461b == 0 && this.f63462c == 0 && this.f63463d == 0 && this.f63465f == 1 && this.k == 0 && this.f63466g == 0 && this.f63467h == 0) ? false : true;
    }

    public void l(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f63460a = aVar.f63460a;
        this.f63461b = aVar.f63461b;
        this.f63462c = aVar.f63462c;
        this.f63464e = aVar.f63464e;
        this.f63463d = aVar.f63463d;
        this.j = aVar.j;
        this.f63465f = aVar.f63465f;
        this.k = aVar.k;
        this.f63467h = aVar.f63467h;
        this.f63466g = aVar.f63466g;
    }

    public void m() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        j.v("post" + currentAccount, this.f63460a);
        j.v("like" + currentAccount, this.f63461b);
        j.v("group" + currentAccount, this.f63462c);
        j.v("live" + currentAccount, this.f63463d);
        j.v("reply" + currentAccount, this.f63465f);
        j.v("reply_show_myself" + currentAccount, this.k);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_INSIDE + currentAccount, this.f63466g);
        j.v(PrivacyMarkActivityConfig.BAZHU_SHOW_OUTSIDE + currentAccount, this.f63467h);
        TbadkCoreApplication.getInst().setLocationShared(this.f63464e);
    }

    public void n(String str, int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        d.b.i0.r.d0.b j = d.b.i0.r.d0.b.j();
        j.v(str + currentAccount, i);
    }

    public void o(int i) {
        this.f63466g = i;
    }

    public void p(int i) {
        this.f63467h = i;
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63461b = i;
    }

    public void s(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63462c = i;
    }

    public void t(int i) {
        if (i > 3 || i < 1) {
            return;
        }
        this.f63463d = i;
    }

    public void u(int i) {
        if (i != 1) {
            this.f63464e = false;
        } else {
            this.f63464e = true;
        }
    }

    public void v(SimpleUser simpleUser) {
        this.i = simpleUser;
        if (simpleUser != null) {
            x(simpleUser.show_onlyme.intValue());
        }
    }

    public void w(int i) {
        if (i == 0) {
            this.f63465f = 1;
        } else {
            this.f63465f = i;
        }
    }

    public void x(int i) {
        this.k = i;
    }

    public void y(int i) {
        this.f63460a = i;
    }
}
