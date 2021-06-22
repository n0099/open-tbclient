package d.a.n0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f53853a;

    /* renamed from: b  reason: collision with root package name */
    public String f53854b;

    /* renamed from: c  reason: collision with root package name */
    public String f53855c;

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f53853a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f53854b;
    }

    public String c() {
        return this.f53854b;
    }

    public String d() {
        return this.f53853a;
    }

    public String e() {
        return this.f53855c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f53853a = bannerImage.img_url;
        this.f53854b = bannerImage.ahead_url;
        this.f53855c = bannerImage.title;
    }

    public void g(String str) {
        this.f53854b = str;
    }
}
