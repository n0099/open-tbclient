package com.fun.ad.sdk;

import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;
/* loaded from: classes9.dex */
public interface FunNativeAdInflater {
    ViewGroup getAdContainer(FunNativeAd funNativeAd);

    List<View> getClickViews();

    List<View> getCreativeViews();

    NativeAdContainer getGdtAdContainer(FunNativeAd funNativeAd);
}
