package d.a.h0.a.p.d;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes2.dex */
public interface c extends d.a.h0.a.e0.k.a {
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
