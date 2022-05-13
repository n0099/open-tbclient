package com.repackage;

import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.repackage.nr4;
/* compiled from: lambda */
/* loaded from: classes5.dex */
public final /* synthetic */ class d19 implements nr4.e {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ d19 a = new d19();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ d19() {
    }

    @Override // com.repackage.nr4.e
    public final void onClick(nr4 nr4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
            WorkPublishActivity.m78showLocPermissionDialog$lambda21(nr4Var);
        }
    }
}
