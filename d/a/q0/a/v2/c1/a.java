package d.a.q0.a.v2.c1;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.face.platform.common.ConstantHelper;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.f1.e.f.c;
import d.a.q0.a.k;
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
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f51302i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Set<d.a.q0.a.v2.e1.b<Pipe.SourceChannel>> f51303a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f51304b;

    /* renamed from: c  reason: collision with root package name */
    public int f51305c;

    /* renamed from: d  reason: collision with root package name */
    public long f51306d;

    /* renamed from: e  reason: collision with root package name */
    public TimeUnit f51307e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.q0.a.v2.e1.b<String> f51308f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a f51309g;

    /* renamed from: h  reason: collision with root package name */
    public float f51310h;

    /* renamed from: d.a.q0.a.v2.c1.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1003a implements d.a.q0.a.v2.e1.b<d.a.q0.a.v2.e1.b<Pipe.SourceChannel>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f51311e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f51312f;

        public C1003a(a aVar, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51312f = aVar;
            this.f51311e = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.v2.e1.b<Pipe.SourceChannel> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                try {
                    this.f51311e.add(new e(this.f51312f, bVar));
                } catch (IOException e2) {
                    if (a.f51302i) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.v2.e1.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f51313e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ExecutorService f51314f;

        public b(a aVar, CountDownLatch countDownLatch, ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, countDownLatch, executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51313e = countDownLatch;
            this.f51314f = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                eVar.f(this.f51313e);
                this.f51314f.submit(eVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.v2.e1.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f51315e;

        public c(a aVar, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51315e = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                try {
                    if (eVar.f51319h.isOpen() && eVar.f51318g.isOpen()) {
                        this.f51315e.rewind();
                        eVar.f51319h.write(this.f51315e);
                    }
                } catch (IOException e2) {
                    if (a.f51302i) {
                        a.m("connect e:" + e2 + " line: " + eVar);
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.a.v2.e1.b<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
                Pipe.SinkChannel sinkChannel = eVar.f51319h;
                a.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final d.a.q0.a.v2.e1.b<Pipe.SourceChannel> f51316e;

        /* renamed from: f  reason: collision with root package name */
        public final Pipe f51317f;

        /* renamed from: g  reason: collision with root package name */
        public final Pipe.SourceChannel f51318g;

        /* renamed from: h  reason: collision with root package name */
        public final Pipe.SinkChannel f51319h;

        /* renamed from: i  reason: collision with root package name */
        public CountDownLatch f51320i;
        public String j;

        public e(a aVar, d.a.q0.a.v2.e1.b<Pipe.SourceChannel> bVar) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51316e = bVar;
            Pipe open = Pipe.open();
            this.f51317f = open;
            this.f51319h = open.sink();
            this.f51318g = this.f51317f.source();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Pipe.SinkChannel sinkChannel = this.f51319h;
                a.f(sinkChannel, "sink for " + toString());
                Pipe.SourceChannel sourceChannel = this.f51318g;
                a.f(sourceChannel, "source for " + toString());
            }
        }

        public final void e() {
            CountDownLatch countDownLatch;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (countDownLatch = this.f51320i) == null) {
                return;
            }
            countDownLatch.countDown();
        }

        public final void f(CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, countDownLatch) == null) {
                this.f51320i = countDownLatch;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.j = Thread.currentThread().toString();
                if (a.f51302i) {
                    a.m(" >> run on " + toString());
                }
                try {
                    try {
                        this.f51316e.onCallback(this.f51318g);
                    } catch (Exception e2) {
                        if (a.f51302i) {
                            e2.printStackTrace();
                            a.m("catch Exception on " + toString() + " :\n  " + e2.toString());
                        }
                    }
                    if (a.f51302i) {
                        a.m("countdown by end -> " + toString());
                    }
                    e();
                } finally {
                    d();
                }
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "PipeLine: " + this.j + " consumer=" + this.f51316e.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(793963681, "Ld/a/q0/a/v2/c1/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(793963681, "Ld/a/q0/a/v2/c1/a;");
                return;
            }
        }
        f51302i = k.f49133a;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f51303a = new HashSet();
        this.f51305c = 8192;
        this.f51306d = -1L;
        this.f51307e = TimeUnit.NANOSECONDS;
        this.f51309g = new c.a();
        this.f51310h = 0.0f;
    }

    public static void f(Channel channel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, channel, str) == null) && channel != null && channel.isOpen()) {
            d.a.q0.t.d.d(channel);
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) && f51302i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public a d(@NonNull d.a.q0.a.v2.e1.b<Pipe.SourceChannel>... bVarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVarArr)) == null) {
            this.f51303a.addAll(Arrays.asList(bVarArr));
            return this;
        }
        return (a) invokeL.objValue;
    }

    public final void e(String str) {
        d.a.q0.a.v2.e1.b<String> bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (bVar = this.f51308f) == null) {
            return;
        }
        bVar.onCallback(str);
    }

    public a g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.f51309g.D(bundle);
            return this;
        }
        return (a) invokeL.objValue;
    }

    public synchronized void h(ReadableByteChannel readableByteChannel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, readableByteChannel) == null) {
            synchronized (this) {
                e("start");
                long currentTimeMillis = System.currentTimeMillis();
                List<e> i2 = i();
                CountDownLatch countDownLatch = new CountDownLatch(i2.size());
                ExecutorService l = l(i2, countDownLatch);
                n(readableByteChannel, i2);
                e("pump_finish");
                if (f51302i) {
                    m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                try {
                    if (f51302i) {
                        m("main await for timeout: " + this.f51307e.toMillis(this.f51306d));
                    }
                    boolean z = false;
                    if (this.f51306d < 0) {
                        countDownLatch.await();
                    } else {
                        z = !countDownLatch.await(this.f51306d, this.f51307e);
                    }
                    if (f51302i) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("main await finish by ");
                        sb.append(z ? "time's up" : "count down");
                        m(sb.toString());
                    }
                    if (f51302i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                } catch (InterruptedException e2) {
                    if (f51302i) {
                        m("main await finish by InterruptedException " + e2);
                        e2.printStackTrace();
                    }
                    if (f51302i) {
                        m("all done: " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                r(l);
                e(ConstantHelper.LOG_FINISH);
            }
        }
    }

    public final List<e> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            d.a.q0.a.v2.e1.a.c(new C1003a(this, arrayList), this.f51303a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f51310h : invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float h2 = this.f51309g.h("progress_granularity", 0.01f);
            if (h2 < 0.0f) {
                h2 = 0.0f;
            }
            if (h2 > 1.0f) {
                return 1.0f;
            }
            return h2;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public final ExecutorService l(@NonNull List<e> list, @NonNull CountDownLatch countDownLatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, countDownLatch)) == null) {
            ExecutorService executorService = this.f51304b;
            if (executorService == null || executorService.isShutdown() || this.f51304b.isTerminated()) {
                this.f51304b = null;
            }
            ExecutorService executorService2 = this.f51304b;
            if (executorService2 == null) {
                executorService2 = Executors.newCachedThreadPool();
            }
            d.a.q0.a.v2.e1.a.c(new b(this, countDownLatch, executorService2), list);
            return executorService2;
        }
        return (ExecutorService) invokeLL.objValue;
    }

    public final void n(@NonNull ReadableByteChannel readableByteChannel, @NonNull List<e> list) {
        d dVar;
        long j;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, readableByteChannel, list) == null) {
            ReadableByteChannel readableByteChannel2 = readableByteChannel;
            List<e> list2 = list;
            float f2 = 0.0f;
            s(0.0f);
            float k = k();
            long k2 = this.f51309g.k(CloudStabilityUBCUtils.KEY_LENGTH);
            ByteBuffer allocate = ByteBuffer.allocate(this.f51305c);
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
                            d.a.q0.a.v2.e1.a.c(new c(this, allocate), list2);
                            int i4 = i3 + 1;
                            if (k2 > 0) {
                                float f3 = ((float) j2) / ((float) k2);
                                if (f3 < f2) {
                                    f3 = 0.0f;
                                }
                                if (f3 > 1.0f) {
                                    f3 = 1.0f;
                                }
                                float f4 = f3 - this.f51310h;
                                int round = Math.round(100.0f * f3);
                                i2 = i4;
                                StringBuilder sb = new StringBuilder();
                                int i5 = 0;
                                while (i5 < 100) {
                                    sb.append(i5 > round ? "=" : "#");
                                    i5++;
                                }
                                if (f51302i) {
                                    j = k2;
                                    m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f3), sb, Long.valueOf(read), Long.valueOf(j2)));
                                } else {
                                    j = k2;
                                }
                                if (f4 > k) {
                                    if (f51302i) {
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
                            if (f51302i) {
                                e.printStackTrace();
                            }
                            f(readableByteChannel2, "connected source");
                            dVar = new d(this);
                            d.a.q0.a.v2.e1.a.c(dVar, list2);
                            s(1.0f);
                        } catch (Throwable th) {
                            th = th;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            f(readableByteChannel2, "connected source");
                            d.a.q0.a.v2.e1.a.c(new d(this), list2);
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
            if (f51302i) {
                m("pumping done: writeCount=" + i3 + " length: " + j3);
            }
            f(readableByteChannel, "connected source");
            dVar = new d(this);
            list2 = list;
            d.a.q0.a.v2.e1.a.c(dVar, list2);
            s(1.0f);
        }
    }

    @NonNull
    public a o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 < 1) {
                i2 = 8192;
            }
            this.f51305c = i2;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public a p(d.a.q0.a.v2.e1.b<String> bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bVar)) == null) {
            this.f51308f = bVar;
            return this;
        }
        return (a) invokeL.objValue;
    }

    @NonNull
    public a q(long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j, timeUnit)) == null) {
            if (j < 0) {
                j = -1;
            }
            this.f51306d = j;
            this.f51307e = timeUnit;
            return this;
        }
        return (a) invokeJL.objValue;
    }

    public final void r(@NonNull ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, executorService) == null) {
            if (executorService != this.f51304b && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            this.f51304b = null;
        }
    }

    public final void s(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            if (f51302i) {
                m("updateProgress: progress=" + f2);
            }
            this.f51310h = f2;
            e("on_progress");
        }
    }
}
