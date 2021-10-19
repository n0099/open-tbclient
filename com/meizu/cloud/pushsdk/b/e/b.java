package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes10.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f74999a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f75000b;

    /* renamed from: c  reason: collision with root package name */
    public d f75001c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f74999a = jVar;
        if (aVar != null) {
            this.f75001c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f75002a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f75003b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j2) throws IOException {
                super.a(bVar, j2);
                if (this.f75003b == 0) {
                    this.f75003b = b.this.b();
                }
                this.f75002a += j2;
                if (b.this.f75001c != null) {
                    b.this.f75001c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f75002a, this.f75003b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f74999a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f75000b == null) {
            this.f75000b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f74999a.a(this.f75000b);
        this.f75000b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f74999a.b();
    }
}
