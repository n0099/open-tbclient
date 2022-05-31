package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg2;
/* loaded from: classes5.dex */
public final class bg2 extends cd2<dg2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final dg2.f h;

    /* loaded from: classes5.dex */
    public class a implements dg2.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bg2 a;

        public a(bg2 bg2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bg2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bg2Var;
        }

        @Override // com.repackage.dg2.f
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.onCallback(this.a, "onConfirmBtnClick", null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg2(@NonNull dg2 dg2Var) {
        super(dg2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ed2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a aVar = new a(this);
        this.h = aVar;
        dg2Var.E0(aVar);
        this.a.a(new hg2());
        this.a.a(new gg2());
        this.a.a(new ig2());
        this.a.a(new eg2());
        this.a.a(new fg2());
    }
}
