package com.dxmpay.apollon.taskmanager;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.utils.ChannelUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public final class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long TIMESLICE = 1000;
    public static final boolean j;
    public static final String k;
    public static HashMap<String, TaskManager> sTskMgrMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f63086a;

    /* renamed from: b  reason: collision with root package name */
    public String f63087b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f63088c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f63089d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f63090e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Runnable> f63091f;

    /* renamed from: g  reason: collision with root package name */
    public final ThreadFactory f63092g;

    /* renamed from: h  reason: collision with root package name */
    public d f63093h;

    /* renamed from: i  reason: collision with root package name */
    public e f63094i;

    /* loaded from: classes11.dex */
    public class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f63095a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f63096b;

        /* renamed from: c  reason: collision with root package name */
        public long f63097c;

        /* renamed from: d  reason: collision with root package name */
        public long f63098d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f63099e;

        /* renamed from: f  reason: collision with root package name */
        public long f63100f;

        public Task(TaskManager taskManager, long j, long j2, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63098d = j;
            this.f63100f = System.currentTimeMillis() + j;
            this.f63097c = j2;
            this.f63099e = z;
            this.f63096b = runnable;
            this.f63095a = str;
        }
    }

    /* loaded from: classes11.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f63101e;

        public a(TaskManager taskManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63101e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "DxmWalletTask #" + this.f63101e.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f63102e;

        public b(TaskManager taskManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63102e = taskManager;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f63102e.d();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f63103e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Task f63104f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f63105g;

        public c(TaskManager taskManager, long j, Task task) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j), task};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63105g = taskManager;
            this.f63103e = j;
            this.f63104f = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(this.f63103e);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.f63105g.o(this.f63104f);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f63106e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TaskManager taskManager, int i2, int i3, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), timeUnit, blockingQueue, threadFactory};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Long) objArr2[2]).longValue(), (TimeUnit) objArr2[3], (BlockingQueue) objArr2[4], (ThreadFactory) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63106e = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f63106e.f63090e.remove((Future) runnable);
                super.afterExecute(runnable, th);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020943952, "Lcom/dxmpay/apollon/taskmanager/TaskManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1020943952, "Lcom/dxmpay/apollon/taskmanager/TaskManager;");
                return;
            }
        }
        j = ApollonConstants.DEBUG;
        k = TaskManager.class.getSimpleName();
        sTskMgrMap = new HashMap<>();
    }

    public TaskManager() {
        d dVar;
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
        this.f63086a = Long.MAX_VALUE;
        this.f63088c = new Timer();
        this.f63090e = new HashMap<>();
        this.f63091f = new LinkedBlockingQueue(10);
        this.f63092g = new a(this);
        this.f63093h = new d(this, 5, 128, 1L, TimeUnit.SECONDS, this.f63091f, this.f63092g);
        this.f63094i = new e(this, null);
        this.f63089d = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (dVar = this.f63093h) == null) {
            return;
        }
        dVar.allowCoreThreadTimeOut(true);
    }

    public static synchronized TaskManager getInstance(String str) {
        InterceptResult invokeL;
        TaskManager taskManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (TaskManager.class) {
                taskManager = sTskMgrMap.get(str);
                if (taskManager == null) {
                    taskManager = new TaskManager();
                    sTskMgrMap.put(str, taskManager);
                    taskManager.f63087b = str;
                }
            }
            return taskManager;
        }
        return (TaskManager) invokeL.objValue;
    }

    public final Task a(String str, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (str != null && str.equals(next.f63095a)) {
                    return next;
                }
            }
            return null;
        }
        return (Task) invokeLL.objValue;
    }

    public boolean addTask(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, task, str)) == null) {
            if (task == null || task.f63096b == null) {
                return false;
            }
            synchronized (this.f63089d) {
                ArrayList<Task> b2 = b(str);
                if (!j(task, b2)) {
                    if (task.f63100f <= System.currentTimeMillis()) {
                        m(task);
                    } else if (task.f63098d > 0) {
                        m(task);
                    }
                    if (task.f63097c > 0) {
                        task.f63100f = System.currentTimeMillis() + task.f63098d + task.f63097c;
                        b2.add(task);
                        f(task);
                    }
                } else {
                    i(task, str);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final ArrayList<Task> b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            ArrayList<Task> arrayList = this.f63089d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f63089d.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void cancelAllTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f63089d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    l(it.next());
                }
                b2.clear();
                this.f63089d.remove(str);
            }
        }
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this.f63089d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.f63095a.equals(str2)) {
                        l(next);
                        b2.remove(next.f63095a);
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = j;
            synchronized (this.f63089d) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f63086a = Long.MAX_VALUE;
                for (String str : this.f63089d.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task> it = b(str).iterator();
                    while (it.hasNext()) {
                        Task next = it.next();
                        if (next.f63100f - currentTimeMillis < 1000) {
                            if (j) {
                                String str2 = "task.mNextRunTime - current = " + (next.f63100f - currentTimeMillis);
                            }
                            m(next);
                            if (next.f63097c > 0) {
                                next.f63100f = next.f63097c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f63100f < this.f63086a) {
                            this.f63086a = next.f63100f;
                        }
                    }
                    if (this.f63086a < Long.MAX_VALUE) {
                        e(this.f63086a - currentTimeMillis);
                    }
                }
            }
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            if (j) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.f63088c;
            if (timer != null) {
                timer.cancel();
                this.f63088c = null;
            }
            this.f63088c = new Timer();
            this.f63088c.schedule(new b(this), j2);
        }
    }

    public final void f(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, task) == null) {
            long j2 = task.f63100f;
            if (j2 < this.f63086a) {
                e(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    public final void g(Task task, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, task, j2) == null) {
            this.f63093h.execute(new c(this, j2, task));
        }
    }

    public final boolean i(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, task, str)) == null) {
            if (task == null || task.f63096b == null) {
                return false;
            }
            synchronized (this.f63089d) {
                ArrayList<Task> b2 = b(str);
                Task a2 = a(task.f63095a, b2);
                if (a2 != null) {
                    l(a2);
                    b2.remove(a2);
                    addTask(task, str);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean j(Task task, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, task, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (next != null && (str = next.f63095a) != null && str.equals(task.f63095a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void l(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, task) == null) {
            if (task.f63099e) {
                this.f63094i.b(task.f63096b);
                return;
            }
            for (Future<?> future : this.f63090e.keySet()) {
                if (this.f63090e.get(future) == task.f63096b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    public final void m(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, task) == null) {
            if (task.f63098d > 0) {
                g(task, task.f63100f - System.currentTimeMillis());
            } else {
                o(task);
            }
        }
    }

    public final void o(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, task) == null) {
            if (task.f63097c > 0) {
                task.f63098d = 0L;
            }
            if (task.f63099e) {
                this.f63094i.execute(task.f63096b);
                return;
            }
            this.f63090e.put(this.f63093h.submit(task.f63096b), task.f63096b);
            if (j) {
                String str = "execute task, " + task.f63095a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Timer timer = this.f63088c;
            if (timer != null) {
                timer.cancel();
                this.f63088c = null;
            }
            e eVar = this.f63094i;
            if (eVar != null && eVar.f63107e != null) {
                while (true) {
                    Runnable poll = this.f63094i.f63107e.poll();
                    if (poll == null) {
                        break;
                    }
                    this.f63094i.b(poll);
                }
            }
            d dVar = this.f63093h;
            if (dVar != null) {
                try {
                    dVar.shutdownNow();
                    this.f63093h.awaitTermination(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            String str = this.f63087b;
            if (str != null) {
                sTskMgrMap.remove(str);
            }
        }
    }

    /* loaded from: classes11.dex */
    public class e implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final LinkedList<Runnable> f63107e;

        /* renamed from: f  reason: collision with root package name */
        public Runnable f63108f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f63109g;

        /* loaded from: classes11.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f63110e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f63111f;

            public a(e eVar, Runnable runnable) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, runnable};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f63111f = eVar;
                this.f63110e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f63110e.run();
                    } finally {
                        this.f63111f.a();
                    }
                }
            }
        }

        public e(TaskManager taskManager) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f63109g = taskManager;
            this.f63107e = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f63107e.poll();
                    this.f63108f = poll;
                    if (poll != null) {
                        this.f63109g.f63090e.put(this.f63109g.f63093h.submit(this.f63108f), this.f63108f);
                    }
                }
            }
        }

        public synchronized void b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f63107e.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f63107e.offer(new a(this, runnable));
                    if (this.f63108f == null) {
                        a();
                    }
                }
            }
        }

        public /* synthetic */ e(TaskManager taskManager, a aVar) {
            this(taskManager);
        }
    }
}
