package okhttp3.internal.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
/* loaded from: classes3.dex */
public final class RealResponseBody extends ResponseBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long contentLength;
    @Nullable
    public final String contentTypeString;
    public final BufferedSource source;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), bufferedSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.contentLength : invokeV.longValue;
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String str = this.contentTypeString;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }
        return (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.source : (BufferedSource) invokeV.objValue;
    }
}
