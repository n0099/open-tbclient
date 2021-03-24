package d.b.g0.a.e0.p.o;

import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.b.g0.a.e0.p.f;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class a extends f {
    public b G;

    /* renamed from: d.b.g0.a.e0.p.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0673a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f44215e;

        public RunnableC0673a(int i) {
            this.f44215e = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.G != null) {
                int i = this.f44215e;
                if (i == -1) {
                    a.this.G.onError();
                } else if (i == 0) {
                    a.this.G.a();
                } else if (i != 1) {
                } else {
                    a.this.G.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void onError();

        void onSuccess();
    }

    public a(String str, b bVar) {
        super(str);
        this.G = bVar;
    }

    @Override // d.b.g0.a.e0.p.f, d.b.g0.l.h.g
    public void C(d.b.g0.l.k.a aVar) {
        super.C(aVar);
        G0(-1);
    }

    @Override // d.b.g0.l.h.g
    public void F() {
        super.F();
        G0(0);
    }

    public final void G0(int i) {
        k0.T(new RunnableC0673a(i));
    }

    @Override // d.b.g0.a.e0.p.j
    public int K() {
        return 1;
    }

    @Override // d.b.g0.a.e0.p.f
    public PMSDownloadType i0() {
        return null;
    }

    @Override // d.b.g0.a.e0.p.f
    public void t0() {
        super.t0();
        if (D0() == null) {
            G0(1);
            y0("page_route_download", "0");
            return;
        }
        G0(-1);
    }

    @Override // d.b.g0.a.e0.p.f
    public void u0(Throwable th) {
        G0(-1);
    }
}
