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
/* renamed from: com.kuaishou.weapon.p0.ʽᵢ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public final class C0381 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static EnumC0382 f339;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.kuaishou.weapon.p0.ʽᵢ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class EnumC0382 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: ʻ  reason: contains not printable characters */
        public static final EnumC0382 f340;

        /* renamed from: ʼ  reason: contains not printable characters */
        public static final EnumC0382 f341;

        /* renamed from: ʽ  reason: contains not printable characters */
        public static final EnumC0382 f342;

        /* renamed from: ʾ  reason: contains not printable characters */
        public static final /* synthetic */ EnumC0382[] f343;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(191180603, "Lcom/kuaishou/weapon/p0/ʽᵢ$ʻ;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(191180603, "Lcom/kuaishou/weapon/p0/ʽᵢ$ʻ;");
                    return;
                }
            }
            f340 = new EnumC0382(RomUtils.UNKNOWN, 0);
            f341 = new EnumC0382("ARMEABI_V7A", 1);
            EnumC0382 enumC0382 = new EnumC0382("ARM64_V8A", 2);
            f342 = enumC0382;
            f343 = new EnumC0382[]{f340, f341, enumC0382};
        }

        public EnumC0382(String str, int i) {
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

        public static EnumC0382 valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0382) Enum.valueOf(EnumC0382.class, str) : (EnumC0382) invokeL.objValue;
        }

        public static EnumC0382[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0382[]) f343.clone() : (EnumC0382[]) invokeV.objValue;
        }
    }

    public C0381() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static EnumC0382 m457(Context context) {
        InterceptResult invokeL;
        EnumC0382 enumC0382;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            EnumC0382 enumC03822 = f339;
            if (enumC03822 != null) {
                return enumC03822;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                if (i < 23) {
                    if (i >= 21) {
                        try {
                            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
                            f339 = ((Boolean) cls.getDeclaredMethod("is64Bit", new Class[0]).invoke(cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(cls, new Object[0]), new Object[0])).booleanValue() ? EnumC0382.f342 : EnumC0382.f341;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            try {
                                f339 = context.getApplicationInfo().nativeLibraryDir.contains("arm64") ? EnumC0382.f342 : EnumC0382.f340;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                enumC0382 = EnumC0382.f340;
                            }
                        }
                    }
                    return f339;
                } else if (Process.is64Bit()) {
                    enumC0382 = EnumC0382.f342;
                }
                f339 = enumC0382;
                return f339;
            }
            enumC0382 = EnumC0382.f341;
            f339 = enumC0382;
            return f339;
        }
        return (EnumC0382) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static String m458(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) ? m459(context) ? "arm64-v8a" : PassBiometricUtil.CPU_TYPE_ARMEABI_V7A : (String) invokeL.objValue;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m459(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) ? m457(context) == EnumC0382.f342 : invokeL.booleanValue;
    }
}
