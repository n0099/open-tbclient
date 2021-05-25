package d.a.l0.h.o0.d.a;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import d.a.l0.a.k;
import d.a.l0.a.v2.n0;
import d.a.l0.a.v2.q0;
import d.a.l0.f.g;
import d.a.l0.h.o0.d.a.a;
/* loaded from: classes3.dex */
public class b extends EventTargetImpl implements a.InterfaceC1038a {

    /* renamed from: e  reason: collision with root package name */
    public ApiButton f47548e;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public d.a.l0.h.o0.d.a.a style;
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
            ApiButton apiButton = b.this.f47548e;
            if (apiButton != null) {
                d.a.l0.h.o0.b.d(apiButton);
                b.this.f47548e = null;
            }
        }
    }

    /* renamed from: d.a.l0.h.o0.d.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1039b implements Runnable {
        public RunnableC1039b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton = b.this.f47548e;
            if (apiButton != null) {
                apiButton.hide();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton = b.this.f47548e;
            if (apiButton != null) {
                apiButton.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47552e;

        public d(String str) {
            this.f47552e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (k.f43199a) {
                Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + this.f47552e);
            }
            if (b.this.f47548e == null) {
                return;
            }
            String str = this.f47552e;
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
                bVar.f47548e.setButtonText(bVar.text);
            } else if (c2 != 1) {
            } else {
                b bVar2 = b.this;
                bVar2.f47548e.setImageUrl(bVar2.image);
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
            if (bVar.f47548e == null || bVar.D()) {
                return;
            }
            b.this.f47548e.h();
        }
    }

    public b(JsObject jsObject, d.a.l0.a.l0.c cVar) {
        super(cVar);
        this.type = "text";
        this.text = d.a.l0.a.c1.a.b().getString(g.aiapps_aigames_userinfo_button_text_des);
        C(jsObject);
    }

    public boolean A() {
        d.a.l0.h.o0.d.a.a aVar;
        if (this.f47548e == null || (aVar = this.style) == null) {
            return false;
        }
        aVar.b(this);
        d.a.l0.a.l1.e.a.a B = B();
        return B != null && d.a.l0.h.o0.b.a(this.f47548e, B);
    }

    public final d.a.l0.a.l1.e.a.a B() {
        d.a.l0.h.o0.d.a.a aVar = this.style;
        if (aVar == null || this.f47548e == null) {
            return null;
        }
        int g2 = n0.g(aVar.width);
        int g3 = n0.g(this.style.height);
        int g4 = n0.g(this.style.left);
        int g5 = n0.g(this.style.top);
        int g6 = n0.g(this.style.borderWidth) * 2;
        if (g2 < g6) {
            g2 = g6;
        }
        if (g3 < g6) {
            g3 = g6;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f47548e.getLayoutParams();
        if (layoutParams != null && layoutParams.width == g2 && layoutParams.height == g3 && layoutParams.leftMargin == g4 && layoutParams.topMargin == g5) {
            return null;
        }
        return new d.a.l0.a.l1.e.a.a(g4, g5, g2, g3);
    }

    public final void C(JsObject jsObject) {
        d.a.l0.a.y.b.a G = d.a.l0.a.y.b.a.G(jsObject);
        if (k.f43199a) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse jsObject = ");
            sb.append(G);
            Log.d("BaseButtonProxy", sb.toString() != null ? G.toString() : null);
        }
        if (G == null) {
            return;
        }
        this.type = G.D("type", this.type);
        this.text = G.D("text", this.text);
        this.image = G.D("image", this.image);
        d.a.l0.a.y.b.a y = G.y("style", null);
        this.style = y == null ? this.style : new d.a.l0.h.o0.d.a.a(y);
    }

    public final boolean D() {
        d.a.l0.a.l1.e.a.a B;
        return (this.f47548e == null || this.style == null || (B = B()) == null || !d.a.l0.h.o0.b.f(this.f47548e, B)) ? false : true;
    }

    @JavascriptInterface
    public void destroy() {
        q0.b0(new a());
    }

    @JavascriptInterface
    public void hide() {
        q0.b0(new RunnableC1039b());
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        q0.b0(new d(str));
    }

    @Override // d.a.l0.h.o0.d.a.a.InterfaceC1038a
    public void s() {
        q0.b0(new e());
    }

    @JavascriptInterface
    public void show() {
        q0.b0(new c());
    }
}
