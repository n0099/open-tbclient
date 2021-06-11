package d.a.l0.a.y0.i;

import androidx.annotation.NonNull;
import d.a.l0.a.y0.i.c;
import d.a.l0.a.y0.i.d.d;
import d.a.l0.a.y0.i.d.e;
/* loaded from: classes3.dex */
public final class a extends d.a.l0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f49516h;

    /* renamed from: d.a.l0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0971a implements c.f {
        public C0971a() {
        }

        @Override // d.a.l0.a.y0.i.c.f
        public void a() {
            if (a.this.f49448b != null) {
                a.this.f49448b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0971a c0971a = new C0971a();
        this.f49516h = c0971a;
        cVar.E0(c0971a);
        this.f49447a.a(new d());
        this.f49447a.a(new d.a.l0.a.y0.i.d.c());
        this.f49447a.a(new e());
        this.f49447a.a(new d.a.l0.a.y0.i.d.a());
        this.f49447a.a(new d.a.l0.a.y0.i.d.b());
    }
}
