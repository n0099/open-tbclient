package d.a.k0.s0;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
/* loaded from: classes4.dex */
public class d implements d.a.k0.r0.c {
    @Override // d.a.k0.r0.c
    public d.a.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.i4) {
            d.a.k0.s0.e.b bVar = new d.a.k0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.i0(d.a.k0.r0.d.c.e().d("pb_banner"));
            bVar.g0("pb");
            bVar.h0("pb_banner");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.a.k0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.a.k0.r0.c
    public d.a.c.j.e.a<?, ?> b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            d.a.k0.s0.e.b bVar = new d.a.k0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.i0(d.a.k0.r0.d.c.e().d("frs_feed"));
            bVar.g0("frs");
            bVar.h0("frs_feed");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.a.k0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.a.k0.r0.c
    public d.a.c.j.e.a<?, ?> c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            d.a.k0.s0.e.b bVar = new d.a.k0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.i0("6051001980-1210572494");
            bVar.g0("personalize");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.a.k0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }

    @Override // d.a.k0.r0.c
    public d.a.c.j.e.a<?, ?> d(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            d.a.k0.s0.e.b bVar = new d.a.k0.s0.e.b(baseFragmentActivity, bdUniqueId);
            bVar.i0(d.a.k0.r0.d.c.e().d("frs_feed"));
            bVar.g0("frs");
            bVar.h0("frs_feed");
            return bVar;
        } else if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.a.k0.s0.e.a(baseFragmentActivity, bdUniqueId);
        } else {
            return null;
        }
    }
}
