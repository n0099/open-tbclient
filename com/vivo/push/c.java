package com.vivo.push;

import android.os.Handler;
import android.os.Message;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes10.dex */
public final class c implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f76159a;

    public c(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f76159a = bVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        InterceptResult invokeL;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
            if (message == null) {
                com.vivo.push.util.p.a("AidlManager", "handleMessage error : msg is null");
                return false;
            }
            int i2 = message.what;
            if (i2 == 1) {
                com.vivo.push.util.p.a("AidlManager", "In connect, bind core service time out");
                atomicInteger = this.f76159a.f76111f;
                if (atomicInteger.get() == 2) {
                    this.f76159a.a(1);
                }
            } else if (i2 == 2) {
                atomicInteger2 = this.f76159a.f76111f;
                if (atomicInteger2.get() == 4) {
                    this.f76159a.e();
                }
                this.f76159a.a(1);
            } else {
                com.vivo.push.util.p.b("AidlManager", "unknow msg what [" + message.what + PreferencesUtil.RIGHT_MOUNT);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
