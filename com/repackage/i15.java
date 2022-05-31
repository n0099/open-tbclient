package com.repackage;

import android.content.Context;
import com.baidu.tbadk.editortools.local.view.LocalInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i15 extends e05 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LocalInputContainer t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i15(Context context, z05 z05Var) {
        super(context, (String) null, 36);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, z05Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(context, z05Var);
        this.m = this.t;
        this.o = false;
        this.n = 3;
        this.p = new int[]{24, 3};
    }

    public final void g(Context context, z05 z05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, z05Var) == null) {
            LocalInputContainer localInputContainer = new LocalInputContainer(context);
            this.t = localInputContainer;
            localInputContainer.f(z05Var);
        }
    }
}
