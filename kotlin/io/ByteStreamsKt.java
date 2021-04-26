package kotlin.io;

import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.ByteIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0004\u0010\b\u001a\u001e\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0013\u001a\u00020\u0012*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u0012*\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a$\u0010\u001a\u001a\u00020\u0012*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001e\u001a\u0014\u0010 \u001a\u00020\u001f*\u00020\u0003H\u0086\u0002¢\u0006\u0004\b \u0010!\u001a\u0013\u0010\"\u001a\u00020\u0019*\u00020\u0000H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010\"\u001a\u00020\u0019*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\"\u0010%\u001a\u001e\u0010'\u001a\u00020&*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b¢\u0006\u0004\b'\u0010(\u001a\u001e\u0010*\u001a\u00020)*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0087\b¢\u0006\u0004\b*\u0010+¨\u0006,"}, d2 = {"Ljava/io/InputStream;", "", "bufferSize", "Ljava/io/BufferedInputStream;", "buffered", "(Ljava/io/InputStream;I)Ljava/io/BufferedInputStream;", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "(Ljava/io/OutputStream;I)Ljava/io/BufferedOutputStream;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/BufferedReader;", "bufferedReader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "", "Ljava/io/ByteArrayInputStream;", "byteInputStream", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/io/ByteArrayInputStream;", "out", "", "copyTo", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", "", "inputStream", "([B)Ljava/io/ByteArrayInputStream;", "offset", CloudStabilityUBCUtils.KEY_LENGTH, "([BII)Ljava/io/ByteArrayInputStream;", "Lkotlin/collections/ByteIterator;", "iterator", "(Ljava/io/BufferedInputStream;)Lkotlin/collections/ByteIterator;", "readBytes", "(Ljava/io/InputStream;)[B", "estimatedSize", "(Ljava/io/InputStream;I)[B", "Ljava/io/InputStreamReader;", "reader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "Ljava/io/OutputStreamWriter;", "writer", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "ByteStreamsKt")
/* loaded from: classes7.dex */
public final class ByteStreamsKt {
    @InlineOnly
    public static final BufferedInputStream buffered(InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    public static /* synthetic */ BufferedInputStream buffered$default(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    @InlineOnly
    public static final BufferedReader bufferedReader(InputStream inputStream, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    public static /* synthetic */ BufferedReader bufferedReader$default(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @InlineOnly
    public static final BufferedWriter bufferedWriter(OutputStream outputStream, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @InlineOnly
    public static final ByteArrayInputStream byteInputStream(String str, Charset charset) {
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ ByteArrayInputStream byteInputStream$default(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if (str != null) {
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteArrayInputStream(bytes);
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final long copyTo(InputStream copyTo, OutputStream out, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(out, "out");
        byte[] bArr = new byte[i2];
        int read = copyTo.read(bArr);
        long j = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j += read;
            read = copyTo.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return copyTo(inputStream, outputStream, i2);
    }

    @InlineOnly
    public static final ByteArrayInputStream inputStream(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    public static final ByteIterator iterator(final BufferedInputStream iterator) {
        Intrinsics.checkNotNullParameter(iterator, "$this$iterator");
        return new ByteIterator() { // from class: kotlin.io.ByteStreamsKt$iterator$1
            public boolean finished;
            public int nextByte = -1;
            public boolean nextPrepared;

            private final void prepareNext() {
                if (this.nextPrepared || this.finished) {
                    return;
                }
                int read = iterator.read();
                this.nextByte = read;
                this.nextPrepared = true;
                this.finished = read == -1;
            }

            public final boolean getFinished() {
                return this.finished;
            }

            public final int getNextByte() {
                return this.nextByte;
            }

            public final boolean getNextPrepared() {
                return this.nextPrepared;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                prepareNext();
                return !this.finished;
            }

            @Override // kotlin.collections.ByteIterator
            public byte nextByte() {
                prepareNext();
                if (!this.finished) {
                    byte b2 = (byte) this.nextByte;
                    this.nextPrepared = false;
                    return b2;
                }
                throw new NoSuchElementException("Input stream is over.");
            }

            public final void setFinished(boolean z) {
                this.finished = z;
            }

            public final void setNextByte(int i2) {
                this.nextByte = i2;
            }

            public final void setNextPrepared(boolean z) {
                this.nextPrepared = z;
            }
        };
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    public static final byte[] readBytes(InputStream readBytes, int i2) {
        Intrinsics.checkNotNullParameter(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, readBytes.available()));
        copyTo$default(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return readBytes(inputStream, i2);
    }

    @InlineOnly
    public static final InputStreamReader reader(InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    public static /* synthetic */ InputStreamReader reader$default(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new InputStreamReader(inputStream, charset);
    }

    @InlineOnly
    public static final OutputStreamWriter writer(OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ OutputStreamWriter writer$default(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return new OutputStreamWriter(outputStream, charset);
    }

    @InlineOnly
    public static final BufferedOutputStream buffered(OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    public static /* synthetic */ BufferedOutputStream buffered$default(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @InlineOnly
    public static final ByteArrayInputStream inputStream(byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @SinceKotlin(version = "1.3")
    public static final byte[] readBytes(InputStream readBytes) {
        Intrinsics.checkNotNullParameter(readBytes, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, readBytes.available()));
        copyTo$default(readBytes, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
