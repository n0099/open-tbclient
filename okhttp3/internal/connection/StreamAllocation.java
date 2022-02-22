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
import java.net.Socket;
import java.util.List;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
/* loaded from: classes5.dex */
public final class StreamAllocation {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Address address;
    public final Call call;
    public final Object callStackTrace;
    public boolean canceled;
    public HttpCodec codec;
    public RealConnection connection;
    public final ConnectionPool connectionPool;
    public final EventListener eventListener;
    public int refusedStreamCount;
    public boolean released;
    public boolean reportedAcquired;
    public Route route;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;

    /* loaded from: classes5.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.callStackTrace = obj;
        }
    }

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

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {connectionPool, address, call, eventListener, obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Socket socket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (z3) {
                this.codec = null;
            }
            if (z2) {
                this.released = true;
            }
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                if (z) {
                    realConnection.noNewStreams = true;
                }
                if (this.codec == null) {
                    if (this.released || this.connection.noNewStreams) {
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
                    return null;
                }
                return null;
            }
            return null;
        }
        return (Socket) invokeCommon.objValue;
    }

    private RealConnection findConnection(int i2, int i3, int i4, int i5, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Socket releaseIfNoNewStreams;
        Socket socket;
        RealConnection realConnection;
        RealConnection realConnection2;
        Route route;
        boolean z2;
        boolean z3;
        RouteSelector.Selection selection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z)})) == null) {
            synchronized (this.connectionPool) {
                if (!this.released) {
                    if (this.codec == null) {
                        if (!this.canceled) {
                            RealConnection realConnection3 = this.connection;
                            releaseIfNoNewStreams = releaseIfNoNewStreams();
                            socket = null;
                            if (this.connection != null) {
                                realConnection2 = this.connection;
                                realConnection = null;
                            } else {
                                realConnection = realConnection3;
                                realConnection2 = null;
                            }
                            if (!this.reportedAcquired) {
                                realConnection = null;
                            }
                            if (realConnection2 == null) {
                                Internal.instance.get(this.connectionPool, this.address, this, null);
                                if (this.connection != null) {
                                    realConnection2 = this.connection;
                                    route = null;
                                    z2 = true;
                                } else {
                                    route = this.route;
                                }
                            } else {
                                route = null;
                            }
                            z2 = false;
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
            if (z2) {
                this.eventListener.connectionAcquired(this.call, realConnection2);
            }
            if (realConnection2 != null) {
                return realConnection2;
            }
            if (route != null || ((selection = this.routeSelection) != null && selection.hasNext())) {
                z3 = false;
            } else {
                this.routeSelection = this.routeSelector.next();
                z3 = true;
            }
            synchronized (this.connectionPool) {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    List<Route> all = this.routeSelection.getAll();
                    int size = all.size();
                    int i6 = 0;
                    while (true) {
                        if (i6 >= size) {
                            break;
                        }
                        Route route2 = all.get(i6);
                        Internal.instance.get(this.connectionPool, this.address, this, route2);
                        if (this.connection != null) {
                            realConnection2 = this.connection;
                            this.route = route2;
                            z2 = true;
                            break;
                        }
                        i6++;
                    }
                }
                if (!z2) {
                    if (route == null) {
                        route = this.routeSelection.next();
                    }
                    this.route = route;
                    this.refusedStreamCount = 0;
                    realConnection2 = new RealConnection(this.connectionPool, route);
                    acquire(realConnection2, false);
                }
            }
            if (z2) {
                this.eventListener.connectionAcquired(this.call, realConnection2);
                return realConnection2;
            }
            realConnection2.connect(i2, i3, i4, i5, z, this.call, this.eventListener);
            routeDatabase().connected(realConnection2.route());
            synchronized (this.connectionPool) {
                this.reportedAcquired = true;
                Internal.instance.put(this.connectionPool, realConnection2);
                if (realConnection2.isMultiplexed()) {
                    socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                    realConnection2 = this.connection;
                }
            }
            Util.closeQuietly(socket);
            this.eventListener.connectionAcquired(this.call, realConnection2);
            return realConnection2;
        }
        return (RealConnection) invokeCommon.objValue;
    }

    private RealConnection findHealthyConnection(int i2, int i3, int i4, int i5, boolean z, boolean z2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Boolean.valueOf(z2)})) != null) {
            return (RealConnection) invokeCommon.objValue;
        }
        while (true) {
            RealConnection findConnection = findConnection(i2, i3, i4, i5, z);
            synchronized (this.connectionPool) {
                if (findConnection.successCount == 0) {
                    return findConnection;
                }
                if (findConnection.isHealthy(z2)) {
                    return findConnection;
                }
                noNewStreams();
            }
        }
    }

    private Socket releaseIfNoNewStreams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            RealConnection realConnection = this.connection;
            if (realConnection == null || !realConnection.noNewStreams) {
                return null;
            }
            return deallocate(false, false, true);
        }
        return (Socket) invokeV.objValue;
    }

    private RouteDatabase routeDatabase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? Internal.instance.routeDatabase(this.connectionPool) : (RouteDatabase) invokeV.objValue;
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

    public boolean hasMoreRoutes() {
        InterceptResult invokeV;
        RouteSelector.Selection selection;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.route != null || ((selection = this.routeSelection) != null && selection.hasNext()) || this.routeSelector.hasNext() : invokeV.booleanValue;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, okHttpClient, chain, z)) == null) {
            try {
                HttpCodec newCodec = findHealthyConnection(chain.connectTimeoutMillis(), chain.readTimeoutMillis(), chain.writeTimeoutMillis(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z).newCodec(okHttpClient, chain, this);
                synchronized (this.connectionPool) {
                    this.codec = newCodec;
                }
                return newCodec;
            } catch (IOException e2) {
                throw new RouteException(e2);
            }
        }
        return (HttpCodec) invokeLLZ.objValue;
    }

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
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

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this.connectionPool) {
                realConnection = this.connection;
                deallocate = deallocate(false, true, false);
                if (this.connection != null) {
                    realConnection = null;
                }
            }
            Util.closeQuietly(deallocate);
            if (realConnection != null) {
                this.eventListener.connectionReleased(this.call, realConnection);
                this.eventListener.callEnd(this.call);
            }
        }
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, realConnection)) == null) {
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

    public Route route() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.route : (Route) invokeV.objValue;
    }

    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        boolean z;
        Socket deallocate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iOException) == null) {
            synchronized (this.connectionPool) {
                realConnection = null;
                if (iOException instanceof StreamResetException) {
                    ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                    if (errorCode == ErrorCode.REFUSED_STREAM) {
                        int i2 = this.refusedStreamCount + 1;
                        this.refusedStreamCount = i2;
                        if (i2 > 1) {
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

    public void streamFinished(boolean z, HttpCodec httpCodec, long j2, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), httpCodec, Long.valueOf(j2), iOException}) == null) {
            this.eventListener.responseBodyEnd(this.call, j2);
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
                this.eventListener.callFailed(this.call, iOException);
            } else if (z2) {
                this.eventListener.callEnd(this.call);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            RealConnection connection = connection();
            return connection != null ? connection.toString() : this.address.toString();
        }
        return (String) invokeV.objValue;
    }

    private void release(RealConnection realConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, realConnection) == null) {
            int size = realConnection.allocations.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (realConnection.allocations.get(i2).get() == this) {
                    realConnection.allocations.remove(i2);
                    return;
                }
            }
            throw new IllegalStateException();
        }
    }
}
