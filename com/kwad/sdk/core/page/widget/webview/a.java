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
/* loaded from: classes3.dex */
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

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(a(bb.d(context)), attributeSet, i2);
        this.a = true;
    }

    @RequiresApi(api = 21)
    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(a(bb.d(context)), attributeSet, i2, i3);
        this.a = true;
    }

    public a(Context context, AttributeSet attributeSet, int i2, boolean z) {
        super(a(bb.d(context)), attributeSet, i2, z);
        this.a = true;
    }

    public static Context a(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 21 || i2 >= 23) ? context : context.createConfigurationContext(new Configuration());
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
