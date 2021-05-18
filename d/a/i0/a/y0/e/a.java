package d.a.i0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import d.a.i0.a.y0.e.c;
import d.a.i0.a.y0.e.d.d;
import d.a.i0.a.y0.e.d.e;
/* loaded from: classes.dex */
public class a extends d.a.i0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45606h;

    /* renamed from: d.a.i0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0896a implements c.f {
        public C0896a() {
        }

        @Override // d.a.i0.a.y0.e.c.f
        public void a() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onCustomKeyboardHide", null);
            }
        }

        @Override // d.a.i0.a.y0.e.c.f
        public void b(int i2) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i2));
            }
        }

        @Override // d.a.i0.a.y0.e.c.f
        public void c(String str) {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "committext", str);
            }
        }

        @Override // d.a.i0.a.y0.e.c.f
        public void d() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0896a c0896a = new C0896a();
        this.f45606h = c0896a;
        cVar.G0(c0896a);
        this.f45597a.a(new e());
        this.f45597a.a(new d.a.i0.a.y0.e.d.a());
        this.f45597a.a(new d());
        this.f45597a.a(new d.a.i0.a.y0.e.d.c());
        this.f45597a.a(new d.a.i0.a.y0.e.d.b());
    }
}
