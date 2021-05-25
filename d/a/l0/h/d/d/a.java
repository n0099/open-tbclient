package d.a.l0.h.d.d;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.a.l0.a.l0.c;
import d.a.l0.h.d.b;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f47278e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.h.z.c f47279f;

    public a(c cVar) {
        super(cVar);
        this.domain = "openData";
        this.f47278e = cVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f47279f == null) {
            this.f47279f = new d.a.l0.h.z.c(this.f47278e);
        }
        this.f47279f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f47279f == null) {
            this.f47279f = new d.a.l0.h.z.c(this.f47278e);
        }
        this.f47279f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f47279f == null) {
            this.f47279f = new d.a.l0.h.z.c(this.f47278e);
        }
        this.f47279f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f47278e.p() instanceof b) {
            ((b) this.f47278e.p()).B(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f47279f == null) {
            this.f47279f = new d.a.l0.h.z.c(this.f47278e);
        }
        this.f47279f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f47279f == null) {
            this.f47279f = new d.a.l0.h.z.c(this.f47278e);
        }
        this.f47279f.setUserCloudStorage(jsObject);
    }
}
