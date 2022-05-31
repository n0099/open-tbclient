package com.repackage;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class qk6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final lb6 a;
    public final FrsFragment b;
    public final po6 c;
    public final jo6 d;
    public final FrsModelController e;
    public final qc6 f;
    public final jk6 g;

    public qk6(FrsFragment frsFragment) {
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
            this.d = frsFragment.N();
            this.a = this.b.y0();
            this.c = this.b.M2();
            this.e = this.b.c0();
            this.f = this.b.J2();
            this.g = this.b.p0();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
