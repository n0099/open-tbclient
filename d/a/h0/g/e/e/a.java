package d.a.h0.g.e.e;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.a.h0.g.i.b;
import d.a.h0.g.x.c;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public b f46296e;

    /* renamed from: f  reason: collision with root package name */
    public c f46297f;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.f46296e = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f46297f == null) {
            this.f46297f = new c(this.f46296e);
        }
        this.f46297f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f46297f == null) {
            this.f46297f = new c(this.f46296e);
        }
        this.f46297f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f46297f == null) {
            this.f46297f = new c(this.f46296e);
        }
        this.f46297f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f46296e.o() instanceof d.a.h0.g.e.c) {
            ((d.a.h0.g.e.c) this.f46296e.o()).C(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f46297f == null) {
            this.f46297f = new c(this.f46296e);
        }
        this.f46297f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f46297f == null) {
            this.f46297f = new c(this.f46296e);
        }
        this.f46297f.setUserCloudStorage(jsObject);
    }
}
