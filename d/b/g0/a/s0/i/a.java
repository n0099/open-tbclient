package d.b.g0.a.s0.i;

import androidx.annotation.NonNull;
import d.b.g0.a.s0.i.c;
import d.b.g0.a.s0.i.d.d;
import d.b.g0.a.s0.i.d.e;
/* loaded from: classes3.dex */
public final class a extends d.b.g0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45851h;

    /* renamed from: d.b.g0.a.s0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0787a implements c.f {
        public C0787a() {
        }

        @Override // d.b.g0.a.s0.i.c.f
        public void a() {
            if (a.this.f45785b != null) {
                a.this.f45785b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0787a c0787a = new C0787a();
        this.f45851h = c0787a;
        cVar.w0(c0787a);
        this.f45784a.a(new d());
        this.f45784a.a(new d.b.g0.a.s0.i.d.c());
        this.f45784a.a(new e());
        this.f45784a.a(new d.b.g0.a.s0.i.d.a());
        this.f45784a.a(new d.b.g0.a.s0.i.d.b());
    }
}
