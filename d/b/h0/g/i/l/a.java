package d.b.h0.g.i.l;

import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public V8Engine f48910a;

    public a(V8Engine v8Engine) {
        this.f48910a = v8Engine;
    }

    public void a(@NonNull Object obj, @NonNull String str) {
        this.f48910a.addJavascriptInterface(obj, str);
    }

    public void b(String str, ValueCallback<String> valueCallback) {
        this.f48910a.evaluateJavascript(str, valueCallback, "mainContextEvaluate");
    }

    public void c(String str, String str2) {
        this.f48910a.requireJSFile(str, str2);
    }

    public void d(JSExceptionType jSExceptionType, String str) {
        this.f48910a.throwJSException(jSExceptionType, str);
    }
}
