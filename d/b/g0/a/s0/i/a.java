package d.b.g0.a.s0.i;

import androidx.annotation.NonNull;
import d.b.g0.a.s0.i.c;
import d.b.g0.a.s0.i.d.d;
import d.b.g0.a.s0.i.d.e;
/* loaded from: classes2.dex */
public final class a extends d.b.g0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f46244h;

    /* renamed from: d.b.g0.a.s0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0800a implements c.f {
        public C0800a() {
        }

        @Override // d.b.g0.a.s0.i.c.f
        public void a() {
            if (a.this.f46178b != null) {
                a.this.f46178b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0800a c0800a = new C0800a();
        this.f46244h = c0800a;
        cVar.w0(c0800a);
        this.f46177a.a(new d());
        this.f46177a.a(new d.b.g0.a.s0.i.d.c());
        this.f46177a.a(new e());
        this.f46177a.a(new d.b.g0.a.s0.i.d.a());
        this.f46177a.a(new d.b.g0.a.s0.i.d.b());
    }
}
