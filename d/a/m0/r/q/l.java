package d.a.m0.r.q;

import tbclient.BannerImage;
/* loaded from: classes3.dex */
public class l implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f53746a;

    /* renamed from: b  reason: collision with root package name */
    public String f53747b;

    /* renamed from: c  reason: collision with root package name */
    public String f53748c;

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f53746a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f53747b;
    }

    public String c() {
        return this.f53747b;
    }

    public String d() {
        return this.f53746a;
    }

    public String e() {
        return this.f53748c;
    }

    public void f(BannerImage bannerImage) {
        if (bannerImage == null) {
            return;
        }
        this.f53746a = bannerImage.img_url;
        this.f53747b = bannerImage.ahead_url;
        this.f53748c = bannerImage.title;
    }

    public void g(String str) {
        this.f53747b = str;
    }
}
