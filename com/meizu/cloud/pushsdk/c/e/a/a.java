package com.meizu.cloud.pushsdk.c.e.a;

import com.meizu.cloud.pushsdk.c.b.a.b;
import com.meizu.cloud.pushsdk.c.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes7.dex */
public class a extends c {
    public static final String n = "a";
    public static ScheduledExecutorService o;

    public a(c.a aVar) {
        super(aVar);
        b.a(this.k);
        c();
    }

    @Override // com.meizu.cloud.pushsdk.c.e.c
    public void a(final com.meizu.cloud.pushsdk.c.c.b bVar, final boolean z) {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.c.e.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.super.a(bVar, z);
            }
        });
    }

    public void c() {
        if (o == null && this.f40434i) {
            com.meizu.cloud.pushsdk.c.f.c.b(n, "Session checking has been resumed.", new Object[0]);
            final com.meizu.cloud.pushsdk.c.e.a aVar = this.f40429d;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            o = newSingleThreadScheduledExecutor;
            Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.c.e.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.b();
                }
            };
            long j = this.j;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(runnable, j, j, this.l);
        }
    }
}
