package com.cmic.sso.sdk.a;

import android.annotation.SuppressLint;
import android.os.Build;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
@SuppressLint({"NewApi"})
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69375a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2109459649, "Lcom/cmic/sso/sdk/a/a$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2109459649, "Lcom/cmic/sso/sdk/a/a$1;");
                    return;
                }
            }
            int[] iArr = new int[EnumC1942a.values().length];
            f69375a = iArr;
            try {
                iArr[EnumC1942a.f69378c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69375a[EnumC1942a.f69377b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class EnumC1942a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1942a f69376a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1942a f69377b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1942a f69378c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ EnumC1942a[] f69379d;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2109461137, "Lcom/cmic/sso/sdk/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2109461137, "Lcom/cmic/sso/sdk/a/a$a;");
                    return;
                }
            }
            f69376a = new EnumC1942a(RomUtils.UNKNOWN, 0);
            f69377b = new EnumC1942a("SAMSUNG", 1);
            EnumC1942a enumC1942a = new EnumC1942a("HUAWEI", 2);
            f69378c = enumC1942a;
            f69379d = new EnumC1942a[]{f69376a, f69377b, enumC1942a};
        }

        public EnumC1942a(String str, int i2) {
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

        public static EnumC1942a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1942a) Enum.valueOf(EnumC1942a.class, str) : (EnumC1942a) invokeL.objValue;
        }

        public static EnumC1942a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1942a[]) f69379d.clone() : (EnumC1942a[]) invokeV.objValue;
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a(b()) : invokeV.intValue;
    }

    public static EnumC1942a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
                return EnumC1942a.f69377b;
            }
            if (str.equalsIgnoreCase("Huawei")) {
                return EnumC1942a.f69378c;
            }
            return EnumC1942a.f69376a;
        }
        return (EnumC1942a) invokeV.objValue;
    }

    public static int a(EnumC1942a enumC1942a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, enumC1942a)) == null) {
            int i2 = AnonymousClass1.f69375a[enumC1942a.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
