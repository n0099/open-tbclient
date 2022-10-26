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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;
/* loaded from: classes8.dex */
public class HttpMultipart {
    public static /* synthetic */ Interceptable $ic;
    public static final ByteArrayBuffer CR_LF;
    public static final ByteArrayBuffer FIELD_SEP;
    public static final ByteArrayBuffer TWO_DASHES;
    public transient /* synthetic */ FieldHolder $fh;
    public final String boundary;
    public final Charset charset;
    public final HttpMultipartMode mode;
    public final List parts;
    public final String subType;

    /* renamed from: org.apache.http.entity.mime.HttpMultipart$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-971737610, "Lorg/apache/http/entity/mime/HttpMultipart$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-971737610, "Lorg/apache/http/entity/mime/HttpMultipart$1;");
                    return;
                }
            }
            int[] iArr = new int[HttpMultipartMode.values().length];
            $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode = iArr;
            try {
                iArr[HttpMultipartMode.STRICT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[HttpMultipartMode.BROWSER_COMPATIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1614417181, "Lorg/apache/http/entity/mime/HttpMultipart;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1614417181, "Lorg/apache/http/entity/mime/HttpMultipart;");
                return;
            }
        }
        FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
        CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
        TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpMultipart(String str, String str2) {
        this(str, null, str2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Charset) objArr2[1], (String) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpMultipart(String str, Charset charset, String str2) {
        this(str, charset, str2, HttpMultipartMode.STRICT);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, charset, str2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (Charset) objArr2[1], (String) objArr2[2], (HttpMultipartMode) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public HttpMultipart(String str, Charset charset, String str2, HttpMultipartMode httpMultipartMode) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, charset, str2, httpMultipartMode};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (str != null) {
            if (str2 != null) {
                this.subType = str;
                this.charset = charset == null ? MIME.DEFAULT_CHARSET : charset;
                this.boundary = str2;
                this.parts = new ArrayList();
                this.mode = httpMultipartMode;
                return;
            }
            throw new IllegalArgumentException("Multipart boundary may not be null");
        }
        throw new IllegalArgumentException("Multipart subtype may not be null");
    }

    private void doWriteTo(HttpMultipartMode httpMultipartMode, OutputStream outputStream, boolean z) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, httpMultipartMode, outputStream, z) == null) {
            ByteArrayBuffer encode = encode(this.charset, getBoundary());
            for (FormBodyPart formBodyPart : this.parts) {
                writeBytes(TWO_DASHES, outputStream);
                writeBytes(encode, outputStream);
                writeBytes(CR_LF, outputStream);
                Header header = formBodyPart.getHeader();
                int i = AnonymousClass1.$SwitchMap$org$apache$http$entity$mime$HttpMultipartMode[httpMultipartMode.ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        writeField(formBodyPart.getHeader().getField("Content-Disposition"), this.charset, outputStream);
                        if (formBodyPart.getBody().getFilename() != null) {
                            writeField(formBodyPart.getHeader().getField("Content-Type"), this.charset, outputStream);
                        }
                    }
                } else {
                    Iterator it = header.iterator();
                    while (it.hasNext()) {
                        writeField((MinimalField) it.next(), outputStream);
                    }
                }
                writeBytes(CR_LF, outputStream);
                if (z) {
                    formBodyPart.getBody().writeTo(outputStream);
                }
                writeBytes(CR_LF, outputStream);
            }
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(encode, outputStream);
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(CR_LF, outputStream);
        }
    }

    public static ByteArrayBuffer encode(Charset charset, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, charset, str)) == null) {
            ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
            byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
            return byteArrayBuffer;
        }
        return (ByteArrayBuffer) invokeLL.objValue;
    }

    public static void writeBytes(String str, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, outputStream) == null) {
            writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
        }
    }

    public static void writeField(MinimalField minimalField, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, minimalField, outputStream) == null) {
            writeBytes(minimalField.getName(), outputStream);
            writeBytes(FIELD_SEP, outputStream);
            writeBytes(minimalField.getBody(), outputStream);
            writeBytes(CR_LF, outputStream);
        }
    }

    public static void writeBytes(String str, Charset charset, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, charset, outputStream) == null) {
            writeBytes(encode(charset, str), outputStream);
        }
    }

    public static void writeField(MinimalField minimalField, Charset charset, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, minimalField, charset, outputStream) == null) {
            writeBytes(minimalField.getName(), charset, outputStream);
            writeBytes(FIELD_SEP, outputStream);
            writeBytes(minimalField.getBody(), charset, outputStream);
            writeBytes(CR_LF, outputStream);
        }
    }

    public static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, byteArrayBuffer, outputStream) == null) {
            outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
        }
    }

    public void addBodyPart(FormBodyPart formBodyPart) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, formBodyPart) != null) || formBodyPart == null) {
            return;
        }
        this.parts.add(formBodyPart);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, outputStream) == null) {
            doWriteTo(this.mode, outputStream, true);
        }
    }

    public List getBodyParts() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.parts;
        }
        return (List) invokeV.objValue;
    }

    public String getBoundary() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.boundary;
        }
        return (String) invokeV.objValue;
    }

    public Charset getCharset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.charset;
        }
        return (Charset) invokeV.objValue;
    }

    public HttpMultipartMode getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mode;
        }
        return (HttpMultipartMode) invokeV.objValue;
    }

    public String getSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.subType;
        }
        return (String) invokeV.objValue;
    }

    public long getTotalLength() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            long j = 0;
            for (FormBodyPart formBodyPart : this.parts) {
                long contentLength = formBodyPart.getBody().getContentLength();
                if (contentLength < 0) {
                    return -1L;
                }
                j += contentLength;
            }
            try {
                doWriteTo(this.mode, new ByteArrayOutputStream(), false);
                return j + byteArrayOutputStream.toByteArray().length;
            } catch (IOException unused) {
                return -1L;
            }
        }
        return invokeV.longValue;
    }
}
