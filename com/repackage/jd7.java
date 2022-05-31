package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseActivity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestCommonViewHolder;
import com.baidu.tieba.postsearch.PostSearchActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jd7 extends wm<od7, SearchSuggestCommonViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context i;

    /* loaded from: classes6.dex */
    public class a implements tn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(jd7 jd7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof od7)) {
                od7 od7Var = (od7) jnVar;
                String a = od7Var.a();
                String b = od7Var.b();
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921595, b);
                Context context = this.a;
                if (context != null && (context instanceof BdBaseActivity)) {
                    customResponsedMessage.setmOrginalMessage(new CustomMessage(2921595, ((BdBaseActivity) context).getUniqueId()));
                }
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                TiebaStatic.eventStat(this.a, "search_bar_result_click", "click", 1, new Object[0]);
                TiebaStatic.log(new StatisticItem(PostSearchActivity.FORUM_SEARCH_CLICK).param("obj_name", a).param("obj_source", "2").param("obj_type", "1").param("obj_locate", i + 1).param("obj_param1", b));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jd7(Context context, BdUniqueId bdUniqueId) {
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
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, od7 od7Var, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        a0(i, view2, viewGroup, od7Var, searchSuggestCommonViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: Z */
    public SearchSuggestCommonViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new SearchSuggestCommonViewHolder(LayoutInflater.from(this.i).inflate(R.layout.obfuscated_res_0x7f0d0735, viewGroup, false)) : (SearchSuggestCommonViewHolder) invokeL.objValue;
    }

    public View a0(int i, View view2, ViewGroup viewGroup, od7 od7Var, SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, od7Var, searchSuggestCommonViewHolder})) == null) {
            if (od7Var == null) {
                return view2;
            }
            b0(searchSuggestCommonViewHolder);
            WebPManager.setPureDrawable(searchSuggestCommonViewHolder.c, R.drawable.obfuscated_res_0x7f080a35, R.color.CAM_X0109, null);
            id7.a(searchSuggestCommonViewHolder.b, od7Var.b(), od7Var.a());
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void b0(SearchSuggestCommonViewHolder searchSuggestCommonViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, searchSuggestCommonViewHolder) == null) {
            wq4 d = wq4.d(searchSuggestCommonViewHolder.b);
            d.v(R.color.CAM_X0105);
            d.z(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestCommonViewHolder.a, R.drawable.addresslist_item_bg);
            wq4.d(searchSuggestCommonViewHolder.d).f(R.color.CAM_X0203);
        }
    }
}
