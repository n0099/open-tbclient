package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes2.dex */
public class n {
    public static t<com.facebook.cache.common.b, PooledByteBuffer> a(h<com.facebook.cache.common.b, PooledByteBuffer> hVar, final o oVar) {
        oVar.b(hVar);
        return new p(hVar, new v<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: h */
            public void aE(com.facebook.cache.common.b bVar) {
                o.this.o(bVar);
            }

            @Override // com.facebook.imagepipeline.c.v
            public void bXc() {
                o.this.bXs();
            }

            @Override // com.facebook.imagepipeline.c.v
            public void bXd() {
                o.this.bXr();
            }
        });
    }
}
