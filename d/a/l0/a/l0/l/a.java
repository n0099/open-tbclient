package d.a.l0.a.l0.l;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f43321a;

    public a(V8Engine v8Engine) {
        this.f43321a = v8Engine;
    }

    public void a(@NonNull Object obj, @NonNull String str) {
        this.f43321a.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback<String> valueCallback) {
        this.f43321a.evaluateJavascript(str, valueCallback, "mainContextEvaluate");
    }

    public void c(String str, String str2) {
        this.f43321a.requireJSFile(str, str2);
    }

    public void d(JSExceptionType jSExceptionType, String str) {
        this.f43321a.throwJSException(jSExceptionType, str);
    }
}
