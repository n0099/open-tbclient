package d.a.i0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.a.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f49207a;

    /* renamed from: b  reason: collision with root package name */
    public String f49208b;

    /* renamed from: c  reason: collision with root package name */
    public String f49209c;

    @Override // d.a.i0.r.w.b.a
    public String a() {
        return this.f49207a;
    }

    @Override // d.a.i0.r.w.b.a
    public String b() {
        return this.f49208b;
    }

    public String c() {
        return this.f49208b;
    }

    public String d() {
        return this.f49207a;
    }

    public String e() {
        return this.f49209c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f49207a = bannerImage.img_url;
        this.f49208b = bannerImage.ahead_url;
        this.f49209c = bannerImage.title;
    }

    public void g(String str) {
        this.f49208b = str;
    }
}
