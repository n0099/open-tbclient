package d.b.g0.a.p.d;

import android.view.View;
import android.widget.AbsoluteLayout;
/* loaded from: classes3.dex */
public interface c extends d.b.g0.a.e0.k.a {
    boolean canGoBack();

    View covertToView();

    void destroy();

    int getContentHeight();

    AbsoluteLayout getCurrentWebView();

    float getScale();

    int getWebViewScrollX();

    int getWebViewScrollY();

    void goBack();

    void setDefaultViewSize(int i, int i2, String str);

    void webViewScrollTo(int i, int i2);
}
