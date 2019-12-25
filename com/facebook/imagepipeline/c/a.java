package com.facebook.imagepipeline.c;

import com.facebook.imagepipeline.c.h;
/* loaded from: classes11.dex */
public class a {
    public static h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> a(com.facebook.common.internal.j<q> jVar, com.facebook.common.memory.c cVar, h.a aVar) {
        h<com.facebook.cache.common.b, com.facebook.imagepipeline.g.c> hVar = new h<>(new v<com.facebook.imagepipeline.g.c>() { // from class: com.facebook.imagepipeline.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.v
            /* renamed from: e */
            public int bg(com.facebook.imagepipeline.g.c cVar2) {
                return cVar2.getSizeInBytes();
            }
        }, aVar, jVar);
        cVar.a(hVar);
        return hVar;
    }
}
