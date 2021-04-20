package d.b.g0.g.x;

import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public c f49063a;

    public d(@NonNull d.b.g0.g.i.a aVar) {
        this.f49063a = new c(aVar);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        this.f49063a.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        this.f49063a.setUserCloudStorage(jsObject);
    }
}
