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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public final class Okio {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-129639080, "Lokio/Okio;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-129639080, "Lokio/Okio;");
                return;
            }
        }
        logger = Logger.getLogger(Okio.class.getName());
    }

    public Okio() {
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

    public static Sink blackhole() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new Sink() { // from class: okio.Okio.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                @Override // okio.Sink
                public Timeout timeout() {
                    InterceptResult invokeV2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return Timeout.NONE;
                    }
                    return (Timeout) invokeV2.objValue;
                }

                @Override // okio.Sink
                public void write(Buffer buffer, long j) throws IOException {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLJ(1048579, this, buffer, j) == null) {
                        buffer.skip(j);
                    }
                }
            };
        }
        return (Sink) invokeV.objValue;
    }

    public static Sink appendingSink(File file) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            if (file != null) {
                return sink(new FileOutputStream(file, true));
            }
            throw new IllegalArgumentException("file == null");
        }
        return (Sink) invokeL.objValue;
    }

    public static BufferedSink buffer(Sink sink) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sink)) == null) {
            return new RealBufferedSink(sink);
        }
        return (BufferedSink) invokeL.objValue;
    }

    public static boolean isAndroidGetsocknameError(AssertionError assertionError) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, assertionError)) == null) {
            if (assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains("getsockname failed")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static Sink sink(File file) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            if (file != null) {
                return sink(new FileOutputStream(file));
            }
            throw new IllegalArgumentException("file == null");
        }
        return (Sink) invokeL.objValue;
    }

    public static Source source(File file) throws FileNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) {
            if (file != null) {
                return source(new FileInputStream(file));
            }
            throw new IllegalArgumentException("file == null");
        }
        return (Source) invokeL.objValue;
    }

    public static AsyncTimeout timeout(Socket socket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, socket)) == null) {
            return new AsyncTimeout(socket) { // from class: okio.Okio.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Socket val$socket;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {socket};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$socket = socket;
                }

                @Override // okio.AsyncTimeout
                public IOException newTimeoutException(@Nullable IOException iOException) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, iOException)) == null) {
                        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                        if (iOException != null) {
                            socketTimeoutException.initCause(iOException);
                        }
                        return socketTimeoutException;
                    }
                    return (IOException) invokeL2.objValue;
                }

                @Override // okio.AsyncTimeout
                public void timedOut() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        try {
                            this.val$socket.close();
                        } catch (AssertionError e) {
                            if (Okio.isAndroidGetsocknameError(e)) {
                                Logger logger2 = Okio.logger;
                                Level level = Level.WARNING;
                                logger2.log(level, "Failed to close timed out socket " + this.val$socket, (Throwable) e);
                                return;
                            }
                            throw e;
                        } catch (Exception e2) {
                            Logger logger3 = Okio.logger;
                            Level level2 = Level.WARNING;
                            logger3.log(level2, "Failed to close timed out socket " + this.val$socket, (Throwable) e2);
                        }
                    }
                }
            };
        }
        return (AsyncTimeout) invokeL.objValue;
    }

    public static BufferedSource buffer(Source source) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, source)) == null) {
            return new RealBufferedSource(source);
        }
        return (BufferedSource) invokeL.objValue;
    }

    public static Sink sink(OutputStream outputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, outputStream)) == null) {
            return sink(outputStream, new Timeout());
        }
        return (Sink) invokeL.objValue;
    }

    public static Source source(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, inputStream)) == null) {
            return source(inputStream, new Timeout());
        }
        return (Source) invokeL.objValue;
    }

    public static Sink sink(OutputStream outputStream, Timeout timeout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, outputStream, timeout)) == null) {
            if (outputStream != null) {
                if (timeout != null) {
                    return new Sink(timeout, outputStream) { // from class: okio.Okio.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ OutputStream val$out;
                        public final /* synthetic */ Timeout val$timeout;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {timeout, outputStream};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$timeout = timeout;
                            this.val$out = outputStream;
                        }

                        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$out.close();
                            }
                        }

                        @Override // okio.Sink, java.io.Flushable
                        public void flush() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                this.val$out.flush();
                            }
                        }

                        @Override // okio.Sink
                        public Timeout timeout() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                                return this.val$timeout;
                            }
                            return (Timeout) invokeV.objValue;
                        }

                        public String toString() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                                return "sink(" + this.val$out + SmallTailInfo.EMOTION_SUFFIX;
                            }
                            return (String) invokeV.objValue;
                        }

                        @Override // okio.Sink
                        public void write(Buffer buffer, long j) throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeLJ(1048580, this, buffer, j) == null) {
                                Util.checkOffsetAndCount(buffer.size, 0L, j);
                                while (j > 0) {
                                    this.val$timeout.throwIfReached();
                                    Segment segment = buffer.head;
                                    int min = (int) Math.min(j, segment.limit - segment.pos);
                                    this.val$out.write(segment.data, segment.pos, min);
                                    int i = segment.pos + min;
                                    segment.pos = i;
                                    long j2 = min;
                                    j -= j2;
                                    buffer.size -= j2;
                                    if (i == segment.limit) {
                                        buffer.head = segment.pop();
                                        SegmentPool.recycle(segment);
                                    }
                                }
                            }
                        }
                    };
                }
                throw new IllegalArgumentException("timeout == null");
            }
            throw new IllegalArgumentException("out == null");
        }
        return (Sink) invokeLL.objValue;
    }

    public static Source source(InputStream inputStream, Timeout timeout) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, inputStream, timeout)) == null) {
            if (inputStream != null) {
                if (timeout != null) {
                    return new Source(timeout, inputStream) { // from class: okio.Okio.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ InputStream val$in;
                        public final /* synthetic */ Timeout val$timeout;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {timeout, inputStream};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.val$timeout = timeout;
                            this.val$in = inputStream;
                        }

                        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                        public void close() throws IOException {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$in.close();
                            }
                        }

                        @Override // okio.Source
                        public Timeout timeout() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                                return this.val$timeout;
                            }
                            return (Timeout) invokeV.objValue;
                        }

                        public String toString() {
                            InterceptResult invokeV;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                                return "source(" + this.val$in + SmallTailInfo.EMOTION_SUFFIX;
                            }
                            return (String) invokeV.objValue;
                        }

                        @Override // okio.Source
                        public long read(Buffer buffer, long j) throws IOException {
                            InterceptResult invokeLJ;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLJ = interceptable2.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                                int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
                                if (i >= 0) {
                                    if (i == 0) {
                                        return 0L;
                                    }
                                    try {
                                        this.val$timeout.throwIfReached();
                                        Segment writableSegment = buffer.writableSegment(1);
                                        int read = this.val$in.read(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                                        if (read == -1) {
                                            return -1L;
                                        }
                                        writableSegment.limit += read;
                                        long j2 = read;
                                        buffer.size += j2;
                                        return j2;
                                    } catch (AssertionError e) {
                                        if (Okio.isAndroidGetsocknameError(e)) {
                                            throw new IOException(e);
                                        }
                                        throw e;
                                    }
                                }
                                throw new IllegalArgumentException("byteCount < 0: " + j);
                            }
                            return invokeLJ.longValue;
                        }
                    };
                }
                throw new IllegalArgumentException("timeout == null");
            }
            throw new IllegalArgumentException("in == null");
        }
        return (Source) invokeLL.objValue;
    }

    public static Sink sink(Socket socket) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, socket)) == null) {
            if (socket != null) {
                if (socket.getOutputStream() != null) {
                    AsyncTimeout timeout = timeout(socket);
                    return timeout.sink(sink(socket.getOutputStream(), timeout));
                }
                throw new IOException("socket's output stream == null");
            }
            throw new IllegalArgumentException("socket == null");
        }
        return (Sink) invokeL.objValue;
    }

    public static Source source(Socket socket) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, socket)) == null) {
            if (socket != null) {
                if (socket.getInputStream() != null) {
                    AsyncTimeout timeout = timeout(socket);
                    return timeout.source(source(socket.getInputStream(), timeout));
                }
                throw new IOException("socket's input stream == null");
            }
            throw new IllegalArgumentException("socket == null");
        }
        return (Source) invokeL.objValue;
    }

    public static Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, path, openOptionArr)) == null) {
            if (path != null) {
                return sink(Files.newOutputStream(path, openOptionArr));
            }
            throw new IllegalArgumentException("path == null");
        }
        return (Sink) invokeLL.objValue;
    }

    public static Source source(Path path, OpenOption... openOptionArr) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, path, openOptionArr)) == null) {
            if (path != null) {
                return source(Files.newInputStream(path, openOptionArr));
            }
            throw new IllegalArgumentException("path == null");
        }
        return (Source) invokeLL.objValue;
    }
}
