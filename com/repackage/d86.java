package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.faceshop.forumpackage.adapter.ForumEmotionEmptyViewHolder;
import com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionEmptyView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d86 extends wm<e86, ForumEmotionEmptyViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public a86 j;
    public f86 k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d86(TbPageContext<?> tbPageContext, f86 f86Var, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, f86Var, bdUniqueId};
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
        this.k = f86Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: Z */
    public ForumEmotionEmptyViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            ForumEmotionEmptyView forumEmotionEmptyView = new ForumEmotionEmptyView(this.i);
            forumEmotionEmptyView.b(TbadkCoreApplication.getInst().getSkinType());
            return new ForumEmotionEmptyViewHolder(this.i, forumEmotionEmptyView);
        }
        return (ForumEmotionEmptyViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, e86 e86Var, ForumEmotionEmptyViewHolder forumEmotionEmptyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, e86Var, forumEmotionEmptyViewHolder})) == null) {
            forumEmotionEmptyViewHolder.d(e86Var, i, this.k, this.j);
            return forumEmotionEmptyViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(a86 a86Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a86Var) == null) {
            this.j = a86Var;
        }
    }
}
