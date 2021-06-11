package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f71037a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f71038b;

    public c(InputStream inputStream, int i2) {
        this.f71037a = inputStream;
        this.f71038b = new d.o.a.e.b.i.a(i2);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f71038b;
        aVar.f71041c = this.f71037a.read(aVar.f71039a);
        return this.f71038b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f71037a);
    }
}
