package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.e;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.k;
import java.io.IOException;
/* loaded from: classes3.dex */
public class b extends j {
    private final j a;
    private com.meizu.cloud.pushsdk.b.g.b b;
    private d c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.c = new d(aVar);
        }
    }

    private k a(k kVar) {
        return new e(kVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1
            long a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.e, com.meizu.cloud.pushsdk.b.g.k
            public void a(com.meizu.cloud.pushsdk.b.g.a aVar, long j) throws IOException {
                super.a(aVar, j);
                if (this.b == 0) {
                    this.b = b.this.b();
                }
                this.a += j;
                if (b.this.c != null) {
                    b.this.c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.b bVar) throws IOException {
        if (this.b == null) {
            this.b = f.a(a((k) bVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.a.b();
    }
}
