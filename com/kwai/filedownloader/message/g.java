package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f35170a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final e.b f35171b;

    /* loaded from: classes6.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final List<Integer> f35173b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final Executor f35174c;

        public a(int i2) {
            this.f35174c = com.kwai.filedownloader.f.b.a(1, "Flow-" + i2);
        }

        public void a(int i2) {
            this.f35173b.add(Integer.valueOf(i2));
        }

        public void a(final MessageSnapshot messageSnapshot) {
            this.f35174c.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f35171b.a(messageSnapshot);
                    try {
                        a.this.f35173b.remove(Integer.valueOf(messageSnapshot.m()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i2, e.b bVar) {
        this.f35171b = bVar;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f35170a.add(new a(i3));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f35170a) {
                int m = messageSnapshot.m();
                Iterator<a> it = this.f35170a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f35173b.contains(Integer.valueOf(m))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i2 = 0;
                    Iterator<a> it2 = this.f35170a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.f35173b.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i2 == 0 || next2.f35173b.size() < i2) {
                            i2 = next2.f35173b.size();
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
