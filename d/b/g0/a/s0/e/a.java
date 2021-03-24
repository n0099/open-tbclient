package d.b.g0.a.s0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import d.b.g0.a.s0.e.c;
import d.b.g0.a.s0.e.d.d;
import d.b.g0.a.s0.e.d.e;
/* loaded from: classes3.dex */
public class a extends d.b.g0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45793h;

    /* renamed from: d.b.g0.a.s0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0779a implements c.f {
        public C0779a() {
        }

        @Override // d.b.g0.a.s0.e.c.f
        public void a() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onCustomKeyboardHide", null);
            }
        }

        @Override // d.b.g0.a.s0.e.c.f
        public void b(int i) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i));
            }
        }

        @Override // d.b.g0.a.s0.e.c.f
        public void c(String str) {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "committext", str);
            }
        }

        @Override // d.b.g0.a.s0.e.c.f
        public void d() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0779a c0779a = new C0779a();
        this.f45793h = c0779a;
        cVar.v0(c0779a);
        this.f45784a.a(new e());
        this.f45784a.a(new d.b.g0.a.s0.e.d.a());
        this.f45784a.a(new d());
        this.f45784a.a(new d.b.g0.a.s0.e.d.c());
        this.f45784a.a(new d.b.g0.a.s0.e.d.b());
    }
}
