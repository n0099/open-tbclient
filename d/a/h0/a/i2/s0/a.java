package d.a.h0.a.i2.s0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import d.a.h0.a.k;
import d.a.h0.a.y0.e.f.c;
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
    public static final boolean f42806i = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f42808b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.h0.a.i2.u0.b<String> f42812f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.a.h0.a.i2.u0.b<Pipe.SourceChannel>> f42807a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f42809c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f42810d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f42811e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f42813g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f42814h = 0.0f;

    /* renamed from: d.a.h0.a.i2.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0673a implements d.a.h0.a.i2.u0.b<d.a.h0.a.i2.u0.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f42815e;

        public C0673a(List list) {
            this.f42815e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.i2.u0.b<Pipe.SourceChannel> bVar) {
            try {
                this.f42815e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.f42806i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f42817e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f42818f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f42817e = countDownLatch;
            this.f42818f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f42817e);
            this.f42818f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.h0.a.i2.u0.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f42819e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f42819e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f42823h.isOpen() && eVar.f42822g.isOpen()) {
                    this.f42819e.rewind();
                    eVar.f42823h.write(this.f42819e);
                }
            } catch (IOException e2) {
                if (a.f42806i) {
                    a.m("connect e:" + e2 + " line: " + eVar);
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.h0.a.i2.u0.b<e> {
        public d(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Pipe.SinkChannel sinkChannel = eVar.f42823h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.h0.a.i2.u0.b<Pipe.SourceChannel> f42820e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f42821f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f42822g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f42823h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f42824i;
        public String j;

        public e(a aVar, d.a.h0.a.i2.u0.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f42820e = bVar;
            Pipe open = Pipe.open();
            this.f42821f = open;
            this.f42823h = open.sink();
            this.f42822g = this.f42821f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f42823h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f42822g;
            a.f(sourceChannel, "source for " + toString());
        }

        public final void e() {
            CountDownLatch countDownLatch = this.f42824i;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public final void f(CountDownLatch countDownLatch) {
            this.f42824i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j = Thread.currentThread().toString();
            if (a.f42806i) {
                a.m(" >> run on " + toString());
            }
            try {
                try {
                    this.f42820e.onCallback(this.f42822g);
                } catch (Exception e2) {
                    if (a.f42806i) {
                        e2.printStackTrace();
                        a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                    }
                }
                if (a.f42806i) {
                    a.m("countdown by end -> " + toString());
                }
                e();
            } finally {
                d();
            }
        }

        public String toString() {
            return "PipeLine: " + this.j + " consumer=" + this.f42820e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.a.h0.p.d.a(channel);
    }

    public static void m(String str) {
        if (f42806i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.a.h0.a.i2.u0.b<Pipe.SourceChannel>... bVarArr) {
        this.f42807a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.a.h0.a.i2.u0.b<String> bVar = this.f42812f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f42813g.C(bundle);
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
        if (f42806i) {
            m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            if (f42806i) {
                m("main await for timeout: " + this.f42811e.toMillis(this.f42810d));
            }
            boolean z = false;
            if (this.f42810d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f42810d, this.f42811e);
            }
            if (f42806i) {
                StringBuilder sb = new StringBuilder();
                sb.append("main await finish by ");
                sb.append(z ? "time's up" : "count down");
                m(sb.toString());
            }
            if (f42806i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e2) {
            if (f42806i) {
                m("main await finish by InterruptedException " + e2);
                e2.printStackTrace();
            }
            if (f42806i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        r(l);
        e("finish");
    }

    public final List<e> i() {
        ArrayList arrayList = new ArrayList();
        d.a.h0.a.i2.u0.a.c(new C0673a(arrayList), this.f42807a);
        return arrayList;
    }

    public float j() {
        return this.f42814h;
    }

    public final float k() {
        float g2 = this.f42813g.g("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f42808b;
        if (executorService == null || executorService.isShutdown() || this.f42808b.isTerminated()) {
            this.f42808b = null;
        }
        ExecutorService executorService2 = this.f42808b;
        if (executorService2 == null) {
            executorService2 = Executors.newCachedThreadPool();
        }
        d.a.h0.a.i2.u0.a.c(new b(this, countDownLatch, executorService2), list);
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
        long j2 = this.f42813g.j(CloudStabilityUBCUtils.KEY_LENGTH);
        ByteBuffer allocate = ByteBuffer.allocate(this.f42809c);
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
                        d.a.h0.a.i2.u0.a.c(new c(this, allocate), list2);
                        int i4 = i3 + 1;
                        if (j2 > 0) {
                            float f3 = ((float) j3) / ((float) j2);
                            if (f3 < f2) {
                                f3 = 0.0f;
                            }
                            if (f3 > 1.0f) {
                                f3 = 1.0f;
                            }
                            float f4 = f3 - this.f42814h;
                            int round = Math.round(100.0f * f3);
                            i2 = i4;
                            StringBuilder sb = new StringBuilder();
                            int i5 = 0;
                            while (i5 < 100) {
                                sb.append(i5 > round ? "=" : "#");
                                i5++;
                            }
                            if (f42806i) {
                                j = j2;
                                m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j3)));
                            } else {
                                j = j2;
                            }
                            if (f4 > k) {
                                if (f42806i) {
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
                        if (f42806i) {
                            e.printStackTrace();
                        }
                        f(readableByteChannel2, "connected source");
                        dVar = new d(this);
                        d.a.h0.a.i2.u0.a.c(dVar, list2);
                        s(1.0f);
                    } catch (Throwable th) {
                        th = th;
                        readableByteChannel2 = readableByteChannel;
                        list2 = list;
                        f(readableByteChannel2, "connected source");
                        d.a.h0.a.i2.u0.a.c(new d(this), list2);
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
        if (f42806i) {
            m("pumping done: writeCount=" + i3 + " length: " + j4);
        }
        f(readableByteChannel, "connected source");
        dVar = new d(this);
        list2 = list;
        d.a.h0.a.i2.u0.a.c(dVar, list2);
        s(1.0f);
    }

    @NonNull
    public a o(int i2) {
        if (i2 < 1) {
            i2 = 8192;
        }
        this.f42809c = i2;
        return this;
    }

    public a p(d.a.h0.a.i2.u0.b<String> bVar) {
        this.f42812f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f42810d = j;
        this.f42811e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f42808b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f42808b = null;
    }

    public final void s(float f2) {
        if (f42806i) {
            m("updateProgress: progress=" + f2);
        }
        this.f42814h = f2;
        e("on_progress");
    }
}
