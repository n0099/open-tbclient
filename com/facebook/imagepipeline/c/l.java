package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes4.dex */
public class l {
    public static h<com.facebook.cache.common.b, PooledByteBuffer> a(com.facebook.common.internal.j<q> jVar, com.facebook.common.memory.c cVar) {
        h<com.facebook.cache.common.b, PooledByteBuffer> hVar = new h<>(new v<PooledByteBuffer>() { // from class: com.facebook.imagepipeline.c.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: a */
            public int bf(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, new s(), jVar);
        cVar.a(hVar);
        return hVar;
    }
}
