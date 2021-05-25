package d.a.n0.h2.e;

import tbclient.BannerImage;
/* loaded from: classes5.dex */
public class a implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f55531a;

    /* renamed from: b  reason: collision with root package name */
    public String f55532b;

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f55531a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f55532b;
    }

    public String c() {
        return this.f55532b;
    }

    public void d(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f55531a = bannerImage.img_url;
        this.f55532b = bannerImage.ahead_url;
        String str = bannerImage.title;
    }
}
