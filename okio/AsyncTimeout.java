package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class AsyncTimeout extends Timeout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long IDLE_TIMEOUT_MILLIS;
    public static final long IDLE_TIMEOUT_NANOS;
    public static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    public static AsyncTimeout head;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean inQueue;
    @Nullable
    public AsyncTimeout next;
    public long timeoutAt;

    public void timedOut() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static final class Watchdog extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Watchdog() {
            super("Okio Watchdog");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0019, code lost:
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            while (true) {
                synchronized (AsyncTimeout.class) {
                    AsyncTimeout awaitTimeout = AsyncTimeout.awaitTimeout();
                    if (awaitTimeout != null) {
                        if (awaitTimeout == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(768191349, "Lokio/AsyncTimeout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(768191349, "Lokio/AsyncTimeout;");
                return;
            }
        }
        IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    }

    public AsyncTimeout() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void enter() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.inQueue) {
                long timeoutNanos = timeoutNanos();
                boolean hasDeadline = hasDeadline();
                if (timeoutNanos == 0 && !hasDeadline) {
                    return;
                }
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            throw new IllegalStateException("Unbalanced enter/exit");
        }
    }

    public final boolean exit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            return cancelScheduledTimeout(this);
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public static AsyncTimeout awaitTimeout() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            AsyncTimeout asyncTimeout = head.next;
            if (asyncTimeout == null) {
                long nanoTime = System.nanoTime();
                AsyncTimeout.class.wait(IDLE_TIMEOUT_MILLIS);
                if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return head;
            }
            long remainingNanos = asyncTimeout.remainingNanos(System.nanoTime());
            if (remainingNanos > 0) {
                long j = remainingNanos / 1000000;
                AsyncTimeout.class.wait(j, (int) (remainingNanos - (1000000 * j)));
                return null;
            }
            head.next = asyncTimeout.next;
            asyncTimeout.next = null;
            return asyncTimeout;
        }
        return (AsyncTimeout) invokeV.objValue;
    }

    public static synchronized boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, asyncTimeout)) == null) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout asyncTimeout2 = head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private long remainingNanos(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, this, j)) == null) {
            return this.timeoutAt - j;
        }
        return invokeJ.longValue;
    }

    public final IOException exit(IOException iOException) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException)) == null) {
            if (!exit()) {
                return iOException;
            }
            return newTimeoutException(iOException);
        }
        return (IOException) invokeL.objValue;
    }

    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, iOException)) == null) {
            InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
            return interruptedIOException;
        }
        return (IOException) invokeL.objValue;
    }

    public final Sink sink(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sink)) == null) {
            return new Sink(this, sink) { // from class: okio.AsyncTimeout.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncTimeout this$0;
                public final /* synthetic */ Sink val$sink;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sink};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$sink = sink;
                }

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.enter();
                        try {
                            try {
                                this.val$sink.close();
                                this.this$0.exit(true);
                            } catch (IOException e) {
                                throw this.this$0.exit(e);
                            }
                        } catch (Throwable th) {
                            this.this$0.exit(false);
                            throw th;
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.this$0.enter();
                        try {
                            try {
                                this.val$sink.flush();
                                this.this$0.exit(true);
                            } catch (IOException e) {
                                throw this.this$0.exit(e);
                            }
                        } catch (Throwable th) {
                            this.this$0.exit(false);
                            throw th;
                        }
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return this.this$0;
                    }
                    return (Timeout) invokeV.objValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        return "AsyncTimeout.sink(" + this.val$sink + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    return (String) invokeV.objValue;
                }

                @Override // okio.Sink
                public void write(Buffer buffer, long j) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLJ(1048580, this, buffer, j) == null) {
                        Util.checkOffsetAndCount(buffer.size, 0L, j);
                        while (true) {
                            long j2 = 0;
                            if (j > 0) {
                                Segment segment = buffer.head;
                                while (true) {
                                    if (j2 >= 65536) {
                                        break;
                                    }
                                    j2 += segment.limit - segment.pos;
                                    if (j2 >= j) {
                                        j2 = j;
                                        break;
                                    }
                                    segment = segment.next;
                                }
                                this.this$0.enter();
                                try {
                                    try {
                                        this.val$sink.write(buffer, j2);
                                        j -= j2;
                                        this.this$0.exit(true);
                                    } catch (IOException e) {
                                        throw this.this$0.exit(e);
                                    }
                                } catch (Throwable th) {
                                    this.this$0.exit(false);
                                    throw th;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            };
        }
        return (Sink) invokeL.objValue;
    }

    public final Source source(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, source)) == null) {
            return new Source(this, source) { // from class: okio.AsyncTimeout.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ AsyncTimeout this$0;
                public final /* synthetic */ Source val$source;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, source};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$source = source;
                }

                @Override // okio.Source
                public long read(Buffer buffer, long j) throws IOException {
                    InterceptResult invokeLJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                        this.this$0.enter();
                        try {
                            try {
                                long read = this.val$source.read(buffer, j);
                                this.this$0.exit(true);
                                return read;
                            } catch (IOException e) {
                                throw this.this$0.exit(e);
                            }
                        } catch (Throwable th) {
                            this.this$0.exit(false);
                            throw th;
                        }
                    }
                    return invokeLJ.longValue;
                }

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            try {
                                this.val$source.close();
                                this.this$0.exit(true);
                            } catch (IOException e) {
                                throw this.this$0.exit(e);
                            }
                        } catch (Throwable th) {
                            this.this$0.exit(false);
                            throw th;
                        }
                    }
                }

                @Override // okio.Source
                public Timeout timeout() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return this.this$0;
                    }
                    return (Timeout) invokeV.objValue;
                }

                public String toString() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        return "AsyncTimeout.source(" + this.val$source + SmallTailInfo.EMOTION_SUFFIX;
                    }
                    return (String) invokeV.objValue;
                }
            };
        }
        return (Source) invokeL.objValue;
    }

    public static synchronized void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{asyncTimeout, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            synchronized (AsyncTimeout.class) {
                if (head == null) {
                    head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long nanoTime = System.nanoTime();
                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                if (i != 0 && z) {
                    asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                } else if (i != 0) {
                    asyncTimeout.timeoutAt = j + nanoTime;
                } else if (z) {
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                AsyncTimeout asyncTimeout2 = head;
                while (asyncTimeout2.next != null && remainingNanos >= asyncTimeout2.next.remainingNanos(nanoTime)) {
                    asyncTimeout2 = asyncTimeout2.next;
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == head) {
                    AsyncTimeout.class.notify();
                }
            }
        }
    }

    public final void exit(boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && exit() && z) {
            throw newTimeoutException(null);
        }
    }
}
