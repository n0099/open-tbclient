package com.repackage;

import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.nq4;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class ly8 implements nq4.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ ly8 a = new ly8();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ ly8() {
    }

    @Override // com.repackage.nq4.e
    public final void onClick(nq4 nq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
            WorkPublishActivity.o2(nq4Var);
        }
    }
}
