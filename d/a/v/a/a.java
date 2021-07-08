package d.a.v.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.asynctask.BdAsyncTask;
import com.baidu.live.asynctask.BdAsyncTaskParallelType;
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
/* loaded from: classes8.dex */
public class a implements Executor {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadFactory o;
    public static final BlockingQueue<Runnable> p;
    public static final Executor q;
    public static volatile a r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final SparseIntArray f67787e;

    /* renamed from: f  reason: collision with root package name */
    public final LinkedList<d> f67788f;

    /* renamed from: g  reason: collision with root package name */
    public final LinkedList<d> f67789g;

    /* renamed from: h  reason: collision with root package name */
    public final LinkedList<d> f67790h;

    /* renamed from: i  reason: collision with root package name */
    public volatile int f67791i;
    public volatile int j;
    public volatile int k;
    public volatile int l;
    public HandlerThread m;
    public Handler n;

    /* renamed from: d.a.v.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class ThreadFactoryC1923a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f67792e;

        public ThreadFactoryC1923a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67792e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                String str = "BdAsyncTask #" + String.valueOf(this.f67792e.getAndIncrement());
                d.a.v.e.a.g(str);
                return new Thread(runnable, str);
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f67793a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67793a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof d)) {
                        return;
                    }
                    this.f67793a.j((d) obj2);
                } else if (i2 == 2 && (obj = message.obj) != null && (obj instanceof d)) {
                    this.f67793a.i((d) obj);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f67794f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, d.a.v.a.b bVar) {
            super(bVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((d.a.v.a.b) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67794f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    try {
                        if (e() == 4) {
                            Process.setThreadPriority(-2);
                        } else if (e() == 3) {
                            Process.setThreadPriority(-1);
                        } else if (e() == 2) {
                            Process.setThreadPriority(0);
                        } else {
                            Process.setThreadPriority(10);
                        }
                    } catch (Exception e2) {
                        d.a.v.e.a.d(e2.getMessage());
                    }
                    j();
                } finally {
                    if (!h()) {
                        this.f67794f.n.sendMessageDelayed(this.f67794f.n.obtainMessage(2, this), 1L);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public d.a.v.a.b<?> f67795e;

        public d(d.a.v.a.b<?> bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67795e = null;
            if (bVar != null && bVar.b() != null) {
                this.f67795e = bVar;
                return;
            }
            throw new InvalidParameterException("parameter is null");
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f67795e.a();
            }
        }

        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.f67795e.b().j() != null) {
                    return this.f67795e.b().j().a();
                }
                return 1;
            }
            return invokeV.intValue;
        }

        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.f67795e.b().j() != null) {
                    return this.f67795e.b().j().b();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        public BdAsyncTaskParallelType d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f67795e.b().j() != null) {
                    return this.f67795e.b().j().c();
                }
                return BdAsyncTaskParallelType.MAX_PARALLEL;
            }
            return (BdAsyncTaskParallelType) invokeV.objValue;
        }

        public int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f67795e.b().k() : invokeV.intValue;
        }

        public BdAsyncTask<?, ?, ?> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f67795e.b() : (BdAsyncTask) invokeV.objValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f67795e.isCancelled() : invokeV.booleanValue;
        }

        public boolean h() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f67795e.b().m() : invokeV.booleanValue;
        }

        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f67795e.b().n() : invokeV.booleanValue;
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                try {
                    this.f67795e.run();
                } catch (OutOfMemoryError e2) {
                    d.a.v.e.a.e(e2);
                }
            }
        }

        public void k(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
                this.f67795e.b().y(z);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1210351002, "Ld/a/v/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1210351002, "Ld/a/v/a/a;");
                return;
            }
        }
        o = new ThreadFactoryC1923a();
        p = new SynchronousQueue();
        q = new ThreadPoolExecutor(7, 256, 30L, TimeUnit.SECONDS, p, o, new ThreadPoolExecutor.DiscardPolicy());
        r = null;
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
        this.f67787e = new SparseIntArray();
        this.f67788f = new LinkedList<>();
        this.f67789g = new LinkedList<>();
        this.f67790h = new LinkedList<>();
        this.f67791i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = null;
        HandlerThread handlerThread = new HandlerThread("BdAsyncTaskExecutor");
        this.m = handlerThread;
        handlerThread.start();
        this.n = new b(this, this.m.getLooper());
    }

    public static a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (r == null) {
                synchronized (a.class) {
                    if (r == null) {
                        r = new a();
                    }
                }
            }
            return r;
        }
        return (a) invokeV.objValue;
    }

    public final boolean c(int i2, d dVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i2, dVar)) == null) {
            if (dVar == null) {
                return false;
            }
            BdAsyncTaskParallelType d2 = dVar.d();
            if (d2 == BdAsyncTaskParallelType.SERIAL) {
                if (i2 < 1) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.TWO_PARALLEL) {
                if (i2 < 2) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.THREE_PARALLEL) {
                if (i2 < 3) {
                    return true;
                }
            } else if (d2 == BdAsyncTaskParallelType.FOUR_PARALLEL) {
                if (i2 < 4) {
                    return true;
                }
            } else if (d2 != BdAsyncTaskParallelType.CUSTOM_PARALLEL || i2 < dVar.b()) {
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
                this.f67789g.add(dVar);
                this.f67788f.remove(dVar);
                q.execute(dVar);
                this.n.sendMessageDelayed(this.n.obtainMessage(1, dVar), 180000L);
                int e2 = dVar.e();
                if (e2 == 1) {
                    this.l++;
                } else if (e2 == 2) {
                    this.k++;
                } else if (e2 == 3) {
                    this.j++;
                } else if (e2 == 4) {
                    this.f67791i++;
                    if (this.f67791i >= 7) {
                        d.a.v.e.a.d("SuperHight Task too much num = " + this.f67791i);
                    }
                }
                int c2 = dVar.c();
                if (c2 != 0) {
                    this.f67787e.put(c2, this.f67787e.get(c2, 0) + 1);
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            synchronized (this) {
                if (runnable instanceof d.a.v.a.b) {
                    c cVar = new c(this, (d.a.v.a.b) runnable);
                    if (cVar.h()) {
                        new Thread(cVar).start();
                        return;
                    }
                    f(cVar);
                    i(null);
                }
            }
        }
    }

    public final synchronized void f(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                int size = this.f67788f.size();
                int i2 = 0;
                while (i2 < size && this.f67788f.get(i2).e() >= dVar.e()) {
                    i2++;
                }
                this.f67788f.add(i2, dVar);
            }
        }
    }

    public final synchronized void g(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            synchronized (this) {
                if (dVar == null) {
                    return;
                }
                if (dVar.i()) {
                    this.f67790h.remove(dVar);
                } else {
                    this.f67789g.remove(dVar);
                    this.n.removeMessages(1, dVar);
                    int e2 = dVar.e();
                    if (e2 == 1) {
                        this.l--;
                    } else if (e2 == 2) {
                        this.k--;
                    } else if (e2 == 3) {
                        this.j--;
                    } else if (e2 == 4) {
                        this.f67791i--;
                    }
                    int c2 = dVar.c();
                    if (c2 != 0) {
                        int i2 = this.f67787e.get(c2) - 1;
                        if (i2 <= 0) {
                            this.f67787e.delete(c2);
                        } else {
                            this.f67787e.put(c2, i2);
                        }
                        if (i2 < 0) {
                            d.a.v.e.a.d("removeTask error < 0");
                        }
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
    public synchronized void h(BdAsyncTask<?, ?, ?> bdAsyncTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdAsyncTask) == null) {
            synchronized (this) {
                Iterator<d> it = this.f67788f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    d next = it.next();
                    if (next != null && next.f() == bdAsyncTask) {
                        break;
                    }
                }
            }
        }
    }

    public synchronized void i(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                for (int i2 = 0; i2 < this.f67788f.size(); i2++) {
                    d dVar2 = this.f67788f.get(i2);
                    if (dVar2 != null) {
                        int c2 = dVar2.c();
                        int e2 = dVar2.e();
                        if (e2 != 1) {
                            if (e2 != 2) {
                                if (e2 != 3) {
                                    if (e2 == 4 && c2 == 0) {
                                        d(dVar2);
                                        return;
                                    }
                                } else if (this.j + this.k + this.l >= 7) {
                                    return;
                                }
                            } else if (this.j + this.k + this.l >= 6) {
                                return;
                            }
                        } else if (this.j + this.k + this.l >= 5) {
                            return;
                        }
                        if (c(this.f67787e.get(c2), dVar2)) {
                            d(dVar2);
                            return;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void j(d dVar) {
        d poll;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            synchronized (this) {
                g(dVar);
                if (!dVar.g()) {
                    dVar.k(true);
                    this.f67790h.add(dVar);
                    if (this.f67790h.size() > 242 && (poll = this.f67790h.poll()) != null) {
                        poll.a();
                    }
                } else {
                    d.a.v.e.a.d("task TimeOut but it's cancelled()");
                }
                i(null);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "mWaitingTasks = " + this.f67788f.size() + " mRunningTasks = " + this.f67789g.size() + " mTimeOutTasks = " + this.f67790h.size();
        }
        return (String) invokeV.objValue;
    }
}
