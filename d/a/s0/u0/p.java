package d.a.s0.u0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.s0.u0.e2.l f66709a;

    public p(TbPageContext tbPageContext, d.a.s0.u0.e2.l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, lVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66709a = lVar;
    }

    public void a(d.a.s0.e.d dVar) {
        d.a.s0.u0.e2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.f66709a) == null || lVar.d0() == null || this.f66709a.d0().d0() == null || this.f66709a.B0() == null || dVar == null || this.f66709a.B0().a0() == null || this.f66709a.Q() == null) {
            return;
        }
        BdTypeRecyclerView a0 = this.f66709a.B0().a0();
        int i2 = dVar.f58261a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                a0.removeHeaderView(dVar.a());
                this.f66709a.Q().d0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            a0.removeHeaderView(dVar.a());
            a0.t(dVar.a(), a0.getHeaderViewsCount() - 1);
            this.f66709a.Q().d0(8);
        }
    }
}
