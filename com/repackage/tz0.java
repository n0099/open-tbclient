package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class tz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<String> a(wz0 wz0Var) {
        InterceptResult invokeL;
        oz0[][] e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, wz0Var)) == null) {
            ArrayList<String> arrayList = new ArrayList<>(2);
            for (oz0[] oz0VarArr : wz0Var.e()) {
                String[] strArr = new String[oz0VarArr.length];
                for (int i = 0; i < oz0VarArr.length; i++) {
                    strArr[i] = oz0VarArr[i].b;
                }
                arrayList.add("CREATE INDEX IF NOT EXISTS i_" + wz0Var.g() + "_" + TextUtils.join("_", strArr) + " ON " + wz0Var.g() + " (" + TextUtils.join(StringUtil.ARRAY_ELEMENT_SEPARATOR, strArr) + SmallTailInfo.EMOTION_SUFFIX);
            }
            return arrayList;
        }
        return (ArrayList) invokeL.objValue;
    }

    public static String b(wz0 wz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, wz0Var)) == null) {
            return "CREATE TABLE IF NOT EXISTS " + wz0Var.g() + " (" + f(wz0Var.d()) + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeL.objValue;
    }

    public static String c(oz0 oz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, oz0Var)) == null) {
            int i = oz0Var.d;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            return " PRIMARY KEY AUTOINCREMENT";
                        }
                        throw new IllegalArgumentException("Unsupported field attribute " + oz0Var.d);
                    }
                    return " PRIMARY KEY";
                }
                return " DEFAULT 0";
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String d(oz0... oz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, oz0VarArr)) == null) ? e(oz0VarArr, null) : (String) invokeL.objValue;
    }

    public static String e(oz0[] oz0VarArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oz0VarArr, str)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = oz0VarArr.length;
            String str2 = "";
            int i = 0;
            while (i < length) {
                oz0 oz0Var = oz0VarArr[i];
                sb.append(str2);
                if (str != null && str.length() != 0) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.append(oz0Var.b);
                i++;
                str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String f(oz0[] oz0VarArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, oz0VarArr)) == null) {
            StringBuilder sb = new StringBuilder();
            int length = oz0VarArr.length;
            String str = "";
            int i = 0;
            while (i < length) {
                oz0 oz0Var = oz0VarArr[i];
                sb.append(str);
                sb.append(oz0Var.b);
                sb.append(getType(oz0Var));
                sb.append(c(oz0Var));
                i++;
                str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getType(oz0 oz0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, oz0Var)) == null) {
            int i = oz0Var.a;
            if (i == 1 || i == 2 || i == 3) {
                return " INTEGER";
            }
            if (i == 4) {
                return " TEXT";
            }
            throw new IllegalArgumentException("Unsupported field type " + oz0Var.a);
        }
        return (String) invokeL.objValue;
    }
}
