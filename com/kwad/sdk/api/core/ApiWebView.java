package com.kwad.sdk.api.core;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.kwad.sdk.api.loader.Wrapper;
@KsAdSdkDynamicApi
/* loaded from: classes7.dex */
public class ApiWebView extends WebView {
    @KsAdSdkDynamicApi
    public ApiWebView(Context context) {
        super(Wrapper.unwrapContextIfNeed(context));
    }

    @KsAdSdkDynamicApi
    public ApiWebView(Context context, AttributeSet attributeSet) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet);
    }

    @KsAdSdkDynamicApi
    public ApiWebView(Context context, AttributeSet attributeSet, int i) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i);
    }

    @KsAdSdkDynamicApi
    public ApiWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i, i2);
    }

    @KsAdSdkDynamicApi
    public ApiWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(Wrapper.unwrapContextIfNeed(context), attributeSet, i, z);
    }

    @KsAdSdkDynamicApi
    public Context getContext2() {
        return Wrapper.wrapContextIfNeed(getContext());
    }
}
