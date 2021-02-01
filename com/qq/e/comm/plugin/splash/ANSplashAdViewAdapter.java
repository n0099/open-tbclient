package com.qq.e.comm.plugin.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.mediation.interfaces.BaseSplashAd;
/* loaded from: classes15.dex */
class ANSplashAdViewAdapter extends BaseSplashAd implements com.qq.e.comm.plugin.r.a {
    private b mSplashAdView;

    public ANSplashAdViewAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        this.mSplashAdView = new b(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, com.qq.e.comm.plugin.ad.l.UNION_ADAPTER);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchAdOnly() {
        this.mSplashAdView.fetchAdOnly();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void fetchAndShowIn(ViewGroup viewGroup) {
        this.mSplashAdView.fetchAndShowIn(viewGroup);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public int getAdapterPriority() {
        return this.mSplashAdView.g();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public int getECPM() {
        return this.mSplashAdView.h();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public String getECPMLevel() {
        return this.mSplashAdView.getECPMLevel();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.mSplashAdView.i();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.mSplashAdView.j();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void preload() {
        this.mSplashAdView.preload();
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setAdListener(ADListener aDListener) {
        this.mSplashAdView.setAdListener(aDListener);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setFetchDelay(int i) {
        this.mSplashAdView.setFetchDelay(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setLoadAdParams(LoadAdParams loadAdParams) {
        this.mSplashAdView.setLoadAdParams(loadAdParams);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void setSkipView(View view) {
        this.mSplashAdView.setSkipView(view);
    }

    @Override // com.qq.e.mediation.interfaces.BaseSplashAd
    public void showAd(ViewGroup viewGroup) {
        this.mSplashAdView.showAd(viewGroup);
    }
}
