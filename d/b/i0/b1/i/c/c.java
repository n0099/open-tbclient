package d.b.i0.b1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.b.i0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d.b.i0.b1.i.a.b f50650a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f50651b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> f50652c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.e.k.b<d.b.i0.b1.i.a.a> f50653d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f50654e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f50655f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            try {
                c.this.f50654e.shutdownNow();
                c.this.f50654e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (c.this.f50651b != null) {
                c.this.f50651b.recycle();
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

    /* renamed from: d.b.i0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1088c extends d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> {
        public C1088c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1086a c1086a, d.b.i0.b1.i.a.a aVar, d.b.i0.b1.i.a.a aVar2) {
            if (!z || c.this.f50653d == null || aVar == null) {
                return;
            }
            aVar.a();
            c.this.f50653d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.a
        /* renamed from: p */
        public int m(a.C1086a c1086a, d.b.i0.b1.i.a.a aVar) {
            if (aVar == null) {
                return 0;
            }
            return BitmapHelper.getBitmapSize(aVar.b());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f50658e;

        /* renamed from: f  reason: collision with root package name */
        public int f50659f;

        /* renamed from: g  reason: collision with root package name */
        public int f50660g;

        /* renamed from: h  reason: collision with root package name */
        public d.b.i0.b1.i.a.b f50661h;
        public BitmapRegionDecoder i;
        public d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> j;
        public d.b.i0.b1.i.b.a k;
        public c l;

        public d(int i, int i2, int i3) {
            this.f50658e = i;
            this.f50659f = i2;
            this.f50660g = i3;
        }

        public final void b(c cVar, d.b.i0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> aVar) {
            this.f50661h = bVar;
            this.i = bitmapRegionDecoder;
            this.j = aVar;
            this.l = cVar;
        }

        public final boolean c(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }

        public void d(d.b.i0.b1.i.b.a aVar) {
            this.k = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.i0.b1.i.a.a c2;
            if (this.j != null && this.f50661h.b(this.f50658e, this.f50659f, this.f50660g)) {
                Rect j = this.f50661h.j(this.f50658e, this.f50659f, this.f50660g);
                this.f50661h.a(j);
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
                        c2 = this.f50661h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f50661h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f50660g;
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
                c2.j(this.f50658e, this.f50659f, this.f50660g);
                this.j.h(c2.d(), c2);
                d.b.i0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    public c(d.b.i0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.f50650a = bVar;
        this.f50651b = bitmapRegionDecoder;
        d.b.i0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f50654e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f50652c = new C1088c((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.b.c.e.k.b<d.b.i0.b1.i.a.a> p = d.b.i0.a0.c.k().p(this.f50650a.e());
        this.f50653d = p;
        p.f(6);
    }

    public void d(boolean z) {
        this.f50654e.purge();
        if (z && this.f50655f == null) {
            a aVar = new a();
            this.f50655f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> e() {
        return this.f50652c;
    }

    public d.b.c.e.k.b<d.b.i0.b1.i.a.a> f() {
        return this.f50653d;
    }

    public void g() {
        d(true);
        d.b.c.e.k.a<a.C1086a, d.b.i0.b1.i.a.a> aVar = this.f50652c;
        if (aVar != null) {
            aVar.k(0);
            this.f50652c.a();
            this.f50652c = null;
        }
        this.f50653d = null;
    }

    public void h(d dVar) {
        if (dVar == null || this.f50655f != null) {
            return;
        }
        dVar.b(this, this.f50650a, this.f50651b, e());
        this.f50654e.submit(dVar);
    }
}
