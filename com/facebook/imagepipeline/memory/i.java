package com.facebook.imagepipeline.memory;

import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class i {
    final a pAx;
    private final com.facebook.common.references.c<byte[]> poN;

    public i(com.facebook.common.memory.c cVar, r rVar) {
        com.facebook.common.internal.g.checkArgument(rVar.pAU > 0);
        this.pAx = new a(cVar, rVar, n.ewt());
        this.poN = new com.facebook.common.references.c<byte[]>() { // from class: com.facebook.imagepipeline.memory.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.facebook.common.references.c
            public void release(byte[] bArr) {
                i.this.release(bArr);
            }
        };
    }

    public com.facebook.common.references.a<byte[]> Pf(int i) {
        return com.facebook.common.references.a.a(this.pAx.get(i), this.poN);
    }

    public void release(byte[] bArr) {
        this.pAx.release(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends j {
        public a(com.facebook.common.memory.c cVar, r rVar, s sVar) {
            super(cVar, rVar, sVar);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        d<byte[]> Pz(int i) {
            return new o(Pw(i), this.pAf.pAU, 0);
        }
    }
}
