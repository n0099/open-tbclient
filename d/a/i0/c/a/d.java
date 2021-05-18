package d.a.i0.c.a;

import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.bdtls.BdtlsController;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f46278b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.c.a.a f46279a = new d.a.i0.c.a.a();

    /* loaded from: classes3.dex */
    public static class a implements BdtlsController.a {
        @Override // com.baidu.swan.bdtls.BdtlsController.a
        public void loadLibrary(String str) {
            SoLoader.load(d.a.i0.a.c1.a.b(), str);
        }
    }

    static {
        boolean z = d.a.i0.c.a.a.f46273a;
        BdtlsController.a(new a());
    }

    public static d b() {
        if (f46278b == null) {
            synchronized (d.class) {
                if (f46278b == null) {
                    f46278b = new d();
                }
            }
        }
        return f46278b;
    }

    public void a(String str, d.a.i0.c.a.k.c cVar) {
        g.l().p(str, cVar);
    }

    public void c(byte[] bArr) {
        BdtlsController.handleConfsk(bArr);
    }

    public boolean d() {
        d.a.i0.c.a.a aVar = this.f46279a;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public boolean e(String str) {
        d.a.i0.c.a.a aVar = this.f46279a;
        return aVar != null && aVar.b(str);
    }

    public void f(boolean z) {
    }
}
