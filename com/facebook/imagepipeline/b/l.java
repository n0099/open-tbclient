package com.facebook.imagepipeline.b;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes5.dex */
public class l {
    public static h<com.facebook.cache.common.b, PooledByteBuffer> a(com.facebook.common.internal.j<q> jVar, com.facebook.common.memory.c cVar) {
        h<com.facebook.cache.common.b, PooledByteBuffer> hVar = new h<>(new v<PooledByteBuffer>() { // from class: com.facebook.imagepipeline.b.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: a */
            public int bs(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, new s(), jVar);
        cVar.a(hVar);
        return hVar;
    }
}
