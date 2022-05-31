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
/* loaded from: classes7.dex */
public class rs7 extends es7<ss7, PbListAlaRecommendVH> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kp7 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rs7(pw7 pw7Var) {
        super(pw7Var, ss7.o);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pw7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((pw7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wm
    /* renamed from: b0 */
    public PbListAlaRecommendVH M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new PbListAlaRecommendVH(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0673, (ViewGroup) null), this.i.w()) : (PbListAlaRecommendVH) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.es7, com.repackage.wm
    /* renamed from: c0 */
    public View S(int i, View view2, ViewGroup viewGroup, ss7 ss7Var, PbListAlaRecommendVH pbListAlaRecommendVH) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ss7Var, pbListAlaRecommendVH})) == null) {
            super.S(i, view2, viewGroup, ss7Var, pbListAlaRecommendVH);
            if (ss7Var == null) {
                return null;
            }
            pbListAlaRecommendVH.d(ss7Var);
            pbListAlaRecommendVH.i(this.o);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void d0(kp7 kp7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, kp7Var) == null) {
            this.o = kp7Var;
        }
    }
}
