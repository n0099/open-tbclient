package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.net.URLDecoder;
/* loaded from: classes5.dex */
public final class DataSchemeDataSource implements DataSource {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_DATA = "data";
    public transient /* synthetic */ FieldHolder $fh;
    public int bytesRead;
    public byte[] data;
    public DataSpec dataSpec;

    public DataSchemeDataSource() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.dataSpec = null;
            this.data = null;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            DataSpec dataSpec = this.dataSpec;
            if (dataSpec != null) {
                return dataSpec.uri;
            }
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dataSpec)) == null) {
            this.dataSpec = dataSpec;
            Uri uri = dataSpec.uri;
            String scheme = uri.getScheme();
            if ("data".equals(scheme)) {
                String[] split = uri.getSchemeSpecificPart().split(",");
                if (split.length <= 2) {
                    String str = split[1];
                    if (split[0].contains(DataUrlLoader.BASE64_TAG)) {
                        try {
                            this.data = Base64.decode(str, 0);
                        } catch (IllegalArgumentException e) {
                            throw new ParserException("Error while parsing Base64 encoded string: " + str, e);
                        }
                    } else {
                        this.data = URLDecoder.decode(str, "US-ASCII").getBytes();
                    }
                    return this.data.length;
                }
                throw new ParserException("Unexpected URI format: " + uri);
            }
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        return invokeL.longValue;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, bArr, i, i2)) == null) {
            if (i2 == 0) {
                return 0;
            }
            int length = this.data.length - this.bytesRead;
            if (length == 0) {
                return -1;
            }
            int min = Math.min(i2, length);
            System.arraycopy(this.data, this.bytesRead, bArr, i, min);
            this.bytesRead += min;
            return min;
        }
        return invokeLII.intValue;
    }
}
