package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes9.dex */
public abstract class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a extends Exception {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, cls, str, clsArr, objArr)) == null) {
            if (cls != null) {
                if (clsArr == null) {
                    if (objArr != null) {
                        throw new a("paramsType is null, but params is not null");
                    }
                } else if (objArr == null) {
                    throw new a("paramsType or params should be same");
                } else {
                    if (clsArr.length != objArr.length) {
                        throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
                    }
                }
                try {
                } catch (NoSuchMethodException unused) {
                    y.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
                }
                try {
                    return cls.getMethod(str, clsArr).invoke(null, objArr);
                } catch (IllegalAccessException unused2) {
                    str2 = "invokeStaticFun(): method invoke Exception!";
                    y.f("hmsSdk", str2);
                    return null;
                } catch (IllegalArgumentException unused3) {
                    str2 = "invokeStaticFun(): Illegal Argument!";
                    y.f("hmsSdk", str2);
                    return null;
                } catch (InvocationTargetException unused4) {
                    str2 = "invokeStaticFun(): Invocation Target Exception!";
                    y.f("hmsSdk", str2);
                    return null;
                }
            }
            throw new a("class is null in invokeStaticFun");
        }
        return invokeLLLL.objValue;
    }

    public static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        InterceptResult invokeLLLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65537, null, str, str2, clsArr, objArr)) == null) {
            try {
                return a(Class.forName(str), str2, clsArr, objArr);
            } catch (a unused) {
                str3 = "invokeStaticFun(): Static function call Exception ";
                y.f("hmsSdk", str3);
                return null;
            } catch (ClassNotFoundException unused2) {
                str3 = "invokeStaticFun() Not found class!";
                y.f("hmsSdk", str3);
                return null;
            }
        }
        return invokeLLLL.objValue;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a("ro.build.version.emui", "") : (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? context == null ? "" : ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID) : (String) invokeL.objValue;
    }

    public static String a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2;
            }
            String a2 = a(CountryCodeBean.ANDRIOD_SYSTEMPROP, str, str2);
            return TextUtils.isEmpty(a2) ? a("com.huawei.android.os.SystemPropertiesEx", str, str2) : a2;
        }
        return (String) invokeLL.objValue;
    }

    public static String a(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, null, str, str2, str3)) == null) {
            Object a2 = a(str, CommandUBCHelper.COMMAND_UBC_SOURCE_RECEIVE, new Class[]{String.class, String.class}, new Object[]{str2, str3});
            return a2 != null ? (String) a2 : str3;
        }
        return (String) invokeLLL.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            String a2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
            y.c("hmsSdk", "SystemPropertiesEx: get rom_ver: " + a2);
            if (TextUtils.isEmpty(a2)) {
                String str = Build.DISPLAY;
                y.c("hmsSdk", "SystemProperties: get rom_ver: " + str);
                return str;
            }
            return a2;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("CHANNEL")) == null) {
                    return "Unknown";
                }
                String obj2 = obj.toString();
                return obj2.length() > 256 ? "Unknown" : obj2;
            } catch (PackageManager.NameNotFoundException unused) {
                y.f("hmsSdk", "getChannel(): The packageName is not correct!");
                return "Unknown";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? context == null ? "" : context.getPackageName() : (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (context == null) {
                return "";
            }
            try {
                return context.getPackageManager().getPackageInfo(c(context), 16384).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                y.f("hmsSdk", "getVersion(): The package name is not correct!");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
