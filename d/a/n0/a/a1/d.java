package d.a.n0.a.a1;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a1.g;
import d.a.n0.a.f1.g.b;
import d.a.n0.a.k;
import java.io.IOException;
import java.nio.channels.Pipe;
/* loaded from: classes7.dex */
public class d extends g.f {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f43315h;

    /* renamed from: i  reason: collision with root package name */
    public final d.a.n0.n.f.d f43316i;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(700040608, "Ld/a/n0/a/a1/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(700040608, "Ld/a/n0/a/a1/d;");
                return;
            }
        }
        j = k.f45831a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, d.a.n0.n.f.d dVar) {
        super("check_sign");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, dVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f43315h = str;
        this.f43316i = dVar;
    }

    @Override // d.a.n0.a.a1.g.f
    public boolean f(Pipe.SourceChannel sourceChannel, Bundle bundle) {
        InterceptResult invokeLL;
        d.a.n0.a.q2.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sourceChannel, bundle)) == null) {
            d.a.n0.a.f1.g.a d2 = d.a.n0.a.f1.g.a.d(bundle.getString("launch_id"));
            b.C0703b e2 = d2.e();
            e2.b("SignChecker");
            e2.d(1);
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    aVar = d.a.n0.a.h0.m.r.a.a(sourceChannel, this.f43315h, this.f43316i);
                } catch (IOException e3) {
                    if (j) {
                        e3.printStackTrace();
                    }
                    d.a.n0.a.q2.a aVar2 = new d.a.n0.a.q2.a();
                    aVar2.j(11L);
                    aVar2.h(2300L);
                    aVar2.e("inputStream IOException:" + e3.toString());
                    d.a.n0.a.q2.e.a().f(aVar2);
                    d2.g("SignChecker", aVar2.toString());
                    d.a.n0.a.v2.c1.b.a(sourceChannel);
                    aVar = aVar2;
                }
                d2.g("SignChecker", "Cost: " + (System.currentTimeMillis() - currentTimeMillis));
                boolean z = aVar == null;
                if (aVar != null) {
                    d2.g("SignChecker", aVar.toString());
                    b().putLong("result_error_code", aVar.a());
                }
                d2.g("SignChecker", "done: " + z);
                return z;
            } finally {
                d.a.n0.a.v2.c1.b.a(sourceChannel);
            }
        }
        return invokeLL.booleanValue;
    }
}
