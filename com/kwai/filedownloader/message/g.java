package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public final List<a> f37828a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final e.b f37829b;

    /* loaded from: classes7.dex */
    public class a {

        /* renamed from: b  reason: collision with root package name */
        public final List<Integer> f37831b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public final Executor f37832c;

        public a(int i2) {
            this.f37832c = com.kwai.filedownloader.f.b.a(1, "Flow-" + i2);
        }

        public void a(int i2) {
            this.f37831b.add(Integer.valueOf(i2));
        }

        public void a(final MessageSnapshot messageSnapshot) {
            this.f37832c.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.f37829b.a(messageSnapshot);
                    try {
                        a.this.f37831b.remove(Integer.valueOf(messageSnapshot.m()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public g(int i2, e.b bVar) {
        this.f37829b = bVar;
        for (int i3 = 0; i3 < i2; i3++) {
            this.f37828a.add(new a(i3));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.f37828a) {
                int m = messageSnapshot.m();
                Iterator<a> it = this.f37828a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f37831b.contains(Integer.valueOf(m))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int i2 = 0;
                    Iterator<a> it2 = this.f37828a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.f37831b.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (i2 == 0 || next2.f37831b.size() < i2) {
                            i2 = next2.f37831b.size();
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
