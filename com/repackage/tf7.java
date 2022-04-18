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
/* loaded from: classes7.dex */
public class tf7 extends ho<yf7, SearchSuggestForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes7.dex */
    public class a implements dp {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ tf7 b;

        public a(tf7 tf7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tf7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tf7Var;
            this.a = context;
        }

        @Override // com.repackage.dp
        public void b(View view2, uo uoVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, uoVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (uoVar instanceof yf7)) {
                yf7 yf7Var = (yf7) uoVar;
                FrsActivityConfig createNormalCfg = new FrsActivityConfig(this.a).createNormalCfg(yf7Var.e(), FrsActivityConfig.FRS_FROM_SEARCH_SUG);
                createNormalCfg.setCallFrom(16);
                MessageManager.getInstance().sendMessage(new CustomMessage(2003000, createNormalCfg));
                this.b.b0(yf7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tf7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.ho
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, yf7 yf7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        d0(i, view2, viewGroup, yf7Var, searchSuggestForumViewHolder);
        return view2;
    }

    public final void a0(StatisticItem statisticItem, yf7 yf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, yf7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", yf7Var.b().longValue());
            statisticItem.param("fname", yf7Var.e());
        }
    }

    public final void b0(yf7 yf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yf7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_CLICK);
            a0(statisticItem, yf7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: c0 */
    public SearchSuggestForumViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestForumViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d074c, viewGroup, false)) : (SearchSuggestForumViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, yf7 yf7Var, SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, yf7Var, searchSuggestForumViewHolder})) == null) {
            if (yf7Var == null) {
                return view2;
            }
            e0(searchSuggestForumViewHolder);
            searchSuggestForumViewHolder.b.setConrers(15);
            searchSuggestForumViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestForumViewHolder.b.K(yf7Var.a(), 10, false);
            searchSuggestForumViewHolder.c.setText(yf7Var.e() + this.i.getString(R.string.obfuscated_res_0x7f0f0643));
            if (!StringUtils.isNull(yf7Var.g())) {
                searchSuggestForumViewHolder.d.setText(this.i.getString(R.string.obfuscated_res_0x7f0f109a, yf7Var.g()));
            } else {
                Context context = this.i;
                searchSuggestForumViewHolder.d.setText(context.getString(R.string.obfuscated_res_0x7f0f109a, context.getString(R.string.obfuscated_res_0x7f0f109b)));
            }
            searchSuggestForumViewHolder.e.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f0415), StringHelper.numberUniformFormatExtraWithRoundInt(yf7Var.f().intValue())));
            searchSuggestForumViewHolder.f.setText(String.format(this.i.getString(R.string.obfuscated_res_0x7f0f06ab), StringHelper.numberUniformFormatExtraWithRoundInt(yf7Var.i().intValue())));
            f0(yf7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(SearchSuggestForumViewHolder searchSuggestForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestForumViewHolder) == null) {
            vr4 d = vr4.d(searchSuggestForumViewHolder.c);
            d.A(R.string.F_X02);
            d.z(R.dimen.T_X06);
            d.v(R.color.CAM_X0105);
            vr4 d2 = vr4.d(searchSuggestForumViewHolder.d);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0108);
            vr4 d3 = vr4.d(searchSuggestForumViewHolder.e);
            d3.z(R.dimen.T_X09);
            d3.v(R.color.CAM_X0108);
            vr4 d4 = vr4.d(searchSuggestForumViewHolder.f);
            d4.z(R.dimen.T_X09);
            d4.v(R.color.CAM_X0108);
            SkinManager.setBackgroundResource(searchSuggestForumViewHolder.a, R.drawable.addresslist_item_bg);
            vr4.d(searchSuggestForumViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void f0(yf7 yf7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, yf7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_FORUM_SHOW);
            a0(statisticItem, yf7Var);
            TiebaStatic.log(statisticItem);
        }
    }
}
