package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.u;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class c implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ b a;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message == null) {
                u.a("AidlManager", "handleMessage error : msg is null");
                return false;
            }
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    u.b("AidlManager", "unknow msg what [" + message.what + PreferencesUtil.RIGHT_MOUNT);
                } else {
                    atomicInteger2 = this.a.f;
                    if (atomicInteger2.get() == 4) {
                        this.a.f();
                    }
                    this.a.a(1);
                }
            } else {
                u.a("AidlManager", "In connect, bind core service time out");
                atomicInteger = this.a.f;
                if (atomicInteger.get() == 2) {
                    this.a.a(1);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
