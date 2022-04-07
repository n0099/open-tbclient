package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes5.dex */
public class b extends j {
    public final j a;
    public com.meizu.cloud.pushsdk.b.g.c b;
    public d c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1
            public long a = 0;
            public long b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
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
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.a.b();
    }
}
