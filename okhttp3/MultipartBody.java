package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.android.internal.http.multipart.FilePart;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes4.dex */
public final class MultipartBody extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public static final MediaType ALTERNATIVE;
    public static final byte[] COLONSPACE;
    public static final byte[] CRLF;
    public static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    public transient /* synthetic */ FieldHolder $fh;
    public final ByteString boundary;
    public long contentLength;
    public final MediaType contentType;
    public final MediaType originalType;
    public final List<Part> parts;

    /* loaded from: classes4.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteString boundary;
        public final List<Part> parts;
        public MediaType type;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder() {
            this(UUID.randomUUID().toString());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public Builder addFormDataPart(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? addPart(Part.createFormData(str, str2)) : (Builder) invokeLL.objValue;
        }

        public Builder addPart(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, requestBody)) == null) ? addPart(Part.create(requestBody)) : (Builder) invokeL.objValue;
        }

        public MultipartBody build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (!this.parts.isEmpty()) {
                    return new MultipartBody(this.boundary, this.type, this.parts);
                }
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return (MultipartBody) invokeV.objValue;
        }

        public Builder setType(MediaType mediaType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, mediaType)) == null) {
                if (mediaType != null) {
                    if (mediaType.type().equals("multipart")) {
                        this.type = mediaType;
                        return this;
                    }
                    throw new IllegalArgumentException("multipart != " + mediaType);
                }
                throw new NullPointerException("type == null");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
            this.boundary = ByteString.encodeUtf8(str);
        }

        public Builder addFormDataPart(String str, @Nullable String str2, RequestBody requestBody) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, requestBody)) == null) ? addPart(Part.createFormData(str, str2, requestBody)) : (Builder) invokeLLL.objValue;
        }

        public Builder addPart(@Nullable Headers headers, RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, headers, requestBody)) == null) ? addPart(Part.create(headers, requestBody)) : (Builder) invokeLL.objValue;
        }

        public Builder addPart(Part part) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, part)) == null) {
                if (part != null) {
                    this.parts.add(part);
                    return this;
                }
                throw new NullPointerException("part == null");
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class Part {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final RequestBody body;
        @Nullable
        public final Headers headers;

        public Part(@Nullable Headers headers, RequestBody requestBody) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {headers, requestBody};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.headers = headers;
            this.body = requestBody;
        }

        public static Part create(RequestBody requestBody) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, requestBody)) == null) ? create(null, requestBody) : (Part) invokeL.objValue;
        }

        public static Part createFormData(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) ? createFormData(str, null, RequestBody.create((MediaType) null, str2)) : (Part) invokeLL.objValue;
        }

        public RequestBody body() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.body : (RequestBody) invokeV.objValue;
        }

        @Nullable
        public Headers headers() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.headers : (Headers) invokeV.objValue;
        }

        public static Part create(@Nullable Headers headers, RequestBody requestBody) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, headers, requestBody)) == null) {
                if (requestBody != null) {
                    if (headers != null && headers.get("Content-Type") != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Type");
                    }
                    if (headers != null && headers.get("Content-Length") != null) {
                        throw new IllegalArgumentException("Unexpected header: Content-Length");
                    }
                    return new Part(headers, requestBody);
                }
                throw new NullPointerException("body == null");
            }
            return (Part) invokeLL.objValue;
        }

        public static Part createFormData(String str, @Nullable String str2, RequestBody requestBody) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, requestBody)) == null) {
                if (str != null) {
                    StringBuilder sb = new StringBuilder("form-data; name=");
                    MultipartBody.appendQuotedString(sb, str);
                    if (str2 != null) {
                        sb.append(FilePart.FILE_NAME);
                        MultipartBody.appendQuotedString(sb, str2);
                    }
                    return create(Headers.of("Content-Disposition", sb.toString()), requestBody);
                }
                throw new NullPointerException("name == null");
            }
            return (Part) invokeLLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(573940409, "Lokhttp3/MultipartBody;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(573940409, "Lokhttp3/MultipartBody;");
                return;
            }
        }
        MIXED = MediaType.get("multipart/mixed");
        ALTERNATIVE = MediaType.get("multipart/alternative");
        DIGEST = MediaType.get("multipart/digest");
        PARALLEL = MediaType.get("multipart/parallel");
        FORM = MediaType.get(IMAudioTransRequest.CONTENT_TYPE);
        COLONSPACE = new byte[]{58, 32};
        CRLF = new byte[]{13, 10};
        DASHDASH = new byte[]{UtilsBlink.VER_TYPE_SEPARATOR, UtilsBlink.VER_TYPE_SEPARATOR};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {byteString, mediaType, list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.contentLength = -1L;
        this.boundary = byteString;
        this.originalType = mediaType;
        this.contentType = MediaType.get(mediaType + "; boundary=" + byteString.utf8());
        this.parts = Util.immutableList(list);
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sb, str)) == null) {
            sb.append('\"');
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt != '\"') {
                    sb.append(charAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append('\"');
            return sb;
        }
        return (StringBuilder) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: okio.Buffer */
    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: okio.Buffer */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: okio.Buffer */
    /* JADX WARN: Multi-variable type inference failed */
    private long writeOrCountBytes(@Nullable BufferedSink bufferedSink, boolean z) throws IOException {
        InterceptResult invokeLZ;
        Buffer buffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, this, bufferedSink, z)) == null) {
            if (z) {
                bufferedSink = new Buffer();
                buffer = bufferedSink;
            } else {
                buffer = 0;
            }
            int size = this.parts.size();
            long j2 = 0;
            for (int i2 = 0; i2 < size; i2++) {
                Part part = this.parts.get(i2);
                Headers headers = part.headers;
                RequestBody requestBody = part.body;
                bufferedSink.write(DASHDASH);
                bufferedSink.write(this.boundary);
                bufferedSink.write(CRLF);
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        bufferedSink.writeUtf8(headers.name(i3)).write(COLONSPACE).writeUtf8(headers.value(i3)).write(CRLF);
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    bufferedSink.writeUtf8(com.android.internal.http.multipart.Part.CONTENT_TYPE).writeUtf8(contentType.toString()).write(CRLF);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(contentLength).write(CRLF);
                } else if (z) {
                    buffer.clear();
                    return -1L;
                }
                bufferedSink.write(CRLF);
                if (z) {
                    j2 += contentLength;
                } else {
                    requestBody.writeTo(bufferedSink);
                }
                bufferedSink.write(CRLF);
            }
            bufferedSink.write(DASHDASH);
            bufferedSink.write(this.boundary);
            bufferedSink.write(DASHDASH);
            bufferedSink.write(CRLF);
            if (z) {
                long size3 = j2 + buffer.size();
                buffer.clear();
                return size3;
            }
            return j2;
        }
        return invokeLZ.longValue;
    }

    public String boundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.boundary.utf8() : (String) invokeV.objValue;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j2 = this.contentLength;
            if (j2 != -1) {
                return j2;
            }
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return invokeV.longValue;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.contentType : (MediaType) invokeV.objValue;
    }

    public Part part(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? this.parts.get(i2) : (Part) invokeI.objValue;
    }

    public List<Part> parts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.parts : (List) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.parts.size() : invokeV.intValue;
    }

    public MediaType type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.originalType : (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bufferedSink) == null) {
            writeOrCountBytes(bufferedSink, false);
        }
    }
}
