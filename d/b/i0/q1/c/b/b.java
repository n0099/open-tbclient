package d.b.i0.q1.c.b;

import tbclient.GetVipInfo.VipBannerItem;
/* loaded from: classes3.dex */
public class b implements d.b.h0.r.w.b.a {

    /* renamed from: a  reason: collision with root package name */
    public String f59292a;

    /* renamed from: b  reason: collision with root package name */
    public String f59293b;

    public b(VipBannerItem vipBannerItem) {
        if (vipBannerItem == null) {
            return;
        }
        this.f59292a = vipBannerItem.img_url;
        this.f59293b = vipBannerItem.link;
    }

    @Override // d.b.h0.r.w.b.a
    public String a() {
        return this.f59292a;
    }

    @Override // d.b.h0.r.w.b.a
    public String b() {
        return this.f59293b;
    }
}
