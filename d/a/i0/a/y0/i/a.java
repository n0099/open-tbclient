package d.a.i0.a.y0.i;

import androidx.annotation.NonNull;
import d.a.i0.a.y0.i.c;
import d.a.i0.a.y0.i.d.d;
import d.a.i0.a.y0.i.d.e;
/* loaded from: classes.dex */
public final class a extends d.a.i0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45666h;

    /* renamed from: d.a.i0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0904a implements c.f {
        public C0904a() {
        }

        @Override // d.a.i0.a.y0.i.c.f
        public void a() {
            if (a.this.f45598b != null) {
                a.this.f45598b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0904a c0904a = new C0904a();
        this.f45666h = c0904a;
        cVar.H0(c0904a);
        this.f45597a.a(new d());
        this.f45597a.a(new d.a.i0.a.y0.i.d.c());
        this.f45597a.a(new e());
        this.f45597a.a(new d.a.i0.a.y0.i.d.a());
        this.f45597a.a(new d.a.i0.a.y0.i.d.b());
    }
}
