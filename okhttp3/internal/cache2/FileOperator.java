package okhttp3.internal.cache2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;
/* loaded from: classes9.dex */
public final class FileOperator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fileChannel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.fileChannel = fileChannel;
    }

    public void read(long j2, Buffer buffer, long j3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), buffer, Long.valueOf(j3)}) == null) {
            if (j3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            while (j3 > 0) {
                long transferTo = this.fileChannel.transferTo(j2, j3, buffer);
                j2 += transferTo;
                j3 -= transferTo;
            }
        }
    }

    public void write(long j2, Buffer buffer, long j3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), buffer, Long.valueOf(j3)}) == null) {
            if (j3 < 0 || j3 > buffer.size()) {
                throw new IndexOutOfBoundsException();
            }
            long j4 = j2;
            long j5 = j3;
            while (j5 > 0) {
                long transferFrom = this.fileChannel.transferFrom(buffer, j4, j5);
                j4 += transferFrom;
                j5 -= transferFrom;
            }
        }
    }
}
