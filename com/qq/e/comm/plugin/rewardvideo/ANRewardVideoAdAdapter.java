package com.qq.e.comm.plugin.rewardvideo;

import android.app.Activity;
import android.content.Context;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.mediation.interfaces.BaseRewardAd;
/* loaded from: classes4.dex */
class ANRewardVideoAdAdapter extends BaseRewardAd implements com.qq.e.comm.plugin.r.a {
    private j mDelegate;
    private ADListener mListener;

    public ANRewardVideoAdAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        this.mDelegate = new j(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, com.qq.e.comm.plugin.ad.l.UNION_ADAPTER, new ADListener() { // from class: com.qq.e.comm.plugin.rewardvideo.ANRewardVideoAdAdapter.1
            @Override // com.qq.e.comm.adevent.ADListener
            public void onADEvent(ADEvent aDEvent) {
                if (ANRewardVideoAdAdapter.this.mListener != null) {
                    ANRewardVideoAdAdapter.this.mListener.onADEvent(aDEvent);
                }
            }
        });
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getAdapterPriority() {
        return this.mDelegate.b();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getECPM() {
        return this.mDelegate.getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public String getECPMLevel() {
        return this.mDelegate.getECPMLevel();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public long getExpireTimestamp() {
        return this.mDelegate.getExpireTimestamp();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        return this.mDelegate.getMediationPrice();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public int getVideoDuration() {
        return this.mDelegate.getVideoDuration();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public boolean hasShown() {
        return this.mDelegate.hasShown();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        return this.mDelegate.isContractAd();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void loadAD() {
        this.mDelegate.loadAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void setVolumOn(boolean z) {
        this.mDelegate.setVolumeOn(z);
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD() {
        this.mDelegate.showAD();
    }

    @Override // com.qq.e.mediation.interfaces.BaseRewardAd
    public void showAD(Activity activity) {
        this.mDelegate.showAD(activity);
    }
}
