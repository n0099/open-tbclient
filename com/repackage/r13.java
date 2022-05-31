package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.lz2;
/* loaded from: classes6.dex */
public abstract class r13 extends pz2 implements ae3<lz2.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r13(kz2 kz2Var) {
        super(kz2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kz2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = false;
    }

    public static void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            sv2 P = tv2.P("swan_kill_to_client");
            P.J(str);
            P.call();
        }
    }

    public static void K(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                r13 B = gz2.J().B();
                B.b = i;
                B.H(str);
                return;
            }
            sv2 w = tv2.P("swan_forbidden_kill_on_server").z("mAppId", str).w("ipc_forbidden_flag", i);
            w.K(true);
            w.call();
        }
    }

    public abstract void H(String str);

    public void I() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.c) {
            return;
        }
        ez2 ez2Var = new ez2();
        ez2Var.e(this, "event_messenger_call");
        v(ez2Var);
        this.c = true;
    }
}
