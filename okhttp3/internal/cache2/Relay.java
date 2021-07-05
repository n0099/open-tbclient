package okhttp3.internal.cache2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
/* loaded from: classes10.dex */
public final class Relay {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long FILE_HEADER_SIZE = 32;
    public static final ByteString PREFIX_CLEAN;
    public static final ByteString PREFIX_DIRTY;
    public static final int SOURCE_FILE = 2;
    public static final int SOURCE_UPSTREAM = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final Buffer buffer;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    public final ByteString metadata;
    public int sourceCount;
    public Source upstream;
    public final Buffer upstreamBuffer;
    public long upstreamPos;
    public Thread upstreamReader;

    /* loaded from: classes10.dex */
    public class RelaySource implements Source {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FileOperator fileOperator;
        public long sourcePos;
        public final /* synthetic */ Relay this$0;
        public final Timeout timeout;

        public RelaySource(Relay relay) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relay};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = relay;
            this.timeout = new Timeout();
            this.fileOperator = new FileOperator(this.this$0.file.getChannel());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (this.this$0) {
                Relay relay = this.this$0;
                relay.sourceCount--;
                if (this.this$0.sourceCount == 0) {
                    RandomAccessFile randomAccessFile2 = this.this$0.file;
                    this.this$0.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
            if (r5 != 2) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
            r2 = java.lang.Math.min(r23, r7 - r21.sourcePos);
            r21.fileOperator.read(r21.sourcePos + 32, r22, r2);
            r21.sourcePos += r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
            r5 = r21.this$0.upstream.read(r21.this$0.upstreamBuffer, r21.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
            if (r5 != (-1)) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
            r21.this$0.commit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
            r2 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0089, code lost:
            monitor-enter(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x008a, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
            monitor-exit(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0098, code lost:
            r2 = java.lang.Math.min(r5, r23);
            r21.this$0.upstreamBuffer.copyTo(r22, 0, r2);
            r21.sourcePos += r2;
            r21.fileOperator.write(r7 + 32, r21.this$0.upstreamBuffer.clone(), r5);
            r7 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
            monitor-enter(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00c2, code lost:
            r21.this$0.buffer.write(r21.this$0.upstreamBuffer, r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:
            if (r21.this$0.buffer.size() <= r21.this$0.bufferMaxSize) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x00dd, code lost:
            r21.this$0.buffer.skip(r21.this$0.buffer.size() - r21.this$0.bufferMaxSize);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00f1, code lost:
            r21.this$0.upstreamPos += r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00f8, code lost:
            monitor-exit(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
            r5 = r21.this$0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00fb, code lost:
            monitor-enter(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0105, code lost:
            monitor-exit(r5);
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0106, code lost:
            return r2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x010d, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0110, code lost:
            monitor-enter(r21.this$0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0111, code lost:
            r21.this$0.upstreamReader = null;
            r21.this$0.notifyAll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x011b, code lost:
            throw r0;
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long read(Buffer buffer, long j) throws IOException {
            InterceptResult invokeLJ;
            char c2;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) != null) {
                return invokeLJ.longValue;
            }
            if (this.fileOperator != null) {
                synchronized (this.this$0) {
                    while (true) {
                        long j2 = this.sourcePos;
                        long j3 = this.this$0.upstreamPos;
                        if (j2 == j3) {
                            if (!this.this$0.complete) {
                                if (this.this$0.upstreamReader != null) {
                                    this.timeout.waitUntilNotified(this.this$0);
                                } else {
                                    this.this$0.upstreamReader = Thread.currentThread();
                                    c2 = 1;
                                    break;
                                }
                            } else {
                                return -1L;
                            }
                        } else {
                            long size = j3 - this.this$0.buffer.size();
                            if (this.sourcePos >= size) {
                                long min = Math.min(j, j3 - this.sourcePos);
                                this.this$0.buffer.copyTo(buffer, this.sourcePos - size, min);
                                this.sourcePos += min;
                                return min;
                            }
                            c2 = 2;
                        }
                    }
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timeout : (Timeout) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-706833629, "Lokhttp3/internal/cache2/Relay;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-706833629, "Lokhttp3/internal/cache2/Relay;");
                return;
            }
        }
        PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    }

    public Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {randomAccessFile, source, Long.valueOf(j), byteString, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.upstreamBuffer = new Buffer();
        this.buffer = new Buffer();
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, Source source, ByteString byteString, long j) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{file, source, byteString, Long.valueOf(j)})) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, source, 0L, byteString, j);
            randomAccessFile.setLength(0L);
            relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
            return relay;
        }
        return (Relay) invokeCommon.objValue;
    }

    public static Relay read(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
            Buffer buffer = new Buffer();
            fileOperator.read(0L, buffer, 32L);
            if (buffer.readByteString(PREFIX_CLEAN.size()).equals(PREFIX_CLEAN)) {
                long readLong = buffer.readLong();
                long readLong2 = buffer.readLong();
                Buffer buffer2 = new Buffer();
                fileOperator.read(readLong + 32, buffer2, readLong2);
                return new Relay(randomAccessFile, null, readLong, buffer2.readByteString(), 0L);
            }
            throw new IOException("unreadable cache file");
        }
        return (Relay) invokeL.objValue;
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65540, this, new Object[]{byteString, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            Buffer buffer = new Buffer();
            buffer.write(byteString);
            buffer.writeLong(j);
            buffer.writeLong(j2);
            if (buffer.size() == 32) {
                new FileOperator(this.file.getChannel()).write(0L, buffer, 32L);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    private void writeMetadata(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, this, j) == null) {
            Buffer buffer = new Buffer();
            buffer.write(this.metadata);
            new FileOperator(this.file.getChannel()).write(32 + j, buffer, this.metadata.size());
        }
    }

    public void commit(long j) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            writeMetadata(j);
            this.file.getChannel().force(false);
            writeHeader(PREFIX_CLEAN, j, this.metadata.size());
            this.file.getChannel().force(false);
            synchronized (this) {
                this.complete = true;
            }
            Util.closeQuietly(this.upstream);
            this.upstream = null;
        }
    }

    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.file == null : invokeV.booleanValue;
    }

    public ByteString metadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.metadata : (ByteString) invokeV.objValue;
    }

    public Source newSource() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this) {
                if (this.file == null) {
                    return null;
                }
                this.sourceCount++;
                return new RelaySource(this);
            }
        }
        return (Source) invokeV.objValue;
    }
}
