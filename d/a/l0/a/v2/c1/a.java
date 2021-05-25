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
    public static final boolean f45374i = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f45376b;

    /* renamed from: f  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<String> f45380f;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.a.l0.a.v2.e1.b<Pipe.SourceChannel>> f45375a = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public int f45377c = 8192;

    /* renamed from: d  reason: collision with root package name */
    public long f45378d = -1;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f45379e = TimeUnit.NANOSECONDS;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f45381g = new c.a();

    /* renamed from: h  reason: collision with root package name */
    public float f45382h = 0.0f;

    /* renamed from: d.a.l0.a.v2.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0884a implements d.a.l0.a.v2.e1.b<d.a.l0.a.v2.e1.b<Pipe.SourceChannel>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45383e;

        public C0884a(List list) {
            this.f45383e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.v2.e1.b<Pipe.SourceChannel> bVar) {
            try {
                this.f45383e.add(new e(a.this, bVar));
            } catch (IOException e2) {
                if (a.f45374i) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f45385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f45386f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            this.f45385e = countDownLatch;
            this.f45386f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            eVar.f(this.f45385e);
            this.f45386f.submit(eVar);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<e> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f45387e;

        public c(a aVar, ByteBuffer byteBuffer) {
            this.f45387e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            try {
                if (eVar.f45391h.isOpen() && eVar.f45390g.isOpen()) {
                    this.f45387e.rewind();
                    eVar.f45391h.write(this.f45387e);
                }
            } catch (IOException e2) {
                if (a.f45374i) {
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
            Pipe.SinkChannel sinkChannel = eVar.f45391h;
            a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final d.a.l0.a.v2.e1.b<Pipe.SourceChannel> f45388e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f45389f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f45390g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f45391h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f45392i;
        public String j;

        public e(a aVar, d.a.l0.a.v2.e1.b<Pipe.SourceChannel> bVar) throws IOException {
            this.f45388e = bVar;
            Pipe open = Pipe.open();
            this.f45389f = open;
            this.f45391h = open.sink();
            this.f45390g = this.f45389f.source();
        }

        public final void d() {
            Pipe.SinkChannel sinkChannel = this.f45391h;
            a.f(sinkChannel, "sink for " + toString());
            Pipe.SourceChannel sourceChannel = this.f45390g;
            a.f(sourceChannel, "source for " + toString());
        }

        public final void e() {
            CountDownLatch countDownLatch = this.f45392i;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

        public final void f(CountDownLatch countDownLatch) {
            this.f45392i = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.j = Thread.currentThread().toString();
            if (a.f45374i) {
                a.m(" >> run on " + toString());
            }
            try {
                try {
                    this.f45388e.onCallback(this.f45390g);
                } catch (Exception e2) {
                    if (a.f45374i) {
                        e2.printStackTrace();
                        a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                    }
                }
                if (a.f45374i) {
                    a.m("countdown by end -> " + toString());
                }
                e();
            } finally {
                d();
            }
        }

        public String toString() {
            return "PipeLine: " + this.j + " consumer=" + this.f45388e.toString();
        }
    }

    public static void f(Channel channel, String str) {
        if (channel == null || !channel.isOpen()) {
            return;
        }
        d.a.l0.t.d.d(channel);
    }

    public static void m(String str) {
        if (f45374i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.a.l0.a.v2.e1.b<Pipe.SourceChannel>... bVarArr) {
        this.f45375a.addAll(Arrays.asList(bVarArr));
        return this;
    }

    public final void e(String str) {
        d.a.l0.a.v2.e1.b<String> bVar = this.f45380f;
        if (bVar != null) {
            bVar.onCallback(str);
        }
    }

    public a g(Bundle bundle) {
        this.f45381g.D(bundle);
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
        if (f45374i) {
            m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        try {
            if (f45374i) {
                m("main await for timeout: " + this.f45379e.toMillis(this.f45378d));
            }
            boolean z = false;
            if (this.f45378d < 0) {
                countDownLatch.await();
            } else {
                z = !countDownLatch.await(this.f45378d, this.f45379e);
            }
            if (f45374i) {
                StringBuilder sb = new StringBuilder();
                sb.append("main await finish by ");
                sb.append(z ? "time's up" : "count down");
                m(sb.toString());
            }
            if (f45374i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (InterruptedException e2) {
            if (f45374i) {
                m("main await finish by InterruptedException " + e2);
                e2.printStackTrace();
            }
            if (f45374i) {
                m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
        r(l);
        e("finish");
    }

    public final List<e> i() {
        ArrayList arrayList = new ArrayList();
        d.a.l0.a.v2.e1.a.c(new C0884a(arrayList), this.f45375a);
        return arrayList;
    }

    public float j() {
        return this.f45382h;
    }

    public final float k() {
        float h2 = this.f45381g.h("progress_granularity", 0.01f);
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
        ExecutorService executorService = this.f45376b;
        if (executorService == null || executorService.isShutdown() || this.f45376b.isTerminated()) {
            this.f45376b = null;
        }
        ExecutorService executorService2 = this.f45376b;
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
        long k2 = this.f45381g.k(CloudStabilityUBCUtils.KEY_LENGTH);
        ByteBuffer allocate = ByteBuffer.allocate(this.f45377c);
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
                            float f4 = f3 - this.f45382h;
                            int round = Math.round(100.0f * f3);
                            i2 = i4;
                            StringBuilder sb = new StringBuilder();
                            int i5 = 0;
                            while (i5 < 100) {
                                sb.append(i5 > round ? "=" : "#");
                                i5++;
                            }
                            if (f45374i) {
                                j = k2;
                                m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j2)));
                            } else {
                                j = k2;
                            }
                            if (f4 > k) {
                                if (f45374i) {
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
                        if (f45374i) {
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
        if (f45374i) {
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
        this.f45377c = i2;
        return this;
    }

    public a p(d.a.l0.a.v2.e1.b<String> bVar) {
        this.f45380f = bVar;
        return this;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        if (j < 0) {
            j = -1;
        }
        this.f45378d = j;
        this.f45379e = timeUnit;
        return this;
    }

    public final void r(@NonNull ExecutorService executorService) {
        if (executorService != this.f45376b && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        this.f45376b = null;
    }

    public final void s(float f2) {
        if (f45374i) {
            m("updateProgress: progress=" + f2);
        }
        this.f45382h = f2;
        e("on_progress");
    }
}
