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
    public b f48104e;

    /* renamed from: f  reason: collision with root package name */
    public c f48105f;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.f48104e = bVar;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.f48105f == null) {
            this.f48105f = new c(this.f48104e);
        }
        this.f48105f.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.f48105f == null) {
            this.f48105f = new c(this.f48104e);
        }
        this.f48105f.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.f48105f == null) {
            this.f48105f = new c(this.f48104e);
        }
        this.f48105f.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.f48104e.t() instanceof d.b.g0.g.e.c) {
            ((d.b.g0.g.e.c) this.f48104e.t()).C(jsObject);
        }
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.f48105f == null) {
            this.f48105f = new c(this.f48104e);
        }
        this.f48105f.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.f48105f == null) {
            this.f48105f = new c(this.f48104e);
        }
        this.f48105f.setUserCloudStorage(jsObject);
    }
}
