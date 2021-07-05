package d.a.s0.v.d.c.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.alasquare.live_tab.view.OfficialRecommendLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends d.a.c.k.e.a<d.a.s0.v.d.c.e.c, OfficialRecommendLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public d.a.s0.v.d.c.h.b n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), d.a.s0.v.d.c.e.c.f67518f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public OfficialRecommendLiveViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            this.n = new d.a.s0.v.d.c.h.b(this.m, viewGroup);
            return new OfficialRecommendLiveViewHolder(this.n);
        }
        return (OfficialRecommendLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.s0.v.d.c.e.c cVar, OfficialRecommendLiveViewHolder officialRecommendLiveViewHolder) {
        InterceptResult invokeCommon;
        d.a.s0.v.d.c.h.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, cVar, officialRecommendLiveViewHolder})) == null) {
            if (officialRecommendLiveViewHolder == null || (bVar = officialRecommendLiveViewHolder.f14002a) == null) {
                return null;
            }
            bVar.m(cVar);
            officialRecommendLiveViewHolder.f14002a.n(this.m, TbadkCoreApplication.getInst().getSkinType());
            return officialRecommendLiveViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }
}
