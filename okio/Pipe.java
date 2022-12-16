package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes9.dex */
public final class Pipe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public final long maxBufferSize;
    public final Sink sink;
    public boolean sinkClosed;
    public final Source source;
    public boolean sourceClosed;

    /* loaded from: classes9.dex */
    public final class PipeSink implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Pipe this$0;
        public final Timeout timeout;

        public PipeSink(Pipe pipe) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pipe};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pipe;
            this.timeout = new Timeout();
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0.buffer) {
                    if (this.this$0.sinkClosed) {
                        return;
                    }
                    if (this.this$0.sourceClosed && this.this$0.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    this.this$0.sinkClosed = true;
                    this.this$0.buffer.notifyAll();
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                synchronized (this.this$0.buffer) {
                    if (!this.this$0.sinkClosed) {
                        if (this.this$0.sourceClosed && this.this$0.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.timeout;
            }
            return (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                synchronized (this.this$0.buffer) {
                    if (!this.this$0.sinkClosed) {
                        while (j > 0) {
                            if (!this.this$0.sourceClosed) {
                                long size = this.this$0.maxBufferSize - this.this$0.buffer.size();
                                if (size == 0) {
                                    this.timeout.waitUntilNotified(this.this$0.buffer);
                                } else {
                                    long min = Math.min(size, j);
                                    this.this$0.buffer.write(buffer, min);
                                    j -= min;
                                    this.this$0.buffer.notifyAll();
                                }
                            } else {
                                throw new IOException("source is closed");
                            }
                        }
                    } else {
                        throw new IllegalStateException("closed");
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public final class PipeSource implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Pipe this$0;
        public final Timeout timeout;

        public PipeSource(Pipe pipe) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pipe};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = pipe;
            this.timeout = new Timeout();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.this$0.buffer) {
                    this.this$0.sourceClosed = true;
                    this.this$0.buffer.notifyAll();
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.timeout;
            }
            return (Timeout) invokeV.objValue;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                synchronized (this.this$0.buffer) {
                    if (!this.this$0.sourceClosed) {
                        while (this.this$0.buffer.size() == 0) {
                            if (this.this$0.sinkClosed) {
                                return -1L;
                            }
                            this.timeout.waitUntilNotified(this.this$0.buffer);
                        }
                        long read = this.this$0.buffer.read(buffer, j);
                        this.this$0.buffer.notifyAll();
                        return read;
                    }
                    throw new IllegalStateException("closed");
                }
            }
            return invokeLJ.longValue;
        }
    }

    public Pipe(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = new Buffer();
        this.sink = new PipeSink(this);
        this.source = new PipeSource(this);
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public final Sink sink() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.sink;
        }
        return (Sink) invokeV.objValue;
    }

    public final Source source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.source;
        }
        return (Source) invokeV.objValue;
    }
}
