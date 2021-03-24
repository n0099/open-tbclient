package d.b.i0.i3.h;

import tbclient.GetThemeList.ThemeCarousel;
/* loaded from: classes5.dex */
public class a implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f56368a;

    /* renamed from: b  reason: collision with root package name */
    public String f56369b;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f56368a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f56369b;
    }

    public void c(ThemeCarousel themeCarousel) {
        if (themeCarousel == null) {
            return;
        }
        this.f56368a = themeCarousel.pic_url;
        this.f56369b = themeCarousel.active_url;
    }
}
