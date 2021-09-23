package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class h1 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m1 f77360a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(m1 m1Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m1Var, looper};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Looper) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f77360a = m1Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            int i2 = message.what;
            m1.c();
            if (i2 == 100101) {
                this.f77360a.f77425j.removeMessages(100101);
                Y0 a2 = Z0.a(this.f77360a.f77416a);
                a1 a1Var = new a1(null);
                a1Var.f77266a = this.f77360a.f77417b;
                a2.a(a1Var, U1.r(this.f77360a.f77416a) * 1000, 2002, 0).a();
                this.f77360a.a(PBError.TIMEOUT);
            }
        }
    }
}
