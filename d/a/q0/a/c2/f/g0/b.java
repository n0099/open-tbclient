package d.a.q0.a.c2.f.g0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.a2.e;
import d.a.q0.a.a2.h;
import d.a.q0.a.a2.i;
import d.a.q0.a.a2.k;
/* loaded from: classes8.dex */
public class b extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public String f46966h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(h hVar) {
        super(hVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.g0.a
    public void e(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && i() && (str2 = this.f46966h) != null && str2.equals(str)) {
            d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
            if (g2.C()) {
                if (g2.r().d0()) {
                    g2.o("flag_finish_activity", "flag_remove_task");
                    return;
                }
                d.a.q0.a.q2.a aVar = new d.a.q0.a.q2.a();
                aVar.j(10L);
                aVar.h(2107L);
                aVar.c("app forbidden");
                k.k0(d.a.q0.n.g.a.h().s(str), d.a.q0.a.c1.a.b(), g2.r().L(), false, null, aVar);
            }
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (e.Q() == null || this.f46964f == 0) ? false : true : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a.v2.e1.b
    /* renamed from: j */
    public void onCallback(i.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (d.a.q0.a.v1.b.c.f(aVar.C(), "swan_forbidden_kill_on_client")) {
                this.f46964f = aVar.j("ipc_forbidden_flag", 1);
                this.f46966h = aVar.o("mAppId", d.a.q0.a.a2.d.g().getAppId());
            }
            if (d.a.q0.a.v1.b.c.f(aVar.C(), "swan_kill_to_client")) {
                d.a.q0.a.a2.d.g().o("flag_finish_activity", "flag_remove_task");
            }
        }
    }
}
