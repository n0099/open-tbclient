package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.m.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;
/* loaded from: classes10.dex */
public class c extends WebView {
    public boolean aCL;
    public com.kwad.sdk.core.webview.a.a aCM;

    public c(Context context) {
        super(bn(context));
        this.aCL = true;
        init();
    }

    public void setEnableDestroy(boolean z) {
        this.aCL = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.aCM.setNeedHybridLoad(z);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bn(context), attributeSet);
        this.aCL = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(bn(context), attributeSet, i);
        this.aCL = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(bn(context), attributeSet, i, i2);
        this.aCL = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(bn(context), attributeSet, i, z);
        this.aCL = true;
        init();
    }

    public static Context bn(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dq = l.dq(context);
        if (!l.dt(dq)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dq.getClass().getName() + "--classloader:" + dq.getClass().getClassLoader() + "--context2:" + l.dq(ServiceProvider.Jn()).getClass().getName()));
            return l.dq(ServiceProvider.Jn());
        }
        return dq;
    }

    private void init() {
        bs.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aCM = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aCL) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }
}
