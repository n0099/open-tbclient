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
        public static final /* synthetic */ int[] f68649a;
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
            int[] iArr = new int[EnumC1932a.values().length];
            f68649a = iArr;
            try {
                iArr[EnumC1932a.f68652c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f68649a[EnumC1932a.f68651b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.cmic.sso.sdk.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class EnumC1932a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC1932a f68650a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC1932a f68651b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC1932a f68652c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ EnumC1932a[] f68653d;
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
            f68650a = new EnumC1932a(RomUtils.UNKNOWN, 0);
            f68651b = new EnumC1932a("SAMSUNG", 1);
            EnumC1932a enumC1932a = new EnumC1932a("HUAWEI", 2);
            f68652c = enumC1932a;
            f68653d = new EnumC1932a[]{f68650a, f68651b, enumC1932a};
        }

        public EnumC1932a(String str, int i2) {
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

        public static EnumC1932a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC1932a) Enum.valueOf(EnumC1932a.class, str) : (EnumC1932a) invokeL.objValue;
        }

        public static EnumC1932a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC1932a[]) f68653d.clone() : (EnumC1932a[]) invokeV.objValue;
        }
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a(b()) : invokeV.intValue;
    }

    public static EnumC1932a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = Build.BRAND;
            if (str.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
                return EnumC1932a.f68651b;
            }
            if (str.equalsIgnoreCase("Huawei")) {
                return EnumC1932a.f68652c;
            }
            return EnumC1932a.f68650a;
        }
        return (EnumC1932a) invokeV.objValue;
    }

    public static int a(EnumC1932a enumC1932a) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, enumC1932a)) == null) {
            int i2 = AnonymousClass1.f68649a[enumC1932a.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
