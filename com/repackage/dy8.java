package com.repackage;

import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dq4;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class dy8 implements dq4.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ dy8 a = new dy8();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ dy8() {
    }

    @Override // com.repackage.dq4.e
    public final void onClick(dq4 dq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
            WorkPublishActivity.m77showLocPermissionDialog$lambda22(dq4Var);
        }
    }
}
