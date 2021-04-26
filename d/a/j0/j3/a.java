package d.a.j0.j3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f56050a;

    /* renamed from: b  reason: collision with root package name */
    public String f56051b;

    /* renamed from: c  reason: collision with root package name */
    public String f56052c;

    /* renamed from: d  reason: collision with root package name */
    public String f56053d;

    /* renamed from: e  reason: collision with root package name */
    public String f56054e;

    /* renamed from: f  reason: collision with root package name */
    public String f56055f;

    /* renamed from: g  reason: collision with root package name */
    public int f56056g;

    /* renamed from: h  reason: collision with root package name */
    public int f56057h;

    /* renamed from: i  reason: collision with root package name */
    public int f56058i;
    public int j = 0;

    public long a() {
        return this.f56050a;
    }

    public String b() {
        return this.f56055f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f56052c;
    }

    public String e() {
        return this.f56053d;
    }

    public int f() {
        return this.f56057h;
    }

    public int g() {
        return this.f56056g;
    }

    public int h() {
        return this.f56058i;
    }

    public String i() {
        return this.f56054e;
    }

    public String j() {
        return this.f56051b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f56050a = themeCardPropMain.props_id.longValue();
        this.f56051b = themeCardPropMain.title;
        this.f56052c = themeCardPropMain.description;
        this.f56053d = themeCardPropMain.example_url;
        this.f56054e = themeCardPropMain.permission;
        this.f56055f = themeCardPropMain.props_state_img;
        this.f56056g = themeCardPropMain.in_use.intValue();
        this.f56057h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.f56058i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f56050a = j;
    }

    public void n(String str) {
        this.f56055f = str;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.f56052c = str;
    }

    public void q(String str) {
        this.f56053d = str;
    }

    public void r(int i2) {
        this.f56057h = i2;
    }

    public void s(int i2) {
        this.f56056g = i2;
    }

    public void t(int i2) {
        this.f56058i = i2;
    }

    public void u(String str) {
        this.f56054e = str;
    }

    public void v(String str) {
        this.f56051b = str;
    }
}
