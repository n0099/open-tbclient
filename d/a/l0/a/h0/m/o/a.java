package d.a.l0.a.h0.m.o;

import com.baidu.swan.apps.core.pms.PMSDownloadType;
import com.baidu.swan.apps.core.pms.PkgDownloadError;
import d.a.l0.a.h0.m.f;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class a extends f {
    public b F;

    /* renamed from: d.a.l0.a.h0.m.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0738a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f46074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.q2.a f46075f;

        public RunnableC0738a(int i2, d.a.l0.a.q2.a aVar) {
            this.f46074e = i2;
            this.f46075f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.F != null) {
                int i2 = this.f46074e;
                if (i2 == -1) {
                    a.this.F.b(this.f46075f);
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

        void b(d.a.l0.a.q2.a aVar);

        void onSuccess();
    }

    public a(String str, b bVar) {
        super(str);
        this.F = bVar;
    }

    @Override // d.a.l0.a.h0.m.f, d.a.l0.n.f.g
    public void B(d.a.l0.n.h.a aVar) {
        super.B(aVar);
        d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
        aVar2.j(10L);
        aVar2.h(aVar.f51676a);
        aVar2.c(aVar.f51677b);
        aVar2.p(aVar.f51678c);
        G0(-1, aVar2);
    }

    @Override // d.a.l0.n.f.g
    public void E() {
        super.E();
        F0(0);
    }

    public final void F0(int i2) {
        G0(i2, null);
    }

    public final void G0(int i2, d.a.l0.a.q2.a aVar) {
        q0.X(new RunnableC0738a(i2, aVar));
    }

    @Override // d.a.l0.a.h0.m.j
    public int J() {
        return 1;
    }

    @Override // d.a.l0.a.h0.m.f
    public PMSDownloadType h0() {
        return null;
    }

    @Override // d.a.l0.a.h0.m.f
    public void s0() {
        super.s0();
        d.a.l0.a.q2.a C0 = C0();
        if (C0 == null) {
            F0(1);
            x0("page_route_download", "0");
            return;
        }
        G0(-1, C0);
    }

    @Override // d.a.l0.a.h0.m.f
    public void t0(Throwable th) {
        d.a.l0.a.q2.a aVar;
        if (th instanceof PkgDownloadError) {
            aVar = ((PkgDownloadError) th).getErrCode();
        } else {
            aVar = new d.a.l0.a.q2.a();
            aVar.j(10L);
            aVar.h(0L);
        }
        G0(-1, aVar);
    }
}
