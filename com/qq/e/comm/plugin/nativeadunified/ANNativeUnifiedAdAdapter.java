package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.List;
/* loaded from: classes4.dex */
class ANNativeUnifiedAdAdapter extends BaseNativeUnifiedAd {
    private List<NativeUnifiedADData> data;
    private i delegate;
    private ADListener listener;

    public ANNativeUnifiedAdAdapter(Context context, String str, String str2) {
        super(context, str, str2);
        this.delegate = new i(context, GDTADManager.getInstance().getAppStatus().getAPPID(), str, com.qq.e.comm.plugin.ad.l.UNION_ADAPTER, new ADListener() { // from class: com.qq.e.comm.plugin.nativeadunified.ANNativeUnifiedAdAdapter.1
            @Override // com.qq.e.comm.adevent.ADListener
            public void onADEvent(ADEvent aDEvent) {
                ANNativeUnifiedAdAdapter.this.listener.onADEvent(aDEvent);
                if (aDEvent == null || aDEvent.getType() != 1 || aDEvent.getParas() == null || aDEvent.getParas().length <= 0) {
                    return;
                }
                ANNativeUnifiedAdAdapter.this.data = (List) aDEvent.getParas()[0];
            }
        });
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public int getAdapterPriority() {
        return this.delegate.e();
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public int getECPM() {
        if (this.data == null || this.data.isEmpty()) {
            return -1;
        }
        return this.data.get(0).getECPM();
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void loadData(int i) {
        this.data = null;
        this.delegate.loadData(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setAdListener(ADListener aDListener) {
        this.listener = aDListener;
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setBrowserType(int i) {
        this.delegate.setBrowserType(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setCategories(List<String> list) {
        this.delegate.setCategories(list);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setDownAPPConfirmPolicy(DownAPPConfirmPolicy downAPPConfirmPolicy) {
        this.delegate.setDownAPPConfirmPolicy(downAPPConfirmPolicy);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMaxVideoDuration(int i) {
        this.delegate.setMaxVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setMinVideoDuration(int i) {
        this.delegate.setMinVideoDuration(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setVideoADContainerRender(int i) {
        this.delegate.setVideoADContainerRender(i);
    }

    @Override // com.qq.e.mediation.interfaces.BaseNativeUnifiedAd
    public void setVideoPlayPolicy(int i) {
        this.delegate.setVideoPlayPolicy(i);
    }
}
