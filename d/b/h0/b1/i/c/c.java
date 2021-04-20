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
    public final d.b.h0.b1.i.a.b f50314a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f50315b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> f50316c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.c.e.k.b<d.b.h0.b1.i.a.a> f50317d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f50318e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f50319f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            try {
                c.this.f50318e.shutdownNow();
                c.this.f50318e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (c.this.f50315b != null) {
                c.this.f50315b.recycle();
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
    public class C1066c extends d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> {
        public C1066c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C1064a c1064a, d.b.h0.b1.i.a.a aVar, d.b.h0.b1.i.a.a aVar2) {
            if (!z || c.this.f50317d == null || aVar == null) {
                return;
            }
            aVar.a();
            c.this.f50317d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.c.e.k.a
        /* renamed from: p */
        public int m(a.C1064a c1064a, d.b.h0.b1.i.a.a aVar) {
            if (aVar == null) {
                return 0;
            }
            return BitmapHelper.getBitmapSize(aVar.b());
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public int f50322e;

        /* renamed from: f  reason: collision with root package name */
        public int f50323f;

        /* renamed from: g  reason: collision with root package name */
        public int f50324g;

        /* renamed from: h  reason: collision with root package name */
        public d.b.h0.b1.i.a.b f50325h;
        public BitmapRegionDecoder i;
        public d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> j;
        public d.b.h0.b1.i.b.a k;
        public c l;

        public d(int i, int i2, int i3) {
            this.f50322e = i;
            this.f50323f = i2;
            this.f50324g = i3;
        }

        public final void b(c cVar, d.b.h0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> aVar) {
            this.f50325h = bVar;
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
            if (this.j != null && this.f50325h.b(this.f50322e, this.f50323f, this.f50324g)) {
                Rect j = this.f50325h.j(this.f50322e, this.f50323f, this.f50324g);
                this.f50325h.a(j);
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
                        c2 = this.f50325h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> aVar = this.j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f50325h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f50324g;
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
                c2.j(this.f50322e, this.f50323f, this.f50324g);
                this.j.h(c2.d(), c2);
                d.b.h0.b1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    public c(d.b.h0.b1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        this.f50314a = bVar;
        this.f50315b = bitmapRegionDecoder;
        d.b.h0.a0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f50318e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f50316c = new C1066c((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        d.b.c.e.k.b<d.b.h0.b1.i.a.a> p = d.b.h0.a0.c.k().p(this.f50314a.e());
        this.f50317d = p;
        p.f(6);
    }

    public void d(boolean z) {
        this.f50318e.purge();
        if (z && this.f50319f == null) {
            a aVar = new a();
            this.f50319f = aVar;
            aVar.execute(new Void[0]);
        }
    }

    public d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> e() {
        return this.f50316c;
    }

    public d.b.c.e.k.b<d.b.h0.b1.i.a.a> f() {
        return this.f50317d;
    }

    public void g() {
        d(true);
        d.b.c.e.k.a<a.C1064a, d.b.h0.b1.i.a.a> aVar = this.f50316c;
        if (aVar != null) {
            aVar.k(0);
            this.f50316c.a();
            this.f50316c = null;
        }
        this.f50317d = null;
    }

    public void h(d dVar) {
        if (dVar == null || this.f50319f != null) {
            return;
        }
        dVar.b(this, this.f50314a, this.f50315b, e());
        this.f50318e.submit(dVar);
    }
}
