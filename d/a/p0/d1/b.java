package d.a.p0.d1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import d.a.p0.e1.d.c;
import d.a.p0.n1.p.e;
/* loaded from: classes7.dex */
public class b implements d.a.p0.n1.s.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.d f54888a;

    public b(c.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54888a = dVar;
    }

    @Override // d.a.p0.n1.s.b
    public void a(boolean z, Message message, boolean z2, long j, String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), message, Boolean.valueOf(z2), Long.valueOf(j), str, Integer.valueOf(i2)}) == null) {
            d.a.p0.d1.c.a aVar = new d.a.p0.d1.c.a();
            e eVar = new e();
            eVar.f60669a = j;
            eVar.f60670b = str;
            d.a.p0.n1.p.a a2 = d.a.p0.n1.r.b.d().a(eVar);
            if (a2 != null) {
                a2.c(z, message, z2, i2);
            }
            aVar.c(a2);
            c.d dVar = this.f54888a;
            if (dVar != null) {
                dVar.e(z, aVar, z2, "", str, true);
            }
        }
    }

    @Override // d.a.p0.n1.s.b
    public void b(long j, String str, String str2, int i2) {
        c.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), str, str2, Integer.valueOf(i2)}) == null) || (dVar = this.f54888a) == null) {
            return;
        }
        dVar.c(str, str2, i2, true, 1);
    }

    @Override // d.a.p0.n1.s.b
    public void c(long j, String str, Message message, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), str, message, Boolean.valueOf(z)}) == null) {
        }
    }
}
