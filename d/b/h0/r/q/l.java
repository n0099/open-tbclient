package d.b.h0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f50835a;

    /* renamed from: b  reason: collision with root package name */
    public String f50836b;

    /* renamed from: c  reason: collision with root package name */
    public String f50837c;

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f50835a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f50836b;
    }

    public String c() {
        return this.f50836b;
    }

    public String d() {
        return this.f50835a;
    }

    public String e() {
        return this.f50837c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f50835a = bannerImage.img_url;
        this.f50836b = bannerImage.ahead_url;
        this.f50837c = bannerImage.title;
    }

    public void g(String str) {
        this.f50836b = str;
    }
}
