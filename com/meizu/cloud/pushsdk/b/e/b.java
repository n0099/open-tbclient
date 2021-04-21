package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f37955a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f37956b;

    /* renamed from: c  reason: collision with root package name */
    public d f37957c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f37955a = jVar;
        if (aVar != null) {
            this.f37957c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f37958a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f37959b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f37959b == 0) {
                    this.f37959b = b.this.b();
                }
                this.f37958a += j;
                if (b.this.f37957c != null) {
                    b.this.f37957c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f37958a, this.f37959b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f37955a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f37956b == null) {
            this.f37956b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f37955a.a(this.f37956b);
        this.f37956b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f37955a.b();
    }
}
