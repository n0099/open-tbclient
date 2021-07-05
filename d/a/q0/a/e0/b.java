package d.a.q0.a.e0;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k2.g.g;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.a.e0.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0716b extends g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d.a.q0.a.e0.b$b$a */
        /* loaded from: classes8.dex */
        public static final class a {
            public static /* synthetic */ Interceptable $ic;

            /* renamed from: a  reason: collision with root package name */
            public static final C0716b f47283a;
            public transient /* synthetic */ FieldHolder $fh;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(275198793, "Ld/a/q0/a/e0/b$b$a;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(275198793, "Ld/a/q0/a/e0/b$b$a;");
                        return;
                    }
                }
                f47283a = new C0716b(null);
            }
        }

        public /* synthetic */ C0716b(a aVar) {
            this();
        }

        public static C0716b e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f47283a : (C0716b) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0716b() {
            super("searchbox_sconsole_sp");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return "consoleSwitch" + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !TextUtils.isEmpty(str) && C0716b.e().getBoolean(a(str), false) : invokeL.booleanValue;
    }

    public static void c(boolean z) {
        d.a.q0.a.a2.e i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65538, null, z) == null) || (i2 = d.a.q0.a.a2.e.i()) == null) {
            return;
        }
        C0716b.e().putBoolean(a(i2.D()), z);
    }
}
