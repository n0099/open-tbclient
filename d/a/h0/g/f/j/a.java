package d.a.h0.g.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import d.a.h0.a.e0.p.j;
import d.a.h0.a.i2.e0;
import d.a.h0.a.k;
import d.a.h0.g.f.b;
import d.a.h0.g.q.a;
import d.a.h0.l.h.c;
import d.a.h0.l.k.h;
import d.a.h0.l.r.f;
import d.a.h0.p.d;
import java.io.File;
import java.util.Set;
/* loaded from: classes3.dex */
public class a extends j {
    public static final boolean j = k.f43101a;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public b f46325g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public d.a.h0.g.f.k.a f46326h;

    /* renamed from: i  reason: collision with root package name */
    public c<h> f46327i = new C0934a();

    /* renamed from: d.a.h0.g.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0934a extends d.a.h0.l.h.b<h> {
        public C0934a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.c
        /* renamed from: l */
        public String e(h hVar) {
            return a.d.g().getPath();
        }

        @Override // d.a.h0.l.h.e
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            return a.this.m(bundle, set);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: o */
        public void f(h hVar, d.a.h0.l.k.a aVar) {
            super.f(hVar, aVar);
            if (a.j) {
                Log.e("ConsoleJsDownload", "onDownloadError: " + aVar.toString());
            }
            a.this.f46325g.a(false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: p */
        public void i(h hVar) {
            super.i(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadFinish: " + hVar.toString());
            }
            if (!e0.a(new File(hVar.f47147a), hVar.m)) {
                if (a.j) {
                    Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                }
                a.this.f46325g.a(false);
                return;
            }
            File a2 = a.this.f46326h.a();
            if (a2.exists()) {
                d.f(a2);
            } else {
                d.h(a2);
            }
            boolean F = d.F(hVar.f47147a, a2.getAbsolutePath());
            if (F) {
                a.this.f46326h.b(hVar.j);
            }
            d.g(hVar.f47147a);
            a.this.f46325g.a(F);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: q */
        public void d(h hVar) {
            super.d(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloadStart: " + hVar.toString());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.l.h.b, d.a.h0.l.h.c
        /* renamed from: r */
        public void g(h hVar) {
            super.g(hVar);
            if (a.j) {
                Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
            }
        }
    }

    public a(@NonNull d.a.h0.g.f.k.a aVar, @NonNull b bVar) {
        this.f46325g = bVar;
        this.f46326h = aVar;
    }

    @Override // d.a.h0.l.h.g
    public void B(d.a.h0.l.k.a aVar) {
        super.B(aVar);
        if (j) {
            Log.e("ConsoleJsDownload", "onFetchError: " + aVar.toString());
        }
        this.f46325g.a(false);
    }

    @Override // d.a.h0.l.h.g
    public void D() {
        super.D();
        if (j) {
            Log.i("ConsoleJsDownload", "onFetchSuccess");
        }
    }

    @Override // d.a.h0.l.h.g
    public void E() {
        super.E();
        if (j) {
            Log.i("ConsoleJsDownload", "onNoPackage");
        }
        this.f46325g.a(false);
    }

    @Override // d.a.h0.l.h.g
    public void F(f fVar) {
        super.F(fVar);
        if (j) {
            Log.i("ConsoleJsDownload", "onPrepareDownload");
        }
    }

    @Override // d.a.h0.l.h.g
    public c<h> w() {
        return this.f46327i;
    }
}
