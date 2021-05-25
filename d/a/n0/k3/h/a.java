package d.a.n0.k3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f57117a;

    /* renamed from: b  reason: collision with root package name */
    public String f57118b;

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f57117a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f57118b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f57117a = themeCarousel.pic_url;
        this.f57118b = themeCarousel.active_url;
    }
}
