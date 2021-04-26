package d.a.h0.g.k0.f.b;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import d.a.h0.a.i2.k0;
import d.a.h0.g.c0.d;
/* loaded from: classes3.dex */
public class b extends d.a.h0.g.k0.f.a.b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.h0.g.k0.c.b() == null) {
                return;
            }
            b.this.f46442e = new UserInfoButton(d.a.h0.g.k0.c.b(), b.this);
            b.this.f46442e.setType(b.this.type);
            b.this.f46442e.setButtonText(b.this.text);
            b.this.f46442e.setImageUrl(b.this.image);
            b.this.f46442e.setApiButtonStyle(b.this.style);
            b.this.B();
            b.this.M();
        }
    }

    public b(JsObject jsObject, d.a.h0.g.i.b bVar) {
        super(jsObject, bVar);
        k0.X(new a());
    }

    public final void M() {
        if (d.d()) {
            return;
        }
        d.a.h0.g.c0.c.l("Button shows early.");
    }
}
