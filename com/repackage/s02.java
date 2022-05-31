package com.repackage;

import android.net.Uri;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.input.InputType;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes7.dex */
public class s02 implements v02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Set<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755374436, "Lcom/repackage/s02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755374436, "Lcom/repackage/s02;");
                return;
            }
        }
        a = rf1.a;
        HashSet hashSet = new HashSet();
        b = hashSet;
        hashSet.add("https");
        b.add("http");
        b.add(LoginConstants.SMS_LOGIN);
        b.add(InputType.TEL);
    }

    public s02() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.repackage.v02
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
        }
    }

    @Override // com.repackage.v02
    public boolean b(String str) {
        InterceptResult invokeL;
        Uri parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || (parse = Uri.parse(str)) == null) {
                return true;
            }
            boolean contains = b.contains(parse.getScheme());
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append(contains ? "legal schemes : " : "illegal schemes : ");
                sb.append(parse.getScheme());
                Log.d("WebViewWidgetListener", sb.toString());
            }
            return !contains;
        }
        return invokeL.booleanValue;
    }

    @Override // com.repackage.v02
    public void c(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, str, str2) == null) {
        }
    }

    @Override // com.repackage.v02
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    @Override // com.repackage.v02
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // com.repackage.v02
    public void goBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
        }
    }
}
