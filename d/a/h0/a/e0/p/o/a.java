package d.a.h0.a.e0.p.o;

import com.baidu.swan.apps.core.pms.PMSDownloadType;
import d.a.h0.a.e0.p.f;
import d.a.h0.a.i2.k0;
/* loaded from: classes2.dex */
public class a extends f {
    public b G;

    /* renamed from: d.a.h0.a.e0.p.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0645a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f42241e;

        public RunnableC0645a(int i2) {
            this.f42241e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.G != null) {
                int i2 = this.f42241e;
                if (i2 == -1) {
                    a.this.G.onError();
                } else if (i2 == 0) {
                    a.this.G.a();
                } else if (i2 != 1) {
                } else {
                    a.this.G.onSuccess();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void onError();

        void onSuccess();
    }

    public a(String str, b bVar) {
        super(str);
        this.G = bVar;
    }

    @Override // d.a.h0.a.e0.p.f, d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        F0(-1);
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        F0(0);
    }

    public final void F0(int i2) {
        k0.T(new RunnableC0645a(i2));
    }

    @Override // d.a.h0.a.e0.p.j
    public int J() {
        return 1;
    }

    @Override // d.a.h0.a.e0.p.f
    public PMSDownloadType h0() {
        return null;
    }

    @Override // d.a.h0.a.e0.p.f
    public void s0() {
        super.s0();
        if (C0() == null) {
            F0(1);
            x0("page_route_download", "0");
            return;
        }
        F0(-1);
    }

    @Override // d.a.h0.a.e0.p.f
    public void t0(Throwable th) {
        F0(-1);
    }
}
