package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
/* loaded from: classes8.dex */
public final class GzipSink implements Sink {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean closed;
    public final CRC32 crc;
    public final Deflater deflater;
    public final DeflaterSink deflaterSink;
    public final BufferedSink sink;

    public GzipSink(Sink sink) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sink};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.crc = new CRC32();
        if (sink != null) {
            this.deflater = new Deflater(-1, true);
            BufferedSink buffer = Okio.buffer(sink);
            this.sink = buffer;
            this.deflaterSink = new DeflaterSink(buffer, this.deflater);
            writeHeader();
            return;
        }
        throw new IllegalArgumentException("sink == null");
    }

    private void updateCrc(Buffer buffer, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65537, this, buffer, j) == null) {
            Segment segment = buffer.head;
            while (j > 0) {
                int min = (int) Math.min(j, segment.limit - segment.pos);
                this.crc.update(segment.data, segment.pos, min);
                j -= min;
                segment = segment.next;
            }
        }
    }

    private void writeFooter() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.sink.writeIntLe((int) this.crc.getValue());
            this.sink.writeIntLe((int) this.deflater.getBytesRead());
        }
    }

    private void writeHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            Buffer buffer = this.sink.buffer();
            buffer.writeShort(w0.y5);
            buffer.writeByte(8);
            buffer.writeByte(0);
            buffer.writeInt(0);
            buffer.writeByte(0);
            buffer.writeByte(0);
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
            this.deflaterSink.finishDeflate();
            writeFooter();
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

    public Deflater deflater() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.deflater : (Deflater) invokeV.objValue;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.deflaterSink.flush();
        }
    }

    @Override // okio.Sink
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.sink.timeout() : (Timeout) invokeV.objValue;
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048580, this, buffer, j) == null) {
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i == 0) {
            } else {
                updateCrc(buffer, j);
                this.deflaterSink.write(buffer, j);
            }
        }
    }
}
