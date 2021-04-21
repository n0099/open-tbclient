package d.b.h0.g.k0.f.b;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import d.b.h0.a.i2.k0;
import d.b.h0.g.c0.d;
/* loaded from: classes3.dex */
public class b extends d.b.h0.g.k0.f.a.b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.b.h0.g.k0.c.b() == null) {
                return;
            }
            b.this.f48967e = new UserInfoButton(d.b.h0.g.k0.c.b(), b.this);
            b.this.f48967e.setType(b.this.type);
            b.this.f48967e.setButtonText(b.this.text);
            b.this.f48967e.setImageUrl(b.this.image);
            b.this.f48967e.setApiButtonStyle(b.this.style);
            b.this.B();
            b.this.M();
        }
    }

    public b(JsObject jsObject, d.b.h0.g.i.b bVar) {
        super(jsObject, bVar);
        k0.X(new a());
    }

    public final void M() {
        if (d.d()) {
            return;
        }
        d.b.h0.g.c0.c.l("Button shows early.");
    }
}
