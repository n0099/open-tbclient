package com.win.opensdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class F0 extends Handler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ O0 f77146a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public F0(O0 o0, Looper looper) {
        super(looper);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {o0, looper};
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
        this.f77146a = o0;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
            super.handleMessage(message);
            if (message.what != 1101) {
                return;
            }
            this.f77146a.f77183e.removeMessages(1101);
            O0 o0 = this.f77146a;
            if (!o0.f77180b && o0.a(o0.f77179a)) {
                N0 n0 = this.f77146a.f77181c;
                if (n0 != null) {
                    n0.a();
                }
                this.f77146a.f77180b = true;
                return;
            }
            this.f77146a.f77183e.sendEmptyMessageDelayed(1101, 300L);
        }
    }
}
