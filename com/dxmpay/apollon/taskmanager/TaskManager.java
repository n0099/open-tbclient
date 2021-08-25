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
/* loaded from: classes9.dex */
public final class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long TIMESLICE = 1000;

    /* renamed from: j  reason: collision with root package name */
    public static final boolean f69222j;
    public static final String k;
    public static HashMap<String, TaskManager> sTskMgrMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69223a;

    /* renamed from: b  reason: collision with root package name */
    public String f69224b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f69225c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f69226d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f69227e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Runnable> f69228f;

    /* renamed from: g  reason: collision with root package name */
    public final ThreadFactory f69229g;

    /* renamed from: h  reason: collision with root package name */
    public d f69230h;

    /* renamed from: i  reason: collision with root package name */
    public e f69231i;

    /* loaded from: classes9.dex */
    public class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69232a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f69233b;

        /* renamed from: c  reason: collision with root package name */
        public long f69234c;

        /* renamed from: d  reason: collision with root package name */
        public long f69235d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f69236e;

        /* renamed from: f  reason: collision with root package name */
        public long f69237f;

        public Task(TaskManager taskManager, long j2, long j3, boolean z, String str, Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), str, runnable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69235d = j2;
            this.f69237f = System.currentTimeMillis() + j2;
            this.f69234c = j3;
            this.f69236e = z;
            this.f69233b = runnable;
            this.f69232a = str;
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f69238e;

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
            this.f69238e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "DxmWalletTask #" + this.f69238e.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69239e;

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
            this.f69239e = taskManager;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f69239e.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f69240e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Task f69241f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69242g;

        public c(TaskManager taskManager, long j2, Task task) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Long.valueOf(j2), task};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69242g = taskManager;
            this.f69240e = j2;
            this.f69241f = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(this.f69240e);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.f69242g.o(this.f69241f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69243e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TaskManager taskManager, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
            super(i2, i3, j2, timeUnit, blockingQueue, threadFactory);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {taskManager, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), timeUnit, blockingQueue, threadFactory};
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
            this.f69243e = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f69243e.f69227e.remove((Future) runnable);
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
        f69222j = ApollonConstants.DEBUG;
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
        this.f69223a = Long.MAX_VALUE;
        this.f69225c = new Timer();
        this.f69227e = new HashMap<>();
        this.f69228f = new LinkedBlockingQueue(10);
        this.f69229g = new a(this);
        this.f69230h = new d(this, 5, 128, 1L, TimeUnit.SECONDS, this.f69228f, this.f69229g);
        this.f69231i = new e(this, null);
        this.f69226d = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (dVar = this.f69230h) == null) {
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
                    taskManager.f69224b = str;
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
                if (str != null && str.equals(next.f69232a)) {
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
            if (task == null || task.f69233b == null) {
                return false;
            }
            synchronized (this.f69226d) {
                ArrayList<Task> b2 = b(str);
                if (!j(task, b2)) {
                    if (task.f69237f <= System.currentTimeMillis()) {
                        m(task);
                    } else if (task.f69235d > 0) {
                        m(task);
                    }
                    if (task.f69234c > 0) {
                        task.f69237f = System.currentTimeMillis() + task.f69235d + task.f69234c;
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
            ArrayList<Task> arrayList = this.f69226d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f69226d.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void cancelAllTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f69226d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    l(it.next());
                }
                b2.clear();
                this.f69226d.remove(str);
            }
        }
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this.f69226d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.f69232a.equals(str2)) {
                        l(next);
                        b2.remove(next.f69232a);
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f69222j;
            synchronized (this.f69226d) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f69223a = Long.MAX_VALUE;
                for (String str : this.f69226d.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task> it = b(str).iterator();
                    while (it.hasNext()) {
                        Task next = it.next();
                        if (next.f69237f - currentTimeMillis < 1000) {
                            if (f69222j) {
                                String str2 = "task.mNextRunTime - current = " + (next.f69237f - currentTimeMillis);
                            }
                            m(next);
                            if (next.f69234c > 0) {
                                next.f69237f = next.f69234c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f69237f < this.f69223a) {
                            this.f69223a = next.f69237f;
                        }
                    }
                    if (this.f69223a < Long.MAX_VALUE) {
                        e(this.f69223a - currentTimeMillis);
                    }
                }
            }
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            if (f69222j) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.f69225c;
            if (timer != null) {
                timer.cancel();
                this.f69225c = null;
            }
            this.f69225c = new Timer();
            this.f69225c.schedule(new b(this), j2);
        }
    }

    public final void f(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, task) == null) {
            long j2 = task.f69237f;
            if (j2 < this.f69223a) {
                e(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    public final void g(Task task, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, task, j2) == null) {
            this.f69230h.execute(new c(this, j2, task));
        }
    }

    public final boolean i(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, task, str)) == null) {
            if (task == null || task.f69233b == null) {
                return false;
            }
            synchronized (this.f69226d) {
                ArrayList<Task> b2 = b(str);
                Task a2 = a(task.f69232a, b2);
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
                if (next != null && (str = next.f69232a) != null && str.equals(task.f69232a)) {
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
            if (task.f69236e) {
                this.f69231i.b(task.f69233b);
                return;
            }
            for (Future<?> future : this.f69227e.keySet()) {
                if (this.f69227e.get(future) == task.f69233b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    public final void m(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, task) == null) {
            if (task.f69235d > 0) {
                g(task, task.f69237f - System.currentTimeMillis());
            } else {
                o(task);
            }
        }
    }

    public final void o(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, task) == null) {
            if (task.f69234c > 0) {
                task.f69235d = 0L;
            }
            if (task.f69236e) {
                this.f69231i.execute(task.f69233b);
                return;
            }
            this.f69227e.put(this.f69230h.submit(task.f69233b), task.f69233b);
            if (f69222j) {
                String str = "execute task, " + task.f69232a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Timer timer = this.f69225c;
            if (timer != null) {
                timer.cancel();
                this.f69225c = null;
            }
            e eVar = this.f69231i;
            if (eVar != null && eVar.f69244e != null) {
                while (true) {
                    Runnable poll = this.f69231i.f69244e.poll();
                    if (poll == null) {
                        break;
                    }
                    this.f69231i.b(poll);
                }
            }
            d dVar = this.f69230h;
            if (dVar != null) {
                try {
                    dVar.shutdownNow();
                    this.f69230h.awaitTermination(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            String str = this.f69224b;
            if (str != null) {
                sTskMgrMap.remove(str);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final LinkedList<Runnable> f69244e;

        /* renamed from: f  reason: collision with root package name */
        public Runnable f69245f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69246g;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f69247e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f69248f;

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
                this.f69248f = eVar;
                this.f69247e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f69247e.run();
                    } finally {
                        this.f69248f.a();
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
            this.f69246g = taskManager;
            this.f69244e = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f69244e.poll();
                    this.f69245f = poll;
                    if (poll != null) {
                        this.f69246g.f69227e.put(this.f69246g.f69230h.submit(this.f69245f), this.f69245f);
                    }
                }
            }
        }

        public synchronized void b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f69244e.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f69244e.offer(new a(this, runnable));
                    if (this.f69245f == null) {
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
