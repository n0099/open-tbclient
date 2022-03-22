package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
/* loaded from: classes8.dex */
public final class InflaterSource implements Source {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final BufferedSource source;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.buffer(source), inflater);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source, inflater};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((BufferedSource) objArr2[0], (Inflater) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void releaseInflatedBytes() throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (i = this.bufferBytesHeldByInflater) == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:
        releaseInflatedBytes();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        if (r1.pos != r1.limit) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0061, code lost:
        r7.head = r1.pop();
        okio.SegmentPool.recycle(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
        return -1;
     */
    @Override // okio.Source
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long read(Buffer buffer, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) != null) {
            return invokeLJ.longValue;
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (i == 0) {
                return 0L;
            }
            while (true) {
                boolean refill = refill();
                try {
                    Segment writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) Math.min(j, 8192 - writableSegment.limit));
                    if (inflate > 0) {
                        writableSegment.limit += inflate;
                        long j2 = inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.inflater.finished() || this.inflater.needsDictionary()) {
                        break;
                    } else if (refill) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e2) {
                    throw new IOException(e2);
                }
            }
        } else {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
    }

    public boolean refill() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.inflater.needsInput()) {
                releaseInflatedBytes();
                if (this.inflater.getRemaining() == 0) {
                    if (this.source.exhausted()) {
                        return true;
                    }
                    Segment segment = this.source.buffer().head;
                    int i = segment.limit;
                    int i2 = segment.pos;
                    int i3 = i - i2;
                    this.bufferBytesHeldByInflater = i3;
                    this.inflater.setInput(segment.data, i2, i3);
                    return false;
                }
                throw new IllegalStateException("?");
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // okio.Source
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.source.timeout() : (Timeout) invokeV.objValue;
    }

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bufferedSource, inflater};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (bufferedSource == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (inflater != null) {
            this.source = bufferedSource;
            this.inflater = inflater;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }
}
