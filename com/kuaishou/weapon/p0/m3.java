package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class m3 {
    public static /* synthetic */ Interceptable $ic;
    public static a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-578131052, "Lcom/kuaishou/weapon/p0/m3$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-578131052, "Lcom/kuaishou/weapon/p0/m3$a;");
                    return;
                }
            }
            a = new a(RomUtils.UNKNOWN, 0);
            b = new a("ARMEABI_V7A", 1);
            a aVar = new a("ARM64_V8A", 2);
            c = aVar;
            d = new a[]{a, b, aVar};
        }

        public a(String str, int i) {
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

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) d.clone() : (a[]) invokeV.objValue;
        }
    }

    public m3() {
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

    public static a a(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            a aVar2 = a;
            if (aVar2 != null) {
                return aVar2;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                if (i < 23) {
                    if (i >= 21) {
                        try {
                            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                            a = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? a.c : a.b;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            try {
                                a = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? a.c : a.a;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                aVar = a.a;
                            }
                        }
                    }
                    return a;
                } else if (Process.is64Bit()) {
                    aVar = a.c;
                }
                a = aVar;
                return a;
            }
            aVar = a.b;
            a = aVar;
            return a;
        }
        return (a) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? c(context) ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A : (String) invokeL.objValue;
    }

    public static boolean c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? a(context) == a.c : invokeL.booleanValue;
    }
}
