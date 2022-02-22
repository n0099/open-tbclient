package okhttp3.internal.ws;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;
/* loaded from: classes5.dex */
public final class WebSocketWriter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean activeWriter;
    public final Buffer buffer;
    public final FrameSink frameSink;
    public final boolean isClient;
    public final Buffer.UnsafeCursor maskCursor;
    public final byte[] maskKey;
    public final Random random;
    public final BufferedSink sink;
    public final Buffer sinkBuffer;
    public boolean writerClosed;

    /* loaded from: classes5.dex */
    public final class FrameSink implements Sink {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean closed;
        public long contentLength;
        public int formatOpcode;
        public boolean isFirstFrame;
        public final /* synthetic */ WebSocketWriter this$0;

        public FrameSink(WebSocketWriter webSocketWriter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {webSocketWriter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = webSocketWriter;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.closed) {
                    WebSocketWriter webSocketWriter = this.this$0;
                    webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, true);
                    this.closed = true;
                    this.this$0.activeWriter = false;
                    return;
                }
                throw new IOException("closed");
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (!this.closed) {
                    WebSocketWriter webSocketWriter = this.this$0;
                    webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.size(), this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                throw new IOException("closed");
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.sink.timeout() : (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j2) == null) {
                if (!this.closed) {
                    this.this$0.buffer.write(buffer, j2);
                    boolean z = this.isFirstFrame && this.contentLength != -1 && this.this$0.buffer.size() > this.contentLength - 8192;
                    long completeSegmentByteCount = this.this$0.buffer.completeSegmentByteCount();
                    if (completeSegmentByteCount <= 0 || z) {
                        return;
                    }
                    this.this$0.writeMessageFrame(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                    this.isFirstFrame = false;
                    return;
                }
                throw new IOException("closed");
            }
        }
    }

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), bufferedSink, random};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.buffer = new Buffer();
        this.frameSink = new FrameSink(this);
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        }
        if (random != null) {
            this.isClient = z;
            this.sink = bufferedSink;
            this.sinkBuffer = bufferedSink.buffer();
            this.random = random;
            this.maskKey = z ? new byte[4] : null;
            this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
            return;
        }
        throw new NullPointerException("random == null");
    }

    private void writeControlFrame(int i2, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, this, i2, byteString) == null) {
            if (!this.writerClosed) {
                int size = byteString.size();
                if (size <= 125) {
                    this.sinkBuffer.writeByte(i2 | 128);
                    if (this.isClient) {
                        this.sinkBuffer.writeByte(size | 128);
                        this.random.nextBytes(this.maskKey);
                        this.sinkBuffer.write(this.maskKey);
                        if (size > 0) {
                            long size2 = this.sinkBuffer.size();
                            this.sinkBuffer.write(byteString);
                            this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                            this.maskCursor.seek(size2);
                            WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                            this.maskCursor.close();
                        }
                    } else {
                        this.sinkBuffer.writeByte(size);
                        this.sinkBuffer.write(byteString);
                    }
                    this.sink.flush();
                    return;
                }
                throw new IllegalArgumentException("Payload size must be less than or equal to 125");
            }
            throw new IOException("closed");
        }
    }

    public Sink newMessageSink(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (!this.activeWriter) {
                this.activeWriter = true;
                FrameSink frameSink = this.frameSink;
                frameSink.formatOpcode = i2;
                frameSink.contentLength = j2;
                frameSink.isFirstFrame = true;
                frameSink.closed = false;
                return frameSink;
            }
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        return (Sink) invokeCommon.objValue;
    }

    public void writeClose(int i2, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, byteString) == null) {
            ByteString byteString2 = ByteString.EMPTY;
            if (i2 != 0 || byteString != null) {
                if (i2 != 0) {
                    WebSocketProtocol.validateCloseCode(i2);
                }
                Buffer buffer = new Buffer();
                buffer.writeShort(i2);
                if (byteString != null) {
                    buffer.write(byteString);
                }
                byteString2 = buffer.readByteString();
            }
            try {
                writeControlFrame(8, byteString2);
            } finally {
                this.writerClosed = true;
            }
        }
    }

    public void writeMessageFrame(int i2, long j2, boolean z, boolean z2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!this.writerClosed) {
                if (!z) {
                    i2 = 0;
                }
                if (z2) {
                    i2 |= 128;
                }
                this.sinkBuffer.writeByte(i2);
                int i3 = this.isClient ? 128 : 0;
                if (j2 <= 125) {
                    this.sinkBuffer.writeByte(((int) j2) | i3);
                } else if (j2 <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    this.sinkBuffer.writeByte(i3 | 126);
                    this.sinkBuffer.writeShort((int) j2);
                } else {
                    this.sinkBuffer.writeByte(i3 | 127);
                    this.sinkBuffer.writeLong(j2);
                }
                if (this.isClient) {
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (j2 > 0) {
                        long size = this.sinkBuffer.size();
                        this.sinkBuffer.write(this.buffer, j2);
                        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                        this.maskCursor.seek(size);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.write(this.buffer, j2);
                }
                this.sink.emit();
                return;
            }
            throw new IOException("closed");
        }
    }

    public void writePing(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteString) == null) {
            writeControlFrame(9, byteString);
        }
    }

    public void writePong(ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, byteString) == null) {
            writeControlFrame(10, byteString);
        }
    }
}
