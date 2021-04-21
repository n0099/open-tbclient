package d.b.h.b;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdSailorWebView f43788e;

    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.f43788e = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f43788e.showEmbeddedTitleBar(false);
    }
}
