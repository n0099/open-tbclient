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
    public volatile d f53560g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f53561h;
    public int i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f53562e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f53562e);
            this.f53562e = this.f53562e + 1;
            return thread;
        }
    }

    /* renamed from: d.b.i0.c3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1189b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f53563e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f53564f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53565g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f53566h;
        public final /* synthetic */ String i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1189b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i, int i2, String str, int i3, CountDownLatch countDownLatch) {
            this.f53563e = randomAccessFile;
            this.f53564f = arrayList;
            this.f53565g = i;
            this.f53566h = i2;
            this.i = str;
            this.j = i3;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f53563e, ((Integer) this.f53564f.get(this.f53565g)).intValue(), this.f53566h, this.i);
            if (h2 != null) {
                if (h2.f53569b != 0) {
                    b.this.f53560g.f53569b = h2.f53569b;
                    b.this.f53560g.f53570c = h2.f53570c;
                }
                if (!StringUtils.isNull(h2.f53568a)) {
                    b.this.f53560g.f53568a = h2.f53568a;
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
        this.f53560g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i = bVar.i;
        bVar.i = i + 1;
        return i;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public void a() {
        this.f53561h = true;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public boolean c() {
        return (!this.f53561h && this.f53560g.f53569b == 0 && StringUtils.isNull(this.f53560g.f53568a)) ? false : true;
    }

    @Override // d.b.i0.c3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53555b), r.f7664a);
            for (int i2 = 0; i2 < size; i2++) {
                threadPoolExecutor.execute(new RunnableC1189b(randomAccessFile, arrayList, i2, i, str, size, countDownLatch));
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
            return this.f53560g;
        } catch (FileNotFoundException unused) {
            return this.f53560g;
        }
    }
}
