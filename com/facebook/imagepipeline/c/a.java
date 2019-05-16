package com.facebook.imagepipeline.c;
/* loaded from: classes2.dex */
public class a {
    public static h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> a(com.facebook.common.internal.i<u> iVar, com.facebook.common.memory.c cVar, com.facebook.imagepipeline.b.f fVar, boolean z) {
        h<com.facebook.cache.common.b, com.facebook.imagepipeline.f.b> hVar = new h<>(new ac<com.facebook.imagepipeline.f.b>() { // from class: com.facebook.imagepipeline.c.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.imagepipeline.c.ac
            /* renamed from: e */
            public int aR(com.facebook.imagepipeline.f.b bVar) {
                return bVar.getSizeInBytes();
            }
        }, new d(), iVar, fVar, z);
        cVar.a(hVar);
        return hVar;
    }
}
