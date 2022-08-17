package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbListAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nw7 extends aw7<ow7, PbListAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public et7 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nw7(s08 s08Var) {
        super(s08Var, ow7.o);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s08Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((s08) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: u */
    public PbListAlaRecommendVH onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbListAlaRecommendVH(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06bb, (ViewGroup) null), this.a.P()) : (PbListAlaRecommendVH) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.aw7, com.repackage.bn
    /* renamed from: v */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ow7 ow7Var, PbListAlaRecommendVH pbListAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ow7Var, pbListAlaRecommendVH})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, ow7Var, pbListAlaRecommendVH);
            if (ow7Var == null) {
                return null;
            }
            pbListAlaRecommendVH.b(ow7Var);
            pbListAlaRecommendVH.g(this.g);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void w(et7 et7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, et7Var) == null) {
            this.g = et7Var;
        }
    }
}
