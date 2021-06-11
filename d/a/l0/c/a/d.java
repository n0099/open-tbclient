package d.a.l0.c.a;

import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.bdtls.BdtlsController;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static volatile d f50128b;

    /* renamed from: a  reason: collision with root package name */
    public d.a.l0.c.a.a f50129a = new d.a.l0.c.a.a();

    /* loaded from: classes3.dex */
    public static class a implements BdtlsController.a {
        @Override // com.baidu.swan.bdtls.BdtlsController.a
        public void loadLibrary(String str) {
            SoLoader.load(d.a.l0.a.c1.a.b(), str);
        }
    }

    static {
        boolean z = d.a.l0.c.a.a.f50123a;
        BdtlsController.a(new a());
    }

    public static d b() {
        if (f50128b == null) {
            synchronized (d.class) {
                if (f50128b == null) {
                    f50128b = new d();
                }
            }
        }
        return f50128b;
    }

    public void a(String str, d.a.l0.c.a.k.c cVar) {
        g.l().p(str, cVar);
    }

    public void c(byte[] bArr) {
        BdtlsController.handleConfsk(bArr);
    }

    public boolean d() {
        d.a.l0.c.a.a aVar = this.f50129a;
        if (aVar == null) {
            return false;
        }
        return aVar.a();
    }

    public boolean e(String str) {
        d.a.l0.c.a.a aVar = this.f50129a;
        return aVar != null && aVar.b(str);
    }

    public void f(boolean z) {
    }
}
