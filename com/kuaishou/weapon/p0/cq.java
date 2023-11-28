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
public class cq {
    public static /* synthetic */ Interceptable $ic;
    public static cq a;
    public static cq b;
    public static cq c;
    public transient /* synthetic */ FieldHolder $fh;
    public long d;
    public a e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public static final a b;
        public static final /* synthetic */ a[] d;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-585519220, "Lcom/kuaishou/weapon/p0/cq$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-585519220, "Lcom/kuaishou/weapon/p0/cq$a;");
                    return;
                }
            }
            a = new a("DWORD", 0, 4);
            a aVar = new a("QWORD", 1, 8);
            b = aVar;
            d = new a[]{a, aVar};
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
            this.c = i2;
        }

        public static a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (a) Enum.valueOf(a.class, str);
            }
            return (a) invokeL.objValue;
        }

        public static a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (a[]) d.clone();
            }
            return (a[]) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(334585897, "Lcom/kuaishou/weapon/p0/cq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(334585897, "Lcom/kuaishou/weapon/p0/cq;");
                return;
            }
        }
        c();
    }

    public cq() {
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

    public long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (a) invokeV.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a = new cq();
            b = new cq();
            c = new cq();
            b.a(a.a);
            int i = Build.VERSION.SDK_INT;
            if (cr.a()) {
                a.a(a.b);
                c.a(a.b);
                switch (i) {
                    case 19:
                        a.a(32L);
                        b.a(28L);
                        return;
                    case 20:
                    default:
                        throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                    case 21:
                        a.a(40L);
                        a.a(a.b);
                        c.a(32L);
                        c.a(a.b);
                        b.a(56L);
                        return;
                    case 22:
                        a.a(52L);
                        c.a(44L);
                        b.a(20L);
                        return;
                    case 23:
                        a.a(48L);
                        c.a(40L);
                        b.a(12L);
                        return;
                    case 24:
                    case 25:
                        a.a(48L);
                        c.a(40L);
                        b.a(4L);
                        return;
                    case 26:
                    case 27:
                        a.a(40L);
                        c.a(32L);
                        b.a(4L);
                        return;
                    case 28:
                    case 29:
                        a.a(32L);
                        c.a(24L);
                        b.a(4L);
                        return;
                }
            }
            a.a(a.a);
            c.a(a.a);
            switch (i) {
                case 19:
                    a.a(32L);
                    b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    a.a(40L);
                    a.a(a.b);
                    c.a(32L);
                    c.a(a.b);
                    b.a(56L);
                    return;
                case 22:
                    a.a(44L);
                    c.a(40L);
                    b.a(20L);
                    return;
                case 23:
                    a.a(36L);
                    c.a(32L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    a.a(32L);
                    c.a(28L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    a.a(28L);
                    c.a(24L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    a.a(24L);
                    c.a(20L);
                    b.a(4L);
                    return;
            }
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.d = j;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.e = aVar;
        }
    }
}
