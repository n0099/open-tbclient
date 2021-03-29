package d.b.g0.a.s0.i;

import androidx.annotation.NonNull;
import d.b.g0.a.s0.i.c;
import d.b.g0.a.s0.i.d.d;
import d.b.g0.a.s0.i.d.e;
/* loaded from: classes2.dex */
public final class a extends d.b.g0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45852h;

    /* renamed from: d.b.g0.a.s0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0788a implements c.f {
        public C0788a() {
        }

        @Override // d.b.g0.a.s0.i.c.f
        public void a() {
            if (a.this.f45786b != null) {
                a.this.f45786b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0788a c0788a = new C0788a();
        this.f45852h = c0788a;
        cVar.w0(c0788a);
        this.f45785a.a(new d());
        this.f45785a.a(new d.b.g0.a.s0.i.d.c());
        this.f45785a.a(new e());
        this.f45785a.a(new d.b.g0.a.s0.i.d.a());
        this.f45785a.a(new d.b.g0.a.s0.i.d.b());
    }
}
