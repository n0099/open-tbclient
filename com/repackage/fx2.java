package com.repackage;

import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.zw2;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes6.dex */
public class fx2 implements zw2.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Deque<Message> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755692527, "Lcom/repackage/fx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755692527, "Lcom/repackage/fx2;");
                return;
            }
        }
        boolean z = tg1.a;
    }

    public fx2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayDeque();
    }

    @Override // com.repackage.zw2.c
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ex2 P = ex2.P();
            while (P.N() && !this.a.isEmpty()) {
                Message peek = this.a.peek();
                if (peek == null || e(peek)) {
                    this.a.poll();
                }
            }
        }
    }

    @Override // com.repackage.zw2.c
    public void b(@NonNull bx2 bx2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bx2Var) == null) {
            Message h = bx2Var.h();
            h.arg1 = SwanAppProcessInfo.current().index;
            if (i03.J().D()) {
                Object obj = h.obj;
                if (obj instanceof Bundle) {
                    Bundle bundle = (Bundle) obj;
                    if (!bundle.containsKey("ai_apps_id")) {
                        bundle.putString("ai_apps_id", i03.J().getAppId());
                    }
                }
            }
            if (e(h) || !bx2Var.n()) {
                return;
            }
            this.a.offer(h);
            ex2.P().b0();
        }
    }

    @Override // com.repackage.zw2.c
    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.repackage.zw2.c
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final boolean e(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, message)) == null) {
            ex2 P = ex2.P();
            if (message == null || !P.N()) {
                return false;
            }
            try {
                P.R().send(message);
                return true;
            } catch (RemoteException e) {
                P.T();
                jx1.l("SwanMsgSenderOfClient", " sendMsgToService msg = " + message.toString(), e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
