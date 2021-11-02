package okhttp3.internal.cache2;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.nio.channels.FileChannel;
import okio.Buffer;
/* loaded from: classes3.dex */
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

    public void read(long j, Buffer buffer, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), buffer, Long.valueOf(j2)}) == null) {
            if (j2 < 0) {
                throw new IndexOutOfBoundsException();
            }
            while (j2 > 0) {
                long transferTo = this.fileChannel.transferTo(j, j2, buffer);
                j += transferTo;
                j2 -= transferTo;
            }
        }
    }

    public void write(long j, Buffer buffer, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), buffer, Long.valueOf(j2)}) == null) {
            if (j2 < 0 || j2 > buffer.size()) {
                throw new IndexOutOfBoundsException();
            }
            long j3 = j;
            long j4 = j2;
            while (j4 > 0) {
                long transferFrom = this.fileChannel.transferFrom(buffer, j3, j4);
                j3 += transferFrom;
                j4 -= transferFrom;
            }
        }
    }
}
