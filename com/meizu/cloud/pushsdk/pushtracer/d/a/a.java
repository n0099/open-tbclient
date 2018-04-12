package com.meizu.cloud.pushsdk.pushtracer.d.a;

import com.meizu.cloud.pushsdk.pushtracer.d.c;
import com.meizu.cloud.pushsdk.pushtracer.emitter.a.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes3.dex */
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
            com.meizu.cloud.pushsdk.pushtracer.utils.b.b(n, "Session checking has been resumed.", new Object[0]);
            final com.meizu.cloud.pushsdk.pushtracer.d.a aVar = this.d;
            o = Executors.newSingleThreadScheduledExecutor();
            o.scheduleAtFixedRate(new Runnable() { // from class: com.meizu.cloud.pushsdk.pushtracer.d.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aVar.b();
                }
            }, this.j, this.j, this.l);
        }
    }

    @Override // com.meizu.cloud.pushsdk.pushtracer.d.c
    public void a(final com.meizu.cloud.pushsdk.pushtracer.b.b bVar) {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.pushtracer.d.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.super.a(bVar);
            }
        });
    }
}
