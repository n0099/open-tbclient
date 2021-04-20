package d.b.h0.r.y;

import android.content.Context;
import android.webkit.WebView;
/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f51508a;

    /* renamed from: b  reason: collision with root package name */
    public final b f51509b;

    public l(WebView webView, b bVar) {
        this.f51508a = webView;
        this.f51509b = bVar;
    }

    public abstract void c(m mVar);

    public final void d(n nVar) {
        e(nVar.g(), nVar);
    }

    public abstract void e(String str, d dVar);

    public final Context f() {
        return this.f51508a.getContext();
    }
}
