package d.a.p0.u0;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.u0.e2.l f63490a;

    public p(TbPageContext tbPageContext, d.a.p0.u0.e2.l lVar) {
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
        this.f63490a = lVar;
    }

    public void a(d.a.p0.e.d dVar) {
        d.a.p0.u0.e2.l lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) || (lVar = this.f63490a) == null || lVar.d0() == null || this.f63490a.d0().d0() == null || this.f63490a.B0() == null || dVar == null || this.f63490a.B0().b0() == null || this.f63490a.Q() == null) {
            return;
        }
        BdTypeRecyclerView b0 = this.f63490a.B0().b0();
        int i2 = dVar.f55006a;
        if (i2 != 2) {
            if (i2 == 3 && dVar.a() != null) {
                b0.removeHeaderView(dVar.a());
                this.f63490a.Q().d0(0);
            }
        } else if (dVar.a() == null) {
        } else {
            b0.removeHeaderView(dVar.a());
            b0.t(dVar.a(), b0.getHeaderViewsCount() - 1);
            this.f63490a.Q().d0(8);
        }
    }
}
