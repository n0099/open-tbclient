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
import com.kuaishou.weapon.un.g;
@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.cmic.sso.sdk.a.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            int[] iArr = new int[EnumC2023a.values().length];
            a = iArr;
            try {
                iArr[EnumC2023a.f55445c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumC2023a.f55444b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class EnumC2023a {
        public static /* synthetic */ Interceptable $ic;
        public static final EnumC2023a a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC2023a f55444b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC2023a f55445c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ EnumC2023a[] f55446d;
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
            a = new EnumC2023a(RomUtils.UNKNOWN, 0);
            f55444b = new EnumC2023a(g.f57226j, 1);
            EnumC2023a enumC2023a = new EnumC2023a("HUAWEI", 2);
            f55445c = enumC2023a;
            f55446d = new EnumC2023a[]{a, f55444b, enumC2023a};
        }

        public EnumC2023a(String str, int i2) {
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

        public static EnumC2023a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC2023a) Enum.valueOf(EnumC2023a.class, str) : (EnumC2023a) invokeL.objValue;
        }

        public static EnumC2023a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC2023a[]) f55446d.clone() : (EnumC2023a[]) invokeV.objValue;
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a(b()) : invokeV.intValue;
    }

    public static EnumC2023a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
                return EnumC2023a.f55444b;
            }
            if (str.equalsIgnoreCase("Huawei")) {
                return EnumC2023a.f55445c;
            }
            return EnumC2023a.a;
        }
        return (EnumC2023a) invokeV.objValue;
    }

    public static int a(EnumC2023a enumC2023a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, enumC2023a)) == null) {
            int i2 = AnonymousClass1.a[enumC2023a.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
