package com.meizu.cloud.pushsdk.networking.d;

import com.meizu.cloud.pushsdk.networking.b.g;
import com.meizu.cloud.pushsdk.networking.b.j;
import com.meizu.cloud.pushsdk.networking.c.o;
import com.meizu.cloud.pushsdk.networking.model.Progress;
import com.meizu.cloud.pushsdk.networking.okio.k;
import java.io.IOException;
/* loaded from: classes3.dex */
public class d extends j {
    private final j a;
    private com.meizu.cloud.pushsdk.networking.okio.c b;
    private f c;

    public d(j jVar, o oVar) {
        this.a = jVar;
        if (oVar != null) {
            this.c = new f(oVar);
        }
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public long b() throws IOException {
        return this.a.b();
    }

    @Override // com.meizu.cloud.pushsdk.networking.b.j
    public void a(com.meizu.cloud.pushsdk.networking.okio.c cVar) throws IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.networking.okio.f.a(a((k) cVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    private k a(k kVar) {
        return new com.meizu.cloud.pushsdk.networking.okio.e(kVar) { // from class: com.meizu.cloud.pushsdk.networking.d.d.1
            long a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.networking.okio.e, com.meizu.cloud.pushsdk.networking.okio.k
            public void a(com.meizu.cloud.pushsdk.networking.okio.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.b == 0) {
                    this.b = d.this.b();
                }
                this.a += j;
                if (d.this.c != null) {
                    d.this.c.obtainMessage(1, new Progress(this.a, this.b)).sendToTarget();
                }
            }
        };
    }
}
