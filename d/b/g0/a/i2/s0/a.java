package d.b.g0.a.i2.s0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.b.g0.a.k;
import d.b.g0.a.y0.e.f.c;
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
    public static final boolean i = k.f45051a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f44768b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<String> f44772f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> f44767a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f44769c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f44770d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f44771e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f44773g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f44774h = 0.0f;

    /* renamed from: d.b.g0.a.i2.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0702a implements d.b.g0.a.i2.u0.b<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44775e;

        public C0702a(List list) {
            this.f44775e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) {
            try {
                this.f44775e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f44777e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f44778f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f44777e = countDownLatch;
            this.f44778f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f44777e);
            this.f44778f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f44779e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f44779e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f44783h.isOpen() && eVar.f44782g.isOpen()) {
                    this.f44779e.rewind();
                    eVar.f44783h.write(this.f44779e);
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
    public class d implements d.b.g0.a.i2.u0.b<e> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Pipe.SinkChannel sinkChannel = eVar.f44783h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.g0.a.i2.u0.b<Pipe.SourceChannel> f44780e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f44781f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f44782g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f44783h;
        public CountDownLatch i;
        public String j;

        public e(a aVar, d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f44780e = bVar;
            Pipe open = Pipe.open();
            this.f44781f = open;
            this.f44783h = open.sink();
            this.f44782g = this.f44781f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f44783h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f44782g;
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
                    this.f44780e.onCallback(this.f44782g);
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
            return "PipeLine: " + this.j + " consumer=" + this.f44780e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.b.g0.p.d.a(channel);
    }

    public static void m(String str) {
        if (i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.b.g0.a.i2.u0.b<Pipe.SourceChannel>... bVarArr) {
        this.f44767a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.b.g0.a.i2.u0.b<String> bVar = this.f44772f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f44773g.C(bundle);
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
                m("main await for timeout: " + this.f44771e.toMillis(this.f44770d));
            }
            boolean z = false;
            if (this.f44770d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f44770d, this.f44771e);
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
        d.b.g0.a.i2.u0.a.c(new C0702a(arrayList), this.f44767a);
        return arrayList;
    }

    public float j() {
        return this.f44774h;
    }

    public final float k() {
        float g2 = this.f44773g.g("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f44768b;
        if (executorService == null || executorService.isShutdown() || this.f44768b.isTerminated()) {
            this.f44768b = null;
        }
        ExecutorService executorService2 = this.f44768b;
        if (executorService2 == null) {
            executorService2 = Executors.newCachedThreadPool();
        }
        d.b.g0.a.i2.u0.a.c(new b(this, countDownLatch, executorService2), list);
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
        long j2 = this.f44773g.j("length");
        ByteBuffer allocate = ByteBuffer.allocate(this.f44769c);
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
                        d.b.g0.a.i2.u0.a.c(new c(this, allocate), list2);
                        int i4 = i3 + 1;
                        if (j2 > 0) {
                            float f3 = ((float) j3) / ((float) j2);
                            if (f3 < f2) {
                                f3 = 0.0f;
                            }
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = f3 - this.f44774h;
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
                        d.b.g0.a.i2.u0.a.c(dVar, list2);
                        s(1.0f);
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        f(readableByteChannel2, "connected source");
                        d.b.g0.a.i2.u0.a.c(new d(this), list2);
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
        d.b.g0.a.i2.u0.a.c(dVar, list2);
        s(1.0f);
    }

    @NonNull
    public a o(int i2) {
        if (i2 < 1) {
            i2 = 8192;
        }
        this.f44769c = i2;
        return this;
    }

    public a p(d.b.g0.a.i2.u0.b<String> bVar) {
        this.f44772f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f44770d = j;
        this.f44771e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f44768b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f44768b = null;
    }

    public final void s(float f2) {
        if (i) {
            m("updateProgress: progress=" + f2);
        }
        this.f44774h = f2;
        e("on_progress");
    }
}
