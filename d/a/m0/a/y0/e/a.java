package d.a.m0.a.y0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import d.a.m0.a.y0.e.c;
import d.a.m0.a.y0.e.d.d;
import d.a.m0.a.y0.e.d.e;
/* loaded from: classes3.dex */
public class a extends d.a.m0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f49564h;

    /* renamed from: d.a.m0.a.y0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0966a implements c.f {
        public C0966a() {
        }

        @Override // d.a.m0.a.y0.e.c.f
        public void a() {
            if (a.this.f49556b != null) {
                a.this.f49556b.onCallback(a.this, "onCustomKeyboardHide", null);
            }
        }

        @Override // d.a.m0.a.y0.e.c.f
        public void b(int i2) {
            if (a.this.f49556b != null) {
                a.this.f49556b.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i2));
            }
        }

        @Override // d.a.m0.a.y0.e.c.f
        public void c(String str) {
            if (a.this.f49556b != null) {
                a.this.f49556b.onCallback(a.this, "committext", str);
            }
        }

        @Override // d.a.m0.a.y0.e.c.f
        public void d() {
            if (a.this.f49556b != null) {
                a.this.f49556b.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0966a c0966a = new C0966a();
        this.f49564h = c0966a;
        cVar.D0(c0966a);
        this.f49555a.a(new e());
        this.f49555a.a(new d.a.m0.a.y0.e.d.a());
        this.f49555a.a(new d());
        this.f49555a.a(new d.a.m0.a.y0.e.d.c());
        this.f49555a.a(new d.a.m0.a.y0.e.d.b());
    }
}
