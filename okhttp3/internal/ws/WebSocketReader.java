package okhttp3.internal.ws;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
/* loaded from: classes10.dex */
public final class WebSocketReader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean closed;
    public final Buffer controlFrameBuffer;
    public final FrameCallback frameCallback;
    public long frameLength;
    public final boolean isClient;
    public boolean isControlFrame;
    public boolean isFinalFrame;
    public final Buffer.UnsafeCursor maskCursor;
    public final byte[] maskKey;
    public final Buffer messageFrameBuffer;
    public int opcode;
    public final BufferedSource source;

    /* loaded from: classes10.dex */
    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(String str) throws IOException;

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), bufferedSource, frameCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.controlFrameBuffer = new Buffer();
        this.messageFrameBuffer = new Buffer();
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback != null) {
            this.isClient = z;
            this.source = bufferedSource;
            this.frameCallback = frameCallback;
            this.maskKey = z ? null : new byte[4];
            this.maskCursor = z ? null : new Buffer.UnsafeCursor();
            return;
        }
        throw new NullPointerException("frameCallback == null");
    }

    private void readControlFrame() throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            long j = this.frameLength;
            if (j > 0) {
                this.source.readFully(this.controlFrameBuffer, j);
                if (!this.isClient) {
                    this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(0L);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            switch (this.opcode) {
                case 8:
                    short s = 1005;
                    long size = this.controlFrameBuffer.size();
                    if (size != 1) {
                        if (size != 0) {
                            s = this.controlFrameBuffer.readShort();
                            str = this.controlFrameBuffer.readUtf8();
                            String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                            if (closeCodeExceptionMessage != null) {
                                throw new ProtocolException(closeCodeExceptionMessage);
                            }
                        } else {
                            str = "";
                        }
                        this.frameCallback.onReadClose(s, str);
                        this.closed = true;
                        return;
                    }
                    throw new ProtocolException("Malformed close payload length of 1.");
                case 9:
                    this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                    return;
                case 10:
                    this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                    return;
                default:
                    throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
            }
        }
    }

    /* JADX DEBUG: Incorrect finally slice size: {[IGET, INVOKE, SGET, INVOKE, ARITH] complete}, expected: {[IGET, INVOKE, SGET, INVOKE] complete} */
    /* JADX WARN: Finally extract failed */
    private void readHeader() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            if (!this.closed) {
                long timeoutNanos = this.source.timeout().timeoutNanos();
                this.source.timeout().clearTimeout();
                try {
                    int readByte = this.source.readByte() & 255;
                    this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    this.opcode = readByte & 15;
                    this.isFinalFrame = (readByte & 128) != 0;
                    boolean z = (readByte & 8) != 0;
                    this.isControlFrame = z;
                    if (z && !this.isFinalFrame) {
                        throw new ProtocolException("Control frames must be final.");
                    }
                    boolean z2 = (readByte & 64) != 0;
                    boolean z3 = (readByte & 32) != 0;
                    boolean z4 = (readByte & 16) != 0;
                    if (!z2 && !z3 && !z4) {
                        int readByte2 = this.source.readByte() & 255;
                        boolean z5 = (readByte2 & 128) != 0;
                        if (z5 == this.isClient) {
                            throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                        }
                        long j = readByte2 & 127;
                        this.frameLength = j;
                        if (j == 126) {
                            this.frameLength = this.source.readShort() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                        } else if (j == 127) {
                            long readLong = this.source.readLong();
                            this.frameLength = readLong;
                            if (readLong < 0) {
                                throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                            }
                        }
                        if (this.isControlFrame && this.frameLength > 125) {
                            throw new ProtocolException("Control frame must be less than 125B.");
                        }
                        if (z5) {
                            this.source.readFully(this.maskKey);
                            return;
                        }
                        return;
                    }
                    throw new ProtocolException("Reserved flags are unsupported.");
                } catch (Throwable th) {
                    this.source.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                    throw th;
                }
            }
            throw new IOException("closed");
        }
    }

    private void readMessage() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            while (!this.closed) {
                long j = this.frameLength;
                if (j > 0) {
                    this.source.readFully(this.messageFrameBuffer, j);
                    if (!this.isClient) {
                        this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                        this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                }
                if (this.isFinalFrame) {
                    return;
                }
                readUntilNonControlFrame();
                if (this.opcode != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
                }
            }
            throw new IOException("closed");
        }
    }

    private void readMessageFrame() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            int i2 = this.opcode;
            if (i2 != 1 && i2 != 2) {
                throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
            }
            readMessage();
            if (i2 == 1) {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
            } else {
                this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
            }
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            while (!this.closed) {
                readHeader();
                if (!this.isControlFrame) {
                    return;
                }
                readControlFrame();
            }
        }
    }

    public void processNextFrame() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            readHeader();
            if (this.isControlFrame) {
                readControlFrame();
            } else {
                readMessageFrame();
            }
        }
    }
}
