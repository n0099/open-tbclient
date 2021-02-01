package com.qq.e.comm.plugin.gdtnativead;

import android.content.Context;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.ad.l;
import com.qq.e.comm.plugin.ad.n;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.mediation.interfaces.BaseNativeExpressAd;
import java.util.List;
/* loaded from: classes15.dex */
class ANNativeExpressAdAdapter extends BaseNativeExpressAd implements com.qq.e.comm.plugin.r.a {
    private f mDelegate;
    private NativeExpressADView mExpressADView;
    private ADListener mListener;

    public ANNativeExpressAdAdapter(Context context, ADSize aDSize, String str, String str2) {
        super(context, aDSize, str, str2);
        this.mDelegate = new f(context, aDSize, GDTADManager.getInstance().getAppStatus().getAPPID(), str, l.UNION_ADAPTER, new ADListener() { // from class: com.qq.e.comm.plugin.gdtnativead.ANNativeExpressAdAdapter.1
            @Override // com.qq.e.comm.adevent.ADListener
            public void onADEvent(ADEvent aDEvent) {
                if (aDEvent != null && aDEvent.getType() == 2 && aDEvent.getParas() != null && aDEvent.getParas().length > 0) {
                    try {
                        List list = (List) aDEvent.getParas()[0];
                        if (list != null && list.size() > 0) {
                            ANNativeExpressAdAdapter.this.mExpressADView = (NativeExpressADView) list.get(0);
                        }
                    } catch (Exception e) {
                        GDTLogger.w("ANNativeExpressAdAdapter cast exception");
                        e.printStackTrace();
                    }
                }
                if (ANNativeExpressAdAdapter.this.mListener != null) {
                    ANNativeExpressAdAdapter.this.mListener.onADEvent(aDEvent);
                }
            }
        });
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public int getECPM() {
        if (this.mExpressADView == null || this.mExpressADView.getBoundData() == null) {
            return -1;
        }
        return this.mExpressADView.getBoundData().getECPM();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public int getMediationPrice() {
        if (this.mExpressADView == null || !(this.mExpressADView.getBoundData() instanceof n)) {
            return -1;
        }
        return ((n) this.mExpressADView.getBoundData()).getMediationPrice();
    }

    @Override // com.qq.e.comm.plugin.r.a
    public boolean isContractAd() {
        if (this.mExpressADView == null || !(this.mExpressADView.getBoundData() instanceof n)) {
            return false;
        }
        return ((n) this.mExpressADView.getBoundData()).isContractAd();
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i) {
        this.mDelegate.loadAd(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void loadAD(int i, LoadAdParams loadAdParams) {
        this.mDelegate.loadAd(i, loadAdParams);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setAdListener(ADListener aDListener) {
        this.mListener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMaxVideoDuration(int i) {
        this.mDelegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setMinVideoDuration(int i) {
        this.mDelegate.setMinVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setVideoOption(VideoOption videoOption) {
        this.mDelegate.setVideoOption(videoOption);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeExpressAd
    public void setVideoPlayPolicy(int i) {
        this.mDelegate.setVideoPlayPolicy(i);
    }
}
