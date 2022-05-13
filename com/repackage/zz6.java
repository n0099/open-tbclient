package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HomeLocalCompleteInfoLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class zz6 extends eo<p07, AdapterViewHolder<HomeLocalCompleteInfoLayout>> implements sz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public View.OnClickListener j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zz6(TbPageContext tbPageContext, @Nullable View.OnClickListener onClickListener) {
        super(tbPageContext.getPageActivity(), p07.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, onClickListener};
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
        this.i = tbPageContext;
        this.j = onClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: Z */
    public AdapterViewHolder<HomeLocalCompleteInfoLayout> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new AdapterViewHolder<>(new HomeLocalCompleteInfoLayout(viewGroup.getContext())) : (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, p07 p07Var, AdapterViewHolder<HomeLocalCompleteInfoLayout> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, p07Var, adapterViewHolder})) == null) {
            if (p07Var == null || adapterViewHolder == null) {
                return null;
            }
            HomeLocalCompleteInfoLayout c = adapterViewHolder.c();
            c.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            c.setCloseClickListener(this.j);
            rz6.m();
            return adapterViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.repackage.sz6
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }
}
