package com.repackage;

import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qm6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final id6 a;
    public final FrsFragment b;
    public final gq6 c;
    public final aq6 d;
    public final FrsModelController e;
    public final ne6 f;
    public final jm6 g;

    public qm6(FrsFragment frsFragment) {
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
            this.d = frsFragment.p0();
            this.a = this.b.l1();
            this.c = this.b.D3();
            this.e = this.b.L0();
            this.f = this.b.A3();
            this.g = this.b.b1();
            return;
        }
        throw new NullPointerException("FrsActivity is NullPointerException");
    }
}
