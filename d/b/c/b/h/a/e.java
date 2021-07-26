package d.b.c.b.h.a;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    public static volatile e f69433e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f69434a;

    /* renamed from: b  reason: collision with root package name */
    public Map<com.bytedance.tea.crash.c, c> f69435b;

    /* renamed from: c  reason: collision with root package name */
    public b f69436c;

    /* renamed from: d  reason: collision with root package name */
    public d f69437d;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f69438a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1846404907, "Ld/b/c/b/h/a/e$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1846404907, "Ld/b/c/b/h/a/e$a;");
                    return;
                }
            }
            int[] iArr = new int[com.bytedance.tea.crash.c.values().length];
            f69438a = iArr;
            try {
                iArr[com.bytedance.tea.crash.c.f32566b.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f69438a[com.bytedance.tea.crash.c.f32568d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f69438a[com.bytedance.tea.crash.c.f32572h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69435b = new HashMap();
        this.f69434a = context;
        this.f69436c = new b(context);
        this.f69437d = new d(this.f69434a);
    }

    public static e c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f69433e != null) {
                return f69433e;
            }
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return (e) invokeV.objValue;
    }

    public static void d(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, context) == null) && f69433e == null) {
            f69433e = new e(context);
        }
    }

    public d.b.c.b.e.a a(com.bytedance.tea.crash.c cVar, d.b.c.b.e.a aVar) {
        InterceptResult invokeLL;
        c b2;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cVar, aVar)) == null) ? (cVar == null || (b2 = b(cVar)) == null) ? aVar : b2.a(aVar) : (d.b.c.b.e.a) invokeLL.objValue;
    }

    @Nullable
    public final c b(com.bytedance.tea.crash.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar)) == null) {
            c cVar2 = this.f69435b.get(cVar);
            if (cVar2 != null) {
                return cVar2;
            }
            int i2 = a.f69438a[cVar.ordinal()];
            if (i2 == 1) {
                cVar2 = new g(this.f69434a, this.f69436c, this.f69437d);
            } else if (i2 == 2) {
                cVar2 = new d.b.c.b.h.a.a(this.f69434a, this.f69436c, this.f69437d);
            } else if (i2 == 3) {
                cVar2 = new f(this.f69434a, this.f69436c, this.f69437d);
            }
            if (cVar2 != null) {
                this.f69435b.put(cVar, cVar2);
            }
            return cVar2;
        }
        return (c) invokeL.objValue;
    }
}
