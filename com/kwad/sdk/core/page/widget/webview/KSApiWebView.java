package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes7.dex */
public class KSApiWebView extends ApiWebView {
    public KSApiWebView(Context context) {
        super(a(ao.d(context)));
    }

    public KSApiWebView(Context context, AttributeSet attributeSet) {
        super(a(ao.d(context)), attributeSet);
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(ao.d(context)), attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public KSApiWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a(ao.d(context)), attributeSet, i2, i3);
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(a(ao.d(context)), attributeSet, i2, z);
    }

    public static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
