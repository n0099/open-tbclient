package org.apache.http.entity.mime;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.message.BasicHeader;
/* loaded from: classes8.dex */
public class MultipartEntity implements HttpEntity {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] MULTIPART_CHARS;
    public transient /* synthetic */ FieldHolder $fh;
    public final org.apache.http.Header contentType;
    public volatile boolean dirty;
    public long length;
    public final HttpMultipart multipart;

    @Override // org.apache.http.HttpEntity
    public org.apache.http.Header getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (org.apache.http.Header) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(611663512, "Lorg/apache/http/entity/mime/MultipartEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(611663512, "Lorg/apache/http/entity/mime/MultipartEntity;");
                return;
            }
        }
        MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException, UnsupportedOperationException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !isStreaming()) {
            return;
        }
        throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException, UnsupportedOperationException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new UnsupportedOperationException("Multipart form entity does not implement #getContent()");
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.dirty) {
                this.length = this.multipart.getTotalLength();
                this.dirty = false;
            }
            return this.length;
        }
        return invokeV.longValue;
    }

    @Override // org.apache.http.HttpEntity
    public org.apache.http.Header getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.contentType;
        }
        return (org.apache.http.Header) invokeV.objValue;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return !isRepeatable();
        }
        return invokeV.booleanValue;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return !isRepeatable();
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultipartEntity() {
        this(HttpMultipartMode.STRICT, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((HttpMultipartMode) objArr[0], (String) objArr[1], (Charset) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public String generateBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int nextInt = random.nextInt(11) + 30;
            for (int i = 0; i < nextInt; i++) {
                char[] cArr = MULTIPART_CHARS;
                sb.append(cArr[random.nextInt(cArr.length)]);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Iterator it = this.multipart.getBodyParts().iterator();
            while (it.hasNext()) {
                if (((FormBodyPart) it.next()).getBody().getContentLength() < 0) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultipartEntity(HttpMultipartMode httpMultipartMode) {
        this(httpMultipartMode, null, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpMultipartMode};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((HttpMultipartMode) objArr2[0], (String) objArr2[1], (Charset) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public MultipartEntity(HttpMultipartMode httpMultipartMode, String str, Charset charset) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {httpMultipartMode, str, charset};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        str = str == null ? generateBoundary() : str;
        this.multipart = new HttpMultipart("form-data", charset, str, httpMultipartMode == null ? HttpMultipartMode.STRICT : httpMultipartMode);
        this.contentType = new BasicHeader("Content-Type", generateContentType(str, charset));
        this.dirty = true;
    }

    public void addPart(String str, ContentBody contentBody) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, contentBody) == null) {
            addPart(new FormBodyPart(str, contentBody));
        }
    }

    public void addPart(FormBodyPart formBodyPart) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, formBodyPart) == null) {
            this.multipart.addBodyPart(formBodyPart);
            this.dirty = true;
        }
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, outputStream) == null) {
            this.multipart.writeTo(outputStream);
        }
    }

    public String generateContentType(String str, Charset charset) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, charset)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("multipart/form-data; boundary=");
            sb.append(str);
            if (charset != null) {
                sb.append("; charset=");
                sb.append(charset.name());
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }
}
