package org.json.alipay;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public Reader b;
    public char c;
    public boolean d;

    public c(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.d = false;
        this.a = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(String str) {
        this(new StringReader(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((Reader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private String a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i)) == null) {
            if (i == 0) {
                return "";
            }
            char[] cArr = new char[i];
            int i2 = 0;
            if (this.d) {
                this.d = false;
                cArr[0] = this.c;
                i2 = 1;
            }
            while (i2 < i) {
                try {
                    int read = this.b.read(cArr, i2, i - i2);
                    if (read == -1) {
                        break;
                    }
                    i2 += read;
                } catch (IOException e) {
                    throw new JSONException(e);
                }
            }
            this.a += i2;
            if (i2 >= i) {
                this.c = cArr[i - 1];
                return new String(cArr);
            }
            throw a("Substring bounds error");
        }
        return (String) invokeI.objValue;
    }

    public final JSONException a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return new JSONException(str + toString());
        }
        return (JSONException) invokeL.objValue;
    }

    public final void a() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.d || (i = this.a) <= 0) {
                throw new JSONException("Stepping back two steps is not supported");
            }
            this.a = i - 1;
            this.d = true;
        }
    }

    public final char b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.d) {
                this.d = false;
                if (this.c != 0) {
                    this.a++;
                }
                return this.c;
            }
            try {
                int read = this.b.read();
                if (read <= 0) {
                    this.c = (char) 0;
                    return (char) 0;
                }
                this.a++;
                char c = (char) read;
                this.c = c;
                return c;
            } catch (IOException e) {
                throw new JSONException(e);
            }
        }
        return invokeV.charValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final char c() {
        char b;
        char b2;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.charValue;
        }
        while (true) {
            char b3 = b();
            if (b3 == '/') {
                char b4 = b();
                if (b4 == '*') {
                    while (true) {
                        char b5 = b();
                        if (b5 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (b5 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else if (b4 != '/') {
                    a();
                    return WebvttCueParser.CHAR_SLASH;
                } else {
                    do {
                        b = b();
                        if (b != '\n' && b != '\r') {
                        }
                    } while (b != 0);
                }
            } else if (b3 == '#') {
                do {
                    b2 = b();
                    if (b2 != '\n' && b2 != '\r') {
                    }
                } while (b2 != 0);
            } else if (b3 == 0 || b3 > ' ') {
                break;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x014a, code lost:
        throw a("Unterminated string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d() {
        InterceptResult invokeV;
        String a;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.objValue;
        }
        char c = c();
        if (c != '\"') {
            if (c != '[') {
                if (c == '{') {
                    a();
                    return new b(this);
                } else if (c != '\'') {
                    if (c != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c2 = c;
                        while (c2 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c2) < 0) {
                            stringBuffer.append(c2);
                            c2 = b();
                        }
                        a();
                        String trim = stringBuffer.toString().trim();
                        if (trim.equals("")) {
                            throw a("Missing value");
                        }
                        if (trim.equalsIgnoreCase("true")) {
                            return Boolean.TRUE;
                        }
                        if (trim.equalsIgnoreCase("false")) {
                            return Boolean.FALSE;
                        }
                        if (trim.equalsIgnoreCase(StringUtil.NULL_STRING)) {
                            return b.a;
                        }
                        if ((c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+') {
                            if (c == '0') {
                                try {
                                    return (trim.length() <= 2 || !(trim.charAt(1) == 'x' || trim.charAt(1) == 'X')) ? new Integer(Integer.parseInt(trim, 8)) : new Integer(Integer.parseInt(trim.substring(2), 16));
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                try {
                                    try {
                                        return new Integer(trim);
                                    } catch (Exception unused2) {
                                        return new Long(trim);
                                    }
                                } catch (Exception unused3) {
                                    return trim;
                                }
                            } catch (Exception unused4) {
                                return new Double(trim);
                            }
                        }
                        return trim;
                    }
                }
            }
            a();
            return new a(this);
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        while (true) {
            char b = b();
            if (b == 0 || b == '\n' || b == '\r') {
                break;
            }
            if (b == '\\') {
                b = b();
                if (b == 'b') {
                    stringBuffer2.append('\b');
                } else if (b == 'f') {
                    b = '\f';
                } else if (b == 'n') {
                    stringBuffer2.append('\n');
                } else if (b != 'r') {
                    if (b == 'x') {
                        a = a(2);
                    } else if (b == 't') {
                        b = '\t';
                    } else if (b == 'u') {
                        a = a(4);
                    }
                    b = (char) Integer.parseInt(a, 16);
                } else {
                    stringBuffer2.append('\r');
                }
            } else if (b == c) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(b);
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return " at character " + this.a;
        }
        return (String) invokeV.objValue;
    }
}
