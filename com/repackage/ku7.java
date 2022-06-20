package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.adapter.PbNoDataItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ku7 extends lt7<br7, PbNoDataItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ku7(wx7 wx7Var, BdUniqueId bdUniqueId) {
        super(wx7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wx7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((wx7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.lt7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, (br7) obj, (PbNoDataItemViewHolder) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public PbNoDataItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbNoDataItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0677, viewGroup, false), this.a) : (PbNoDataItemViewHolder) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, br7 br7Var, PbNoDataItemViewHolder pbNoDataItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, br7Var, pbNoDataItemViewHolder})) == null) {
            super.S(i, view2, viewGroup, br7Var, pbNoDataItemViewHolder);
            this.l = TbadkCoreApplication.getInst().getSkinType();
            pbNoDataItemViewHolder.a.setText(br7Var.H0);
            int i2 = br7Var.G0;
            if (i2 != 0) {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, i2);
            } else {
                SkinManager.setImageResource(pbNoDataItemViewHolder.b, R.drawable.new_pic_emotion_06);
            }
            SkinManager.setViewTextColor(pbNoDataItemViewHolder.a, (int) R.color.CAM_X0109);
            if (br7Var.I0 != 0 && view2.getLayoutParams() != null) {
                view2.getLayoutParams().height = br7Var.I0;
            }
            if (br7Var.J0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.b.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, br7Var.J0, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            if (br7Var.K0 != 0) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbNoDataItemViewHolder.a.getLayoutParams();
                int i3 = marginLayoutParams2.leftMargin;
                marginLayoutParams2.setMargins(i3, i3, marginLayoutParams2.rightMargin, br7Var.K0);
            }
            pbNoDataItemViewHolder.b.setVisibility(br7Var.L0);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
