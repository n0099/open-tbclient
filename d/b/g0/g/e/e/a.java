package d.b.g0.g.e.e;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.b.g0.g.i.b;
import d.b.g0.g.x.c;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public b f48103e;

    /* renamed from: f  reason: collision with root package name */
    public c f48104f;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.f48103e = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f48104f == null) {
            this.f48104f = new c(this.f48103e);
        }
        this.f48104f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f48104f == null) {
            this.f48104f = new c(this.f48103e);
        }
        this.f48104f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f48104f == null) {
            this.f48104f = new c(this.f48103e);
        }
        this.f48104f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f48103e.t() instanceof d.b.g0.g.e.c) {
            ((d.b.g0.g.e.c) this.f48103e.t()).C(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f48104f == null) {
            this.f48104f = new c(this.f48103e);
        }
        this.f48104f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f48104f == null) {
            this.f48104f = new c(this.f48103e);
        }
        this.f48104f.setUserCloudStorage(jsObject);
    }
}
