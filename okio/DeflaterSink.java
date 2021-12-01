package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.zip.Deflater;
/* loaded from: classes3.dex */
public final class DeflaterSink implements Sink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean closed;
    public final Deflater deflater;
    public final BufferedSink sink;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.buffer(sink), deflater);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sink, deflater};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BufferedSink) objArr2[0], (Deflater) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void deflate(boolean z) throws IOException {
        Segment writableSegment;
        int deflate;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            Buffer buffer = this.sink.buffer();
            while (true) {
                writableSegment = buffer.writableSegment(1);
                if (z) {
                    Deflater deflater = this.deflater;
                    byte[] bArr = writableSegment.data;
                    int i2 = writableSegment.limit;
                    deflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
                } else {
                    Deflater deflater2 = this.deflater;
                    byte[] bArr2 = writableSegment.data;
                    int i3 = writableSegment.limit;
                    deflate = deflater2.deflate(bArr2, i3, 8192 - i3);
                }
                if (deflate > 0) {
                    writableSegment.limit += deflate;
                    buffer.size += deflate;
                    this.sink.emitCompleteSegments();
                } else if (this.deflater.needsInput()) {
                    break;
                }
            }
            if (writableSegment.pos == writableSegment.limit) {
                buffer.head = writableSegment.pop();
                SegmentPool.recycle(writableSegment);
            }
        }
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
            return;
        }
        Throwable th = null;
        try {
            finishDeflate();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.deflater.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.closed = true;
        if (th != null) {
            Util.sneakyRethrow(th);
        }
    }

    public void finishDeflate() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.deflater.finish();
            deflate(false);
        }
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            deflate(true);
            this.sink.flush();
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sink.timeout() : (Timeout) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return "DeflaterSink(" + this.sink + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048581, this, buffer, j2) == null) {
            Util.checkOffsetAndCount(buffer.size, 0L, j2);
            while (j2 > 0) {
                Segment segment = buffer.head;
                int min = (int) Math.min(j2, segment.limit - segment.pos);
                this.deflater.setInput(segment.data, segment.pos, min);
                deflate(false);
                long j3 = min;
                buffer.size -= j3;
                int i2 = segment.pos + min;
                segment.pos = i2;
                if (i2 == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
                j2 -= j3;
            }
        }
    }

    public DeflaterSink(BufferedSink bufferedSink, Deflater deflater) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSink, deflater};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bufferedSink == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (deflater != null) {
            this.sink = bufferedSink;
            this.deflater = deflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
