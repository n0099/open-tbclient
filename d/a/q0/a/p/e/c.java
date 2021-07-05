package d.a.q0.a.p.e;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes8.dex */
public interface c extends d.a.q0.a.h0.f.a {
    boolean canGoBack();

    View covertToView();

    void destroy();

    int getContentHeight();

    AbsoluteLayout getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i2, int i3, String str);

    void webViewScrollTo(int i2, int i3);
}
