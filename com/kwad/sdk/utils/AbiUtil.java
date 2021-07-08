package com.kwad.sdk.utils;

import android.os.Build;
import android.os.Process;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.loader.Reflect;
/* loaded from: classes6.dex */
public final class AbiUtil {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Abi f36485a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Abi {
        public static final /* synthetic */ Abi[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Abi ARM64_V8A;
        public static final Abi ARMEABI_V7A;
        public static final Abi UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1901859750, "Lcom/kwad/sdk/utils/AbiUtil$Abi;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1901859750, "Lcom/kwad/sdk/utils/AbiUtil$Abi;");
                    return;
                }
            }
            UNKNOWN = new Abi(RomUtils.UNKNOWN, 0);
            ARMEABI_V7A = new Abi("ARMEABI_V7A", 1);
            Abi abi = new Abi("ARM64_V8A", 2);
            ARM64_V8A = abi;
            $VALUES = new Abi[]{UNKNOWN, ARMEABI_V7A, abi};
        }

        public Abi(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Abi valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Abi) Enum.valueOf(Abi.class, str) : (Abi) invokeL.objValue;
        }

        public static Abi[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Abi[]) $VALUES.clone() : (Abi[]) invokeV.objValue;
        }
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b() ? "arm64-v8a" : "armeabi-v7a" : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? c() == Abi.ARM64_V8A : invokeV.booleanValue;
    }

    public static Abi c() {
        InterceptResult invokeV;
        Abi abi;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Abi abi2 = f36485a;
            if (abi2 != null) {
                return abi2;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                if (i2 < 23) {
                    if (i2 >= 21) {
                        try {
                            f36485a = ((Boolean) Reflect.a("dalvik.system.VMRuntime").d("getRuntime").d("is64Bit").a()).booleanValue() ? Abi.ARM64_V8A : Abi.ARMEABI_V7A;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            try {
                                f36485a = KsAdSDKImpl.get().getContext().getApplicationInfo().nativeLibraryDir.contains("arm64") ? Abi.ARM64_V8A : Abi.UNKNOWN;
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                                abi = Abi.UNKNOWN;
                            }
                        }
                    }
                    return f36485a;
                } else if (Process.is64Bit()) {
                    abi = Abi.ARM64_V8A;
                }
                f36485a = abi;
                return f36485a;
            }
            abi = Abi.ARMEABI_V7A;
            f36485a = abi;
            return f36485a;
        }
        return (Abi) invokeV.objValue;
    }
}
