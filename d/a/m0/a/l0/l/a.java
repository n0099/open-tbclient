package d.a.m0.a.l0.l;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f47105a;

    public a(V8Engine v8Engine) {
        this.f47105a = v8Engine;
    }

    public void a(@NonNull Object obj, @NonNull String str) {
        this.f47105a.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback<String> valueCallback) {
        this.f47105a.evaluateJavascript(str, valueCallback, "mainContextEvaluate");
    }

    public void c(String str, String str2) {
        this.f47105a.requireJSFile(str, str2);
    }

    public void d(JSExceptionType jSExceptionType, String str) {
        this.f47105a.throwJSException(jSExceptionType, str);
    }
}
