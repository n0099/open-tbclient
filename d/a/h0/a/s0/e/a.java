package d.a.h0.a.s0.e;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import d.a.h0.a.s0.e.c;
import d.a.h0.a.s0.e.d.d;
import d.a.h0.a.s0.e.d.e;
/* loaded from: classes2.dex */
public class a extends d.a.h0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f43880h;

    /* renamed from: d.a.h0.a.s0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0751a implements c.f {
        public C0751a() {
        }

        @Override // d.a.h0.a.s0.e.c.f
        public void a() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onCustomKeyboardHide", null);
            }
        }

        @Override // d.a.h0.a.s0.e.c.f
        public void b(int i2) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onCustomKeyboardShow", Integer.valueOf(i2));
            }
        }

        @Override // d.a.h0.a.s0.e.c.f
        public void c(String str) {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "committext", str);
            }
        }

        @Override // d.a.h0.a.s0.e.c.f
        public void d() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "deletebutton", new KeyEvent(0, 67));
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0751a c0751a = new C0751a();
        this.f43880h = c0751a;
        cVar.w0(c0751a);
        this.f43871a.a(new e());
        this.f43871a.a(new d.a.h0.a.s0.e.d.a());
        this.f43871a.a(new d());
        this.f43871a.a(new d.a.h0.a.s0.e.d.c());
        this.f43871a.a(new d.a.h0.a.s0.e.d.b());
    }
}
