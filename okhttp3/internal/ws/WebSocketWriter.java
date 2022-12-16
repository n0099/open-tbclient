package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
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
/* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.this$0.sink.timeout();
            }
            return (Timeout) invokeV.objValue;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048579, this, buffer, j) == null) {
                if (!this.closed) {
                    this.this$0.buffer.write(buffer, j);
                    if (this.isFirstFrame && this.contentLength != -1 && this.this$0.buffer.size() > this.contentLength - PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        z = true;
                    } else {
                        z = false;
                    }
                    long completeSegmentByteCount = this.this$0.buffer.completeSegmentByteCount();
                    if (completeSegmentByteCount > 0 && !z) {
                        this.this$0.writeMessageFrame(this.formatOpcode, completeSegmentByteCount, this.isFirstFrame, false);
                        this.isFirstFrame = false;
                        return;
                    }
                    return;
                }
                throw new IOException("closed");
            }
        }
    }

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), bufferedSink, random};
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
        this.frameSink = new FrameSink(this);
        if (bufferedSink != null) {
            if (random != null) {
                this.isClient = z;
                this.sink = bufferedSink;
                this.sinkBuffer = bufferedSink.buffer();
                this.random = random;
                if (z) {
                    bArr = new byte[4];
                } else {
                    bArr = null;
                }
                this.maskKey = bArr;
                this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
                return;
            }
            throw new NullPointerException("random == null");
        }
        throw new NullPointerException("sink == null");
    }

    private void writeControlFrame(int i, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, this, i, byteString) == null) {
            if (!this.writerClosed) {
                int size = byteString.size();
                if (size <= 125) {
                    this.sinkBuffer.writeByte(i | 128);
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

    public Sink newMessageSink(int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (!this.activeWriter) {
                this.activeWriter = true;
                FrameSink frameSink = this.frameSink;
                frameSink.formatOpcode = i;
                frameSink.contentLength = j;
                frameSink.isFirstFrame = true;
                frameSink.closed = false;
                return frameSink;
            }
            throw new IllegalStateException("Another message writer is active. Did you call close()?");
        }
        return (Sink) invokeCommon.objValue;
    }

    public void writeClose(int i, ByteString byteString) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, byteString) == null) {
            ByteString byteString2 = ByteString.EMPTY;
            if (i != 0 || byteString != null) {
                if (i != 0) {
                    WebSocketProtocol.validateCloseCode(i);
                }
                Buffer buffer = new Buffer();
                buffer.writeShort(i);
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

    public void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (!this.writerClosed) {
                int i2 = 0;
                if (!z) {
                    i = 0;
                }
                if (z2) {
                    i |= 128;
                }
                this.sinkBuffer.writeByte(i);
                if (this.isClient) {
                    i2 = 128;
                }
                if (j <= 125) {
                    this.sinkBuffer.writeByte(((int) j) | i2);
                } else if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                    this.sinkBuffer.writeByte(i2 | 126);
                    this.sinkBuffer.writeShort((int) j);
                } else {
                    this.sinkBuffer.writeByte(i2 | 127);
                    this.sinkBuffer.writeLong(j);
                }
                if (this.isClient) {
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (j > 0) {
                        long size = this.sinkBuffer.size();
                        this.sinkBuffer.write(this.buffer, j);
                        this.sinkBuffer.readAndWriteUnsafe(this.maskCursor);
                        this.maskCursor.seek(size);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.write(this.buffer, j);
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
