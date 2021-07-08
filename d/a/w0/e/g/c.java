package d.a.w0.e.g;

import android.content.Context;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.w0.e.f.d;
/* loaded from: classes8.dex */
public class c extends d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: h  reason: collision with root package name */
    public static String f68441h = "XMUnionID";

    /* renamed from: i  reason: collision with root package name */
    public static boolean f68442i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1305248677, "Ld/a/w0/e/g/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1305248677, "Ld/a/w0/e/g/c;");
                return;
            }
        }
        f68442i = d.a.w0.e.a.e();
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
        if (f68442i) {
            Log.e(f68441h, "xiaomi XMUnionID !!");
        }
        this.f68434d = "";
        this.f68432b = false;
        this.f68433c = false;
        this.f68437g = -200;
    }

    @Override // d.a.w0.e.f.c
    public d.a.w0.e.f.c d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                this.f68433c = d.i.b.a.b();
                this.f68434d = d.i.b.a.a(this.f68431a);
                this.f68437g = 0;
            } catch (Exception e2) {
                if (f68442i) {
                    Log.e(f68441h, "xiaomi init4UnionId error", e2);
                }
            }
            return this;
        }
        return (d.a.w0.e.f.c) invokeV.objValue;
    }
}
