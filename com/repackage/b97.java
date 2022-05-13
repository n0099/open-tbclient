package com.repackage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) ? iu4.k().m(b(str), 0L) : invokeL.longValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "im_mark_top_index_" + TbadkCoreApplication.getCurrentAccount() + "@" + str;
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65538, null, str, z) == null) {
            String b = b(str);
            if (z) {
                iu4.k().x(b, System.currentTimeMillis());
            } else {
                iu4.k().D(b);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921691, str));
        }
    }
}
