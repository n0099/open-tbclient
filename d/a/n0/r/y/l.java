package d.a.n0.r.y;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f54159a;

    /* renamed from: b  reason: collision with root package name */
    public final b f54160b;

    public l(WebView webView, b bVar) {
        this.f54159a = webView;
        this.f54160b = bVar;
    }

    public abstract void c(m mVar);

    public final void d(n nVar) {
        e(nVar.g(), nVar);
    }

    public abstract void e(String str, d dVar);

    public final Context f() {
        return this.f54159a.getContext();
    }
}
