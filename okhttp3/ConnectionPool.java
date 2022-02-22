package okhttp3;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
/* loaded from: classes5.dex */
public final class ConnectionPool {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public static final Executor executor;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable cleanupRunnable;
    public boolean cleanupRunning;
    public final Deque<RealConnection> connections;
    public final long keepAliveDurationNs;
    public final int maxIdleConnections;
    public final RouteDatabase routeDatabase;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-447202379, "Lokhttp3/ConnectionPool;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-447202379, "Lokhttp3/ConnectionPool;");
                return;
            }
        }
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConnectionPool() {
        this(5, 5L, TimeUnit.MINUTES);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Long) objArr[1]).longValue(), (TimeUnit) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private int pruneAndGetAllocationCount(RealConnection realConnection, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, this, realConnection, j2)) == null) {
            List<Reference<StreamAllocation>> list = realConnection.allocations;
            int i2 = 0;
            while (i2 < list.size()) {
                Reference<StreamAllocation> reference = list.get(i2);
                if (reference.get() != null) {
                    i2++;
                } else {
                    Platform.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((StreamAllocation.StreamAllocationReference) reference).callStackTrace);
                    list.remove(i2);
                    realConnection.noNewStreams = true;
                    if (list.isEmpty()) {
                        realConnection.idleAtNanos = j2 - this.keepAliveDurationNs;
                        return 0;
                    }
                }
            }
            return list.size();
        }
        return invokeLJ.intValue;
    }

    public long cleanup(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) {
            synchronized (this) {
                RealConnection realConnection = null;
                long j3 = Long.MIN_VALUE;
                int i2 = 0;
                int i3 = 0;
                for (RealConnection realConnection2 : this.connections) {
                    if (pruneAndGetAllocationCount(realConnection2, j2) > 0) {
                        i3++;
                    } else {
                        i2++;
                        long j4 = j2 - realConnection2.idleAtNanos;
                        if (j4 > j3) {
                            realConnection = realConnection2;
                            j3 = j4;
                        }
                    }
                }
                if (j3 < this.keepAliveDurationNs && i2 <= this.maxIdleConnections) {
                    if (i2 > 0) {
                        return this.keepAliveDurationNs - j3;
                    }
                    if (i3 > 0) {
                        return this.keepAliveDurationNs;
                    }
                    this.cleanupRunning = false;
                    return -1L;
                }
                this.connections.remove(realConnection);
                Util.closeQuietly(realConnection.socket());
                return 0L;
            }
        }
        return invokeJ.longValue;
    }

    public boolean connectionBecameIdle(RealConnection realConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, realConnection)) == null) {
            if (!realConnection.noNewStreams && this.maxIdleConnections != 0) {
                notifyAll();
                return false;
            }
            this.connections.remove(realConnection);
            return true;
        }
        return invokeL.booleanValue;
    }

    public synchronized int connectionCount() {
        InterceptResult invokeV;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                size = this.connections.size();
            }
            return size;
        }
        return invokeV.intValue;
    }

    @Nullable
    public Socket deduplicate(Address address, StreamAllocation streamAllocation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, address, streamAllocation)) == null) {
            for (RealConnection realConnection : this.connections) {
                if (realConnection.isEligible(address, null) && realConnection.isMultiplexed() && realConnection != streamAllocation.connection()) {
                    return streamAllocation.releaseAndAcquire(realConnection);
                }
            }
            return null;
        }
        return (Socket) invokeLL.objValue;
    }

    public void evictAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList<RealConnection> arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealConnection> it = this.connections.iterator();
                while (it.hasNext()) {
                    RealConnection next = it.next();
                    if (next.allocations.isEmpty()) {
                        next.noNewStreams = true;
                        arrayList.add(next);
                        it.remove();
                    }
                }
            }
            for (RealConnection realConnection : arrayList) {
                Util.closeQuietly(realConnection.socket());
            }
        }
    }

    @Nullable
    public RealConnection get(Address address, StreamAllocation streamAllocation, Route route) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, address, streamAllocation, route)) == null) {
            for (RealConnection realConnection : this.connections) {
                if (realConnection.isEligible(address, route)) {
                    streamAllocation.acquire(realConnection, true);
                    return realConnection;
                }
            }
            return null;
        }
        return (RealConnection) invokeLLL.objValue;
    }

    public synchronized int idleConnectionCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = 0;
                for (RealConnection realConnection : this.connections) {
                    if (realConnection.allocations.isEmpty()) {
                        i2++;
                    }
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void put(RealConnection realConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, realConnection) == null) {
            if (!this.cleanupRunning) {
                this.cleanupRunning = true;
                executor.execute(this.cleanupRunnable);
            }
            this.connections.add(realConnection);
        }
    }

    public ConnectionPool(int i2, long j2, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Long.valueOf(j2), timeUnit};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.cleanupRunnable = new Runnable(this) { // from class: okhttp3.ConnectionPool.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ConnectionPool this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                    return;
                }
                while (true) {
                    long cleanup = this.this$0.cleanup(System.nanoTime());
                    if (cleanup == -1) {
                        return;
                    }
                    if (cleanup > 0) {
                        long j3 = cleanup / 1000000;
                        long j4 = cleanup - (1000000 * j3);
                        synchronized (this.this$0) {
                            try {
                                this.this$0.wait(j3, (int) j4);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.connections = new ArrayDeque();
        this.routeDatabase = new RouteDatabase();
        this.maxIdleConnections = i2;
        this.keepAliveDurationNs = timeUnit.toNanos(j2);
        if (j2 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j2);
    }
}
