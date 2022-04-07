package com.kwad.sdk.core.page.widget.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.utils.bb;
/* loaded from: classes5.dex */
public class a extends ApiWebView {
    public boolean a;

    public a(Context context) {
        super(a(bb.d(context)));
        this.a = true;
    }

    public a(Context context, AttributeSet attributeSet) {
        super(a(bb.d(context)), attributeSet);
        this.a = true;
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(a(bb.d(context)), attributeSet, i);
        this.a = true;
    }

    @RequiresApi(api = 21)
    public a(Context context, AttributeSet attributeSet, int i, int i2) {
        super(a(bb.d(context)), attributeSet, i, i2);
        this.a = true;
    }

    public a(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(a(bb.d(context)), attributeSet, i, z);
        this.a = true;
    }

    public static Context a(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 21 || i >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public void a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        removeAllViews();
        destroy();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.a) {
            super.destroy();
        }
    }

    public void setEnableDestroy(boolean z) {
        this.a = z;
    }
}
