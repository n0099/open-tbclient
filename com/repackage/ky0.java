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
public class ky0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(ny0 ny0Var) {
        InterceptResult invokeL;
        fy0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, ny0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (fy0[] fy0VarArr : ny0Var.e()) {
                String[] strArr = new String[fy0VarArr.length];
                for (int i = 0; i < fy0VarArr.length; i++) {
                    strArr[i] = fy0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + ny0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + ny0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(ny0 ny0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ny0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + ny0Var.g() + " (" + f(ny0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, fy0Var)) == null) {
            int i = fy0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + fy0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(fy0... fy0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, fy0VarArr)) == null) ? e(fy0VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(fy0[] fy0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fy0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = fy0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                fy0 fy0Var = fy0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(fy0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(fy0[] fy0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fy0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = fy0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                fy0 fy0Var = fy0VarArr[i];
                sb.append(str);
                sb.append(fy0Var.b);
                sb.append(getType(fy0Var));
                sb.append(c(fy0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(fy0 fy0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fy0Var)) == null) {
            int i = fy0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + fy0Var.a);
        }
        return (String) invokeL.objValue;
    }
}
