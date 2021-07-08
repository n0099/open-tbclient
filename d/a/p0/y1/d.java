package d.a.p0.y1;

import com.baidu.mapsdkplatform.comapi.map.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
/* loaded from: classes8.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f66420a;

        /* renamed from: b  reason: collision with root package name */
        public long f66421b;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static long a(RandomAccessFile randomAccessFile, a aVar) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, randomAccessFile, aVar)) == null) {
            CRC32 crc32 = new CRC32();
            long j = aVar.f66421b;
            randomAccessFile.seek(aVar.f66420a);
            int min = (int) Math.min(16384L, j);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = randomAccessFile.read(bArr, 0, min);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j -= read;
                if (j == 0) {
                    break;
                }
                min = (int) Math.min(16384L, j);
            }
            return crc32.getValue();
        }
        return invokeLL.longValue;
    }

    public static a b(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, randomAccessFile)) == null) {
            long length = randomAccessFile.length() - 22;
            if (length >= 0) {
                long j = length - 65536;
                long j2 = j >= 0 ? j : 0L;
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        a aVar = new a();
                        aVar.f66421b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        aVar.f66420a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        return aVar;
                    }
                    length--;
                } while (length >= j2);
                throw new ZipException("End Of Central Directory signature not found");
            }
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        return (a) invokeL.objValue;
    }

    public static long c(File file) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, file)) == null) {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, r.f7762a);
            try {
                return a(randomAccessFile, b(randomAccessFile));
            } finally {
                randomAccessFile.close();
            }
        }
        return invokeL.longValue;
    }
}
