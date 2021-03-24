package d.b.i0.c3.o0.d.f;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class b extends d.b.i0.c3.o0.d.f.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile d f53559g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f53560h;
    public int i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f53561e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f53561e);
            this.f53561e = this.f53561e + 1;
            return thread;
        }
    }

    /* renamed from: d.b.i0.c3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1188b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f53562e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f53563f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53564g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f53565h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1188b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
            this.f53562e = randomAccessFile;
            this.f53563f = arrayList;
            this.f53564g = i;
            this.f53565h = i2;
            this.i = str;
            this.j = i3;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f53562e, ((Integer) this.f53563f.get(this.f53564g)).intValue(), this.f53565h, this.i);
            if (h2 != null) {
                if (h2.f53568b != 0) {
                    b.this.f53559g.f53568b = h2.f53568b;
                    b.this.f53559g.f53569c = h2.f53569c;
                }
                if (!StringUtils.isNull(h2.f53567a)) {
                    b.this.f53559g.f53567a = h2.f53567a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i, int i2, long j, String str2) {
        super(str, i, i2, j, str2);
        this.f53559g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i = bVar.i;
        bVar.i = i + 1;
        return i;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public void a() {
        this.f53560h = true;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public boolean c() {
        return (!this.f53560h && this.f53559g.f53568b == 0 && StringUtils.isNull(this.f53559g.f53567a)) ? false : true;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53554b), r.f7663a);
            for (int i2 = 0; i2 < size; i2++) {
                threadPoolExecutor.execute(new RunnableC1188b(randomAccessFile, arrayList, i2, i, str, size, countDownLatch));
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            threadPoolExecutor.shutdown();
            try {
                randomAccessFile.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return this.f53559g;
        } catch (FileNotFoundException unused) {
            return this.f53559g;
        }
    }
}
