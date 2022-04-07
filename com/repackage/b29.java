package com.repackage;

import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.dr4;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class b29 implements dr4.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ b29 a = new b29();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ b29() {
    }

    @Override // com.repackage.dr4.e
    public final void onClick(dr4 dr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
            WorkPublishActivity.m77showLocPermissionDialog$lambda21(dr4Var);
        }
    }
}
