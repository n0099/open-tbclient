package com.sdk.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sdk.a.g;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class h implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "com.sdk.a.h";
    public static final Boolean b;
    public static final long serialVersionUID = -8869881146515387822L;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public String d;
    public String e;
    public TreeMap f;
    public ArrayList g;
    public HashMap h;
    public int i;
    public com.sdk.e.b j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1593316080, "Lcom/sdk/a/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1593316080, "Lcom/sdk/a/h;");
                return;
            }
        }
        b = Boolean.valueOf(com.sdk.f.g.b);
    }

    public String a(TreeMap treeMap) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, treeMap)) == null) {
            if (treeMap != null) {
                try {
                    sb = new StringBuilder();
                    for (Map.Entry entry : treeMap.entrySet()) {
                        String str = (String) entry.getKey();
                        Object value = entry.getValue();
                        if (value != null && com.sdk.n.a.b(str).booleanValue()) {
                            String encode = URLEncoder.encode(value.toString(), "UTF-8");
                            if (com.sdk.f.g.e) {
                                if (!"sign".equals(str) && !"unikey".equals(str)) {
                                    sb.append(str);
                                    sb.append("=");
                                    encode = com.sdk.q.d.b(encode);
                                    sb.append(encode);
                                    sb.append("&");
                                }
                                sb.append(str);
                            } else {
                                sb.append(str);
                            }
                            sb.append("=");
                            sb.append(encode);
                            sb.append("&");
                        }
                    }
                    sb.deleteCharAt(sb.length() - 1);
                } catch (Exception e) {
                    com.sdk.n.a.a(a, e.getMessage(), b);
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
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && com.sdk.n.a.b(str).booleanValue()) {
            this.c = str;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.d = str;
        }
    }

    public h() {
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
        this.c = g.a.a.l;
        this.i = 0;
    }
}
