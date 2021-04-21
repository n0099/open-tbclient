package d.b.i0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.b.i0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f51578a;

    /* renamed from: b  reason: collision with root package name */
    public String f51579b;

    /* renamed from: c  reason: collision with root package name */
    public String f51580c;

    @Override // d.b.i0.r.w.b.a
    public String a() {
        return this.f51578a;
    }

    @Override // d.b.i0.r.w.b.a
    public String b() {
        return this.f51579b;
    }

    public String c() {
        return this.f51579b;
    }

    public String d() {
        return this.f51578a;
    }

    public String e() {
        return this.f51580c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f51578a = bannerImage.img_url;
        this.f51579b = bannerImage.ahead_url;
        this.f51580c = bannerImage.title;
    }

    public void g(String str) {
        this.f51579b = str;
    }
}
