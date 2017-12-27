package com.meizu.cloud.pushsdk.b.e.a;

import com.meizu.cloud.pushsdk.b.b.a.b;
import com.meizu.cloud.pushsdk.b.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes2.dex */
public class a extends c {
    private static final String n = a.class.getSimpleName();
    private static ScheduledExecutorService o;

    public a(c.a aVar) {
        super(aVar);
        b.a(this.k);
        c();
    }

    public void c() {
        if (o == null && this.i) {
            com.meizu.cloud.pushsdk.b.f.c.b(n, "Session checking has been resumed.", new Object[0]);
            final com.meizu.cloud.pushsdk.b.e.a aVar = this.d;
            o = Executors.newSingleThreadScheduledExecutor();
            o.scheduleAtFixedRate(new Runnable() { // from class: com.meizu.cloud.pushsdk.b.e.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.b();
                }
            }, this.j, this.j, this.l);
        }
    }

    @Override // com.meizu.cloud.pushsdk.b.e.c
    public void a(final com.meizu.cloud.pushsdk.b.c.b bVar) {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.b.e.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.super.a(bVar);
            }
        });
    }
}
