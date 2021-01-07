package com.qq.e.comm.plugin.b;

import android.app.Activity;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.UBVI;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.util.z;
/* loaded from: classes4.dex */
public class d implements UBVI {

    /* renamed from: a  reason: collision with root package name */
    private final c f12218a;

    /* renamed from: b  reason: collision with root package name */
    private final a f12219b;
    private final String c;

    public d(UnifiedBannerView unifiedBannerView, Activity activity, String str, String str2, UnifiedBannerADListener unifiedBannerADListener) {
        this.f12219b = new a(unifiedBannerView, this, unifiedBannerADListener, str2);
        this.c = str2;
        this.f12218a = new c(activity, new ADSize(-1, -2), str, str2, this.f12219b);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void destroy() {
        ai.a("gdt_tag_callback", "destroy()");
        z.a().a(this.c);
        NativeExpressADView a2 = this.f12219b.a();
        if (a2 != null) {
            a2.destroy();
        }
        this.f12218a.c();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void fetchAd() {
        ai.a("gdt_tag_callback", "fetchAd()");
        this.f12218a.a();
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void onWindowFocusChanged(boolean z) {
        ai.a("gdt_tag_callback", "onWindowFocusChanged(hasWindowFocus)");
        this.f12219b.a(z);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        ai.a("gdt_tag_callback", "setDownAPPConfirmPolicy(policy)");
        this.f12218a.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        ai.a("gdt_tag_callback", "setLoadAdParams(loadAdParams)");
        this.f12218a.a(loadAdParams);
    }

    @Override // com.qq.e.comm.pi.UBVI
    public void setRefresh(int i) {
        ai.a("gdt_tag_callback", "setRefresh(refresh)");
        this.f12218a.b(i);
    }
}
