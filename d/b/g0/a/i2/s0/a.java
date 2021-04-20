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
    public static final boolean i = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f45160b;

    /* renamed from: f  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<String> f45164f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> f45159a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f45161c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f45162d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f45163e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f45165g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f45166h = 0.0f;

    /* renamed from: d.b.g0.a.i2.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0714a implements d.b.g0.a.i2.u0.b<d.b.g0.a.i2.u0.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45167e;

        public C0714a(List list) {
            this.f45167e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) {
            try {
                this.f45167e.add(new e(a.this, bVar));
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
        public final /* synthetic */ CountDownLatch f45169e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f45170f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f45169e = countDownLatch;
            this.f45170f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f45169e);
            this.f45170f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f45171e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f45171e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f45175h.isOpen() && eVar.f45174g.isOpen()) {
                    this.f45171e.rewind();
                    eVar.f45175h.write(this.f45171e);
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
            Pipe.SinkChannel sinkChannel = eVar.f45175h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.b.g0.a.i2.u0.b<Pipe.SourceChannel> f45172e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f45173f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f45174g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f45175h;
        public CountDownLatch i;
        public String j;

        public e(a aVar, d.b.g0.a.i2.u0.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f45172e = bVar;
            Pipe open = Pipe.open();
            this.f45173f = open;
            this.f45175h = open.sink();
            this.f45174g = this.f45173f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f45175h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f45174g;
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
                    this.f45172e.onCallback(this.f45174g);
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
            return "PipeLine: " + this.j + " consumer=" + this.f45172e.toString();
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
        this.f45159a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.b.g0.a.i2.u0.b<String> bVar = this.f45164f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f45165g.C(bundle);
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
                m("main await for timeout: " + this.f45163e.toMillis(this.f45162d));
            }
            boolean z = false;
            if (this.f45162d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f45162d, this.f45163e);
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
        d.b.g0.a.i2.u0.a.c(new C0714a(arrayList), this.f45159a);
        return arrayList;
    }

    public float j() {
        return this.f45166h;
    }

    public final float k() {
        float g2 = this.f45165g.g("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f45160b;
        if (executorService == null || executorService.isShutdown() || this.f45160b.isTerminated()) {
            this.f45160b = null;
        }
        ExecutorService executorService2 = this.f45160b;
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
        long j2 = this.f45165g.j("length");
        ByteBuffer allocate = ByteBuffer.allocate(this.f45161c);
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
                            float f4 = f3 - this.f45166h;
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
        this.f45161c = i2;
        return this;
    }

    public a p(d.b.g0.a.i2.u0.b<String> bVar) {
        this.f45164f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f45162d = j;
        this.f45163e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f45160b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f45160b = null;
    }

    public final void s(float f2) {
        if (i) {
            m("updateProgress: progress=" + f2);
        }
        this.f45166h = f2;
        e("on_progress");
    }
}
