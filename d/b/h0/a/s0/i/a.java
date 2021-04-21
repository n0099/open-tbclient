package d.b.h0.a.s0.i;

import androidx.annotation.NonNull;
import d.b.h0.a.s0.i.c;
import d.b.h0.a.s0.i.d.d;
import d.b.h0.a.s0.i.d.e;
/* loaded from: classes2.dex */
public final class a extends d.b.h0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f46573h;

    /* renamed from: d.b.h0.a.s0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0820a implements c.f {
        public C0820a() {
        }

        @Override // d.b.h0.a.s0.i.c.f
        public void a() {
            if (a.this.f46507b != null) {
                a.this.f46507b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0820a c0820a = new C0820a();
        this.f46573h = c0820a;
        cVar.w0(c0820a);
        this.f46506a.a(new d());
        this.f46506a.a(new d.b.h0.a.s0.i.d.c());
        this.f46506a.a(new e());
        this.f46506a.a(new d.b.h0.a.s0.i.d.a());
        this.f46506a.a(new d.b.h0.a.s0.i.d.b());
    }
}
