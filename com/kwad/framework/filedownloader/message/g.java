package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes10.dex */
public final class g {
    public final e.b ahe;
    public final List<a> ahg = new ArrayList();

    /* loaded from: classes10.dex */
    public class a {
        public final List<Integer> ahh = new ArrayList();
        public final Executor ahi;

        public a(int i) {
            this.ahi = com.kwad.framework.filedownloader.f.b.o(1, "Flow-" + i);
        }

        public final void bw(int i) {
            this.ahh.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.ahi.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.ahe.r(messageSnapshot);
                    try {
                        a.this.ahh.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i, e.b bVar) {
        this.ahe = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.ahg.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.ahg) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.ahg.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.ahh.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i = 0;
                    Iterator<a> it2 = this.ahg.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.ahh.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i == 0 || next2.ahh.size() < i) {
                            i = next2.ahh.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.bw(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
