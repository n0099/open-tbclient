package com.repackage;

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
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ph7;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class kh7 extends bn<ph7, SearchSuggestRankingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes6.dex */
    public class a implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ kh7 b;

        public a(kh7 kh7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kh7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = kh7Var;
            this.a = context;
        }

        @Override // com.repackage.yn
        public void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            ph7 ph7Var;
            ph7.a b;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (onVar instanceof ph7) && (b = (ph7Var = (ph7) onVar).b()) != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("tab_id", b.d() + "");
                hashMap.put("sort_type", b.c() + "");
                hashMap.put("rank_type", b.b() + "");
                hashMap.put("rank_code", b.a() + "");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "ItemRecommendList", hashMap)));
                this.b.u(ph7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kh7(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ph7 ph7Var, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        w(i, view2, viewGroup, ph7Var, searchSuggestRankingViewHolder);
        return view2;
    }

    public final void t(StatisticItem statisticItem, ph7 ph7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, ph7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_name", ph7Var.c());
        }
    }

    public final void u(ph7 ph7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ph7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_CLICK);
            t(statisticItem, ph7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: v */
    public SearchSuggestRankingViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestRankingViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0788, viewGroup, false)) : (SearchSuggestRankingViewHolder) invokeL.objValue;
    }

    public View w(int i, View view2, ViewGroup viewGroup, ph7 ph7Var, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ph7Var, searchSuggestRankingViewHolder})) == null) {
            if (ph7Var == null) {
                return view2;
            }
            x(searchSuggestRankingViewHolder);
            WebPManager.setMaskDrawable(searchSuggestRankingViewHolder.c, R.drawable.obfuscated_res_0x7f080a47, null);
            fh7.a(searchSuggestRankingViewHolder.b, ph7Var.f(), ph7Var.a());
            y(ph7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void x(SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestRankingViewHolder) == null) {
            ms4 d = ms4.d(searchSuggestRankingViewHolder.b);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestRankingViewHolder.a, R.drawable.addresslist_item_bg);
            ms4.d(searchSuggestRankingViewHolder.d).f(R.color.CAM_X0203);
        }
    }

    public final void y(ph7 ph7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ph7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_SHOW);
            t(statisticItem, ph7Var);
            TiebaStatic.log(statisticItem);
        }
    }
}
