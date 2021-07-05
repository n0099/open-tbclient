package d.a.z0.e;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f71611b = "UnionIDFactory";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f71612c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.z0.e.f.c f71613a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(372887125, "Ld/a/z0/e/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(372887125, "Ld/a/z0/e/d;");
                return;
            }
        }
        f71612c = a.e();
    }

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        int a2 = b.a();
        if (f71612c) {
            String str = f71611b;
            Log.e(str, "UnionIDFactory manufacturer:" + a2);
        }
        if (a2 == 10001) {
            this.f71613a = new d.a.z0.e.g.a(context);
        } else if (a2 != 10002) {
            this.f71613a = new d.a.z0.e.g.b(context);
        } else {
            if (f71612c) {
                Log.e(f71611b, "UnionIDFactory XMUnionID");
            }
            this.f71613a = new d.a.z0.e.g.c(context);
        }
    }

    public d.a.z0.e.f.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f71613a : (d.a.z0.e.f.c) invokeV.objValue;
    }
}
