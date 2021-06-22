package d.a.m0.a.v2.c1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.m0.a.f1.e.f.c;
import d.a.m0.a.k;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f49156i = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49158b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.a.v2.e1.b<String> f49162f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.a.m0.a.v2.e1.b<Pipe.SourceChannel>> f49157a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f49159c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f49160d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f49161e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f49163g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f49164h = 0.0f;

    /* renamed from: d.a.m0.a.v2.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0943a implements d.a.m0.a.v2.e1.b<d.a.m0.a.v2.e1.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49165e;

        public C0943a(List list) {
            this.f49165e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.v2.e1.b<Pipe.SourceChannel> bVar) {
            try {
                this.f49165e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.f49156i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f49167e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f49168f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f49167e = countDownLatch;
            this.f49168f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f49167e);
            this.f49168f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f49169e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f49169e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f49173h.isOpen() && eVar.f49172g.isOpen()) {
                    this.f49169e.rewind();
                    eVar.f49173h.write(this.f49169e);
                }
            } catch (IOException e2) {
                if (a.f49156i) {
                    a.m("connect e:" + e2 + " line: " + eVar);
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.a.v2.e1.b<e> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Pipe.SinkChannel sinkChannel = eVar.f49173h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.m0.a.v2.e1.b<Pipe.SourceChannel> f49170e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f49171f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f49172g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f49173h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f49174i;
        public String j;

        public e(a aVar, d.a.m0.a.v2.e1.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f49170e = bVar;
            Pipe open = Pipe.open();
            this.f49171f = open;
            this.f49173h = open.sink();
            this.f49172g = this.f49171f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f49173h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f49172g;
            a.f(sourceChannel, "source for " + toString());
        }

        public final void e() {
            CountDownLatch countDownLatch = this.f49174i;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public final void f(CountDownLatch countDownLatch) {
            this.f49174i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j = Thread.currentThread().toString();
            if (a.f49156i) {
                a.m(" >> run on " + toString());
            }
            try {
                try {
                    this.f49170e.onCallback(this.f49172g);
                } catch (Exception e2) {
                    if (a.f49156i) {
                        e2.printStackTrace();
                        a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                    }
                }
                if (a.f49156i) {
                    a.m("countdown by end -> " + toString());
                }
                e();
            } finally {
                d();
            }
        }

        public String toString() {
            return "PipeLine: " + this.j + " consumer=" + this.f49170e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.a.m0.t.d.d(channel);
    }

    public static void m(String str) {
        if (f49156i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.a.m0.a.v2.e1.b<Pipe.SourceChannel>... bVarArr) {
        this.f49157a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.a.m0.a.v2.e1.b<String> bVar = this.f49162f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f49163g.D(bundle);
        return this;
    }

    public synchronized void h(ReadableByteChannel readableByteChannel) {
        e(IntentConfig.START);
        long currentTimeMillis = System.currentTimeMillis();
        List<e> i2 = i();
        CountDownLatch countDownLatch = new CountDownLatch(i2.size());
        ExecutorService l = l(i2, countDownLatch);
        n(readableByteChannel, i2);
        e("pump_finish");
        if (f49156i) {
            m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            if (f49156i) {
                m("main await for timeout: " + this.f49161e.toMillis(this.f49160d));
            }
            boolean z = false;
            if (this.f49160d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f49160d, this.f49161e);
            }
            if (f49156i) {
                StringBuilder sb = new StringBuilder();
                sb.append("main await finish by ");
                sb.append(z ? "time's up" : "count down");
                m(sb.toString());
            }
            if (f49156i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e2) {
            if (f49156i) {
                m("main await finish by InterruptedException " + e2);
                e2.printStackTrace();
            }
            if (f49156i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        r(l);
        e(ConstantHelper.LOG_FINISH);
    }

    public final List<e> i() {
        ArrayList arrayList = new ArrayList();
        d.a.m0.a.v2.e1.a.c(new C0943a(arrayList), this.f49157a);
        return arrayList;
    }

    public float j() {
        return this.f49164h;
    }

    public final float k() {
        float h2 = this.f49163g.h("progress_granularity", 0.01f);
        if (h2 < 0.0f) {
            h2 = 0.0f;
        }
        if (h2 > 1.0f) {
            return 1.0f;
        }
        return h2;
    }

    @NonNull
    public final ExecutorService l(@NonNull List<e> list, @NonNull CountDownLatch countDownLatch) {
        ExecutorService executorService = this.f49158b;
        if (executorService == null || executorService.isShutdown() || this.f49158b.isTerminated()) {
            this.f49158b = null;
        }
        ExecutorService executorService2 = this.f49158b;
        if (executorService2 == null) {
            executorService2 = Executors.newCachedThreadPool();
        }
        d.a.m0.a.v2.e1.a.c(new b(this, countDownLatch, executorService2), list);
        return executorService2;
    }

    public final void n(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<e> list) {
        d dVar;
        long j;
        int i2;
        ReadableByteChannel readableByteChannel2 = readableByteChannel;
        List<e> list2 = list;
        float f2 = 0.0f;
        s(0.0f);
        float k = k();
        long k2 = this.f49163g.k(CloudStabilityUBCUtils.KEY_LENGTH);
        ByteBuffer allocate = ByteBuffer.allocate(this.f49159c);
        long j2 = 0;
        int i3 = 0;
        while (true) {
            try {
                try {
                    long read = readableByteChannel2.read(allocate);
                    if (read == -1) {
                        break;
                    }
                    j2 += read;
                    try {
                        allocate.flip();
                        d.a.m0.a.v2.e1.a.c(new c(this, allocate), list2);
                        int i4 = i3 + 1;
                        if (k2 > 0) {
                            float f3 = ((float) j2) / ((float) k2);
                            if (f3 < f2) {
                                f3 = 0.0f;
                            }
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = f3 - this.f49164h;
                            int round = Math.round(100.0f * f3);
                            i2 = i4;
                            StringBuilder sb = new StringBuilder();
                            int i5 = 0;
                            while (i5 < 100) {
                                sb.append(i5 > round ? "=" : "#");
                                i5++;
                            }
                            if (f49156i) {
                                j = k2;
                                m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j2)));
                            } else {
                                j = k2;
                            }
                            if (f4 > k) {
                                if (f49156i) {
                                    NumberFormat percentInstance = NumberFormat.getPercentInstance();
                                    m("pumping: updateProgress granularity:" + percentInstance.format(k) + " step:" + percentInstance.format(f4));
                                }
                                s(f3);
                            }
                        } else {
                            j = k2;
                            i2 = i4;
                        }
                        allocate.clear();
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        i3 = i2;
                        k2 = j;
                        f2 = 0.0f;
                    } catch (IOException e2) {
                        e = e2;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        if (f49156i) {
                            e.printStackTrace();
                        }
                        f(readableByteChannel2, "connected source");
                        dVar = new d(this);
                        d.a.m0.a.v2.e1.a.c(dVar, list2);
                        s(1.0f);
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        f(readableByteChannel2, "connected source");
                        d.a.m0.a.v2.e1.a.c(new d(this), list2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        long j3 = k2;
        if (f49156i) {
            m("pumping done: writeCount=" + i3 + " length: " + j3);
        }
        f(readableByteChannel, "connected source");
        dVar = new d(this);
        list2 = list;
        d.a.m0.a.v2.e1.a.c(dVar, list2);
        s(1.0f);
    }

    @NonNull
    public a o(int i2) {
        if (i2 < 1) {
            i2 = 8192;
        }
        this.f49159c = i2;
        return this;
    }

    public a p(d.a.m0.a.v2.e1.b<String> bVar) {
        this.f49162f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f49160d = j;
        this.f49161e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f49158b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f49158b = null;
    }

    public final void s(float f2) {
        if (f49156i) {
            m("updateProgress: progress=" + f2);
        }
        this.f49164h = f2;
        e("on_progress");
    }
}
