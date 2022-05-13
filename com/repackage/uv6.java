package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.NoDataItemViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class uv6 extends eo<ap, NoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uv6(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), ap.c);
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
        this.i = 3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.repackage.eo
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, ap apVar, NoDataItemViewHolder noDataItemViewHolder) {
        a0(i, view2, viewGroup, apVar, noDataItemViewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.eo
    /* renamed from: Z */
    public NoDataItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0077, viewGroup, false);
            inflate.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            return new NoDataItemViewHolder(inflate);
        }
        return (NoDataItemViewHolder) invokeL.objValue;
    }

    public View a0(int i, View view2, ViewGroup viewGroup, ap apVar, NoDataItemViewHolder noDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, apVar, noDataItemViewHolder})) == null) {
            noDataItemViewHolder.a.setText(apVar.a);
            if (this.i != TbadkCoreApplication.getInst().getSkinType()) {
                SkinManager.setImageResource(noDataItemViewHolder.b, apVar.b);
                SkinManager.setViewTextColor(noDataItemViewHolder.a, (int) R.color.CAM_X0109);
                this.i = TbadkCoreApplication.getInst().getSkinType();
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
