package d.a.h0.a.e0.k;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
/* loaded from: classes2.dex */
public interface a {
    void addJavascriptInterface(@NonNull Object obj, @NonNull String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    String getContainerId();

    boolean isDestroyed();

    boolean isWebView();

    void onJSLoaded();
}
