package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f67208a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f67209b;

    public c(InputStream inputStream, int i2) {
        this.f67208a = inputStream;
        this.f67209b = new d.o.a.e.b.i.a(i2);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f67209b;
        aVar.f67212c = this.f67208a.read(aVar.f67210a);
        return this.f67209b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f67208a);
    }
}
