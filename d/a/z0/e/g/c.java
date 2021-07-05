package d.a.z0.e.g;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.z0.e.f.d;
/* loaded from: classes10.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f71638h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f71639i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1862322526, "Ld/a/z0/e/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1862322526, "Ld/a/z0/e/g/c;");
                return;
            }
        }
        f71639i = d.a.z0.e.a.e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (f71639i) {
            Log.e(f71638h, "xiaomi XMUnionID !!");
        }
        this.f71631d = "";
        this.f71629b = false;
        this.f71630c = false;
        this.f71634g = -200;
    }

    @Override // d.a.z0.e.f.c
    public d.a.z0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f71630c = d.i.b.a.b();
                this.f71631d = d.i.b.a.a(this.f71628a);
                this.f71634g = 0;
            } catch (Exception e2) {
                if (f71639i) {
                    Log.e(f71638h, "xiaomi init4UnionId error", e2);
                }
            }
            return this;
        }
        return (d.a.z0.e.f.c) invokeV.objValue;
    }
}
