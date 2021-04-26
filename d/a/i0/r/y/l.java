package d.a.i0.r.y;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f49493a;

    /* renamed from: b  reason: collision with root package name */
    public final b f49494b;

    public l(WebView webView, b bVar) {
        this.f49493a = webView;
        this.f49494b = bVar;
    }

    public abstract void c(m mVar);

    public final void d(n nVar) {
        e(nVar.g(), nVar);
    }

    public abstract void e(String str, d dVar);

    public final Context f() {
        return this.f49493a.getContext();
    }
}
