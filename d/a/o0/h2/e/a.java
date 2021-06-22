package d.a.o0.h2.e;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59345a;

    /* renamed from: b  reason: collision with root package name */
    public String f59346b;

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f59345a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f59346b;
    }

    public String c() {
        return this.f59346b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f59345a = bannerImage.img_url;
        this.f59346b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
