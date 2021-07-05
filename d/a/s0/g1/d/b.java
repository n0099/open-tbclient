package d.a.s0.g1.d;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.u0.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<d.a.c.k.e.a> f59717a;

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
        this.f59717a = new ArrayList();
        k kVar = (k) MessageManager.getInstance().runTask(2921336, k.class, tbPageContext).getData();
        if (kVar != null) {
            this.f59717a.add(kVar);
        }
        this.f59717a.add(new c(tbPageContext, b2.v3));
        this.f59717a.add(new a(tbPageContext, b2.w3));
        bdTypeRecyclerView.a(this.f59717a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.f59717a)) {
            return;
        }
        for (d.a.c.k.e.a aVar : this.f59717a) {
            if (aVar instanceof k) {
                ((k) aVar).s0(tbPageTag);
            }
        }
    }
}
