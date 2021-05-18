package d.a.i0.h.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.i0.a.h0.m.j;
import d.a.i0.a.k;
import d.a.i0.a.v2.j0;
import d.a.i0.h.f.b;
import d.a.i0.h.s.a;
import d.a.i0.n.f.c;
import d.a.i0.n.h.h;
import d.a.i0.n.o.f;
import d.a.i0.t.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean j = k.f43025a;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f47186g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.a.i0.h.f.k.a f47187h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f47188i = new C1013a();

    /* renamed from: d.a.i0.h.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1013a extends d.a.i0.n.f.b<h> {
        public C1013a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.c
        /* renamed from: l */
        public String d(h hVar) {
            return a.d.g().getPath();
        }

        @Override // d.a.i0.n.f.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: o */
        public void e(h hVar, d.a.i0.n.h.a aVar) {
            super.e(hVar, aVar);
            if (a.j) {
                Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.f47186g.a(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: p */
        public void i(h hVar) {
            super.i(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!j0.a(new File(hVar.f47830a), hVar.m)) {
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.f47186g.a(false);
                return;
            }
            File a2 = a.this.f47187h.a();
            if (a2.exists()) {
                d.i(a2);
            } else {
                d.k(a2);
            }
            boolean T = d.T(hVar.f47830a, a2.getAbsolutePath());
            if (T) {
                a.this.f47187h.b(hVar.j, hVar.f47838i);
            }
            d.j(hVar.f47830a);
            a.this.f47186g.a(T);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: q */
        public void c(h hVar) {
            super.c(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.n.f.b, d.a.i0.n.f.c
        /* renamed from: r */
        public void f(h hVar) {
            super.f(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
            }
        }
    }

    public a(@NonNull d.a.i0.h.f.k.a aVar, @NonNull b bVar) {
        this.f47186g = bVar;
        this.f47187h = aVar;
    }

    @Override // d.a.i0.n.f.g
    public void B(d.a.i0.n.h.a aVar) {
        super.B(aVar);
        if (j) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.f47186g.a(false);
    }

    @Override // d.a.i0.n.f.g
    public void D() {
        super.D();
        if (j) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // d.a.i0.n.f.g
    public void E() {
        super.E();
        if (j) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.f47186g.a(false);
    }

    @Override // d.a.i0.n.f.g
    public void F(f fVar) {
        super.F(fVar);
        if (j) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // d.a.i0.n.f.g
    public c<h> w() {
        return this.f47188i;
    }
}
