package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.manito.ManitoHeaderItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ha6 extends pc6<ia6, ManitoHeaderItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ha6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.pc6, com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        m0(i, view2, viewGroup, (ia6) obj, (ManitoHeaderItemViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: l0 */
    public ManitoHeaderItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new ManitoHeaderItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0529, (ViewGroup) null)) : (ManitoHeaderItemViewHolder) invokeL.objValue;
    }

    public View m0(int i, View view2, ViewGroup viewGroup, ia6 ia6Var, ManitoHeaderItemViewHolder manitoHeaderItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ia6Var, manitoHeaderItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, ia6Var, manitoHeaderItemViewHolder);
            if (manitoHeaderItemViewHolder.b != this.n) {
                SkinManager.setBackgroundColor(manitoHeaderItemViewHolder.b(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(manitoHeaderItemViewHolder.a, R.color.CAM_X0105, 1);
            }
            manitoHeaderItemViewHolder.a.setText(String.format(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0676), Integer.valueOf(ia6Var.a())));
            manitoHeaderItemViewHolder.b = this.n;
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
