package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.utils.an;
/* loaded from: classes6.dex */
public class KSApiWebView extends ApiWebView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33335a;

    public KSApiWebView(Context context) {
        super(a(an.d(context)));
        this.f33335a = true;
    }

    public KSApiWebView(Context context, AttributeSet attributeSet) {
        super(a(an.d(context)), attributeSet);
        this.f33335a = true;
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i2) {
        super(a(an.d(context)), attributeSet, i2);
        this.f33335a = true;
    }

    @RequiresApi(api = 21)
    public KSApiWebView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a(an.d(context)), attributeSet, i2, i3);
        this.f33335a = true;
    }

    public KSApiWebView(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(a(an.d(context)), attributeSet, i2, z);
        this.f33335a = true;
    }

    public static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.f33335a) {
            super.destroy();
        }
    }

    public void setEnableDestroy(boolean z) {
        this.f33335a = z;
    }
}
