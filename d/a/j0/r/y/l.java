package d.a.j0.r.y;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f50312a;

    /* renamed from: b  reason: collision with root package name */
    public final b f50313b;

    public l(WebView webView, b bVar) {
        this.f50312a = webView;
        this.f50313b = bVar;
    }

    public abstract void c(m mVar);

    public final void d(n nVar) {
        e(nVar.g(), nVar);
    }

    public abstract void e(String str, d dVar);

    public final Context f() {
        return this.f50312a.getContext();
    }
}
