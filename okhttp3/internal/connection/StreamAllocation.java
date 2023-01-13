package okhttp3.internal.connection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
/* loaded from: classes9.dex */
public final class StreamAllocation {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "StreamAllocation";
    @Nullable
    public static volatile ScheduledExecutorService scheduledExecutorService;
    public transient /* synthetic */ FieldHolder $fh;
    public final Address address;
    public List<RealConnection> attemptList;
    public final Call call;
    public final Object callStackTrace;
    public boolean canceled;
    public HttpCodec codec;
    public List<RealConnection> connectingList;
    public RealConnection connection;
    public final ConnectionPool connectionPool;
    public final AtomicBoolean connectionSuccess;
    public volatile CountDownLatch countDownLatch;
    public int currentAddressIndex;
    public final EventListener eventListener;
    @Nullable
    public ExecutorService executorService;
    public List<RealConnection> failedList;
    public boolean hasFallbackToIPv4;
    public int ipv6FallbackTimerInMs;
    public boolean isMultipleConnectEnabled;
    public boolean isRetryStream;
    public Timer mFallbackTimer;
    public int maxMultiConnectNum;
    public int maxPreConnect;
    public long multiConnectDelayTimeInMs;
    public List<MultipleConnectTask> multipleConnectTasks;
    public Map<HttpUrl, Integer> preConnectHttpUrlMap;
    public int preConnectNum;
    public int refusedStreamCount;
    public boolean released;
    public boolean reportedAcquired;
    public RealConnection result;
    public Route route;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;
    public List<RealConnection> successList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1384512048, "Lokhttp3/internal/connection/StreamAllocation;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1384512048, "Lokhttp3/internal/connection/StreamAllocation;");
        }
    }

    /* loaded from: classes9.dex */
    public class FallbackConnectTask extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean canceled;
        public int connectTimeout;
        public boolean connectionRetryEnabled;
        public RealConnection fallbackConnection;
        public RealConnection mainConnection;
        public int pingIntervalMillis;
        public int readTimeout;
        public RouteSelector.Selection routeSelection;
        public boolean started;
        public final /* synthetic */ StreamAllocation this$0;
        public int writeTimeout;

        public FallbackConnectTask(StreamAllocation streamAllocation, RealConnection realConnection, RealConnection realConnection2, RouteSelector.Selection selection, int i, int i2, int i3, int i4, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {streamAllocation, realConnection, realConnection2, selection, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = streamAllocation;
            this.connectTimeout = i;
            this.readTimeout = i2;
            this.writeTimeout = i3;
            this.pingIntervalMillis = i4;
            this.connectionRetryEnabled = z;
            this.routeSelection = selection;
            this.mainConnection = realConnection;
            this.fallbackConnection = realConnection2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isMainConnectReady() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                RealConnection realConnection = this.mainConnection;
                if (realConnection == null || realConnection.socket() == null || !this.mainConnection.isHealthy(false)) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.canceled = true;
                if (this.started) {
                    this.fallbackConnection.cancel();
                }
                return super.cancel();
            }
            return invokeV.booleanValue;
        }

        public boolean isStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.started;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    if (!this.canceled && !isMainConnectReady()) {
                        this.started = true;
                        this.this$0.route = this.routeSelection.markNextIPv4();
                        this.fallbackConnection.routeList = this.routeSelection.getAll();
                        if (this.this$0.isMultipleConnectEnabled && !this.this$0.isRetryStream && this.fallbackConnection != null) {
                            new MultipleConnectTask(this.this$0, this.fallbackConnection, this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, false, this).started = true;
                        }
                        this.fallbackConnection.connect(this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, this.connectionRetryEnabled, this.this$0.call, this.this$0.eventListener);
                        if (isMainConnectReady()) {
                            this.fallbackConnection.cancel();
                        } else {
                            this.mainConnection.cancel();
                        }
                    }
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class MultipleConnectTask implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile boolean canceled;
        public int connectTimeout;
        public boolean connectionRetryEnabled;
        public RealConnection currentConnection;
        public FallbackConnectTask fallbackConnectTask;
        public int pingIntervalMillis;
        public int readTimeout;
        public volatile boolean started;
        public final /* synthetic */ StreamAllocation this$0;
        public int writeTimeout;

        public MultipleConnectTask(@Nonnull StreamAllocation streamAllocation, RealConnection realConnection, int i, int i2, int i3, int i4, boolean z, FallbackConnectTask fallbackConnectTask) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {streamAllocation, realConnection, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), fallbackConnectTask};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = streamAllocation;
            this.connectTimeout = i;
            this.readTimeout = i2;
            this.writeTimeout = i3;
            this.pingIntervalMillis = i4;
            this.connectionRetryEnabled = z;
            this.currentConnection = realConnection;
            this.fallbackConnectTask = fallbackConnectTask;
            streamAllocation.attemptList.add(this.currentConnection);
            streamAllocation.multipleConnectTasks.add(this);
            setConnectStateCallback(this.currentConnection);
        }

        public MultipleConnectTask getTaskByConnection(RealConnection realConnection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, realConnection)) == null) {
                for (MultipleConnectTask multipleConnectTask : this.this$0.multipleConnectTasks) {
                    if (multipleConnectTask.currentConnection == realConnection) {
                        return multipleConnectTask;
                    }
                }
                return null;
            }
            return (MultipleConnectTask) invokeL.objValue;
        }

        private void setConnectStateCallback(RealConnection realConnection) {
            RealConnection realConnection2;
            Route findNextIpv4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65545, this, realConnection) == null) {
                if (this.this$0.currentAddressIndex < Math.min(this.this$0.maxMultiConnectNum - 1, this.this$0.routeSelection.getIPv4Size() - 1) && (findNextIpv4 = this.this$0.findNextIpv4()) != null) {
                    realConnection2 = new RealConnection(this.this$0.connectionPool, findNextIpv4);
                } else {
                    realConnection2 = null;
                }
                if (this.this$0.currentAddressIndex < Math.min(this.this$0.maxMultiConnectNum, this.this$0.routeSelection.getIPv4Size())) {
                    realConnection.setConnectCompleteCallback(new RealConnection.ConnectComplete(this, realConnection, realConnection2) { // from class: okhttp3.internal.connection.StreamAllocation.MultipleConnectTask.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultipleConnectTask this$1;
                        public final /* synthetic */ RealConnection val$currentConnection;
                        public final /* synthetic */ RealConnection val$finalNewMultiConnection;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, realConnection, realConnection2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$1 = this;
                            this.val$currentConnection = realConnection;
                            this.val$finalNewMultiConnection = realConnection2;
                        }

                        @Override // okhttp3.internal.connection.RealConnection.ConnectComplete
                        public void receiveConnectState(int i) {
                            RealConnection realConnection3;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                                if (i != 0) {
                                    if (i != 1) {
                                        if (i == 2) {
                                            if (this.this$1.fallbackConnectTask != null && this.this$1.fallbackConnectTask.isMainConnectReady()) {
                                                for (MultipleConnectTask multipleConnectTask : this.this$1.this$0.multipleConnectTasks) {
                                                    multipleConnectTask.cancel();
                                                }
                                                return;
                                            }
                                            StreamAllocation.access$708(this.this$1.this$0);
                                            this.this$1.this$0.connectingList.add(this.val$currentConnection);
                                            this.this$1.this$0.attemptList.remove(this.val$currentConnection);
                                            if (!this.this$1.this$0.failedList.contains(this.val$finalNewMultiConnection) && !this.this$1.this$0.connectingList.contains(this.val$finalNewMultiConnection) && this.this$1.this$0.failedList.size() < this.this$1.this$0.maxMultiConnectNum && (realConnection3 = this.val$finalNewMultiConnection) != null) {
                                                MultipleConnectTask multipleConnectTask2 = this.this$1;
                                                StreamAllocation.access$2900().schedule(new Runnable(this, new MultipleConnectTask(multipleConnectTask2.this$0, realConnection3, multipleConnectTask2.connectTimeout, this.this$1.readTimeout, this.this$1.writeTimeout, this.this$1.pingIntervalMillis, false, this.this$1.fallbackConnectTask)) { // from class: okhttp3.internal.connection.StreamAllocation.MultipleConnectTask.1.1
                                                    public static /* synthetic */ Interceptable $ic;
                                                    public transient /* synthetic */ FieldHolder $fh;
                                                    public final /* synthetic */ AnonymousClass1 this$2;
                                                    public final /* synthetic */ MultipleConnectTask val$multipleDelayConnectTask;

                                                    {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 != null) {
                                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                                            newInitContext.initArgs = r2;
                                                            Object[] objArr = {this, r7};
                                                            interceptable3.invokeUnInit(65536, newInitContext);
                                                            int i2 = newInitContext.flag;
                                                            if ((i2 & 1) != 0) {
                                                                int i3 = i2 & 2;
                                                                newInitContext.thisArg = this;
                                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                                return;
                                                            }
                                                        }
                                                        this.this$2 = this;
                                                        this.val$multipleDelayConnectTask = r7;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        Interceptable interceptable3 = $ic;
                                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                                            this.this$2.this$1.this$0.executorService.submit(this.val$multipleDelayConnectTask);
                                                        }
                                                    }
                                                }, this.this$1.this$0.multiConnectDelayTimeInMs, TimeUnit.MILLISECONDS);
                                            }
                                        }
                                    } else if (this.this$1.fallbackConnectTask != null && this.this$1.fallbackConnectTask.isMainConnectReady()) {
                                        for (MultipleConnectTask multipleConnectTask3 : this.this$1.this$0.multipleConnectTasks) {
                                            multipleConnectTask3.cancel();
                                        }
                                    } else {
                                        this.this$1.this$0.failedList.add(this.val$currentConnection);
                                        this.val$currentConnection.cancel();
                                        this.this$1.this$0.connectingList.remove(this.val$currentConnection);
                                        if (!this.this$1.this$0.failedList.contains(this.val$finalNewMultiConnection) && !this.this$1.this$0.connectingList.contains(this.val$finalNewMultiConnection) && this.this$1.this$0.failedList.size() < this.this$1.this$0.maxMultiConnectNum) {
                                            if (this.this$1.this$0.attemptList.contains(this.val$finalNewMultiConnection)) {
                                                MultipleConnectTask taskByConnection = this.this$1.getTaskByConnection(this.val$finalNewMultiConnection);
                                                if (taskByConnection != null && !taskByConnection.isStarted()) {
                                                    MultipleConnectTask multipleConnectTask4 = this.this$1;
                                                    taskByConnection.connectionRetryEnabled = multipleConnectTask4.this$0.isConnectionRetryNeeded(multipleConnectTask4.connectionRetryEnabled);
                                                    this.this$1.this$0.executorService.submit(taskByConnection);
                                                }
                                            } else {
                                                RealConnection realConnection4 = this.val$finalNewMultiConnection;
                                                if (realConnection4 != null) {
                                                    MultipleConnectTask multipleConnectTask5 = this.this$1;
                                                    StreamAllocation streamAllocation = multipleConnectTask5.this$0;
                                                    int i2 = multipleConnectTask5.connectTimeout;
                                                    int i3 = this.this$1.readTimeout;
                                                    int i4 = this.this$1.writeTimeout;
                                                    int i5 = this.this$1.pingIntervalMillis;
                                                    MultipleConnectTask multipleConnectTask6 = this.this$1;
                                                    this.this$1.this$0.executorService.submit(new MultipleConnectTask(streamAllocation, realConnection4, i2, i3, i4, i5, multipleConnectTask6.this$0.isConnectionRetryNeeded(multipleConnectTask6.connectionRetryEnabled), this.this$1.fallbackConnectTask));
                                                }
                                            }
                                        }
                                        if (this.this$1.this$0.failedList.size() >= this.this$1.this$0.maxMultiConnectNum || this.this$1.this$0.failedList.size() >= this.this$1.this$0.routeSelection.getIPv4Size()) {
                                            this.this$1.this$0.countDownLatch.countDown();
                                        }
                                    }
                                } else if (this.this$1.this$0.connectionSuccess.compareAndSet(false, true)) {
                                    for (MultipleConnectTask multipleConnectTask7 : this.this$1.this$0.multipleConnectTasks) {
                                        if (multipleConnectTask7 != this.this$1) {
                                            multipleConnectTask7.cancel();
                                        }
                                    }
                                    if (this.this$1.fallbackConnectTask != null) {
                                        if (this.this$1.fallbackConnectTask.isMainConnectReady()) {
                                            this.val$currentConnection.cancel();
                                            return;
                                        }
                                        this.this$1.fallbackConnectTask.mainConnection.cancel();
                                    }
                                    if (this.val$currentConnection != this.this$1.this$0.connection) {
                                        synchronized (this.this$1.this$0.connectionPool) {
                                            this.this$1.this$0.releaseAndAcquire(this.val$currentConnection);
                                        }
                                        this.this$1.this$0.route = this.val$currentConnection.route();
                                        this.this$1.this$0.result = this.val$currentConnection;
                                    }
                                    this.this$1.this$0.successList.add(this.val$currentConnection);
                                    this.this$1.this$0.countDownLatch.countDown();
                                    this.this$1.this$0.multipleConnectTasks.clear();
                                    this.this$1.this$0.connectingList.clear();
                                    this.this$1.this$0.attemptList.clear();
                                }
                            }
                        }
                    });
                }
            }
        }

        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.canceled = true;
                if (this.started) {
                    this.currentConnection.cancel();
                }
            }
        }

        public boolean isStarted() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.started;
            }
            return invokeV.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                try {
                    if (!this.canceled && !isStarted() && this.this$0.successList.size() <= 0) {
                        this.started = true;
                        if (this.this$0.attemptList.contains(this.currentConnection)) {
                            this.currentConnection.connect(this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, this.connectionRetryEnabled, this.this$0.call, this.this$0.eventListener);
                        }
                    }
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Object callStackTrace;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {streamAllocation, obj};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectionPool, address, call, eventListener, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.maxMultiConnectNum = 0;
        this.multiConnectDelayTimeInMs = 0L;
        this.isMultipleConnectEnabled = false;
        this.currentAddressIndex = 0;
        this.isRetryStream = false;
        this.attemptList = new CopyOnWriteArrayList();
        this.connectingList = new CopyOnWriteArrayList();
        this.failedList = new CopyOnWriteArrayList();
        this.successList = new CopyOnWriteArrayList();
        this.multipleConnectTasks = new CopyOnWriteArrayList();
        this.connectionSuccess = new AtomicBoolean(false);
        this.preConnectNum = 0;
        this.maxPreConnect = 0;
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    private boolean AddressListOnlyContainsIPv6(List<Route> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, list)) == null) {
            if (list == null || list.isEmpty()) {
                return false;
            }
            for (Route route : list) {
                if (!(route.socketAddress().getAddress() instanceof Inet6Address)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private void release(RealConnection realConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, realConnection) == null) {
            int size = realConnection.allocations.size();
            for (int i = 0; i < size; i++) {
                if (realConnection.allocations.get(i).get() == this) {
                    realConnection.allocations.remove(i);
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, realConnection)) == null) {
            if (this.codec == null && this.connection.allocations.size() == 1) {
                Socket deallocate = deallocate(true, false, false);
                this.connection = realConnection;
                realConnection.allocations.add(this.connection.allocations.get(0));
                return deallocate;
            }
            throw new IllegalStateException();
        }
        return (Socket) invokeL.objValue;
    }

    public static /* synthetic */ int access$708(StreamAllocation streamAllocation) {
        int i = streamAllocation.currentAddressIndex;
        streamAllocation.currentAddressIndex = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnectionRetryNeeded(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65566, this, z)) == null) {
            if (this.isMultipleConnectEnabled) {
                if (z && this.failedList.size() >= this.maxMultiConnectNum - 1) {
                    return true;
                }
                return false;
            }
            return z;
        }
        return invokeZ.booleanValue;
    }

    public void setIsRetryStream(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.isRetryStream = z;
        }
    }

    public void acquire(RealConnection realConnection, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, realConnection, z) == null) {
            if (this.connection == null) {
                this.connection = realConnection;
                this.reportedAcquired = z;
                realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException();
        }
    }

    public static /* synthetic */ ScheduledExecutorService access$2900() {
        return scheduledExecutorService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Route findNextIpv4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            if (this.currentAddressIndex < this.maxMultiConnectNum) {
                return this.routeSelection.markNextIPv4();
            }
            return null;
        }
        return (Route) invokeV.objValue;
    }

    private Socket releaseIfNoNewStreams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            RealConnection realConnection = this.connection;
            if (realConnection != null && realConnection.noNewStreams) {
                return deallocate(false, false, true);
            }
            return null;
        }
        return (Socket) invokeV.objValue;
    }

    private RouteDatabase routeDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            return Internal.instance.routeDatabase(this.connectionPool);
        }
        return (RouteDatabase) invokeV.objValue;
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            if (scheduledExecutorService == null) {
                synchronized (StreamAllocation.class) {
                    if (scheduledExecutorService == null) {
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                    }
                }
            }
            return scheduledExecutorService;
        }
        return (ScheduledExecutorService) invokeV.objValue;
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.connectionPool) {
                this.canceled = true;
                httpCodec = this.codec;
                realConnection = this.connection;
            }
            if (httpCodec != null) {
                httpCodec.cancel();
            } else if (realConnection != null) {
                realConnection.cancel();
            }
        }
    }

    public HttpCodec codec() {
        InterceptResult invokeV;
        HttpCodec httpCodec;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this.connectionPool) {
                httpCodec = this.codec;
            }
            return httpCodec;
        }
        return (HttpCodec) invokeV.objValue;
    }

    public synchronized RealConnection connection() {
        InterceptResult invokeV;
        RealConnection realConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                realConnection = this.connection;
            }
            return realConnection;
        }
        return (RealConnection) invokeV.objValue;
    }

    public int getPreConnectNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.preConnectNum;
        }
        return invokeV.intValue;
    }

    public boolean hasMoreRoutes() {
        InterceptResult invokeV;
        RouteSelector.Selection selection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.route == null && (((selection = this.routeSelection) == null || !selection.hasNext()) && !this.routeSelector.hasNext())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this.connectionPool) {
                realConnection = this.connection;
                deallocate = deallocate(true, false, false);
                if (this.connection != null) {
                    realConnection = null;
                }
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null) {
                this.eventListener.connectionReleased(this.call, realConnection);
            }
        }
    }

    public Route route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.route;
        }
        return (Route) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            RealConnection connection = connection();
            if (connection != null) {
                return connection.toString();
            }
            return this.address.toString();
        }
        return (String) invokeV.objValue;
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Socket socket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z3) {
                this.codec = null;
            }
            if (z2) {
                this.released = true;
            }
            RealConnection realConnection = this.connection;
            if (realConnection == null) {
                return null;
            }
            if (z) {
                realConnection.noNewStreams = true;
            }
            if (this.codec != null) {
                return null;
            }
            if (!this.released && !this.connection.noNewStreams) {
                return null;
            }
            release(this.connection);
            if (this.connection.allocations.isEmpty()) {
                this.connection.idleAtNanos = System.nanoTime();
                if (Internal.instance.connectionBecameIdle(this.connectionPool, this.connection)) {
                    socket = this.connection.socket();
                    this.connection = null;
                    return socket;
                }
            }
            socket = null;
            this.connection = null;
            return socket;
        }
        return (Socket) invokeCommon.objValue;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048583, this, okHttpClient, chain, z)) == null) {
            int connectTimeoutMillis = chain.connectTimeoutMillis();
            int readTimeoutMillis = chain.readTimeoutMillis();
            int writeTimeoutMillis = chain.writeTimeoutMillis();
            int pingIntervalMillis = okHttpClient.pingIntervalMillis();
            boolean retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.ipv6FallbackTimerInMs = okHttpClient.getFallbackConnectDelayMs();
            this.executorService = okHttpClient.dispatcher().executorService();
            this.maxMultiConnectNum = this.call.request().getMaxMultiConnectNum();
            this.multiConnectDelayTimeInMs = this.call.request().getMultiConnectDelayTimeInMs();
            try {
                HttpCodec newCodec = findHealthyConnection(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, pingIntervalMillis, retryOnConnectionFailure, z).newCodec(okHttpClient, chain, this);
                synchronized (this.connectionPool) {
                    this.codec = newCodec;
                }
                return newCodec;
            } catch (IOException e) {
                throw new RouteException(e);
            }
        }
        return (HttpCodec) invokeLLZ.objValue;
    }

    private Route findAddressListStartWithIPv4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            for (int i = 0; i < this.routeSelection.getAll().size(); i++) {
                Route route = this.routeSelection.getAll().get(i);
                if (route.socketAddress().getAddress() instanceof Inet4Address) {
                    return route;
                }
            }
            return null;
        }
        return (Route) invokeV.objValue;
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this.connectionPool) {
                realConnection = this.connection;
                deallocate = deallocate(false, true, false);
                if (this.connection != null) {
                    realConnection = null;
                }
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null) {
                Internal.instance.timeoutExit(this.call, null);
                this.eventListener.connectionReleased(this.call, realConnection);
                this.eventListener.callEnd(this.call);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
        InterceptResult invokeCommon;
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        boolean z2;
        Route route;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        FallbackConnectTask fallbackConnectTask;
        RealConnection realConnection2;
        RealConnection realConnection3;
        List<Route> all;
        RouteSelector.Selection selection;
        Route route2;
        RouteSelector.Selection selection2;
        RouteSelector.Selection selection3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65563, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            Socket socket = null;
            this.result = null;
            synchronized (this.connectionPool) {
                if (!this.released) {
                    if (this.codec == null) {
                        if (!this.canceled) {
                            realConnection = this.connection;
                            releaseIfNoNewStreams = releaseIfNoNewStreams();
                            if (this.connection != null) {
                                this.result = this.connection;
                                realConnection = null;
                            }
                            if (!this.reportedAcquired) {
                                realConnection = null;
                            }
                            z2 = false;
                            if (this.result == null) {
                                Internal.instance.get(this.connectionPool, this.address, this, null);
                                if (this.connection != null) {
                                    this.result = this.connection;
                                    route = null;
                                    z3 = true;
                                } else {
                                    route = this.route;
                                }
                            } else {
                                route = null;
                            }
                            z3 = false;
                        } else {
                            throw new IOException("Canceled");
                        }
                    } else {
                        throw new IllegalStateException("codec != null");
                    }
                } else {
                    throw new IllegalStateException("released");
                }
            }
            Util.closeQuietly(releaseIfNoNewStreams);
            if (realConnection != null) {
                this.eventListener.connectionReleased(this.call, realConnection);
            }
            if (z3) {
                this.eventListener.connectionAcquired(this.call, this.result);
            }
            if (this.result != null) {
                this.route = this.connection.route();
                return this.result;
            }
            if (route == null && ((selection3 = this.routeSelection) == null || !selection3.hasNext())) {
                this.routeSelection = this.routeSelector.next();
                z4 = true;
            } else {
                z4 = false;
            }
            synchronized (this.connectionPool) {
                if (!this.canceled) {
                    if (z4) {
                        List<Route> all2 = this.routeSelection.getAll();
                        int size = all2.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                break;
                            }
                            Route route3 = all2.get(i5);
                            Internal.instance.get(this.connectionPool, this.address, this, route3);
                            if (this.connection != null) {
                                this.result = this.connection;
                                this.route = route3;
                                z3 = true;
                                break;
                            }
                            i5++;
                        }
                    }
                    if (!z3) {
                        if (route == null) {
                            route = this.routeSelection.next();
                        }
                        this.route = route;
                        this.refusedStreamCount = 0;
                        RealConnection realConnection4 = new RealConnection(this.connectionPool, route);
                        this.result = realConnection4;
                        acquire(realConnection4, false);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            }
            if (z3) {
                this.eventListener.connectionAcquired(this.call, this.result);
                return this.result;
            }
            if (this.ipv6FallbackTimerInMs > 0 && (route2 = this.route) != null && (route2.socketAddress().getAddress() instanceof Inet6Address) && (selection2 = this.routeSelection) != null && !AddressListOnlyContainsIPv6(selection2.getAll())) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (this.maxMultiConnectNum > 0 && this.multiConnectDelayTimeInMs > 0 && (selection = this.routeSelection) != null && selection.getIPv4Size() > 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            this.isMultipleConnectEnabled = z6;
            this.countDownLatch = new CountDownLatch(1);
            if (z5) {
                if (this.mFallbackTimer == null) {
                    this.mFallbackTimer = new Timer();
                }
                RealConnection realConnection5 = new RealConnection(this.connectionPool, findAddressListStartWithIPv4());
                FallbackConnectTask fallbackConnectTask2 = new FallbackConnectTask(this, this.result, realConnection5, this.routeSelection, i, i2, i3, i4, z);
                this.mFallbackTimer.schedule(fallbackConnectTask2, this.ipv6FallbackTimerInMs);
                fallbackConnectTask = fallbackConnectTask2;
                realConnection2 = realConnection5;
            } else {
                if (this.isMultipleConnectEnabled && !this.isRetryStream && (realConnection3 = this.result) != null) {
                    new MultipleConnectTask(this, realConnection3, i, i2, i3, i4, false, null).started = true;
                }
                fallbackConnectTask = null;
                realConnection2 = null;
            }
            RealConnection realConnection6 = this.result;
            RouteSelector.Selection selection4 = this.routeSelection;
            if (selection4 == null) {
                all = null;
            } else {
                all = selection4.getAll();
            }
            realConnection6.routeList = all;
            try {
            } catch (RuntimeException e) {
                try {
                    if (z5) {
                    }
                } catch (InterruptedException unused) {
                }
            }
            if (!shouldPoolConnection(this.result)) {
                return null;
            }
            this.result.connect(i, i2, i3, i4, isConnectionRetryNeeded(z), this.call, this.eventListener);
            if (!z5) {
                try {
                    if (!this.isRetryStream && this.isMultipleConnectEnabled) {
                        this.countDownLatch.await();
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                RealConnection realConnection7 = this.result;
                realConnection7.isFallbackConn = this.hasFallbackToIPv4;
                if (this.isMultipleConnectEnabled && this.currentAddressIndex > 1) {
                    z2 = true;
                }
                realConnection7.isMultiConnectTriggered = z2;
                RealConnection realConnection8 = this.result;
                realConnection8.addressIndex = realConnection8.route().addressIndex();
                routeDatabase().connected(this.result.route());
                synchronized (this.connectionPool) {
                    this.reportedAcquired = true;
                    Internal.instance.put(this.connectionPool, this.result);
                    if (this.result.isMultiplexed()) {
                        socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                        this.result = this.connection;
                    }
                }
                Util.closeQuietly(socket);
                this.eventListener.connectionAcquired(this.call, this.result);
                return this.result;
            }
            try {
                if (!this.isRetryStream && this.isMultipleConnectEnabled && this.connectionSuccess.get()) {
                    this.countDownLatch.await();
                }
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
            RealConnection realConnection72 = this.result;
            realConnection72.isFallbackConn = this.hasFallbackToIPv4;
            if (this.isMultipleConnectEnabled) {
                z2 = true;
            }
            realConnection72.isMultiConnectTriggered = z2;
            RealConnection realConnection82 = this.result;
            realConnection82.addressIndex = realConnection82.route().addressIndex();
            routeDatabase().connected(this.result.route());
            synchronized (this.connectionPool) {
            }
            if (z5) {
                if (!this.isRetryStream && this.isMultipleConnectEnabled) {
                    this.countDownLatch.await();
                    if (this.successList.size() > 0) {
                        this.result = this.successList.get(0);
                    } else if (this.failedList.size() >= this.maxMultiConnectNum || this.failedList.size() >= this.routeSelection.getIPv4Size()) {
                        throw e;
                    }
                } else {
                    throw e;
                }
            } else if (!this.isRetryStream && this.isMultipleConnectEnabled) {
                this.countDownLatch.await();
                if (this.successList.size() > 0) {
                    this.result = this.successList.get(0);
                } else if (this.failedList.size() >= this.maxMultiConnectNum || this.failedList.size() >= this.routeSelection.getIPv4Size()) {
                    throw e;
                }
            } else {
                this.hasFallbackToIPv4 = true;
                if (fallbackConnectTask.isStarted() && ((this.result.socket() == null || !this.result.isHealthy(false)) && realConnection2.socket() != null && realConnection2.isHealthy(false))) {
                    release(this.connection);
                    this.connection = null;
                    synchronized (this.connectionPool) {
                        acquire(realConnection2, this.reportedAcquired);
                        this.route = realConnection2.route();
                        this.result = realConnection2;
                    }
                } else {
                    if (!fallbackConnectTask.isStarted()) {
                        fallbackConnectTask.cancel();
                    } else {
                        fallbackConnectTask.cancel();
                        this.route = this.routeSelection.markNextIPv4();
                    }
                    throw e;
                }
            }
            RealConnection realConnection722 = this.result;
            realConnection722.isFallbackConn = this.hasFallbackToIPv4;
            if (this.isMultipleConnectEnabled) {
            }
            realConnection722.isMultiConnectTriggered = z2;
            RealConnection realConnection822 = this.result;
            realConnection822.addressIndex = realConnection822.route().addressIndex();
            routeDatabase().connected(this.result.route());
            synchronized (this.connectionPool) {
            }
        } else {
            return (RealConnection) invokeCommon.objValue;
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65564, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (RealConnection) invokeCommon.objValue;
        }
        while (true) {
            RealConnection findConnection = findConnection(i, i2, i3, i4, z);
            if (findConnection == null) {
                return findConnection;
            }
            synchronized (this.connectionPool) {
                if (findConnection.successCount == 0 && !findConnection.isMultiplexed()) {
                    return findConnection;
                }
                if (!findConnection.isHealthy(z2)) {
                    noNewStreams();
                } else {
                    return findConnection;
                }
            }
        }
    }

    private boolean shouldPoolConnection(Connection connection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, this, connection)) == null) {
            if (this.preConnectNum < 1) {
                return true;
            }
            if (this.connectionPool.connectionsCount(this.address.url().host(), false) < this.preConnectNum && this.connectionPool.getPreConnectAlive(this.preConnectHttpUrlMap) < this.maxPreConnect && !this.connectionPool.hostH2ConnectionExist(this.address.url().host())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void createPreConnect(int i, int i2, int i3, int i4, boolean z, int i5, int i6, Map<HttpUrl, Integer> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5), Integer.valueOf(i6), map}) == null) {
            this.maxPreConnect = i5;
            this.preConnectNum = i6;
            this.preConnectHttpUrlMap = map;
            try {
                findHealthyConnection(i, i2, i3, i4, z, false);
                if (this.connection != null) {
                    synchronized (this.connectionPool) {
                        release(this.connection);
                        this.connection = null;
                    }
                }
            } catch (IOException e) {
                throw new RouteException(e);
            }
        }
    }

    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        boolean z;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iOException) == null) {
            synchronized (this.connectionPool) {
                realConnection = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i;
                        if (i > 1) {
                            this.route = null;
                            z = true;
                        }
                        z = false;
                    } else {
                        if (errorCode != ErrorCode.CANCEL) {
                            this.route = null;
                            z = true;
                        }
                        z = false;
                    }
                } else {
                    if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                        if (this.connection.successCount == 0) {
                            if (this.route != null && iOException != null) {
                                this.routeSelector.connectFailed(this.route, iOException);
                            }
                            this.route = null;
                        }
                        z = true;
                    }
                    z = false;
                }
                RealConnection realConnection2 = this.connection;
                deallocate = deallocate(z, false, true);
                if (this.connection == null && this.reportedAcquired) {
                    realConnection = realConnection2;
                }
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null) {
                this.eventListener.connectionReleased(this.call, realConnection);
            }
        }
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), httpCodec, Long.valueOf(j), iOException}) == null) {
            this.eventListener.responseBodyEnd(this.call, j);
            synchronized (this.connectionPool) {
                if (httpCodec != null) {
                    if (httpCodec == this.codec) {
                        if (!z) {
                            this.connection.successCount++;
                        }
                        realConnection = this.connection;
                        deallocate = deallocate(z, false, true);
                        if (this.connection != null) {
                            realConnection = null;
                        }
                        z2 = this.released;
                    }
                }
                throw new IllegalStateException("expected " + this.codec + " but was " + httpCodec);
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null) {
                this.eventListener.connectionReleased(this.call, realConnection);
            }
            if (iOException != null) {
                this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
            } else if (z2) {
                Internal.instance.timeoutExit(this.call, null);
                this.eventListener.callEnd(this.call);
            }
        }
    }
}
