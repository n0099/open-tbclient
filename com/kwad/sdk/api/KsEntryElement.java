package com.kwad.sdk.api;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkApi;
@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public interface KsEntryElement {

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public @interface EntranceType {
        public static final int ENTRYTYPE_BLUR = 4;
        public static final int ENTRYTYPE_GIF = 3;
        public static final int ENTRYTYPE_SCROOLTYPE = 2;
        public static final int ENTRYTYPE_TAB = 5;
        public static final int ENTRYTYPE_TWOSINGLE = 1;
    }

    @KsAdSdkApi
    @Keep
    /* loaded from: classes3.dex */
    public interface OnFeedClickListener {
        @KsAdSdkApi
        @Keep
        void handleFeedClick(@EntranceType int i, int i2, View view);
    }

    @Nullable
    @KsAdSdkApi
    @Keep
    View getEntryView(Context context, OnFeedClickListener onFeedClickListener);

    @KsAdSdkApi
    @Keep
    int getEntryViewType();

    @KsAdSdkApi
    @Keep
    void refresh();

    @KsAdSdkApi
    @Keep
    void setEnableSlideAutoOpen(boolean z);

    @KsAdSdkApi
    @Keep
    void setTouchIntercept(boolean z);
}
