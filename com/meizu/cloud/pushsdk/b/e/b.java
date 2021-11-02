package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes2.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f67363a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f67364b;

    /* renamed from: c  reason: collision with root package name */
    public d f67365c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f67363a = jVar;
        if (aVar != null) {
            this.f67365c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f67366a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f67367b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f67367b == 0) {
                    this.f67367b = b.this.b();
                }
                this.f67366a += j;
                if (b.this.f67365c != null) {
                    b.this.f67365c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f67366a, this.f67367b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f67363a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f67364b == null) {
            this.f67364b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f67363a.a(this.f67364b);
        this.f67364b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f67363a.b();
    }
}
