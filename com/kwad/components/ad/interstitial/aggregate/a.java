package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.e.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public final class a extends PagerAdapter {
    public final KsAdVideoPlayConfig dU;
    public final KsInterstitialAd.AdInteractionListener ie;
    public final List<AdResultData> im = new ArrayList();
    public final com.kwad.components.ad.interstitial.d io;
    public final boolean iq;
    public b ir;
    public InterfaceC0595a is;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0595a {
        void cp();
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(com.kwad.components.ad.interstitial.g.c cVar, int i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        return view2 == obj;
    }

    public a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.io = dVar;
        this.dU = ksAdVideoPlayConfig;
        this.ie = adInteractionListener;
        this.iq = com.kwad.sdk.core.response.b.a.cq(e.dP(com.kwad.sdk.core.response.b.c.m(adResultData))) == 1;
    }

    public final void d(List<AdResultData> list) {
        if (list != null && list.size() > 0) {
            this.im.clear();
            this.im.addAll(list);
        }
    }

    public final void a(InterfaceC0595a interfaceC0595a) {
        this.is = interfaceC0595a;
    }

    public final void a(b bVar) {
        this.ir = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.im.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, final int i) {
        boolean z;
        com.kwad.components.ad.interstitial.g.c cVar = new com.kwad.components.ad.interstitial.g.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        cVar.setAggregateAdView(z);
        if (i == 0) {
            cVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                @Override // com.kwad.components.ad.interstitial.e.c.a
                public final void b(long j, long j2) {
                    AdResultData adResultData = (AdResultData) a.this.im.get(i);
                    if (adResultData == null) {
                        return;
                    }
                    com.kwad.components.ad.interstitial.report.a.dM().b(com.kwad.sdk.core.response.b.c.m(adResultData), j, j2);
                    if (a.this.is != null) {
                        a.this.is.cp();
                    }
                }
            });
        }
        if (i > 0) {
            int i2 = 7;
            if (i == 1) {
                if (this.iq) {
                    i2 = 8;
                }
                cVar.setAggregateShowTriggerType(i2);
            } else {
                cVar.setAggregateShowTriggerType(7);
            }
        }
        cVar.a(this.im.get(i), this.io, this.dU, this.ie);
        b bVar = this.ir;
        if (bVar != null) {
            bVar.a(cVar, i);
        }
        return cVar;
    }
}
