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
/* loaded from: classes3.dex */
public class aa implements e.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public aa() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private boolean a(List<a.b> list, MessageSnapshot messageSnapshot) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, list, messageSnapshot)) == null) {
            if (list.size() > 1 && messageSnapshot.b() == -3) {
                for (a.b bVar : list) {
                    if (bVar.G().c(messageSnapshot)) {
                        return true;
                    }
                }
            }
            for (a.b bVar2 : list) {
                if (bVar2.G().b(messageSnapshot)) {
                    return true;
                }
            }
            if (-4 == messageSnapshot.b()) {
                for (a.b bVar3 : list) {
                    if (bVar3.G().d(messageSnapshot)) {
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
    public void a(MessageSnapshot messageSnapshot) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, messageSnapshot) == null) {
            synchronized (Integer.toString(messageSnapshot.m()).intern()) {
                List<a.b> b2 = h.a().b(messageSnapshot.m());
                if (b2.size() > 0) {
                    a F = b2.get(0).F();
                    if (com.kwai.filedownloader.e.d.a) {
                        com.kwai.filedownloader.e.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(F.v()), Byte.valueOf(messageSnapshot.b()), Integer.valueOf(b2.size()));
                    }
                    if (!a(b2, messageSnapshot)) {
                        StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.m() + " status:" + ((int) messageSnapshot.b()) + " task-count:" + b2.size());
                        for (a.b bVar : b2) {
                            sb.append(" | ");
                            sb.append((int) bVar.F().v());
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
