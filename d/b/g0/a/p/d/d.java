package d.b.g0.a.p.d;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import d.b.g0.a.p.d.c;
/* loaded from: classes3.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    @UiThread
    void A();

    @UiThread
    void C();

    void F(d.b.g0.a.e0.n.c cVar);

    void H(d.b.g0.a.e0.n.c cVar);

    String S();

    void W();

    String b();

    String c();

    void d(Activity activity);

    void destroy();

    void e(d.b.g0.a.e0.g gVar);

    T getWebView();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();
}
