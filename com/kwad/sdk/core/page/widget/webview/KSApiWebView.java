package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes3.dex */
public class KSApiWebView extends ApiWebView {
    public KSApiWebView(Context context) {
        super(a(ao.d(context)));
    }

    public KSApiWebView(Context context, AttributeSet attributeSet) {
        super(a(ao.d(context)), attributeSet);
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i) {
        super(a(ao.d(context)), attributeSet, i);
    }

    @RequiresApi(api = 21)
    public KSApiWebView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(a(ao.d(context)), attributeSet, i, i2);
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(a(ao.d(context)), attributeSet, i, z);
    }

    private static Context a(Context context) {
        return (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
