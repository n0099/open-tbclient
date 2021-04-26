package d.a.h0.a.p.d;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import d.a.h0.a.p.d.c;
/* loaded from: classes2.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    @UiThread
    void N();

    void S(d.a.h0.a.e0.n.c cVar);

    String a0();

    String b();

    String c();

    void d(d.a.h0.a.e0.g gVar);

    void d0();

    void destroy();

    void e(Activity activity);

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void q();

    T s();

    void t(d.a.h0.a.e0.n.c cVar);
}
