package d.a.m0.h.d.d;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.a.m0.a.l0.c;
import d.a.m0.h.d.b;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public c f51060e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.h.z.c f51061f;

    public a(c cVar) {
        super(cVar);
        this.domain = "openData";
        this.f51060e = cVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f51061f == null) {
            this.f51061f = new d.a.m0.h.z.c(this.f51060e);
        }
        this.f51061f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f51061f == null) {
            this.f51061f = new d.a.m0.h.z.c(this.f51060e);
        }
        this.f51061f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f51061f == null) {
            this.f51061f = new d.a.m0.h.z.c(this.f51060e);
        }
        this.f51061f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f51060e.p() instanceof b) {
            ((b) this.f51060e.p()).B(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f51061f == null) {
            this.f51061f = new d.a.m0.h.z.c(this.f51060e);
        }
        this.f51061f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f51061f == null) {
            this.f51061f = new d.a.m0.h.z.c(this.f51060e);
        }
        this.f51061f.setUserCloudStorage(jsObject);
    }
}
