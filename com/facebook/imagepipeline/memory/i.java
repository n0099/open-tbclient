package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class i {
    final a pEY;
    private final com.facebook.common.references.c<byte[]> ptp;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pFv > 0);
        this.pEY = new a(cVar, rVar, n.eAl());
        this.ptp = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> QM(int i) {
        return com.facebook.common.references.a.a(this.pEY.get(i), this.ptp);
    }

    public void release(byte[] bArr) {
        this.pEY.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Rg(int i) {
            return new o(Rd(i), this.pEG.pFv, 0);
        }
    }
}
