package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f37448a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final e.b f37449b;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final List<Integer> f37451b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final Executor f37452c;

        public a(int i) {
            this.f37452c = com.kwai.filedownloader.f.b.a(1, "Flow-" + i);
        }

        public void a(int i) {
            this.f37451b.add(Integer.valueOf(i));
        }

        public void a(final MessageSnapshot messageSnapshot) {
            this.f37452c.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f37449b.a(messageSnapshot);
                    try {
                        a.this.f37451b.remove(Integer.valueOf(messageSnapshot.m()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i, e.b bVar) {
        this.f37449b = bVar;
        for (int i2 = 0; i2 < i; i2++) {
            this.f37448a.add(new a(i2));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f37448a) {
                int m = messageSnapshot.m();
                Iterator<a> it = this.f37448a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f37451b.contains(Integer.valueOf(m))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i = 0;
                    Iterator<a> it2 = this.f37448a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.f37451b.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i == 0 || next2.f37451b.size() < i) {
                            i = next2.f37451b.size();
                            aVar = next2;
                        }
                    }
                }
                aVar.a(m);
            }
        } finally {
            aVar.a(messageSnapshot);
        }
    }
}
