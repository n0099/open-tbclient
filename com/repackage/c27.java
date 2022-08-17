package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.HotTopicRankLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c27 extends bn<n27, AdapterViewHolder<HotTopicRankLayout>> implements o17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c27(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), px6.a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        this.a = tbPageContext;
    }

    @Override // com.repackage.o17
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.b = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: s */
    public AdapterViewHolder<HotTopicRankLayout> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new AdapterViewHolder<>(new HotTopicRankLayout(viewGroup.getContext())) : (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n27 n27Var, AdapterViewHolder<HotTopicRankLayout> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n27Var, adapterViewHolder})) == null) {
            if (n27Var == null || adapterViewHolder == null) {
                return null;
            }
            HotTopicRankLayout a = adapterViewHolder.a();
            a.setTabCode(this.b);
            a.a(n27Var);
            a.onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
            return adapterViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void u(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, unVar) == null) {
        }
    }
}
