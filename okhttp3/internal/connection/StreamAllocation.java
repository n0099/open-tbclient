package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.Socket;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    static final /* synthetic */ boolean $assertionsDisabled;
    public final Address address;
    public final Call call;
    private final Object callStackTrace;
    private boolean canceled;
    private HttpCodec codec;
    private RealConnection connection;
    private final ConnectionPool connectionPool;
    public final EventListener eventListener;
    private boolean hasFallbackToIPv4;
    private int ipv6FallbackTimerInMs;
    private Timer mFallbackTimer;
    private int refusedStreamCount;
    private boolean released;
    private boolean reportedAcquired;
    private Route route;
    private RouteSelector.Selection routeSelection;
    private final RouteSelector routeSelector;

    static {
        $assertionsDisabled = !StreamAllocation.class.desiredAssertionStatus();
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
    }

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, Request request, boolean z) {
        int connectTimeoutMillis = chain.connectTimeoutMillis();
        int readTimeoutMillis = chain.readTimeoutMillis();
        int writeTimeoutMillis = chain.writeTimeoutMillis();
        int pingIntervalMillis = okHttpClient.pingIntervalMillis();
        boolean retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
        this.ipv6FallbackTimerInMs = okHttpClient.getFallbackConnectDelayMs();
        try {
            HttpCodec newCodec = findHealthyConnection(connectTimeoutMillis, readTimeoutMillis, writeTimeoutMillis, pingIntervalMillis, retryOnConnectionFailure, request, z).newCodec(okHttpClient, chain, this);
            synchronized (this.connectionPool) {
                this.codec = newCodec;
            }
            return newCodec;
        } catch (IOException e) {
            throw new RouteException(e);
        }
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, Request request, boolean z2) throws IOException {
        RealConnection findConnection;
        while (true) {
            findConnection = findConnection(i, i2, i3, i4, z, request);
            synchronized (this.connectionPool) {
                if (findConnection.successCount != 0) {
                    if (findConnection.isHealthy(z2)) {
                        break;
                    }
                    noNewStreams();
                } else {
                    break;
                }
            }
        }
        return findConnection;
    }

    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z, Request request) throws IOException {
        RealConnection realConnection;
        Socket releaseIfNoNewStreams;
        RealConnection realConnection2;
        boolean z2 = false;
        RealConnection realConnection3 = null;
        Route route = null;
        synchronized (this.connectionPool) {
            if (this.released) {
                throw new IllegalStateException("released");
            }
            if (this.codec != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.canceled) {
                throw new IOException("Canceled");
            }
            realConnection = this.connection;
            releaseIfNoNewStreams = releaseIfNoNewStreams();
            if (this.connection != null) {
                realConnection3 = this.connection;
                realConnection = null;
            }
            if (!this.reportedAcquired) {
                realConnection = null;
            }
            if (realConnection3 == null) {
                Internal.instance.get(this.connectionPool, this.address, this, null);
                if (this.connection != null) {
                    z2 = true;
                    realConnection3 = this.connection;
                } else {
                    route = this.route;
                }
            }
        }
        Util.closeQuietly(releaseIfNoNewStreams);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z2) {
            this.eventListener.connectionAcquired(this.call, realConnection3);
        }
        if (realConnection3 == null) {
            boolean z3 = false;
            if (route == null && (this.routeSelection == null || !this.routeSelection.hasNext())) {
                z3 = true;
                this.routeSelection = this.routeSelector.next();
            }
            synchronized (this.connectionPool) {
                if (this.canceled) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    List<Route> all = this.routeSelection.getAll();
                    int size = all.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        Route route2 = all.get(i5);
                        Internal.instance.get(this.connectionPool, this.address, this, route2);
                        if (this.connection == null) {
                            i5++;
                        } else {
                            z2 = true;
                            realConnection3 = this.connection;
                            this.route = route2;
                            break;
                        }
                    }
                }
                if (!z2) {
                    Route next = route == null ? this.routeSelection.next() : route;
                    this.route = next;
                    this.refusedStreamCount = 0;
                    realConnection3 = new RealConnection(this.connectionPool, next);
                    acquire(realConnection3, false);
                }
            }
            if (z2) {
                this.eventListener.connectionAcquired(this.call, realConnection3);
            } else {
                boolean z4 = this.ipv6FallbackTimerInMs > 0 && this.route != null && (this.route.socketAddress().getAddress() instanceof Inet6Address) && !AddressListOnlyContainsIPv6(this.routeSelection.getAll());
                FallbackConnectTask fallbackConnectTask = null;
                if (!z4) {
                    realConnection2 = null;
                } else {
                    RealConnection realConnection4 = new RealConnection(this.connectionPool, findAddressListStartWithIPv4());
                    fallbackConnectTask = new FallbackConnectTask(realConnection3, realConnection4, this.routeSelection, i, i2, i3, i4, z, request);
                    if (this.mFallbackTimer == null) {
                        this.mFallbackTimer = new Timer();
                    }
                    this.mFallbackTimer.schedule(fallbackConnectTask, this.ipv6FallbackTimerInMs);
                    realConnection2 = realConnection4;
                }
                realConnection3.routeList = this.routeSelection.getAll();
                try {
                    realConnection3.connect(i, i2, i3, i4, z, this.call, this.eventListener, request);
                } catch (RuntimeException e) {
                    if (!z4) {
                        throw e;
                    }
                    this.hasFallbackToIPv4 = true;
                    if (fallbackConnectTask.isStarted() && ((realConnection3.socket() == null || !realConnection3.isHealthy(false)) && realConnection2.socket() != null && realConnection2.isHealthy(false))) {
                        release(this.connection);
                        this.connection = null;
                        acquire(realConnection2, this.reportedAcquired);
                        this.route = realConnection2.route();
                        realConnection3 = realConnection2;
                    } else {
                        if (!fallbackConnectTask.isStarted()) {
                            fallbackConnectTask.cancel();
                        } else {
                            fallbackConnectTask.cancel();
                            this.route = this.routeSelection.markIndexStartWithIPv4();
                        }
                        throw e;
                    }
                }
                realConnection3.isFallbackConn = this.hasFallbackToIPv4;
                routeDatabase().connected(realConnection3.route());
                Socket socket = null;
                synchronized (this.connectionPool) {
                    this.reportedAcquired = true;
                    Internal.instance.put(this.connectionPool, realConnection3);
                    if (realConnection3.isMultiplexed()) {
                        socket = Internal.instance.deduplicate(this.connectionPool, this.address, this);
                        realConnection3 = this.connection;
                    }
                }
                Util.closeQuietly(socket);
                this.eventListener.connectionAcquired(this.call, realConnection3);
            }
        }
        return realConnection3;
    }

    private Socket releaseIfNoNewStreams() {
        if ($assertionsDisabled || Thread.holdsLock(this.connectionPool)) {
            RealConnection realConnection = this.connection;
            if (realConnection == null || !realConnection.noNewStreams) {
                return null;
            }
            return deallocate(false, false, true);
        }
        throw new AssertionError();
    }

    public void streamFinished(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z2;
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
            this.eventListener.callFailed(this.call, iOException);
        } else if (z2) {
            this.eventListener.callEnd(this.call);
        }
    }

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public Route route() {
        return this.route;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public void release() {
        RealConnection realConnection;
        Socket deallocate;
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

    public void noNewStreams() {
        RealConnection realConnection;
        Socket deallocate;
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

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if ($assertionsDisabled || Thread.holdsLock(this.connectionPool)) {
            if (z3) {
                this.codec = null;
            }
            if (z2) {
                this.released = true;
            }
            if (this.connection != null) {
                if (z) {
                    this.connection.noNewStreams = true;
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
        throw new AssertionError();
    }

    public void cancel() {
        HttpCodec httpCodec;
        RealConnection realConnection;
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

    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        Socket deallocate;
        boolean z = false;
        boolean z2 = true;
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    this.refusedStreamCount++;
                    if (this.refusedStreamCount > 1) {
                        this.route = null;
                        z = z2;
                    }
                    z2 = false;
                    z = z2;
                } else {
                    if (errorCode != ErrorCode.CANCEL) {
                        this.route = null;
                        z = z2;
                    }
                    z2 = false;
                    z = z2;
                }
            } else if (this.connection != null && (!this.connection.isMultiplexed() || (iOException instanceof ConnectionShutdownException))) {
                if (this.connection.successCount == 0) {
                    if (this.route != null && iOException != null) {
                        this.routeSelector.connectFailed(this.route, iOException);
                    }
                    this.route = null;
                }
                z = true;
            }
            realConnection = this.connection;
            deallocate = deallocate(z, false, true);
            if (this.connection != null || !this.reportedAcquired) {
                realConnection = null;
            }
        }
        Util.closeQuietly(deallocate);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (!$assertionsDisabled && !Thread.holdsLock(this.connectionPool)) {
            throw new AssertionError();
        }
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        this.connection = realConnection;
        this.reportedAcquired = z;
        realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
    }

    private void release(RealConnection realConnection) {
        int size = realConnection.allocations.size();
        for (int i = 0; i < size; i++) {
            if (realConnection.allocations.get(i).get() == this) {
                realConnection.allocations.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public Socket releaseAndAcquire(RealConnection realConnection) {
        if ($assertionsDisabled || Thread.holdsLock(this.connectionPool)) {
            if (this.codec == null && this.connection.allocations.size() == 1) {
                Socket deallocate = deallocate(true, false, false);
                this.connection = realConnection;
                realConnection.allocations.add(this.connection.allocations.get(0));
                return deallocate;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public boolean hasMoreRoutes() {
        return this.route != null || (this.routeSelection != null && this.routeSelection.hasNext()) || this.routeSelector.hasNext();
    }

    public String toString() {
        RealConnection connection = connection();
        return connection != null ? connection.toString() : this.address.toString();
    }

    /* loaded from: classes5.dex */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    private boolean AddressListOnlyContainsIPv6(List<Route> list) {
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

    private Route findAddressListStartWithIPv4() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.routeSelection.getAll().size()) {
                Route route = this.routeSelection.getAll().get(i2);
                if (!(route.socketAddress().getAddress() instanceof Inet4Address)) {
                    i = i2 + 1;
                } else {
                    return route;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class FallbackConnectTask extends TimerTask {
        private boolean canceled;
        private int connectTimeout;
        private boolean connectionRetryEnabled;
        private RealConnection fallbackConnection;
        private RealConnection mainConnection;
        private int pingIntervalMillis;
        private int readTimeout;
        private Request request;
        private RouteSelector.Selection routeSelection;
        private boolean started;
        private int writeTimeout;

        public FallbackConnectTask(RealConnection realConnection, RealConnection realConnection2, RouteSelector.Selection selection, int i, int i2, int i3, int i4, boolean z, Request request) {
            this.connectTimeout = i;
            this.readTimeout = i2;
            this.writeTimeout = i3;
            this.pingIntervalMillis = i4;
            this.connectionRetryEnabled = z;
            this.request = request;
            this.routeSelection = selection;
            this.mainConnection = realConnection;
            this.fallbackConnection = realConnection2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (!this.canceled && !isMainConnectReady()) {
                    this.started = true;
                    StreamAllocation.this.route = this.routeSelection.markIndexStartWithIPv4();
                    this.fallbackConnection.routeList = this.routeSelection.getAll();
                    this.fallbackConnection.connect(this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, this.connectionRetryEnabled, StreamAllocation.this.call, StreamAllocation.this.eventListener, this.request);
                    if (isMainConnectReady()) {
                        this.fallbackConnection.cancel();
                    } else {
                        this.mainConnection.cancel();
                    }
                }
            } catch (RuntimeException e) {
            }
        }

        private boolean isMainConnectReady() {
            return (this.mainConnection == null || this.mainConnection.socket() == null || !this.mainConnection.isHealthy(false)) ? false : true;
        }

        public boolean isStarted() {
            return this.started;
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            this.canceled = true;
            if (this.started) {
                this.fallbackConnection.cancel();
            }
            return super.cancel();
        }
    }
}
