package d.a.o0.e3.o0.d.f;

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
public class b extends d.a.o0.e3.o0.d.f.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile d f58001g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f58002h;

    /* renamed from: i  reason: collision with root package name */
    public int f58003i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f58004e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f58004e);
            this.f58004e = this.f58004e + 1;
            return thread;
        }
    }

    /* renamed from: d.a.o0.e3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1359b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f58005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f58006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f58007g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f58008h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f58009i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1359b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            this.f58005e = randomAccessFile;
            this.f58006f = arrayList;
            this.f58007g = i2;
            this.f58008h = i3;
            this.f58009i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f58005e, ((Integer) this.f58006f.get(this.f58007g)).intValue(), this.f58008h, this.f58009i);
            if (h2 != null) {
                if (h2.f58012b != 0) {
                    b.this.f58001g.f58012b = h2.f58012b;
                    b.this.f58001g.f58013c = h2.f58013c;
                }
                if (!StringUtils.isNull(h2.f58011a)) {
                    b.this.f58001g.f58011a = h2.f58011a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.f58003i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        this.f58001g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f58003i;
        bVar.f58003i = i2 + 1;
        return i2;
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public void a() {
        this.f58002h = true;
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public boolean c() {
        return (!this.f58002h && this.f58001g.f58012b == 0 && StringUtils.isNull(this.f58001g.f58011a)) ? false : true;
    }

    @Override // d.a.o0.e3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f57996b), r.f7715a);
            for (int i3 = 0; i3 < size; i3++) {
                threadPoolExecutor.execute(new RunnableC1359b(randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
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
            return this.f58001g;
        } catch (FileNotFoundException unused) {
            return this.f58001g;
        }
    }
}
