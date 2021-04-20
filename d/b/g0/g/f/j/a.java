package d.b.g0.g.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import d.b.g0.a.e0.p.j;
import d.b.g0.a.i2.e0;
import d.b.g0.a.k;
import d.b.g0.g.f.b;
import d.b.g0.g.q.a;
import d.b.g0.l.h.c;
import d.b.g0.l.k.h;
import d.b.g0.l.r.f;
import d.b.g0.p.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean j = k.f45443a;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f48525g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.b.g0.g.f.k.a f48526h;
    public c<h> i = new C0975a();

    /* renamed from: d.b.g0.g.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0975a extends d.b.g0.l.h.b<h> {
        public C0975a() {
        }

        @Override // d.b.g0.l.h.e
        @NonNull
        public Bundle g(@NonNull Bundle bundle, Set<String> set) {
            return a.this.g(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.c
        /* renamed from: m */
        public String j(h hVar) {
            return a.d.g().getPath();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: o */
        public void l(h hVar, d.b.g0.l.k.a aVar) {
            super.l(hVar, aVar);
            if (a.j) {
                Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.f48525g.a(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: p */
        public void b(h hVar) {
            super.b(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!e0.a(new File(hVar.f49309a), hVar.m)) {
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.f48525g.a(false);
                return;
            }
            File a2 = a.this.f48526h.a();
            if (a2.exists()) {
                d.f(a2);
            } else {
                d.h(a2);
            }
            boolean F = d.F(hVar.f49309a, a2.getAbsolutePath());
            if (F) {
                a.this.f48526h.b(hVar.j);
            }
            d.g(hVar.f49309a);
            a.this.f48525g.a(F);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: q */
        public void i(h hVar) {
            super.i(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.l.h.b, d.b.g0.l.h.c
        /* renamed from: r */
        public void n(h hVar) {
            super.n(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
            }
        }
    }

    public a(@NonNull d.b.g0.g.f.k.a aVar, @NonNull b bVar) {
        this.f48525g = bVar;
        this.f48526h = aVar;
    }

    @Override // d.b.g0.l.h.g
    public void B(d.b.g0.l.k.a aVar) {
        super.B(aVar);
        if (j) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.f48525g.a(false);
    }

    @Override // d.b.g0.l.h.g
    public void D() {
        super.D();
        if (j) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // d.b.g0.l.h.g
    public void E() {
        super.E();
        if (j) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.f48525g.a(false);
    }

    @Override // d.b.g0.l.h.g
    public void F(f fVar) {
        super.F(fVar);
        if (j) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // d.b.g0.l.h.g
    public c<h> w() {
        return this.i;
    }
}
