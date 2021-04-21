package d.b.h.b;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* loaded from: classes.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdSailorWebView f43787e;

    public a(BdSailorWebView bdSailorWebView) {
        this.f43787e = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        WebChromeClient.CustomViewCallback customViewCallback;
        int i;
        WebChromeClient.CustomViewCallback customViewCallback2;
        FrameLayout frameLayout3;
        try {
            Context context = this.f43787e.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f43787e.getCurrentWebView() != null) {
                    this.f43787e.getCurrentWebView().setVisibility(0);
                }
                this.f43787e.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.f43787e.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.f43787e.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.f43787e.mFullscreenContainer = null;
                }
                this.f43787e.mCustomView = null;
                customViewCallback = this.f43787e.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.f43787e.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.f43787e.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e2) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e2.printStackTrace();
        }
    }
}
