package d.b.h0.g.e.e;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import d.b.h0.g.i.b;
import d.b.h0.g.x.c;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;

    /* renamed from: e  reason: collision with root package name */
    public b f48825e;

    /* renamed from: f  reason: collision with root package name */
    public c f48826f;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.f48825e = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f48826f == null) {
            this.f48826f = new c(this.f48825e);
        }
        this.f48826f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f48826f == null) {
            this.f48826f = new c(this.f48825e);
        }
        this.f48826f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f48826f == null) {
            this.f48826f = new c(this.f48825e);
        }
        this.f48826f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f48825e.t() instanceof d.b.h0.g.e.c) {
            ((d.b.h0.g.e.c) this.f48825e.t()).C(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f48826f == null) {
            this.f48826f = new c(this.f48825e);
        }
        this.f48826f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f48826f == null) {
            this.f48826f = new c(this.f48825e);
        }
        this.f48826f.setUserCloudStorage(jsObject);
    }
}
