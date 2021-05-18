package d.a.i0.h.d.d;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.a.i0.a.l0.c;
import d.a.i0.h.d.b;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f47102e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.h.z.c f47103f;

    public a(c cVar) {
        super(cVar);
        this.domain = "openData";
        this.f47102e = cVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f47103f == null) {
            this.f47103f = new d.a.i0.h.z.c(this.f47102e);
        }
        this.f47103f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f47103f == null) {
            this.f47103f = new d.a.i0.h.z.c(this.f47102e);
        }
        this.f47103f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f47103f == null) {
            this.f47103f = new d.a.i0.h.z.c(this.f47102e);
        }
        this.f47103f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f47102e.p() instanceof b) {
            ((b) this.f47102e.p()).B(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f47103f == null) {
            this.f47103f = new d.a.i0.h.z.c(this.f47102e);
        }
        this.f47103f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f47103f == null) {
            this.f47103f = new d.a.i0.h.z.c(this.f47102e);
        }
        this.f47103f.setUserCloudStorage(jsObject);
    }
}
