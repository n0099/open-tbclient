package com.fun.ad.sdk;

import com.baidu.mobads.nativecpu.IBasicCPUData;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.win.opensdk.PBNative;
/* loaded from: classes4.dex */
public class ChannelNativeAds_5 {
    public final IBasicCPUData baiduNative;
    public final TTNativeAd csjNative;
    public final NativeUnifiedADData gdtNative;
    public final PBNative jyNative;
    public final KsNativeAd ksNative;
    public GdtADStatusChangeListener mListener;

    /* loaded from: classes4.dex */
    public interface GdtADStatusChangeListener {
        void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData);
    }

    public ChannelNativeAds_5(IBasicCPUData iBasicCPUData, TTNativeAd tTNativeAd, NativeUnifiedADData nativeUnifiedADData, PBNative pBNative, KsNativeAd ksNativeAd) {
        this.baiduNative = iBasicCPUData;
        this.csjNative = tTNativeAd;
        this.gdtNative = nativeUnifiedADData;
        this.jyNative = pBNative;
        this.ksNative = ksNativeAd;
    }

    public static ChannelNativeAds_5 create(IBasicCPUData iBasicCPUData) {
        return new ChannelNativeAds_5(iBasicCPUData, null, null, null, null);
    }

    public static ChannelNativeAds_5 create(TTNativeAd tTNativeAd) {
        return new ChannelNativeAds_5(null, tTNativeAd, null, null, null);
    }

    public static ChannelNativeAds_5 create(KsNativeAd ksNativeAd) {
        return new ChannelNativeAds_5(null, null, null, null, ksNativeAd);
    }

    public static ChannelNativeAds_5 create(NativeUnifiedADData nativeUnifiedADData) {
        return new ChannelNativeAds_5(null, null, nativeUnifiedADData, null, null);
    }

    public static ChannelNativeAds_5 create(PBNative pBNative) {
        return new ChannelNativeAds_5(null, null, null, pBNative, null);
    }

    public GdtADStatusChangeListener getGdtADStatusChangeListener() {
        return this.mListener;
    }

    public void setGdtADStatusChangeListener(GdtADStatusChangeListener gdtADStatusChangeListener) {
        this.mListener = gdtADStatusChangeListener;
    }
}
