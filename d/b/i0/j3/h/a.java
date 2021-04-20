package d.b.i0.j3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f57816a;

    /* renamed from: b  reason: collision with root package name */
    public String f57817b;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f57816a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f57817b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f57816a = themeCarousel.pic_url;
        this.f57817b = themeCarousel.active_url;
    }
}
