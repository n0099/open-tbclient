package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    Buffer buffer();

    BufferedSink emit() throws IOException;

    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    OutputStream outputStream();

    BufferedSink write(ByteString byteString) throws IOException;

    BufferedSink write(Source source, long j) throws IOException;

    BufferedSink write(byte[] bArr) throws IOException;

    BufferedSink write(byte[] bArr, int i2, int i3) throws IOException;

    long writeAll(Source source) throws IOException;

    BufferedSink writeByte(int i2) throws IOException;

    BufferedSink writeDecimalLong(long j) throws IOException;

    BufferedSink writeHexadecimalUnsignedLong(long j) throws IOException;

    BufferedSink writeInt(int i2) throws IOException;

    BufferedSink writeIntLe(int i2) throws IOException;

    BufferedSink writeLong(long j) throws IOException;

    BufferedSink writeLongLe(long j) throws IOException;

    BufferedSink writeShort(int i2) throws IOException;

    BufferedSink writeShortLe(int i2) throws IOException;

    BufferedSink writeString(String str, int i2, int i3, Charset charset) throws IOException;

    BufferedSink writeString(String str, Charset charset) throws IOException;

    BufferedSink writeUtf8(String str) throws IOException;

    BufferedSink writeUtf8(String str, int i2, int i3) throws IOException;

    BufferedSink writeUtf8CodePoint(int i2) throws IOException;
}
