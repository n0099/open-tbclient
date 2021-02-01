package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class i {
    final a pKG;
    private final com.facebook.common.references.c<byte[]> pyZ;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pLd > 0);
        this.pKG = new a(cVar, rVar, n.eyL());
        this.pyZ = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> PA(int i) {
        return com.facebook.common.references.a.a(this.pKG.get(i), this.pyZ);
    }

    public void release(byte[] bArr) {
        this.pKG.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> PU(int i) {
            return new o(PR(i), this.pKo.pLd, 0);
        }
    }
}
