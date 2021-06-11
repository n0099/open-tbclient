package d.a.l0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import d.a.l0.a.y0.e.c;
import d.a.l0.a.y0.e.d.d;
import d.a.l0.a.y0.e.d.e;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f49456h;

    /* renamed from: d.a.l0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0963a implements c.f {
        public C0963a() {
        }

        @Override // d.a.l0.a.y0.e.c.f
        public void a() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onCustomKeyboardHide", null);
            }
        }

        @Override // d.a.l0.a.y0.e.c.f
        public void b(int i2) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i2));
            }
        }

        @Override // d.a.l0.a.y0.e.c.f
        public void c(String str) {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "committext", str);
            }
        }

        @Override // d.a.l0.a.y0.e.c.f
        public void d() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0963a c0963a = new C0963a();
        this.f49456h = c0963a;
        cVar.D0(c0963a);
        this.f49447a.a(new e());
        this.f49447a.a(new d.a.l0.a.y0.e.d.a());
        this.f49447a.a(new d());
        this.f49447a.a(new d.a.l0.a.y0.e.d.c());
        this.f49447a.a(new d.a.l0.a.y0.e.d.b());
    }
}
