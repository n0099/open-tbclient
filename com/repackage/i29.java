package com.repackage;

import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.cr4;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class i29 implements cr4.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ i29 a = new i29();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ i29() {
    }

    @Override // com.repackage.cr4.e
    public final void onClick(cr4 cr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
            WorkPublishActivity.m77showLocPermissionDialog$lambda21(cr4Var);
        }
    }
}
