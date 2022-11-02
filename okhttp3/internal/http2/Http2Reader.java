package okhttp3.internal.http2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UShort;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
/* loaded from: classes8.dex */
public final class Http2Reader implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean client;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    /* loaded from: classes8.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list) throws IOException;

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    /* loaded from: classes8.dex */
    public static final class ContinuationSource implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte flags;
        public int left;
        public int length;
        public short padding;
        public final BufferedSource source;
        public int streamId;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public ContinuationSource(BufferedSource bufferedSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferedSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.source = bufferedSource;
        }

        private void readContinuationHeader() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                int i = this.streamId;
                int readMedium = Http2Reader.readMedium(this.source);
                this.left = readMedium;
                this.length = readMedium;
                byte readByte = (byte) (this.source.readByte() & 255);
                this.flags = (byte) (this.source.readByte() & 255);
                if (Http2Reader.logger.isLoggable(Level.FINE)) {
                    Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, readByte, this.flags));
                }
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                this.streamId = readInt;
                if (readByte == 9) {
                    if (readInt == i) {
                        return;
                    }
                    throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) != null) {
                return invokeLJ.longValue;
            }
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j, i));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left = (int) (this.left - read);
                    return read;
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.source.timeout();
            }
            return (Timeout) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1596329017, "Lokhttp3/internal/http2/Http2Reader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1596329017, "Lokhttp3/internal/http2/Http2Reader;");
                return;
            }
        }
        logger = Logger.getLogger(Http2.class.getName());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.source.close();
        }
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(4096, continuationSource);
    }

    public static int lengthWithoutPadding(int i, byte b, short s) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Byte.valueOf(b), Short.valueOf(s)})) == null) {
            if ((b & 8) != 0) {
                i--;
            }
            if (s <= i) {
                return (short) (i - s);
            }
            throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return invokeCommon.intValue;
    }

    private void readData(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            short s = 0;
            if (i2 != 0) {
                boolean z2 = true;
                if ((b & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((b & 32) == 0) {
                    z2 = false;
                }
                if (!z2) {
                    if ((b & 8) != 0) {
                        s = (short) (this.source.readByte() & 255);
                    }
                    handler.data(z, i2, this.source, lengthWithoutPadding(i, b, s));
                    this.source.skip(s);
                    return;
                }
                throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            if (i >= 8) {
                if (i2 == 0) {
                    int readInt = this.source.readInt();
                    int readInt2 = this.source.readInt();
                    int i3 = i - 8;
                    ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                    if (fromHttp2 != null) {
                        ByteString byteString = ByteString.EMPTY;
                        if (i3 > 0) {
                            byteString = this.source.readByteString(i3);
                        }
                        handler.goAway(readInt, fromHttp2, byteString);
                        return;
                    }
                    throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                }
                throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) throws IOException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            short s = 0;
            if (i2 != 0) {
                if ((b & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((b & 8) != 0) {
                    s = (short) (this.source.readByte() & 255);
                }
                if ((b & 32) != 0) {
                    readPriority(handler, i2);
                    i -= 5;
                }
                handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, s), s, b, i2));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            if (i == 4) {
                if (i2 != 0) {
                    int readInt = this.source.readInt();
                    ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                    if (fromHttp2 != null) {
                        handler.rstStream(i2, fromHttp2);
                        return;
                    }
                    throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                }
                throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            if (i == 4) {
                long readInt = this.source.readInt() & 2147483647L;
                if (readInt != 0) {
                    handler.windowUpdate(i2, readInt);
                    return;
                }
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i), Short.valueOf(s), Byte.valueOf(b), Integer.valueOf(i2)})) == null) {
            ContinuationSource continuationSource = this.continuation;
            continuationSource.left = i;
            continuationSource.length = i;
            continuationSource.padding = s;
            continuationSource.flags = b;
            continuationSource.streamId = i2;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }
        return (List) invokeCommon.objValue;
    }

    private void readPing(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            boolean z = false;
            if (i == 8) {
                if (i2 == 0) {
                    int readInt = this.source.readInt();
                    int readInt2 = this.source.readInt();
                    if ((b & 1) != 0) {
                        z = true;
                    }
                    handler.ping(z, readInt, readInt2);
                    return;
                }
                throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
            }
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
    }

    private void readPriority(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            if (i == 5) {
                if (i2 != 0) {
                    readPriority(handler, i2);
                    return;
                }
                throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            short s = 0;
            if (i2 != 0) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.readByte() & 255);
                }
                handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, s), s, b, i2));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
    }

    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bufferedSource)) == null) {
            return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
        }
        return invokeL.intValue;
    }

    private void readPriority(Handler handler, int i) throws IOException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, handler, i) == null) {
            int readInt = this.source.readInt();
            if ((Integer.MIN_VALUE & readInt) != 0) {
                z = true;
            } else {
                z = false;
            }
            handler.priority(i, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, z);
        }
    }

    private void readSettings(Handler handler, int i, byte b, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{handler, Integer.valueOf(i), Byte.valueOf(b), Integer.valueOf(i2)}) == null) {
            if (i2 == 0) {
                if ((b & 1) != 0) {
                    if (i == 0) {
                        handler.ackSettings();
                        return;
                    }
                    throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                } else if (i % 6 == 0) {
                    Settings settings = new Settings();
                    for (int i3 = 0; i3 < i; i3 += 6) {
                        int readShort = this.source.readShort() & UShort.MAX_VALUE;
                        int readInt = this.source.readInt();
                        if (readShort != 2) {
                            if (readShort != 3) {
                                if (readShort != 4) {
                                    if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                                    }
                                } else {
                                    readShort = 7;
                                    if (readInt < 0) {
                                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                                    }
                                }
                            } else {
                                readShort = 4;
                            }
                        } else if (readInt != 0 && readInt != 1) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        settings.set(readShort, readInt);
                    }
                    handler.settings(false, settings);
                    return;
                } else {
                    throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
                }
            }
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, handler)) == null) {
            try {
                this.source.require(9L);
                int readMedium = readMedium(this.source);
                if (readMedium >= 0 && readMedium <= 16384) {
                    byte readByte = (byte) (this.source.readByte() & 255);
                    if (z && readByte != 4) {
                        throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                    }
                    byte readByte2 = (byte) (this.source.readByte() & 255);
                    int readInt = this.source.readInt() & Integer.MAX_VALUE;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(Http2.frameLog(true, readInt, readMedium, readByte, readByte2));
                    }
                    switch (readByte) {
                        case 0:
                            readData(handler, readMedium, readByte2, readInt);
                            break;
                        case 1:
                            readHeaders(handler, readMedium, readByte2, readInt);
                            break;
                        case 2:
                            readPriority(handler, readMedium, readByte2, readInt);
                            break;
                        case 3:
                            readRstStream(handler, readMedium, readByte2, readInt);
                            break;
                        case 4:
                            readSettings(handler, readMedium, readByte2, readInt);
                            break;
                        case 5:
                            readPushPromise(handler, readMedium, readByte2, readInt);
                            break;
                        case 6:
                            readPing(handler, readMedium, readByte2, readInt);
                            break;
                        case 7:
                            readGoAway(handler, readMedium, readByte2, readInt);
                            break;
                        case 8:
                            readWindowUpdate(handler, readMedium, readByte2, readInt);
                            break;
                        default:
                            this.source.skip(readMedium);
                            break;
                    }
                    return true;
                }
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeZL.booleanValue;
    }

    public void readConnectionPreface(Handler handler) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, handler) == null) {
            if (this.client) {
                if (!nextFrame(true, handler)) {
                    throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
                }
                return;
            }
            ByteString readByteString = this.source.readByteString(Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (Http2.CONNECTION_PREFACE.equals(readByteString)) {
                return;
            }
            throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
        }
    }
}
