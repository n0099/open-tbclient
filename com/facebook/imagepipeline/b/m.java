package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes5.dex */
public class m {
    public static o<com.facebook.cache.common.b, PooledByteBuffer> a(h<com.facebook.cache.common.b, PooledByteBuffer> hVar, final n nVar) {
        nVar.b(hVar);
        return new o<>(hVar, new r<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.b.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.r
            /* renamed from: i */
            public void br(com.facebook.cache.common.b bVar) {
                n.this.q(bVar);
            }

            @Override // com.facebook.imagepipeline.b.r
            public void evN() {
                n.this.ewc();
            }

            @Override // com.facebook.imagepipeline.b.r
            public void evO() {
                n.this.ewb();
            }
        });
    }
}
