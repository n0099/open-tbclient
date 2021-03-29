package d.b.g0.g.i.l;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48189a;

    public a(V8Engine v8Engine) {
        this.f48189a = v8Engine;
    }

    public void a(@NonNull Object obj, @NonNull String str) {
        this.f48189a.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback<String> valueCallback) {
        this.f48189a.evaluateJavascript(str, valueCallback, "mainContextEvaluate");
    }

    public void c(String str, String str2) {
        this.f48189a.requireJSFile(str, str2);
    }

    public void d(JSExceptionType jSExceptionType, String str) {
        this.f48189a.throwJSException(jSExceptionType, str);
    }
}
