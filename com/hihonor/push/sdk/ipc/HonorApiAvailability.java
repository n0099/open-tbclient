package com.hihonor.push.sdk.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tieba.nmb;
import com.baidu.tieba.qmb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes9.dex */
public class HonorApiAvailability {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class PackageStates {
        public static /* synthetic */ Interceptable $ic;
        public static final PackageStates DISABLED;
        public static final PackageStates ENABLED;
        public static final PackageStates NOT_INSTALLED;
        public static final /* synthetic */ PackageStates[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2046378479, "Lcom/hihonor/push/sdk/ipc/HonorApiAvailability$PackageStates;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2046378479, "Lcom/hihonor/push/sdk/ipc/HonorApiAvailability$PackageStates;");
                    return;
                }
            }
            PackageStates packageStates = new PackageStates("ENABLED", 0);
            ENABLED = packageStates;
            PackageStates packageStates2 = new PackageStates("DISABLED", 1);
            DISABLED = packageStates2;
            PackageStates packageStates3 = new PackageStates("NOT_INSTALLED", 2);
            NOT_INSTALLED = packageStates3;
            a = new PackageStates[]{packageStates, packageStates2, packageStates3};
        }

        public PackageStates(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PackageStates valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (PackageStates) Enum.valueOf(PackageStates.class, str);
            }
            return (PackageStates) invokeL.objValue;
        }

        public static PackageStates[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (PackageStates[]) a.clone();
            }
            return (PackageStates[]) invokeV.objValue;
        }
    }

    public static qmb a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            qmb qmbVar = new qmb();
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("android", "com.hihonor.android.pushagentproxy.HiPushService"));
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
            if (queryIntentServices.size() > 0) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                if (it.hasNext()) {
                    ResolveInfo next = it.next();
                    String str = next.serviceInfo.applicationInfo.packageName;
                    String e = nmb.e(context, str);
                    qmbVar.f(str);
                    qmbVar.g(next.serviceInfo.name);
                    qmbVar.h(e);
                }
            }
            return qmbVar;
        }
        return (qmb) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        PackageStates packageStates;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context != null) {
                qmb a = a(context);
                String c = a.c();
                String str = "service package name is " + c;
                if (TextUtils.isEmpty(c)) {
                    packageStates = PackageStates.NOT_INSTALLED;
                } else {
                    try {
                        if (context.getPackageManager().getApplicationInfo(c, 0).enabled) {
                            packageStates = PackageStates.ENABLED;
                        } else {
                            packageStates = PackageStates.DISABLED;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        packageStates = PackageStates.NOT_INSTALLED;
                    }
                }
                if (PackageStates.NOT_INSTALLED.equals(packageStates)) {
                    Log.i("HonorApiAvailability", "push service is not installed");
                    return 8002008;
                } else if (PackageStates.DISABLED.equals(packageStates)) {
                    Log.i("HonorApiAvailability", "push service is disabled");
                    return 8002007;
                } else if (TextUtils.equals(c, "android") && !TextUtils.isEmpty(a.e())) {
                    return HonorPushErrorEnum.SUCCESS.statusCode;
                } else {
                    return 8002006;
                }
            }
            throw new NullPointerException("context must not be null.");
        }
        return invokeL.intValue;
    }
}
