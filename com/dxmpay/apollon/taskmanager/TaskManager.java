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
    public static final boolean f69713j;
    public static final String k;
    public static HashMap<String, TaskManager> sTskMgrMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f69714a;

    /* renamed from: b  reason: collision with root package name */
    public String f69715b;

    /* renamed from: c  reason: collision with root package name */
    public Timer f69716c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f69717d;

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f69718e;

    /* renamed from: f  reason: collision with root package name */
    public final BlockingQueue<Runnable> f69719f;

    /* renamed from: g  reason: collision with root package name */
    public final ThreadFactory f69720g;

    /* renamed from: h  reason: collision with root package name */
    public d f69721h;

    /* renamed from: i  reason: collision with root package name */
    public e f69722i;

    /* loaded from: classes9.dex */
    public class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f69723a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f69724b;

        /* renamed from: c  reason: collision with root package name */
        public long f69725c;

        /* renamed from: d  reason: collision with root package name */
        public long f69726d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f69727e;

        /* renamed from: f  reason: collision with root package name */
        public long f69728f;

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
            this.f69726d = j2;
            this.f69728f = System.currentTimeMillis() + j2;
            this.f69725c = j3;
            this.f69727e = z;
            this.f69724b = runnable;
            this.f69723a = str;
        }
    }

    /* loaded from: classes9.dex */
    public class a implements ThreadFactory {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicInteger f69729e;

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
            this.f69729e = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, runnable)) == null) {
                return new Thread(runnable, "DxmWalletTask #" + this.f69729e.getAndIncrement());
            }
            return (Thread) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69730e;

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
            this.f69730e = taskManager;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f69730e.d();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f69731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Task f69732f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69733g;

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
            this.f69733g = taskManager;
            this.f69731e = j2;
            this.f69732f = task;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Thread.sleep(this.f69731e);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                this.f69733g.o(this.f69732f);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69734e;

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
            this.f69734e = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.f69734e.f69718e.remove((Future) runnable);
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
        f69713j = ApollonConstants.DEBUG;
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
        this.f69714a = Long.MAX_VALUE;
        this.f69716c = new Timer();
        this.f69718e = new HashMap<>();
        this.f69719f = new LinkedBlockingQueue(10);
        this.f69720g = new a(this);
        this.f69721h = new d(this, 5, 128, 1L, TimeUnit.SECONDS, this.f69719f, this.f69720g);
        this.f69722i = new e(this, null);
        this.f69717d = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (dVar = this.f69721h) == null) {
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
                    taskManager.f69715b = str;
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
                if (str != null && str.equals(next.f69723a)) {
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
            if (task == null || task.f69724b == null) {
                return false;
            }
            synchronized (this.f69717d) {
                ArrayList<Task> b2 = b(str);
                if (!j(task, b2)) {
                    if (task.f69728f <= System.currentTimeMillis()) {
                        m(task);
                    } else if (task.f69726d > 0) {
                        m(task);
                    }
                    if (task.f69725c > 0) {
                        task.f69728f = System.currentTimeMillis() + task.f69726d + task.f69725c;
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
            ArrayList<Task> arrayList = this.f69717d.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f69717d.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public void cancelAllTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            synchronized (this.f69717d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    l(it.next());
                }
                b2.clear();
                this.f69717d.remove(str);
            }
        }
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this.f69717d) {
                ArrayList<Task> b2 = b(str);
                Iterator<Task> it = b2.iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.f69723a.equals(str2)) {
                        l(next);
                        b2.remove(next.f69723a);
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            boolean z = f69713j;
            synchronized (this.f69717d) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f69714a = Long.MAX_VALUE;
                for (String str : this.f69717d.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task> it = b(str).iterator();
                    while (it.hasNext()) {
                        Task next = it.next();
                        if (next.f69728f - currentTimeMillis < 1000) {
                            if (f69713j) {
                                String str2 = "task.mNextRunTime - current = " + (next.f69728f - currentTimeMillis);
                            }
                            m(next);
                            if (next.f69725c > 0) {
                                next.f69728f = next.f69725c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f69728f < this.f69714a) {
                            this.f69714a = next.f69728f;
                        }
                    }
                    if (this.f69714a < Long.MAX_VALUE) {
                        e(this.f69714a - currentTimeMillis);
                    }
                }
            }
        }
    }

    public final void e(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            if (f69713j) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.f69716c;
            if (timer != null) {
                timer.cancel();
                this.f69716c = null;
            }
            this.f69716c = new Timer();
            this.f69716c.schedule(new b(this), j2);
        }
    }

    public final void f(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, task) == null) {
            long j2 = task.f69728f;
            if (j2 < this.f69714a) {
                e(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    public final void g(Task task, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, task, j2) == null) {
            this.f69721h.execute(new c(this, j2, task));
        }
    }

    public final boolean i(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, task, str)) == null) {
            if (task == null || task.f69724b == null) {
                return false;
            }
            synchronized (this.f69717d) {
                ArrayList<Task> b2 = b(str);
                Task a2 = a(task.f69723a, b2);
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
                if (next != null && (str = next.f69723a) != null && str.equals(task.f69723a)) {
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
            if (task.f69727e) {
                this.f69722i.b(task.f69724b);
                return;
            }
            for (Future<?> future : this.f69718e.keySet()) {
                if (this.f69718e.get(future) == task.f69724b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    public final void m(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, task) == null) {
            if (task.f69726d > 0) {
                g(task, task.f69728f - System.currentTimeMillis());
            } else {
                o(task);
            }
        }
    }

    public final void o(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, task) == null) {
            if (task.f69725c > 0) {
                task.f69726d = 0L;
            }
            if (task.f69727e) {
                this.f69722i.execute(task.f69724b);
                return;
            }
            this.f69718e.put(this.f69721h.submit(task.f69724b), task.f69724b);
            if (f69713j) {
                String str = "execute task, " + task.f69723a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Timer timer = this.f69716c;
            if (timer != null) {
                timer.cancel();
                this.f69716c = null;
            }
            e eVar = this.f69722i;
            if (eVar != null && eVar.f69735e != null) {
                while (true) {
                    Runnable poll = this.f69722i.f69735e.poll();
                    if (poll == null) {
                        break;
                    }
                    this.f69722i.b(poll);
                }
            }
            d dVar = this.f69721h;
            if (dVar != null) {
                try {
                    dVar.shutdownNow();
                    this.f69721h.awaitTermination(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            String str = this.f69715b;
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
        public final LinkedList<Runnable> f69735e;

        /* renamed from: f  reason: collision with root package name */
        public Runnable f69736f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f69737g;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Runnable f69738e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f69739f;

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
                this.f69739f = eVar;
                this.f69738e = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    try {
                        this.f69738e.run();
                    } finally {
                        this.f69739f.a();
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
            this.f69737g = taskManager;
            this.f69735e = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.f69735e.poll();
                    this.f69736f = poll;
                    if (poll != null) {
                        this.f69737g.f69718e.put(this.f69737g.f69721h.submit(this.f69736f), this.f69736f);
                    }
                }
            }
        }

        public synchronized void b(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.f69735e.remove(runnable);
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.f69735e.offer(new a(this, runnable));
                    if (this.f69736f == null) {
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
