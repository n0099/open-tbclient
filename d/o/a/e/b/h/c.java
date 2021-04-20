package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f68013a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f68014b;

    public c(InputStream inputStream, int i) {
        this.f68013a = inputStream;
        this.f68014b = new d.o.a.e.b.i.a(i);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f68014b;
        aVar.f68017c = this.f68013a.read(aVar.f68015a);
        return this.f68014b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f68013a);
    }
}
