package com.qq.e.comm.plugin.intersitial2;

import android.app.Activity;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.util.AdError;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
/* loaded from: classes15.dex */
class ANInterstitialAdAdapter extends BaseInterstitialAd implements com.qq.e.comm.plugin.r.a {
    private UnifiedInterstitialADListener mListener;
    private e unifiedInterstitialADDelegate;

    public ANInterstitialAdAdapter(Activity activity, String str, String str2) {
        super(activity, str, str2);
        this.unifiedInterstitialADDelegate = new e(activity, GDTADManager.getInstance().getAppStatus().getAPPID(), str, l.UNION_ADAPTER, new UnifiedInterstitialADListener() { // from class: com.qq.e.comm.plugin.intersitial2.ANInterstitialAdAdapter.1
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClicked() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADClicked();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADClosed() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADClosed();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADExposure() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADExposure();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADLeftApplication();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADOpened();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADReceive() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onADReceive();
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onNoAD(AdError adError) {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onNoAD(adError);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onVideoCached() {
                if (ANInterstitialAdAdapter.this.mListener != null) {
                    ANInterstitialAdAdapter.this.mListener.onVideoCached();
                }
            }
        });
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void close() {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.close();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void destory() {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.destory();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdPatternType() {
        return this.unifiedInterstitialADDelegate.getAdPatternType();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getAdapterPriority() {
        return this.unifiedInterstitialADDelegate.a();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public int getECPM() {
        return this.unifiedInterstitialADDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public String getECPMLevel() {
        return this.unifiedInterstitialADDelegate.getECPMLevel();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.unifiedInterstitialADDelegate.getMediationPrice();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.unifiedInterstitialADDelegate.isContractAd();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public boolean isValid() {
        return this.unifiedInterstitialADDelegate.isValid();
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void loadAd() {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.loadAd();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setAdListener(UnifiedInterstitialADListener unifiedInterstitialADListener) {
        this.mListener = unifiedInterstitialADListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMaxVideoDuration(int i) {
        this.unifiedInterstitialADDelegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMediaListener(UnifiedInterstitialMediaListener unifiedInterstitialMediaListener) {
        this.unifiedInterstitialADDelegate.setMediaListener(unifiedInterstitialMediaListener);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setMinVideoDuration(int i) {
        this.unifiedInterstitialADDelegate.setMinVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setVideoOption(VideoOption videoOption) {
        this.unifiedInterstitialADDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void setVideoPlayPolicy(int i) {
        this.unifiedInterstitialADDelegate.setVideoPlayPolicy(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show() {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.show();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void show(Activity activity) {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.show(activity);
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void showAsPopupWindow() {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.showAsPopupWindow();
        }
    }

    @Override // com.qq.e.mediation.interfaces.BaseInterstitialAd
    public void showAsPopupWindow(Activity activity) {
        if (this.unifiedInterstitialADDelegate != null) {
            this.unifiedInterstitialADDelegate.showAsPopupWindow(activity);
        }
    }
}
