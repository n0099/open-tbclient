package d.a.m0.h.o0.d.b;

import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.games.view.button.userinfo.UserInfoButton;
import d.a.m0.a.v2.q0;
import d.a.m0.h.f0.e;
import d.a.m0.h.f0.h;
/* loaded from: classes3.dex */
public class b extends d.a.m0.h.o0.d.a.b {

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.a.m0.h.o0.b.b() == null) {
                return;
            }
            b.this.f51330e = new UserInfoButton(d.a.m0.h.o0.b.b(), b.this);
            b.this.f51330e.setType(b.this.type);
            b.this.f51330e.setButtonText(b.this.text);
            b.this.f51330e.setImageUrl(b.this.image);
            b.this.f51330e.setApiButtonStyle(b.this.style);
            b.this.A();
            b.this.L();
        }
    }

    public b(JsObject jsObject, d.a.m0.a.l0.c cVar) {
        super(jsObject, cVar);
        q0.b0(new a());
    }

    public final void L() {
        if (h.d()) {
            return;
        }
        e.l("Button shows early.");
    }
}
