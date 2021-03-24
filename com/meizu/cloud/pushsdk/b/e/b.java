package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f37570a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f37571b;

    /* renamed from: c  reason: collision with root package name */
    public d f37572c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f37570a = jVar;
        if (aVar != null) {
            this.f37572c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f37573a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f37574b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f37574b == 0) {
                    this.f37574b = b.this.b();
                }
                this.f37573a += j;
                if (b.this.f37572c != null) {
                    b.this.f37572c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f37573a, this.f37574b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f37570a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f37571b == null) {
            this.f37571b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f37570a.a(this.f37571b);
        this.f37571b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f37570a.b();
    }
}
