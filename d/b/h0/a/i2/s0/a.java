package d.b.h0.a.i2.s0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.h0.a.k;
import d.b.h0.a.y0.e.f.c;
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
    public static final boolean i = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f45489b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.a.i2.u0.b<String> f45493f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.h0.a.i2.u0.b<Pipe.SourceChannel>> f45488a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f45490c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f45491d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f45492e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f45494g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f45495h = 0.0f;

    /* renamed from: d.b.h0.a.i2.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0734a implements d.b.h0.a.i2.u0.b<d.b.h0.a.i2.u0.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45496e;

        public C0734a(List list) {
            this.f45496e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.i2.u0.b<Pipe.SourceChannel> bVar) {
            try {
                this.f45496e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f45498e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f45499f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f45498e = countDownLatch;
            this.f45499f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f45498e);
            this.f45499f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f45500e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f45500e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f45504h.isOpen() && eVar.f45503g.isOpen()) {
                    this.f45500e.rewind();
                    eVar.f45504h.write(this.f45500e);
                }
            } catch (IOException e2) {
                if (a.i) {
                    a.m("connect e:" + e2 + " line: " + eVar);
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.h0.a.i2.u0.b<e> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Pipe.SinkChannel sinkChannel = eVar.f45504h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.h0.a.i2.u0.b<Pipe.SourceChannel> f45501e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f45502f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f45503g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f45504h;
        public CountDownLatch i;
        public String j;

        public e(a aVar, d.b.h0.a.i2.u0.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f45501e = bVar;
            Pipe open = Pipe.open();
            this.f45502f = open;
            this.f45504h = open.sink();
            this.f45503g = this.f45502f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f45504h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f45503g;
            a.f(sourceChannel, "source for " + toString());
        }

        public final void e() {
            CountDownLatch countDownLatch = this.i;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public final void f(CountDownLatch countDownLatch) {
            this.i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j = Thread.currentThread().toString();
            if (a.i) {
                a.m(" >> run on " + toString());
            }
            try {
                try {
                    this.f45501e.onCallback(this.f45503g);
                } catch (Exception e2) {
                    if (a.i) {
                        e2.printStackTrace();
                        a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                    }
                }
                if (a.i) {
                    a.m("countdown by end -> " + toString());
                }
                e();
            } finally {
                d();
            }
        }

        public String toString() {
            return "PipeLine: " + this.j + " consumer=" + this.f45501e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.b.h0.p.d.a(channel);
    }

    public static void m(String str) {
        if (i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.b.h0.a.i2.u0.b<Pipe.SourceChannel>... bVarArr) {
        this.f45488a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.b.h0.a.i2.u0.b<String> bVar = this.f45493f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f45494g.C(bundle);
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
        if (i) {
            m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            if (i) {
                m("main await for timeout: " + this.f45492e.toMillis(this.f45491d));
            }
            boolean z = false;
            if (this.f45491d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f45491d, this.f45492e);
            }
            if (i) {
                StringBuilder sb = new StringBuilder();
                sb.append("main await finish by ");
                sb.append(z ? "time's up" : "count down");
                m(sb.toString());
            }
            if (i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e2) {
            if (i) {
                m("main await finish by InterruptedException " + e2);
                e2.printStackTrace();
            }
            if (i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        r(l);
        e("finish");
    }

    public final List<e> i() {
        ArrayList arrayList = new ArrayList();
        d.b.h0.a.i2.u0.a.c(new C0734a(arrayList), this.f45488a);
        return arrayList;
    }

    public float j() {
        return this.f45495h;
    }

    public final float k() {
        float g2 = this.f45494g.g("progress_granularity", 0.01f);
        if (g2 < 0.0f) {
            g2 = 0.0f;
        }
        if (g2 > 1.0f) {
            return 1.0f;
        }
        return g2;
    }

    @NonNull
    public final ExecutorService l(@NonNull List<e> list, @NonNull CountDownLatch countDownLatch) {
        ExecutorService executorService = this.f45489b;
        if (executorService == null || executorService.isShutdown() || this.f45489b.isTerminated()) {
            this.f45489b = null;
        }
        ExecutorService executorService2 = this.f45489b;
        if (executorService2 == null) {
            executorService2 = Executors.newCachedThreadPool();
        }
        d.b.h0.a.i2.u0.a.c(new b(this, countDownLatch, executorService2), list);
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
        long j2 = this.f45494g.j("length");
        ByteBuffer allocate = ByteBuffer.allocate(this.f45490c);
        long j3 = 0;
        int i3 = 0;
        while (true) {
            try {
                try {
                    long read = readableByteChannel2.read(allocate);
                    if (read == -1) {
                        break;
                    }
                    j3 += read;
                    try {
                        allocate.flip();
                        d.b.h0.a.i2.u0.a.c(new c(this, allocate), list2);
                        int i4 = i3 + 1;
                        if (j2 > 0) {
                            float f3 = ((float) j3) / ((float) j2);
                            if (f3 < f2) {
                                f3 = 0.0f;
                            }
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = f3 - this.f45495h;
                            int round = Math.round(100.0f * f3);
                            i2 = i4;
                            StringBuilder sb = new StringBuilder();
                            int i5 = 0;
                            while (i5 < 100) {
                                sb.append(i5 > round ? "=" : "#");
                                i5++;
                            }
                            if (i) {
                                j = j2;
                                m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j3)));
                            } else {
                                j = j2;
                            }
                            if (f4 > k) {
                                if (i) {
                                    NumberFormat percentInstance = NumberFormat.getPercentInstance();
                                    m("pumping: updateProgress granularity:" + percentInstance.format(k) + " step:" + percentInstance.format(f4));
                                }
                                s(f3);
                            }
                        } else {
                            j = j2;
                            i2 = i4;
                        }
                        allocate.clear();
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        i3 = i2;
                        j2 = j;
                        f2 = 0.0f;
                    } catch (IOException e2) {
                        e = e2;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        if (i) {
                            e.printStackTrace();
                        }
                        f(readableByteChannel2, "connected source");
                        dVar = new d(this);
                        d.b.h0.a.i2.u0.a.c(dVar, list2);
                        s(1.0f);
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        f(readableByteChannel2, "connected source");
                        d.b.h0.a.i2.u0.a.c(new d(this), list2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        }
        long j4 = j2;
        if (i) {
            m("pumping done: writeCount=" + i3 + " length: " + j4);
        }
        f(readableByteChannel, "connected source");
        dVar = new d(this);
        list2 = list;
        d.b.h0.a.i2.u0.a.c(dVar, list2);
        s(1.0f);
    }

    @NonNull
    public a o(int i2) {
        if (i2 < 1) {
            i2 = 8192;
        }
        this.f45490c = i2;
        return this;
    }

    public a p(d.b.h0.a.i2.u0.b<String> bVar) {
        this.f45493f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f45491d = j;
        this.f45492e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f45489b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f45489b = null;
    }

    public final void s(float f2) {
        if (i) {
            m("updateProgress: progress=" + f2);
        }
        this.f45495h = f2;
        e("on_progress");
    }
}
