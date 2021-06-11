package d.a.n0.s1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.a.m0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f64110a;

    /* renamed from: b  reason: collision with root package name */
    public String f64111b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f64110a = vipBannerItem.img_url;
        this.f64111b = vipBannerItem.link;
    }

    @Override // d.a.m0.r.w.b.a
    public String a() {
        return this.f64110a;
    }

    @Override // d.a.m0.r.w.b.a
    public String b() {
        return this.f64111b;
    }
}
