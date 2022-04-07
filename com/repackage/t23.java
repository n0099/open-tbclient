package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.n03;
/* loaded from: classes7.dex */
public abstract class t23 extends r03 implements cf3<n03.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int b;
    public boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t23(m03 m03Var) {
        super(m03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((m03) newInitContext.callArgs[0]);
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
            uw2 P = vw2.P("swan_kill_to_client");
            P.J(str);
            P.call();
        }
    }

    public static void K(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, str, i) == null) {
            if (SwanAppProcessInfo.SERVICE.equals(SwanAppProcessInfo.current())) {
                t23 B = i03.J().B();
                B.b = i;
                B.H(str);
                return;
            }
            uw2 w = vw2.P("swan_forbidden_kill_on_server").z("mAppId", str).w("ipc_forbidden_flag", i);
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
        g03 g03Var = new g03();
        g03Var.e(this, "event_messenger_call");
        v(g03Var);
        this.c = true;
    }
}
