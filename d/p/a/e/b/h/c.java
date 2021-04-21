package d.p.a.e.b.h;

import d.p.a.e.b.l.e;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final InputStream f68160a;

    /* renamed from: b  reason: collision with root package name */
    public final d.p.a.e.b.i.a f68161b;

    public c(InputStream inputStream, int i) {
        this.f68160a = inputStream;
        this.f68161b = new d.p.a.e.b.i.a(i);
    }

    @Override // d.p.a.e.b.h.b
    public d.p.a.e.b.i.a a() throws IOException {
        d.p.a.e.b.i.a aVar = this.f68161b;
        aVar.f68164c = this.f68160a.read(aVar.f68162a);
        return this.f68161b;
    }

    @Override // d.p.a.e.b.h.b
    public void a(d.p.a.e.b.i.a aVar) {
    }

    @Override // d.p.a.e.b.h.b
    public void b() {
        e.C(this.f68160a);
    }
}
