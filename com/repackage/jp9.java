package com.repackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.win.opensdk.PBError;
/* loaded from: classes6.dex */
public class jp9 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ vl9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jp9(vl9 vl9Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vl9Var, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vl9Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        vl9 vl9Var;
        wl9 wl9Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message.what != 0 || (wl9Var = (vl9Var = this.a).c) == null || vl9Var.d) {
            return;
        }
        wl9Var.onFail(PBError.LOAD_TIME_OUT);
        this.a.e = true;
    }
}
