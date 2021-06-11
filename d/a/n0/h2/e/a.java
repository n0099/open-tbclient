package d.a.n0.h2.e;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59220a;

    /* renamed from: b  reason: collision with root package name */
    public String f59221b;

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f59220a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f59221b;
    }

    public String c() {
        return this.f59221b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f59220a = bannerImage.img_url;
        this.f59221b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
