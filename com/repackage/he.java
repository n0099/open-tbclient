package com.repackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class he implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static he k;
    public static final ThreadFactory l;
    public static final BlockingQueue<Runnable> m;
    public static final Executor n;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile int a;
    public volatile int b;
    public volatile int c;
    public volatile int d;
    public final SparseIntArray e;
    public final LinkedList<d> f;
    public final LinkedList<d> g;
    public final LinkedList<d> h;
    public HandlerThread i;
    public Handler j;

    /* loaded from: classes6.dex */
    public static class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final AtomicInteger a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "BdAsyncTask #" + String.valueOf(this.a.getAndIncrement());
                BdLog.i(str);
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(he heVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = heVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof d)) {
                        return;
                    }
                    this.a.y((d) obj2);
                } else if (i == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                    this.a.p((d) obj);
                    BdBaseApplication.getInst().isDebugMode();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ he b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(he heVar, ie ieVar) {
            super(ieVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {heVar, ieVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ie) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = heVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (g() == 4) {
                            Process.setThreadPriority(-2);
                        } else if (g() == 3) {
                            Process.setThreadPriority(-1);
                        } else if (g() == 2) {
                            Process.setThreadPriority(0);
                        } else {
                            Process.setThreadPriority(10);
                        }
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
                    l();
                } finally {
                    if (!k()) {
                        this.b.j.sendMessageDelayed(this.b.j.obtainMessage(2, this), 1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ie<?> a;

        public d(ie<?> ieVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ieVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            if (ieVar != null && ieVar.b() != null) {
                this.a = ieVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.b().isTimeout() : invokeV.booleanValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.a();
            }
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.a.b().getParallel() != null) {
                    return this.a.b().getParallel().a();
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.b().getKey() : (String) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.a.b().getParallel() != null) {
                    return this.a.b().getParallel().b();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public BdAsyncTaskParallel.BdAsyncTaskParallelType f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.a.b().getParallel() != null) {
                    return this.a.b().getParallel().getType();
                }
                return BdAsyncTaskParallel.BdAsyncTaskParallelType.MAX_PARALLEL;
            }
            return (BdAsyncTaskParallel.BdAsyncTaskParallelType) invokeV.objValue;
        }

        public int g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.a.b().getPriority() : invokeV.intValue;
        }

        public int h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.b().getTag() : invokeV.intValue;
        }

        public BdAsyncTask<?, ?, ?> i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.a.b() : (BdAsyncTask) invokeV.objValue;
        }

        public boolean j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.isCancelled() : invokeV.booleanValue;
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.a.b().isSelfExecute() : invokeV.booleanValue;
        }

        public void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                try {
                    this.a.run();
                } catch (OutOfMemoryError unused) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
            }
        }

        public void m(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
                this.a.b().setTimeout(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964038488, "Lcom/repackage/he;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964038488, "Lcom/repackage/he;");
                return;
            }
        }
        l = new a();
        m = new SynchronousQueue();
        n = new ThreadPoolExecutor(7, 256, 30L, TimeUnit.SECONDS, m, l, new ThreadPoolExecutor.DiscardPolicy());
    }

    public he() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = new SparseIntArray();
        this.f = new LinkedList<>();
        this.g = new LinkedList<>();
        this.h = new LinkedList<>();
        this.i = null;
        this.j = null;
        HandlerThread handlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.i = handlerThread;
        handlerThread.start();
        this.j = new b(this, this.i.getLooper());
    }

    public static he e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (k == null) {
                synchronized (he.class) {
                    if (k == null) {
                        k = new he();
                    }
                }
            }
            return k;
        }
        return (he) invokeV.objValue;
    }

    public final boolean c(int i, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            BdAsyncTaskParallel.BdAsyncTaskParallelType f = dVar.f();
            if (f == BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL) {
                if (i < 1) {
                    return true;
                }
            } else if (f == BdAsyncTaskParallel.BdAsyncTaskParallelType.TWO_PARALLEL) {
                if (i < 2) {
                    return true;
                }
            } else if (f == BdAsyncTaskParallel.BdAsyncTaskParallelType.THREE_PARALLEL) {
                if (i < 3) {
                    return true;
                }
            } else if (f == BdAsyncTaskParallel.BdAsyncTaskParallelType.FOUR_PARALLEL) {
                if (i < 4) {
                    return true;
                }
            } else if (f != BdAsyncTaskParallel.BdAsyncTaskParallelType.CUSTOM_PARALLEL || i < dVar.c()) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public final synchronized void d(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                this.g.add(dVar);
                this.f.remove(dVar);
                n.execute(dVar);
                this.j.sendMessageDelayed(this.j.obtainMessage(1, dVar), LiveFeedPageSdk.REFRESH_TIME);
                int g = dVar.g();
                if (g == 1) {
                    this.d++;
                } else if (g == 2) {
                    this.c++;
                } else if (g == 3) {
                    this.b++;
                } else if (g == 4) {
                    this.a++;
                    if (this.a >= 7) {
                        BdLog.e("SuperHight Task too much num = " + this.a);
                    }
                }
                int e = dVar.e();
                if (e != 0) {
                    this.e.put(e, this.e.get(e, 0) + 1);
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            synchronized (this) {
                if (runnable instanceof ie) {
                    c cVar = new c(this, (ie) runnable);
                    if (cVar.k()) {
                        new Thread(cVar).start();
                        return;
                    }
                    h(cVar);
                    p(null);
                    BdBaseApplication.getInst().isDebugMode();
                }
            }
        }
    }

    public final synchronized int f(LinkedList<d> linkedList, String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, linkedList, str, bdUniqueId)) == null) {
            synchronized (this) {
                int i = 0;
                if (linkedList == null || bdUniqueId == null) {
                    return 0;
                }
                int id = bdUniqueId.getId();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h = next.h();
                    String d2 = next.d();
                    if ((str != null && h == id && str.equals(d2)) || (str == null && id != 0 && h == id)) {
                        if (next.i() != null && !next.i().isCancelled()) {
                            i++;
                        }
                    }
                }
                return i;
            }
        }
        return invokeLLL.intValue;
    }

    public int g(String str, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, bdUniqueId)) == null) ? f(this.f, str, bdUniqueId) + f(this.g, str, bdUniqueId) + f(this.h, str, bdUniqueId) : invokeLL.intValue;
    }

    public final synchronized void h(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                int size = this.f.size();
                int i = 0;
                while (i < size && this.f.get(i).g() >= dVar.g()) {
                    i++;
                }
                this.f.add(i, dVar);
            }
        }
    }

    public synchronized void i(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bdUniqueId) == null) {
            synchronized (this) {
                j(bdUniqueId, null);
            }
        }
    }

    public synchronized void j(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, bdUniqueId, str) == null) {
            synchronized (this) {
                l(bdUniqueId, str);
                n(this.g, false, bdUniqueId, str);
                n(this.h, false, bdUniqueId, str);
            }
        }
    }

    public synchronized void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            synchronized (this) {
                l(bdUniqueId, null);
            }
        }
    }

    public synchronized void l(BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, bdUniqueId, str) == null) {
            synchronized (this) {
                n(this.f, true, bdUniqueId, str);
            }
        }
    }

    public final synchronized void m(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                if (dVar.a()) {
                    this.h.remove(dVar);
                } else {
                    this.g.remove(dVar);
                    this.j.removeMessages(1, dVar);
                    int g = dVar.g();
                    if (g == 1) {
                        this.d--;
                    } else if (g == 2) {
                        this.c--;
                    } else if (g == 3) {
                        this.b--;
                    } else if (g == 4) {
                        this.a--;
                    }
                    int e = dVar.e();
                    if (e != 0) {
                        int i = this.e.get(e) - 1;
                        if (i <= 0) {
                            this.e.delete(e);
                        } else {
                            this.e.put(e, i);
                        }
                        if (i < 0) {
                            BdLog.e("removeTask error < 0");
                        }
                    }
                }
            }
        }
    }

    public final synchronized void n(LinkedList<d> linkedList, boolean z, BdUniqueId bdUniqueId, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{linkedList, Boolean.valueOf(z), bdUniqueId, str}) == null) {
            synchronized (this) {
                if (bdUniqueId == null) {
                    return;
                }
                int id = bdUniqueId.getId();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h = next.h();
                    String d2 = next.d();
                    if ((str != null && h == id && str.equals(d2)) || (str == null && id != 0 && h == id)) {
                        if (z) {
                            it.remove();
                        }
                        next.b();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        r0.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void o(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bdAsyncTask) == null) {
            synchronized (this) {
                Iterator<d> it = this.f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null && next.i() == bdAsyncTask) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void p(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            synchronized (this) {
                m(dVar);
                for (int i = 0; i < this.f.size(); i++) {
                    d dVar2 = this.f.get(i);
                    if (dVar2 != null) {
                        int e = dVar2.e();
                        int g = dVar2.g();
                        if (g != 1) {
                            if (g != 2) {
                                if (g != 3) {
                                    if (g == 4 && e == 0) {
                                        d(dVar2);
                                        return;
                                    }
                                } else if (this.b + this.c + this.d >= 7) {
                                    return;
                                }
                            } else if (this.b + this.c + this.d >= 6) {
                                return;
                            }
                        } else if (this.b + this.c + this.d >= 5) {
                            return;
                        }
                        if (c(this.e.get(e), dVar2)) {
                            d(dVar2);
                            return;
                        }
                    }
                }
            }
        }
    }

    public synchronized BdAsyncTask<?, ?, ?> q(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            synchronized (this) {
                v = v(this.g, str);
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> r(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        LinkedList<BdAsyncTask<?, ?, ?>> s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bdUniqueId)) == null) {
            synchronized (this) {
                s = s(bdUniqueId, null);
            }
            return s;
        }
        return (LinkedList) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> s(BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLL;
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, bdUniqueId, str)) == null) {
            synchronized (this) {
                linkedList = new LinkedList<>();
                LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.f, bdUniqueId, str);
                if (t != null) {
                    linkedList.addAll(t);
                }
                LinkedList<BdAsyncTask<?, ?, ?>> t2 = t(this.g, bdUniqueId, str);
                if (t2 != null) {
                    linkedList.addAll(t2);
                }
                LinkedList<BdAsyncTask<?, ?, ?>> t3 = t(this.h, bdUniqueId, str);
                if (t3 != null) {
                    linkedList.addAll(t3);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeLL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> t(LinkedList<d> linkedList, BdUniqueId bdUniqueId, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, linkedList, bdUniqueId, str)) == null) {
            synchronized (this) {
                if (linkedList == null || bdUniqueId == null) {
                    return null;
                }
                int id = bdUniqueId.getId();
                LinkedList<BdAsyncTask<?, ?, ?>> linkedList2 = new LinkedList<>();
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    int h = next.h();
                    String d2 = next.d();
                    if ((str != null && h == id && str.equals(d2)) || (str == null && id != 0 && h == id)) {
                        if (next.i() != null && !next.i().isCancelled()) {
                            linkedList2.add(next.i());
                        }
                    }
                }
                return linkedList2;
            }
        }
        return (LinkedList) invokeLLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return "mWaitingTasks = " + this.f.size() + " mRunningTasks = " + this.g.size() + " mTimeOutTasks = " + this.h.size();
        }
        return (String) invokeV.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> u(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            synchronized (this) {
                v = v(this.f, str);
                if (v == null) {
                    v = v(this.g, str);
                }
                if (v == null) {
                    v = v(this.h, str);
                }
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> v(LinkedList<d> linkedList, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, linkedList, str)) == null) {
            synchronized (this) {
                if (linkedList == null || str == null) {
                    return null;
                }
                Iterator<d> it = linkedList.iterator();
                while (it.hasNext()) {
                    d next = it.next();
                    String d2 = next.d();
                    if (d2 != null && d2.equals(str) && !next.i().isCancelled()) {
                        return next.i();
                    }
                }
                return null;
            }
        }
        return (BdAsyncTask) invokeLL.objValue;
    }

    public synchronized BdAsyncTask<?, ?, ?> w(String str) {
        InterceptResult invokeL;
        BdAsyncTask<?, ?, ?> v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            synchronized (this) {
                v = v(this.f, str);
            }
            return v;
        }
        return (BdAsyncTask) invokeL.objValue;
    }

    public synchronized LinkedList<BdAsyncTask<?, ?, ?>> x(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        LinkedList<BdAsyncTask<?, ?, ?>> linkedList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, bdUniqueId)) == null) {
            synchronized (this) {
                linkedList = new LinkedList<>();
                LinkedList<BdAsyncTask<?, ?, ?>> t = t(this.f, bdUniqueId, null);
                if (t != null) {
                    linkedList.addAll(t);
                }
            }
            return linkedList;
        }
        return (LinkedList) invokeL.objValue;
    }

    public final synchronized void y(d dVar) {
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
            synchronized (this) {
                m(dVar);
                if (!dVar.j()) {
                    dVar.m(true);
                    this.h.add(dVar);
                    if (this.h.size() > 242 && (poll = this.h.poll()) != null) {
                        poll.b();
                    }
                } else {
                    BdLog.e("task TimeOut but it's cancelled()");
                }
                p(null);
            }
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.f.size() + "/" + this.g.size() + "/" + this.h.size();
        }
        return (String) invokeV.objValue;
    }
}
