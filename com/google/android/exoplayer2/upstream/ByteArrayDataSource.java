package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class ByteArrayDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesRemaining;
    public final byte[] data;
    public int readPosition;
    public Uri uri;

    public ByteArrayDataSource(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Assertions.checkNotNull(bArr);
        Assertions.checkArgument(bArr.length > 0);
        this.data = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.uri = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.uri : (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            this.uri = dataSpec.uri;
            long j = dataSpec.position;
            this.readPosition = (int) j;
            long j2 = dataSpec.length;
            if (j2 == -1) {
                j2 = this.data.length - j;
            }
            int i = (int) j2;
            this.bytesRemaining = i;
            if (i <= 0 || this.readPosition + i > this.data.length) {
                throw new IOException("Unsatisfiable range: [" + this.readPosition + StringUtil.ARRAY_ELEMENT_SEPARATOR + dataSpec.length + "], length: " + this.data.length);
            }
            return i;
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            int i3 = this.bytesRemaining;
            if (i3 == 0) {
                return -1;
            }
            int min = Math.min(i2, i3);
            System.arraycopy(this.data, this.readPosition, bArr, i, min);
            this.readPosition += min;
            this.bytesRemaining -= min;
            return min;
        }
        return invokeLII.intValue;
    }
}
