package d.a.l0.a.y0.i;

import androidx.annotation.NonNull;
import d.a.l0.a.y0.i.c;
import d.a.l0.a.y0.i.d.d;
import d.a.l0.a.y0.i.d.e;
/* loaded from: classes3.dex */
public final class a extends d.a.l0.a.y0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f45842h;

    /* renamed from: d.a.l0.a.y0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0915a implements c.f {
        public C0915a() {
        }

        @Override // d.a.l0.a.y0.i.c.f
        public void a() {
            if (a.this.f45774b != null) {
                a.this.f45774b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0915a c0915a = new C0915a();
        this.f45842h = c0915a;
        cVar.H0(c0915a);
        this.f45773a.a(new d());
        this.f45773a.a(new d.a.l0.a.y0.i.d.c());
        this.f45773a.a(new e());
        this.f45773a.a(new d.a.l0.a.y0.i.d.a());
        this.f45773a.a(new d.a.l0.a.y0.i.d.b());
    }
}
