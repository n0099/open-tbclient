package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f35506a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f35507b;

    /* renamed from: c  reason: collision with root package name */
    public d f35508c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f35506a = jVar;
        if (aVar != null) {
            this.f35508c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f35509a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f35510b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f35510b == 0) {
                    this.f35510b = b.this.b();
                }
                this.f35509a += j;
                if (b.this.f35508c != null) {
                    b.this.f35508c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f35509a, this.f35510b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f35506a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f35507b == null) {
            this.f35507b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f35506a.a(this.f35507b);
        this.f35507b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f35506a.b();
    }
}
