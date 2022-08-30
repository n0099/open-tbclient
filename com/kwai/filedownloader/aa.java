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
/* loaded from: classes7.dex */
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

    public static boolean a(List<a.InterfaceC0620a> list, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, messageSnapshot)) == null) {
            if (list.size() > 1 && messageSnapshot.Ca() == -3) {
                for (a.InterfaceC0620a interfaceC0620a : list) {
                    if (interfaceC0620a.Cj().c(messageSnapshot)) {
                        return true;
                    }
                }
            }
            for (a.InterfaceC0620a interfaceC0620a2 : list) {
                if (interfaceC0620a2.Cj().b(messageSnapshot)) {
                    return true;
                }
            }
            if (-4 == messageSnapshot.Ca()) {
                for (a.InterfaceC0620a interfaceC0620a3 : list) {
                    if (interfaceC0620a3.Cj().d(messageSnapshot)) {
                        return true;
                    }
                }
            }
            if (list.size() == 1) {
                return list.get(0).Cj().a(messageSnapshot);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.kwai.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
                List<a.InterfaceC0620a> bT = h.CG().bT(messageSnapshot.getId());
                if (bT.size() > 0) {
                    a Ci = bT.get(0).Ci();
                    if (com.kwai.filedownloader.e.d.awL) {
                        com.kwai.filedownloader.e.d.e(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(Ci.Ca()), Byte.valueOf(messageSnapshot.Ca()), Integer.valueOf(bT.size()));
                    }
                    if (!a(bT, messageSnapshot)) {
                        StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.Ca()) + " task-count:" + bT.size());
                        for (a.InterfaceC0620a interfaceC0620a : bT) {
                            sb.append(" | ");
                            sb.append((int) interfaceC0620a.Ci().Ca());
                        }
                        com.kwai.filedownloader.e.d.d(this, sb.toString(), new Object[0]);
                    }
                } else {
                    com.kwai.filedownloader.e.d.d(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.Ca()));
                }
            }
        }
    }
}
