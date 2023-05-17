package okhttp3.internal.connection;

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
/* loaded from: classes10.dex */
public final class StreamAllocation {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "StreamAllocation";
    @Nullable
    public static volatile ScheduledExecutorService scheduledExecutorService;
    public final Address address;
    public final Call call;
    public final Object callStackTrace;
    public boolean canceled;
    public HttpCodec codec;
    public RealConnection connection;
    public final ConnectionPool connectionPool;
    public volatile CountDownLatch countDownLatch;
    public final EventListener eventListener;
    @Nullable
    public ExecutorService executorService;
    public boolean hasFallbackToIPv4;
    public int ipv6FallbackTimerInMs;
    public Timer mFallbackTimer;
    public Map<HttpUrl, Integer> preConnectHttpUrlMap;
    public int refusedStreamCount;
    public boolean released;
    public boolean reportedAcquired;
    public RealConnection result;
    public Route route;
    public RouteSelector.Selection routeSelection;
    public final RouteSelector routeSelector;
    public int maxMultiConnectNum = 0;
    public long multiConnectDelayTimeInMs = 0;
    public boolean isMultipleConnectEnabled = false;
    public int currentAddressIndex = 0;
    public boolean isRetryStream = false;
    public List<RealConnection> attemptList = new CopyOnWriteArrayList();
    public List<RealConnection> connectingList = new CopyOnWriteArrayList();
    public List<RealConnection> failedList = new CopyOnWriteArrayList();
    public List<RealConnection> successList = new CopyOnWriteArrayList();
    public List<MultipleConnectTask> multipleConnectTasks = new CopyOnWriteArrayList();
    public final AtomicBoolean connectionSuccess = new AtomicBoolean(false);
    public int preConnectNum = 0;
    public int maxPreConnect = 0;

    /* loaded from: classes10.dex */
    public class FallbackConnectTask extends TimerTask {
        public boolean canceled;
        public int connectTimeout;
        public boolean connectionRetryEnabled;
        public RealConnection fallbackConnection;
        public RealConnection mainConnection;
        public int pingIntervalMillis;
        public int readTimeout;
        public RouteSelector.Selection routeSelection;
        public boolean started;
        public int writeTimeout;

        public FallbackConnectTask(RealConnection realConnection, RealConnection realConnection2, RouteSelector.Selection selection, int i, int i2, int i3, int i4, boolean z) {
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
            RealConnection realConnection = this.mainConnection;
            if (realConnection == null || realConnection.socket() == null || !this.mainConnection.isHealthy(false)) {
                return false;
            }
            return true;
        }

        @Override // java.util.TimerTask
        public boolean cancel() {
            this.canceled = true;
            if (this.started) {
                this.fallbackConnection.cancel();
            }
            return super.cancel();
        }

