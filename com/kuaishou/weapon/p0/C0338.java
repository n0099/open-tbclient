package com.kuaishou.weapon.p0;

import android.os.Build;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʼᴵ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0338 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static C0338 f123;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static C0338 f124;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static C0338 f125;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public long f126;

    /* renamed from: ʼ  reason: contains not printable characters */
    public EnumC0339 f127;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.kuaishou.weapon.p0.ʼᴵ$ʻ  reason: contains not printable characters */
    /* loaded from: classes5.dex */
    public static final class EnumC0339 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: ʼ  reason: contains not printable characters */
        public static final EnumC0339 f128;

        /* renamed from: ʽ  reason: contains not printable characters */
        public static final EnumC0339 f129;

        /* renamed from: ʾ  reason: contains not printable characters */
        public static final /* synthetic */ EnumC0339[] f130;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: ʻ  reason: contains not printable characters */
        public int f131;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(188916487, "Lcom/kuaishou/weapon/p0/ʼᴵ$ʻ;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(188916487, "Lcom/kuaishou/weapon/p0/ʼᴵ$ʻ;");
                    return;
                }
            }
            f128 = new EnumC0339("DWORD", 0, 4);
            EnumC0339 enumC0339 = new EnumC0339("QWORD", 1, 8);
            f129 = enumC0339;
            f130 = new EnumC0339[]{f128, enumC0339};
        }

        public EnumC0339(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f131 = i2;
        }

        public static EnumC0339 valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0339) Enum.valueOf(EnumC0339.class, str) : (EnumC0339) invokeL.objValue;
        }

        public static EnumC0339[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0339[]) f130.clone() : (EnumC0339[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335391742, "Lcom/kuaishou/weapon/p0/ʼᴵ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335391742, "Lcom/kuaishou/weapon/p0/ʼᴵ;");
                return;
            }
        }
        m284();
    }

    public C0338() {
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

    /* renamed from: ʽ  reason: contains not printable characters */
    public static void m284() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            f123 = new C0338();
            f124 = new C0338();
            f125 = new C0338();
            f124.m287(EnumC0339.f128);
            int i = Build.VERSION.SDK_INT;
            if (C0340.m289()) {
                f123.m287(EnumC0339.f129);
                f125.m287(EnumC0339.f129);
                switch (i) {
                    case 19:
                        f123.m286(32L);
                        f124.m286(28L);
                        return;
                    case 20:
                    default:
                        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                    case 21:
                        f123.m286(40L);
                        f123.m287(EnumC0339.f129);
                        f125.m286(32L);
                        f125.m287(EnumC0339.f129);
                        f124.m286(56L);
                        return;
                    case 22:
                        f123.m286(52L);
                        f125.m286(44L);
                        f124.m286(20L);
                        return;
                    case 23:
                        f123.m286(48L);
                        f125.m286(40L);
                        f124.m286(12L);
                        return;
                    case 24:
                    case 25:
                        f123.m286(48L);
                        f125.m286(40L);
                        f124.m286(4L);
                        return;
                    case 26:
                    case 27:
                        f123.m286(40L);
                        f125.m286(32L);
                        f124.m286(4L);
                        return;
                    case 28:
                    case 29:
                        f123.m286(32L);
                        f125.m286(24L);
                        f124.m286(4L);
                        return;
                }
            }
            f123.m287(EnumC0339.f128);
            f125.m287(EnumC0339.f128);
            switch (i) {
                case 19:
                    f123.m286(32L);
                    f124.m286(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    f123.m286(40L);
                    f123.m287(EnumC0339.f129);
                    f125.m286(32L);
                    f125.m287(EnumC0339.f129);
                    f124.m286(56L);
                    return;
                case 22:
                    f123.m286(44L);
                    f125.m286(40L);
                    f124.m286(20L);
                    return;
                case 23:
                    f123.m286(36L);
                    f125.m286(32L);
                    f124.m286(12L);
                    return;
                case 24:
                case 25:
                    f123.m286(32L);
                    f125.m286(28L);
                    f124.m286(4L);
                    return;
                case 26:
                case 27:
                    f123.m286(28L);
                    f125.m286(24L);
                    f124.m286(4L);
                    return;
                case 28:
                case 29:
                    f123.m286(24L);
                    f125.m286(20L);
                    f124.m286(4L);
                    return;
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public EnumC0339 m285() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f127 : (EnumC0339) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m286(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.f126 = j;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m287(EnumC0339 enumC0339) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, enumC0339) == null) {
            this.f127 = enumC0339;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public long m288() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f126 : invokeV.longValue;
    }
}
