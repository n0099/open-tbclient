package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nf7 extends an<sf7, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes6.dex */
    public class a implements xn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ nf7 b;

        public a(nf7 nf7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nf7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = nf7Var;
            this.a = context;
        }

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof sf7)) {
                sf7 sf7Var = (sf7) nnVar;
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(sf7Var.c(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
                createNormalCfg.setCallFrom(16);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                this.b.b0(sf7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nf7(Context context, BdUniqueId bdUniqueId) {
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
        this.i = context;
        this.d = bdUniqueId;
        V(new a(this, context));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, sf7 sf7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        d0(i, view2, viewGroup, sf7Var, searchSuggestForumViewHolder);
        return view2;
    }

    public final void a0(StatisticItem statisticItem, sf7 sf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, sf7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", sf7Var.b().longValue());
            statisticItem.param("fname", sf7Var.c());
        }
    }

    public final void b0(sf7 sf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sf7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            a0(statisticItem, sf7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public SearchSuggestForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestForumViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0753, viewGroup, false)) : (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, sf7 sf7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, sf7Var, searchSuggestForumViewHolder})) == null) {
            if (sf7Var == null) {
                return view2;
            }
            e0(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.b.setConrers(15);
            searchSuggestForumViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.b.J(sf7Var.a(), 10, false);
            searchSuggestForumViewHolder.c.setText(sf7Var.c() + this.i.getString(R.string.obfuscated_res_0x7f0f0650));
            if (!StringUtils.isNull(sf7Var.g())) {
                searchSuggestForumViewHolder.d.setText(this.i.getString(R.string.obfuscated_res_0x7f0f10c4, sf7Var.g()));
            } else {
                Context context = this.i;
                searchSuggestForumViewHolder.d.setText(context.getString(R.string.obfuscated_res_0x7f0f10c4, context.getString(R.string.obfuscated_res_0x7f0f10c5)));
            }
            searchSuggestForumViewHolder.e.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f041a), StringHelper.numberUniformFormatExtraWithRoundInt(sf7Var.d().intValue())));
            searchSuggestForumViewHolder.f.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f06b9), StringHelper.numberUniformFormatExtraWithRoundInt(sf7Var.h().intValue())));
            f0(sf7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            ur4 d = ur4.d(searchSuggestForumViewHolder.c);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X06);
            d.v(R.color.CAM_X0105);
            ur4 d2 = ur4.d(searchSuggestForumViewHolder.d);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0108);
            ur4 d3 = ur4.d(searchSuggestForumViewHolder.e);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            ur4 d4 = ur4.d(searchSuggestForumViewHolder.f);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            ur4.d(searchSuggestForumViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void f0(sf7 sf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, sf7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            a0(statisticItem, sf7Var);
            TiebaStatic.log(statisticItem);
        }
    }
}
