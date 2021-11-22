package com.heytap.openid.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.heytap.openid.sdk.b;
/* loaded from: classes2.dex */
public class OpenIDSDK {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenIDSDK() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                b bVar = b.C1924b.f64624a;
                Context a2 = a.a(context);
                synchronized (bVar) {
                    try {
                        if (bVar.f64618a != null) {
                            a2.unbindService(bVar.f64622e);
                            bVar.f64618a = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public static String getAAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? !a.a() ? "" : b.C1924b.f64624a.a(a.a(context), "AUID") : (String) invokeL.objValue;
    }

    public static String getOAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? !a.a() ? "" : b.C1924b.f64624a.a(a.a(context), "OUID") : (String) invokeL.objValue;
    }

    public static boolean getOAIDStatus(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (a.a()) {
                return "TRUE".equalsIgnoreCase(b.C1924b.f64624a.a(a.a(context), "OUID_STATUS"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String getUDID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? !a.a() ? "" : b.C1924b.f64624a.a(a.a(context), "GUID") : (String) invokeL.objValue;
    }

    public static String getVAID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) ? !a.a() ? "" : b.C1924b.f64624a.a(a.a(context), "DUID") : (String) invokeL.objValue;
    }

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            b bVar = b.C1924b.f64624a;
            Context a2 = a.a(context);
            bVar.getClass();
            boolean z = false;
            try {
                PackageInfo packageInfo = a2.getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo != null) {
                    if (packageInfo.versionCode >= 1) {
                        z = true;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            a.f64617b = z;
            a.f64616a = true;
        }
    }

    public static boolean isSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            boolean z = a.f64616a;
            return a.f64617b;
        }
        return invokeV.booleanValue;
    }
}
