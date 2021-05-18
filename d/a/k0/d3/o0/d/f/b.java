package d.a.k0.d3.o0.d.f;

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
public class b extends d.a.k0.d3.o0.d.f.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile d f53974g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f53975h;

    /* renamed from: i  reason: collision with root package name */
    public int f53976i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f53977e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f53977e);
            this.f53977e = this.f53977e + 1;
            return thread;
        }
    }

    /* renamed from: d.a.k0.d3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1280b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f53978e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f53979f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53980g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f53981h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f53982i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1280b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            this.f53978e = randomAccessFile;
            this.f53979f = arrayList;
            this.f53980g = i2;
            this.f53981h = i3;
            this.f53982i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f53978e, ((Integer) this.f53979f.get(this.f53980g)).intValue(), this.f53981h, this.f53982i);
            if (h2 != null) {
                if (h2.f53985b != 0) {
                    b.this.f53974g.f53985b = h2.f53985b;
                    b.this.f53974g.f53986c = h2.f53986c;
                }
                if (!StringUtils.isNull(h2.f53984a)) {
                    b.this.f53974g.f53984a = h2.f53984a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.f53976i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        this.f53974g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f53976i;
        bVar.f53976i = i2 + 1;
        return i2;
    }

    @Override // d.a.k0.d3.o0.d.f.a
    public void a() {
        this.f53975h = true;
    }

    @Override // d.a.k0.d3.o0.d.f.a
    public boolean c() {
        return (!this.f53975h && this.f53974g.f53985b == 0 && StringUtils.isNull(this.f53974g.f53984a)) ? false : true;
    }

    @Override // d.a.k0.d3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53969b), r.f7772a);
            for (int i3 = 0; i3 < size; i3++) {
                threadPoolExecutor.execute(new RunnableC1280b(randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
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
            return this.f53974g;
        } catch (FileNotFoundException unused) {
            return this.f53974g;
        }
    }
}
