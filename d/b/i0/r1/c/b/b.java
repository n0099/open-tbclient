package d.b.i0.r1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f60987a;

    /* renamed from: b  reason: collision with root package name */
    public String f60988b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f60987a = vipBannerItem.img_url;
        this.f60988b = vipBannerItem.link;
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f60987a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f60988b;
    }
}
