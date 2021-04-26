package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f66522a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f66523b;

    public c(InputStream inputStream, int i2) {
        this.f66522a = inputStream;
        this.f66523b = new d.o.a.e.b.i.a(i2);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f66523b;
        aVar.f66526c = this.f66522a.read(aVar.f66524a);
        return this.f66523b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f66522a);
    }
}
