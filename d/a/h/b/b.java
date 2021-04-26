package d.a.h.b;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdSailorWebView f41045e;

    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.f41045e = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f41045e.showEmbeddedTitleBar(false);
    }
}
