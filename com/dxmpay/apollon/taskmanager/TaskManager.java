package com.dxmpay.apollon.taskmanager;

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
/* loaded from: classes7.dex */
public final class TaskManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long TIMESLICE = 1000;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f52306b;
    public static HashMap<String, TaskManager> sTskMgrMap;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public long f52307c;

    /* renamed from: d  reason: collision with root package name */
    public String f52308d;

    /* renamed from: e  reason: collision with root package name */
    public Timer f52309e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, ArrayList<Task>> f52310f;

    /* renamed from: g  reason: collision with root package name */
    public final HashMap<Future<?>, Runnable> f52311g;

    /* renamed from: h  reason: collision with root package name */
    public final BlockingQueue<Runnable> f52312h;

    /* renamed from: i  reason: collision with root package name */
    public final ThreadFactory f52313i;

    /* renamed from: j  reason: collision with root package name */
    public a f52314j;
    public b k;

    /* loaded from: classes7.dex */
    public class Task {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f52318b;

        /* renamed from: c  reason: collision with root package name */
        public long f52319c;

        /* renamed from: d  reason: collision with root package name */
        public long f52320d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f52321e;

        /* renamed from: f  reason: collision with root package name */
        public long f52322f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ TaskManager f52323g;

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
            this.f52323g = taskManager;
            this.f52320d = j2;
            this.f52322f = System.currentTimeMillis() + j2;
            this.f52319c = j3;
            this.f52321e = z;
            this.f52318b = runnable;
            this.a = str;
        }
    }

    /* loaded from: classes7.dex */
    public class a extends ThreadPoolExecutor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TaskManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(TaskManager taskManager, int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
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
            this.a = taskManager;
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, th) == null) {
                this.a.f52311g.remove((Future) runnable);
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
        a = ApollonConstants.DEBUG;
        f52306b = TaskManager.class.getSimpleName();
        sTskMgrMap = new HashMap<>();
    }

    public TaskManager() {
        a aVar;
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
        this.f52307c = Long.MAX_VALUE;
        this.f52309e = new Timer();
        this.f52311g = new HashMap<>();
        this.f52312h = new LinkedBlockingQueue(10);
        this.f52313i = new ThreadFactory(this) { // from class: com.dxmpay.apollon.taskmanager.TaskManager.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ TaskManager a;

            /* renamed from: b  reason: collision with root package name */
            public final AtomicInteger f52315b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
                this.f52315b = new AtomicInteger(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, runnable)) == null) {
                    return new Thread(runnable, "DxmWalletTask #" + this.f52315b.getAndIncrement());
                }
                return (Thread) invokeL.objValue;
            }
        };
        this.f52314j = new a(this, 5, 128, 1L, TimeUnit.SECONDS, this.f52312h, this.f52313i);
        this.k = new b();
        this.f52310f = new HashMap<>();
        if (!ChannelUtils.isSpecailPackage() || (aVar = this.f52314j) == null) {
            return;
        }
        aVar.allowCoreThreadTimeOut(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, task) == null) {
            if (task.f52319c > 0) {
                task.f52320d = 0L;
            }
            if (task.f52321e) {
                this.k.execute(task.f52318b);
                return;
            }
            this.f52311g.put(this.f52314j.submit(task.f52318b), task.f52318b);
            if (a) {
                String str = "execute task, " + task.a + " execute time is " + System.currentTimeMillis();
            }
        }
    }

    public static synchronized TaskManager getInstance(String str) {
        InterceptResult invokeL;
        TaskManager taskManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, str)) == null) {
            synchronized (TaskManager.class) {
                taskManager = sTskMgrMap.get(str);
                if (taskManager == null) {
                    taskManager = new TaskManager();
                    sTskMgrMap.put(str, taskManager);
                    taskManager.f52308d = str;
                }
            }
            return taskManager;
        }
        return (TaskManager) invokeL.objValue;
    }

    public boolean addTask(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, task, str)) == null) {
            if (task == null || task.f52318b == null) {
                return false;
            }
            synchronized (this.f52310f) {
                ArrayList<Task> a2 = a(str);
                if (!a(task, a2)) {
                    if (task.f52322f <= System.currentTimeMillis()) {
                        c(task);
                    } else if (task.f52320d > 0) {
                        c(task);
                    }
                    if (task.f52319c > 0) {
                        task.f52322f = System.currentTimeMillis() + task.f52320d + task.f52319c;
                        a2.add(task);
                        a(task);
                    }
                } else {
                    a(task, str);
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void cancelAllTasks(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this.f52310f) {
                ArrayList<Task> a2 = a(str);
                Iterator<Task> it = a2.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                a2.clear();
                this.f52310f.remove(str);
            }
        }
    }

    public void cancelTask(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            synchronized (this.f52310f) {
                ArrayList<Task> a2 = a(str);
                Iterator<Task> it = a2.iterator();
                while (it.hasNext()) {
                    Task next = it.next();
                    if (next.a.equals(str2)) {
                        b(next);
                        a2.remove(next.a);
                    }
                }
            }
        }
    }

    public void shutdown() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = this.f52309e;
            if (timer != null) {
                timer.cancel();
                this.f52309e = null;
            }
            b bVar = this.k;
            if (bVar != null && bVar.a != null) {
                while (true) {
                    Runnable poll = this.k.a.poll();
                    if (poll == null) {
                        break;
                    }
                    this.k.a(poll);
                }
            }
            a aVar = this.f52314j;
            if (aVar != null) {
                try {
                    aVar.shutdownNow();
                    this.f52314j.awaitTermination(3L, TimeUnit.SECONDS);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
            String str = this.f52308d;
            if (str != null) {
                sTskMgrMap.remove(str);
            }
        }
    }

    private void b(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, task) == null) {
            if (task.f52321e) {
                this.k.a(task.f52318b);
                return;
            }
            for (Future<?> future : this.f52311g.keySet()) {
                if (this.f52311g.get(future) == task.f52318b && future != null && (!future.isCancelled() || !future.isDone())) {
                    future.cancel(true);
                }
            }
        }
    }

    private void c(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, task) == null) {
            if (task.f52320d > 0) {
                a(task, task.f52322f - System.currentTimeMillis());
            } else {
                d(task);
            }
        }
    }

    private Task a(String str, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, str, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (str != null && str.equals(next.a)) {
                    return next;
                }
            }
            return null;
        }
        return (Task) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class b implements Executor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final LinkedList<Runnable> a;

        /* renamed from: b  reason: collision with root package name */
        public Runnable f52324b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TaskManager f52325c;

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
            this.f52325c = taskManager;
            this.a = new LinkedList<>();
        }

        public synchronized void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    Runnable poll = this.a.poll();
                    this.f52324b = poll;
                    if (poll != null) {
                        this.f52325c.f52311g.put(this.f52325c.f52314j.submit(this.f52324b), this.f52324b);
                    }
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
                synchronized (this) {
                    this.a.offer(new Runnable(this, runnable) { // from class: com.dxmpay.apollon.taskmanager.TaskManager.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Runnable a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ b f52326b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, runnable};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f52326b = this;
                            this.a = runnable;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                try {
                                    this.a.run();
                                } finally {
                                    this.f52326b.a();
                                }
                            }
                        }
                    });
                    if (this.f52324b == null) {
                        a();
                    }
                }
            }
        }

        public synchronized void a(Runnable runnable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
                synchronized (this) {
                    this.a.remove(runnable);
                }
            }
        }
    }

    private ArrayList<Task> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            ArrayList<Task> arrayList = this.f52310f.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            this.f52310f.put(str, arrayList);
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    private boolean a(Task task, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, task, str)) == null) {
            if (task == null || task.f52318b == null) {
                return false;
            }
            synchronized (this.f52310f) {
                ArrayList<Task> a2 = a(str);
                Task a3 = a(task.a, a2);
                if (a3 != null) {
                    b(a3);
                    a2.remove(a3);
                    addTask(task, str);
                    return true;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    private void a(Task task) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, task) == null) {
            long j2 = task.f52322f;
            if (j2 < this.f52307c) {
                a(Math.max(j2 - System.currentTimeMillis(), 1000L));
            }
        }
    }

    private void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, this, j2) == null) {
            if (a) {
                String str = "intervalMillis: " + j2;
            }
            Timer timer = this.f52309e;
            if (timer != null) {
                timer.cancel();
                this.f52309e = null;
            }
            this.f52309e = new Timer();
            this.f52309e.schedule(new TimerTask(this) { // from class: com.dxmpay.apollon.taskmanager.TaskManager.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TaskManager a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.a.a();
                    }
                }
            }, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            boolean z = a;
            synchronized (this.f52310f) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f52307c = Long.MAX_VALUE;
                for (String str : this.f52310f.keySet()) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<Task> it = a(str).iterator();
                    while (it.hasNext()) {
                        Task next = it.next();
                        if (next.f52322f - currentTimeMillis < 1000) {
                            if (a) {
                                String str2 = "task.mNextRunTime - current = " + (next.f52322f - currentTimeMillis);
                            }
                            c(next);
                            if (next.f52319c > 0) {
                                next.f52322f = next.f52319c + currentTimeMillis;
                                arrayList.add(next);
                            }
                        }
                        if (next.f52322f < this.f52307c) {
                            this.f52307c = next.f52322f;
                        }
                    }
                    if (this.f52307c < Long.MAX_VALUE) {
                        a(this.f52307c - currentTimeMillis);
                    }
                }
            }
        }
    }

    private boolean a(Task task, ArrayList<Task> arrayList) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, task, arrayList)) == null) {
            Iterator<Task> it = arrayList.iterator();
            while (it.hasNext()) {
                Task next = it.next();
                if (next != null && (str = next.a) != null && str.equals(task.a)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private void a(Task task, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65544, this, task, j2) == null) {
            this.f52314j.execute(new Runnable(this, j2, task) { // from class: com.dxmpay.apollon.taskmanager.TaskManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ long a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Task f52316b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ TaskManager f52317c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(j2), task};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f52317c = this;
                    this.a = j2;
                    this.f52316b = task;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            Thread.sleep(this.a);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        this.f52317c.d(this.f52316b);
                    }
                }
            });
        }
    }
}
