package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes6.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f37571a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f37572b;

    /* renamed from: c  reason: collision with root package name */
    public d f37573c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f37571a = jVar;
        if (aVar != null) {
            this.f37573c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f37574a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f37575b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f37575b == 0) {
                    this.f37575b = b.this.b();
                }
                this.f37574a += j;
                if (b.this.f37573c != null) {
                    b.this.f37573c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f37574a, this.f37575b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f37571a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f37572b == null) {
            this.f37572b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f37571a.a(this.f37572b);
        this.f37572b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f37571a.b();
    }
}
