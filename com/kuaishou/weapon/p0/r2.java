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
/* loaded from: classes10.dex */
public class r2 {
    public static /* synthetic */ Interceptable $ic;
    public static r2 c;
    public static r2 d;
    public static r2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;
    public a b;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a b;
        public static final a c;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-573543238, "Lcom/kuaishou/weapon/p0/r2$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-573543238, "Lcom/kuaishou/weapon/p0/r2$a;");
                    return;
                }
            }
            b = new a("DWORD", 0, 4);
            a aVar = new a("QWORD", 1, 8);
            c = aVar;
            d = new a[]{b, aVar};
        }

        public a(String str, int i, int i2) {
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
            this.a = i2;
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334598359, "Lcom/kuaishou/weapon/p0/r2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334598359, "Lcom/kuaishou/weapon/p0/r2;");
                return;
            }
        }
        c();
    }

    public r2() {
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

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            c = new r2();
            d = new r2();
            e = new r2();
            d.a(a.b);
            int i = Build.VERSION.SDK_INT;
            if (s2.a()) {
                c.a(a.c);
                e.a(a.c);
                switch (i) {
                    case 19:
                        c.a(32L);
                        d.a(28L);
                        return;
                    case 20:
                    default:
                        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                    case 21:
                        c.a(40L);
                        c.a(a.c);
                        e.a(32L);
                        e.a(a.c);
                        d.a(56L);
                        return;
                    case 22:
                        c.a(52L);
                        e.a(44L);
                        d.a(20L);
                        return;
                    case 23:
                        c.a(48L);
                        e.a(40L);
                        d.a(12L);
                        return;
                    case 24:
                    case 25:
                        c.a(48L);
                        e.a(40L);
                        d.a(4L);
                        return;
                    case 26:
                    case 27:
                        c.a(40L);
                        e.a(32L);
                        d.a(4L);
                        return;
                    case 28:
                    case 29:
                        c.a(32L);
                        e.a(24L);
                        d.a(4L);
                        return;
                }
            }
            c.a(a.b);
            e.a(a.b);
            switch (i) {
                case 19:
                    c.a(32L);
                    d.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    c.a(40L);
                    c.a(a.c);
                    e.a(32L);
                    e.a(a.c);
                    d.a(56L);
                    return;
                case 22:
                    c.a(44L);
                    e.a(40L);
                    d.a(20L);
                    return;
                case 23:
                    c.a(36L);
                    e.a(32L);
                    d.a(12L);
                    return;
                case 24:
                case 25:
                    c.a(32L);
                    e.a(28L);
                    d.a(4L);
                    return;
                case 26:
                case 27:
                    c.a(28L);
                    e.a(24L);
                    d.a(4L);
                    return;
                case 28:
                case 29:
                    c.a(24L);
                    e.a(20L);
                    d.a(4L);
                    return;
            }
        }
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (a) invokeV.objValue;
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.a = j;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.longValue;
    }
}
