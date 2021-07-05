package d.a.q0.f.j.n;

import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class i implements d.a.q0.f.j.p.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f52860a;

    public i(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52860a = fVar;
    }

    @Override // d.a.q0.f.j.p.a
    public void a(d.a.q0.f.j.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            b(aVar);
        }
    }

    public final void b(d.a.q0.f.j.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f52860a.f51200d.clear();
            if (aVar != null) {
                this.f52860a.f51200d.putString("functionType", aVar.a());
                this.f52860a.f51200d.putString("resultData", aVar.b());
                this.f52860a.f51200d.putInt(l.f1990a, aVar.c());
            }
            this.f52860a.c();
        }
    }
}
