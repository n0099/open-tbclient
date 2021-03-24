package d.o.a.e.b.h;

import d.o.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f67015a;

    /* renamed from: b  reason: collision with root package name */
    public final d.o.a.e.b.i.a f67016b;

    public c(InputStream inputStream, int i) {
        this.f67015a = inputStream;
        this.f67016b = new d.o.a.e.b.i.a(i);
    }

    @Override // d.o.a.e.b.h.b
    public d.o.a.e.b.i.a a() throws IOException {
        d.o.a.e.b.i.a aVar = this.f67016b;
        aVar.f67019c = this.f67015a.read(aVar.f67017a);
        return this.f67016b;
    }

    @Override // d.o.a.e.b.h.b
    public void a(d.o.a.e.b.i.a aVar) {
    }

    @Override // d.o.a.e.b.h.b
    public void b() {
        e.C(this.f67015a);
    }
}
