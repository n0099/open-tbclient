package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j0 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m0 f42599a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(m0 m0Var, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m0Var, looper};
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
        this.f42599a = m0Var;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1101) {
                return;
            }
            this.f42599a.f42609e.removeMessages(1101);
            m0 m0Var = this.f42599a;
            if (!m0Var.f42606b && m0Var.a(m0Var.f42605a)) {
                l0 l0Var = this.f42599a.f42607c;
                if (l0Var != null) {
                    l0Var.a();
                }
                this.f42599a.f42606b = true;
                return;
            }
            this.f42599a.f42609e.sendEmptyMessageDelayed(1101, 300L);
        }
    }
}
