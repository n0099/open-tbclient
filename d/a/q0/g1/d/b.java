package d.a.q0.g1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
import d.a.q0.u0.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.d.k.e.a> f57003a;

    public b(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f57003a = new ArrayList();
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f57003a.add(kVar);
        }
        this.f57003a.add(new c(tbPageContext, b2.B3));
        this.f57003a.add(new a(tbPageContext, b2.C3));
        bdTypeRecyclerView.a(this.f57003a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.f57003a)) {
            return;
        }
        for (d.a.d.k.e.a aVar : this.f57003a) {
            if (aVar instanceof k) {
                ((k) aVar).p0(tbPageTag);
            }
        }
    }
}
