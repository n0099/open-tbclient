package com.repackage;

import android.database.ContentObserver;
import android.os.Handler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jf1 extends ContentObserver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lf1 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jf1(lf1 lf1Var) {
        super(null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {lf1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Handler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = lf1Var;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        lf1 lf1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || (lf1Var = this.a) == null) {
            return;
        }
        lf1Var.b = lf1Var.a.a(0, null);
    }
}
