package d.a.q0.s1.h.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestRankingViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.d.k.e.w;
import d.a.q0.h3.h0.m;
import d.a.q0.s1.h.e.e;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class e extends d.a.d.k.e.a<d.a.q0.s1.h.e.e, SearchSuggestRankingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context m;

    /* loaded from: classes8.dex */
    public class a implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f62764e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ e f62765f;

        public a(e eVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62765f = eVar;
            this.f62764e = context;
        }

        @Override // d.a.d.k.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            d.a.q0.s1.h.e.e eVar;
            e.a c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.q0.s1.h.e.e) && (c2 = (eVar = (d.a.q0.s1.h.e.e) nVar).c()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("tab_id", c2.d() + "");
                hashMap.put("sort_type", c2.c() + "");
                hashMap.put("rank_type", c2.b() + "");
                hashMap.put("rank_code", c2.a() + "");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(this.f62764e, "ItemRecommendList", hashMap)));
                this.f62765f.g0(eVar);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.m = context;
        this.f42344h = bdUniqueId;
        a0(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.e eVar, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        j0(i2, view, viewGroup, eVar, searchSuggestRankingViewHolder);
        return view;
    }

    public final void f0(StatisticItem statisticItem, d.a.q0.s1.h.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, eVar) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_name", eVar.d());
        }
    }

    public final void g0(d.a.q0.s1.h.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_CLICK);
            f0(statisticItem, eVar);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: i0 */
    public SearchSuggestRankingViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestRankingViewHolder(LayoutInflater.from(this.m).inflate(R.layout.search_suggest_ranking_item, viewGroup, false)) : (SearchSuggestRankingViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view, ViewGroup viewGroup, d.a.q0.s1.h.e.e eVar, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, searchSuggestRankingViewHolder})) == null) {
            if (eVar == null) {
                return view;
            }
            k0(searchSuggestRankingViewHolder);
            WebPManager.setMaskDrawable(searchSuggestRankingViewHolder.f18527c, R.drawable.icon_search_chart, null);
            d.a.q0.s1.h.c.a(searchSuggestRankingViewHolder.f18526b, eVar.e(), eVar.b());
            l0(eVar);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void k0(SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestRankingViewHolder) == null) {
            d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(searchSuggestRankingViewHolder.f18526b);
            d2.t(R.color.CAM_X0105);
            d2.x(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestRankingViewHolder.f18525a, R.drawable.addresslist_item_bg);
            d.a.p0.s.u.c.d(searchSuggestRankingViewHolder.f18528d).f(R.color.CAM_X0203);
        }
    }

    public final void l0(d.a.q0.s1.h.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, eVar) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_SHOW);
            f0(statisticItem, eVar);
            TiebaStatic.log(statisticItem);
        }
    }
}
