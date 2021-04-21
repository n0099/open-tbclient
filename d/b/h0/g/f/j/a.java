package d.b.h0.g.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.h0.a.e0.p.j;
import d.b.h0.a.i2.e0;
import d.b.h0.a.k;
import d.b.h0.g.f.b;
import d.b.h0.g.q.a;
import d.b.h0.l.h.c;
import d.b.h0.l.k.h;
import d.b.h0.l.r.f;
import d.b.h0.p.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean j = k.f45772a;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f48854g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.b.h0.g.f.k.a f48855h;
    public c<h> i = new C0995a();

    /* renamed from: d.b.h0.g.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0995a extends d.b.h0.l.h.b<h> {
        public C0995a() {
        }

        @Override // d.b.h0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return a.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.c
        /* renamed from: m */
        public String j(h hVar) {
            return a.d.g().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: o */
        public void l(h hVar, d.b.h0.l.k.a aVar) {
            super.l(hVar, aVar);
            if (a.j) {
                Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.f48854g.a(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: p */
        public void b(h hVar) {
            super.b(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!e0.a(new File(hVar.f49638a), hVar.m)) {
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.f48854g.a(false);
                return;
            }
            File a2 = a.this.f48855h.a();
            if (a2.exists()) {
                d.f(a2);
            } else {
                d.h(a2);
            }
            boolean F = d.F(hVar.f49638a, a2.getAbsolutePath());
            if (F) {
                a.this.f48855h.b(hVar.j);
            }
            d.g(hVar.f49638a);
            a.this.f48854g.a(F);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: q */
        public void i(h hVar) {
            super.i(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.l.h.b, d.b.h0.l.h.c
        /* renamed from: r */
        public void n(h hVar) {
            super.n(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
            }
        }
    }

    public a(@NonNull d.b.h0.g.f.k.a aVar, @NonNull b bVar) {
        this.f48854g = bVar;
        this.f48855h = aVar;
    }

    @Override // d.b.h0.l.h.g
    public void B(d.b.h0.l.k.a aVar) {
        super.B(aVar);
        if (j) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.f48854g.a(false);
    }

    @Override // d.b.h0.l.h.g
    public void D() {
        super.D();
        if (j) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // d.b.h0.l.h.g
    public void E() {
        super.E();
        if (j) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.f48854g.a(false);
    }

    @Override // d.b.h0.l.h.g
    public void F(f fVar) {
        super.F(fVar);
        if (j) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // d.b.h0.l.h.g
    public c<h> w() {
        return this.i;
    }
}
