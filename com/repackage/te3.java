package com.repackage;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.kl2;
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
/* loaded from: classes7.dex */
public class te3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public transient /* synthetic */ FieldHolder $fh;
    public final Set<af3<Pipe.SourceChannel>> a;
    public ExecutorService b;
    public int c;
    public long d;
    public TimeUnit e;
    public af3<String> f;
    public final kl2.a g;
    public float h;

    /* loaded from: classes7.dex */
    public class a implements af3<af3<Pipe.SourceChannel>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ te3 b;

        public a(te3 te3Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = te3Var;
            this.a = list;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(af3<Pipe.SourceChannel> af3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, af3Var) == null) {
                try {
                    this.a.add(new e(this.b, af3Var));
                } catch (IOException e) {
                    if (te3.i) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CountDownLatch a;
        public final /* synthetic */ ExecutorService b;

        public b(te3 te3Var, CountDownLatch countDownLatch, ExecutorService executorService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var, countDownLatch, executorService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = countDownLatch;
            this.b = executorService;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                eVar.f(this.a);
                this.b.submit(eVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements af3<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ByteBuffer a;

        public c(te3 te3Var, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var, byteBuffer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                try {
                    if (eVar.d.isOpen() && eVar.c.isOpen()) {
                        this.a.rewind();
                        eVar.d.write(this.a);
                    }
                } catch (IOException e) {
                    if (te3.i) {
                        te3.m("connect e:" + e + " line: " + eVar);
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements af3<e> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(te3 te3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
                Pipe.SinkChannel sinkChannel = eVar.d;
                te3.f(sinkChannel, eVar.toString() + " by[PumpingFinish]");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final af3<Pipe.SourceChannel> a;
        public final Pipe b;
        public final Pipe.SourceChannel c;
        public final Pipe.SinkChannel d;
        public CountDownLatch e;
        public String f;

        public e(te3 te3Var, af3<Pipe.SourceChannel> af3Var) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te3Var, af3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af3Var;
            Pipe open = Pipe.open();
            this.b = open;
            this.d = open.sink();
            this.c = this.b.source();
        }

        public final void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Pipe.SinkChannel sinkChannel = this.d;
                te3.f(sinkChannel, "sink for " + toString());
                Pipe.SourceChannel sourceChannel = this.c;
                te3.f(sourceChannel, "source for " + toString());
            }
        }

        public final void e() {
            CountDownLatch countDownLatch;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (countDownLatch = this.e) == null) {
                return;
            }
            countDownLatch.countDown();
        }

        public final void f(CountDownLatch countDownLatch) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, countDownLatch) == null) {
                this.e = countDownLatch;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f = Thread.currentThread().toString();
                if (te3.i) {
                    te3.m(" >> run on " + toString());
                }
                try {
                    try {
                        this.a.a(this.c);
                    } catch (Exception e) {
                        if (te3.i) {
                            e.printStackTrace();
                            te3.m("catch Exception on " + toString() + " :\n  " + e.toString());
                        }
                    }
                    if (te3.i) {
                        te3.m("countdown by end -> " + toString());
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
                return "PipeLine: " + this.f + " consumer=" + this.a.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755293681, "Lcom/repackage/te3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755293681, "Lcom/repackage/te3;");
                return;
            }
        }
        i = rg1.a;
    }

    public te3() {
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
        this.a = new HashSet();
        this.c = 8192;
        this.d = -1L;
        this.e = TimeUnit.NANOSECONDS;
        this.g = new kl2.a();
        this.h = 0.0f;
    }

    public static void f(Channel channel, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65541, null, channel, str) == null) && channel != null && channel.isOpen()) {
            jg4.d(channel);
        }
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, str) == null) && i) {
            Log.i("PipeHub", str);
        }
    }

    @NonNull
    public te3 d(@NonNull af3<Pipe.SourceChannel>... af3VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, af3VarArr)) == null) {
            this.a.addAll(Arrays.asList(af3VarArr));
            return this;
        }
        return (te3) invokeL.objValue;
    }

    public final void e(String str) {
        af3<String> af3Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (af3Var = this.f) == null) {
            return;
        }
        af3Var.a(str);
    }

    public te3 g(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
            this.g.update(bundle);
            return this;
        }
        return (te3) invokeL.objValue;
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
                if (i) {
                    m("pumping: cost=" + (System.currentTimeMillis() - currentTimeMillis));
                }
                try {
                    if (i) {
                        m("main await for timeout: " + this.e.toMillis(this.d));
                    }
                    boolean z = false;
                    if (this.d < 0) {
                        countDownLatch.await();
                    } else {
                        z = !countDownLatch.await(this.d, this.e);
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
        }
    }

    public final List<e> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ArrayList arrayList = new ArrayList();
            ze3.c(new a(this, arrayList), this.a);
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public float j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : invokeV.floatValue;
    }

    public final float k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float h = this.g.h("progress_granularity", 0.01f);
            if (h < 0.0f) {
                h = 0.0f;
            }
            if (h > 1.0f) {
                return 1.0f;
            }
            return h;
        }
        return invokeV.floatValue;
    }

    @NonNull
    public final ExecutorService l(@NonNull List<e> list, @NonNull CountDownLatch countDownLatch) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, list, countDownLatch)) == null) {
            ExecutorService executorService = this.b;
            if (executorService == null || executorService.isShutdown() || this.b.isTerminated()) {
                this.b = null;
            }
            ExecutorService executorService2 = this.b;
            if (executorService2 == null) {
                executorService2 = Executors.newCachedThreadPool();
            }
            ze3.c(new b(this, countDownLatch, executorService2), list);
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
            float f = 0.0f;
            s(0.0f);
            float k = k();
            long k2 = this.g.k(CloudStabilityUBCUtils.KEY_LENGTH);
            ByteBuffer allocate = ByteBuffer.allocate(this.c);
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
                            ze3.c(new c(this, allocate), list2);
                            int i4 = i3 + 1;
                            if (k2 > 0) {
                                float f2 = ((float) j2) / ((float) k2);
                                if (f2 < f) {
                                    f2 = 0.0f;
                                }
                                if (f2 > 1.0f) {
                                    f2 = 1.0f;
                                }
                                float f3 = f2 - this.h;
                                int round = Math.round(100.0f * f2);
                                i2 = i4;
                                StringBuilder sb = new StringBuilder();
                                int i5 = 0;
                                while (i5 < 100) {
                                    sb.append(i5 > round ? "=" : "#");
                                    i5++;
                                }
                                if (i) {
                                    j = k2;
                                    m(String.format("pumping: %4s [%s] read/at:[%7d/%-7d]", NumberFormat.getPercentInstance().format(f2), sb, Long.valueOf(read), Long.valueOf(j2)));
                                } else {
                                    j = k2;
                                }
                                if (f3 > k) {
                                    if (i) {
                                        NumberFormat percentInstance = NumberFormat.getPercentInstance();
                                        m("pumping: updateProgress granularity:" + percentInstance.format(k) + " step:" + percentInstance.format(f3));
                                    }
                                    s(f2);
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
                            f = 0.0f;
                        } catch (IOException e2) {
                            e = e2;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            if (i) {
                                e.printStackTrace();
                            }
                            f(readableByteChannel2, "connected source");
                            dVar = new d(this);
                            ze3.c(dVar, list2);
                            s(1.0f);
                        } catch (Throwable th) {
                            th = th;
                            readableByteChannel2 = readableByteChannel;
                            list2 = list;
                            f(readableByteChannel2, "connected source");
                            ze3.c(new d(this), list2);
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
            if (i) {
                m("pumping done: writeCount=" + i3 + " length: " + j3);
            }
            f(readableByteChannel, "connected source");
            dVar = new d(this);
            list2 = list;
            ze3.c(dVar, list2);
            s(1.0f);
        }
    }

    @NonNull
    public te3 o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            if (i2 < 1) {
                i2 = 8192;
            }
            this.c = i2;
            return this;
        }
        return (te3) invokeI.objValue;
    }

    public te3 p(af3<String> af3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, af3Var)) == null) {
            this.f = af3Var;
            return this;
        }
        return (te3) invokeL.objValue;
    }

    @NonNull
    public te3 q(long j, @NonNull TimeUnit timeUnit) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048587, this, j, timeUnit)) == null) {
            if (j < 0) {
                j = -1;
            }
            this.d = j;
            this.e = timeUnit;
            return this;
        }
        return (te3) invokeJL.objValue;
    }

    public final void r(@NonNull ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, executorService) == null) {
            if (executorService != this.b && !executorService.isShutdown()) {
                executorService.shutdown();
            }
            this.b = null;
        }
    }

    public final void s(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f) == null) {
            if (i) {
                m("updateProgress: progress=" + f);
            }
            this.h = f;
            e("on_progress");
        }
    }
}
