package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.List;
/* loaded from: classes10.dex */
public final class aa implements e.b {
    public static boolean a(List<a.InterfaceC0677a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.tL() == -3) {
            for (a.InterfaceC0677a interfaceC0677a : list) {
                if (interfaceC0677a.tU().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        for (a.InterfaceC0677a interfaceC0677a2 : list) {
            if (interfaceC0677a2.tU().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.tL()) {
            for (a.InterfaceC0677a interfaceC0677a3 : list) {
                if (interfaceC0677a3.tU().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() != 1) {
            return false;
        }
        return list.get(0).tU().a(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0677a> aV = h.ur().aV(messageSnapshot.getId());
            if (aV.size() > 0) {
                a tT = aV.get(0).tT();
                if (com.kwad.framework.filedownloader.f.d.ahW) {
                    com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(tT.tL()), Byte.valueOf(messageSnapshot.tL()), Integer.valueOf(aV.size()));
                }
                if (!a(aV, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.tL()) + " task-count:" + aV.size());
                    for (a.InterfaceC0677a interfaceC0677a : aV) {
                        sb.append(" | ");
                        sb.append((int) interfaceC0677a.tT().tL());
                    }
                    com.kwad.framework.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.tL()));
            }
        }
    }
}
