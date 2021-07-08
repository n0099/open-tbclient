package d.a.n0.a.p.e;

import android.app.Activity;
import androidx.annotation.UiThread;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import d.a.n0.a.p.e.c;
/* loaded from: classes7.dex */
public interface d<T extends c> extends TypedCallbackHandler {
    @UiThread
    void P();

    void V(d.a.n0.a.h0.j.c cVar);

    String a();

    String b();

    void c(d.a.n0.a.h0.b bVar);

    String c0();

    void destroy();

    void e(Activity activity);

    void f0();

    void loadUrl(String str);

    void onJSLoaded();

    void onPause();

    void onResume();

    @UiThread
    void s();

    T u();

    void v(d.a.n0.a.h0.j.c cVar);
}
