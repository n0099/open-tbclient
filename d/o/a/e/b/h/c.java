package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f67251a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f67252b;

    public c(InputStream inputStream, int i2) {
        this.f67251a = inputStream;
        this.f67252b = new d.o.a.e.b.i.a(i2);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f67252b;
        aVar.f67255c = this.f67251a.read(aVar.f67253a);
        return this.f67252b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f67251a);
    }
}
