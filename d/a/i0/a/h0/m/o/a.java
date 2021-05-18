package d.a.i0.a.h0.m.o;

import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import d.a.i0.a.h0.m.f;
import d.a.i0.a.v2.q0;
/* loaded from: classes2.dex */
public class a extends f {
    public b F;

    /* renamed from: d.a.i0.a.h0.m.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0671a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42224e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.q2.a f42225f;

        public RunnableC0671a(int i2, d.a.i0.a.q2.a aVar) {
            this.f42224e = i2;
            this.f42225f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.F != null) {
                int i2 = this.f42224e;
                if (i2 == -1) {
                    a.this.F.b(this.f42225f);
                } else if (i2 == 0) {
                    a.this.F.a();
                } else if (i2 != 1) {
                } else {
                    a.this.F.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void b(d.a.i0.a.q2.a aVar);

        void onSuccess();
    }

    public a(String str, b bVar) {
        super(str);
        this.F = bVar;
    }

    @Override // d.a.i0.a.h0.m.f, d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        super.B(aVar);
        d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
        aVar2.j(10L);
        aVar2.h(aVar.f47826a);
        aVar2.c(aVar.f47827b);
        aVar2.p(aVar.f47828c);
        G0(-1, aVar2);
    }

    @Override // d.a.i0.n.f.g
    public void E() {
        super.E();
        F0(0);
    }

    public final void F0(int i2) {
        G0(i2, null);
    }

    public final void G0(int i2, d.a.i0.a.q2.a aVar) {
        q0.X(new RunnableC0671a(i2, aVar));
    }

    @Override // d.a.i0.a.h0.m.j
    public int J() {
        return 1;
    }

    @Override // d.a.i0.a.h0.m.f
    public PMSDownloadType h0() {
        return null;
    }

    @Override // d.a.i0.a.h0.m.f
    public void s0() {
        super.s0();
        d.a.i0.a.q2.a C0 = C0();
        if (C0 == null) {
            F0(1);
            x0("page_route_download", "0");
            return;
        }
        G0(-1, C0);
    }

    @Override // d.a.i0.a.h0.m.f
    public void t0(Throwable th) {
        d.a.i0.a.q2.a aVar;
        if (th instanceof PkgDownloadError) {
            aVar = ((PkgDownloadError) th).getErrCode();
        } else {
            aVar = new d.a.i0.a.q2.a();
            aVar.j(10L);
            aVar.h(0L);
        }
        G0(-1, aVar);
    }
}
