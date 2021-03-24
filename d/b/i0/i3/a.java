package d.b.i0.i3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f56200a;

    /* renamed from: b  reason: collision with root package name */
    public String f56201b;

    /* renamed from: c  reason: collision with root package name */
    public String f56202c;

    /* renamed from: d  reason: collision with root package name */
    public String f56203d;

    /* renamed from: e  reason: collision with root package name */
    public String f56204e;

    /* renamed from: f  reason: collision with root package name */
    public String f56205f;

    /* renamed from: g  reason: collision with root package name */
    public int f56206g;

    /* renamed from: h  reason: collision with root package name */
    public int f56207h;
    public int i;
    public int j = 0;

    public long a() {
        return this.f56200a;
    }

    public String b() {
        return this.f56205f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f56202c;
    }

    public String e() {
        return this.f56203d;
    }

    public int f() {
        return this.f56207h;
    }

    public int g() {
        return this.f56206g;
    }

    public int h() {
        return this.i;
    }

    public String i() {
        return this.f56204e;
    }

    public String j() {
        return this.f56201b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f56200a = themeCardPropMain.props_id.longValue();
        this.f56201b = themeCardPropMain.title;
        this.f56202c = themeCardPropMain.description;
        this.f56203d = themeCardPropMain.example_url;
        this.f56204e = themeCardPropMain.permission;
        this.f56205f = themeCardPropMain.props_state_img;
        this.f56206g = themeCardPropMain.in_use.intValue();
        this.f56207h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f56200a = j;
    }

    public void n(String str) {
        this.f56205f = str;
    }

    public void o(int i) {
        this.j = i;
    }

    public void p(String str) {
        this.f56202c = str;
    }

    public void q(String str) {
        this.f56203d = str;
    }

    public void r(int i) {
        this.f56207h = i;
    }

    public void s(int i) {
        this.f56206g = i;
    }

    public void t(int i) {
        this.i = i;
    }

    public void u(String str) {
        this.f56204e = str;
    }

    public void v(String str) {
        this.f56201b = str;
    }
}
