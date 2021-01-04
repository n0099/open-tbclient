package com.facebook.imagepipeline.b;

import com.facebook.imagepipeline.b.h;
/* loaded from: classes6.dex */
public class a {
    public static h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> a(com.facebook.common.internal.j<q> jVar, com.facebook.common.memory.c cVar, h.a aVar) {
        h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.c> hVar = new h<>(new v<com.facebook.imagepipeline.f.c>() { // from class: com.facebook.imagepipeline.b.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.b.v
            /* renamed from: d */
            public int bq(com.facebook.imagepipeline.f.c cVar2) {
                return cVar2.getSizeInBytes();
            }
        }, aVar, jVar);
        cVar.a(hVar);
        return hVar;
    }
}
