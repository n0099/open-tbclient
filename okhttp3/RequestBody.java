package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
/* loaded from: classes4.dex */
public abstract class RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestBody() {
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

    public static RequestBody create(@Nullable MediaType mediaType, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, mediaType, str)) == null) {
            Charset charset = Util.UTF_8;
            if (mediaType != null && (charset = mediaType.charset()) == null) {
                charset = Util.UTF_8;
                mediaType = MediaType.parse(mediaType + "; charset=utf-8");
            }
            return create(mediaType, str.getBytes(charset));
        }
        return (RequestBody) invokeLL.objValue;
    }

    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return -1L;
        }
        return invokeV.longValue;
    }

    @Nullable
    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(@Nullable MediaType mediaType, ByteString byteString) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, mediaType, byteString)) == null) ? new RequestBody(mediaType, byteString) { // from class: okhttp3.RequestBody.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ByteString val$content;
            public final /* synthetic */ MediaType val$contentType;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mediaType, byteString};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.val$contentType = mediaType;
                this.val$content = byteString;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$content.size() : invokeV.longValue;
            }

            @Override // okhttp3.RequestBody
            @Nullable
            public MediaType contentType() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$contentType : (MediaType) invokeV.objValue;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                    bufferedSink.write(this.val$content);
                }
            }
        } : (RequestBody) invokeLL.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mediaType, bArr)) == null) ? create(mediaType, bArr, 0, bArr.length) : (RequestBody) invokeLL.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, byte[] bArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65541, null, mediaType, bArr, i2, i3)) == null) {
            if (bArr != null) {
                Util.checkOffsetAndCount(bArr.length, i2, i3);
                return new RequestBody(mediaType, i3, bArr, i2) { // from class: okhttp3.RequestBody.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ int val$byteCount;
                    public final /* synthetic */ byte[] val$content;
                    public final /* synthetic */ MediaType val$contentType;
                    public final /* synthetic */ int val$offset;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, Integer.valueOf(i3), bArr, Integer.valueOf(i2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$contentType = mediaType;
                        this.val$byteCount = i3;
                        this.val$content = bArr;
                        this.val$offset = i2;
                    }

                    @Override // okhttp3.RequestBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$byteCount : invokeV.longValue;
                    }

                    @Override // okhttp3.RequestBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$contentType : (MediaType) invokeV.objValue;
                    }

                    @Override // okhttp3.RequestBody
                    public void writeTo(BufferedSink bufferedSink) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                            bufferedSink.write(this.val$content, this.val$offset, this.val$byteCount);
                        }
                    }
                };
            }
            throw new NullPointerException("content == null");
        }
        return (RequestBody) invokeLLII.objValue;
    }

    public static RequestBody create(@Nullable MediaType mediaType, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, mediaType, file)) == null) {
            if (file != null) {
                return new RequestBody(mediaType, file) { // from class: okhttp3.RequestBody.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ MediaType val$contentType;
                    public final /* synthetic */ File val$file;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {mediaType, file};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$contentType = mediaType;
                        this.val$file = file;
                    }

                    @Override // okhttp3.RequestBody
                    public long contentLength() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? this.val$file.length() : invokeV.longValue;
                    }

                    @Override // okhttp3.RequestBody
                    @Nullable
                    public MediaType contentType() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.val$contentType : (MediaType) invokeV.objValue;
                    }

                    @Override // okhttp3.RequestBody
                    public void writeTo(BufferedSink bufferedSink) throws IOException {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                            Source source = null;
                            try {
                                source = Okio.source(this.val$file);
                                bufferedSink.writeAll(source);
                            } finally {
                                Util.closeQuietly(source);
                            }
                        }
                    }
                };
            }
            throw new NullPointerException("content == null");
        }
        return (RequestBody) invokeLL.objValue;
    }
}
