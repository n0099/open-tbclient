package com.fun.ad.sdk;

import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.win.opensdk.PBNative;
/* loaded from: classes6.dex */
public class ChannelNativeAds_6 {
    public final TTNativeAd csjNative;
    public final NativeUnifiedADData gdtNative;
    public final PBNative jyNative;
    public final KsNativeAd ksNative;
    public GdtADStatusChangeListener mListener;

    /* loaded from: classes6.dex */
    public interface GdtADStatusChangeListener {
        void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData);
    }

    public ChannelNativeAds_6(TTNativeAd tTNativeAd, NativeUnifiedADData nativeUnifiedADData, PBNative pBNative, KsNativeAd ksNativeAd) {
        this.csjNative = tTNativeAd;
        this.gdtNative = nativeUnifiedADData;
        this.jyNative = pBNative;
        this.ksNative = ksNativeAd;
    }

    public static ChannelNativeAds_6 create(TTNativeAd tTNativeAd) {
        return new ChannelNativeAds_6(tTNativeAd, null, null, null);
    }

    public static ChannelNativeAds_6 create(KsNativeAd ksNativeAd) {
        return new ChannelNativeAds_6(null, null, null, ksNativeAd);
    }

    public static ChannelNativeAds_6 create(NativeUnifiedADData nativeUnifiedADData) {
        return new ChannelNativeAds_6(null, nativeUnifiedADData, null, null);
    }

    public static ChannelNativeAds_6 create(PBNative pBNative) {
        return new ChannelNativeAds_6(null, null, pBNative, null);
    }

    public GdtADStatusChangeListener getGdtADStatusChangeListener() {
        return this.mListener;
    }

    public void setGdtADStatusChangeListener(GdtADStatusChangeListener gdtADStatusChangeListener) {
        this.mListener = gdtADStatusChangeListener;
    }
}