        public boolean isStarted() {
            return this.started;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (!this.canceled && !isMainConnectReady()) {
                    this.started = true;
                    StreamAllocation.this.route = this.routeSelection.markNextIPv4();
                    this.fallbackConnection.routeList = this.routeSelection.getAll();
                    if (StreamAllocation.this.isMultipleConnectEnabled && !StreamAllocation.this.isRetryStream && this.fallbackConnection != null) {
                        new MultipleConnectTask(this.fallbackConnection, this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, false, this).started = true;
                    }
                    this.fallbackConnection.connect(this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, this.connectionRetryEnabled, StreamAllocation.this.call, StreamAllocation.this.eventListener);
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

    /* loaded from: classes10.dex */
    public class MultipleConnectTask implements Runnable {
        public volatile boolean canceled;
        public int connectTimeout;
        public boolean connectionRetryEnabled;
        public RealConnection currentConnection;
        public FallbackConnectTask fallbackConnectTask;
        public int pingIntervalMillis;
        public int readTimeout;
        public volatile boolean started;
        public int writeTimeout;

        public MultipleConnectTask(@Nonnull RealConnection realConnection, int i, int i2, int i3, int i4, boolean z, FallbackConnectTask fallbackConnectTask) {
            this.connectTimeout = i;
            this.readTimeout = i2;
            this.writeTimeout = i3;
            this.pingIntervalMillis = i4;
            this.connectionRetryEnabled = z;
            this.currentConnection = realConnection;
            this.fallbackConnectTask = fallbackConnectTask;
            StreamAllocation.this.attemptList.add(this.currentConnection);
            StreamAllocation.this.multipleConnectTasks.add(this);
            setConnectStateCallback(this.currentConnection);
        }

        public MultipleConnectTask getTaskByConnection(RealConnection realConnection) {
            for (MultipleConnectTask multipleConnectTask : StreamAllocation.this.multipleConnectTasks) {
                if (multipleConnectTask.currentConnection == realConnection) {
                    return multipleConnectTask;
                }
            }
            return null;
        }

        private void setConnectStateCallback(final RealConnection realConnection) {
            final RealConnection realConnection2;
            Route findNextIpv4;
            if (StreamAllocation.this.currentAddressIndex < Math.min(StreamAllocation.this.maxMultiConnectNum - 1, StreamAllocation.this.routeSelection.getIPv4Size() - 1) && (findNextIpv4 = StreamAllocation.this.findNextIpv4()) != null) {
                realConnection2 = new RealConnection(StreamAllocation.this.connectionPool, findNextIpv4);
            } else {
                realConnection2 = null;
            }
            if (StreamAllocation.this.currentAddressIndex < Math.min(StreamAllocation.this.maxMultiConnectNum, StreamAllocation.this.routeSelection.getIPv4Size())) {
                realConnection.setConnectCompleteCallback(new RealConnection.ConnectComplete() { // from class: okhttp3.internal.connection.StreamAllocation.MultipleConnectTask.1
                    @Override // okhttp3.internal.connection.RealConnection.ConnectComplete
                    public void receiveConnectState(int i) {
                        RealConnection realConnection3;
                        if (i != 0) {
                            if (i != 1) {
                                if (i == 2) {
                                    if (MultipleConnectTask.this.fallbackConnectTask != null && MultipleConnectTask.this.fallbackConnectTask.isMainConnectReady()) {
                                        for (MultipleConnectTask multipleConnectTask : StreamAllocation.this.multipleConnectTasks) {
                                            multipleConnectTask.cancel();
                                        }
                                        return;
                                    }
                                    StreamAllocation.access$708(StreamAllocation.this);
                                    StreamAllocation.this.connectingList.add(realConnection);
                                    StreamAllocation.this.attemptList.remove(realConnection);
                                    if (!StreamAllocation.this.failedList.contains(realConnection2) && !StreamAllocation.this.connectingList.contains(realConnection2) && StreamAllocation.this.failedList.size() < StreamAllocation.this.maxMultiConnectNum && (realConnection3 = realConnection2) != null) {
                                        MultipleConnectTask multipleConnectTask2 = MultipleConnectTask.this;
                                        final MultipleConnectTask multipleConnectTask3 = new MultipleConnectTask(realConnection3, multipleConnectTask2.connectTimeout, MultipleConnectTask.this.readTimeout, MultipleConnectTask.this.writeTimeout, MultipleConnectTask.this.pingIntervalMillis, false, MultipleConnectTask.this.fallbackConnectTask);
                                        StreamAllocation.access$2900().schedule(new Runnable() { // from class: okhttp3.internal.connection.StreamAllocation.MultipleConnectTask.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                StreamAllocation.this.executorService.submit(multipleConnectTask3);
                                            }
                                        }, StreamAllocation.this.multiConnectDelayTimeInMs, TimeUnit.MILLISECONDS);
                                    }
                                }
                            } else if (MultipleConnectTask.this.fallbackConnectTask != null && MultipleConnectTask.this.fallbackConnectTask.isMainConnectReady()) {
                                for (MultipleConnectTask multipleConnectTask4 : StreamAllocation.this.multipleConnectTasks) {
                                    multipleConnectTask4.cancel();
                                }
                            } else {
                                StreamAllocation.this.failedList.add(realConnection);
                                realConnection.cancel();
                                StreamAllocation.this.connectingList.remove(realConnection);
                                if (!StreamAllocation.this.failedList.contains(realConnection2) && !StreamAllocation.this.connectingList.contains(realConnection2) && StreamAllocation.this.failedList.size() < StreamAllocation.this.maxMultiConnectNum) {
                                    if (StreamAllocation.this.attemptList.contains(realConnection2)) {
                                        MultipleConnectTask taskByConnection = MultipleConnectTask.this.getTaskByConnection(realConnection2);
                                        if (taskByConnection != null && !taskByConnection.isStarted()) {
                                            MultipleConnectTask multipleConnectTask5 = MultipleConnectTask.this;
                                            taskByConnection.connectionRetryEnabled = StreamAllocation.this.isConnectionRetryNeeded(multipleConnectTask5.connectionRetryEnabled);
                                            StreamAllocation.this.executorService.submit(taskByConnection);
                                        }
                                    } else {
                                        RealConnection realConnection4 = realConnection2;
                                        if (realConnection4 != null) {
                                            MultipleConnectTask multipleConnectTask6 = MultipleConnectTask.this;
                                            StreamAllocation streamAllocation = StreamAllocation.this;
                                            int i2 = multipleConnectTask6.connectTimeout;
                                            int i3 = MultipleConnectTask.this.readTimeout;
                                            int i4 = MultipleConnectTask.this.writeTimeout;
                                            int i5 = MultipleConnectTask.this.pingIntervalMillis;
                                            MultipleConnectTask multipleConnectTask7 = MultipleConnectTask.this;
                                            StreamAllocation.this.executorService.submit(new MultipleConnectTask(realConnection4, i2, i3, i4, i5, StreamAllocation.this.isConnectionRetryNeeded(multipleConnectTask7.connectionRetryEnabled), MultipleConnectTask.this.fallbackConnectTask));
                                        }
                                    }
                                }
                                if (StreamAllocation.this.failedList.size() >= StreamAllocation.this.maxMultiConnectNum || StreamAllocation.this.failedList.size() >= StreamAllocation.this.routeSelection.getIPv4Size()) {
                                    StreamAllocation.this.countDownLatch.countDown();
                                }
                            }
                        } else if (StreamAllocation.this.connectionSuccess.compareAndSet(false, true)) {
                            for (MultipleConnectTask multipleConnectTask8 : StreamAllocation.this.multipleConnectTasks) {
                                if (multipleConnectTask8 != MultipleConnectTask.this) {
                                    multipleConnectTask8.cancel();
                                }
                            }
                            if (MultipleConnectTask.this.fallbackConnectTask != null) {
                                if (MultipleConnectTask.this.fallbackConnectTask.isMainConnectReady()) {
                                    realConnection.cancel();
                                    return;
                                }
                                MultipleConnectTask.this.fallbackConnectTask.mainConnection.cancel();
                            }
                            if (realConnection != StreamAllocation.this.connection) {
                                synchronized (StreamAllocation.this.connectionPool) {
                                    StreamAllocation.this.releaseAndAcquire(realConnection);
                                }
                                StreamAllocation.this.route = realConnection.route();
                                StreamAllocation.this.result = realConnection;
                            }
                            StreamAllocation.this.successList.add(realConnection);
                            StreamAllocation.this.countDownLatch.countDown();
                            StreamAllocation.this.multipleConnectTasks.clear();
                            StreamAllocation.this.connectingList.clear();
                            StreamAllocation.this.attemptList.clear();
                        }
                    }
                });
            }
        }

        public void cancel() {
            this.canceled = true;
            if (this.started) {
                this.currentConnection.cancel();
            }
        }

        public boolean isStarted() {
            return this.started;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.canceled && !isStarted() && StreamAllocation.this.successList.size() <= 0) {
                    this.started = true;
                    if (StreamAllocation.this.attemptList.contains(this.currentConnection)) {
                        this.currentConnection.connect(this.connectTimeout, this.readTimeout, this.writeTimeout, this.pingIntervalMillis, this.connectionRetryEnabled, StreamAllocation.this.call, StreamAllocation.this.eventListener);
                    }
                }
            } catch (RuntimeException unused) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class StreamAllocationReference extends WeakReference<StreamAllocation> {
        public final Object callStackTrace;

        public StreamAllocationReference(StreamAllocation streamAllocation, Object obj) {
            super(streamAllocation);
            this.callStackTrace = obj;
        }
    }

    public StreamAllocation(ConnectionPool connectionPool, Address address, Call call, EventListener eventListener, Object obj) {
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
        this.routeSelector = new RouteSelector(address, routeDatabase(), call, eventListener);
        this.callStackTrace = obj;
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

    public static /* synthetic */ int access$708(StreamAllocation streamAllocation) {
        int i = streamAllocation.currentAddressIndex;
        streamAllocation.currentAddressIndex = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnectionRetryNeeded(boolean z) {
        if (this.isMultipleConnectEnabled) {
            if (z && this.failedList.size() >= this.maxMultiConnectNum - 1) {
                return true;
            }
            return false;
        }
        return z;
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
        if (this.codec == null && this.connection.allocations.size() == 1) {
            Socket deallocate = deallocate(true, false, false);
            this.connection = realConnection;
            realConnection.allocations.add(this.connection.allocations.get(0));
            return deallocate;
        }
        throw new IllegalStateException();
    }

    public void setIsRetryStream(boolean z) {
        this.isRetryStream = z;
    }

    public void acquire(RealConnection realConnection, boolean z) {
        if (this.connection == null) {
            this.connection = realConnection;
            this.reportedAcquired = z;
            realConnection.allocations.add(new StreamAllocationReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public static /* synthetic */ ScheduledExecutorService access$2900() {
        return scheduledExecutorService();
    }

    private Route findAddressListStartWithIPv4() {
        for (int i = 0; i < this.routeSelection.getAll().size(); i++) {
            Route route = this.routeSelection.getAll().get(i);
            if (route.socketAddress().getAddress() instanceof Inet4Address) {
                return route;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Route findNextIpv4() {
        if (this.currentAddressIndex < this.maxMultiConnectNum) {
            return this.routeSelection.markNextIPv4();
        }
        return null;
    }

    private Socket releaseIfNoNewStreams() {
        RealConnection realConnection = this.connection;
        if (realConnection != null && realConnection.noNewStreams) {
            return deallocate(false, false, true);
        }
        return null;
    }

    private RouteDatabase routeDatabase() {
        return Internal.instance.routeDatabase(this.connectionPool);
    }

    public static ScheduledExecutorService scheduledExecutorService() {
        if (scheduledExecutorService == null) {
            synchronized (StreamAllocation.class) {
                if (scheduledExecutorService == null) {
                    scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
                }
            }
        }
        return scheduledExecutorService;
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

    public HttpCodec codec() {
        HttpCodec httpCodec;
        synchronized (this.connectionPool) {
            httpCodec = this.codec;
        }
        return httpCodec;
    }

    public synchronized RealConnection connection() {
        return this.connection;
    }

    public int getPreConnectNum() {
        return this.preConnectNum;
    }

    public boolean hasMoreRoutes() {
        RouteSelector.Selection selection;
        if (this.route == null && (((selection = this.routeSelection) == null || !selection.hasNext()) && !this.routeSelector.hasNext())) {
            return false;
        }
        return true;
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
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.connectionReleased(this.call, realConnection);
            this.eventListener.callEnd(this.call);
        }
    }

    public Route route() {
        return this.route;
    }

    public String toString() {
        RealConnection connection = connection();
        if (connection != null) {
            return connection.toString();
        }
        return this.address.toString();
    }

    private Socket deallocate(boolean z, boolean z2, boolean z3) {
        Socket socket;
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

    public HttpCodec newStream(OkHttpClient okHttpClient, Interceptor.Chain chain, boolean z) {
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

    /* JADX WARN: Removed duplicated region for block: B:128:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private RealConnection findConnection(int i, int i2, int i3, int i4, boolean z) throws IOException {
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
            FallbackConnectTask fallbackConnectTask2 = new FallbackConnectTask(this.result, realConnection5, this.routeSelection, i, i2, i3, i4, z);
            this.mFallbackTimer.schedule(fallbackConnectTask2, this.ipv6FallbackTimerInMs);
            fallbackConnectTask = fallbackConnectTask2;
            realConnection2 = realConnection5;
        } else {
            if (this.isMultipleConnectEnabled && !this.isRetryStream && (realConnection3 = this.result) != null) {
                new MultipleConnectTask(realConnection3, i, i2, i3, i4, false, null).started = true;
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
    }

    private RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
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
        if (this.preConnectNum < 1) {
            return true;
        }
        if (this.connectionPool.connectionsCount(this.address.url().host(), false) < this.preConnectNum && this.connectionPool.getPreConnectAlive(this.preConnectHttpUrlMap) < this.maxPreConnect && !this.connectionPool.hostH2ConnectionExist(this.address.url().host())) {
            return true;
        }
        return false;
    }

    public void createPreConnect(int i, int i2, int i3, int i4, boolean z, int i5, int i6, Map<HttpUrl, Integer> map) {
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

    public void streamFailed(IOException iOException) {
        RealConnection realConnection;
        boolean z;
        Socket deallocate;
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
            this.eventListener.callFailed(this.call, Internal.instance.timeoutExit(this.call, iOException));
        } else if (z2) {
            Internal.instance.timeoutExit(this.call, null);
            this.eventListener.callEnd(this.call);
        }
    }
}
