package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestItemViewHolder;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ld7 extends wm<qd7, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes6.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ ld7 b;

        public a(ld7 ld7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ld7Var;
            this.a = context;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof qd7)) {
                HashMap hashMap = new HashMap();
                StringBuilder sb = new StringBuilder();
                qd7 qd7Var = (qd7) jnVar;
                sb.append(qd7Var.b());
                sb.append("");
                hashMap.put("itemID", sb.toString());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "GameItemDetailsPage", hashMap)));
                this.b.b0(qd7Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ld7(Context context, BdUniqueId bdUniqueId) {
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
    @Override // com.repackage.wm
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, qd7 qd7Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        d0(i, view2, viewGroup, qd7Var, searchSuggestItemViewHolder);
        return view2;
    }

    public final void a0(StatisticItem statisticItem, qd7 qd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, statisticItem, qd7Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", qd7Var.b().longValue());
        }
    }

    public final void b0(qd7 qd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qd7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            a0(statisticItem, qd7Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: c0 */
    public SearchSuggestItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new SearchSuggestItemViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0738, viewGroup, false)) : (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    public View d0(int i, View view2, ViewGroup viewGroup, qd7 qd7Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view2, viewGroup, qd7Var, searchSuggestItemViewHolder})) == null) {
            if (qd7Var == null) {
                return view2;
            }
            e0(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.b.setConrers(15);
            searchSuggestItemViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.b.K(qd7Var.a(), 10, false);
            searchSuggestItemViewHolder.c.setText(qd7Var.e());
            searchSuggestItemViewHolder.f.setStarSpacing(li.f(this.i, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.f.setStarCount(qd7Var.g().intValue());
            TextView textView = searchSuggestItemViewHolder.d;
            StringBuilder sb = new StringBuilder();
            sb.append(qd7Var.f());
            String str = "";
            sb.append("");
            textView.setText(sb.toString());
            if (qd7Var.i() != null) {
                for (String str2 : qd7Var.i()) {
                    if (!StringUtils.isNull(str2)) {
                        if (!StringUtils.isNull(str)) {
                            str2 = str + " " + str2;
                        }
                        str = str2;
                    }
                }
            }
            searchSuggestItemViewHolder.e.setText(str);
            f0(qd7Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void e0(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, searchSuggestItemViewHolder) == null) {
            wq4 d = wq4.d(searchSuggestItemViewHolder.c);
            d.A(R.string.F_X02);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            wq4 d2 = wq4.d(searchSuggestItemViewHolder.d);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X09);
            wq4 d3 = wq4.d(searchSuggestItemViewHolder.e);
            d3.v(R.color.CAM_X0108);
            d3.z(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.a, R.drawable.addresslist_item_bg);
            wq4.d(searchSuggestItemViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void f0(qd7 qd7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, qd7Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            a0(statisticItem, qd7Var);
            TiebaStatic.log(statisticItem);
        }
    }
}
