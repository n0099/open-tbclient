package com.fun.ad.sdk;

import android.view.View;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes7.dex */
public interface FunNativeInfo {
    ChannelNativeAds getChannelNativeAds();

    String getDescription();

    String getIconUrl();

    List<String> getImageUrls();

    FunNativeAd.InteractionType getInteractionType();

    String getTitle();

    View getVideoView();
}
