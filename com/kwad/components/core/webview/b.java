package com.kwad.components.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.m.p;
import com.kwad.sdk.api.core.ApiWebView;
import com.kwad.sdk.api.loader.Wrapper;
/* loaded from: classes10.dex */
public class b extends ApiWebView {
    public boolean KH;
    public com.kwad.components.core.webview.kwai.a KI;

    public b(Context context) {
        super(aw(Wrapper.unwrapContextIfNeed(context)));
        this.KH = true;
        init();
    }

    public b(Context context, AttributeSet attributeSet) {
        super(aw(Wrapper.unwrapContextIfNeed(context)), attributeSet);
        this.KH = true;
        init();
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(aw(Wrapper.unwrapContextIfNeed(context)), attributeSet, i);
        this.KH = true;
        init();
    }

    @RequiresApi(api = 21)
    public b(Context context, AttributeSet attributeSet, int i, int i2) {
        super(aw(Wrapper.unwrapContextIfNeed(context)), attributeSet, i, i2);
        this.KH = true;
        init();
    }

    public b(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(aw(Wrapper.unwrapContextIfNeed(context)), attributeSet, i, z);
        this.KH = true;
        init();
    }

    public static Context aw(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 21 || i >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    private void init() {
        p.b(this);
        com.kwad.components.core.webview.kwai.a aVar = new com.kwad.components.core.webview.kwai.a();
        this.KI = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.KH) {
            super.destroy();
        }
    }

    public final void release() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this);
        }
        removeAllViews();
        destroy();
    }

    public void setEnableDestroy(boolean z) {
        this.KH = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.KI.setNeedHybridLoad(z);
    }
}
