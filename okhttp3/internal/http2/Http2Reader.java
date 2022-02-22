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
/* loaded from: classes5.dex */
public final class Http2Reader implements Closeable {
    public static /* synthetic */ Interceptable $ic;
    public static final Logger logger;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean client;
    public final ContinuationSource continuation;
    public final Hpack.Reader hpackReader;
    public final BufferedSource source;

    /* loaded from: classes5.dex */
    public static final class ContinuationSource implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte flags;
        public int left;
        public int length;
        public short padding;
        public final BufferedSource source;
        public int streamId;

        public ContinuationSource(BufferedSource bufferedSource) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bufferedSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = this.streamId;
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
                if (readByte != 9) {
                    throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                }
                if (readInt != i2) {
                    throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j2)) != null) {
                return invokeLJ.longValue;
            }
            while (true) {
                int i2 = this.left;
                if (i2 == 0) {
                    this.source.skip(this.padding);
                    this.padding = (short) 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j2, i2));
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.source.timeout() : (Timeout) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, ByteString byteString, String str2, int i3, long j2);

        void data(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i2, int i3, List<Header> list);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i2, long j2);
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

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public static int lengthWithoutPadding(int i2, byte b2, short s) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2), Short.valueOf(s)})) == null) {
            if ((b2 & 8) != 0) {
                i2--;
            }
            if (s <= i2) {
                return (short) (i2 - s);
            }
            throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
        }
        return invokeCommon.intValue;
    }

    private void readData(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 == 0) {
                throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            }
            boolean z = (b2 & 1) != 0;
            if (!((b2 & 32) != 0)) {
                short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                handler.data(z, i3, this.source, lengthWithoutPadding(i2, b2, readByte));
                this.source.skip(readByte);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
    }

    private void readGoAway(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 < 8) {
                throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                int readInt = this.source.readInt();
                int readInt2 = this.source.readInt();
                int i4 = i2 - 8;
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
                }
                ByteString byteString = ByteString.EMPTY;
                if (i4 > 0) {
                    byteString = this.source.readByteString(i4);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<Header> readHeaderBlock(int i2, short s, byte b2, int i3) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, this, new Object[]{Integer.valueOf(i2), Short.valueOf(s), Byte.valueOf(b2), Integer.valueOf(i3)})) == null) {
            ContinuationSource continuationSource = this.continuation;
            continuationSource.left = i2;
            continuationSource.length = i2;
            continuationSource.padding = s;
            continuationSource.flags = b2;
            continuationSource.streamId = i3;
            this.hpackReader.readHeaders();
            return this.hpackReader.getAndResetHeaderList();
        }
        return (List) invokeCommon.objValue;
    }

    private void readHeaders(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                boolean z = (b2 & 1) != 0;
                short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                if ((b2 & 32) != 0) {
                    readPriority(handler, i3);
                    i2 -= 5;
                }
                handler.headers(z, i3, -1, readHeaderBlock(lengthWithoutPadding(i2, b2, readByte), readByte, b2, i3));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
    }

    public static int readMedium(BufferedSource bufferedSource) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bufferedSource)) == null) ? (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8) : invokeL.intValue;
    }

    private void readPing(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 8) {
                throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i2));
            }
            if (i3 == 0) {
                handler.ping((b2 & 1) != 0, this.source.readInt(), this.source.readInt());
                return;
            }
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 5) {
                throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                readPriority(handler, i3);
                return;
            }
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPushPromise(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                short readByte = (b2 & 8) != 0 ? (short) (this.source.readByte() & 255) : (short) 0;
                handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i2 - 4, b2, readByte), readByte, b2, i3));
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
    }

    private void readRstStream(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i2));
            }
            if (i3 != 0) {
                int readInt = this.source.readInt();
                ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
                if (fromHttp2 == null) {
                    throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
                }
                handler.rstStream(i3, fromHttp2);
                return;
            }
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void readSettings(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i3 != 0) {
                throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b2 & 1) != 0) {
                if (i2 == 0) {
                    handler.ackSettings();
                    return;
                }
                throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            } else if (i2 % 6 != 0) {
                throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i2));
            } else {
                Settings settings = new Settings();
                for (int i4 = 0; i4 < i2; i4 += 6) {
                    int readShort = this.source.readShort() & UShort.MAX_VALUE;
                    int readInt = this.source.readInt();
                    if (readShort != 2) {
                        if (readShort == 3) {
                            readShort = 4;
                        } else if (readShort == 4) {
                            readShort = 7;
                            if (readInt < 0) {
                                throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                        } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt != 0 && readInt != 1) {
                        throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    settings.set(readShort, readInt);
                }
                handler.settings(false, settings);
            }
        }
    }

    private void readWindowUpdate(Handler handler, int i2, byte b2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, this, new Object[]{handler, Integer.valueOf(i2), Byte.valueOf(b2), Integer.valueOf(i3)}) == null) {
            if (i2 != 4) {
                throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i2));
            }
            long readInt = this.source.readInt() & 2147483647L;
            if (readInt == 0) {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
            handler.windowUpdate(i3, readInt);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.source.close();
        }
    }

    public boolean nextFrame(boolean z, Handler handler) throws IOException {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z, handler)) == null) {
            try {
                this.source.require(9L);
                int readMedium = readMedium(this.source);
                if (readMedium < 0 || readMedium > 16384) {
                    throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
                }
                byte readByte = (byte) (this.source.readByte() & 255);
                if (!z || readByte == 4) {
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
                throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
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
            if (!Http2.CONNECTION_PREFACE.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        }
    }

    private void readPriority(Handler handler, int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, handler, i2) == null) {
            int readInt = this.source.readInt();
            handler.priority(i2, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }
    }
}
