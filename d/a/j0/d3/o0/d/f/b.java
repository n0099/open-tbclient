package d.a.j0.d3.o0.d.f;

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
public class b extends d.a.j0.d3.o0.d.f.a {

    /* renamed from: g  reason: collision with root package name */
    public volatile d f53267g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f53268h;

    /* renamed from: i  reason: collision with root package name */
    public int f53269i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f53270e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f53270e);
            this.f53270e = this.f53270e + 1;
            return thread;
        }
    }

    /* renamed from: d.a.j0.d3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1208b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f53271e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f53272f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f53273g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f53274h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f53275i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1208b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            this.f53271e = randomAccessFile;
            this.f53272f = arrayList;
            this.f53273g = i2;
            this.f53274h = i3;
            this.f53275i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f53271e, ((Integer) this.f53272f.get(this.f53273g)).intValue(), this.f53274h, this.f53275i);
            if (h2 != null) {
                if (h2.f53278b != 0) {
                    b.this.f53267g.f53278b = h2.f53278b;
                    b.this.f53267g.f53279c = h2.f53279c;
                }
                if (!StringUtils.isNull(h2.f53277a)) {
                    b.this.f53267g.f53277a = h2.f53277a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.f53269i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        this.f53267g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f53269i;
        bVar.f53269i = i2 + 1;
        return i2;
    }

    @Override // d.a.j0.d3.o0.d.f.a
    public void a() {
        this.f53268h = true;
    }

    @Override // d.a.j0.d3.o0.d.f.a
    public boolean c() {
        return (!this.f53268h && this.f53267g.f53278b == 0 && StringUtils.isNull(this.f53267g.f53277a)) ? false : true;
    }

    @Override // d.a.j0.d3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f53262b), r.f7975a);
            for (int i3 = 0; i3 < size; i3++) {
                threadPoolExecutor.execute(new RunnableC1208b(randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
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
            return this.f53267g;
        } catch (FileNotFoundException unused) {
            return this.f53267g;
        }
    }
}
