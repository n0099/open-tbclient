package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class i {
    final a pDr;
    private final com.facebook.common.references.c<byte[]> pti;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pDO > 0);
        this.pDr = new a(cVar, rVar, n.ezH());
        this.pti = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> QU(int i) {
        return com.facebook.common.references.a.a(this.pDr.get(i), this.pti);
    }

    public void release(byte[] bArr) {
        this.pDr.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> QP(int i) {
            return new o(QM(i), this.pCZ.pDO, 0);
        }
    }
}
