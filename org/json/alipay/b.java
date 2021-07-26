package org.json.alipay;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Object f73612a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map f73613b;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final Object clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : invokeV.objValue;
        }

        public final boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? obj == null || obj == this : invokeL.booleanValue;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? StringUtil.NULL_STRING : (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1024124562, "Lorg/json/alipay/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1024124562, "Lorg/json/alipay/b;");
                return;
            }
        }
        f73612a = new a((byte) 0);
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73613b = new HashMap();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(String str) {
        this(new c(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((c) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public b(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.f73613b = map == null ? new HashMap() : map;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c2 = cVar.c();
            if (c2 == 0) {
                throw cVar.a("A JSONObject text must end with '}'");
            }
            if (c2 == '}') {
                return;
            }
            cVar.a();
            String obj = cVar.d().toString();
            char c3 = cVar.c();
            if (c3 == '=') {
                if (cVar.b() != '>') {
                    cVar.a();
                }
            } else if (c3 != ':') {
                throw cVar.a("Expected a ':' after a key");
            }
            Object d2 = cVar.d();
            if (obj == null) {
                throw new JSONException("Null key.");
            }
            if (d2 != null) {
                b(d2);
                this.f73613b.put(obj, d2);
            } else {
                this.f73613b.remove(obj);
            }
            char c4 = cVar.c();
            if (c4 != ',' && c4 != ';') {
                if (c4 != '}') {
                    throw cVar.a("Expected a ',' or '}'");
                }
                return;
            } else if (cVar.c() == '}') {
                return;
            } else {
                cVar.a();
            }
        }
    }

    public static String a(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, obj)) == null) {
            if (obj == null || obj.equals(null)) {
                return StringUtil.NULL_STRING;
            }
            if (!(obj instanceof Number)) {
                return ((obj instanceof Boolean) || (obj instanceof b) || (obj instanceof org.json.alipay.a)) ? obj.toString() : obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new org.json.alipay.a((Collection) obj).toString() : obj.getClass().isArray() ? new org.json.alipay.a(obj).toString() : c(obj.toString());
            }
            Number number = (Number) obj;
            if (number != null) {
                b(number);
                String obj2 = number.toString();
                if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
                    return obj2;
                }
                while (obj2.endsWith("0")) {
                    obj2 = obj2.substring(0, obj2.length() - 1);
                }
                return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
            }
            throw new JSONException("Null pointer");
        }
        return (String) invokeL.objValue;
    }

    public static void b(Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, obj) == null) || obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d2 = (Double) obj;
            if (d2.isInfinite() || d2.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f2 = (Float) obj;
            if (f2.isInfinite() || f2.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0088, code lost:
        if (r4 == '<') goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return "\"\"";
            }
            int length = str.length();
            StringBuffer stringBuffer = new StringBuffer(length + 4);
            stringBuffer.append(Typography.quote);
            int i2 = 0;
            char c2 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt == '\f') {
                    str2 = "\\f";
                } else if (charAt != '\r') {
                    if (charAt != '\"') {
                        if (charAt != '/') {
                            if (charAt != '\\') {
                                switch (charAt) {
                                    case '\b':
                                        str2 = "\\b";
                                        break;
                                    case '\t':
                                        str2 = "\\t";
                                        break;
                                    case '\n':
                                        str2 = "\\n";
                                        break;
                                    default:
                                        if (charAt < ' ' || ((charAt >= 128 && charAt < 160) || (charAt >= 8192 && charAt < 8448))) {
                                            String str3 = "000" + Integer.toHexString(charAt);
                                            str2 = "\\u" + str3.substring(str3.length() - 4);
                                            break;
                                        }
                                        stringBuffer.append(charAt);
                                        i2++;
                                        c2 = charAt;
                                        break;
                                }
                            }
                        }
                    }
                    stringBuffer.append('\\');
                    stringBuffer.append(charAt);
                    i2++;
                    c2 = charAt;
                } else {
                    str2 = "\\r";
                }
                stringBuffer.append(str2);
                i2++;
                c2 = charAt;
            }
            stringBuffer.append(Typography.quote);
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public final Object a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            Object obj = str == null ? null : this.f73613b.get(str);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("JSONObject[" + c(str) + "] not found.");
        }
        return invokeL.objValue;
    }

    public final Iterator a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f73613b.keySet().iterator() : (Iterator) invokeV.objValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? this.f73613b.containsKey(str) : invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                Iterator a2 = a();
                StringBuffer stringBuffer = new StringBuffer(StringUtil.ARRAY_START);
                while (a2.hasNext()) {
                    if (stringBuffer.length() > 1) {
                        stringBuffer.append(',');
                    }
                    Object next = a2.next();
                    stringBuffer.append(c(next.toString()));
                    stringBuffer.append(':');
                    stringBuffer.append(a(this.f73613b.get(next)));
                }
                stringBuffer.append('}');
                return stringBuffer.toString();
            } catch (Exception unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }
}
