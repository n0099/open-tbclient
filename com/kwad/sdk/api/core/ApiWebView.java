package com.kwad.sdk.api.core;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
@Keep
/* loaded from: classes4.dex */
public class ApiWebView extends WebView {
    @KsAdSdkDynamicApi
    @Keep
    public ApiWebView(Context context) {
        super(Wrapper.unwrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    @Keep
    public ApiWebView(Context context, AttributeSet attributeSet) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet);
    }

    @KsAdSdkDynamicApi
    @Keep
    public ApiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i2);
    }

    @KsAdSdkDynamicApi
    @Keep
    @RequiresApi(api = 21)
    public ApiWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i2, i3);
    }

    @KsAdSdkDynamicApi
    @Keep
    public ApiWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i2, z);
    }

    @KsAdSdkDynamicApi
    @Keep
    public Context getContext2() {
        return Wrapper.wrapContextIfNeed(getContext());
    }
}
