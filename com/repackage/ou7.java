package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbImageAlaRecommendVH;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ou7 extends du7<pu7, PbImageAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId o;
    public jr7 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ou7(qy7 qy7Var, BdUniqueId bdUniqueId) {
        super(qy7Var, pu7.q);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = bdUniqueId;
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        c0(i, view2, viewGroup, (pu7) obj, (PbImageAlaRecommendVH) viewHolder);
        return view2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public PbImageAlaRecommendVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbImageAlaRecommendVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0683, viewGroup, false), this.i.getPageContext(), this.o) : (PbImageAlaRecommendVH) invokeL.objValue;
    }

    public View c0(int i, View view2, ViewGroup viewGroup, pu7 pu7Var, PbImageAlaRecommendVH pbImageAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pu7Var, pbImageAlaRecommendVH})) == null) {
            super.S(i, view2, viewGroup, pu7Var, pbImageAlaRecommendVH);
            if (pbImageAlaRecommendVH != null) {
                pbImageAlaRecommendVH.e(pu7Var);
                pbImageAlaRecommendVH.j(this.p);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jr7Var) == null) {
            this.p = jr7Var;
        }
    }
}
