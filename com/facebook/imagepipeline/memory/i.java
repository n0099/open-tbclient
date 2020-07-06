package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class i {
    private final com.facebook.common.references.c<byte[]> mIT;
    final a mVk;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.mVH > 0);
        this.mVk = new a(cVar, rVar, n.dFG());
        this.mIT = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            /* renamed from: am */
            public void release(byte[] bArr) {
                i.this.am(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> ID(int i) {
        return com.facebook.common.references.a.a(this.mVk.get(i), this.mIT);
    }

    public void am(byte[] bArr) {
        this.mVk.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> IX(int i) {
            return new o(IU(i), this.mUS.mVH, 0);
        }
    }
}
