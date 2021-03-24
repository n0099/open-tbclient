package d.b.h.b;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.widget.FrameLayout;
import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdSailorWebView f49467e;

    public a(BdSailorWebView bdSailorWebView) {
        this.f49467e = bdSailorWebView;
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
            Context context = this.f49467e.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                if (this.f49467e.getCurrentWebView() != null) {
                    this.f49467e.getCurrentWebView().setVisibility(0);
                }
                this.f49467e.setFullscreen(activity, false);
                Window window = activity.getWindow();
                if (window == null || (frameLayout = (FrameLayout) window.getDecorView()) == null) {
                    return;
                }
                frameLayout2 = this.f49467e.mFullscreenContainer;
                if (frameLayout2 != null) {
                    frameLayout3 = this.f49467e.mFullscreenContainer;
                    frameLayout.removeView(frameLayout3);
                    this.f49467e.mFullscreenContainer = null;
                }
                this.f49467e.mCustomView = null;
                customViewCallback = this.f49467e.mCustomViewCallback;
                if (customViewCallback != null) {
                    customViewCallback2 = this.f49467e.mCustomViewCallback;
                    customViewCallback2.onCustomViewHidden();
                }
                i = this.f49467e.mOriginalOrientation;
                activity.setRequestedOrientation(i);
            }
        } catch (Exception e2) {
            str = BdSailorWebView.LOG_TAG;
            Log.e(str, "Exception happened when hide custom view");
            e2.printStackTrace();
        }
    }
}
