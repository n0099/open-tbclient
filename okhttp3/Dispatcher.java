package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.Util;
/* loaded from: classes5.dex */
public final class Dispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ExecutorService executorService;
    @Nullable
    public Runnable idleCallback;
    public int maxRequests;
    public int maxRequestsPerHost;
    public final Deque<RealCall.AsyncCall> readyAsyncCalls;
    public final Deque<RealCall.AsyncCall> runningAsyncCalls;
    public final Deque<RealCall> runningSyncCalls;

    public Dispatcher(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
        this.executorService = executorService;
    }

    private void promoteCalls() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.runningAsyncCalls.size() >= this.maxRequests || this.readyAsyncCalls.isEmpty()) {
            return;
        }
        Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
        while (it.hasNext()) {
            RealCall.AsyncCall next = it.next();
            if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                it.remove();
                this.runningAsyncCalls.add(next);
                executorService().execute(next);
            }
            if (this.runningAsyncCalls.size() >= this.maxRequests) {
                return;
            }
        }
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, asyncCall)) == null) {
            int i2 = 0;
            for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
                if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeL.intValue;
    }

    public synchronized void cancelAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                    asyncCall.get().cancel();
                }
                for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
                    asyncCall2.get().cancel();
                }
                for (RealCall realCall : this.runningSyncCalls) {
                    realCall.cancel();
                }
            }
        }
    }

    public synchronized void enqueue(RealCall.AsyncCall asyncCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, asyncCall) == null) {
            synchronized (this) {
                if (this.runningAsyncCalls.size() < this.maxRequests && runningCallsForHost(asyncCall) < this.maxRequestsPerHost) {
                    this.runningAsyncCalls.add(asyncCall);
                    executorService().execute(asyncCall);
                } else {
                    this.readyAsyncCalls.add(asyncCall);
                }
            }
        }
    }

    public synchronized void executed(RealCall realCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, realCall) == null) {
            synchronized (this) {
                this.runningSyncCalls.add(realCall);
            }
        }
    }

    public synchronized ExecutorService executorService() {
        InterceptResult invokeV;
        ExecutorService executorService;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.executorService == null) {
                    this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
                }
                executorService = this.executorService;
            }
            return executorService;
        }
        return (ExecutorService) invokeV.objValue;
    }

    public void finished(RealCall.AsyncCall asyncCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, asyncCall) == null) {
            finished(this.runningAsyncCalls, asyncCall, true);
        }
    }

    public synchronized int getMaxRequests() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this.maxRequests;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxRequestsPerHost() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.maxRequestsPerHost;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public synchronized List<Call> queuedCalls() {
        InterceptResult invokeV;
        List<Call> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
                    arrayList.add(asyncCall.get());
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int queuedCallsCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                size = this.readyAsyncCalls.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized List<Call> runningCalls() {
        InterceptResult invokeV;
        List<Call> unmodifiableList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.runningSyncCalls);
                for (RealCall.AsyncCall asyncCall : this.runningAsyncCalls) {
                    arrayList.add(asyncCall.get());
                }
                unmodifiableList = Collections.unmodifiableList(arrayList);
            }
            return unmodifiableList;
        }
        return (List) invokeV.objValue;
    }

    public synchronized int runningCallsCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                size = this.runningAsyncCalls.size() + this.runningSyncCalls.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, runnable) == null) {
            synchronized (this) {
                this.idleCallback = runnable;
            }
        }
    }

    public synchronized void setMaxRequests(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 1) {
                    this.maxRequests = i2;
                    promoteCalls();
                } else {
                    throw new IllegalArgumentException("max < 1: " + i2);
                }
            }
        }
    }

    public synchronized void setMaxRequestsPerHost(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            synchronized (this) {
                if (i2 >= 1) {
                    this.maxRequestsPerHost = i2;
                    promoteCalls();
                } else {
                    throw new IllegalArgumentException("max < 1: " + i2);
                }
            }
        }
    }

    public void finished(RealCall realCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, realCall) == null) {
            finished(this.runningSyncCalls, realCall, false);
        }
    }

    private <T> void finished(Deque<T> deque, T t, boolean z) {
        int runningCallsCount;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, this, deque, t, z) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    if (z) {
                        promoteCalls();
                    }
                    runningCallsCount = runningCallsCount();
                    runnable = this.idleCallback;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            if (runningCallsCount != 0 || runnable == null) {
                return;
            }
            runnable.run();
        }
    }

    public Dispatcher() {
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
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
    }
}
