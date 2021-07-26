package d.a.o0.u;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.u.c.c;
import d.a.o0.u.c.d;
import d.a.o0.u.c.e;
import d.a.o0.u.c.f;
import d.a.o0.u.c.g;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f51627c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final a<String> f51628a;

    /* renamed from: b  reason: collision with root package name */
    public String f51629b;

    public b(Context context) {
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
        a<String> aVar = new a<>();
        this.f51628a = aVar;
        if (context == null) {
            return;
        }
        aVar.a(new c(context));
        this.f51628a.a(new e(context));
        this.f51628a.a(new d(context));
        this.f51628a.a(new g(context));
        this.f51628a.a(new d.a.o0.u.c.a(context));
        this.f51628a.a(new f(context));
    }

    public static b b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f51627c == null) {
                synchronized (b.class) {
                    if (f51627c == null) {
                        f51627c = new b(context);
                    }
                }
            }
            return f51627c;
        }
        return (b) invokeL.objValue;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (TextUtils.isEmpty(this.f51629b)) {
                synchronized (this) {
                    if (TextUtils.isEmpty(this.f51629b)) {
                        String b2 = this.f51628a.b();
                        this.f51629b = b2;
                        this.f51628a.d(b2);
                    }
                }
            }
            return this.f51629b;
        }
        return (String) invokeV.objValue;
    }
}
