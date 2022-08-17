package com.repackage;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ie7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, el4> a;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public HashMap<String, String> c;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
            Uri parse = Uri.parse(str);
            this.a = "tblego".equals(parse.getScheme());
            if (e()) {
                this.b = parse.getAuthority() + parse.getPath();
                this.c = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.c.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.b = "";
            this.c = new HashMap<>();
        }

        public static b a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new b(str) : (b) invokeL.objValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (String) invokeV.objValue;
        }

        public HashMap<String, String> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (HashMap) invokeV.objValue;
        }

        public String d(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                if (!TextUtils.isEmpty(str) && e()) {
                    for (String str2 : this.c.keySet()) {
                        if (str.equals(str2)) {
                            return this.c.get(str2);
                        }
                    }
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static ie7 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-302574889, "Lcom/repackage/ie7$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-302574889, "Lcom/repackage/ie7$c;");
                    return;
                }
            }
            a = new ie7(null);
        }
    }

    public /* synthetic */ ie7(a aVar) {
        this();
    }

    public static ie7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (ie7) invokeV.objValue;
    }

    public void b(bl4 bl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bl4Var) == null) {
            c(bl4Var.c(), bl4Var);
        }
    }

    public void c(String str, el4 el4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, el4Var) == null) {
            this.a.put(str, el4Var);
        }
    }

    public void d(Object obj, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, str) == null) || str == null) {
            return;
        }
        b a2 = b.a(str);
        el4 el4Var = this.a.get(a2.b());
        if (el4Var == null || !a2.e()) {
            return;
        }
        el4Var.b(obj, a2.c(), str);
    }

    public void e(Object obj, String str, HashMap<String, String> hashMap, c9 c9Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, obj, str, hashMap, c9Var) == null) || str == null) {
            return;
        }
        b a2 = b.a(str);
        el4 el4Var = this.a.get(a2.b());
        if (el4Var == null || !a2.e()) {
            return;
        }
        if (hashMap != null && !hashMap.isEmpty()) {
            a2.c().putAll(hashMap);
        }
        el4Var.a(obj, a2.c(), str, c9Var);
    }

    public ie7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
    }
}
