package com.ta.utdid2.b.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import kotlin.text.Typography;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes8.dex */
public class a implements XmlSerializer {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "xmlpull.org/v1/doc/features.html#indent-output";

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f16a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public OutputStream f17a;

    /* renamed from: a  reason: collision with other field name */
    public Writer f18a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f19a;

    /* renamed from: a  reason: collision with other field name */
    public CharsetEncoder f20a;

    /* renamed from: a  reason: collision with other field name */
    public final char[] f21a;
    public boolean e;
    public int mPos;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(669989098, "Lcom/ta/utdid2/b/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(669989098, "Lcom/ta/utdid2/b/a/a;");
                return;
            }
        }
        f16a = new String[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f21a = new char[8192];
        this.f19a = ByteBuffer.allocate(8192);
    }

    private void a() throws IOException {
        int position;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && (position = this.f19a.position()) > 0) {
            this.f19a.flip();
            this.f17a.write(this.f19a.array(), 0, position);
            this.f19a.clear();
        }
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return "http://" + a;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            flush();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public int getDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getNamespace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new UnsupportedOperationException();
        }
        return (String) invokeV.objValue;
    }

    private void a(String str) throws IOException {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            int length = str.length();
            String[] strArr = f16a;
            char length2 = (char) strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                    if (i2 < i) {
                        a(str, i2, i - i2);
                    }
                    i2 = i + 1;
                    append(str2);
                }
                i++;
            }
            if (i2 < i) {
                a(str, i2, i - i2);
            }
        }
    }

    private void a(String str, int i, int i2) throws IOException {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i, i2) == null) {
            if (i2 > 8192) {
                int i4 = i2 + i;
                while (i < i4) {
                    int i5 = i + 8192;
                    if (i5 < i4) {
                        i3 = 8192;
                    } else {
                        i3 = i4 - i;
                    }
                    a(str, i, i3);
                    i = i5;
                }
                return;
            }
            int i6 = this.mPos;
            if (i6 + i2 > 8192) {
                flush();
                i6 = this.mPos;
            }
            str.getChars(i, i + i2, this.f21a, i6);
            this.mPos = i6 + i2;
        }
    }

    private void append(char[] cArr, int i, int i2) throws IOException {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, this, cArr, i, i2) == null) {
            if (i2 > 8192) {
                int i4 = i2 + i;
                while (i < i4) {
                    int i5 = i + 8192;
                    if (i5 < i4) {
                        i3 = 8192;
                    } else {
                        i3 = i4 - i;
                    }
                    append(cArr, i, i3);
                    i = i5;
                }
                return;
            }
            int i6 = this.mPos;
            if (i6 + i2 > 8192) {
                flush();
                i6 = this.mPos;
            }
            System.arraycopy(cArr, i, this.f21a, i6, i2);
            this.mPos = i6 + i2;
        }
    }

    private void a(char[] cArr, int i, int i2) throws IOException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65541, this, cArr, i, i2) == null) {
            String[] strArr = f16a;
            char length = (char) strArr.length;
            int i3 = i2 + i;
            int i4 = i;
            while (i < i3) {
                char c = cArr[i];
                if (c < length && (str = strArr[c]) != null) {
                    if (i4 < i) {
                        append(cArr, i4, i - i4);
                    }
                    i4 = i + 1;
                    append(str);
                }
                i++;
            }
            if (i4 < i) {
                append(cArr, i4, i - i4);
            }
        }
    }

    private void append(char c) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Character.valueOf(c)}) == null) {
            int i = this.mPos;
            if (i >= 8191) {
                flush();
                i = this.mPos;
            }
            this.f21a[i] = c;
            this.mPos = i + 1;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public boolean getFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public Object getProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            throw new UnsupportedOperationException();
        }
        return invokeL.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, writer) == null) {
            this.f18a = writer;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            if (this.e) {
                append(">");
                this.e = false;
            }
            a(str);
            return this;
        }
        return (XmlSerializer) invokeL.objValue;
    }

    private void append(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            a(str, 0, str.length());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, str2, str3)) == null) {
            append(WebvttCueParser.CHAR_SPACE);
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            append("=\"");
            a(str3);
            append(Typography.quote);
            return this;
        }
        return (XmlSerializer) invokeLLL.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) throws IOException, IllegalArgumentException, IllegalStateException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048600, this, cArr, i, i2)) == null) {
            if (this.e) {
                append(">");
                this.e = false;
            }
            a(cArr, i, i2);
            return this;
        }
        return (XmlSerializer) invokeLII.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            if (this.e) {
                append(" />\n");
            } else {
                append("</");
                if (str != null) {
                    append(str);
                    append(':');
                }
                append(str2);
                append(">\n");
            }
            this.e = false;
            return this;
        }
        return (XmlSerializer) invokeLL.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, outputStream, str) == null) {
            if (outputStream != null) {
                try {
                    this.f20a = Charset.forName(str).newEncoder();
                    this.f17a = outputStream;
                    return;
                } catch (IllegalCharsetNameException e) {
                    throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e));
                } catch (UnsupportedCharsetException e2) {
                    throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e2));
                }
            }
            throw new IllegalArgumentException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, str, bool) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version='1.0' encoding='utf-8' standalone='");
            if (bool.booleanValue()) {
                str2 = "yes";
            } else {
                str2 = "no";
            }
            sb.append(str2);
            sb.append("' ?>\n");
            append(sb.toString());
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void flush() throws IOException {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (i = this.mPos) > 0) {
            if (this.f17a != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f21a, 0, i);
                CoderResult encode = this.f20a.encode(wrap, this.f19a, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        a();
                        encode = this.f20a.encode(wrap, this.f19a, true);
                    } else {
                        a();
                        this.f17a.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f18a.write(this.f21a, 0, i);
            this.f18a.flush();
            this.mPos = 0;
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public String getPrefix(String str, boolean z) throws IllegalArgumentException {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, str, z)) == null) {
            throw new UnsupportedOperationException();
        }
        return (String) invokeLZ.objValue;
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setFeature(String str, boolean z) throws IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048592, this, str, z) != null) || str.equals(d())) {
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, obj) == null) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // org.xmlpull.v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048598, this, str, str2)) == null) {
            if (this.e) {
                append(">\n");
            }
            append('<');
            if (str != null) {
                append(str);
                append(':');
            }
            append(str2);
            this.e = true;
            return this;
        }
        return (XmlSerializer) invokeLL.objValue;
    }
}
