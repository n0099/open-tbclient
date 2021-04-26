package com.fun.ad.sdk;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes6.dex */
public interface FunNativeAd {

    /* loaded from: classes6.dex */
    public enum InteractionType {
        TYPE_UNKNOW,
        TYPE_DOWNLOAD,
        TYPE_DIAL,
        TYPE_BROWSE
    }

    ChannelNativeAds_6 getChannelNativeAds_6();

    String getDescription();

    String getIconUrl();

    List<String> getImageUrls();

    InteractionType getInteractionType();

    String getTitle();

    View getVideoView();

    void show(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, FunAdInteractionListener funAdInteractionListener);
}
