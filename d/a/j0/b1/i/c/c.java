package d.a.j0.b1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.j0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.j0.b1.i.a.b f49041a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f49042b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> f49043c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.j0.b1.i.a.a> f49044d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f49045e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f49046f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            try {
                c.this.f49045e.shutdownNow();
                c.this.f49045e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (c.this.f49042b != null) {
                c.this.f49042b.recycle();
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RejectedExecutionHandler {
        public b(c cVar) {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* renamed from: d.a.j0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1103c extends d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> {
        public C1103c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1101a c1101a, d.a.j0.b1.i.a.a aVar, d.a.j0.b1.i.a.a aVar2) {
            if (!z || c.this.f49044d == null || aVar == null) {
                return;
            }
            aVar.a();
            c.this.f49044d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(a.C1101a c1101a, d.a.j0.b1.i.a.a aVar) {
            if (aVar == null) {
                return 0;
            }
            return BitmapHelper.getBitmapSize(aVar.b());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f49049e;

        /* renamed from: f  reason: collision with root package name */
        public int f49050f;

        /* renamed from: g  reason: collision with root package name */
        public int f49051g;

        /* renamed from: h  reason: collision with root package name */
        public d.a.j0.b1.i.a.b f49052h;

        /* renamed from: i  reason: collision with root package name */
        public BitmapRegionDecoder f49053i;
        public d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> j;
        public d.a.j0.b1.i.b.a k;
        public c l;

        public d(int i2, int i3, int i4) {
            this.f49049e = i2;
            this.f49050f = i3;
            this.f49051g = i4;
        }

        public final void b(c cVar, d.a.j0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> aVar) {
            this.f49052h = bVar;
            this.f49053i = bitmapRegionDecoder;
            this.j = aVar;
            this.l = cVar;
        }

        public final boolean c(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }

        public void d(d.a.j0.b1.i.b.a aVar) {
            this.k = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.j0.b1.i.a.a c2;
            if (this.j != null && this.f49052h.b(this.f49049e, this.f49050f, this.f49051g)) {
                Rect j = this.f49052h.j(this.f49049e, this.f49050f, this.f49051g);
                this.f49052h.a(j);
                if (c(j)) {
                    return;
                }
                try {
                    c2 = this.l.f().b();
                    if (c2 != null) {
                        if (!c2.g(j)) {
                            System.currentTimeMillis();
                            c2.a();
                        }
                    } else {
                        c2 = this.f49052h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f49052h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f49051g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.f49053i.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.f49053i.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f49049e, this.f49050f, this.f49051g);
                this.j.h(c2.d(), c2);
                d.a.j0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    public c(d.a.j0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.f49041a = bVar;
        this.f49042b = bitmapRegionDecoder;
        d.a.j0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f49045e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f49043c = new C1103c((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.a.c.e.k.b<d.a.j0.b1.i.a.a> p = d.a.j0.a0.c.k().p(this.f49041a.e());
        this.f49044d = p;
        p.f(6);
    }

    public void d(boolean z) {
        this.f49045e.purge();
        if (z && this.f49046f == null) {
            a aVar = new a();
            this.f49046f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> e() {
        return this.f49043c;
    }

    public d.a.c.e.k.b<d.a.j0.b1.i.a.a> f() {
        return this.f49044d;
    }

    public void g() {
        d(true);
        d.a.c.e.k.a<a.C1101a, d.a.j0.b1.i.a.a> aVar = this.f49043c;
        if (aVar != null) {
            aVar.k(0);
            this.f49043c.a();
            this.f49043c = null;
        }
        this.f49044d = null;
    }

    public void h(d dVar) {
        if (dVar == null || this.f49046f != null) {
            return;
        }
        dVar.b(this, this.f49041a, this.f49042b, e());
        this.f49045e.submit(dVar);
    }
}
