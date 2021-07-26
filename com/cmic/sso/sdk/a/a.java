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
/* loaded from: classes5.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32682a;
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
            int[] iArr = new int[EnumC0372a.values().length];
            f32682a = iArr;
            try {
                iArr[EnumC0372a.f32685c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32682a[EnumC0372a.f32684b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class EnumC0372a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0372a f32683a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC0372a f32684b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0372a f32685c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ EnumC0372a[] f32686d;
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
            f32683a = new EnumC0372a(RomUtils.UNKNOWN, 0);
            f32684b = new EnumC0372a("SAMSUNG", 1);
            EnumC0372a enumC0372a = new EnumC0372a("HUAWEI", 2);
            f32685c = enumC0372a;
            f32686d = new EnumC0372a[]{f32683a, f32684b, enumC0372a};
        }

        public EnumC0372a(String str, int i2) {
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

        public static EnumC0372a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0372a) Enum.valueOf(EnumC0372a.class, str) : (EnumC0372a) invokeL.objValue;
        }

        public static EnumC0372a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0372a[]) f32686d.clone() : (EnumC0372a[]) invokeV.objValue;
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a(b()) : invokeV.intValue;
    }

    public static EnumC0372a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
                return EnumC0372a.f32684b;
            }
            if (str.equalsIgnoreCase("Huawei")) {
                return EnumC0372a.f32685c;
            }
            return EnumC0372a.f32683a;
        }
        return (EnumC0372a) invokeV.objValue;
    }

    public static int a(EnumC0372a enumC0372a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, enumC0372a)) == null) {
            int i2 = AnonymousClass1.f32682a[enumC0372a.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
