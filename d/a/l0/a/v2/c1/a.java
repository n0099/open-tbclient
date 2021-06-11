package d.a.l0.a.v2.c1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.l0.a.f1.e.f.c;
import d.a.l0.a.k;
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
    public static final boolean f49048i = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f49050b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<String> f49054f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<Pipe.SourceChannel>> f49049a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f49051c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f49052d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f49053e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f49055g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f49056h = 0.0f;

    /* renamed from: d.a.l0.a.v2.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0940a implements d.a.l0.a.v2.e1.b<d.a.l0.a.v2.e1.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f49057e;

        public C0940a(List list) {
            this.f49057e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.v2.e1.b<Pipe.SourceChannel> bVar) {
            try {
                this.f49057e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.f49048i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f49059e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f49060f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f49059e = countDownLatch;
            this.f49060f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f49059e);
            this.f49060f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f49061e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f49061e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f49065h.isOpen() && eVar.f49064g.isOpen()) {
                    this.f49061e.rewind();
                    eVar.f49065h.write(this.f49061e);
                }
            } catch (IOException e2) {
                if (a.f49048i) {
                    a.m("connect e:" + e2 + " line: " + eVar);
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.l0.a.v2.e1.b<e> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Pipe.SinkChannel sinkChannel = eVar.f49065h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.l0.a.v2.e1.b<Pipe.SourceChannel> f49062e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f49063f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f49064g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f49065h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f49066i;
        public String j;

        public e(a aVar, d.a.l0.a.v2.e1.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f49062e = bVar;
            Pipe open = Pipe.open();
            this.f49063f = open;
            this.f49065h = open.sink();
            this.f49064g = this.f49063f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f49065h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f49064g;
            a.f(sourceChannel, "source for " + toString());
        }

        public final void e() {
            CountDownLatch countDownLatch = this.f49066i;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public final void f(CountDownLatch countDownLatch) {
            this.f49066i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j = Thread.currentThread().toString();
            if (a.f49048i) {
                a.m(" >> run on " + toString());
            }
            try {
                try {
                    this.f49062e.onCallback(this.f49064g);
                } catch (Exception e2) {
                    if (a.f49048i) {
                        e2.printStackTrace();
                        a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                    }
                }
                if (a.f49048i) {
                    a.m("countdown by end -> " + toString());
                }
                e();
            } finally {
                d();
            }
        }

        public String toString() {
            return "PipeLine: " + this.j + " consumer=" + this.f49062e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.a.l0.t.d.d(channel);
    }

    public static void m(String str) {
        if (f49048i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.a.l0.a.v2.e1.b<Pipe.SourceChannel>... bVarArr) {
        this.f49049a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.a.l0.a.v2.e1.b<String> bVar = this.f49054f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f49055g.D(bundle);
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
        if (f49048i) {
            m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            if (f49048i) {
                m("main await for timeout: " + this.f49053e.toMillis(this.f49052d));
            }
            boolean z = false;
            if (this.f49052d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f49052d, this.f49053e);
            }
            if (f49048i) {
                StringBuilder sb = new StringBuilder();
                sb.append("main await finish by ");
                sb.append(z ? "time's up" : "count down");
                m(sb.toString());
            }
            if (f49048i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e2) {
            if (f49048i) {
                m("main await finish by InterruptedException " + e2);
                e2.printStackTrace();
            }
            if (f49048i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        r(l);
        e("finish");
    }

    public final List<e> i() {
        ArrayList arrayList = new ArrayList();
        d.a.l0.a.v2.e1.a.c(new C0940a(arrayList), this.f49049a);
        return arrayList;
    }

    public float j() {
        return this.f49056h;
    }

    public final float k() {
        float h2 = this.f49055g.h("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f49050b;
        if (executorService == null || executorService.isShutdown() || this.f49050b.isTerminated()) {
            this.f49050b = null;
        }
        ExecutorService executorService2 = this.f49050b;
        if (executorService2 == null) {
            executorService2 = Executors.newCachedThreadPool();
        }
        d.a.l0.a.v2.e1.a.c(new b(this, countDownLatch, executorService2), list);
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
        long k2 = this.f49055g.k(CloudStabilityUBCUtils.KEY_LENGTH);
        ByteBuffer allocate = ByteBuffer.allocate(this.f49051c);
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
                        d.a.l0.a.v2.e1.a.c(new c(this, allocate), list2);
                        int i4 = i3 + 1;
                        if (k2 > 0) {
                            float f3 = ((float) j2) / ((float) k2);
                            if (f3 < f2) {
                                f3 = 0.0f;
                            }
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = f3 - this.f49056h;
                            int round = Math.round(100.0f * f3);
                            i2 = i4;
                            StringBuilder sb = new StringBuilder();
                            int i5 = 0;
                            while (i5 < 100) {
                                sb.append(i5 > round ? "=" : "#");
                                i5++;
                            }
                            if (f49048i) {
                                j = k2;
                                m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j2)));
                            } else {
                                j = k2;
                            }
                            if (f4 > k) {
                                if (f49048i) {
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
                        if (f49048i) {
                            e.printStackTrace();
                        }
                        f(readableByteChannel2, "connected source");
                        dVar = new d(this);
                        d.a.l0.a.v2.e1.a.c(dVar, list2);
                        s(1.0f);
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        f(readableByteChannel2, "connected source");
                        d.a.l0.a.v2.e1.a.c(new d(this), list2);
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
        if (f49048i) {
            m("pumping done: writeCount=" + i3 + " length: " + j3);
        }
        f(readableByteChannel, "connected source");
        dVar = new d(this);
        list2 = list;
        d.a.l0.a.v2.e1.a.c(dVar, list2);
        s(1.0f);
    }

    @NonNull
    public a o(int i2) {
        if (i2 < 1) {
            i2 = 8192;
        }
        this.f49051c = i2;
        return this;
    }

    public a p(d.a.l0.a.v2.e1.b<String> bVar) {
        this.f49054f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f49052d = j;
        this.f49053e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f49050b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f49050b = null;
    }

    public final void s(float f2) {
        if (f49048i) {
            m("updateProgress: progress=" + f2);
        }
        this.f49056h = f2;
        e("on_progress");
    }
}
