package com.repackage;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b80 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if ((a & 1) != 0) {
                str = "banner,";
            } else {
                str = "";
            }
            if ((a & 2) != 0) {
                str = str + "follow,";
            }
            if ((a & 4) != 0) {
                str = str + "tab,";
            }
            if ((a & 8) != 0) {
                str = str + "feed,";
            }
            return TextUtils.isEmpty(str) ? "" : str.substring(0, str.length() - 1);
        }
        return (String) invokeV.objValue;
    }

    public static void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            a = i;
        }
    }
}
