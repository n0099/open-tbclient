package com.heytap.openid.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.sdk.b;
/* loaded from: classes7.dex */
public class OpenIDSDK {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenIDSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void clear(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            String str = "pkg:" + context.getPackageName() + " clear";
            if (a.a()) {
                b bVar = b.C0516b.a;
                Context a = a.a(context);
                synchronized (bVar) {
                    try {
                        if (bVar.a != null) {
                            a.unbindService(bVar.e);
                            bVar.a = null;
                        }
                    } catch (Exception unused) {
                        Log.e("OpenIDHelper", "ex: unbind fail");
                    }
                }
            }
        }
    }

    public static String getAAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? !a.a() ? "" : b.C0516b.a.a(a.a(context), "AUID") : (String) invokeL.objValue;
    }

    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? !a.a() ? "" : b.C0516b.a.a(a.a(context), "OUID") : (String) invokeL.objValue;
    }

    public static boolean getOAIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a.a()) {
                return "TRUE".equalsIgnoreCase(b.C0516b.a.a(a.a(context), "OUID_STATUS"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getUDID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? !a.a() ? "" : b.C0516b.a.a(a.a(context), "GUID") : (String) invokeL.objValue;
    }

    public static String getVAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) ? !a.a() ? "" : b.C0516b.a.a(a.a(context), "DUID") : (String) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            b bVar = b.C0516b.a;
            Context a = a.a(context);
            bVar.getClass();
            boolean z = false;
            try {
                PackageInfo packageInfo = a.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo != null) {
                    if (packageInfo.versionCode >= 1) {
                        z = true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            a.b = z;
            a.a = true;
        }
    }

    public static boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            if (!a.a) {
                Log.e("OpenIDHelper", "SDK Need Init First!");
            }
            return a.b;
        }
        return invokeV.booleanValue;
    }
}
