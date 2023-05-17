package com.sdk.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.f;
import java.io.File;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes9.dex */
public class g<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.a.g";
    public static final Boolean b;
    public static final long serialVersionUID = -8869881146515387822L;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public String e;
    public TreeMap<String, Object> f;
    public ArrayList<File> g;
    public HashMap<String, Object> h;
    public int i;
    public com.sdk.e.b<T> j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316111, "Lcom/sdk/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316111, "Lcom/sdk/a/g;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.f.a);
    }

    public String a(TreeMap<String, Object> treeMap) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, treeMap)) == null) {
            if (treeMap != null) {
                try {
                    sb = new StringBuilder();
                    for (Map.Entry<String, Object> entry : treeMap.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (value != null && com.sdk.o.a.b(key).booleanValue()) {
                            String encode = URLEncoder.encode(value.toString(), "UTF-8");
                            if (com.sdk.f.f.d) {
                                if (!"sign".equals(key) && !"unikey".equals(key)) {
                                    sb.append(key);
                                    sb.append("=");
                                    encode = com.sdk.r.d.b(encode);
                                }
                                sb.append(key);
                                sb.append("=");
                            } else {
                                sb.append(key);
                                sb.append("=");
                            }
                            sb.append(encode);
                            sb.append("&");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                } catch (Exception e) {
                    com.sdk.o.a.a(a, e.getMessage(), b);
                    throw new Exception("http请求参数出错");
                }
            } else {
                sb = null;
            }
            if (sb == null) {
                return null;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && com.sdk.o.a.b(str).booleanValue()) {
            this.c = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public g() {
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
        this.c = f.a.a.l;
        this.i = 0;
    }
}
