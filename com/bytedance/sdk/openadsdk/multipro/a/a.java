package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.e;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ContentResolver a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                try {
                    context = o.a();
                } catch (Throwable unused) {
                    return null;
                }
            }
            return context.getContentResolver();
        }
        return (ContentResolver) invokeL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return e.f68132b + "/t_db/ttopensdk.db/";
        }
        return (String) invokeV.objValue;
    }

    public static synchronized void a(Context context, String str, ContentValues contentValues) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, contentValues) == null) {
            synchronized (a.class) {
                if (contentValues != null) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            ContentResolver a2 = a(context);
                            if (a2 != null) {
                                a2.insert(Uri.parse(a() + str), contentValues);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
    }

    public static synchronized int a(Context context, String str, String str2, String[] strArr) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, context, str, str2, strArr)) == null) {
            synchronized (a.class) {
                if (TextUtils.isEmpty(str)) {
                    return 0;
                }
                try {
                    ContentResolver a2 = a(context);
                    if (a2 != null) {
                        return a2.delete(Uri.parse(a() + str), str2, strArr);
                    }
                } catch (Throwable unused) {
                }
                return 0;
            }
        }
        return invokeLLLL.intValue;
    }

    public static synchronized int a(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65536, null, context, str, contentValues, str2, strArr)) == null) {
            synchronized (a.class) {
                if (contentValues != null) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            ContentResolver a2 = a(context);
                            if (a2 != null) {
                                return a2.update(Uri.parse(a() + str), contentValues, str2, strArr);
                            }
                        } catch (Throwable unused) {
                        }
                        return 0;
                    }
                }
                return 0;
            }
        }
        return invokeLLLLL.intValue;
    }

    public static synchronized Cursor a(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, str, strArr, str2, strArr2, str3, str4, str5})) == null) {
            synchronized (a.class) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    ContentResolver a2 = a(context);
                    if (a2 != null) {
                        return a2.query(Uri.parse(a() + str), strArr, str2, strArr2, str5);
                    }
                } catch (Throwable unused) {
                }
                return null;
            }
        }
        return (Cursor) invokeCommon.objValue;
    }

    public static synchronized void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, context, str) == null) {
            synchronized (a.class) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    ContentResolver a2 = a(context);
                    if (a2 != null) {
                        a2.getType(Uri.parse(a() + "unknown/execSQL?sql=" + Uri.encode(str)));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
