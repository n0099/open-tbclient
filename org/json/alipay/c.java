package org.json.alipay;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f73614a;

    /* renamed from: b  reason: collision with root package name */
    public Reader f73615b;

    /* renamed from: c  reason: collision with root package name */
    public char f73616c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73617d;

    public c(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {reader};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f73615b = reader.markSupported() ? reader : new BufferedReader(reader);
        this.f73617d = false;
        this.f73614a = 0;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((Reader) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private String a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) {
            if (i2 == 0) {
                return "";
            }
            char[] cArr = new char[i2];
            int i3 = 0;
            if (this.f73617d) {
                this.f73617d = false;
                cArr[0] = this.f73616c;
                i3 = 1;
            }
            while (i3 < i2) {
                try {
                    int read = this.f73615b.read(cArr, i3, i2 - i3);
                    if (read == -1) {
                        break;
                    }
                    i3 += read;
                } catch (IOException e2) {
                    throw new JSONException(e2);
                }
            }
            this.f73614a += i3;
            if (i3 >= i2) {
                this.f73616c = cArr[i2 - 1];
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.f73617d || (i2 = this.f73614a) <= 0) {
                throw new JSONException("Stepping back two steps is not supported");
            }
            this.f73614a = i2 - 1;
            this.f73617d = true;
        }
    }

    public final char b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f73617d) {
                this.f73617d = false;
                if (this.f73616c != 0) {
                    this.f73614a++;
                }
                return this.f73616c;
            }
            try {
                int read = this.f73615b.read();
                if (read <= 0) {
                    this.f73616c = (char) 0;
                    return (char) 0;
                }
                this.f73614a++;
                char c2 = (char) read;
                this.f73616c = c2;
                return c2;
            } catch (IOException e2) {
                throw new JSONException(e2);
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
        char b2;
        char b3;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048579, this)) != null) {
            return invokeV.charValue;
        }
        while (true) {
            char b4 = b();
            if (b4 == '/') {
                char b5 = b();
                if (b5 == '*') {
                    while (true) {
                        char b6 = b();
                        if (b6 == 0) {
                            throw a("Unclosed comment");
                        }
                        if (b6 == '*') {
                            if (b() != '/') {
                                a();
                            }
                        }
                    }
                } else if (b5 != '/') {
                    a();
                    return '/';
                } else {
                    do {
                        b2 = b();
                        if (b2 != '\n' && b2 != '\r') {
                        }
                    } while (b2 != 0);
                }
            } else if (b4 == '#') {
                do {
                    b3 = b();
                    if (b3 != '\n' && b3 != '\r') {
                    }
                } while (b3 != 0);
            } else if (b4 == 0 || b4 > ' ') {
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
        String a2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(1048580, this)) != null) {
            return invokeV.objValue;
        }
        char c2 = c();
        if (c2 != '\"') {
            if (c2 != '[') {
                if (c2 == '{') {
                    a();
                    return new b(this);
                } else if (c2 != '\'') {
                    if (c2 != '(') {
                        StringBuffer stringBuffer = new StringBuffer();
                        char c3 = c2;
                        while (c3 >= ' ' && ",:]}/\\\"[{;=#".indexOf(c3) < 0) {
                            stringBuffer.append(c3);
                            c3 = b();
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
                            return b.f73612a;
                        }
                        if ((c2 >= '0' && c2 <= '9') || c2 == '.' || c2 == '-' || c2 == '+') {
                            if (c2 == '0') {
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
            char b2 = b();
            if (b2 == 0 || b2 == '\n' || b2 == '\r') {
                break;
            }
            if (b2 == '\\') {
                b2 = b();
                if (b2 == 'b') {
                    stringBuffer2.append('\b');
                } else if (b2 == 'f') {
                    b2 = '\f';
                } else if (b2 == 'n') {
                    stringBuffer2.append('\n');
                } else if (b2 != 'r') {
                    if (b2 == 'x') {
                        a2 = a(2);
                    } else if (b2 == 't') {
                        b2 = '\t';
                    } else if (b2 == 'u') {
                        a2 = a(4);
                    }
                    b2 = (char) Integer.parseInt(a2, 16);
                } else {
                    stringBuffer2.append('\r');
                }
            } else if (b2 == c2) {
                return stringBuffer2.toString();
            }
            stringBuffer2.append(b2);
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return " at character " + this.f73614a;
        }
        return (String) invokeV.objValue;
    }
}
