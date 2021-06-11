package d.a.n0.k3;

import tbclient.ThemeCardPropMain;
/* loaded from: classes5.dex */
public class a {
    public static long k = 1350000;

    /* renamed from: a  reason: collision with root package name */
    public long f60626a;

    /* renamed from: b  reason: collision with root package name */
    public String f60627b;

    /* renamed from: c  reason: collision with root package name */
    public String f60628c;

    /* renamed from: d  reason: collision with root package name */
    public String f60629d;

    /* renamed from: e  reason: collision with root package name */
    public String f60630e;

    /* renamed from: f  reason: collision with root package name */
    public String f60631f;

    /* renamed from: g  reason: collision with root package name */
    public int f60632g;

    /* renamed from: h  reason: collision with root package name */
    public int f60633h;

    /* renamed from: i  reason: collision with root package name */
    public int f60634i;
    public int j = 0;

    public long a() {
        return this.f60626a;
    }

    public String b() {
        return this.f60631f;
    }

    public int c() {
        return this.j;
    }

    public String d() {
        return this.f60628c;
    }

    public String e() {
        return this.f60629d;
    }

    public int f() {
        return this.f60633h;
    }

    public int g() {
        return this.f60632g;
    }

    public int h() {
        return this.f60634i;
    }

    public String i() {
        return this.f60630e;
    }

    public String j() {
        return this.f60627b;
    }

    public void k(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain == null) {
            return;
        }
        this.f60626a = themeCardPropMain.props_id.longValue();
        this.f60627b = themeCardPropMain.title;
        this.f60628c = themeCardPropMain.description;
        this.f60629d = themeCardPropMain.example_url;
        this.f60630e = themeCardPropMain.permission;
        this.f60631f = themeCardPropMain.props_state_img;
        this.f60632g = themeCardPropMain.in_use.intValue();
        this.f60633h = themeCardPropMain.free_user_level.intValue();
        String str = themeCardPropMain.activity_url;
        this.f60634i = themeCardPropMain.is_finished.intValue();
    }

    public void l(String str) {
    }

    public void m(long j) {
        this.f60626a = j;
    }

    public void n(String str) {
        this.f60631f = str;
    }

    public void o(int i2) {
        this.j = i2;
    }

    public void p(String str) {
        this.f60628c = str;
    }

    public void q(String str) {
        this.f60629d = str;
    }

    public void r(int i2) {
        this.f60633h = i2;
    }

    public void s(int i2) {
        this.f60632g = i2;
    }

    public void t(int i2) {
        this.f60634i = i2;
    }

    public void u(String str) {
        this.f60630e = str;
    }

    public void v(String str) {
        this.f60627b = str;
    }
}
