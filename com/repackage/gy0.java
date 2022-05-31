package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gy0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(jy0 jy0Var) {
        InterceptResult invokeL;
        by0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jy0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (by0[] by0VarArr : jy0Var.e()) {
                String[] strArr = new String[by0VarArr.length];
                for (int i = 0; i < by0VarArr.length; i++) {
                    strArr[i] = by0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + jy0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + jy0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(jy0 jy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jy0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + jy0Var.g() + " (" + f(jy0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(by0 by0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, by0Var)) == null) {
            int i = by0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + by0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(by0... by0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, by0VarArr)) == null) ? e(by0VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(by0[] by0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, by0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = by0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                by0 by0Var = by0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(by0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(by0[] by0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, by0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = by0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                by0 by0Var = by0VarArr[i];
                sb.append(str);
                sb.append(by0Var.b);
                sb.append(getType(by0Var));
                sb.append(c(by0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(by0 by0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, by0Var)) == null) {
            int i = by0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + by0Var.a);
        }
        return (String) invokeL.objValue;
    }
}
