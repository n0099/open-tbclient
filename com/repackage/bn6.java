package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: LikeSign.java */
/* loaded from: classes5.dex */
public final /* synthetic */ class bn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@NonNull TBSpecificationBtn tBSpecificationBtn) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, tBSpecificationBtn) == null) && UbsABTestHelper.isFrsModifyABTestA()) {
            Object tag = tBSpecificationBtn.getTag(R.id.obfuscated_res_0x7f090f62);
            if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
                xt4 xt4Var = (xt4) tBSpecificationBtn.getStyleConfig();
                xt4Var.t(R.color.CAM_X0105);
                tBSpecificationBtn.setConfig(xt4Var);
            }
        }
    }
}
