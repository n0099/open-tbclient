package d.b.i0.q1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59293a;

    /* renamed from: b  reason: collision with root package name */
    public String f59294b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f59293a = vipBannerItem.img_url;
        this.f59294b = vipBannerItem.link;
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f59293a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f59294b;
    }
}
