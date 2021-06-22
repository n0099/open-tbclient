package d.a.o0.k3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60931a;

    /* renamed from: b  reason: collision with root package name */
    public String f60932b;

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f60931a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f60932b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f60931a = themeCarousel.pic_url;
        this.f60932b = themeCarousel.active_url;
    }
}
