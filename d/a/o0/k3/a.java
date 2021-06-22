package d.a.o0.k3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f60751a;

    /* renamed from: b  reason: collision with root package name */
    public String f60752b;

    /* renamed from: c  reason: collision with root package name */
    public String f60753c;

    /* renamed from: d  reason: collision with root package name */
    public String f60754d;

    /* renamed from: e  reason: collision with root package name */
    public String f60755e;

    /* renamed from: f  reason: collision with root package name */
    public String f60756f;

    /* renamed from: g  reason: collision with root package name */
    public int f60757g;

    /* renamed from: h  reason: collision with root package name */
    public int f60758h;

    /* renamed from: i  reason: collision with root package name */
    public int f60759i;
    public int j = 0;

    public long a() {
        return this.f60751a;
    }

    public String b() {
        return this.f60756f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f60753c;
    }

    public String e() {
        return this.f60754d;
    }

    public int f() {
        return this.f60758h;
    }

    public int g() {
        return this.f60757g;
    }

    public int h() {
        return this.f60759i;
    }

    public String i() {
        return this.f60755e;
    }

    public String j() {
        return this.f60752b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f60751a = themeCardPropMain.props_id.longValue();
        this.f60752b = themeCardPropMain.title;
        this.f60753c = themeCardPropMain.description;
        this.f60754d = themeCardPropMain.example_url;
        this.f60755e = themeCardPropMain.permission;
        this.f60756f = themeCardPropMain.props_state_img;
        this.f60757g = themeCardPropMain.in_use.intValue();
        this.f60758h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.f60759i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f60751a = j;
    }

    public void n(String str) {
        this.f60756f = str;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.f60753c = str;
    }

    public void q(String str) {
        this.f60754d = str;
    }

    public void r(int i2) {
        this.f60758h = i2;
    }

    public void s(int i2) {
        this.f60757g = i2;
    }

    public void t(int i2) {
        this.f60759i = i2;
    }

    public void u(String str) {
        this.f60755e = str;
    }

    public void v(String str) {
        this.f60752b = str;
    }
}
