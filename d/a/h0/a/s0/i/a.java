package d.a.h0.a.s0.i;

import androidx.annotation.NonNull;
import d.a.h0.a.s0.i.c;
import d.a.h0.a.s0.i.d.d;
import d.a.h0.a.s0.i.d.e;
/* loaded from: classes2.dex */
public final class a extends d.a.h0.a.s0.b<c> {

    /* renamed from: h  reason: collision with root package name */
    public final c.f f43940h;

    /* renamed from: d.a.h0.a.s0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0759a implements c.f {
        public C0759a() {
        }

        @Override // d.a.h0.a.s0.i.c.f
        public void a() {
            if (a.this.f43872b != null) {
                a.this.f43872b.onCallback(a.this, "onConfirmBtnClick", null);
            }
        }
    }

    public a(@NonNull c cVar) {
        super(cVar);
        C0759a c0759a = new C0759a();
        this.f43940h = c0759a;
        cVar.x0(c0759a);
        this.f43871a.a(new d());
        this.f43871a.a(new d.a.h0.a.s0.i.d.c());
        this.f43871a.a(new e());
        this.f43871a.a(new d.a.h0.a.s0.i.d.a());
        this.f43871a.a(new d.a.h0.a.s0.i.d.b());
    }
}
