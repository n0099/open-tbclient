package okio;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
/* loaded from: classes9.dex */
public final class GzipSource implements Source {
    public static /* synthetic */ Interceptable $ic = null;
    public static final byte FCOMMENT = 4;
    public static final byte FEXTRA = 2;
    public static final byte FHCRC = 1;
    public static final byte FNAME = 3;
    public static final byte SECTION_BODY = 1;
    public static final byte SECTION_DONE = 3;
    public static final byte SECTION_HEADER = 0;
    public static final byte SECTION_TRAILER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public final CRC32 crc;
    public final Inflater inflater;
    public final InflaterSource inflaterSource;
    public int section;
    public final BufferedSource source;

    public GzipSource(Source source) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {source};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.section = 0;
        this.crc = new CRC32();
        if (source != null) {
            this.inflater = new Inflater(true);
            BufferedSource buffer = Okio.buffer(source);
            this.source = buffer;
            this.inflaterSource = new InflaterSource(buffer, this.inflater);
            return;
        }
        throw new IllegalArgumentException("source == null");
    }

    private void checkEqual(String str, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65537, this, str, i2, i3) == null) && i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", str, Integer.valueOf(i3), Integer.valueOf(i2)));
        }
    }

    private void consumeHeader() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.source.require(10L);
            byte b2 = this.source.buffer().getByte(3L);
            boolean z = ((b2 >> 1) & 1) == 1;
            if (z) {
                updateCrc(this.source.buffer(), 0L, 10L);
            }
            checkEqual("ID1ID2", 8075, this.source.readShort());
            this.source.skip(8L);
            if (((b2 >> 2) & 1) == 1) {
                this.source.require(2L);
                if (z) {
                    updateCrc(this.source.buffer(), 0L, 2L);
                }
                long readShortLe = this.source.buffer().readShortLe();
                this.source.require(readShortLe);
                if (z) {
                    updateCrc(this.source.buffer(), 0L, readShortLe);
                }
                this.source.skip(readShortLe);
            }
            if (((b2 >> 3) & 1) == 1) {
                long indexOf = this.source.indexOf((byte) 0);
                if (indexOf != -1) {
                    if (z) {
                        updateCrc(this.source.buffer(), 0L, indexOf + 1);
                    }
                    this.source.skip(indexOf + 1);
                } else {
                    throw new EOFException();
                }
            }
            if (((b2 >> 4) & 1) == 1) {
                long indexOf2 = this.source.indexOf((byte) 0);
                if (indexOf2 != -1) {
                    if (z) {
                        updateCrc(this.source.buffer(), 0L, indexOf2 + 1);
                    }
                    this.source.skip(indexOf2 + 1);
                } else {
                    throw new EOFException();
                }
            }
            if (z) {
                checkEqual("FHCRC", this.source.readShortLe(), (short) this.crc.getValue());
                this.crc.reset();
            }
        }
    }

    private void consumeTrailer() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            checkEqual("CRC", this.source.readIntLe(), (int) this.crc.getValue());
            checkEqual("ISIZE", this.source.readIntLe(), (int) this.inflater.getBytesWritten());
        }
    }

    private void updateCrc(Buffer buffer, long j, long j2) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{buffer, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            Segment segment = buffer.head;
            while (true) {
                int i3 = segment.limit;
                int i4 = segment.pos;
                if (j < i3 - i4) {
                    break;
                }
                j -= i3 - i4;
                segment = segment.next;
            }
            while (j2 > 0) {
                int min = (int) Math.min(segment.limit - i2, j2);
                this.crc.update(segment.data, (int) (segment.pos + j), min);
                j2 -= min;
                segment = segment.next;
                j = 0;
            }
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.inflaterSource.close();
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            } else if (i2 == 0) {
                return 0L;
            } else {
                if (this.section == 0) {
                    consumeHeader();
                    this.section = 1;
                }
                if (this.section == 1) {
                    long j2 = buffer.size;
                    long read = this.inflaterSource.read(buffer, j);
                    if (read != -1) {
                        updateCrc(buffer, j2, read);
                        return read;
                    }
                    this.section = 2;
                }
                if (this.section == 2) {
                    consumeTrailer();
                    this.section = 3;
                    if (!this.source.exhausted()) {
                        throw new IOException("gzip finished without exhausting source");
                    }
                }
                return -1L;
            }
        }
        return invokeLJ.longValue;
    }

    @Override // okio.Source
    public Timeout timeout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.source.timeout() : (Timeout) invokeV.objValue;
    }
}
