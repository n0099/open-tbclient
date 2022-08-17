package com.repackage;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final af6 a;
    public final FrsFragment b;
    public final yr6 c;
    public final sr6 d;
    public final FrsModelController e;
    public final fg6 f;
    public final co6 g;

    public jo6(FrsFragment frsFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (frsFragment != null) {
            this.b = frsFragment;
            this.d = frsFragment.o0();
            this.a = this.b.k1();
            this.c = this.b.F3();
            this.e = this.b.K0();
            this.f = this.b.A3();
            this.g = this.b.a1();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
