package d.a.q0.v.e.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.frsgamelive.view.AlaGameFrsLiveDoubleView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class f extends d.a.d.k.e.a<d.a.q0.v.h.b.a, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public d.a.q0.v.c n;
    public String o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
    @Override // d.a.d.k.e.a
    /* renamed from: e0 */
    public AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AlaGameFrsLiveDoubleView alaGameFrsLiveDoubleView = new AlaGameFrsLiveDoubleView(this.m);
            alaGameFrsLiveDoubleView.t(this.o);
            return new AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder(alaGameFrsLiveDoubleView);
        }
        return (AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: f0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.q0.v.h.b.a aVar, AlaGameFrsLiveDoubleView.AlaGameFrsLiveDoubleViewHolder alaGameFrsLiveDoubleViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, alaGameFrsLiveDoubleViewHolder})) == null) {
            alaGameFrsLiveDoubleViewHolder.f14275a.l(aVar);
            alaGameFrsLiveDoubleViewHolder.f14275a.u(this.n);
            d.a.q0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f65411e.h1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, !StringUtils.isNull(aVar.f65411e.h1().appId) ? aVar.f65411e.h1().appId : ""));
            b2 b2Var = aVar.f65412f;
            if (b2Var != null) {
                d.a.q0.v.b.b().a(new StatisticItem("c12115").param("obj_id", aVar.f65412f.h1().live_id).param(TiebaStatic.Params.OBJ_PARAM3, StringUtils.isNull(b2Var.h1().appId) ? "" : aVar.f65412f.h1().appId));
            }
            return alaGameFrsLiveDoubleViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void g0(d.a.q0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.n = cVar;
        }
    }
}
