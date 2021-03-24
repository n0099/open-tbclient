package d.b.h.b;

import com.baidu.browser.sailor.BdSailorWebView;
import com.baidu.browser.sailor.BdSailorWebViewClientExt;
/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ BdSailorWebView f49468e;

    public b(BdSailorWebViewClientExt bdSailorWebViewClientExt, BdSailorWebView bdSailorWebView) {
        this.f49468e = bdSailorWebView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f49468e.showEmbeddedTitleBar(false);
    }
}
