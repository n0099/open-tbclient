package d.b.h0.g.k0.f.a;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.b.h0.a.h;
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.g.k0.f.a.a;
/* loaded from: classes3.dex */
public class b extends EventTargetImpl implements a.InterfaceC1003a {

    /* renamed from: e  reason: collision with root package name */
    public ApiButton f48967e;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public d.b.h0.g.k0.f.a.a style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton = b.this.f48967e;
            if (apiButton != null) {
                d.b.h0.g.k0.c.d(apiButton);
                b.this.f48967e = null;
            }
        }
    }

    /* renamed from: d.b.h0.g.k0.f.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1004b implements Runnable {
        public RunnableC1004b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton = b.this.f48967e;
            if (apiButton != null) {
                apiButton.o();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton = b.this.f48967e;
            if (apiButton != null) {
                apiButton.w();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48971e;

        public d(String str) {
            this.f48971e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.f45772a) {
                Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + this.f48971e);
            }
            if (b.this.f48967e == null) {
                return;
            }
            String str = this.f48971e;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3556653) {
                if (hashCode == 100313435 && str.equals("image")) {
                    c2 = 1;
                }
            } else if (str.equals("text")) {
                c2 = 0;
            }
            if (c2 == 0) {
                b bVar = b.this;
                bVar.f48967e.setButtonText(bVar.text);
            } else if (c2 != 1) {
            } else {
                b bVar2 = b.this;
                bVar2.f48967e.setImageUrl(bVar2.image);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f48967e == null || bVar.E()) {
                return;
            }
            b.this.f48967e.i();
        }
    }

    public b(JsObject jsObject, d.b.h0.g.i.b bVar) {
        super(bVar);
        this.type = "text";
        this.text = d.b.h0.a.w0.a.c().getString(h.aiapps_aigames_userinfo_button_text_des);
        D(jsObject);
    }

    public boolean B() {
        d.b.h0.g.k0.f.a.a aVar;
        if (this.f48967e == null || (aVar = this.style) == null) {
            return false;
        }
        aVar.b(this);
        d.b.h0.a.e1.d.a.a C = C();
        return C != null && d.b.h0.g.k0.c.a(this.f48967e, C);
    }

    public final d.b.h0.a.e1.d.a.a C() {
        d.b.h0.g.k0.f.a.a aVar = this.style;
        if (aVar == null || this.f48967e == null) {
            return null;
        }
        int f2 = h0.f(aVar.width);
        int f3 = h0.f(this.style.height);
        int f4 = h0.f(this.style.left);
        int f5 = h0.f(this.style.top);
        int f6 = h0.f(this.style.borderWidth) * 2;
        if (f2 < f6) {
            f2 = f6;
        }
        if (f3 < f6) {
            f3 = f6;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48967e.getLayoutParams();
        if (layoutParams != null && layoutParams.width == f2 && layoutParams.height == f3 && layoutParams.leftMargin == f4 && layoutParams.topMargin == f5) {
            return null;
        }
        return new d.b.h0.a.e1.d.a.a(f4, f5, f2, f3);
    }

    public final void D(JsObject jsObject) {
        d.b.h0.g.e.d.c F = d.b.h0.g.e.d.c.F(jsObject);
        if (k.f45772a) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse jsObject = ");
            sb.append(F);
            Log.d("BaseButtonProxy", sb.toString() != null ? F.toString() : null);
        }
        if (F == null) {
            return;
        }
        this.type = F.C("type", this.type);
        this.text = F.C("text", this.text);
        this.image = F.C("image", this.image);
        d.b.h0.g.e.d.c x = F.x("style", null);
        this.style = x == null ? this.style : new d.b.h0.g.k0.f.a.a(x);
    }

    public final boolean E() {
        d.b.h0.a.e1.d.a.a C;
        return (this.f48967e == null || this.style == null || (C = C()) == null || !d.b.h0.g.k0.c.f(this.f48967e, C)) ? false : true;
    }

    @JavascriptInterface
    public void destroy() {
        k0.X(new a());
    }

    @JavascriptInterface
    public void hide() {
        k0.X(new RunnableC1004b());
    }

    @Override // d.b.h0.g.k0.f.a.a.InterfaceC1003a
    public void l() {
        k0.X(new e());
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        k0.X(new d(str));
    }

    @JavascriptInterface
    public void show() {
        k0.X(new c());
    }
}
