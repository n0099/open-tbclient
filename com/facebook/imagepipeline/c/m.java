package com.facebook.imagepipeline.c;

import com.facebook.common.memory.PooledByteBuffer;
/* loaded from: classes2.dex */
public class m {
    public static h<com.facebook.cache.common.b, PooledByteBuffer> a(com.facebook.common.internal.i<u> iVar, com.facebook.common.memory.c cVar, com.facebook.imagepipeline.b.f fVar) {
        h<com.facebook.cache.common.b, PooledByteBuffer> hVar = new h<>(new ac<PooledByteBuffer>() { // from class: com.facebook.imagepipeline.c.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.ac
            /* renamed from: a */
            public int aD(PooledByteBuffer pooledByteBuffer) {
                return pooledByteBuffer.size();
            }
        }, new w(), iVar, fVar, false);
        cVar.a(hVar);
        return hVar;
    }
}
