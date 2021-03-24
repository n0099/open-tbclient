package d.b.h0.b1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.h0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.h0.b1.i.a.b f49920a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f49921b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> f49922c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> f49923d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f49924e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f49925f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            try {
                c.this.f49924e.shutdownNow();
                c.this.f49924e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (c.this.f49921b != null) {
                c.this.f49921b.recycle();
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

    /* renamed from: d.b.h0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1053c extends d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> {
        public C1053c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1051a c1051a, d.b.h0.b1.i.a.a aVar, d.b.h0.b1.i.a.a aVar2) {
            if (!z || c.this.f49923d == null || aVar == null) {
                return;
            }
            aVar.a();
            c.this.f49923d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.k.a
        /* renamed from: p */
        public int m(a.C1051a c1051a, d.b.h0.b1.i.a.a aVar) {
            if (aVar == null) {
                return 0;
            }
            return BitmapHelper.getBitmapSize(aVar.b());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f49928e;

        /* renamed from: f  reason: collision with root package name */
        public int f49929f;

        /* renamed from: g  reason: collision with root package name */
        public int f49930g;

        /* renamed from: h  reason: collision with root package name */
        public d.b.h0.b1.i.a.b f49931h;
        public BitmapRegionDecoder i;
        public d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> j;
        public d.b.h0.b1.i.b.a k;
        public c l;

        public d(int i, int i2, int i3) {
            this.f49928e = i;
            this.f49929f = i2;
            this.f49930g = i3;
        }

        public final void b(c cVar, d.b.h0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> aVar) {
            this.f49931h = bVar;
            this.i = bitmapRegionDecoder;
            this.j = aVar;
            this.l = cVar;
        }

        public final boolean c(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }

        public void d(d.b.h0.b1.i.b.a aVar) {
            this.k = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.h0.b1.i.a.a c2;
            if (this.j != null && this.f49931h.b(this.f49928e, this.f49929f, this.f49930g)) {
                Rect j = this.f49931h.j(this.f49928e, this.f49929f, this.f49930g);
                this.f49931h.a(j);
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
                        c2 = this.f49931h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> aVar = this.j;
                    double g2 = aVar.g();
                    Double.isNaN(g2);
                    aVar.k((int) (g2 * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f49931h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f49930g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.i.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.i.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f49928e, this.f49929f, this.f49930g);
                this.j.h(c2.d(), c2);
                d.b.h0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    public c(d.b.h0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.f49920a = bVar;
        this.f49921b = bitmapRegionDecoder;
        d.b.h0.a0.c.j().s((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f49924e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f49922c = new C1053c((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.b.b.e.k.b<d.b.h0.b1.i.a.a> n = d.b.h0.a0.c.j().n(this.f49920a.e());
        this.f49923d = n;
        n.f(6);
    }

    public void d(boolean z) {
        this.f49924e.purge();
        if (z && this.f49925f == null) {
            a aVar = new a();
            this.f49925f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> e() {
        return this.f49922c;
    }

    public d.b.b.e.k.b<d.b.h0.b1.i.a.a> f() {
        return this.f49923d;
    }

    public void g() {
        d(true);
        d.b.b.e.k.a<a.C1051a, d.b.h0.b1.i.a.a> aVar = this.f49922c;
        if (aVar != null) {
            aVar.k(0);
            this.f49922c.a();
            this.f49922c = null;
        }
        this.f49923d = null;
    }

    public void h(d dVar) {
        if (dVar == null || this.f49925f != null) {
            return;
        }
        dVar.b(this, this.f49920a, this.f49921b, e());
        this.f49924e.submit(dVar);
    }
}
