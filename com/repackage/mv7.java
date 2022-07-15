package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbVideoDetailBrowseModeEmotionHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class mv7 extends du7<yr7, PbVideoDetailBrowseModeEmotionHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mv7(qy7 activity, BdUniqueId mType) {
        super(activity, mType);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, mType};
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
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mType, "mType");
    }

    public final View.OnClickListener b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.o : (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: c0 */
    public PbVideoDetailBrowseModeEmotionHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            View view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0877, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new PbVideoDetailBrowseModeEmotionHolder(view2);
        }
        return (PbVideoDetailBrowseModeEmotionHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: d0 */
    public void T(int i, ViewGroup viewGroup, PbVideoDetailBrowseModeEmotionHolder pbVideoDetailBrowseModeEmotionHolder, yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), viewGroup, pbVideoDetailBrowseModeEmotionHolder, yr7Var}) == null) {
            super.T(i, viewGroup, pbVideoDetailBrowseModeEmotionHolder, yr7Var);
            if (pbVideoDetailBrowseModeEmotionHolder == null) {
                return;
            }
            pbVideoDetailBrowseModeEmotionHolder.c();
            pbVideoDetailBrowseModeEmotionHolder.d(b0());
        }
    }

    public final void e0(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }
}
