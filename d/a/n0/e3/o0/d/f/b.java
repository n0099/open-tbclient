package d.a.n0.e3.o0.d.f;

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
public class b extends d.a.n0.e3.o0.d.f.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile d f54187g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f54188h;

    /* renamed from: i  reason: collision with root package name */
    public int f54189i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f54190e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f54190e);
            this.f54190e = this.f54190e + 1;
            return thread;
        }
    }

    /* renamed from: d.a.n0.e3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1299b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f54191e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f54192f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f54193g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f54194h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f54195i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1299b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            this.f54191e = randomAccessFile;
            this.f54192f = arrayList;
            this.f54193g = i2;
            this.f54194h = i3;
            this.f54195i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f54191e, ((Integer) this.f54192f.get(this.f54193g)).intValue(), this.f54194h, this.f54195i);
            if (h2 != null) {
                if (h2.f54198b != 0) {
                    b.this.f54187g.f54198b = h2.f54198b;
                    b.this.f54187g.f54199c = h2.f54199c;
                }
                if (!StringUtils.isNull(h2.f54197a)) {
                    b.this.f54187g.f54197a = h2.f54197a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.f54189i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        this.f54187g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f54189i;
        bVar.f54189i = i2 + 1;
        return i2;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public void a() {
        this.f54188h = true;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public boolean c() {
        return (!this.f54188h && this.f54187g.f54198b == 0 && StringUtils.isNull(this.f54187g.f54197a)) ? false : true;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f54182b), r.f7672a);
            for (int i3 = 0; i3 < size; i3++) {
                threadPoolExecutor.execute(new RunnableC1299b(randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
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
            return this.f54187g;
        } catch (FileNotFoundException unused) {
            return this.f54187g;
        }
    }
}
