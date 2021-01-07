package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f11258a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final e.b f11259b;

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        private final List<Integer> f11261b = new ArrayList();
        private final Executor c;

        public a(int i) {
            this.c = com.kwai.filedownloader.f.b.a(1, "Flow-" + i);
        }

        public void a(int i) {
            this.f11261b.add(Integer.valueOf(i));
        }

        public void a(final MessageSnapshot messageSnapshot) {
            this.c.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f11259b.a(messageSnapshot);
                    try {
                        a.this.f11261b.remove(Integer.valueOf(messageSnapshot.m()));
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(int i, e.b bVar) {
        this.f11259b = bVar;
        for (int i2 = 0; i2 < i; i2++) {
            this.f11258a.add(new a(i2));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f11258a) {
                int m = messageSnapshot.m();
                Iterator<a> it = this.f11258a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f11261b.contains(Integer.valueOf(m))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i = 0;
                    Iterator<a> it2 = this.f11258a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.f11261b.size() <= 0) {
                            aVar = next2;
                            break;
                        }
                        if (i == 0 || next2.f11261b.size() < i) {
                            i = next2.f11261b.size();
                        } else {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                }
                aVar.a(m);
            }
        } finally {
            aVar.a(messageSnapshot);
        }
    }
}
