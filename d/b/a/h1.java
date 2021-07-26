package d.b.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public abstract class h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final j1 f69235a;

    /* renamed from: b  reason: collision with root package name */
    public int f69236b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69237c;

    public h1(j1 j1Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69236b = 0;
        this.f69235a = j1Var;
    }

    public abstract boolean a();

    public abstract long b();

    public abstract long[] c();

    public abstract boolean d();

    public abstract String e();

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f69237c = true;
        }
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69237c : invokeV.booleanValue;
    }

    public final long h() {
        InterceptResult invokeV;
        boolean z;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!a() || e0.a(this.f69235a.f())) {
                long b2 = b();
                long currentTimeMillis = System.currentTimeMillis();
                if (b2 <= 1000 + currentTimeMillis) {
                    try {
                        z = d();
                    } catch (Exception e2) {
                        h0.b(e2);
                        z = false;
                    }
                    if (z) {
                        this.f69236b = 0;
                        j = b() - System.currentTimeMillis();
                    } else {
                        long[] c2 = c();
                        int i2 = this.f69236b;
                        this.f69236b = i2 + 1;
                        j = c2[i2 % c2.length];
                    }
                    h0.e(e() + " worked:" + z + " " + j, null);
                    return j;
                }
                return b2 - currentTimeMillis;
            }
            return 60000L;
        }
        return invokeV.longValue;
    }
}
