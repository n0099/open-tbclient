package com.repackage;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public class sx7 {
    public static /* synthetic */ Interceptable $ic;
    public static sx7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755305089, "Lcom/repackage/sx7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755305089, "Lcom/repackage/sx7;");
        }
    }

    public sx7() {
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

    public static sx7 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (sx7.class) {
                    if (a == null) {
                        a = new sx7();
                    }
                }
            }
            return a;
        }
        return (sx7) invokeV.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? str != null && str.contains("bookcover:") : invokeL.booleanValue;
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return b(pi.getUrlDecode(str2));
            }
            String str3 = paramPair.get("tbgametype");
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    public final boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? !TextUtils.isEmpty(str) && str.contains("xiaoying.tv") : invokeL.booleanValue;
    }

    public void e(TbPageContext tbPageContext, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, str) == null) || tbPageContext == null || TextUtils.isEmpty(str)) {
            return;
        }
        str.contains("is_native_app=1");
        if (b(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(tbPageContext.getPageActivity(), null, str, null));
        } else if (d(str)) {
            UrlManager.getInstance().dealOneLink((TbPageContext<?>) tbPageContext, new String[]{str}, true);
        } else {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
    }
}
