package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.util.List;
/* loaded from: classes7.dex */
public class z implements e.b {
    private boolean a(List<a.b> list, MessageSnapshot messageSnapshot) {
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

    @Override // com.kwai.filedownloader.message.e.b
    public void a(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.m()).intern()) {
            List<a.b> b2 = h.a().b(messageSnapshot.m());
            if (b2.size() > 0) {
                a F = b2.get(0).F();
                if (com.kwai.filedownloader.f.d.f37874a) {
                    com.kwai.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.m()), Byte.valueOf(F.v()), Byte.valueOf(messageSnapshot.b()), Integer.valueOf(b2.size()));
                }
                if (!a(b2, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.m() + " status:" + ((int) messageSnapshot.b()) + " task-count:" + b2.size());
                    for (a.b bVar : b2) {
                        sb.append(" | ");
                        sb.append((int) bVar.F().v());
                    }
                    com.kwai.filedownloader.f.d.b(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwai.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.b()));
            }
        }
    }
}
