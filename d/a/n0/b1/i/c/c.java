package d.a.n0.b1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import d.a.n0.b1.i.a.a;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.n0.b1.i.a.b f52847a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f52848b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> f52849c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.c.e.k.b<d.a.n0.b1.i.a.a> f52850d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f52851e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f52852f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            try {
                c.this.f52851e.shutdownNow();
                c.this.f52851e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (c.this.f52848b != null) {
                c.this.f52848b.recycle();
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

    /* renamed from: d.a.n0.b1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1169c extends d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> {
        public C1169c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1167a c1167a, d.a.n0.b1.i.a.a aVar, d.a.n0.b1.i.a.a aVar2) {
            if (!z || c.this.f52850d == null || aVar == null) {
                return;
            }
            aVar.a();
            c.this.f52850d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.a
        /* renamed from: p */
        public int m(a.C1167a c1167a, d.a.n0.b1.i.a.a aVar) {
            if (aVar == null) {
                return 0;
            }
            return BitmapHelper.getBitmapSize(aVar.b());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f52855e;

        /* renamed from: f  reason: collision with root package name */
        public int f52856f;

        /* renamed from: g  reason: collision with root package name */
        public int f52857g;

        /* renamed from: h  reason: collision with root package name */
        public d.a.n0.b1.i.a.b f52858h;

        /* renamed from: i  reason: collision with root package name */
        public BitmapRegionDecoder f52859i;
        public d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> j;
        public d.a.n0.b1.i.b.a k;
        public c l;

        public d(int i2, int i3, int i4) {
            this.f52855e = i2;
            this.f52856f = i3;
            this.f52857g = i4;
        }

        public final void b(c cVar, d.a.n0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> aVar) {
            this.f52858h = bVar;
            this.f52859i = bitmapRegionDecoder;
            this.j = aVar;
            this.l = cVar;
        }

        public final boolean c(Rect rect) {
            return rect.right <= rect.left || rect.bottom <= rect.top;
        }

        public void d(d.a.n0.b1.i.b.a aVar) {
            this.k = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.n0.b1.i.a.a c2;
            if (this.j != null && this.f52858h.b(this.f52855e, this.f52856f, this.f52857g)) {
                Rect j = this.f52858h.j(this.f52855e, this.f52856f, this.f52857g);
                this.f52858h.a(j);
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
                        c2 = this.f52858h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f52858h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f52857g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.f52859i.decodeRegion(j, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.f52859i.decodeRegion(j, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f52855e, this.f52856f, this.f52857g);
                this.j.h(c2.d(), c2);
                d.a.n0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    public c(d.a.n0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.f52847a = bVar;
        this.f52848b = bitmapRegionDecoder;
        d.a.n0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f52851e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f52849c = new C1169c((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.a.c.e.k.b<d.a.n0.b1.i.a.a> p = d.a.n0.a0.c.k().p(this.f52847a.e());
        this.f52850d = p;
        p.f(6);
    }

    public void d(boolean z) {
        this.f52851e.purge();
        if (z && this.f52852f == null) {
            a aVar = new a();
            this.f52852f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> e() {
        return this.f52849c;
    }

    public d.a.c.e.k.b<d.a.n0.b1.i.a.a> f() {
        return this.f52850d;
    }

    public void g() {
        d(true);
        d.a.c.e.k.a<a.C1167a, d.a.n0.b1.i.a.a> aVar = this.f52849c;
        if (aVar != null) {
            aVar.k(0);
            this.f52849c.a();
            this.f52849c = null;
        }
        this.f52850d = null;
    }

    public void h(d dVar) {
        if (dVar == null || this.f52852f != null) {
            return;
        }
        dVar.b(this, this.f52847a, this.f52848b, e());
        this.f52851e.submit(dVar);
    }
}
