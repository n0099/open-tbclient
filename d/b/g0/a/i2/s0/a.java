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
    public static final boolean i = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f44767b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<String> f44771f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> f44766a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f44768c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f44769d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f44770e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f44772g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f44773h = 0.0f;

    /* renamed from: d.b.g0.a.i2.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0701a implements d.b.g0.a.i2.u0.b<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44774e;

        public C0701a(List list) {
            this.f44774e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) {
            try {
                this.f44774e.add(new e(a.this, bVar));
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
        public final /* synthetic */ CountDownLatch f44776e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f44777f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f44776e = countDownLatch;
            this.f44777f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f44776e);
            this.f44777f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f44778e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f44778e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f44782h.isOpen() && eVar.f44781g.isOpen()) {
                    this.f44778e.rewind();
                    eVar.f44782h.write(this.f44778e);
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
            Pipe.SinkChannel sinkChannel = eVar.f44782h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.g0.a.i2.u0.b<Pipe.SourceChannel> f44779e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f44780f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f44781g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f44782h;
        public CountDownLatch i;
        public String j;

        public e(a aVar, d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f44779e = bVar;
            Pipe open = Pipe.open();
            this.f44780f = open;
            this.f44782h = open.sink();
            this.f44781g = this.f44780f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f44782h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f44781g;
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
                    this.f44779e.onCallback(this.f44781g);
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
            return "PipeLine: " + this.j + " consumer=" + this.f44779e.toString();
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
        this.f44766a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.b.g0.a.i2.u0.b<String> bVar = this.f44771f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f44772g.C(bundle);
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
                m("main await for timeout: " + this.f44770e.toMillis(this.f44769d));
            }
            boolean z = false;
            if (this.f44769d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f44769d, this.f44770e);
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
        d.b.g0.a.i2.u0.a.c(new C0701a(arrayList), this.f44766a);
        return arrayList;
    }

    public float j() {
        return this.f44773h;
    }

    public final float k() {
        float g2 = this.f44772g.g("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f44767b;
        if (executorService == null || executorService.isShutdown() || this.f44767b.isTerminated()) {
            this.f44767b = null;
        }
        ExecutorService executorService2 = this.f44767b;
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
        long j2 = this.f44772g.j("length");
        ByteBuffer allocate = ByteBuffer.allocate(this.f44768c);
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
                            float f4 = f3 - this.f44773h;
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
        this.f44768c = i2;
        return this;
    }

    public a p(d.b.g0.a.i2.u0.b<String> bVar) {
        this.f44771f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f44769d = j;
        this.f44770e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f44767b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f44767b = null;
    }

    public final void s(float f2) {
        if (i) {
            m("updateProgress: progress=" + f2);
        }
        this.f44773h = f2;
        e("on_progress");
    }
}
