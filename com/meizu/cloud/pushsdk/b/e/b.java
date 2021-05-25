package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f34680a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f34681b;

    /* renamed from: c  reason: collision with root package name */
    public d f34682c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f34680a = jVar;
        if (aVar != null) {
            this.f34682c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f34683a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f34684b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f34684b == 0) {
                    this.f34684b = b.this.b();
                }
                this.f34683a += j;
                if (b.this.f34682c != null) {
                    b.this.f34682c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f34683a, this.f34684b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f34680a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f34681b == null) {
            this.f34681b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f34680a.a(this.f34681b);
        this.f34681b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f34680a.b();
    }
}
