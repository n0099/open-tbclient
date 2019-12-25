package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes9.dex */
public class m {
    public static o<com.facebook.cache.common.b, PooledByteBuffer> a(h<com.facebook.cache.common.b, PooledByteBuffer> hVar, final n nVar) {
        nVar.b(hVar);
        return new o<>(hVar, new r<com.facebook.cache.common.b>() { // from class: com.facebook.imagepipeline.c.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.r
            /* renamed from: i */
            public void bh(com.facebook.cache.common.b bVar) {
                n.this.q(bVar);
            }

            @Override // com.facebook.imagepipeline.c.r
            public void dlv() {
                n.this.dlH();
            }

            @Override // com.facebook.imagepipeline.c.r
            public void dlw() {
                n.this.dlG();
            }
        });
    }
}
