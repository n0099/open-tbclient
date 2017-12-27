package com.meizu.cloud.pushsdk.a.f;

import com.meizu.cloud.pushsdk.a.d.g;
import com.meizu.cloud.pushsdk.a.d.j;
import com.meizu.cloud.pushsdk.a.e.o;
import com.meizu.cloud.pushsdk.a.h.k;
import java.io.IOException;
/* loaded from: classes2.dex */
public class d extends j {
    private final j a;
    private com.meizu.cloud.pushsdk.a.h.b b;
    private f c;

    public d(j jVar, o oVar) {
        this.a = jVar;
        if (oVar != null) {
            this.c = new f(oVar);
        }
    }

    @Override // com.meizu.cloud.pushsdk.a.d.j
    public g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.a.d.j
    public long b() throws IOException {
        return this.a.b();
    }

    @Override // com.meizu.cloud.pushsdk.a.d.j
    public void a(com.meizu.cloud.pushsdk.a.h.b bVar) throws IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.a.h.f.a(a((k) bVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    private k a(k kVar) {
        return new com.meizu.cloud.pushsdk.a.h.e(kVar) { // from class: com.meizu.cloud.pushsdk.a.f.d.1
            long a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.a.h.e, com.meizu.cloud.pushsdk.a.h.k
            public void a(com.meizu.cloud.pushsdk.a.h.a aVar, long j) throws IOException {
                super.a(aVar, j);
                if (this.b == 0) {
                    this.b = d.this.b();
                }
                this.a += j;
                if (d.this.c != null) {
                    d.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.a.g.a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }
}
