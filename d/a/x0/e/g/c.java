package d.a.x0.e.g;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.x0.e.f.d;
/* loaded from: classes8.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f69119h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f69120i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1182264156, "Ld/a/x0/e/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1182264156, "Ld/a/x0/e/g/c;");
                return;
            }
        }
        f69120i = d.a.x0.e.a.e();
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
        if (f69120i) {
            Log.e(f69119h, "xiaomi XMUnionID !!");
        }
        this.f69112d = "";
        this.f69110b = false;
        this.f69111c = false;
        this.f69115g = -200;
    }

    @Override // d.a.x0.e.f.c
    public d.a.x0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f69111c = d.i.b.a.b();
                this.f69112d = d.i.b.a.a(this.f69109a);
                this.f69115g = 0;
            } catch (Exception e2) {
                if (f69120i) {
                    Log.e(f69119h, "xiaomi init4UnionId error", e2);
                }
            }
            return this;
        }
        return (d.a.x0.e.f.c) invokeV.objValue;
    }
}
