package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes7.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f38457a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f38458b;

    /* renamed from: c  reason: collision with root package name */
    public d f38459c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f38457a = jVar;
        if (aVar != null) {
            this.f38459c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f38460a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f38461b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f38461b == 0) {
                    this.f38461b = b.this.b();
                }
                this.f38460a += j;
                if (b.this.f38459c != null) {
                    b.this.f38459c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f38460a, this.f38461b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f38457a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f38458b == null) {
            this.f38458b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f38457a.a(this.f38458b);
        this.f38458b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f38457a.b();
    }
}
