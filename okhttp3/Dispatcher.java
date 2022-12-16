package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
/* loaded from: classes9.dex */
public final class Dispatcher {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(773793992, "Lokhttp3/Dispatcher;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(773793992, "Lokhttp3/Dispatcher;");
        }
    }

    public Dispatcher() {
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
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque();
        this.runningAsyncCalls = new ArrayDeque();
        this.runningSyncCalls = new ArrayDeque();
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

    public Dispatcher(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
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

    private <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, deque, t) == null) {
            synchronized (this) {
                if (deque.remove(t)) {
                    runnable = this.idleCallback;
                } else {
                    throw new AssertionError("Call wasn't in-flight!");
                }
            }
            if (!promoteAndExecute() && runnable != null) {
                runnable.run();
            }
        }
    }

    private boolean promoteAndExecute() {
        InterceptResult invokeV;
        int i;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (runningCallsForHost(next) < this.maxRequestsPerHost) {
                        it.remove();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                if (runningCallsCount() > 0) {
                    z = true;
                } else {
                    z = false;
                }
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    private int runningCallsForHost(RealCall.AsyncCall asyncCall) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, asyncCall)) == null) {
            int i = 0;
            for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
                if (!asyncCall2.get().forWebSocket && asyncCall2.host().equals(asyncCall.host())) {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public void setMaxRequests(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i >= 1) {
                synchronized (this) {
                    this.maxRequests = i;
                }
                promoteAndExecute();
                return;
            }
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public void setMaxRequestsPerHost(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            if (i >= 1) {
                synchronized (this) {
                    this.maxRequestsPerHost = i;
                }
                promoteAndExecute();
                return;
            }
            throw new IllegalArgumentException("max < 1: " + i);
        }
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

    public void enqueue(RealCall.AsyncCall asyncCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, asyncCall) == null) {
            synchronized (this) {
                this.readyAsyncCalls.add(asyncCall);
            }
            promoteAndExecute();
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

    public void finished(RealCall.AsyncCall asyncCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, asyncCall) == null) {
            finished(this.runningAsyncCalls, asyncCall);
        }
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, runnable) == null) {
            synchronized (this) {
                this.idleCallback = runnable;
            }
        }
    }

    public void finished(RealCall realCall) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, realCall) == null) {
            finished(this.runningSyncCalls, realCall);
        }
    }

    public synchronized int getMaxRequests() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i = this.maxRequests;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public synchronized int getMaxRequestsPerHost() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.maxRequestsPerHost;
            }
            return i;
        }
        return invokeV.intValue;
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
}
