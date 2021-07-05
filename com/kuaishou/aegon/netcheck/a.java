package com.kuaishou.aegon.netcheck;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.EnumSet;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.kuaishou.aegon.netcheck.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class EnumC0401a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final EnumC0401a f34028a;

        /* renamed from: b  reason: collision with root package name */
        public static final EnumC0401a f34029b;

        /* renamed from: c  reason: collision with root package name */
        public static final EnumC0401a f34030c;

        /* renamed from: d  reason: collision with root package name */
        public static final EnumC0401a f34031d;

        /* renamed from: e  reason: collision with root package name */
        public static final EnumC0401a f34032e;

        /* renamed from: f  reason: collision with root package name */
        public static final /* synthetic */ EnumC0401a[] f34033f;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: g  reason: collision with root package name */
        public int f34034g;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1577030092, "Lcom/kuaishou/aegon/netcheck/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1577030092, "Lcom/kuaishou/aegon/netcheck/a$a;");
                    return;
                }
            }
            f34028a = new EnumC0401a("RESULT_WEAK_SIGNAL", 0, 1);
            f34029b = new EnumC0401a("RESULT_BAD_WIFI_GATEWAY", 1, 2);
            f34030c = new EnumC0401a("RESULT_NOT_CONNECTED", 2, 3);
            f34031d = new EnumC0401a("RESULT_SLOW_INTERNET", 3, 4);
            EnumC0401a enumC0401a = new EnumC0401a("RESULT_BAD_CELLULAR_GATEWAY", 4, 5);
            f34032e = enumC0401a;
            f34033f = new EnumC0401a[]{f34028a, f34029b, f34030c, f34031d, enumC0401a};
        }

        public EnumC0401a(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f34034g = i3;
        }

        public static EnumC0401a valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnumC0401a) Enum.valueOf(EnumC0401a.class, str) : (EnumC0401a) invokeL.objValue;
        }

        public static EnumC0401a[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnumC0401a[]) f34033f.clone() : (EnumC0401a[]) invokeV.objValue;
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34034g : invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2);

        void a(EnumSet<EnumC0401a> enumSet, String str);
    }
}
