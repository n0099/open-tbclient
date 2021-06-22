package d.a.o0.s1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes4.dex */
public class b implements d.a.n0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f64235a;

    /* renamed from: b  reason: collision with root package name */
    public String f64236b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f64235a = vipBannerItem.img_url;
        this.f64236b = vipBannerItem.link;
    }

    @Override // d.a.n0.r.w.b.a
    public String a() {
        return this.f64235a;
    }

    @Override // d.a.n0.r.w.b.a
    public String b() {
        return this.f64236b;
    }
}
