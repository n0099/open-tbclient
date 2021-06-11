package com.meizu.cloud.pushsdk.b.e;

import com.meizu.cloud.pushsdk.b.c.g;
import com.meizu.cloud.pushsdk.b.c.j;
import com.meizu.cloud.pushsdk.b.g.f;
import com.meizu.cloud.pushsdk.b.g.l;
import java.io.IOException;
/* loaded from: classes7.dex */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    public final j f38359a;

    /* renamed from: b  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.b.g.c f38360b;

    /* renamed from: c  reason: collision with root package name */
    public d f38361c;

    public b(j jVar, com.meizu.cloud.pushsdk.b.d.a aVar) {
        this.f38359a = jVar;
        if (aVar != null) {
            this.f38361c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.b.e.b.1

            /* renamed from: a  reason: collision with root package name */
            public long f38362a = 0;

            /* renamed from: b  reason: collision with root package name */
            public long f38363b = 0;

            @Override // com.meizu.cloud.pushsdk.b.g.f, com.meizu.cloud.pushsdk.b.g.l
            public void a(com.meizu.cloud.pushsdk.b.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.f38363b == 0) {
                    this.f38363b = b.this.b();
                }
                this.f38362a += j;
                if (b.this.f38361c != null) {
                    b.this.f38361c.obtainMessage(1, new com.meizu.cloud.pushsdk.b.f.a(this.f38362a, this.f38363b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public g a() {
        return this.f38359a.a();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public void a(com.meizu.cloud.pushsdk.b.g.c cVar) throws IOException {
        if (this.f38360b == null) {
            this.f38360b = com.meizu.cloud.pushsdk.b.g.g.a(a((l) cVar));
        }
        this.f38359a.a(this.f38360b);
        this.f38360b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.b.c.j
    public long b() throws IOException {
        return this.f38359a.b();
    }
}
