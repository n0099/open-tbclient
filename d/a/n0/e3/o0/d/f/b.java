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
    public volatile d f57876g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f57877h;

    /* renamed from: i  reason: collision with root package name */
    public int f57878i;

    /* loaded from: classes5.dex */
    public class a implements ThreadFactory {

        /* renamed from: e  reason: collision with root package name */
        public int f57879e = 0;

        public a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("VideoUploadThread@" + this.f57879e);
            this.f57879e = this.f57879e + 1;
            return thread;
        }
    }

    /* renamed from: d.a.n0.e3.o0.d.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1355b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ RandomAccessFile f57880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ArrayList f57881f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f57882g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f57883h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f57884i;
        public final /* synthetic */ int j;
        public final /* synthetic */ CountDownLatch k;

        public RunnableC1355b(RandomAccessFile randomAccessFile, ArrayList arrayList, int i2, int i3, String str, int i4, CountDownLatch countDownLatch) {
            this.f57880e = randomAccessFile;
            this.f57881f = arrayList;
            this.f57882g = i2;
            this.f57883h = i3;
            this.f57884i = str;
            this.j = i4;
            this.k = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            d h2 = b.this.h(this.f57880e, ((Integer) this.f57881f.get(this.f57882g)).intValue(), this.f57883h, this.f57884i);
            if (h2 != null) {
                if (h2.f57887b != 0) {
                    b.this.f57876g.f57887b = h2.f57887b;
                    b.this.f57876g.f57888c = h2.f57888c;
                }
                if (!StringUtils.isNull(h2.f57886a)) {
                    b.this.f57876g.f57886a = h2.f57886a;
                }
                synchronized (b.this) {
                    b.k(b.this);
                    b.this.d((int) (((b.this.f57878i * 50.0f) / this.j) + 30.0f));
                }
            }
            this.k.countDown();
        }
    }

    public b(String str, int i2, int i3, long j, String str2) {
        super(str, i2, i3, j, str2);
        this.f57876g = new d();
    }

    public static /* synthetic */ int k(b bVar) {
        int i2 = bVar.f57878i;
        bVar.f57878i = i2 + 1;
        return i2;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public void a() {
        this.f57877h = true;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public boolean c() {
        return (!this.f57877h && this.f57876g.f57887b == 0 && StringUtils.isNull(this.f57876g.f57886a)) ? false : true;
    }

    @Override // d.a.n0.e3.o0.d.f.a
    public d g(ArrayList<Integer> arrayList, String str, int i2) {
        int size = arrayList.size();
        CountDownLatch countDownLatch = new CountDownLatch(size);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a(this));
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f57871b), r.f7715a);
            for (int i3 = 0; i3 < size; i3++) {
                threadPoolExecutor.execute(new RunnableC1355b(randomAccessFile, arrayList, i3, i2, str, size, countDownLatch));
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
            return this.f57876g;
        } catch (FileNotFoundException unused) {
            return this.f57876g;
        }
    }
}
