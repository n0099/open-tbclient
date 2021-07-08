package d.a.p0.u0.q2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageLightCardView;
import com.baidu.tieba.frs.videomiddlepagelight.VideoMiddlePageViewModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.o0.r.q.b2;
import d.a.p0.g3.c;
import d.a.p0.u0.h1.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class b extends d.a.c.k.e.a<g, CardViewHolder<VideoMiddlePageLightCardView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<VideoMiddlePageLightCardView> m;
    public final TbPageContext<?> n;
    public final VideoMiddlePageViewModel o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, VideoMiddlePageViewModel videoMiddlePageViewModel) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, videoMiddlePageViewModel};
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
        this.n = tbPageContext;
        this.o = videoMiddlePageViewModel;
        this.m = new ArrayList();
    }

    public final void f0(g gVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, gVar, i2) == null) {
            StatisticItem statisticItem = new StatisticItem("c12590");
            statisticItem.param("tid", gVar != null ? gVar.f62849f : null);
            statisticItem.param("nid", gVar != null ? gVar.f62850g : null);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", i2);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            statisticItem.param("fid", gVar.f62848e);
            statisticItem.param("obj_param1", k.isEmpty(gVar.r) ? "0" : gVar.r);
            statisticItem.param("extra", k.isEmpty(gVar.s) ? "0" : gVar.s);
            statisticItem.param("obj_id", this.o.e());
            statisticItem.param("ab_tag", k.isEmpty(gVar.t) ? "0" : gVar.t);
            statisticItem.param("obj_type", this.o.d());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM5, gVar.h());
            statisticItem.param("obj_source", k.isEmpty(gVar.q) ? "0" : gVar.q);
            statisticItem.param(TiebaStatic.Params.IS_VERTICAL, gVar.j() ? 1 : 0);
            BaijiahaoData baijiahaoData = gVar.A;
            if (baijiahaoData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, baijiahaoData != null ? baijiahaoData.oriUgcNid : null);
                BaijiahaoData baijiahaoData2 = gVar.A;
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM6, baijiahaoData2 != null ? baijiahaoData2.oriUgcVid : null);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void g0(g gVar, b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048579, this, gVar, b2Var, i2) == null) {
            if (gVar == null) {
                Intrinsics.throwNpe();
            }
            c.g().d(this.n.getUniqueId(), d.a.p0.g3.a.c(gVar.f62849f, "", "", gVar.A), d.a.p0.g3.a.f(b2Var, "a023", "common_exp", i2 + 1, false, null, null));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public CardViewHolder<VideoMiddlePageLightCardView> Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            VideoMiddlePageLightCardView videoMiddlePageLightCardView = new VideoMiddlePageLightCardView(this.n, this.o);
            this.m.add(videoMiddlePageLightCardView);
            return new CardViewHolder<>(videoMiddlePageLightCardView);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: i0 */
    public View X(int i2, View view, ViewGroup viewGroup, g gVar, CardViewHolder<VideoMiddlePageLightCardView> cardViewHolder) {
        InterceptResult invokeCommon;
        VideoMiddlePageLightCardView b2;
        AgreeData d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            b2 c2 = g.c(gVar);
            if (gVar != null && (d2 = gVar.d()) != null) {
                d2.keyFromHomePage = this.o.d();
            }
            if (cardViewHolder != null && (b2 = cardViewHolder.b()) != null) {
                b2.W(gVar, i2);
            }
            g0(gVar, c2, i2);
            f0(gVar, i2);
            if (cardViewHolder != null) {
                return cardViewHolder.a();
            }
            return null;
        }
        return (View) invokeCommon.objValue;
    }

    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (VideoMiddlePageLightCardView videoMiddlePageLightCardView : this.m) {
                if (videoMiddlePageLightCardView != null) {
                    videoMiddlePageLightCardView.onDestroy();
                }
            }
        }
    }
}
