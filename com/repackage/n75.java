package com.repackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class n75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? ru4.k().i() : (String) invokeV.objValue;
    }

    public static ContentResolver b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ru4.k().j() : (ContentResolver) invokeV.objValue;
    }

    public static OrmObject c(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, cls)) == null) {
            if (str == null || cls == null) {
                return null;
            }
            return OrmObject.objectWithJsonStr(e(str), cls);
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static String d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            String e = e(str);
            return e != null ? e : str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return f(Uri.parse(a() + str));
        }
        return (String) invokeL.objValue;
    }

    public static String f(Uri uri) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, uri)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                str = b().getType(uri);
            } catch (SecurityException e) {
                BdLog.detailException(e);
                str = null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            m75.m("getValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static ContentValues g(String str, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, obj)) == null) {
            ContentValues contentValues = new ContentValues();
            String str2 = null;
            if (obj != null) {
                if (obj instanceof String) {
                    str2 = (String) obj;
                } else if (obj instanceof Boolean) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Integer) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Long) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Float) {
                    str2 = String.valueOf(obj);
                } else if (obj instanceof Double) {
                    str2 = String.valueOf(obj);
                }
            }
            contentValues.put(str, str2);
            return contentValues;
        }
        return (ContentValues) invokeLL.objValue;
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            i(str, str2);
        }
    }

    public static void i(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, obj) == null) {
            j(Uri.parse(a() + str), g(str, obj));
        }
    }

    public static void j(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, uri, contentValues) == null) {
            k(uri, contentValues);
        }
    }

    public static void k(Uri uri, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, uri, contentValues) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                b().insert(uri, contentValues);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            m75.m("setValue uri=" + uri + " Time:" + (currentTimeMillis2 - currentTimeMillis));
        }
    }
}
