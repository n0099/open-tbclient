package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.AdapterViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.homepage.tabfeed.view.NearbyForumFriendCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class r07 extends an<jm7, AdapterViewHolder<NearbyForumFriendCardView>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext i;
    public AdapterViewHolder<NearbyForumFriendCardView> j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r07(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), jm7.d);
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
        this.i = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: Z */
    public AdapterViewHolder<NearbyForumFriendCardView> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder = new AdapterViewHolder<>(new NearbyForumFriendCardView(this.i.getPageActivity()));
            this.j = adapterViewHolder;
            return adapterViewHolder;
        }
        return (AdapterViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public View S(int i, View view2, ViewGroup viewGroup, jm7 jm7Var, AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jm7Var, adapterViewHolder})) == null) {
            NearbyForumFriendCardView b = adapterViewHolder.b();
            b.a(jm7Var);
            b.onChangeSkinType(this.i, TbadkCoreApplication.getInst().getSkinType());
            return adapterViewHolder.a();
        }
        return (View) invokeCommon.objValue;
    }

    public void b0(boolean z) {
        AdapterViewHolder<NearbyForumFriendCardView> adapterViewHolder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (adapterViewHolder = this.j) == null) {
            return;
        }
        adapterViewHolder.b().setNeedCompleteProfile(z);
    }
}
