package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes8.dex */
public class b extends j {
    public final j a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f57157b;

    /* renamed from: c  reason: collision with root package name */
    public d f57158c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.f57158c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1
            public long a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f57159b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j2) throws IOException {
                super.a(bVar, j2);
                if (this.f57159b == 0) {
                    this.f57159b = b.this.b();
                }
                this.a += j2;
                if (b.this.f57158c != null) {
                    b.this.f57158c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.a, this.f57159b)).sendToTarget();
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
        if (this.f57157b == null) {
            this.f57157b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.a.a(this.f57157b);
        this.f57157b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.a.b();
    }
}
