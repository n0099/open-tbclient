package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class WorkSourceUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final int zza;
    public static final Method zzb;
    public static final Method zzc;
    public static final Method zzd;
    public static final Method zze;
    public static final Method zzf;
    public static final Method zzg;
    public static final Method zzh;
    public static final Method zzi;
    public transient /* synthetic */ FieldHolder $fh;

    public WorkSourceUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:1|(4:59|(1:61)|62|(2:64|65))|3|4|5|6|(21:51|52|9|10|11|12|13|14|15|(12:43|44|18|(9:38|39|21|(6:33|34|24|(2:29|30)|26|27)|23|24|(0)|26|27)|20|21|(0)|23|24|(0)|26|27)|17|18|(0)|20|21|(0)|23|24|(0)|26|27)|8|9|10|11|12|13|14|15|(0)|17|18|(0)|20|21|(0)|23|24|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
        r1 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        InterceptResult invokeClinit;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1911035430, "Lcom/google/android/gms/common/util/WorkSourceUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1911035430, "Lcom/google/android/gms/common/util/WorkSourceUtil;");
                return;
            }
        }
        zza = Process.myUid();
        Method method6 = null;
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        zzb = method;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
            try {
                method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            } catch (Exception unused2) {
            }
            zzc = method2;
            Method method7 = WorkSource.class.getMethod("size", new Class[0]);
            zzd = method7;
            Method method8 = WorkSource.class.getMethod("get", Integer.TYPE);
            zze = method8;
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                try {
                    method3 = WorkSource.class.getMethod("getName", Integer.TYPE);
                } catch (Exception unused3) {
                }
                zzf = method3;
                if (PlatformVersion.isAtLeastP()) {
                    try {
                        method4 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
                    } catch (Exception e) {
                        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e);
                    }
                    zzg = method4;
                    if (PlatformVersion.isAtLeastP()) {
                        try {
                            method5 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
                        } catch (Exception e2) {
                            Log.w("WorkSourceUtil", "Missing WorkChain class", e2);
                        }
                        zzh = method5;
                        if (PlatformVersion.isAtLeastP()) {
                            try {
                                method6 = WorkSource.class.getMethod("isEmpty", new Class[0]);
                                method6.setAccessible(true);
                            } catch (Exception unused4) {
                            }
                        }
                        zzi = method6;
                    }
                    method5 = null;
                    zzh = method5;
                    if (PlatformVersion.isAtLeastP()) {
                    }
                    zzi = method6;
                }
                method4 = null;
                zzg = method4;
                if (PlatformVersion.isAtLeastP()) {
                }
                method5 = null;
                zzh = method5;
                if (PlatformVersion.isAtLeastP()) {
                }
                zzi = method6;
            }
            method3 = null;
            zzf = method3;
            if (PlatformVersion.isAtLeastP()) {
            }
            method4 = null;
            zzg = method4;
            if (PlatformVersion.isAtLeastP()) {
            }
            method5 = null;
            zzh = method5;
            if (PlatformVersion.isAtLeastP()) {
            }
            zzi = method6;
        }
        method2 = null;
        zzc = method2;
        Method method72 = WorkSource.class.getMethod("size", new Class[0]);
        zzd = method72;
        Method method82 = WorkSource.class.getMethod("get", Integer.TYPE);
        zze = method82;
        if (PlatformVersion.isAtLeastJellyBeanMR2()) {
        }
        method3 = null;
        zzf = method3;
        if (PlatformVersion.isAtLeastP()) {
        }
        method4 = null;
        zzg = method4;
        if (PlatformVersion.isAtLeastP()) {
        }
        method5 = null;
        zzh = method5;
        if (PlatformVersion.isAtLeastP()) {
        }
        zzi = method6;
    }

    public static void add(WorkSource workSource, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, workSource, i, str) == null) {
            Method method = zzc;
            if (method != null) {
                if (str == null) {
                    str = "";
                }
                try {
                    method.invoke(workSource, Integer.valueOf(i), str);
                    return;
                } catch (Exception e) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                    return;
                }
            }
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, Integer.valueOf(i));
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }

    public static WorkSource fromPackage(Context context, String str) {
        InterceptResult invokeLL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (context != null && context.getPackageManager() != null && str != null) {
                try {
                    ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                    if (applicationInfo == null) {
                        if (str.length() != 0) {
                            str3 = "Could not get applicationInfo from package: ".concat(str);
                        } else {
                            str3 = new String("Could not get applicationInfo from package: ");
                        }
                        Log.e("WorkSourceUtil", str3);
                        return null;
                    }
                    int i = applicationInfo.uid;
                    WorkSource workSource = new WorkSource();
                    add(workSource, i, str);
                    return workSource;
                } catch (PackageManager.NameNotFoundException unused) {
                    if (str.length() != 0) {
                        str2 = "Could not find package: ".concat(str);
                    } else {
                        str2 = new String("Could not find package: ");
                    }
                    Log.e("WorkSourceUtil", str2);
                }
            }
            return null;
        }
        return (WorkSource) invokeLL.objValue;
    }

    public static WorkSource fromPackageAndModuleExperimentalPi(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2)) == null) {
            if (context != null && context.getPackageManager() != null && str2 != null && str != null) {
                int i = -1;
                try {
                    ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                    if (applicationInfo == null) {
                        if (str.length() != 0) {
                            str4 = "Could not get applicationInfo from package: ".concat(str);
                        } else {
                            str4 = new String("Could not get applicationInfo from package: ");
                        }
                        Log.e("WorkSourceUtil", str4);
                    } else {
                        i = applicationInfo.uid;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    if (str.length() != 0) {
                        str3 = "Could not find package: ".concat(str);
                    } else {
                        str3 = new String("Could not find package: ");
                    }
                    Log.e("WorkSourceUtil", str3);
                }
                if (i < 0) {
                    return null;
                }
                WorkSource workSource = new WorkSource();
                Method method = zzg;
                if (method != null && zzh != null) {
                    try {
                        Object invoke = method.invoke(workSource, new Object[0]);
                        if (i != zza) {
                            zzh.invoke(invoke, Integer.valueOf(i), str);
                        }
                        zzh.invoke(invoke, Integer.valueOf(zza), str2);
                    } catch (Exception e) {
                        Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e);
                    }
                } else {
                    add(workSource, i, str);
                }
                return workSource;
            }
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        return (WorkSource) invokeLLL.objValue;
    }

    public static List getNames(WorkSource workSource) {
        InterceptResult invokeL;
        int zza2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, workSource)) == null) {
            ArrayList arrayList = new ArrayList();
            if (workSource == null) {
                zza2 = 0;
            } else {
                zza2 = zza(workSource);
            }
            if (zza2 != 0) {
                for (int i = 0; i < zza2; i++) {
                    Method method = zzf;
                    String str = null;
                    if (method != null) {
                        try {
                            str = (String) method.invoke(workSource, Integer.valueOf(i));
                        } catch (Exception e) {
                            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                        }
                    }
                    if (!Strings.isEmptyOrWhitespace(str)) {
                        Preconditions.checkNotNull(str);
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean hasWorkSourcePermission(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            if (context == null || context.getPackageManager() == null || Wrappers.packageManager(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int zza(WorkSource workSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, workSource)) == null) {
            Method method = zzd;
            if (method != null) {
                try {
                    Object invoke = method.invoke(workSource, new Object[0]);
                    Preconditions.checkNotNull(invoke);
                    return ((Integer) invoke).intValue();
                } catch (Exception e) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static boolean isEmpty(WorkSource workSource) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, workSource)) == null) {
            Method method = zzi;
            if (method != null) {
                try {
                    Object invoke = method.invoke(workSource, new Object[0]);
                    Preconditions.checkNotNull(invoke);
                    return ((Boolean) invoke).booleanValue();
                } catch (Exception e) {
                    Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e);
                }
            }
            if (zza(workSource) != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
