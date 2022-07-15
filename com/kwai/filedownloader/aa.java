package com.kwai.filedownloader;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.util.List;
/* loaded from: classes5.dex */
public final class aa implements e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean a(List<a.InterfaceC0555a> list, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, messageSnapshot)) == null) {
            if (list.size() > 1 && messageSnapshot.b() == -3) {
                for (a.InterfaceC0555a interfaceC0555a : list) {
                    if (interfaceC0555a.G().c(messageSnapshot)) {
                        return true;
                    }
                }
            }
            for (a.InterfaceC0555a interfaceC0555a2 : list) {
                if (interfaceC0555a2.G().b(messageSnapshot)) {
                    return true;
                }
            }
            if (-4 == messageSnapshot.b()) {
                for (a.InterfaceC0555a interfaceC0555a3 : list) {
                    if (interfaceC0555a3.G().d(messageSnapshot)) {
                        return true;
                    }
                }
            }
            if (list.size() == 1) {
                return list.get(0).G().a(messageSnapshot);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.message.e.b
    public final void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            synchronized (Integer.toString(messageSnapshot.m()).intern()) {
                List<a.InterfaceC0555a> b = h.a().b(messageSnapshot.m());
                if (b.size() > 0) {
                    a F = b.get(0).F();
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(F.v()), Byte.valueOf(messageSnapshot.b()), Integer.valueOf(b.size()));
                    }
                    if (!a(b, messageSnapshot)) {
                        StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.m() + " status:" + ((int) messageSnapshot.b()) + " task-count:" + b.size());
                        for (a.InterfaceC0555a interfaceC0555a : b) {
                            sb.append(" | ");
                            sb.append((int) interfaceC0555a.F().v());
                        }
                        com.kwai.filedownloader.e.d.b(this, sb.toString(), new Object[0]);
                    }
                } else {
                    com.kwai.filedownloader.e.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.b()));
                }
            }
        }
    }
}
