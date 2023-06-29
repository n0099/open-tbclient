package com.kwad.components.ad.interstitial.widget;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.b.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public final class a extends PagerAdapter {
    public final KsAdVideoPlayConfig cN;
    public final KsInterstitialAd.AdInteractionListener fo;
    public final Dialog gi;
    public final boolean ia;
    public b ib;
    public InterfaceC0609a ic;
    public final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* renamed from: com.kwad.components.ad.interstitial.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0609a {
        void dL();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(e eVar, int i);
    }

    public a(AdTemplate adTemplate, Dialog dialog, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.gi = dialog;
        this.cN = ksAdVideoPlayConfig;
        this.fo = adInteractionListener;
        this.ia = com.kwad.sdk.core.response.a.a.bu(com.kwad.sdk.core.response.a.d.bQ(adTemplate)) == 1;
    }

    public final void a(InterfaceC0609a interfaceC0609a) {
        this.ic = interfaceC0609a;
    }

    public final void a(b bVar) {
        this.ib = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        e eVar = new e(viewGroup.getContext());
        viewGroup.addView(eVar);
        eVar.setAggregateAdView(i > 0);
        if (i == 0) {
            eVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.widget.a.1
                @Override // com.kwad.components.ad.interstitial.b.c.a
                public final void cy() {
                    if (a.this.ic != null) {
                        a.this.ic.dL();
                    }
                }
            });
        }
        if (i > 0) {
            int i2 = 7;
            if (i == 1 && this.ia) {
                i2 = 8;
            }
            eVar.setAggregateShowTriggerType(i2);
        }
        eVar.a(this.mAdTemplateList.get(i), this.gi, this.cN, this.fo);
        b bVar = this.ib;
        if (bVar != null) {
            bVar.a(eVar, i);
        }
        return eVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        return view2 == obj;
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }
}
