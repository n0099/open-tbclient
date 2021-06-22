package d.a.m0.a.y0.i;

import androidx.annotation.NonNull;
import d.a.m0.a.y0.i.c;
import d.a.m0.a.y0.i.d.d;
import d.a.m0.a.y0.i.d.e;
/* loaded from: classes3.dex */
public final class a extends d.a.m0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f49624h;

    /* renamed from: d.a.m0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0974a implements c.f {
        public C0974a() {
        }

        @Override // d.a.m0.a.y0.i.c.f
        public void a() {
            if (a.this.f49556b != null) {
                a.this.f49556b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0974a c0974a = new C0974a();
        this.f49624h = c0974a;
        cVar.E0(c0974a);
        this.f49555a.a(new d());
        this.f49555a.a(new d.a.m0.a.y0.i.d.c());
        this.f49555a.a(new e());
        this.f49555a.a(new d.a.m0.a.y0.i.d.a());
        this.f49555a.a(new d.a.m0.a.y0.i.d.b());
    }
}
